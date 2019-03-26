package ca.bcit.renderrater;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMapClickListener,
        OnMapReadyCallback {

    private static final String TAG = "MainActivity";

    private GoogleMap mMap;
    private LinearLayout infoPanel;
    private TextView title;

    public static ArrayList<String> addressList;
    List<Feature> featureList;
    DatabaseReference databaseFeatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseFeatures = FirebaseDatabase.getInstance().getReference("features");
        featureList = new ArrayList<Feature>();
        addressList = new ArrayList<String>();



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        infoPanel = (LinearLayout) findViewById(R.id.infoSection);
        infoPanel.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.lvTitle);

        ListView listAddress = findViewById(R.id.lvProperties);

        listAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    Intent intent = new Intent (MainActivity.this, RentalDescriptionActivity.class);
                    intent.putExtra("BLDGID", featureList.get(position).properties);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        databaseFeatures.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                //Log.d(TAG, "onDataChange: " + dataSnapshot.getValue(Properties.class));
                Log.d(TAG, "onDataChange: " + dataSnapshot.getChildrenCount());



                for (DataSnapshot featureSnapshot : dataSnapshot.getChildren()) {
//                    Log.d(TAG, "onDataChange: " + featureSnapshot.child("properties").getValue(Properties.class).getSTRNUM() + " "
//                            + featureSnapshot.child("properties").getValue(Properties.class).getSTRNAM());
                    Feature feature = new Feature();
                    feature.properties = featureSnapshot.child("properties").getValue(Properties.class);
                    featureList.add(feature);

                    String address = feature.properties.getSTRNUM() + " "
                            + feature.properties.getSTRNAM();

                    addressList.add(address);

                    Log.d(TAG, "onDataChange: " + feature.properties.getSTRNUM() + " "
                            + feature.properties.getSTRNAM());


                }

                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, addressList);
                ListView listView = findViewById(R.id.lvProperties);
                listView.setAdapter(itemsAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        CameraPosition googlePlex = CameraPosition.builder()
                .target(new LatLng(-34,151))
                .zoom(14)
                .bearing(0)
                .tilt(45)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null);

        LatLng gir = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(gir));

        ArrayList<MarkerOptions> markerList = new ArrayList<>();
        ArrayList<LatLng> girs = new ArrayList<>();

        girs.add(gir);
        girs.add(new LatLng(-34.01, 151.02));
        girs.add(new LatLng(-34.02, 150.95));

        for(int i = 0; i < 3; i++){
            markerList.add(new MarkerOptions()
                    .position(girs.get(i))
                    .title(i + " "));
        }



        mMap.addMarker(markerList.get(0));
        mMap.addMarker(markerList.get(1));
        mMap.addMarker(markerList.get(2));

        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker){
        infoPanel.setVisibility(View.VISIBLE);
        String titleText = marker.getTitle();
        title.setText(titleText);



        return false;
    }

    @Override
    public void onMapClick(LatLng latLng){
        infoPanel.setVisibility(View.GONE);


    }


}
