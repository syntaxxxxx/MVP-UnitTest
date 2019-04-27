package com.syntax.unittest.views.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.syntax.unittest.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment implements ResultView {


    @BindView(R.id.tv_result)
    TextView tvResult;
    Unbinder unbinder;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    ResultPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initPresenter();
        onAttachView();
    }

    private void initPresenter() {
        presenter = new ResultPresenter();
    }

    @Override
    public void showResult(String result) {
        tvResult.setText(result);
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        setResult();
    }

    @Override
    public void onDettachView() {
        presenter.onDettach();
    }

    @Override
    public void onDestroyView() {
        onDettachView();
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setResult() {
        Bundle bundle = getArguments();
        String data = bundle.getString("key");
        presenter.getResult(data);
    }
}
