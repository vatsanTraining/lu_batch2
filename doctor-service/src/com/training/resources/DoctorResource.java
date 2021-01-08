package com.training.resources;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.training.daos.DoctorDaoImpl;
import com.training.entity.Doctor;
import com.training.ifaces.DataAccess;

@Path(value = "/doctors")
public class DoctorResource {

	private DataAccess<Doctor> dao =null;

	
	public DoctorResource() {

		dao = new DoctorDaoImpl();
	}

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getDoctor() {
		
		List<Doctor> list = dao.findAll();
		return Response.status(200).entity(list).build();
	}
	
	
	@GET
	@Path("{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getDoctorById(@PathParam("id") int id) {
		
		Doctor entity = dao.findById(id);
		return Response.status(200).entity(entity).build();
	}
	
	@POST
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	
	public Response addDoctor(Doctor entity) {
		
		int rowAdded = dao.add(entity);
		
		Response resp = Response.status(403,"Exception -Row Already Exisits").entity(entity).build();
		if(rowAdded ==1) {
		 resp =Response.status(201).entity(entity).build();
		}
		return resp;
	}
	
	
	@DELETE
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response removeDoctor(Doctor doc) {
		
		int rowDeleted=0;
		Doctor deletedDoctor= null;

		     rowDeleted =dao.remove(doc.getDoctorId());
		    
		 if(rowDeleted ==1) {
		 deletedDoctor = doc;
		}

		 return Response.status(201).entity(deletedDoctor).build();
	}
}
