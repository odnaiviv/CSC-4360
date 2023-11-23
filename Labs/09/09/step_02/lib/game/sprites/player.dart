// Copyright 2022 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'dart:async';

import 'package:flame/collisions.dart';
import 'package:flame/components.dart';
import 'package:flutter/services.dart';

import '../doodle_dash.dart';
// Core gameplay: Import sprites.dart
// 6 
import 'sprites.dart';

enum PlayerState {
  left,
  right,
  center,
  rocket,
  nooglerCenter,
  nooglerLeft,
  nooglerRight
}

class Player extends SpriteGroupComponent<PlayerState>
    with HasGameRef<DoodleDash>, KeyboardHandler, CollisionCallbacks {
  Player({
    super.position,
    required this.character,
    this.jumpSpeed = 600,
  }) : super(
          size: Vector2(79, 109),
          anchor: Anchor.center,
          priority: 1,
        );

  int _hAxisInput = 0;
  final int movingLeftInput = -1;
  final int movingRightInput = 1;
  Vector2 _velocity = Vector2.zero();
  bool get isMovingDown => _velocity.y > 0;
  Character character;
  double jumpSpeed;
  // 6 
  final double _gravity = 9;
  // Core gameplay: Add _gravity property

  @override
  Future<void> onLoad() async {
    await super.onLoad();

    // 4 
    await _loadCharacterSprites();
    current = PlayerState.center;

    // 6 
    await add(CircleHitbox());

    // Core gameplay: Add circle hitbox to Dash

    // Add a Player to the game: loadCharacterSprites
    // Add a Player to the game: Default Dash onLoad to center state
  }

  @override
  void update(double dt) {

    // 4 
    if (gameRef.gameManager.isIntro || gameRef.gameManager.isGameOver) return;
    _velocity.x = _hAxisInput * jumpSpeed;

    // Add a Player to the game: Add game state check

    // Add a Player to the game: Add calcualtion for Dash's horizontal velocity

    final double dashHorizontalCenter = size.x / 2;

    // 4 
    if (position.x < dashHorizontalCenter) {
      position.x = gameRef.size.x - (dashHorizontalCenter);
    }
    if (position.x > gameRef.size.x - (dashHorizontalCenter)) {
      position.x = dashHorizontalCenter;
    }

    // 4 
    position += _velocity * dt;
    // 6 
    _velocity.y += _gravity;

    // Add a Player to the game: Add infinite side boundaries logic

    // Core gameplay: Add gravity

    // Add a Player to the game: Calculate Dash's current position based on
    // her velocity over elapsed time since last update cycle
    super.update(dt);
  }

  @override
  bool onKeyEvent(RawKeyEvent event, Set<LogicalKeyboardKey> keysPressed) {
    _hAxisInput = 0;
    
    // 4 
    if (keysPressed.contains(LogicalKeyboardKey.arrowLeft)) {
      moveLeft();
    }

    if (keysPressed.contains(LogicalKeyboardKey.arrowRight)) {
      moveRight();
    }

    // Add a Player to the game: Add keypress logic

    return true;
  }

  void moveLeft() {
    _hAxisInput = 0;
    // 9 
    if (isWearingHat) {
      current = PlayerState.nooglerLeft;
    }
    else if (!hasPowerup) {
      current = PlayerState.left;
    }
    _hAxisInput += movingLeftInput;

    // 4 
    current = PlayerState.left;
    _hAxisInput += movingLeftInput;

    // Add a Player to the game: Add logic for moving left
  }

  void moveRight() {
    _hAxisInput = 0;
    // 9 
    if (isWearingHat) {
      current = PlayerState.nooglerRight;
    }
    else if (!hasPowerup) {
      current = PlayerState.right;
    }
    _hAxisInput += movingRightInput;

    // 4 
    current = PlayerState.right;
    _hAxisInput += movingRightInput;

    // Add a Player to the game: Add logic for moving right
  }

  void resetDirection() {
    _hAxisInput = 0;
  }

  // 9 
  bool get hasPowerup =>
    current == PlayerState.rocket ||
    current == PlayerState.nooglerLeft ||
    current == PlayerState.nooglerRight ||
    current == PlayerState.nooglerCenter;

  bool get isInvincible => current == PlayerState.rocket;

  bool get isWearingHat =>
    current == PlayerState.nooglerLeft ||
    current == PlayerState.nooglerRight ||
    current == PlayerState.nooglerCenter;

  // Powerups: Add hasPowerup getter


  // Powerups: Add isInvincible getter

  // Powerups: Add isWearingHat getter

  // Core gameplay: Override onCollision callback
  // 6 
  @override
  void onCollision(Set<Vector2> intersectionPoints, PositionComponent other) {
    super.onCollision(intersectionPoints, other);
    // 8 
    // 9 
    if (other is EnemyPlatform && !isInvincible) {
      gameRef.onLose();
      return;
    }

    bool isCollidingVertically =
    (intersectionPoints.first.y - intersectionPoints.last.y).abs() < 5;
    
    if (isMovingDown && isCollidingVertically) {
      current = PlayerState.center;
    if (other is NormalPlatform) {
      jump();
      return;
      }
      else if (other is SpringBoard) {
        jump(specialJumpSpeed: jumpSpeed * 2);
        return;
      }
      else if (other is BrokenPlatform && other.current == BrokenPlatformState.cracked) {
        jump();
        other.breakPlatform();
        return;
      }
    }

    // 9 
    if (!hasPowerup && other is Rocket) {
      current = PlayerState.rocket;
      other.removeFromParent();
      jump(specialJumpSpeed: jumpSpeed * other.jumpSpeedMultiplier);
      return;
    }
    else if (!hasPowerup && other is NooglerHat) {
      if (current == PlayerState.center) current = PlayerState.nooglerCenter;
      if (current == PlayerState.left) current = PlayerState.nooglerLeft;
      if (current == PlayerState.right) current = PlayerState.nooglerRight;
      other.removeFromParent();
      _removePowerupAfterTime(other.activeLengthInMS);
      jump(specialJumpSpeed: jumpSpeed * other.jumpSpeedMultiplier);
      return;
    }
  }

  // Core gameplay: Add a jump method
  // 6 
  void jump({double? specialJumpSpeed}) {
    _velocity.y = specialJumpSpeed != null ? -specialJumpSpeed : -jumpSpeed;
  }

  void _removePowerupAfterTime(int ms) {
    Future.delayed(Duration(milliseconds: ms), () {
      current = PlayerState.center;
    });
  }

  void setJumpSpeed(double newJumpSpeed) {
    jumpSpeed = newJumpSpeed;
  }

  void reset() {
    _velocity = Vector2.zero();
    current = PlayerState.center;
  }

  void resetPosition() {
    position = Vector2(
      (gameRef.size.x - size.x) / 2,
      (gameRef.size.y - size.y) / 2,
    );
  }

  Future<void> _loadCharacterSprites() async {
    // Load & configure sprite assets
    final left = await gameRef.loadSprite('game/${character.name}_left.png');
    final right = await gameRef.loadSprite('game/${character.name}_right.png');
    final center =
        await gameRef.loadSprite('game/${character.name}_center.png');
    final rocket = await gameRef.loadSprite('game/rocket_4.png');
    final nooglerCenter =
        await gameRef.loadSprite('game/${character.name}_hat_center.png');
    final nooglerLeft =
        await gameRef.loadSprite('game/${character.name}_hat_left.png');
    final nooglerRight =
        await gameRef.loadSprite('game/${character.name}_hat_right.png');

    sprites = <PlayerState, Sprite>{
      PlayerState.left: left,
      PlayerState.right: right,
      PlayerState.center: center,
      PlayerState.rocket: rocket,
      PlayerState.nooglerCenter: nooglerCenter,
      PlayerState.nooglerLeft: nooglerLeft,
      PlayerState.nooglerRight: nooglerRight,
    };
  }
}
