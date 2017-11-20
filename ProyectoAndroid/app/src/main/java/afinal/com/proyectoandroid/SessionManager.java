package afinal.com.proyectoandroid;

/**
 * Created by Janis on 8/11/2017.
 */
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private static final String PREF_NAME = "DoguiApp";
    private Context _context;
    private int PRIVATE_MODE = 0;
    private String KEY_USER = "user";

    public SessionManager(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveUser(User u) {
        Gson gson = new Gson();
        String user_json = gson.toJson(u);
        editor.putString(KEY_USER, user_json);
        editor.commit();
    }

    public User getUser() {
        Gson gson = new Gson();
        User u = gson.fromJson(pref.getString(KEY_USER,null), User.class);
        return u;
    }

}
