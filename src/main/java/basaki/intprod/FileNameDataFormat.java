package basaki.intprod;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;

import org.apache.camel.Exchange;
import org.apache.camel.spi.DataFormat;

public class FileNameDataFormat implements DataFormat {

	@Override
	public void marshal(Exchange exchange, Object graph, OutputStream stream)
			throws Exception {
		System.out.println("*** entering ExchangeToStringDataFormat.marshal");

		exchange.getOut().setHeader(Exchange.FILE_NAME,
				"l" + Calendar.getInstance().getTime().getTime() + ".txt");
		String message = exchange.getIn().getBody(String.class);
		System.out.println("&&&&& " + exchange.getIn().getBody(String.class));
		System.out.println("message: " + message);
		stream.write(message.getBytes());

		System.out.println("*** exiting ExchangeToStringDataFormat.marshal");

	}

	@Override
	public Object unmarshal(Exchange exchange, InputStream stream)
			throws Exception {
		return null;
	}

}
