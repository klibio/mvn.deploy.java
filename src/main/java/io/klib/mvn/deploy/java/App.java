package io.klib.mvn.deploy.java;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Evaluation of Maven Release repositories
 * 
 * Maven Central / Sonatype
 * Reposilite / klib.io
 *
 */
public class App {
	
	/**
	 * avoid build warnings
	 */
	public App() {
		// avoid build warnings
	}
	
	/**
	 * Main to launch the application
	 * 
	 * @param args are not used for the main method
	 */
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		String timestamp = LocalDateTime.now().format(formatter);
		System.out.println("Hello Maven Central deployment " + timestamp);
		System.out.println("Implementation-Version: " + readImplementationVersion());

	}

	private static String readImplementationVersion() {
		String rv = "This class is not inside a JAR file.";
		try {
			// Get the location of the current class file (JAR file containing this class)
			String classPath = App.class.getProtectionDomain().getCodeSource().getLocation().getPath();

			// If the class is inside a JAR, the location will have a ".jar" extension
			if (classPath.endsWith(".jar")) {
				// Open the JAR file
				try (JarFile jarFile = new JarFile(classPath)) {
					// Get the manifest file from the JAR
					Manifest manifest = jarFile.getManifest();

					// Get the main attributes from the manifest
					Attributes mainAttributes = manifest.getMainAttributes();

					// Read the Implementation-Version
					String version = mainAttributes.getValue("Implementation-Version");

					if (version != null) {
						rv = "Implementation-Version: " + version;
					} else {
						rv = "Implementation-Version not found in the manifest.";
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rv;
	}
}
