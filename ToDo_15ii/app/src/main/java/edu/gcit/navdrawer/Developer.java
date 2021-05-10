package edu.gcit.navdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Developer extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,Rate.class);


    }
    public void ClickShare(View view){
        MainActivity.redirectActivity(this,Shared.class);
    }
    public void ClickDeveloper(View view){
        recreate();
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