package basaki;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FilterC implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering FilterC.process");
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage("FilterC message");
		System.out.println("*** exiting FilterC.process");
	}

}
