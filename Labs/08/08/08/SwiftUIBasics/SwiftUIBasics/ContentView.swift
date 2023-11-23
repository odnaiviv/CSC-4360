//
//  ContentView.swift
//  SwiftUIBasics
//
//  Created by user247404 on 10/26/23.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            Text("Weather")
                .font(/*@START_MENU_TOKEN@*/.largeTitle/*@END_MENU_TOKEN@*/)
                .fontWeight(.thin)
                .foregroundColor(Color(hue: 1.0, saturation: 0.0, brightness: 0.388))
            HStack {
                Image(systemName: "sun.max.fill")
                    .foregroundColor(Color.yellow)
                    .imageScale(.large)
                Text("Sunday")
            }
            HStack {
                Image(systemName: "cloud.fill")
                    .foregroundColor(Color(hue: 0.64, saturation: 0.348, brightness: 1.0))
                    .imageScale(.large)
                Text("Monday")
            }
            HStack {
                Image(systemName: "cloud.rain")
                    .foregroundColor(Color.blue)
                    .imageScale(.large)
                Text("Tuesday")
            }
            HStack {
                Image(systemName: "cloud.bolt.rain.fill")
                    .foregroundColor(Color(hue: 0.648, saturation: 0.6, brightness: 0.54))
                    .imageScale(.large)
                Text("Wednesday")
            }
            HStack {
                Image(systemName: "cloud.fill")
                    .foregroundColor(Color(hue: 0.64, saturation: 0.348, brightness: 1.0))
                    .imageScale(.large)
                Text("Thursday")
            }
            HStack {
                Image(systemName: "cloud.fog")
                    .foregroundColor(Color(hue: 0.476, saturation: 0.372, brightness: 0.96))
                    .imageScale(.large)
                Text("Friday")
            }
            HStack {
                Image(systemName: "cloud.sun.fill")
                    .foregroundColor(Color.gray)
                    .imageScale(.large)
                Text("Saturday")
            }
            // Image("icon")
            //     .resizable()
            //     .frame(width: 100.0, height: 100.0)
            //     .cornerRadius(10)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
