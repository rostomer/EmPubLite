package com.commonsware.empublite;

/**
 * Created by Asus on 02.09.2016.
 */
import android.app.Activity;
import android.app.Fragment;
import android.support.v13.app.FragmentStatePagerAdapter;
public class ContentAdapter extends FragmentStatePagerAdapter {
    public ContentAdapter (Activity ctxt)
    {
        super(ctxt.getFragmentManager());
    }

    @Override
    public Fragment getItem(int arg0)
    {
        return null;
    }
    @Override
    public int getCount()
    {
        return 0;
    }
}