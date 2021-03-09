package com.app.dao;

import com.app.pojos.Vendor;

public interface IUserDao {
	Vendor authenticateUser(String em,String pass);
}
