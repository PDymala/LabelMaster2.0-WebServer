package com.diplabels.LabelMaster2;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Label {

	Label() {

	}

	Label(int id, String number) {
		this.id = id;
		this.number = number;

	}

	Label(String number) {
		this.number = number;

	}
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String number;

	public String getNUmber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
