//
//  DataState.swift
//  iosApp
//
//  Created by Ali Baha on 6/22/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

enum DataState {
    case loading
    case result([Entity])
    case error
}
