package com.example.saman.mvp_begin.presentation.users;

import android.support.annotation.NonNull;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Created by saman on 10/4/17.
 */
public class UsersPresenter implements UsersContract.Presenter {

    private final UsersContract.View mUsersView;


    @Override
    public void start() {
        loadUsers();
    }

    public void loadUsers() {
    }

    public UsersPresenter(@NonNull UsersContract.View usersView) {
        mUsersView = checkNotNull(usersView, "usersview cannot be null!");
        mUsersView.setPresenter(this);
    }
}

