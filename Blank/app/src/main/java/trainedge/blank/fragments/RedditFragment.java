package trainedge.blank.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import trainedge.blank.R;
import trainedge.blank.RedditActivity;

import static trainedge.blank.RedditActivity.REDDIT_LINK;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedditFragment extends Fragment {
    public static final String REDDIT_LINK ="https://www.reddit.com";

    public RedditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_reddit, container, false);
        View view = inflate;
        WebView wbReddit= (WebView) view.findViewById(R.id.wbReddit);

        wbReddit.getSettings().setJavaScriptEnabled(true);
        wbReddit.setWebViewClient(new RedCallback());
        wbReddit.loadUrl(REDDIT_LINK);
        return view;
    }

    private class RedCallback extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}
