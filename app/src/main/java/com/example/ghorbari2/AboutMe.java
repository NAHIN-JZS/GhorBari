package com.example.ghorbari2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AboutMe extends AppCompatActivity {

    public static TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_about_me);
        textView1=findViewById(R.id.textAddMe);

        jsontask jsontask1 = new jsontask();
        jsontask1.execute();
    }
    public static class  jsontask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... strings) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;
            String name;
            String roll;
            String DEPT;
            String Section;
            String Varsity;

            try {
                URL url = new URL("https://api.myjson.com/bins/16v2ko");
                httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line="";
                StringBuffer lastBuffer = new StringBuffer();

                while ((line = bufferedReader.readLine()) != null){

                    stringBuffer.append(line);
                }

                String file = stringBuffer.toString();

                JSONObject fileObject = new JSONObject(file);
                JSONArray jsonArray = fileObject.getJSONArray("studentinfo");
                for (int i=0;i<jsonArray.length();i++) {

                    JSONObject arrayObject = jsonArray.getJSONObject(i);

                    name = arrayObject.getString("name");
                    roll = arrayObject.getString("roll");
                    DEPT = arrayObject.getString("DEPT");
                    Section=arrayObject.getString("Section");
                    Varsity=arrayObject.getString("Varsity");
                    lastBuffer.append("Name : "+name+"\n"+"Roll : "+roll+"\n"+"DEPT : "+DEPT+"\n"+"Section : "+Section+"\n"+"Varsity : "+Varsity+"\n");
                }

                return lastBuffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {


            super.onPostExecute(s);

            textView1.setText(s);


        }
    }
}
