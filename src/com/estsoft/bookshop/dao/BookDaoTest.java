package com.estsoft.bookshop.dao;

import java.util.List;

import com.estsoft.bookshop.vo.BookVo;
import com.mysql.jdbc.UpdatableResultSet;

public class BookDaoTest {

	public static void main(String[] args) {
		//insert test (CHECK!!!!!!!!!!�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�)
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
		
		bookVo.setTitle( "Ʈ���϶���" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "����" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "��Ŭ����" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "�극��ŷ��" );
		bookVo.setAuthorNo( 13L );
		bookDao.insert(bookVo);

		bookVo.setTitle( "�Ƹ���" );
		bookVo.setAuthorNo( 14L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "�����׵�" );
		bookVo.setAuthorNo( 15L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "�����ϱ� û���̴�" );
		bookVo.setAuthorNo( 16L );
		bookDao.insert(bookVo);
		
		bookVo.setTitle( "��õ" );
		bookVo.setAuthorNo( 17L );
		bookDao.insert(bookVo);		
	}
}