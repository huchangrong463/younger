package com.cc.springbootstudy.es;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName="mytest3",type="product")
public class TestModel implements java.io.Serializable{
	@Id
	private String uuid;
	private String name;
	private double price;
	private List<String> cats = new ArrayList<String>();
	
	private String highLightStr = "";
	
	public TestModel(){
		
	}
	
	public TestModel(String uuid, String name, double price, List<String> cats) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.price = price;
		this.cats = cats;
	}
	
	public String getHighLightStr() {
		return highLightStr;
	}

	public void setHighLightStr(String highLightStr) {
		this.highLightStr = highLightStr;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<String> getCats() {
		return cats;
	}
	public void setCats(List<String> cats) {
		this.cats = cats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cats == null) ? 0 : cats.hashCode());
		result = prime * result
				+ ((highLightStr == null) ? 0 : highLightStr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestModel other = (TestModel) obj;
		if (cats == null) {
			if (other.cats != null)
				return false;
		} else if (!cats.equals(other.cats))
			return false;
		if (highLightStr == null) {
			if (other.highLightStr != null)
				return false;
		} else if (!highLightStr.equals(other.highLightStr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TestModel [uuid=" + uuid + ", name=" + name + ", price="
				+ price + ", cats=" + cats + ", highLightStr=" + highLightStr
				+ "]";
	}
	
	
}
