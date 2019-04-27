package com.syntax.unittest.base;

public interface BasePresenter <T extends BaseView> {

    void onAttach(T view);
    void onDettach();
}
