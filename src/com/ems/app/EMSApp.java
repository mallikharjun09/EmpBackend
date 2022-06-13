package com.ems.app;

import com.ems.services.EmployeeServices;

public class EMSApp {
	public static void main(String[] args) {
		var dao = new EmployeeServices();
		dao.menu();
	}
}
