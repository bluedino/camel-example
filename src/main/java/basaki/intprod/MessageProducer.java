package basaki.intprod;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component("msgProducer")
public class MessageProducer {

	@Produce(uri = "direct:start")
	private ProducerTemplate template;

	public Object process(String message) throws InterruptedException,
			ExecutionException {
		System.out
				.println("-------------------------------------- MessageProducer.process "
						+ message);
		Future<Object> future = template.asyncSendBody(
				template.getDefaultEndpoint(), message);
		return future.get();
	}

	public Object process(Exchange exchange) throws InterruptedException,
			ExecutionException {
		System.out
				.println("-------------------------------------- MessageProducer.process2 "
						+ exchange);
		System.out.println("message: " + exchange.getIn().getBody(String.class));
		Future<Object> future = template.asyncSendBody(
				template.getDefaultEndpoint(), exchange);

		return future.get();
	}
}
