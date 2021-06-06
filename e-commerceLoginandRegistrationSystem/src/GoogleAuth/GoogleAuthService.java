package GoogleAuth;

import Entities.concretes.User;

public interface GoogleAuthService {
	 boolean register(User user);
	 boolean login(User user);

}
