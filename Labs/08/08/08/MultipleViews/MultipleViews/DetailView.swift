//
//  DetailView.swift
//  MultipleViews
//
//  Created by user247404 on 10/26/23.
//

import SwiftUI

struct DetailView: View {
    var data: WeatherData
    @State var isPresenting = false
    
    var body: some View {
        VStack {
            Text(data.day)
            Button("More Info") {
                isPresenting = true
            }
            .padding()
            .sheet(isPresented: $isPresenting) {
                Text("H \(data.high)° L \(data.low)° F")
                Image(systemName: data.icon)
                    .foregroundColor(data.color)
            }
        }
    }
}

#Preview {
    DetailView(data: DataModel.data[0])
}
