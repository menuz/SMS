package com.cloudlab.control.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.dao.InfoDAO;
import com.cloudlab.dao.imp.InfoDAOImp;
import com.cloudlab.model.Datagrid;
import com.cloudlab.model.Info;

/**
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetInfo.do")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GetInfoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		InfoDAO infoDAO = new InfoDAOImp();
		List<Info> infos = infoDAO.getAllInfos();

		Datagrid<Info> datagrid = new Datagrid(infos.size(), infos);
//		InfoDatagrid datagrid = new InfoDatagrid(infos.size(), infos);

		response.setCharacterEncoding("utf8");
		PrintWriter pw = response.getWriter();

		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					pw);
			jsonGenerator.writeObject(datagrid);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
