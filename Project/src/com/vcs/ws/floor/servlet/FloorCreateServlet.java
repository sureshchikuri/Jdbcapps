package com.vcs.ws.floor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vcs.ws.floor.dao.FloorCreateDao;
import com.vcs.ws.floor.java.Floor;

public class FloorCreateServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		
		Floor floor=new Floor();
		floor.setFloorId(Integer.parseInt(request.getParameter("id")));
		floor.setFloorName(request.getParameter("name"));
		floor.setFloorDesc(request.getParameter("desc"));
		
		FloorCreateDao floorCreateDao=new FloorCreateDao();
		String status=null;
		try {
			status = floorCreateDao.floorCreate(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("status",status);
		RequestDispatcher rd=request.getRequestDispatcher("./jsp/floor/floorCreate.jsp");
		rd.forward(request, response);
		System.out.println("record submitted successfully");
	}
}


