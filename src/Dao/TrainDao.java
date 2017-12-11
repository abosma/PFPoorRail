package Dao;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Model.Component;
import Model.Train;

public class TrainDao {

	@SuppressWarnings("unchecked")
	public void addTrain(Train tr) {
		JSONObject train = new JSONObject();
		JSONArray allComponents = new JSONArray();

		for (Component o : tr.getWagons()) {
			JSONObject specific_component = new JSONObject();

			specific_component.put("seats", o.getSeats());
			specific_component.put("id", o.getId());
			allComponents.add(specific_component);
		}
	
		train.put("Components", allComponents);
		train.put("name", tr.getName());
		StringWriter out = new StringWriter();

		try {
			train.writeJSONString(out);
			System.out.println(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
