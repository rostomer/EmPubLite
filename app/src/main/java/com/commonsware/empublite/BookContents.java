package com.commonsware.empublite;

/**
 * Created by Asus on 14.10.2016.
 */
import java.util.List;
public class BookContents {
    List<BookContents.Chapter> chapters;
    int getChapterCout()
    {
        return (chapters.size());
    }
    String getChapterFile(int position)
    {
        return(chapters.get(position).file);
    }
    static class Chapter
    {
        String file;
    }
}
