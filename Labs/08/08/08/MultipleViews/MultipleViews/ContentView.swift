//
//  ContentView.swift
//  MultipleViews
//
//  Created by user247404 on 10/26/23.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView {
            List(DataModel.data, id: \.id) {
                object in
                HStack {
                    Image(systemName: object.icon)
                        .foregroundColor(object.color)
                    Text("\(object.high)° F")
                    NavigationLink(object.day, destination: DetailView(data: object))
                }
                .navigationTitle("Buford, GA")
            }
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
