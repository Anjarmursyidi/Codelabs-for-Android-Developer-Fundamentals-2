package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // tag for intent extra
    public static final String EXTRA_MESSAGE =
            "com.example.droidcafe.extra.MESSAGE";
    //
    private String mOrdermessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, orderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrdermessage);
                startActivity(intent);
            }
        });
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
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_order) {
        //    return true;
        // }


        switch (item.getItemId()) {
            case R.id.action_order:
                //displayToast(getString(R.string.action_order_message));
                Intent intent = new Intent(MainActivity.this, orderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrdermessage);
                startActivity(intent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_favorite:
                displayToast(getString(R.string.action_favorite_message));
                return true;
            case R.id.action_contact:
                displayToast(getString(R.string.action_contact_message));
                return true;
                default:
        }
        return super.onOptionsItemSelected(item);
    }

    /*

     */

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    //
    public void donutOrder (View view){

        mOrdermessage = getString(R.string.donut_order);
        displayToast(mOrdermessage);
    }
    public void iceCreamOrder (View view){
        mOrdermessage = getString(R.string.iceCream_order);
        displayToast(mOrdermessage);
    }
    public void yogurtOrder (View view){
        mOrdermessage = getString(R.string.yogurt_order);
        displayToast(mOrdermessage);
    }
}
