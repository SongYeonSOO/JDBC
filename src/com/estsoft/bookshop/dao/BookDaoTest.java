package com.estsoft.bookshop.dao;

import java.util.List;

import com.estsoft.bookshop.vo.BookVo;
import com.mysql.jdbc.UpdatableResultSet;

public class BookDaoTest {

	public static void main(String[] args) {
		//insert test (CHECK!!!!!!!!!!★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★)
		//insertTest();
		
		//getList test
	//	getListTest();
	
		//updatestate test
		updateStateTest();
		getListTest();
		
	}
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for( BookVo bookVo : list ) {
			System.out.println( bookVo );
		}
	}
	
	public static void updateStateTest(){
		BookVo bookVo = new BookVo();
		bookVo.setNo(47L);
		bookVo.setState("rent");
		new BookDao().updateState(bookVo);
	}
	public static void insertTest() {
		BookVo bookVo = new BookVo();
		BookDao bookDao = new BookDao();
		
		bookVo.setTitle( "트와일라잇" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "뉴문" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "이클립스" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "브레이킹던" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "아리랑" );
		bookVo.setAuthorNo( 14L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "젊은그들" );
		bookVo.setAuthorNo( 15L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "아프니까 청춘이다" );
		bookVo.setAuthorNo( 16L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "귀천" );
		bookVo.setAuthorNo( 17L );
		bookDao.insert(bookVo);		
	}
}