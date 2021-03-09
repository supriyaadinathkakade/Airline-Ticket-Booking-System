package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Vendor;

@Service //mandatory : to tell SC following class is a B.L supplier.
@Transactional //mandatory : to tell Spring supplied tx mgr bean , to handle txs automatically.
public class UserServiceImpl implements IUserService {
	//dependency : DAO layer 
	@Autowired
	private IUserDao userDao;

	@Override
	public Vendor authenticateUser(String em, String pass) {
		// TODO Auto-generated method stub
		return userDao.authenticateUser(em, pass);
	}

}
