//
//  ColorSliderView.swift
//  SwiftBinding
//
//  Created by user247404 on 10/26/23.
//

import SwiftUI

struct ColorSliderView: View {
    @Binding var value: Double
    var color: Color
    
    var body: some View {
        HStack {
            Circle()
                .frame(width: 25)
                .foregroundColor(color)
            Slider(value: $value)
        }
        .padding()
    }
}

struct ColorSliderView_Previews: PreviewProvider {
    @State static var value = 1.0
    
    static var previews: some View {
        ColorSliderView(value: $value, color: .yellow)
    }
}
