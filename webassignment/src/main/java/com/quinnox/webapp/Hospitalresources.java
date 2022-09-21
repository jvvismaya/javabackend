package com.quinnox.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hospital")
public class Hospitalresources {
	
	HospitalRepository repo = new HospitalRepository();
	
	@GET
	@Path("patientdetails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> gethospitals() throws Exception {
		return repo.gethospitals();
	}
	
	
	@POST
	@Path("newpatient")
	@Consumes(MediaType.APPLICATION_JSON)
	public Hospital newpatientdetails(Hospital ah)throws Exception {
		repo.newpatientdetails(ah);
		return ah;
	}
	
	@GET
	@Path("patientdetails/{patientid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospital> getPatientBasedOnid(@PathParam("patientid")int patientid) throws Exception{
		return repo.getPatientBasedOnid(patientid);
	}
		

	@DELETE
	@Path("delete/{patientid}")
	@Produces(MediaType.APPLICATION_XML)
	public String updatepatientname(@PathParam("patientid")int patientid)throws Exception{
		repo.deletepatientid(patientid);
		return "Hospital = "+patientid +" is deleted";
		
	}
	@PUT
	@Path("update/{patientid}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Hospital> updatePatientName(@PathParam("patientid")int patientid, Hospital ah) throws Exception
	{	
		List<Hospital> bothData = new ArrayList<Hospital>();
		bothData.addAll(repo.getPatientBasedOnid(patientid));
		repo.updatePatientName(patientid, ah);
		bothData.addAll(repo.getPatientBasedOnid(patientid));

		return bothData ;
	}
	
	
}
