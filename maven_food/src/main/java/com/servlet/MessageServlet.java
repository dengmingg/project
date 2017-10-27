package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Message;
import com.services.MessageService;
import com.services.Impl.MessageServiceImpl;
@WebServlet(urlPatterns={"/Message"} ,name="MessageServlet")
public class MessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageService messageService = new MessageServiceImpl();
		List<Message> list = messageService.getMessageList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
