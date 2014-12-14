package com.smarket.model;

public class Person implements IIdentifier {
	
	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public String getName() {
		return name;
	
	}

}
