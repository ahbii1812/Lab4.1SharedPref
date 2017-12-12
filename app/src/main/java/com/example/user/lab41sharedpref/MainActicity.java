package com.example.user.lab41sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActicity extends AppCompatActivity {

    private TextView textViewName;
    private ImageView imageViewProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewName = (TextView) findViewById(R.id.textViewName);
        imageViewProfile = (ImageView) findViewById(R.id.imageViewProfile);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = mySharedPreferences.getString("name_text" , getString(R.string.pref_default_display_name));
        //TODO display name
        String gender = mySharedPreferences.getString("gender_list" , "-1");
        //TODO display title mr or ms and change profile picture
        if(gender.equals("1"))
        {
            textViewName.setText("Mr." + name);
            imageViewProfile.setImageResource(R.drawable.male);
        }
        else if(gender.equals("0"))
        {
            textViewName.setText("Ms." + name);
            imageViewProfile.setImageResource(R.drawable.female);
        }
        else
        {
            textViewName.setText(name);
            imageViewProfile.setImageResource(R.drawable.profile);
        }

    }
}
