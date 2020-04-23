package br.net.nicoletti.ame.gateway.server;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import br.net.nicoletti.ame.gateway.restful.GatewayRESTFul;

public class App {

	private static final URI BASE_URI = URI.create("https://gateway-ame.herokuapp.com:80/");
	/**
	 * "Hello World" root resource path.
	 */
	public static final String ROOT_PATH = "helloworld";

	/**
	 * Main application entry point.
	 *
	 * @param args application arguments.
	 */
	public static void main(String[] args) {
		try {
			System.out.println("\"Hello World\" Jersey Example App");

			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, create(), false);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					server.shutdownNow();
				}
			}));
			server.start();

			System.out.println(
					String.format("Application started.%n" + "Try out %s%s%n" + "Stop the application using CTRL+C",
							BASE_URI, ROOT_PATH));

			Thread.currentThread().join();
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * Create example application resource configuration.
	 *
	 * @return initialized resource configuration of the example application.
	 */
	public static ResourceConfig create() {
		final ResourceConfig resourceConfig = new ResourceConfig(GatewayRESTFul.class);

		return resourceConfig;
	}
}
