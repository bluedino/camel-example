package basaki.intprod;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import basaki.Payload;

public class ProcessorX implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("*** entering ProcessorX.process");
		System.out.println(exchange.getIn().getBody());
		Payload payload = exchange.getIn().getBody(Payload.class);
		String message = payload.getMessage();
		System.out.println(message);
		payload.setMessage(message + " ProcessorX message");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "ProcessorX");
		map.put("successful", Boolean.TRUE);
		exchange.setProperty("hist-map", map);
		System.out.println("*** exiting ProcessorX.process");
	}
}
