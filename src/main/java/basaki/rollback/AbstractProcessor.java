package basaki.rollback;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public abstract class AbstractProcessor implements Processor {

	public final void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public abstract void rollback(Exchange exchange) throws Exception;

}
