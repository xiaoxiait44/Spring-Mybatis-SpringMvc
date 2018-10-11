package com.xxa.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxa.dao.AppointmentDao;
import com.xxa.dao.BookDao;
import com.xxa.dto.AppointExecution;
import com.xxa.entity.Appointment;
import com.xxa.entity.Book;
import com.xxa.enums.AppointStateEnum;
import com.xxa.exception.AppointException;
import com.xxa.exception.NoNumberException;
import com.xxa.exception.RepeatAppointException;
import com.xxa.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao;
    @Autowired
	private AppointmentDao appointmentDao;
	@Override
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		// TODO Auto-generated method stub
		return bookDao.queryAll(0, 4);
	}

	@Override
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			//库存不足
			int update = bookDao.reduceNumber(bookId);
			if(update<=0) {
				throw new NoNumberException("no number");
			}
			int insert = appointmentDao.insertApponintment(bookId, studentId);
			if(insert<=0) {
				//重复预约
				throw new RepeatAppointException("repeat appoint");
			}else {
				//预约成功
				Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
                return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
			}
			
			 // 要先于catch Exception异常前先catch住再抛出，不然自定义的异常也会被转换为AppointException，导致控制	
		} catch (NoNumberException  e1) {
			throw e1;
		}catch(RepeatAppointException  e2) {
			throw e2;
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			 throw new AppointException("appoint inner error:" + e.getMessage());
		}
		
	}

}
