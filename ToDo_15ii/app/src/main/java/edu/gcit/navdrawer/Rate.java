package edu.gcit.navdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Rate extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        recreate();

    }
    public void ClickShare(View view){
        MainActivity.redirectActivity(this,Shared.class);

    }
    public void ClickDeveloper(View view){

        MainActivity.redirectActivity(this,Developer.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    @Override
    protected void onPause(){
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}