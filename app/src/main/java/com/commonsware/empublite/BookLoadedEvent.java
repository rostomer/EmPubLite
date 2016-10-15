package com.commonsware.empublite;

/**
 * Created by Asus on 14.10.2016.
 */

public class BookLoadedEvent {
    private BookContents contents = null;

    public BookLoadedEvent (BookContents contents)
    {
        this.contents = contents;
    }
    public BookContents getBook()
    {
        return  contents;
    }
}