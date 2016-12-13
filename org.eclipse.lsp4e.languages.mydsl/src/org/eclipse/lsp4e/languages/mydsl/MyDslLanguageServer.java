package org.eclipse.lsp4e.languages.mydsl;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.lsp4e.ProcessStreamConnectionProvider;

@SuppressWarnings("restriction")
public class MyDslLanguageServer extends ProcessStreamConnectionProvider {

	public MyDslLanguageServer() {
		final List<String> commands = new ArrayList<>();
		URI launcherUri = locateFile("org.eclipse.lsp4e.languages.mydsl", "server/bin/mydsl-standalone");
		URI workingDirUri = locateFile("org.eclipse.lsp4e.languages.mydsl", "server/working-dir");
		//TODO make this more elegant
		String launcher = launcherUri.toString().substring("file:".length());
		String workingDir = workingDirUri.toString().substring("file:".length());
		commands.add(launcher);
		setCommands(commands);
		setWorkingDirectory(workingDir);
	}

	private static URI locateFile(String bundle, String fullPath) {
		try {
			URL url = FileLocator.find(Platform.getBundle(bundle), new Path(fullPath), null);
			if (url != null)
				return FileLocator.resolve(url).toURI();
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public String toString() {
		return "MyDsl (Xtext) Language Server: " + super.toString();
	}

}
