package com.syntax.unittest;

import com.syntax.unittest.base.BaseView;
import com.syntax.unittest.model.Result;

public interface MainView extends BaseView {

    void onShowFragment(Result data);
    void Error();

}
