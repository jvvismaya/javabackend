package com.quinnox.webapp;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class HospitalRepository {
	
	public List <Hospital> gethospitals() throws SQLException, ClassNotFoundException{
		
		Connection conn = ApollaDatabaseConnection.getconnection();
		String selectQuery = "select * from hospital";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		List<Hospital> hospitals = new ArrayList<Hospital>();
		
		while (rs.next()) {
			
			Hospital h1 = new Hospital();
			h1.setPatientid(rs.getInt("patientid"));
			h1.setPatientname(rs.getString("patientname"));
			h1.setConcern(rs.getString("concern"));
			h1.setDoctorname(rs.getString("doctorname"));
			h1.setConsultancyfee(rs.getInt("consultancyfee"));
			
			hospitals.add(h1);
			System.out.println("patient details retrived");
		}				
		return hospitals;		
	}
	
	public void newpatientdetails (Hospital ah) throws Exception{
		
		Connection conn = ApollaDatabaseConnection.getconnection();
		String insertQuery = "insert into hospital values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertQuery);
		
		ps.setInt(1,ah.getPatientid());
		ps.setString(2,ah.getPatientname());
		ps.setString(3,ah.getConcern());
		ps.setString(4, ah.getDoctorname());
		ps.setInt(5,ah.getConsultancyfee());
		
		ps.executeUpdate();
				
	}
	
	public List<Hospital> getPatientBasedOnid(int patientid) throws Exception{
		
		Connection conn = ApollaDatabaseConnection.getconnection();
		String selectQuery = "select * from hospital where patientid ="+patientid;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		List<Hospital> hospital = new ArrayList<Hospital>();
		Hospital h2 = new Hospital();
		while(rs.next()) {
			//Hospital h2 = new Hospital();
			h2.setPatientid(rs.getInt("patientid"));
			h2.setPatientname(rs.getString("patientname"));
			h2.setConcern(rs.getString("concern"));
			h2.setDoctorname(rs.getString("doctorname"));
			h2.setConsultancyfee(rs.getInt("consultancyfee"));
			
			//hospital.add(h2);
			
		}	
		hospital.add(h2);
		System.out.println("patient details retrived on id");
		return hospital;
		
	}
				
	
	public String  deletepatientid(int patientid) throws Exception
	{
		Connection conn = ApollaDatabaseConnection.getconnection();	
		String queryUpdate = "delete from hospital where patientid = "+patientid;
		PreparedStatement ps =  conn.prepareStatement(queryUpdate);
		ps.executeUpdate();

		return "PatientRecord deleted";
	}
	
	public void  updatePatientName(int patientid, Hospital ah) throws Exception
	{
		Connection con = ApollaDatabaseConnection.getconnection();		
		String queryUpdate = "update hospital set doctorname = ? where patientid= ?";
		PreparedStatement ps =  con.prepareStatement(queryUpdate);
		ps.setInt(2, patientid);
		ps.setString(1, ah.getDoctorname());
		ps.executeUpdate();

	}
			
	};
	
	
