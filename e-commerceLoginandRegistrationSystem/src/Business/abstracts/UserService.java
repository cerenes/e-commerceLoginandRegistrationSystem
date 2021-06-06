package Business.abstracts;

import Entities.concretes.User;

public interface UserService {
	boolean getByEMail(String email);
	
	void add(User user);
	void update(User user);
	void delete(User user);

}
