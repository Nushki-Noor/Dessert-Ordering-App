package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobileapp.R;

import java.util.Vector;

import Adapters.CupcakeClass;
import Database.DBHelper;

public class CreateCupcake extends AppCompatActivity {

    EditText EditTextCupcakeID, EditTextCupcakeName, EditTextCupcakePrice, EditTextCupcakeQuantity;

    Button buttonAddCupcake;

    Spinner spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cupcake);

        EditTextCupcakeID= findViewById(R.id.txtCupID);
        EditTextCupcakeName= findViewById(R.id.txtCupName);
        EditTextCupcakePrice= findViewById(R.id.txtCupPrice);
        EditTextCupcakeQuantity= findViewById(R.id.txtCupQuantity);
        spinnerCategory= findViewById(R.id.spinnerCategory);
        buttonAddCupcake= findViewById(R.id.btnAddCup);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        Vector<String> categoryName = dbHelper.getCategoryName();

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,categoryName);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(ad);


        buttonAddCupcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EditTextCupcakeID.getText().toString().isEmpty() ||
                        EditTextCupcakeName.getText().toString().isEmpty()||
                        EditTextCupcakePrice.getText().toString().isEmpty() ||
                        EditTextCupcakeQuantity.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields cannot be Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    String categoryId = dbHelper.getCategoryID(spinnerCategory.getSelectedItem().toString());

                    CupcakeClass cupcake = new CupcakeClass(
                            EditTextCupcakeID.getText().toString(),
                            EditTextCupcakeName.getText().toString(),
                            Integer.parseInt(EditTextCupcakePrice.getText().toString()),
                            Integer.parseInt(EditTextCupcakeQuantity.getText().toString()),
                            categoryId);

                    if (dbHelper.CreateNewCupcake(cupcake)) {
                        Toast.makeText(getApplicationContext(),"Cupcake Added",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Failed Adding a Cupcake",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
