package com.db1.config.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db1.config.entity.Promotion_base;

@Repository
public interface Promotion_base_Repo extends JpaRepository<Promotion_base, Integer>{

//	@Query(value="SELECT * FROM tbl_promotion_base WHERE DATE(promotion_date)>='2023-04-27' ", nativeQuery = true)
//	public List<Promotion_base> getData();
	
	@Query(value="SELECT * FROM tbl_promotion_base WHERE DATE(promotion_date)>='2023-04-27' ", nativeQuery = true)
	public List<Promotion_base> getData();
	
	@Modifying
	@Transactional
	@Query(value="UPDATE tbl_promotion_base SET sub_date=?1 WHERE msisdn=?2 ", nativeQuery = true)
	public Integer updateDate(String date ,String msisdn);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE  tbl_promotion_base SET STATUS='SubscriberNumber' WHERE msisdn=?1 ", nativeQuery = true)
	public Integer updateAllData(String msisdn);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE  tbl_promotion_base SET STATUS='ChargedNumber' WHERE msisdn=?1 ", nativeQuery = true)
	public Integer updateData(String msisdn);
	
	
}
