package nl.hu.v2tosad.resources;

import java.text.SimpleDateFormat;

import javax.json.*;
import javax.ws.rs.*;

import nl.hu.v2tosad.TOSAD.TestDAO;
import nl.hu.v2tosad.model.Klant;

@Path("/klanten")
public class klantenResource {
	TestDAO test = new TestDAO();
	
	@GET
	@Produces("application/json")
	public String getAllKlanten() {
		JsonArrayBuilder jab = Json.createArrayBuilder();
		for (Klant k : test.selectKlanten()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateString = sdf.format(k.getGeboorteDatum());
			
			job.add("id", k.getId());
			job.add("naam", k.getNaam());
			job.add("geslacht", k.getGeslacht());
			job.add("voorletters", k.getVoorletters());
			if (k.getTitel() == null) {
				job.add("titel", "null");
			} else {
				job.add("titel", k.getTitel());	
			}
			job.add("geboorteDatum", dateString);
			
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@POST
	@Path("add/{name}")
	public void createKlant(@PathParam("name") String naam) {
		test.createKlant(naam);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteKlant(@PathParam("id") int ID) {
		test.deleteKlant(ID);
	}
	
}
