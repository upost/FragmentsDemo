package de.androidnewcomer.fragmentsdemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(findViewById(R.id.main )!=null) {
            getSupportFragmentManager().beginTransaction().hide(getSupportFragmentManager().findFragmentById(R.id.detail)).commit();
        } else {
            getSupportFragmentManager().beginTransaction().show(getSupportFragmentManager().findFragmentById(R.id.detail)).commit();
        }
    }

    @Override
    public void onItemSelected(String article) {
        if(findViewById(R.id.list_and_details)!=null) {
            Log.i(getClass().getSimpleName(), "select, list_and_details");
            DetailFragment f = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail);
            f.showDetail(article);
        } else {
            Log.i(getClass().getSimpleName(), "select, single");
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.list))
                    .show(fragmentManager.findFragmentById(R.id.detail))
                    .addToBackStack(null)
                    .commit();
            ((DetailFragment)fragmentManager.findFragmentById(R.id.detail)).showDetail(article);
        }
    }
}