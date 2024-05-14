package com.ss_technology.mushinprojectandroidapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.ss_technology.mushinprojectandroidapp.Config.BaseURL;
import com.ss_technology.mushinprojectandroidapp.Config.HelperFunctions;
import com.ss_technology.mushinprojectandroidapp.Config.KeepMeLogin;
import com.ss_technology.mushinprojectandroidapp.Config.VolleyCallback;
import com.ss_technology.mushinprojectandroidapp.R;

import org.json.JSONObject;

import java.util.HashMap;

public class Main_Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    KeepMeLogin keepMeLogin;
    /*Button btn_askQuest, btn_newPet, btn_petList;*/
    CardView askQuest, newPet, petList;

    TextView Name, Email;
    private DrawerLayout drawer;
    NavigationView navigationView;
    ImageView profileImage, profileImageAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        /*Name = findViewById(R.id.name_home);
        Email = findViewById(R.id.email);
        profileImage = findViewById(R.id.profileImage);
        */profileImageAppBar = findViewById(R.id.profileImageAppBar);
        askQuest = findViewById(R.id.Ques);
        newPet = findViewById(R.id.addPet);
        petList = findViewById(R.id.petList);
        /*btn_askQuest = findViewById(R.id.ask_Q);
        btn_newPet = findViewById(R.id.new_P);
        btn_petList = findViewById(R.id.pet_L);*/

        Toolbar toolbar = findViewById(R.id.tool1);
        //setSupportActionBar(toolbar);

        toolbar.inflateMenu(R.menu.home);
        keepMeLogin=new KeepMeLogin(this);

        navigationView = findViewById(R.id.nav_view1);


        drawer = findViewById(R.id.drawer_layout1);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        try {
            JSONObject object=new JSONObject(keepMeLogin.getData());
            /*Name.setText(object.getString("name"));
            Email.setText(object.getString("email"));
            */View headerItem=navigationView.getHeaderView(0);
            /*TextView name=headerItem.findViewById(R.id.name);
            TextView email=headerItem.findViewById(R.id.email);
            name.setText(object.getString("name"));
            email.setText(object.getString("email"));*/
            TextView headerName = headerItem.findViewById(R.id.name_header);
            headerName.setText(object.getString("name"));
            TextView headerEmail = headerItem.findViewById(R.id.email_header);
            headerEmail.setText(object.getString("email"));

            ImageView headerImage = headerItem.findViewById(R.id.profile_header);
            Picasso.get().load(BaseURL.userImage()+object.getString("image")).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(headerImage);

            Log.e("Profile Error",BaseURL.userImage()+object.getString("image"));
            /*Picasso.get().load(BaseURL.userImage()+object.getString("image")).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(profileImage);
            */
            Picasso.get().load(BaseURL.userImage()+object.getString("image")).memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(profileImageAppBar);


        }
        catch (Exception e){
            Toast.makeText(this, "Error Occurred in Json Parsing", Toast.LENGTH_SHORT).show();
            Log.e("TAG",e.getMessage());
        }


}



    public void ask_Q(View view)
    {
        startActivity(new Intent(getApplicationContext(), Website.class));
    }

    public void new_P(View view)
    {
        startActivity(new Intent(getApplicationContext(), Add_Your_Pet.class));
    }

    public void pet_L(View view)
    {
        startActivity(new Intent(getApplicationContext(), Your_Pets_List.class));
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to Exit !!!")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> System.exit(0))
                .setNegativeButton("No", null)
                .show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.contact){
            startActivity(new Intent(getApplicationContext(),Contact_Us.class));
        }
        else if (id==R.id.animation){
            startActivity(new Intent(getApplicationContext(),Animation.class));
        }
        else if (id==R.id.ask_question){
            startActivity(new Intent(getApplicationContext(),Website.class));
        }
        else if (id==R.id.diet_planner){
            startActivity(new Intent(getApplicationContext(),Diet_chart.class));
        }
        else if (id==R.id.sell_pets){
            startActivity(new Intent(getApplicationContext(),Sell_Pets.class));
        }
        else if (id==R.id.your_sell_lists){
            startActivity(new Intent(getApplicationContext(),Your_Sell_Lists.class));
        }
        else if (id==R.id.buy_pets){
            startActivity(new Intent(getApplicationContext(),Buy_Pets.class));
        }
        else if (id==R.id.chats){
            startActivity(new Intent(getApplicationContext(),Chats.class));
        }
        else if (id==R.id.add_pets){
            startActivity(new Intent(getApplicationContext(),Add_Your_Pet.class));
        }
        else if (id==R.id.your_pets_list){
            startActivity(new Intent(getApplicationContext(),Your_Pets_List.class));
        }
        else if (id==R.id.vaccinations){
            startActivity(new Intent(getApplicationContext(),Vaccination.class));
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    public void popUpMenuFtn(View view) {

        profileImageAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(Main_Home.this, profileImageAppBar);

                popupMenu.getMenuInflater().inflate(R.menu.home, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.edt_profile) {
                            startActivity(new Intent(getApplicationContext(), Profile.class));
                        } else if (menuItem.getItemId() == R.id.signout) {
                            keepMeLogin.Clear();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }
}