package Core.Adapters;

import Entities.concretes.User;

public interface AuthServiceExternal {
	void login(User user);
	void register(User user);

}
