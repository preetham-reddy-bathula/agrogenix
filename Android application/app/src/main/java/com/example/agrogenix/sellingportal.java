package com.example.agrogenix;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class sellingportal extends AppCompatActivity implements View.OnClickListener{

    EditText name,phone,description;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellingportal);

        name=(EditText) findViewById(R.id.editTextTextPersonName2);
        phone=(EditText) findViewById(R.id.editTextPhone2);
        description=(EditText) findViewById(R.id.editTextTextPersonName3);
        submit=(Button) findViewById(R.id.button8);

        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view==submit) {
            addItemToSheet(); }
    }

    private void addItemToSheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Updating","Please Wait");
        final String tname = name.getText().toString().trim();
        final String tphone = phone.getText().toString().trim();
        final String tdescription = description.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbzfvDJYGtEHpoYPKP7-tCf6-RRdHX2dj5mKRbelLQM4lhN7At3Y9xvyy4gkxTvLeSqv/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(sellingportal.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),farmerspage.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("name",tname);
                parmas.put("phone",tphone);
                parmas.put("description",tdescription);

                return parmas;
            }
        };

        int socketTimeOut = 20000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);



    }
}