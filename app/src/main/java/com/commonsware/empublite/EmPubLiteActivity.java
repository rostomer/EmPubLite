package com.commonsware.empublite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import de.greenrobot.event.EventBus;

import static com.commonsware.empublite.R.id.pager;

public class EmPubLiteActivity extends Activity {
    private ViewPager pager = null;
    private ContentAdapter adapter = null;
    private static String MODEL = "model";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupStrictMode();
        setContentView(R.layout.main);
        pager=(ViewPager)findViewById(R.id.pager);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
     getMenuInflater().inflate(R.menu.options, menu);
        return(super.onCreateOptionsMenu(menu));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
      switch(item.getItemId())
      {
          case R.id.about:
              Intent i = new Intent(this, SimpleContentActivity.class).putExtra(SimpleContentActivity.EXTRA_FILE, "file:///android_asset/misc/about.html");
              startActivity(i);
              return true;
          case R.id.help:
              i = new Intent(this, SimpleContentActivity.class).putExtra(SimpleContentActivity.EXTRA_FILE, "file:///android_asset/misc/help.html");
              startActivity(i);
              return true;
      }
        return (super.onOptionsItemSelected(item));
    }
    @Override public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        if (adapter == null)
        {
            ModelFragment mfrag = (ModelFragment) getFragmentManager().findFragmentByTag(MODEL);

        if (mfrag == null)
        {
          getFragmentManager().beginTransaction().add(new ModelFragment(), MODEL).commit();
        }
            else if (mfrag.getBook()!=null)
        {
            setupPager(mfrag.getBook());
        }
        }
    }
    @Override
    public void onPause() {
        EventBus.getDefault().register(this);
        super.onPause();
    }
    public void setupPager(BookContents contents)
    {
        adapter = new ContentAdapter(this, contents);
        pager.setAdapter(adapter);
        findViewById(R.id.progressBar1).setVisibility(View.GONE);
        pager.setVisibility(View.VISIBLE);

    }
    @SuppressWarnings("unused")
    public void onEventMainThread(BookLoadedEvent event){
        setupPager(event.getBook());
    }
    private void setupStrictMode()
    {
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder().
                detectAll().penaltyLog();
        if(BuildConfig.DEBUG) {
            builder.penaltyFlashScreen();
        }
        StrictMode.setThreadPolicy(builder.build());
    }
}
