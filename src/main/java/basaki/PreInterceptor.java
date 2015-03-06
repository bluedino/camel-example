package basaki;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PreInterceptor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering PreInterceptor.process");
	}

}
