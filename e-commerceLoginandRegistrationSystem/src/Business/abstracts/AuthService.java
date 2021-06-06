package Business.abstracts;

import Entities.concretes.User;

public interface AuthService {
	void login(User user);
	void register(User user);

}
