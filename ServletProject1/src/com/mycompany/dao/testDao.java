package com.mycompany.dao;
import java.util.List;
import com.mycompany.bo.PoItemBo;
public class testDao {
	public static void main(String[] args) {
//		PoItemBo pi = new PoItemBo();
//		pi.setItemNo("IT010");
//		pi.setItemName("Test");
//		pi.setUnitPrice(1000);
//		pi.setItemUnit("EA");
//		int ret = PoItemDao.save(pi);
//		System.out.println(ret); 
//		List<PoItemBo> list = PoItemDao.getPoItems();
//		for(PoItemBo i : list) {
//			System.out.println(i.getItemNo());
		
		PoItemBo ib = PoItemDao.getPoItemByNo("IT001");
		System.out.println(ib.getItemName());
	}
}
