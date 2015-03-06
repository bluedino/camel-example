package basaki.intprod;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.ProcessDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.processor.DelegateAsyncProcessor;
import org.apache.camel.spi.InterceptStrategy;

public class ProcessInterceptorv2 implements InterceptStrategy {

	@Resource(name = "msgProducer")
	private MessageProducer producer;

	@Override
	public Processor wrapProcessorInInterceptors(final CamelContext context,
			final ProcessorDefinition<?> definition, final Processor target,
			Processor nextTarget) throws Exception {

		if (definition instanceof ProcessDefinition) {

			return new DelegateAsyncProcessor(new Processor() {
				@SuppressWarnings("unchecked")
				public void process(Exchange exchange) throws Exception {
					System.out
							.println("%%%% ProcessInterceptor - entering processor "
									+ target);

					exchange.removeProperty("hist-map");
					long start = System.currentTimeMillis();
					target.process(exchange);
					long end = System.currentTimeMillis();
					System.out
							.println("%%%% ProcessInterceptor - exiting processor "
									+ target);

					HashMap<String, Object> map = (HashMap<String, Object>) exchange
							.getProperty("hist-map", HashMap.class);
					if (map == null) {
						map = new HashMap<String, Object>();
						map.put("name", definition.getLabel());
						map.put("successful", Boolean.FALSE);
					}

					StringBuffer buffer = new StringBuffer();
					buffer.append("processing time=" + (end - start) + "\t");
					for (String key : map.keySet()) {
						// System.out.println(key + "=" + map.get(key) + "\t");
						buffer.append(key + "=" + map.get(key) + "\t");
					}

					System.out.println("Buffer: " + buffer);
					producer.process(buffer.toString());
				}
			});
		} else {
			return target;
		}

	}
}
