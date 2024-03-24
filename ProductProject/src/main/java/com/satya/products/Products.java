package com.satya.products;

import java.io.InputStream;
import java.sql.Date;

public class Products {
		
	
		private String proId;
		private String proName;
		private Double proPrice;
		private String proBrand;
		private String proMadeIn;
		private Date proMnfgDate;
		private Date proExpDate;
		private InputStream proImage;
		public String getProId() {
			return proId;
		}
		public void setProId(String proId) {
			this.proId = proId;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public Double getProPrice() {
			return proPrice;
		}
		public void setProPrice(Double proPrice) {
			this.proPrice = proPrice;
		}
		public String getProBrand() {
			return proBrand;
		}
		public void setProBrand(String proBrand) {
			this.proBrand = proBrand;
		}
		public String getProMadeIn() {
			return proMadeIn;
		}
		public void setProMadeIn(String proMadeIn) {
			this.proMadeIn = proMadeIn;
		}
		public Date getProMnfgDate() {
			return proMnfgDate;
		}
		public void setProMnfgDate(Date proMnfgDate) {
			this.proMnfgDate = proMnfgDate;
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