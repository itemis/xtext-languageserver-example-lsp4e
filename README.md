# xtext-languageserver-example-lsp4e

1. `git clone https://github.com/itemis/xtext-languageserver-example-lsp4e.git`
1. `git clone http://git.eclipse.org/gitroot/lsp4e/lsp4e.git`
1. Import projects from `lsp4e` into eclipse and set target platform
1. Import projects from `xtext-languageserver-example-lsp4e`
1. Start Runtime Eclipse Application
1. Create `File->New->Project...->General->Project`
1. Create a file with extension `mydsl`

On slower machines it might be necessary to increase timeout in `org.eclipse.lsp4e.ProjectSpecificLanguageServerWrapper.getServerCapabilities()`
