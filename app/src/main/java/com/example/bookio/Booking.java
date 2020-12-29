package com.example.bookio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Booking extends AppCompatActivity {
    String user;
    TextView textView;
    ImageView hotel1,hotel2,hotel3,hotel4,hotel5,hotel6,hotel7,hotel8;
    TextView name1,name2,name3,name4,name5,name6,name7,name8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        final Intent intent = getIntent();
        user = intent.getStringExtra("User");
        hotel1 = findViewById(R.id.image);
        hotel2 = findViewById(R.id.image2);
        hotel3 = findViewById(R.id.image3);
        hotel4 = findViewById(R.id.image4);
        hotel5 = findViewById(R.id.image5);
        hotel6 = findViewById(R.id.image6);
        hotel7 = findViewById(R.id.image7);
        hotel8 = findViewById(R.id.image8);
        name1 = findViewById(R.id.hotel_name1);
        name2 = findViewById(R.id.hotel_name2);
        name3 = findViewById(R.id.hotel_name3);
        name4 = findViewById(R.id.hotel_name4);
        name5 = findViewById(R.id.hotel_name5);
        name6 = findViewById(R.id.hotel_name6);
        name7 = findViewById(R.id.hotel_name7);
        name8 = findViewById(R.id.hotel_name8);


        String text = "Hey! "+user+" Please select a hotel to proceed.";
        textView = findViewById(R.id.textView3);
        textView.setText(text);

    }
    public void onClick(View view){
        Intent intent = new Intent(this,Display.class);
        if(view.getId()==R.id.image)
            intent.putExtra("Hotel name", name1.getText().toString());
        else if(view.getId()==R.id.image2)
            intent.putExtra("Hotel name", name2.getText().toString());
        else if(view.getId()==R.id.image3)
            intent.putExtra("Hotel name", name3.getText().toString());
        else if(view.getId()==R.id.image4)
            intent.putExtra("Hotel name", name4.getText().toString());
        else if(view.getId()==R.id.image5)
            intent.putExtra("Hotel name", name5.getText().toString());
        else if(view.getId()==R.id.image6)
            intent.putExtra("Hotel name", name6.getText().toString());
        else if(view.getId()==R.id.image7)
            intent.putExtra("Hotel name", name7.getText().toString());
        else if(view.getId()==R.id.image8)
            intent.putExtra("Hotel name", name8.getText().toString());
        intent.putExtra("User",user);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_booking,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.SignOut:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.Close:
                //this.finish();
                //System.exit(0);
                Intent intent1 = new Intent(Booking.this, Close.class);
//Clear all activities and start new task
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
