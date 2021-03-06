package com.wacoal.dockeeper;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.pnpsw.webservice.*;

/**
 *
 * @author sommaik
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://pnpsw.com/webservice";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry("this is a test");

		return response;
	}
	
}
