package com.example.saman.mvp_begin.presentation;

/**
 * Created by saman on 10/4/17.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
