package com.houlin.databinding.layout_bind_expression;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityExpressionBinding;

/**
 * 布局表达式：@{}
 * 表达式不支持：this, super, new, 泛型
 * Null合并运算符：a ?? b（若a为null则取b，否则取a）
 * 布局表达式可以防止数据的空指针异常，自动分配默认值
 * 表达式求值时，可以获得线程安全
 * 表达式的用法见布局文件
 */
public class ExpressionActivity extends AppCompatActivity {

    private ActivityExpressionBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_expression);

        mBinding = ActivityExpressionBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // 布局表达式可以防止数据的空指针异常，自动分配默认值
        mBinding.setUser(null);
    }

}