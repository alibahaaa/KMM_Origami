//
//  DetailView.swift
//  iosApp
//
//  Created by Ali Baha on 6/22/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared


struct DetailView : View {
    
    let entity : Entity
    
    var body: some View {
        
        ScrollView {
            
            VStack {
                Image(uiImage: entity.image.load())
                    .resizable()
                    .frame(width: 250,height: 250)
                    .fixedSize()
                    .padding(8)
                
                Text(entity.description_)
                
            }
            .padding()
            
        }
    }
    
}
