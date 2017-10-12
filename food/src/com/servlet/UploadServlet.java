package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.FoodDao;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;

public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		Food food = new Food();
		String filename = null;
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item: list ){
				if(item.isFormField()){
					if("chineseName".equals(item.getFieldName())){
						food.setChineseName(item.getString("UTF-8"));
					}else if("englishName".equals(item.getFieldName())){
						food.setEnglishName(item.getString("UTF-8"));
					}else if("description".equals(item.getFieldName())){
						food.setDescription(item.getString("UTF-8"));
					}else if("categoryId".equals(item.getFieldName())){
						food.setCategoryId(Integer.parseInt(item.getString()));
					}else if("foodId".equals(item.getFieldName())){
						food.setId(Integer.parseInt(item.getString()));
					}
				}else{
					String clientFilename = item.getName();
					String ext = clientFilename.substring(clientFilename.lastIndexOf("."));
					filename = System.currentTimeMillis()+ext;
					ServletContext application = request.getSession().getServletContext();
					String realPath = application.getRealPath("/Photos/"+filename);
					item.write(new File(realPath));
					System.out.println("上传图片的路径为："+realPath+"/"+"上传的文件名是："+filename);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FoodDao foodDao = new FoodDaoImpl();
		if(food.getId()==0?foodDao.addFood(food):foodDao.update(food)){
			response.sendRedirect("admin/foodsList.jsp");
			
		}else{
			request.getRequestDispatcher("error.jsp").forward(request,response);
		}
		
	}

}
