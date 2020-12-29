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

public class Display extends AppCompatActivity {
    ImageView image;
    TextView hotelname,price;
    String hotel_name;
    TextView user;
    Button book,signout;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        final Intent intent = getIntent();
        hotel_name = intent.getStringExtra("Hotel name");
        username = intent.getStringExtra("User");
        price = findViewById(R.id.textView5);
        image=findViewById(R.id.imageView4);
        hotelname = findViewById(R.id.textView4);
        user = findViewById(R.id.textView7);
        book = (Button)findViewById(R.id.booking);
        signout = findViewById(R.id.button2);
        price.setText(R.string.Rs);
        user.append(username);
        ImgDisplay();
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Display.this,Details.class);
                intent1.putExtra("User",username);
                intent1.putExtra("Hotel name",hotelname.getText().toString());
                intent1.putExtra("Price",price.getText().toString());
                startActivity(intent1);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Display.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
    public void ImgDisplay(){
        if(hotel_name.equals("JW Marriot")) {
            image.setImageResource(R.drawable.hotel1);
            hotelname.setText(hotel_name);
            price.append("15000");
        }
        else if(hotel_name.equals("Grand Dragon")){
            image.setImageResource(R.drawable.granddragon);
            price.append("12000");
        }
        else if(hotel_name.equals("Moonlight"))
        {
            image.setImageResource(R.drawable.moonlight);
            price.append("19000");
        }
        else if(hotel_name.equals("Renaissance")){
            image.setImageResource(R.drawable.renaissance);
            price.append("15000");
        }
        else if(hotel_name.equals("Pride")){
            image.setImageResource(R.drawable.pride);
            price.append("23000");
        }
        else if(hotel_name.equals("Prominent")){
            image.setImageResource(R.drawable.prominent);
            price.append("25000");
        }
        else if(hotel_name.equals("Sea Princess")){
            image.setImageResource(R.drawable.seaprincess);
            price.append("20000");
        }
        else if(hotel_name.equals("Taj Mahal")){
            image.setImageResource(R.drawable.tajmahal);
            price.append("21000");
        }
        hotelname.setText(hotel_name);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_display,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.SignOut:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.Close:
                //this.finish();
                //System.exit(0);
                Intent intent1 = new Intent(Display.this, Close.class);
//Clear all activities and start new task
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
            case R.id.View:
                intent = new Intent(this, Booking.class);
                intent.putExtra("User",username);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
