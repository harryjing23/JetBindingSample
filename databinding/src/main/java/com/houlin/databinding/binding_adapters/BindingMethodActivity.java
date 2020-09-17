package com.houlin.databinding.binding_adapters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.databinding.ActivityBindingMethodBinding;

/**
 * 布局中设置的特性值会根据参数的数据类型自动查找setter
 * 若没有特性值对应的setter，需要用BindingMethods或BindingAdapter
 */
public class BindingMethodActivity extends AppCompatActivity {

    private ActivityBindingMethodBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_binding_method);
        mBinding = ActivityBindingMethodBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }
}