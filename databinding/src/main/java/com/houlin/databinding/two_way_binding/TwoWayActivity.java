package com.houlin.databinding.two_way_binding;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.houlin.databinding.databinding.ActivityTwoWayBinding;

/**
 * 双向绑定：
 * 单向绑定是数据驱动视图，但视图无法驱动数据，需要在视图上添加监听器才可以获取视图上的更新 eg.EditText, CheckBox
 * 常见特性可直接通过"@={...}"使用双向绑定，大多数原生控件已经实现了BindingAdapter(eg. TextViewBindingAdapter)
 */
public class TwoWayActivity extends AppCompatActivity {

    private ActivityTwoWayBinding mBinding;
    private TwoWayViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_two_way);
        mBinding = ActivityTwoWayBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(TwoWayViewModel.class);
        mBinding.setViewModel(mViewModel);
    }


    public void showData(View view) {
        Toast.makeText(this, "" + mViewModel.mLiveDataIsRemember.getValue(),
                Toast.LENGTH_SHORT).show();
    }

    public void resetCheckBox(View view) {
        mViewModel.mLiveDataIsRemember.setValue(false);
    }
}