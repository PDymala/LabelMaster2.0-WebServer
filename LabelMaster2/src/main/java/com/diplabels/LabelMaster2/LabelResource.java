package com.diplabels.LabelMaster2;

import java.sql.SQLException;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;



//http://localhost:8080/LabelMaster2/restapi/standardlabel/checklabel/AA123  GET
//http://localhost:8080/LabelMaster2/restapi/standardlabel/putlabel/AA123   POST
//http://localhost:8080/LabelMaster2/restapi/standardlabel/deletelabel/AA123   DELETE



@Path("standardlabel")
public class LabelResource {

	LabelRepository repo = new LabelRepository();

//	0 = false
//	1 = true / sucess
//	99 = error

	@GET
	@Path("checklabel/{number}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Object checkLabel(@PathParam("number") String number) {

		try {
			if (repo.checkIfExist(number)) {

				JSONObject json = new JSONObject();
				json.put("result", 1);

				// return json;
				return json.get("result");

			} else {

				JSONObject json = new JSONObject();
				json.put("result", 0);

				return json.get("result");

			}
		} catch (ClassNotFoundException | JSONException | SQLException e) {

			e.printStackTrace();

			JSONObject json = new JSONObject();
			json.put("result", 99);

			return json.get("result");
		}

	}

	@POST
	@Path("putlabel/{number}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Object putLabel(@PathParam("number") String number) {

		try {
			Label temp = new Label(number);
			repo.addToDatabase(temp.getNUmber());

			JSONObject json = new JSONObject();
			json.put("result", 1);

			return json.get("result");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject json = new JSONObject();
			json.put("result", 99);

			return json.get("result");
		}

	}

	@DELETE
	@Path("deletelabel/{number}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Object delLabel(@PathParam("number") String number) {

		try {

			repo.deleteLabel(number);
			JSONObject json = new JSONObject();
			json.put("result", 1);

			return json.get("result");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JSONObject json = new JSONObject();
			json.put("result", 99);

			return json.get("result");
		}

	}

}
