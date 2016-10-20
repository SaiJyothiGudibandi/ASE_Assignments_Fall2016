/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
 
@Path("/CIService")
public class CompoundInterestService {
	@GET
	@Path("/ci/{meters}")
	@Produces("application/json")
	public Response calculateCompInterest(@PathParam("meters") Double m)
	{
		JSONObject jsonObject = new JSONObject();
		Double cm;
		cm = m*100;
		jsonObject.put("Meters", m); 
		jsonObject.put("CentiMeters", cm); 
		String result = "@Produces(\"application/json\") Output: \n\nCentimeters Output: \n\n" + jsonObject;
	//	return "<Compound Calculator>" + "<Amount>" + p + "</Amount>" + "<No. of Years>" + t + "</No. of Years>" + "<Interest Rate>" + r + "</Interest Rate>" + "<Simple Interest>" + ci + "</Compound Interest>" + "</Interest Calculator>";
		return Response.status(200).entity(result).build();
	}
}