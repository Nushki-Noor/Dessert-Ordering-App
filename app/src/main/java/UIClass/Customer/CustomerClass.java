package UIClass.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mobileapp.R;

public class CustomerClass extends AppCompatActivity {

    Button buttonOrderCupCakes, buttonViewOrder1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_class);

        buttonOrderCupCakes = findViewById(R.id.btnOrderCupcake);
        buttonViewOrder1 = findViewById(R.id.btnViewOrder1);

        String username = getIntent().getStringExtra("username");

        buttonOrderCupCakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(CustomerClass.this, CustCategory.class);
                intentRegister.putExtra("username", username);
                startActivity(intentRegister);
            }
        });

        buttonViewOrder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(CustomerClass.this, CustViewOrder.class);
                intentRegister.putExtra("username", username);
                startActivity(intentRegister);
            }
        });

    }
}