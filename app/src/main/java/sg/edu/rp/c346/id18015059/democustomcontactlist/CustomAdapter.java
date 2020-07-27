package sg.edu.rp.c346.id18015059.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;
    ArrayList<Contact> alPeople;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects1, ArrayList<Contact> objects2){
        super(context, resource, objects1);
        parent_context = context;
        layout_id = resource;
        contactList = objects1;
        alPeople = objects2;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);


        // Set values to the TextView to display the corresponding information
        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum() + "");

        Contact p = alPeople.get(position);
        if(p.getGender() == "M" || p.getGender() == "M"){
            ivGender.setImageResource(R.drawable.male);
        }
        else {
            ivGender.setImageResource(R.drawable.female);
        }
        return rowView;
    }

}
