package com.estsoft.bookshop.dao;

import java.util.List;

import com.estsoft.bookshop.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		//1. insert test
		insertTest();
		
		//2. getList Test
		getListTest();
	}

	public static void getListTest(){
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> list = authorDao.getList();
		
		for( AuthorVo vo : list ) {
			System.out.println( vo );
		}
	}
	
	public static void insertTest(){
		AuthorVo authorVo = new AuthorVo();
		AuthorDao authorDao = new AuthorDao();

		authorVo.setName( "�����Ĵϸ��̾�" );

		authorDao.insert( authorVo );

		authorVo.setName( "������" );

		authorDao.insert( authorVo );
	
		authorVo.setName( "�赿��" );
		
		authorDao.insert( authorVo );
		
		authorVo.setName( "�賭��" );
	
		authorDao.insert( authorVo );
		authorVo.setName( "õ��" );
		
		authorDao.insert( authorVo );
	}
}
