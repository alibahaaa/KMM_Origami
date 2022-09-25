//
//  MainViewModel.swift
//  iosApp
//
//  Created by Ali Baha on 6/22/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class ViewModel: ObservableObject {
    
    @Published var dataState = DataState.loading

    private let getOrigamiUseCase: GetOrigamiUseCase = koin.get()
    
    func loadOrigamies() {
        self.dataState = DataState.loading
        
        getOrigamiUseCase.invoke {entity, error in
            if let entity = entity {
                self.dataState = DataState.result(entity)
            } else {
                self.dataState = DataState.error
            }
        }
    }
}
