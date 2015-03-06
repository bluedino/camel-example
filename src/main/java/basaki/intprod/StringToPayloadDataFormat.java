package basaki.intprod;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;

import basaki.Payload;

public class StringToPayloadDataFormat implements DataFormat {

	@Override
	public void marshal(Exchange exchange, Object graph, OutputStream stream)
			throws Exception {
		System.out.println("*** entering StringToPayloadDataFormat.marshal");

		exchange.getOut().setHeader(Exchange.FILE_NAME,
				"p" + Calendar.getInstance().getTime().getTime() + ".txt");
		
		System.out.println("payload1: "
				+ exchange.getIn().getBody(Payload.class));
		Payload payload = exchange.getIn().getBody(Payload.class);
		stream.write(payload.getMessage().getBytes());

		System.out.println("*** exiting StringToPayloadDataFormat.marshal");
	}

	@Override
	public Object unmarshal(Exchange exchange, InputStream stream)
			throws Exception {
		System.out.println("*** entering StringToPayloadDataFormat.unmarshal");
		String message = exchange.getIn().getBody(String.class);
		System.out.println("message: " + message);
		Payload payload = new Payload();
		message = (message != null) ? message.trim() : message;
		payload.setMessage(message);
		System.out.println("*** exiting StringToPayloadDataFormat.unmarshal");
		return payload;
	}

}
