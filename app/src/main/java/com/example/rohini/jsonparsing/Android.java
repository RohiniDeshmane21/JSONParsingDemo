package com.example.rohini.jsonparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Android extends AppCompatActivity {
    ListView moduleList;

    String[] ModuleNo = {"Module 1", "Module 2", "Module 3", "Module 4", "Module 5"};

    String[] ModuleName = {"Introduction to Android","User Interface Design","Mobile Data Management","Native Capabilities","Testing"};

    Integer[] drawableImages = {R.drawable.module1, R.drawable.module2, R.drawable.module3, R.drawable.module4, R.drawable.module5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        final MyListAdapter adapter = new MyListAdapter(this, ModuleNo, ModuleName, drawableImages);
        moduleList = (ListView)findViewById(R.id.listViewModules);
        moduleList.setAdapter(adapter);

        moduleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  adapterView, View view, int i, long l) {
                String selectedSubject = adapterView.getItemAtPosition(i).toString();

                Intent moduleDetails = new Intent(Android.this,Module_Details.class);
                moduleDetails.putExtra("ModuleNumber",selectedSubject);
                moduleDetails.putExtra("Subject","Android");
                startActivity(moduleDetails);
            }
        });

    }

}
