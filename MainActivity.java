package com.syntax.unittest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.syntax.unittest.model.Result;
import com.syntax.unittest.views.fragment.ResultFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.edt_a)
    EditText edtA;
    @BindView(R.id.edt_b)
    EditText edtB;
    @BindView(R.id.btn_calculate)
    Button btnCalculate;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initPresenter();
        onAttachView();
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }

    @OnClick(R.id.btn_calculate)
    public void onViewClicked() {

        String inputanA = edtA.getText().toString().trim();
        String inputanB = edtB.getText().toString().trim();

        if (inputanA.isEmpty() || inputanB.isEmpty()) {
            Error();

        } else {
            edtA.setVisibility(View.GONE);
            edtB.setVisibility(View.GONE);
            btnCalculate.setVisibility(View.GONE);
            double a = Double.parseDouble(inputanA);
            double b = Double.parseDouble(inputanB);
            presenter.calculateResult(a, b);

        }
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDettachView() {
        presenter.onDettach();
    }

    @Override
    public void onShowFragment(final Result data) {

        Bundle bundle = new Bundle();
        bundle.putString("key", data.getResult());

        String TAG = ResultFragment.class.getSimpleName();
        Fragment fragment = ResultFragment.newInstance();
        fragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, fragment, TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void Error() {
        Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onAttachView();
    }

    @Override
    protected void onDestroy() {
        onDettachView();
        super.onDestroy();
    }
}
