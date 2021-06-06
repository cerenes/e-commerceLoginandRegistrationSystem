package Business.concretes;
import java.util.List;


import Business.abstracts.UserService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManager implements UserService {
	private final UserDao userDao;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

	@Override
	public boolean getByEMail(String email) {
		
		 List<User> users = userDao.getAll();
	        return users.stream().anyMatch(
	                user -> user.getEmail().contains(email)
	        );
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void update(User user) {
		
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		
	}
	

}
