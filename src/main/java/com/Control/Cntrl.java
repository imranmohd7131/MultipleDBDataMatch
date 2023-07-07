//package com.Control;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.db1.config.entity.Promotion_base;
//import com.db1.config.repo.Promotion_base_Repo;
//import com.db2.config.entity.Subscription;
//
//@RestController
//public class Cntrl {
//	
//	
//	@Autowired
//	Promotion_base_Repo promotion_base_Repo;
//	
//	public void update() {
//		List<Promotion_base> li = promotion_base_Repo.getData();
//		//List<Subscription> sub_li = subscription_Repo.getData();
//		
//		for(Promotion_base list : li) {
//			Promotion_base obj=new Promotion_base();
//			obj.setStatus("1");
//			
//			list.get
//			promotion_base_Repo.save(obj);
//		}
//	} 
//
//}
