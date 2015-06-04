package util;

import java.sql.Timestamp;

import dao.LessonDao;
import dao.TeacherDao;
import entity.Lesn;
import entity.Tear;

public class TestYang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TeacherDao tDao = new TeacherDao();
		Tear tear = tDao.view("1");
		System.out.println(tear.getId());
		LessonDao ld = new LessonDao();
//		Lesn lesson = new Lesn();
//		lesson.setTear(tear);
//		lesson.setId("2");
//		lesson.setBrief("111111111111");
//		lesson.setStatus(new Short("1"));
//		lesson.setTitle("222222");
//		Timestamp dTimestamp = new Timestamp(System.currentTimeMillis());
//		lesson.setTime(dTimestamp);
//		ld.insert(lesson);
//		ld.view("1");
		
		System.out.println();
	}

}
