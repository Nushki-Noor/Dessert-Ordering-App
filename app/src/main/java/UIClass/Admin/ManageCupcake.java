package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapp.R;

public class ManageCupcake extends AppCompatActivity {

    Button buttonCreateCupcake, buttonDeleteCupcake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cupcake);

        buttonCreateCupcake= findViewById(R.id.btncrtCupcake);
        buttonDeleteCupcake= findViewById(R.id.btndltCupcake);

        buttonCreateCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(ManageCupcake.this, CreateCupcake.class);
                startActivity(intentRegister);
            }
        });

        buttonDeleteCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(ManageCupcake.this, DeleteCupcake.class);
                startActivity(intentRegister);
            }
        });
    }
}