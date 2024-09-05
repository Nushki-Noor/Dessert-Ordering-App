package UIClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.R;

import java.util.ArrayList;

import Adapters.UserClass;
import Database.DBHelper;
import UIClass.Admin.Admin;
import UIClass.Customer.CustomerClass;

public class Login extends AppCompatActivity {

    EditText EditTextUsername,EditTextPassword;
    Button ButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditTextUsername=(EditText) findViewById(R.id.txtUsername);
        EditTextPassword=(EditText) findViewById(R.id.txtPassword);
        ButtonLogin=(Button) findViewById(R.id.btnLogin);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = EditTextUsername.getText().toString();

                ArrayList<UserClass> userDetails= dbHelper.ValidLogin(username, EditTextPassword.getText().toString());

                if (userDetails.size()!=0)
                {
                    UserClass user=userDetails.get(0);
                    String userType=user.getUserType();

                    Toast.makeText(getApplicationContext(), "Login Successfull "+userType, Toast.LENGTH_LONG).show();
                    if(userType.equals("Admin"))
                    {
                        Intent intentRegister = new Intent(Login.this, Admin.class);
                        startActivity(intentRegister);
                    }
                    else
                    {
                        Intent intentRegister = new Intent(Login.this, CustomerClass.class);
                        intentRegister.putExtra("username", username);
                        startActivity(intentRegister);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}