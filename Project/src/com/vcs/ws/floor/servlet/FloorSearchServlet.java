package com.vcs.ws.floor.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vcs.ws.floor.dao.FloorSearchDao;
import com.vcs.ws.floor.java.Floor;
import com.vcs.ws.wsconstants.WSConstants;

public class FloorSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String status = "";
		String id = request.getParameter("floorId");
		int floorId = 0;
		int noOfRecords=0;
		int pageNum=1;
		int totNoOfRecords=0;
		int recordsPerPage=WSConstants.RECORDS_PER_PAGE;

		if (id!=null &&!"".equals(id)) {
			floorId =  Integer.parseInt(id);
		}
		
		if(request.getParameter("page")!=null){
			pageNum=Integer.parseInt(request.getParameter("page"));
		}
		
		int startRow=(recordsPerPage * pageNum -(recordsPerPage))+1;
		int endRow=(recordsPerPage * pageNum);
		
		FloorSearchDao floorSearch = new FloorSearchDao();
		List<Floor> floorList = null;
		
		try {
			floorList = floorSearch.Search(floorId,startRow,endRow);
			noOfRecords=floorSearch.getCount(floorId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 int noOfPages=(int)Math.ceil(noOfRecords * 1.0/recordsPerPage);
		
		if (floorList.size() > 0) {
			request.setAttribute("status", status);
			request.setAttribute("floorList", floorList);
			request.setAttribute("noOfPages",noOfPages);
			request.setAttribute("currentPage",pageNum);
			request.setAttribute("noOfRecords",noOfRecords);
			RequestDispatcher rd = request
					.getRequestDispatcher("jsp/floor/floorSearch.jsp");
			rd.forward(request, response);

		} else {
			request.setAttribute("floorList", floorList);
			request.setAttribute("noOfPages",noOfPages);
			request.setAttribute("currentPage",pageNum);
			request.setAttribute("noOfRecords",noOfRecords);
			request.setAttribute("totNoOfRecords", totNoOfRecords);
			request.setAttribute("status", status);
			RequestDispatcher rd = request
					.getRequestDispatcher("./jsp/floor/floorSearch.jsp");
			rd.forward(request, response);
		}
	}

}
