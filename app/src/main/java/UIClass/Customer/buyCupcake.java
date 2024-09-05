package UIClass.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.R;

import java.util.List;

import Adapters.CupcakeClass;
import Adapters.InvoiceClass;
import Database.DBHelper;

public class buyCupcake extends AppCompatActivity {

    EditText EditTextCupcakeID, EditTextCupcakeName, EditTextCupcakeQty, EditTextCupcakePrice, EditTextInvoiceID, EditTextReqQty;
    Button buttonPurchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_cupcake);

        EditTextCupcakeID= findViewById(R.id.txtCupGetID);
        EditTextCupcakeName= findViewById(R.id.txtCupGetName);
        EditTextCupcakeQty= findViewById(R.id.txtCupGetQty);
        EditTextCupcakePrice= findViewById(R.id.txtCupGetPrice);

        EditTextInvoiceID= findViewById(R.id.txtInvoiceID);
        EditTextReqQty= findViewById(R.id.txtReqQty);
        buttonPurchase= findViewById(R.id.btnPurchase);

        String cup = getIntent().getStringExtra("cup");

        String username = getIntent().getStringExtra("username");

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        List<CupcakeClass> buyCakeDetails = dbHelper.getBuyCakeDetails(cup);

        CupcakeClass cupcakeClass = buyCakeDetails.get(0);

        EditTextCupcakeID.setText(cupcakeClass.getCupcakeID());
        EditTextCupcakeName.setText(cupcakeClass.getCupcakeName());
        EditTextCupcakeQty.setText(String.valueOf(cupcakeClass.getCupcakeQuantity()));
        EditTextCupcakePrice.setText(String.valueOf(cupcakeClass.getCupcakePrice()));

        buttonPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String invoiceId = EditTextInvoiceID.getText().toString();
                String cupcakeId = EditTextCupcakeID.getText().toString();
                int buyQty = Integer.parseInt(EditTextReqQty.getText().toString());
                String price = EditTextCupcakePrice.getText().toString();
                int intPrice = Integer.parseInt(price);
                String name = EditTextCupcakeName.getText().toString();

                if (invoiceId.isEmpty() || EditTextReqQty.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fields cannot be blank", Toast.LENGTH_SHORT).show();

                }
                else {
                    dbHelper.buyCupcake(cupcakeId,buyQty);

                    int Total = intPrice * buyQty;

                    InvoiceClass invoiceClass = new InvoiceClass(invoiceId, cupcakeId, username, buyQty,Total);

                    if (dbHelper.addOrder(invoiceClass)) {
                        Toast.makeText(getApplicationContext(), "Cupcake : "+ name + ", Total price is Rs. "+Total , Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(),CustomerClass.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Error Buying Product", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}