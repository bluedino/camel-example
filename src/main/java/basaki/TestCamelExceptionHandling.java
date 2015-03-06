package basaki;

import org.apache.camel.spring.Main;

public class TestCamelExceptionHandling {

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.setApplicationContextUri("/META-INF/spring/camel-exception-context.xml");
		main.run(args);
	}

}
