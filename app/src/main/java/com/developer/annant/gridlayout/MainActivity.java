package com.developer.annant.gridlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridView gridView;


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private MaterialSearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navdraw_layout);


        //Start NavDrawer Code

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navdraw_layout_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);  //Need TO write a method to solve

        View hView = navigationView.inflateHeaderView(R.layout.navdraw_insidenav);
        ImageView imgvw = (ImageView) hView.findViewById(R.id.image_nav);
       // TextView tv = (TextView) hView.findViewById(R.id.text_nav);
        imgvw.setImageResource(R.drawable.rento_logo_light);
        //tv.setText("Rentoversity");
        //End NavDrawer Code


        //Start ViewPager And TabLayout Code
        viewPager = (ViewPager) findViewById(R.id.view_pagerid);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(), getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabs_viewid);
        tabLayout.setupWithViewPager(viewPager);
        //End ViewPager And TabLayout Code

        //gridView = (GridView) findViewById(R.id.common_gridview_layout);





































        // searchView MaterialSearchView Implementation

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });






    }//End OF onCreate  Method

//////////////////////////////////////////////////////////////////////////    Recycler Methods Code Start Here




















    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navdraw_layout_view);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if ((searchView.isSearchOpen())) {
            searchView.closeSearch();

        } else {
            super.onBackPressed();
        }
    }// You Do understand the Use of above method


  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
*/

    //Below is the method we were going to use for correcting the errors//  Important

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        // Enter All your drawer calling code here
        // For example Fragments and Activity
        switch (item.getItemId()) {

           /* case R.id.nav_home:
                startActivity(new Intent(MainActivity.this, HomeDrawerActivity.class));
                break;

                */
            case R.id.navdraw_home:
                Toast.makeText(this, getString(R.string.navigation_home), Toast.LENGTH_SHORT).show();
                //    startActivity(new Intent(MainActivity.this, FeedbackDrawerActivity.class));
                break;
            case R.id.navdraw_wishwall:
                Toast.makeText(this, getString(R.string.navstring_wishwall), Toast.LENGTH_SHORT).show();
                //  startActivity(new Intent(MainActivity.this, ContactUsDrawerActivity.class));
                break;
            case R.id.navdraw_rumblewall:
                Toast.makeText(this, getString(R.string.navstring_rumblewall), Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity.this, ShopInfoDrawerActivity.class));
                break;
            case R.id.navdraw_mylist:
                Toast.makeText(this, getString(R.string.navstring_mylist), Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(MainActivity.this, ShopImageDrawerActivity.class));
                break;

            default:
                //  startActivity(new Intent(MainActivity.this, HomeDrawerActivity.class));
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.navdraw_layout_view);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


    //Drawer Code Ends Here
////////////////////////////////////////////////////////////////////////////////////////////////////


    //For 3 dot  menu in action start here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_in_actionbar, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Cases For Option Item Selected in  3 Dot menu
            case R.id.action_search:
                Toast.makeText(this, getString(R.string.action_search), Toast.LENGTH_SHORT).show();
                // Do nothing for now
                return true;

            case R.id.action_chat:
                Toast.makeText(this, getString(R.string.action_chat), Toast.LENGTH_SHORT).show();
                // Do nothing for now
                return true;

            // Respond to a click on the "Delete" menu option
            case R.id.action_invite_friends:

                Toast.makeText(this, getString(R.string.action_invite), Toast.LENGTH_SHORT).show();
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case R.id.action_contactus:
                Toast.makeText(this, getString(R.string.action_contact_us), Toast.LENGTH_SHORT).show();
                // Navigate back to parent activity (CatalogActivity)
                //NavUtils.navigateUpFromSameTask(this);
                return true;


            case R.id.action_legal:
                Toast.makeText(this, getString(R.string.action_legal), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_ourteam:
                Toast.makeText(this, getString(R.string.action_ourteam), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, OurTeamNavActivity.class));
                return true;
            case R.id.action_logout:
                Toast.makeText(this, getString(R.string.action_logout), Toast.LENGTH_SHORT).show();

                return true;
            // End Of cases For 3 Dot Menu

/*
            //Start Of cases For Nav drawer Clicks
            case R.id.navdraw_home:
                return true;

            case R.id.navdraw_wishwall:
                return true;

            case R.id.navdraw_rumblewall:
                return true;

            case R.id.navdraw_mylist:
                return true;

            //End OF cases For NavDrawer
 */
        }
        return super.onOptionsItemSelected(item);
    }


    ///All of Action 3Dot menu Ends Here

    ///////////////////////////////////////////////////////////////////
    //All for Fragments Start Here
    private class CustomAdapter extends FragmentPagerAdapter {

        private String fragments[] = {"Clothes", "Books"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ClothsFragment();
                case 1:
                    return new BooksFragment();
                default:
                    return null;//new FragmentFirst();
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }

    }
    //All for Fragments End Here

}