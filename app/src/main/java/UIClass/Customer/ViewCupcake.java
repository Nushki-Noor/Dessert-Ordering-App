package UIClass.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobileapp.R;

import java.util.ArrayList;
import java.util.List;

import Adapters.CakeSingleRow;
import Adapters.CupcakeClass;
import Database.DBHelper;

public class ViewCupcake extends AppCompatActivity {

    ListView CupcakeListView;
    EditText EditTextbuyID;
    Button buttonBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cupcake);
        CupcakeListView = findViewById(R.id.cupcakeListView);

        String username = getIntent().getStringExtra("username");

        EditTextbuyID = findViewById(R.id.txtBuyID);
        buttonBuy = findViewById(R.id.btnBuyCups);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        String categoryID = getIntent().getStringExtra("CategoryID");

        List<CupcakeClass> selectCupcake = dbHelper.getSelectCake(categoryID);
        CakeSingleRow adapter = new CakeSingleRow(getApplicationContext(),R.layout.cake_single_row,selectCupcake);
        CupcakeListView.setAdapter(adapter);

        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cupid = EditTextbuyID.getText().toString().trim();
                if (cupid.isEmpty()) {
                    Toast.makeText(ViewCupcake.this, "Please enter Cupcake ID", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(ViewCupcake.this, buyCupcake.class);
                    intent.putExtra("cup", cupid);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }
}
