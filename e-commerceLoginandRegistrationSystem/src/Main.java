import Business.concretes.AuthManager;
import Business.concretes.UserManager;
import Core.Adapters.GoogleAuthManagerAdapter;
import DataAccess.concretes.HibernateUserDao;
import Entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		 User user = new User(1, "ceren", "esirgenci", "ceren@ceren.com", "123456");
	        AuthManager authManager = new AuthManager(
	                new UserManager(new HibernateUserDao()),
	                new GoogleAuthManagerAdapter()
	        );
	        
	       
	        authManager.register(user);
	       
	        user.setConfirmActivationCode("ceren111");
	        
	        authManager.login(user);

	}

}
