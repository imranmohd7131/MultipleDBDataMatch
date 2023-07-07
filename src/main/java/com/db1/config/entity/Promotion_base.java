package com.db1.config.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_promotion_base")
public class Promotion_base {
	
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
	@Id
	private String msisdn;
//	private String service;
	private String status;
//	private java.sql.Date saveDate;
//	private java.sql.Date promotionDate;
//	private String request;
//	private String response;
	

}
