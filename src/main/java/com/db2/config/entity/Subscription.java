package com.db2.config.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tbl_subscription")
public class Subscription {
	
	@Id
	private String ani;
//	private java.sql.Date sub_date_time;
//	private java.sql.Date billing_date;
	private String default_amount;
//	private String STATUS;
	
	private String last_billed_date;
}
