package com.syntax.unittest.views.fragment;

import android.os.Bundle;

import com.syntax.unittest.MainView;
import com.syntax.unittest.base.BasePresenter;
import com.syntax.unittest.model.Result;

public class ResultPresenter implements BasePresenter<ResultView> {

    ResultView resultView;

    @Override
    public void onAttach(ResultView view) {
        resultView = view;
    }

    public void getResult(String data) {
        resultView.showResult(data);
    }

    @Override
    public void onDettach() {
        resultView = null;
    }
}
