//
//  DataModel.swift
//  MultipleViews
//
//  Created by user247404 on 10/26/23.
//

import UIKit
import SwiftUI

struct WeatherData: Hashable {
    var id: Int
    var day: String
    var high: Int
    var low: Int
    var icon: String
    
    var color: Color
}

class DataModel: NSObject {
    // data of upcoming week (Oct 29 - Nov 04)
    static let data: [WeatherData] = [
        WeatherData(id: 1, day: "Sunday", high: 82, low: 59, icon: "sun.max.fill", color: .yellow),
        WeatherData(id: 2, day: "Monnday", high: 82, low: 54, icon: "cloud.sun", color: .mint),
        WeatherData(id: 3, day: "Tuesday", high: 67, low: 38, icon: "cloud.sun.fill", color: .gray),
        WeatherData(id: 4, day: "Wednesday", high: 56, low: 35, icon: "cloud.fill", color: .blue),
        WeatherData(id: 5, day: "Thursday", high: 57, low: 37, icon: "cloud.fog", color: .purple),
        WeatherData(id: 6, day: "Friday", high: 62, low: 42, icon: "cloud.sun.fill", color: .gray),
        WeatherData(id: 7, day: "Saturday", high: 63, low: 46, icon: "cloud.sun", color: .mint)
    ]
}
