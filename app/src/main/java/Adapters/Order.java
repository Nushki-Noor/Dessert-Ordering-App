package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobileapp.R;

import java.util.List;

public class Order extends ArrayAdapter<InvoiceClass> {
    private Context context;
    private  int resource;
    private List<InvoiceClass> invoiceClassList;


    public Order(@NonNull Context context, int resource,List<InvoiceClass> invoiceClassList) {
        super(context, resource,invoiceClassList);
        this.context = context;
        this.resource = resource;
        this.invoiceClassList = invoiceClassList;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView txtCustOrdID,txtOrdCustCupID,txtCustOrdName,txtCustOrdQty,txtCustOrdTotal;

        txtCustOrdID = row.findViewById(R.id.txtCustOrdID);
        txtOrdCustCupID = row.findViewById(R.id.txtOrdCustCupID);
        txtCustOrdName = row.findViewById(R.id.txtCustOrdName);
        txtCustOrdQty = row.findViewById(R.id.txtCustOrdQty);
        txtCustOrdTotal = row.findViewById(R.id.txtCustOrdTotal);

        InvoiceClass invoiceClass = invoiceClassList.get(position);

        txtCustOrdID.setText(invoiceClass.getOrderId());
        txtOrdCustCupID.setText(invoiceClass.getCupcakeId());
        txtCustOrdName.setText(invoiceClass.getUserName());
        txtCustOrdQty.setText(String.valueOf(invoiceClass.getQuantity()));
        txtCustOrdTotal.setText(String.valueOf(invoiceClass.getTotal()));

        return row;
    }
}