package helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MonitoringEventFactory{
	
	ObjectMapper mapper = new ObjectMapper();


	public String generateEvent(String flowInstanceID,String state , Object payload) throws Exception {
		Map<String,Object> event = new HashMap<String,Object>();
		
		event.put("flowInstanceID", flowInstanceID);
		event.put("timestamp",new Date());
		event.put("state", state);
		event.put("payload",payload);
		
		String jsonInString = mapper.writeValueAsString(event);
		
		return jsonInString;
	}

}
