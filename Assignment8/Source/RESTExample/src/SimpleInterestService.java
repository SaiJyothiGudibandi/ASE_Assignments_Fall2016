/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/SIService")
public class SimpleInterestService {
 

		@GET
		@Path("/si/{meters}")
		@Produces("application/json")
		public Response calculateSimpleInterest(@PathParam("meters") Double m)
		{
			JSONObject jsonObject = new JSONObject();
			Double k;
			k = m*1000;
			jsonObject.put("Meters", m); 
			jsonObject.put("Kilo Meters", k);
			String result = "@Produces(\"application/json\") Output: \n\nKilometers Output: \n\n" + jsonObject;
		//	return "<Interest Calculator>" + "<Amount>" + p + "</Amount>" + "<No. of Years>" + t + "</No. of Years>" + "<Interest Rate>" + r + "</Interest Rate>" + "<Simple Interest>" + si + "</Simple Interest>" + "</Interest Calculator>";
				return Response.status(200).entity(result).build();
		}
}