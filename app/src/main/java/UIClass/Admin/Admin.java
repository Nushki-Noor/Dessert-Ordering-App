package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapp.R;

import UIClass.Customer.CustViewOrder;

public class Admin extends AppCompatActivity {
    Button buttonManageCat, buttonManageCup, buttonViewOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        buttonManageCat = findViewById(R.id.btnManageCat);
        buttonManageCup = findViewById(R.id.btnManageCup);
        buttonViewOrder = findViewById(R.id.btnViewOrder);

        buttonManageCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Admin.this, ManageCategory.class);
                startActivity(intentRegister);
            }
        });

        buttonManageCup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Admin.this, ManageCupcake.class);
                startActivity(intentRegister);
            }
        });

        buttonViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(Admin.this, ViewOrder.class);
                startActivity(intentRegister);
            }
        });
    }

}