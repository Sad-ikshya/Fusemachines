package com.fuse.financeManagement.models;

import java.math.BigInteger;
import java.util.Comparator;

public class User {
	private BigInteger id;
	private String fullName;
	private String address;
	private BigInteger phoneNumber;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static Comparator<User> UserFullNameComparator = new Comparator<User>() {
		public int compare(User u1, User u2) {
			String UserName1 = u1.getFullName().toUpperCase();
			String UserName2 = u2.getFullName().toUpperCase();

			return UserName1.compareTo(UserName2);
		}
	};

}
