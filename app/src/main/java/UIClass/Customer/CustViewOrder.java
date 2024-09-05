package UIClass.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mobileapp.R;

import java.util.List;

import Adapters.InvoiceClass;
import Adapters.Order;
import Database.DBHelper;

public class CustViewOrder extends AppCompatActivity {

    ListView CustViewOrderLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_view_order);

        CustViewOrderLV= findViewById(R.id.custViewOrderLV);

        String username = getIntent().getStringExtra("username");

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        List<InvoiceClass> custOrder = dbHelper.getAllCustOrder(username);

        Order adapter = new Order(getApplicationContext(),R.layout.order_single_row,custOrder);
        CustViewOrderLV.setAdapter(adapter);
    }
}
