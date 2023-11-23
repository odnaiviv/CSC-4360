//
//  ContentView.swift
//  SwiftBinding
//
//  Created by user247404 on 10/26/23.
//

import SwiftUI

struct ContentView: View {
    
    @State var red = 1.0
    @State var green = 1.0
    @State var blue = 1.0

    var body: some View {
        VStack {
            Text("Color Picker")
                .font(/*@START_MENU_TOKEN@*/.largeTitle/*@END_MENU_TOKEN@*/)
                .fontWeight(.light)
                .padding()
            Image(systemName: "gamecontroller.fill")
                .foregroundColor(Color(red: red, green: green, blue: blue))
            ColorSliderView(value: $red, color: .red)
            ColorSliderView(value: $green, color: .green)
            ColorSliderView(value: $blue, color: .blue)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
