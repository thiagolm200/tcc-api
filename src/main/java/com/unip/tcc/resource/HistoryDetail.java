package com.unip.tcc.resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoryDetail {
	
	private String date;
	
	private String quantity;
	
	public HistoryDetail(Date date, String quantity) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM");
		
		this.date = simpleDateFormat.format(date);
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}
