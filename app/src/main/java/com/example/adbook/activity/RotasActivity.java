package com.example.adbook.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

import com.example.adbook.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class RotasActivity extends AppCompatActivity implements OnMapReadyCallback {

    FusedLocationProviderClient client;
    GoogleMap mMap;

    Bundle bundle = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotas);
        bundle = getIntent().getExtras();
        client = LocationServices.getFusedLocationProviderClient(this);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ActionBar acb = getSupportActionBar();

        if(acb != null){
            acb.hide();
        }

    }

    @Override
    public void onResume() {
        super.onResume();

        int errorCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        switch (errorCode){
            case ConnectionResult.SERVICE_MISSING:
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
            case ConnectionResult.SERVICE_DISABLED:
                GoogleApiAvailability.getInstance().getErrorDialog(this, errorCode, 0, new DialogInterface.OnCancelListener(){
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                }).show();
                break;
            case ConnectionResult.SUCCESS:
                Log.d("Check GP", "Google play services up-to-date");
                break;
        }



        client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if(location != null){

                    LatLng origin = new LatLng(location.getLatitude(), location.getLongitude());
                    LatLng destino = new LatLng(bundle.getDouble("lat"), bundle.getDouble("long"));
                    mMap.addMarker(new MarkerOptions().position(origin).title("Estou aqui"));
                    mMap.addMarker(new MarkerOptions().position(destino).title("Anuncio"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destino, 14.0f));
                }else {
                    Log.i("Teste", "null");
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        final LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(15 * 1000);
        locationRequest.setFastestInterval(5 * 1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(builder.build())
                .addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        Log.i("Teste", locationSettingsResponse.getLocationSettingsStates().isNetworkLocationPresent()+ " ");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if(e instanceof ResolvableApiException){
                    try {
                        ResolvableApiException resolvableApiException = (ResolvableApiException) e;
                        resolvableApiException.startResolutionForResult( RotasActivity.this, 10);
                    }catch (IntentSender.SendIntentException e1){

                    }
                }
            }
        });

        final LocationCallback locationCallback = new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if(locationResult == null){
                    Log.i("Teste 2 ", "Local is null");
                }

                for(Location location: locationResult.getLocations()){
                    Log.i("Teste 2", location.getLatitude() +" "+ location.getLongitude());
                }
            }

            @Override
            public void onLocationAvailability(LocationAvailability locationAvailability) {
                Log.i("Teste", locationAvailability.isLocationAvailable() +" ");
            }
        };

        client.requestLocationUpdates(locationRequest, locationCallback, null);


    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(20.0f);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

    }
}
