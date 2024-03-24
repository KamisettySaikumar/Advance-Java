package com.sathya.product.productmanagement;
import java.sql.Date;

public class Product_data {
   
	public int proId;
	public String proName;
	public  double proPrice;
	private  String proBrand;
	private  String promadeIn;
	public  Date promDate;
	public  Date promeDate;
	public  byte[] proImage;
	public byte[] proAudio;
	public byte[] proVideo;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getPromadeIn() {
		return promadeIn;
	}
	public void setPromadeIn(String promadeIn) {
		this.promadeIn = promadeIn;
	}
	public Date getPromDate() {
		return promDate;
	}
	public void setPromDate(Date promDate) {
		this.promDate = promDate;
	}
	public Date getPromeDate() {
		return promeDate;
	}
	public void setPromeDate(Date promeDate) {
		this.promeDate = promeDate;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	public byte[] getProAudio() {
		return proAudio;
	}
	public void setProAudio(byte[] proAudio) {
		this.proAudio = proAudio;
	}
	public byte[] getProVideo() {
		return proVideo;
	}
	public void setProVideo(byte[] proVideo) {
		this.proVideo = proVideo;
	}
}