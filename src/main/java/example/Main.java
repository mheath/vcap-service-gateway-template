package example;

import nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mike Heath <elcapo@gmail.com>
 */
public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:context.xml");
		LOGGER.info("Service gateway started");
	}

}
