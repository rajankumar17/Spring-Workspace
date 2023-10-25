package com.javabrains;

public class Flight {

	
	String FLIGHT_NUM;
	String DEP_LOC;
	String ARR_LOC;
	String VALID_TILL;
	String FLIGHT_TIME;
	String FLIGHT_DURN;
	Integer FARE;
	public String getFLIGHT_NUM() {
		return FLIGHT_NUM;
	}
	public void setFLIGHT_NUM(String fLIGHT_NUM) {
		FLIGHT_NUM = fLIGHT_NUM;
	}
	public String getDEP_LOC() {
		return DEP_LOC;
	}
	public void setDEP_LOC(String dEP_LOC) {
		DEP_LOC = dEP_LOC;
	}
	public String getARR_LOC() {
		return ARR_LOC;
	}
	public void setARR_LOC(String aRR_LOC) {
		ARR_LOC = aRR_LOC;
	}
	public String getVALID_TILL() {
		return VALID_TILL;
	}
	public void setVALID_TILL(String vALID_TILL) {
		VALID_TILL = vALID_TILL;
	}
	public String getFLIGHT_TIME() {
		return FLIGHT_TIME;
	}
	public void setFLIGHT_TIME(String fLIGHT_TIME) {
		FLIGHT_TIME = fLIGHT_TIME;
	}
	public String getFLIGHT_DURN() {
		return FLIGHT_DURN;
	}
	public void setFLIGHT_DURN(String fLIGHT_DURN) {
		FLIGHT_DURN = fLIGHT_DURN;
	}
	public Integer getFARE() {
		return FARE;
	}
	public void setFARE(Integer fARE) {
		FARE = fARE;
	}
	@Override
	public String toString() {
		return "Flight [FLIGHT_NUM=" + FLIGHT_NUM + ", DEP_LOC=" + DEP_LOC
				+ ", ARR_LOC=" + ARR_LOC + ", VALID_TILL=" + VALID_TILL
				+ ", FLIGHT_TIME=" + FLIGHT_TIME + ", FLIGHT_DURN="
				+ FLIGHT_DURN + ", FARE=" + FARE + "]";
	}
	
}
