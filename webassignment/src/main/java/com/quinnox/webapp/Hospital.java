package com.quinnox.webapp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {
	private int patientid;
	private String patientname;
	private String concern;
	private String doctorname;
	private int consultancyfee;
	
	
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getConcern() {
		return concern;
	}
	public void setConcern(String concern) {
		this.concern = concern;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public int getConsultancyfee() {
		return consultancyfee;
	}
	public void setConsultancyfee(int consultancyfee) {
		this.consultancyfee = consultancyfee;
	}
	
	

}
