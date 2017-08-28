package com.hph.test.exeTest;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class Hello {

	public static void main(String[] args) {
		try {
			Form queryForm = new Form();
			queryForm.add("cardsn", "062E791A");
			queryForm.add("cardtype", "01");
			queryForm.add("cardfaceno", "1021067935");
			queryForm.add("idtype", "00");
			queryForm.add("idno", "411002199910143520");
			queryForm.add("birthday", "19991014");
			String url = "http://localhost:8086/ws-bike/restlet/bike/0002";
			ClientResource client = new ClientResource(url);
			Representation represen = client.post(queryForm.getWebRepresentation());
			System.out.println(represen.getText());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
