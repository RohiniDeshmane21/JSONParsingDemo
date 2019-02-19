package com.example.rohini.jsonparsing;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Module_Details extends AppCompatActivity {

    TextView SubjectNm, ModuleNm, Details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module__details);

        SubjectNm = (TextView)findViewById((R.id.textViewSubjectName));
        ModuleNm = (TextView)findViewById(R.id.textViewModule);
        Details = (TextView)findViewById(R.id.textViewModuleDetails);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String ModuleNumber = bundle.getString("ModuleNumber");
        String Subject = bundle.getString("Subject");



        try {
            AssetManager assetManager = getAssets();
            InputStream ims = assetManager.open("ModuleData.json");
            int size = ims.available();

            byte[] buffer = new byte[size];
            ims.read(buffer);
            ims.close();
            String json = new String(buffer, "UTF-8");
            JSONObject obj = new JSONObject(json);
            JSONArray subjectDetails = obj.getJSONArray(Subject);
            String ModuleDetails = "";
            for(int i =0 ; i< subjectDetails.length(); i++) {
                String moduleNm = subjectDetails.getJSONObject(i).getString("ModuleNo").toString();
                if(ModuleNumber.equals(moduleNm)) {
                    ModuleDetails = subjectDetails.getJSONObject(i).getString("Details");

                    SubjectNm.setText(Subject);
                    ModuleNm.setText(ModuleNumber);
                    Details.setText(ModuleDetails);
                }
            }

        }catch(IOException e) {
            e.printStackTrace();
            Toast toast=Toast.makeText(getApplicationContext(),"Error 1 "+ e.toString(),Toast.LENGTH_SHORT);
            toast.show();
        } catch (JSONException e) {

            e.printStackTrace();
            Toast toast=Toast.makeText(getApplicationContext(),"Error 2 "+ e.toString(),Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}

