package UIClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapp.R;

public class MainActivity extends AppCompatActivity {

    Button buttonRegister,buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister=(Button) findViewById(R.id.RegBtn);
        buttonLogin=(Button) findViewById(R.id.LogBtn);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(MainActivity.this, Register.class);
                startActivity(intentRegister);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intentLogin = new Intent(MainActivity.this,Login.class);
                startActivity(intentLogin);
            }
        });
    }
}