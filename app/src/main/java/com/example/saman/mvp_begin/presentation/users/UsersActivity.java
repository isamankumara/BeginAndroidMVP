package com.example.saman.mvp_begin.presentation.users;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.saman.mvp_begin.R;
import com.example.saman.mvp_begin.util.ActivityUtils;

/**
 * Created by saman on 10/4/17.
 */
public class UsersActivity extends AppCompatActivity {

    private UsersPresenter mUsersPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UsersFragment usersFragment =
                (UsersFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (usersFragment == null) {
            // Create the fragment
            usersFragment = UsersFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), usersFragment, R.id.contentFrame);
        }

        // Create the presenter
        mUsersPresenter = new UsersPresenter(
                usersFragment
        );
    }
}
