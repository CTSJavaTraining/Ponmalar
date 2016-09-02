package com.training.employeecasestudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainControl {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Please enter the operation to be executed on DB");
		System.out.println("1. Insert reacords");
		System.out.println("2. Delete Records");
		System.out.println("3. Display Records");
		CRUDMain cm = new CRUDMain();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int choice = Integer.parseInt(br.readLine());
		switch (choice) {
		case 1:
			cm.insertRecords();
			break;
		case 2:
			cm.deleteRecords();
			break;
		case 3:
			cm.displayRecords();
			break;
		default:
			System.out.println("Please enter proper values");
			break;
		}
	}
}
