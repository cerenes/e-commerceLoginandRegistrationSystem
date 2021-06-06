package DataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public List<User> getAll() {
		User user = new User(1, "Ceren", "Esirgenci", "ceren@ceren.com", "123456");
        List<User> users = new ArrayList<>();
        users.add(user);

        return users;
		
	}

	@Override
	public void add(User user) {
		 System.out.println("Hibernate ile eklendi, " + user.getFirstName());
		
	}

	@Override
	public void update(User user) {
		
		 System.out.println("Hibernate ile güncellendi, " + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		
		 System.out.println("Hibernate ile silindi, " + user.getFirstName());
	}

}
