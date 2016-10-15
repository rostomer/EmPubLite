package com.commonsware.empublite;

/**
 * Created by Asus on 02.09.2016.
 */
import android.app.Activity;
import android.app.Fragment;
import android.support.v13.app.FragmentStatePagerAdapter;
public class ContentAdapter extends FragmentStatePagerAdapter {
    public ContentAdapter(Activity ctxt, BookContents contents)
    {
        super(ctxt.getFragmentManager());
        this.contents = contents;
    }
    final BookContents contents;

    @Override
    public Fragment getItem(int position)
    {
        String path = contents.getChapterFile(position);

        return(SimpleContentFragment.newInstance("file:///android_asset/book/" + path));
    }
    @Override
    public int getCount()
    {
        return(contents.getChapterCout());
    }
}