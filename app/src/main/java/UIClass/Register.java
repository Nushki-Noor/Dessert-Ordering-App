package UIClass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobileapp.R;

import Adapters.UserClass;
import Database.DBHelper;

public class Register extends AppCompatActivity {

    EditText EditTextUsername, EditTextPass, EditTextConfirmPass;

    Button buttonRegister;

    Spinner regSpinner;

    private DBHelper dbHelper;

    String UserType[]={"Admin","User"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditTextUsername=(EditText) findViewById(R.id.txtRegUsername);
        EditTextPass=(EditText) findViewById(R.id.txtRegPass);
        EditTextConfirmPass=(EditText) findViewById(R.id.txtRegConfirmPass);
        regSpinner=(Spinner) findViewById(R.id.regSpinner);
        buttonRegister=(Button) findViewById(R.id.btnRegister);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        regSpinner.setAdapter(ad);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditTextUsername.getText().toString().isEmpty() ||
                        EditTextPass.getText().toString().isEmpty() ||
                        EditTextConfirmPass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Field's cant be Empty",Toast.LENGTH_LONG).show();
                }
                else if (EditTextPass.getText().toString().length()<3)
                {
                    Toast.makeText(getApplicationContext(),"Password should have more than 5 characters",Toast.LENGTH_LONG).show();
                }
                else if (!EditTextPass.getText().toString().equals(EditTextConfirmPass.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Both Password and Confirm Password Should Match",Toast.LENGTH_LONG).show();
                }
                else
                {
                    UserClass userClass =  new UserClass(EditTextUsername.getText().toString(),EditTextPass.getText().toString(),regSpinner.getSelectedItem().toString());

                    if (dbHelper.CreateNewUser(userClass)){
                        Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(),EditTextUsername.getText().toString()+" has login as " +
                                        regSpinner.getSelectedItem().toString(),
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"User Creation Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}