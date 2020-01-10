package ObservePattern;

class LoginEvent {
    private String userName;
    private String Password;

    public LoginEvent() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

class LoginBean {
    private LoginEventListener loginEventListener;
    private LoginEvent loginEvent;

    public LoginBean() {
        //TODO implement contructor
    }

    public addLoginEventListener(LoginEventListener lel){
        this.loginEventListener = lel;
    }

    public void fireLoginEvent(Object object, String userName, String password){

    }

    public void actionPerformed(LoginEvent event) {
    }

}

interface LoginEventListener{
    void validateLogin(LoginEvent event);
}

class LoginValidator implements LoginEventListener {

    public LoginValidator() {
    }

    @Override
    public void validateLogin(LoginEvent event) {
        // TODO Auto-generated method stub
    }

}
class LoginValidatorA implements LoginEventListener{

	public LoginValidatorA() {
	}

	@Override
	public void validateLogin(LoginEvent event) {
		// TODO Auto-generated method stub
	}

}

class LoginValidatorB implements LoginEventListener{
    public LoginValidatorB(){
    }

	@Override
	public void validateLogin(LoginEvent event) {
		// TODO Auto-generated method stub
	}
}
