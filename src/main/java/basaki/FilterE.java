package basaki;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FilterE implements Processor {

	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering FilterE.process");
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage("FilterE message");
		System.out.println("*** exiting FilterE.process");

	}

}
