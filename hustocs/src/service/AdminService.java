package service;
import dao.AdminDaoer;
import dao.LessonDaoer;
import dao.ResourceDaoer;

public class AdminService extends AbstractUserService implements AdminServicer {
	private AdminDaoer adminDao;
	private LessonDaoer lessonDao;
	private ResourceDaoer resourceDao;
	public AdminDaoer getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDaoer adminDao) {
		this.adminDao = adminDao;
	}
	public LessonDaoer getLessonDao() {
		return lessonDao;
	}
	public void setLessonDao(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}
	public ResourceDaoer getResourceDao() {
		return resourceDao;
	}
	public void setResourceDao(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}
	public AdminService(AdminDaoer adminDao) {
		this.adminDao = adminDao;
	}
	public AdminService(LessonDaoer lessonDao) {
		this.lessonDao = lessonDao;
	}
	public AdminService(ResourceDaoer resourceDao) {
		this.resourceDao = resourceDao;
	}
	@Override
	public String regster(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String login(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(UserServicer user) {
		// TODO Auto-generated method stub
		return false;
	}
}
