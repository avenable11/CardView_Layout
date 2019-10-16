package edu.ivytech.cardviewlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences savedValues;
    private boolean showImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        PreferenceManager.setDefaultValues(this,
                R.xml.root_preferences,false);


    }

    @Override
    protected void onResume() {
        super.onResume();
        savedValues = PreferenceManager.getDefaultSharedPreferences(this);
        showImages = savedValues.getBoolean(getResources().getString(R.string.image_pref_key), false);
        ImageView image = findViewById(R.id.imageView1);
        ImageView image2 = findViewById(R.id.imageView2);
        ImageView image3 = findViewById(R.id.imageView3);
        if(!showImages){
            image.setVisibility(ImageView.GONE);
            image2.setVisibility(ImageView.GONE);
            image3.setVisibility(ImageView.GONE);
        } else {
            image.setVisibility(ImageView.VISIBLE);
            image2.setVisibility(ImageView.VISIBLE);
            image3.setVisibility(ImageView.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
                return true;
            case R.id.about:
                Intent about = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(about);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
