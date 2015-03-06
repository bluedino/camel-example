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
public class StringToPayloadTransformer implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering StringToPayloadTransformer.process");
		String message = exchange.getIn().getBody(String.class);
		System.out.println("message: " + message);
		Payload payload = new Payload();
		payload.setMessage(message);
		exchange.getIn().setBody(payload);
		System.out.println("*** exiting StringToPayloadTransformer.process");
	}

}
