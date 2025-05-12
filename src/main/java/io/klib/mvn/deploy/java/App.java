package io.klib.mvn.deploy.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		String timestamp = LocalDateTime.now().format(formatter);
		System.out.println("Hello Maven Central deployment " + timestamp);
	}
}
