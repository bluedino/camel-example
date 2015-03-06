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
public class FilterD implements Processor {
	
	private static int counter = 0;

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering FilterD.process");
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		counter++;
		System.out.println("counter = " + counter);
		if ((counter % 3) == 0)
		{
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% FilterD failed to consume message");
			throw new ValidationException("counter = " + counter);
		} else {
			payload.setMessage("FilterD message");
			System.out.println("%%% FilterD successful in consuming message");
		}

		System.out.println("*** exiting FilterD.process");
	}

}
