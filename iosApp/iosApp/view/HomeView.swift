//
//  HomeView.swift
//  iosApp
//
//  Created by Ali Baha on 6/22/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared


struct HomeView : View {
    
    let entity : Entity
    
    var body: some View {
        
        HStack {
            Image(uiImage: entity.image.load())
                .resizable()
                .frame(width: 50,height: 50)
                .fixedSize()
                .padding(8)
            
            Text(entity.name)
            
        }
        
    }
    
}

extension String {
    func load() -> UIImage {
        do {
            guard let url = URL(string:self) else {return UIImage()}
            let data: Data = try Data(contentsOf: url)
            return UIImage(data: data) ?? UIImage()
        } catch { }
        return UIImage()
    }
}
