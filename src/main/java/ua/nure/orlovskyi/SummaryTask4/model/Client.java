package ua.nure.orlovskyi.SummaryTask4.model;


public class Client extends User {
	
	
	private String passport;
	private Boolean isBlocked;
	
	
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Boolean getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	@Override
	public String toString() {
		return "Client [passport=" + passport + ", isBlocked=" + isBlocked + "]";
	}
	
	
}

