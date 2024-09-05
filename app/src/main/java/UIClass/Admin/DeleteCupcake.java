package UIClass.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mobileapp.R;

import Database.DBHelper;

public class DeleteCupcake extends AppCompatActivity {

    EditText EditTextCupDelete;

    Button buttonCupDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cupcake);

        EditTextCupDelete= findViewById(R.id.txtCupDelete);
        buttonCupDelete= findViewById(R.id.btnCupDelete);

        DBHelper dbHelper = new DBHelper(getApplicationContext());
        dbHelper.OpenDB();

        buttonCupDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CupcakeID= EditTextCupDelete.getText().toString();

                if (CupcakeID.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter the Cupcake ID", Toast.LENGTH_LONG).show();
                }
                else {
                    dbHelper.deleteCupcake(CupcakeID);
                    Toast.makeText(getApplicationContext(),CupcakeID+" ID is Deleted", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), ManageCupcake.class);
                    startActivity(intent);
                }
            }
        });
    }
}