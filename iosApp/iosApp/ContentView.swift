import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greeting()
    
    @ObservedObject private var viewModel = ViewModel()
    
    var body: some View {
        
        VStack(){
            NavigationView{
                uiState()
                    .navigationTitle("KMM Origami")
            }
        }
        .onAppear(){
            viewModel.loadOrigamies()
        }
    }
    
    private func uiState() -> AnyView {
        switch viewModel.dataState {
            
        case DataState.loading:
            return AnyView( ZStack{
                ProgressView()
                    .progressViewStyle(CircularProgressViewStyle(tint: .gray))
                    .scaleEffect(2)
            }.multilineTextAlignment(.center))
            
        case DataState.result(let origimies):
            return AnyView(
                
                List(origimies) { origimi in
                    
                    NavigationLink {
                        DetailView(entity: origimi)
                            .navigationTitle(origimi.name)
                    } label: {
                        HomeView(entity: origimi)
                    }
                    
                }
  
            )
            
        case DataState.error:
            return AnyView(Text("ERROR").multilineTextAlignment(.center))
        }
    }
    
}

extension Entity: Identifiable { }

struct ContentView_Previews: PreviewProvider {
    
    static var previews: some View {
        ContentView()
    }
}
