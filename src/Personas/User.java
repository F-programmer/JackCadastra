package Personas;

public class User extends Cliente{

	// implementando singleton
	// protecao EXTREMA com multiplas instancias
	// coisa lindaaaa
	private static User instance;

	public static synchronized User getInstance(String[] values, boolean admin) throws Exception {
		if (instance == null) {
			instance = new User(values, admin);
		}
		return instance;
  }
	public static synchronized User getInstance() throws Exception {
		return instance;
  }
  
  private User() {}
  private User(String[] values, boolean admin) throws Exception {
    super(values, true);
    adminUser = admin;
  }

  private boolean adminUser;
  public boolean isAdmin() {
    return adminUser;
  }
}
