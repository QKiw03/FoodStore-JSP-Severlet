package model;

import java.sql.Date;
import java.util.Objects;

public class Supplier {
	private String 	idSupplier;
	private String 	fullName;
	private Date	foundedYear;
	private String	story;
	
	public Supplier() {
	}
	public Supplier(String idSupplier, String fullName, Date foundedYear, String story) {
		this.idSupplier = idSupplier;
		this.fullName = fullName;
		this.foundedYear = foundedYear;
		this.story = story;
	}
	public String getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getFoundedYear() {
		return foundedYear;
	}
	public void setFoundedYear(Date foundedYear) {
		this.foundedYear = foundedYear;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(fullName, idSupplier, foundedYear, story);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(idSupplier, other.idSupplier);
	}
	@Override
	public String toString() {
		return "Supplier [idSupplier=" + idSupplier + ", fullName=" + fullName + ", foundedYear=" + foundedYear
				+ ", story=" + story + "]";
	}
}
