package com.db2.config.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.db1.config.entity.Promotion_base;
import com.db2.config.entity.Subscription;

@Repository
public interface Subscription_Repo extends JpaRepository<Subscription, Integer>{
	

	@Query(value="SELECT * FROM tbl_subscription WHERE DATE(sub_date_time)=?1 ", nativeQuery = true)
	public List<Subscription> getData(String date);
	
//	@Query(value="SELECT ani,default_amount FROM tbl_subscription WHERE ani=?1 AND DATE(sub_date_time)>='2023-04-27' ", nativeQuery = true)
//	public Subscription getAllData(String ani);
	
	@Query(value="SELECT ani,default_amount FROM tbl_subscription WHERE ani=?1 AND DATE(sub_date_time)='2023-04-27' ", nativeQuery = true)
	public Subscription getAllData(String ani);
	
//	@Query(value="SELECT ani,default_amount FROM tbl_subscription WHERE ani=?1 AND DATE(sub_date_time)>='2023-04-27' AND last_billed_date IS NOT NULL", nativeQuery = true)
//	public Subscription getData(String ani);
	
//	@Query(value="SELECT * FROM tbl_subscription WHERE ani=?1 AND DATE(sub_date_time)>='2023-04-27' AND last_billed_date IS NOT NULL", nativeQuery = true)
//	public Subscription getData(String ani);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE  tbl_subscription SET STATUS='Subscribe' WHERE ani=?1 ", nativeQuery = true)
	public Integer updateAllData(String ani);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE  tbl_subscription SET STATUS='Charged' WHERE ani=?1 ", nativeQuery = true)
	public Integer updateData(String ani);

}
