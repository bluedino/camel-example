package basaki.intprod;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import basaki.Payload;
import basaki.ValidationException;

public class ProcessorY implements Processor {

	private static int counter = 0;
	private static int failCounter = 0;

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering ProcessorY.process");

		counter++;
		failCounter++;
		System.out.println("counter = " + counter);
		if ((counter % 2) == 0) {
			//failCounter = 0;
			System.out
					.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ProcessorY failed to consume message");
			throw new ValidationException("counter = " + counter);
		}

		System.out.println(exchange.getIn().getBody());
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage(message + " ProcessorY message");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "ProcessorY");
		map.put("successful", Boolean.TRUE);
		exchange.setProperty("hist-map", map);
		System.out.println("*** exiting ProcessorY.process");
	}
}
