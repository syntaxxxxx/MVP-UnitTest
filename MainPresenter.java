package com.syntax.unittest;

import android.view.View;
import android.widget.EditText;

import com.syntax.unittest.base.BasePresenter;
import com.syntax.unittest.model.Result;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;

    @Override
    public void onAttach(MainView view) {
        mainView = view;
    }

    public double calculate(double inputanA, double inputanB) {
        return inputanA * inputanB;
    }

    public void calculateResult(double a, double b) {
            double total = calculate(a, b);
            Result mResult = new Result();
            mResult.setResult(String.valueOf(total));
            mainView.onShowFragment(mResult);
    }

    @Override
    public void onDettach() {
        mainView = null;
    }
}
