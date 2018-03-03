package com.dao.impl;

import java.sql.SQLException;

import com.dao.BaseDao;
import com.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	public boolean checkLogin(String userName, String password) {
		boolean flag = false;
		String sql = "SELECT * FROM users where UserName=? and PASSWORD=?";
		Object[] params ={userName,password};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				flag = true;
				return flag;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
