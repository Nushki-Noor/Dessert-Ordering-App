package UIClass.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.mobileapp.R;

import java.util.ArrayList;

import Database.DBHelper;

public class CustCategory extends AppCompatActivity {

    ListView CategoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_category);

        String username = getIntent().getStringExtra("username");

        CategoryListView = findViewById(R.id.categoryListView);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        ArrayList<String> allCategory = dbHelper.getAllCategory();
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, allCategory);
        CategoryListView.setAdapter(listAdapter);

        CategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String categoryId = "00" + String.valueOf(position + 1);

                Intent intent = new Intent(getApplicationContext(), ViewCupcake.class);
                intent.putExtra("CategoryID", categoryId);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}