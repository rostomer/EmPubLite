package com.commonsware.empublite;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleContentFragment extends WebViewFragment {
    private static final String Key_File = "file";

    static SimpleContentFragment newInstance(String file)
    {
        SimpleContentFragment f = new SimpleContentFragment();

        Bundle args = new Bundle();
        args.putString(Key_File,file);
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater infalter, ViewGroup container, Bundle SavedInstanceState)
    {
        View result = super.onCreateView(infalter, container, SavedInstanceState);
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setSupportZoom(true);
        getWebView().getSettings().setBuiltInZoomControls(true);
        getWebView().loadUrl(getPage());

        return(result);

    }

    private String getPage()
    {
        return getArguments().getString(Key_File);
    }


    public SimpleContentFragment() {
        // Required empty public constructor
    }



}
