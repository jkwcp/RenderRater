package ca.bcit.renderrater;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FirebaseAdapter extends ArrayAdapter<Properties> {

    private Activity context;
    private List<Properties> propertyList;


    public FirebaseAdapter(Activity context, List<Properties> propertyList) {
        super(context, R.layout.list_layout, propertyList);
        this.context = context;
        this.propertyList = propertyList;
    }

    public FirebaseAdapter(Context context, int resource, List<Properties> property, Activity context1, List<Properties> propertyList) {
        super(context, resource, property);
        this.context = context1;
        this.propertyList = propertyList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView tvStreetName = listViewItem.findViewById(R.id.textViewStreet);
        return listViewItem;

    }

}