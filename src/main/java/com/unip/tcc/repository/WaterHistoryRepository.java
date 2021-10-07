package com.unip.tcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unip.tcc.model.WaterHistory;

@Repository()
public interface WaterHistoryRepository extends JpaRepository<WaterHistory, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO water_history(quantity) values(?1)",
			nativeQuery = true)
	@Transactional
	public int saveByQuantity(Double quantity);
	
	@Query(value="SELECT * from water_history ha where date(ha.date_att) > date(current_date at time zone 'gmt3')",
			nativeQuery = true)
	WaterHistory retreiveToday();
	
	@Query(value="SELECT * from water_history ha WHERE date(ha.date_att) > date(current_date at time zone 'gmt3' - interval '1 day') AND date(a.date_att) < date(current_date at time zone 'gmt3')", 
			nativeQuery = true)
	WaterHistory retreiveYesterday();
	
	@Query(
			value="SELECT * from water_history ha where date(ha.date_att) > date(current_date at time zone 'gmt3' - interval '7 days') order by ha.date_att desc",
			nativeQuery = true)
	List<WaterHistory> retreiveWeek();

}
