package com.houlin.databinding.binding_adapters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.databinding.ActivityBindingMethodBinding;

/**
 * 设置属性值：
 * 1.自动选择方法
 * 2.指定自定义方法名称：@BindingMethods
 * 3.提供自定义逻辑：@BindingAdapter
 * <p>
 * 自动选择方法：
 * 布局中设置的特性值会根据参数的数据类型自动查找setter（不会考虑特性的命名空间）
 * <p>
 * 若没有特性值对应的setter，需要用@BindingMethods或@BindingAdapter
 * <p>
 * PS：dataBinding中设置所有的特性都要用绑定表达式，用传统赋值方式会提示"没有该特性"
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