package time.tv.roles;

/**
 * Created by myname on 04.02.17.
 */
public class Role {
    public String username;
    public String password;
    public String role;

    public Role(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String toString() {
        return username + " : " + password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

