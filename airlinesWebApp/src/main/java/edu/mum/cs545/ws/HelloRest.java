package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("airline")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		Airline airline = airlineService.findByName("oneworld");
		if (airline != null) {
			result = "This is an airline: " + airline.getName();
		}
		return result;
	}
	@Path("airlines")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Airline> getAirlineTest1() {
		String result = "Nil!";
		List<Airline> airline = airlineService.findAll();
		if (airline != null) {
			//result = "This is an airline: " + airline.getName();
		}
		System.out.println(airline);
		return airline;
	}
}
