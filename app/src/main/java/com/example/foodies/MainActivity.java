package com.example.foodies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.foodies.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // db variables
    public EditText name;
    public Button query_button;
    public TextView restName_;
    public TextView price_;
    public TextView tagline_;
    public TextView distance_;
    public TextView typeArr_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // db info
        name = findViewById(R.id.name);
        query_button = findViewById(R.id.query_button);
        restName_ = findViewById(R.id.restName);
        price_ = findViewById(R.id.price);
        tagline_ = findViewById(R.id.tagline);
        distance_ = findViewById(R.id.distance);
        typeArr_ = findViewById(R.id.typeArr);

        query_button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                // create instance of db access class & open db
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                // get string from EditText
                String n = name.getText().toString();
                dbData myDBData = databaseAccess.getData(n);

                // put data from db into result field (will be new page)
                restName_.setText(String.valueOf(myDBData.restName));
                price_.setText(String.valueOf(myDBData.price));
                tagline_.setText(String.valueOf(myDBData.tagline));
                distance_.setText(String.valueOf(myDBData.distance));
                typeArr_.setText(String.valueOf(myDBData.typeArr));

                databaseAccess.close();
            }
        });

        PreferenceObj prefMaster = new PreferenceObj();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.prefSettings) {
            Navigation.findNavController(this,R.id.nav_host_fragment_content_main).navigate(R.id.action_toPreferencesFragment);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}