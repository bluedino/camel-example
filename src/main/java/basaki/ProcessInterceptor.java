package basaki;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.processor.DelegateAsyncProcessor;
import org.apache.camel.spi.InterceptStrategy;

public class ProcessInterceptor implements InterceptStrategy {

	@Override
	public Processor wrapProcessorInInterceptors(final CamelContext context,
			ProcessorDefinition<?> definition, final Processor target,
			Processor nextTarget) throws Exception {
		
		//Route route = context.getRoute("example-service");
		
		
		System.out.println("&&&&&&&&&&&&&&&&&&&& process def label: " + definition.getLabel());
		//Endpoint end = route.getEndpoint();
		//

		return new DelegateAsyncProcessor(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out
						.println("%%%% ProcessInterceptor - entering processor "
								+ target);
				List<Route> routes = context.getRoutes();
				for (Route route : routes)
				{
					System.out.println("$$$$$$$ route: " + route);
					
				}
				target.process(exchange);
				System.out
						.println("%%%% ProcessInterceptor - exiting processor "
								+ target);
			}
		});
	}
}
