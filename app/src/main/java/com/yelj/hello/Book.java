package com.yelj.hello;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: Alex.ylj
 * 2019/4/4 14:05 Thursday
 * Description:
 */
public class Book implements Parcelable {

    public int bookId = 1001;
    public String bookName = "default";

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bookId);
        dest.writeString(this.bookName);
    }

    public Book() {
    }

    protected Book(Parcel in) {
        this.bookId = in.readInt();
        this.bookName = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
