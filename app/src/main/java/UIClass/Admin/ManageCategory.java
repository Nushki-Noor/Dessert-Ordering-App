package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapp.R;

public class ManageCategory extends AppCompatActivity {

    Button buttonCreateCat, buttonDeleteCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_category);

        buttonCreateCat= findViewById(R.id.btncrtCupcake);
        buttonDeleteCat= findViewById(R.id.btndltCupcake);

        buttonCreateCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(ManageCategory.this, CreateCategory.class);
                startActivity(intentRegister);
            }
        });

        buttonDeleteCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(ManageCategory.this, DeleteCategory.class);
                startActivity(intentRegister);
            }
        });
    }
}