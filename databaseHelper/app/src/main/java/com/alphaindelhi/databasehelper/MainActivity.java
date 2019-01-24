package com.alphaindelhi.databasehelper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Databasehelper myDB;
    EditText editTextID , editName , editEmail, editCC;
    Button buttonAdd, buttonGetData, buttonUpdate, buttonDelete, buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new Databasehelper(this);

        editTextID = findViewById(R.id.editText_id);
        editName = findViewById(R.id.editText_name);
        editEmail = findViewById(R.id.editText_email);
        editCC = findViewById(R.id.editText_CC);

        buttonAdd = findViewById(R.id.button_add);
        buttonGetData = findViewById(R.id.button_view);
        buttonUpdate = findViewById(R.id.button_update);
        buttonDelete = findViewById(R.id.button_delete);
        buttonViewAll = findViewById(R.id.button_viewAll);

        //showMessage("Testing", "testing is done");
        AddData();
        getData();
        viewAll();
        updateData();
        deleteData();

        }

        public void AddData(){

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editName.getText().toString(),editEmail.getText().toString(),editCC.getText().toString());
                if(isInserted==true)
                {
                    Toast.makeText(MainActivity.this , "Data Inserted", Toast.LENGTH_SHORT).show();
                } else
                {
                    Toast.makeText(MainActivity.this , "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });





        }
        public void getData(){

        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextID.getText().toString();

                if (id.equals(String.valueOf("")))
                {
                    editTextID.setError("Enter id");
                    return;
                }

                Cursor cursor = myDB.getData(id);
                String data=null;

              //  String getid = cursor.getString(0);

                if(cursor.moveToNext())
                {
                    data = "ID :"+cursor.getString(0)+"\n"+
                           "Name :"+cursor.getString(1)+"\n"+
                            "Email :"+cursor.getString(2)+"\n"+
                            "CC :"+cursor.getString(3)+"\n";

                }

                Intent intent = new Intent(MainActivity.this , Getdata.class);
                intent.putExtra("ID" ,data);
                startActivity(intent);


              //  showMessage("Data", data);
            }
        });

        }
        public void viewAll(){

            //small test
            //  showMessage("All data" , buffer.toString());
            buttonViewAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor cursor = myDB.getAllData();
                    //small test
                    if(cursor.getCount()==0)
                    {
                        showMessage("Error" , "nothing found in DATABASE");
                    }
                    StringBuffer buffer = new StringBuffer();

//                    String getId = cursor.getString(0);
//                    String getName = cursor.getString(1);
//                    String getEmail = cursor.getString(2);
//                    String getcourseCount = cursor.getString(3);

                    while (cursor.moveToNext())
                    {
                        buffer.append("ID :"+cursor.getString(0)+"\n");
                        buffer.append("Name :"+cursor.getString(1)+"\n");
                        buffer.append("Email :"+cursor.getString(2)+"\n");
                        buffer.append("CC :"+cursor.getString(3)+"\n \n");
                    }

                    String data = buffer.toString();
                    Intent intent = new Intent(MainActivity.this , ViewAll.class);
                    intent.putExtra("ID" , data);
                    startActivity(intent);


                 // showMessage("All data" , buffer.toString());
                }
            });


        }
        public void updateData(){

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean update = myDB.updateData(editTextID.getText().toString(),
                        editName.getText().toString(),
                        editEmail.getText().toString(),
                        editCC.getText().toString());

                if(update==true)
                {
                    Toast.makeText(MainActivity.this , "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this , "Oops something went wrong!", Toast.LENGTH_SHORT).show();
                }


            }
        });
        }
        public void deleteData(){

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleterow = myDB.deleteData(editTextID.getText().toString());
                if(deleterow>0)
                {

                    Toast.makeText(MainActivity.this , "Deleted Successfully" , Toast.LENGTH_SHORT).show();

                }else
                {
                    Toast.makeText(MainActivity.this , "Error occured" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        }
        private void showMessage(String title, String message)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.create();
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();

        }








}