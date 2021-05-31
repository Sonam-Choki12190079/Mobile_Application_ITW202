package edu.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText mName, mSName, mId, mMarks;
    Button mAdd, mUpdate, mDelete, mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb= new DatabaseHelper(this);
        mName = findViewById(R.id.Name);
        mSName = findViewById(R.id.SName);
        mId = findViewById(R.id.Id_no);
        mMarks=findViewById(R.id.Markss);
        mAdd=findViewById(R.id.button_add);
        mView = findViewById(R.id.button_view);
        mDelete = findViewById(R.id.button_delete);
        mUpdate = findViewById(R.id.button_update);
        viewAll();
        UpdateData();
        DeleteData();
    }
    public void DeleteData(){
        mDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(mId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data deleted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not deleted", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
    public void UpdateData(){
        mUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(mId.getText().toString(),
                                mName.getText().toString(),
                                mSName.getText().toString(),mMarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data is updated",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not updated", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }

    public void AddData(View view) {
        boolean isInserted = myDb.insertData(mId.getText().toString(),
                mName.getText().toString(),
                mSName.getText().toString(),
                mMarks.getText().toString());
        if(isInserted==true)
            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,"Data not inserted", Toast.LENGTH_SHORT).show();
    }
    public void viewAll(){
        mView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res= myDb.getAllData();
                       if(res.getCount()== 0){
                           showMessage("Error","Nothing found");
                           return;
                       }
                       StringBuffer buffer = new StringBuffer();
                       while(res.moveToNext()){
                           buffer.append("id:"+ res.getString(0)+ "\n");
                           buffer.append("name:"+ res.getString(1)+ "\n");
                           buffer.append("surname:"+ res.getString(2)+ "\n");
                           buffer.append("marks:"+ res.getString(3)+ "\n\n");
                       }
                       showMessage("Data",buffer.toString());
                    }
                }
        );

    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}