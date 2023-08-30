package model;

public class TypeOfFood {
	private String idToF;
	private String nameToF;
	
	public TypeOfFood() {
	}

	public TypeOfFood(String idToF, String nameToF) {
		this.idToF = idToF;
		this.nameToF = nameToF;
	}

	public String getIdToF() {
		return idToF;
	}

	public void setIdToF(String idToF) {
		this.idToF = idToF;
	}

	public String getNameToF() {
		return nameToF;
	}

	public void setNameToF(String nameToF) {
		this.nameToF = nameToF;
	}

	@Override
	public String toString() {
		return "TypeOfFood [idToF=" + idToF + ", nameToF=" + nameToF + "]";
	}
	
}
