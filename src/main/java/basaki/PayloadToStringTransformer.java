/**
 * 
 */
package basaki;

import java.util.Calendar;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author n0253174
 *
 */
public class PayloadToStringTransformer implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering PayloadToStringTransformer.process");
		Payload payload  = exchange.getIn().getBody(Payload.class);
		System.out.println("payload: " + payload);
		exchange.getOut().setBody(payload.getMessage());
		exchange.getOut().setHeader(Exchange.FILE_NAME, "f" + Calendar.getInstance().getTime().getTime() + ".txt");
		System.out.println("*** exiting PayloadToStringTransformer.process");

	}

}
