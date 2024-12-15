package com.readlab.global;

import com.readlab.models.BookCollection;
import com.readlab.models.User;

import java.util.ArrayList;

public interface IUser {
    public ArrayList<User> user_list = new ArrayList<>();
    public ArrayList<BookCollection> book_collection_list = new ArrayList<>();
}
