package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mobileapp.R;

import java.util.List;

import Adapters.InvoiceClass;
import Adapters.Order;
import Database.DBHelper;

public class ViewOrder extends AppCompatActivity {

    ListView AdminOrderListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        AdminOrderListView=findViewById(R.id.AdminorderListView);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        List<InvoiceClass> allOrders = dbHelper.getAllOrders();

        Order adapter = new Order(getApplicationContext(),R.layout.order_single_row,allOrders);
        AdminOrderListView.setAdapter(adapter);
    }
}
