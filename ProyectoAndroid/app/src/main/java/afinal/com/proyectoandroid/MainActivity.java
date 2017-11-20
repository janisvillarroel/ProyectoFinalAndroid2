package afinal.com.proyectoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private SessionManager session;
    private Realm myRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void login(View view) {
        this.myRealm = Realm.getDefaultInstance();
        session = new SessionManager(getApplicationContext());
        int cont=0;
        EditText user = (EditText) findViewById(R.id.txtUser);
        EditText pass = (EditText) findViewById(R.id.txtPassword);
        TextView message = (TextView) findViewById(R.id.textMessage);
        if (user.getText().toString().isEmpty()){
            message.setText(R.string.placeUser);
        }else if (pass.getText().toString().isEmpty()){
            message.setText(R.string.placePassword);
        }else {
               int exists=0;
               RealmResults<UserRealm> list = this.myRealm.where(UserRealm.class).findAll();
                for (UserRealm u : list) {
                    exists=0;
                    if(u.getUsername().equalsIgnoreCase(user.getText().toString())){
                       exists++;
                   }
                   if(u.getPassword().equalsIgnoreCase(pass.getText().toString())){
                       exists++;
                   }
                   if(exists == 2)
                       break;
                }
            if (exists !=2 ) {
                message.setText(R.string.incorrectCredentials);
            }else{
                cont = 1;
            }
        }
        if (cont == 1 ) {
            session.saveUser(new User(user.getText().toString(), pass.getText().toString()));
            user.setText("");
            pass.setText("");
            Intent i = new Intent(this, PrincipalPage.class);
            startActivity(i);
        }
    }

    public void register(View view) {
        Intent i = new Intent(this, Registration.class);
        startActivity(i);
    }
}
