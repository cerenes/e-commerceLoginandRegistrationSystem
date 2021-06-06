package DataAccess.abstracts;

import java.util.List;

import Entities.concretes.User;

public interface UserDao {
	List<User> getAll();

    void add(User user);
    void update(User user);
    void delete(User user);

}
