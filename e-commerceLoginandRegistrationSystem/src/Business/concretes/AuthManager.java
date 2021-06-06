package Business.concretes;

import java.util.Locale;

import Business.Validations.LoginValidation;
import Business.Validations.RegisterValidation;
import Business.abstracts.AuthService;
import Business.abstracts.UserService;
import Core.Adapters.AuthServiceExternal;
import Entities.concretes.User;

public class AuthManager implements AuthService {
	 private final UserService userService;
	 private final AuthServiceExternal authServiceExternal;

	    public AuthManager(UserService userService, AuthServiceExternal authServiceExternal){
	        this.userService = userService;
	        this.authServiceExternal = authServiceExternal;
	    }

	@Override
	public void login(User user) {
		 boolean validationResult = LoginValidation.checkValidate(user);
	        if (!validationResult) {
	           
	            System.out.println("Giriþ baþarýsýz oldu");
	            return;
	        }

	        if (!user.checkActivationCode()){
	            System.out.println("Giriþ baþarýsýz oldu");
	            System.out.println("Aktivasyon kodunu onaylamadan giriþ yapýlamaz");
	            return;
	        }

	        System.out.println("Giriþ baþarýlý oldu");
		
	}

	@Override
	public void register(User user) {
		boolean validationResult = RegisterValidation.checkValidate(user);
        if (!validationResult) return;

        boolean userExists = userService.getByEMail(user.getEmail().toLowerCase(Locale.ROOT));
        if (userExists) {
            System.out.println("Bu email adresi mevcut lütfen farklý bir adres deneyin");
            return;
        }

        userService.add(user);
        System.out.println("Kayýt baþarýlý oldu");
        user.setActivateCode("ceren111");
        System.out.println("Doðrulama maili E-Postanýza gönderildi. ");
		
		
	}
	public void registerWithGoogle(User user){
        authServiceExternal.register(user);

        user.setActivateCode("esra111");
        System.out.println("Doðrulama maili E-Postanýza gönderildi.");
    }

    public void loginWithGoogle(User user){
        if (!user.checkActivationCode()){
            System.out.println("Giriþ baþarýsýz oldu");
            System.out.println("Aktivasyon kodunu onaylamadan giriþ yapýlamaz");
            return;
        }

        authServiceExternal.login(user);
    }

}
