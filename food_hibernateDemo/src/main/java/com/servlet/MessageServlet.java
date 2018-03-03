package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessageDao;
import com.dao.impl.MessageDaoImpl;
import com.entity.Message;
@WebServlet(urlPatterns={"/Message"} ,name="MessageServlet")
public class MessageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDao messageService = new MessageDaoImpl();
		List<Message> list = messageService.getMessageList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
