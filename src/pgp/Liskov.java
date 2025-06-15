package pgp;

import java.util.Collection;
import java.util.LinkedList;

class User {
    private static int ID = 0;
    protected String _username;
    protected String _email;
    protected final int _id;

    public User(String username, String email) {
        assert (username != null);
        assert (email != null);

        this._username = username;
        this._email = email;
        this._id = ID++;
    }

    /**
     * Get the username of this user. This will never be null!
     */
    public String getUsername() {
        return this._username;
    }

    /**
     * Get the email of this user. This will never be null!
     */
    public String getEmail() {
        return this._email;
    }

    /**
     * returns generated ID of this user
     */
    public int getID() {
        return this._id;
    }
}

class NoUsernameException extends RuntimeException {
    public NoUsernameException() {
        super("Not registered user has no username");
    }
}
/*
class NoEmailException extends RuntimeException {
    public NoEmailException() {
        super("Not registered user has no email");
    }
}*/

class NotRegisteredUser extends User {

    public NotRegisteredUser() {
        super("No username", "No email");
    }
    // return default value instead exception
    @Override
    public String getUsername() {
        //throw new NoUsernameException();
        return this._username;
    }

    // return email instead exception
    @Override
    public String getEmail() {
        //throw new NoEmailException();
        return this._email;
    }
}

class EnterpriseUser extends User {
    private String _personalAssistant;

    public EnterpriseUser(String username, String personalAssistant) {
        super(username, "No email");
        //this._email = null; ->_email cannot be null, using "No email" instead.
        this._personalAssistant = personalAssistant;
    }

    public String getPersonalAssistant() {
        return this._personalAssistant;
    }
    @Override
    public String getEmail(){
        return "No email";
    }
}


public class Liskov {
    public static void main(String[] args) {
        final Collection<User> users = new LinkedList<>();
        users.add(new EnterpriseUser("enterprise-customer", "CEO"));
        users.add(new User("max", "max.mustermann@mail.io"));
        users.add(new NotRegisteredUser());

        for (final User user : users) {
            try {
                System.out.println(user.getUsername() + " (" + user.getID() + ")");
            } catch (NoUsernameException e) {
                System.err.println("Cannot print user with ID " + user.getID());
            }

        }
    }
}