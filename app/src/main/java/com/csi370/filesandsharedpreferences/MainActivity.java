package com.examples.ict370.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.csi370.filesandsharedpreferences.ActivitySharedPreferences;
import com.csi370.filesandsharedpreferences.Activity_Database;
import com.csi370.filesandsharedpreferences.Save2SDActivity;
import com.csi370.filesandsharedpreferences.SavingFiles_Int_Ext_2_Activity;

public class MainActivity extends ActionBarActivity {
    private EditText et;
    private String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)(findViewById(R.id.editText1));
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void save(View view){
        data = et.getText().toString();
        try {
            FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
            fOut.write(data.getBytes());
            fOut.close();
            Toast.makeText(getBaseContext(),"file saved",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void read(View view){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            et.setText(temp);
            Toast.makeText(getBaseContext(),"file read",
                    Toast.LENGTH_SHORT).show();

        }catch(Exception e){

        }
    }

    public void openSave2SD(View v)
    {
        Intent intent = new Intent(this, Save2SDActivity.class);
        startActivity(intent);
    }

    public void openPrefs(View v)
    {
        Intent intent = new Intent(this, ActivitySharedPreferences.class);
        startActivity(intent);
    }

    public void openDB(View v)
    {
        Intent intent = new Intent(this, Activity_Database.class);
        startActivity(intent);
    }

    public void openBufferedSave(View v)
    {
        Intent intent = new Intent(this, SavingFiles_Int_Ext_2_Activity.class);
        startActivity(intent);
    }
}
