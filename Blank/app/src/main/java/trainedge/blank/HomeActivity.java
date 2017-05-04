package trainedge.blank;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.zip.Inflater;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    public static final String POSITION = "trainedge.blank.POS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView ivFacebook = (ImageView) findViewById(R.id.ivFacebook);
        ImageView ivInstagram = (ImageView) findViewById(R.id.ivInstagram);
        ImageView ivTwitter = (ImageView) findViewById(R.id.ivTwitter);
        ImageView ivGoogle = (ImageView) findViewById(R.id.ivGoogle);
        ImageView ivPinterest = (ImageView) findViewById(R.id.ivPinterest);
        ImageView ivFlickr = (ImageView) findViewById(R.id.ivFlickr);
        ImageView ivTumblr = (ImageView) findViewById(R.id.ivTumblr);
        ImageView ivTinder = (ImageView) findViewById(R.id.ivTinder);
        ImageView ivReddit = (ImageView) findViewById(R.id.ivReddit);
        ImageView ivInkedin = (ImageView) findViewById(R.id.ivLinkedin);

        ivFacebook.setOnClickListener(this);
        ivInstagram.setOnClickListener(this);
        ivTwitter.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);
        ivPinterest.setOnClickListener(this);
        ivFlickr.setOnClickListener(this);
        ivTumblr.setOnClickListener(this);
        ivTinder.setOnClickListener(this);
        ivReddit.setOnClickListener(this);
        ivInkedin.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_status) {
            Intent status=new Intent(HomeActivity.this,ShareActivity.class);
            startActivity(status);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navabout) {
            Intent abt = new Intent(HomeActivity.this, aboutActivity.class);
            startActivity(abt);
            // Handle the camera action
        } else if (id == R.id.navSetting) {
            Intent set = new Intent(this, SettinActivity.class);
            startActivity(set);


        } else if (id == R.id.navFeedabck) {
            Intent fed = new Intent(HomeActivity.this, Feedback.class);
            startActivity(fed);

        } else if (id == R.id.nav_send) {


        } else if (id == R.id.nav_share) {


            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT, "Olio");

            share.putExtra(Intent.EXTRA_TEXT, "Your friend has invited you to join the app./n To join click the link");
            startActivity(Intent.createChooser(share, "Share via..."));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivFacebook:
                Intent fbIntent = new Intent(this, SocialActivity.class);
                fbIntent.putExtra(POSITION, 0);
                startActivity(fbIntent);
                break;
            case R.id.ivInstagram:
                Intent instaIntent = new Intent(this, SocialActivity.class);
                instaIntent.putExtra(POSITION, 1);
                startActivity(instaIntent);
                break;
            case R.id.ivTwitter:
                Intent twitterIntent = new Intent(this, SocialActivity.class);
                twitterIntent.putExtra(POSITION, 2);
                startActivity(twitterIntent);
                break;
            case R.id.ivGoogle:
                Intent googleIntent = new Intent(this, SocialActivity.class);
                googleIntent.putExtra(POSITION, 3);
                startActivity(googleIntent);
                break;
            case R.id.ivPinterest:
                Intent pinterestIntent = new Intent(this, SocialActivity.class);
                pinterestIntent.putExtra(POSITION, 4);
                startActivity(pinterestIntent);
                break;
            case R.id.ivFlickr:
                Intent flikrIntent = new Intent(this, SocialActivity.class);
                flikrIntent.putExtra(POSITION, 5);
                startActivity(flikrIntent);
                break;

            case R.id.wbTumblr:
                Intent tumblerIntent = new Intent(this, SocialActivity.class);
                tumblerIntent.putExtra(POSITION, 6);
                startActivity(tumblerIntent);
                break;
            case R.id.wbTinder:
                Intent tinderIntent = new Intent(this, SocialActivity.class);
                tinderIntent.putExtra(POSITION, 7);
                startActivity(tinderIntent);
                break;
            case R.id.wbReddit:
                Intent redditIntent = new Intent(this, SocialActivity.class);
                redditIntent.putExtra(POSITION, 8);
                startActivity(redditIntent);
                break;
            case R.id.wvLinkedin:
                Intent linkedIntent = new Intent(this, SocialActivity.class);
                linkedIntent.putExtra(POSITION, 9);
                startActivity(linkedIntent);
                break;
        }
    }
}
