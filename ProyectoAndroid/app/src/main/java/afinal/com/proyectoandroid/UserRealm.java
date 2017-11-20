package afinal.com.proyectoandroid;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Janis on 9/11/2017.
 */

public class UserRealm  extends RealmObject {
    @PrimaryKey
    private String id;
    private String username;
    private String password;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "User{" +"name='" + getUsername() + '\'' +'}';
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
}

