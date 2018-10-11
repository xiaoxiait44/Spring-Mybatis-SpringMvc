package com.xxa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxa.entity.Book;

public interface BookDao {
	/**
	  * 通过id查询图书
	 * @param bookid
	 * @return
	 */
	Book queryById(long id);
	/**
	 * 查询所用图书
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	/**
	 * 减少图书
	 * @param bookid
	 * @return 如果影响行大于1表示更新的记录数
	 */
	int reduceNumber(long bookid);

}
