package Core.Adapters;

import Entities.concretes.User;
import GoogleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthServiceExternal {
	private final GoogleAuthManager googleAuthManager;
	
	public GoogleAuthManagerAdapter() {
        this.googleAuthManager = new GoogleAuthManager();
    }

	@Override
	public void login(User user) {
		
		 googleAuthManager.register(user);
	}

	@Override
	public void register(User user) {
		
		googleAuthManager.login(user);
	}

}
