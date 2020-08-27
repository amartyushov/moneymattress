package io.mart;

import javax.inject.Inject;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest //initialize the application context and the embedded server
class HelloControllerTest {
	
	@Inject
	@Client("/")
	private RxHttpClient client;
	
	@Test
	public void testHello() {
		HttpRequest<String> request = HttpRequest.GET("/hello");
		String body = client.toBlocking().retrieve(request);
		
		assertNotNull(body);
		assertEquals("Hello World", body);
	}
}