package com.estsoft.ticketsystem;

import com.estsoft.bookshop.dao.BookDao;
import com.estsoft.bookshop.vo.BookVo;

public class MovieDBtest {
public static void main(String[] args){
	insertTest();
}
public static void insertTest() {
	Movie m = new Movie();
	MovieDB mdb = new MovieDB();
	//m.setNo(1L);
	m.setTitle("The Lord of the Rings");
	mdb.insert(m);
	//m.setNo(2L);
	m.setTitle("The Matrix");
	mdb.insert(m);
	//m.setNo(3L);
	m.setTitle("Pride & Prejudice");
	mdb.insert(m);
	}
}
