package com.satya.Servlet;

import java.io.InputStream;
import java.sql.Date;

public class Product 
{
	private String proId;
	private String name;
	private double proprice;
	private String proBrand;
	private String proMade;
	private Date proMfgDate;
	private Date proExpDate;
	private InputStream proImage;
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProprice() {
		return proprice;
	}
	public void setProprice(double proprice) {
		this.proprice = proprice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMade() {
		return proMade;
	}
	public void setProMade(String proMade) {
		this.proMade = proMade;
	}
	public Date getProMfgDate() {
		return proMfgDate;
	}
	public void setProMfgDate(Date proMfgDate) {
		this.proMfgDate = proMfgDate;
	}
	public Date getProExpDate() {
		return proExpDate;
	}
	public void setProExpDate(Date proExpDate) {
		this.proExpDate = proExpDate;
	}
	public InputStream getProImage() {
		return proImage;
	}
	public void setProImage(InputStream proImage) {
		this.proImage = proImage;
	}
	

}
