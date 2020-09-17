package com.houlin.databinding.binding_class;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.BR;
import com.houlin.databinding.databinding.ActivityAdvanceBindingBinding;

/**
 * 即时绑定：
 * 当可变或可观察对象发生更改时，绑定会按照计划在下一帧之前发生更改
 * 但有时必须立即执行绑定（eg.RecyclerView的Adapter中），用绑定类执行executePendingBindings()
 * <p>
 * 高级绑定：
 * 当不确定具体的绑定类时（eg.多布局的Adapter中），可以用DataBindingUtil获取绑定基类ViewDataBinding的实例
 * ViewDataBinding没有布局中变量的引用，可以用绑定基类的setVariable()为变量赋值。即为 动态变量
 *
 * 后台线程：
 * 可以在后台线程中更改数据，但前提是这个数据不是集合
 * 数据绑定会在求值过程中对每个变量/字段进行本地化，以避免出现并发问题
 */
public class AdvanceBindingActivity extends AppCompatActivity {

    private ActivityAdvanceBindingBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_advance_binding);

        mBinding = ActivityAdvanceBindingBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        BindingUser bindingUser = new BindingUser();
        // 动态变量：用基类的setVariable()为变量赋值（BR类会为变量生成id）
        mBinding.setVariable(BR.bindingUser, bindingUser);
        // 可观察的数据发生了数据变化
        bindingUser.firstName.set("first");
        bindingUser.lastName.set("last");
        // 即时绑定
        mBinding.executePendingBindings();

    }
}