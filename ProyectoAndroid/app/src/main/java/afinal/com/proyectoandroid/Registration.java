package afinal.com.proyectoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;
import io.realm.Realm;

public class Registration extends AppCompatActivity {
    private Realm myRealm;
    private EditText user;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void save(View view) {
        this.myRealm = Realm.getDefaultInstance();
        int cont=0;
        user = (EditText) findViewById(R.id.txtUserReg);
        pass = (EditText) findViewById(R.id.txtPasswordReg);
        TextView message = (TextView) findViewById(R.id.textMessageReg);
        if (user.getText().toString().isEmpty()){
            message.setText(R.string.placeUser);
        }else if (pass.getText().toString().isEmpty()){
            message.setText(R.string.placePassword);
        }else {
            cont = 1;
        }
        if (cont == 1 ) {
            this.myRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    UserRealm usuario = realm.createObject(UserRealm.class, UUID.randomUUID().toString());
                    usuario.setUsername(user.getText().toString());
                    usuario.setPassword(pass.getText().toString());
                }
            });
            message.setText(R.string.successUser);
            user.setText("");
            pass.setText("");
        }
    }
}
