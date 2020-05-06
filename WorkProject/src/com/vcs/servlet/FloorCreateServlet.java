package com.vcs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vcs.dao.FloorCreateDao;
import com.vcs.floor.Floor;

public class FloorCreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	response.setContentType("text/html");
		
		Floor floor=new Floor();
		floor.setFloorId(Integer.parseInt(request.getParameter("id")));
		floor.setFloorName(request.getParameter("name"));
		floor.setFloorDesc(request.getParameter("desc"));
		
		FloorCreateDao floorDao=new FloorCreateDao();
		String status=null;
		try {
			status=floorDao.insertFloor(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("status", status);
		RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
