package com.example.saman.mvp_begin.domain;

import android.support.annotation.Nullable;

/**
 * Created by saman on 10/4/17.
 */
public final class User {
    @Nullable
    private final String mName;

    public User(@Nullable String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
