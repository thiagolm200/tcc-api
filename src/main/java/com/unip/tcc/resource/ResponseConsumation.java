package com.unip.tcc.resource;

import java.util.ArrayList;
import java.util.List;

import com.unip.tcc.model.WaterHistory;

public class ResponseConsumation {

	private String qtyToday;
	
	private String qtyYesterday;
	
	private List<HistoryDetail> week;

	
	public ResponseConsumation(String qtyToday, String qtyYesterday, List<WaterHistory> listWaterHistoryWeek) {
		
		this.qtyToday = qtyToday;
		
		this.qtyYesterday = qtyYesterday;
		
		this.week = new ArrayList<HistoryDetail>();
		
		for(WaterHistory waterHistory : listWaterHistoryWeek) {
			
			this.week.add(new HistoryDetail(waterHistory.getDateAtt(), waterHistory.getQuantity()));
		}
	}

	public String getQtyToday() {
		return qtyToday;
	}

	public void setQtyToday(String qtyToday) {
		this.qtyToday = qtyToday;
	}

	public String getQtyYesterday() {
		return qtyYesterday;
	}

	public void setQtyYesterday(String qtyYesterday) {
		this.qtyYesterday = qtyYesterday;
	}

	public List<HistoryDetail> getWeek() {
		return week;
	}

	public void setWeek(List<HistoryDetail> week) {
		this.week = week;
	}

}
