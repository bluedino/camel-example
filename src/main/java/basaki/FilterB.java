/**
 * 
 */
package basaki;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author n0253174
 *
 */
public class FilterB implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering FilterB.process");
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage("FilterB message");
		System.out.println("*** exiting FilterB.process");
	}

}
