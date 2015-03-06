package basaki;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author n0253174
 *
 */
public class FilterA implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering FilterA.process");
		System.out.println(exchange.getIn().getBody());
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage("FilterA message");
		System.out.println("*** exiting FilterA.process");
	}

}
