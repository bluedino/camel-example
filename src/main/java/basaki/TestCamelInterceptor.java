package basaki;

import org.apache.camel.spring.Main;

public class TestCamelInterceptor {
	
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.setApplicationContextUri("/META-INF/spring/camel-intercept-context.xml");
		main.run(args);
	}

}
