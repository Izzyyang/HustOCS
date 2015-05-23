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
		Tear tear = tDao.view("0001");
		
		LessonDao ld = new LessonDao();
		Lesn lesson = new Lesn();
		lesson.setTear(tear);
		lesson.setId("0001");
		lesson.setBrief("111111111111");
		lesson.setStatus(new Short("1"));
		ld.insert(lesson);
		ld.view("0001");
		
		System.out.println();
	}

}
