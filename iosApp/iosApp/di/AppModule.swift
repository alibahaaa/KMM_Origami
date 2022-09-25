//
//  AppModule.swift
//  iosApp
//
//  Created by Ali Baha on 6/22/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

func startKoin() {
    _koin = InjectorKt.doInitKoin().koin
}

private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}

extension Koin_coreKoin {
    func get() -> GetOrigamiUseCase {
        return koin.getDependency(objCClass: GetOrigamiUseCase.self) as! GetOrigamiUseCase
    }
}

