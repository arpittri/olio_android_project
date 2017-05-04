package trainedge.blank;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.facebook.share.model.ShareLinkContent;
import com.google.android.gms.plus.PlusShare;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mShareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mShareButton = (Button) findViewById(R.id.btnupload);
        mShareButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        makefacebookPost();
        makeGooglePlusPost();
        maketwitterPost();
        maketinderPost();
        makeTimberPost();
        makeRedditPost();
        makeInstaPost();

    }

    private void makeGooglePlusPost() {
        Intent shareIntent = new PlusShare.Builder(this)
                .setType("text/plain")
                .setText("Just tried this new restaurant! #nomnomnom #myappname")
                .setContentUrl(Uri.parse("https://developers.google.com/+/web/snippet/examples/restaurant"))
                .getIntent();

        startActivityForResult(shareIntent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==32){
            makefacebookPost();
        }
    }

    private void makefacebookPost() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .build();
    }

    private void maketwitterPost() {
      /*  ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.twitter.com"))
                .build();*/
        Intent shareIntent = new PlusShare.Builder(this)
                .setType("text/plain")
                .setText("just set your status in twitter")
                .setContentUrl(Uri.parse("https://www.twitter.com"))
                .getIntent();
        startActivityForResult(shareIntent, 0);
    }

    private void makeInstaPost() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.Instagram.com"))
                .build();
    }

    private void maketinderPost() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.gotinder.com"))
                .build();
    }

    private void makeTimberPost() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.Tumbler.com"))
                .build();
    }

    private void makeRedditPost() {
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://www.Reddit.com"))
                .build();
    }

}
