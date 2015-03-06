package basaki.intprod;

import org.apache.camel.spring.Main;

public class TestCamelInterceptorProducer {
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.setApplicationContextUri("/META-INF/spring/camel-intercept-producer-context.xml");
		main.run(args);
	}
}
