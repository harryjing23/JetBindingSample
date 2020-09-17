package com.houlin.databinding.layout_bind_expression;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityBindDataBinding;

/**
 * 绑定数据：
 * 绑定的数据要么是public，要么提供public的getter
 * 加了layout标签的布局文件，会生成对应的绑定类。绑定类中包含变量和具有id的视图的引用
 */
public class BindDataActivity extends AppCompatActivity {

    private ActivityBindDataBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bind_data);

        // 获取绑定类实例
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_data);
        // 也可以使用 绑定类或DataBindingUtil的inflate方法，获取绑定类实例
//        mBinding = ActivityBindDataBinding.inflate(getLayoutInflater());
//        setContentView(mBinding.getRoot());

        User user = new User("first", "last");
        // 设置绑定的数据
        mBinding.setUser(user);
    }
}