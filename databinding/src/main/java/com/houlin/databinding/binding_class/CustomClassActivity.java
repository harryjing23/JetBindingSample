package com.houlin.databinding.binding_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.houlin.databinding.R;
import com.houlin.databinding.CustomClass;


/**
 * 自定义绑定类名称：
 * 默认情况下，绑定类是根据布局文件的名称生成的，在模块包下的databinding包中
 * <p>
 * 可以指定data标签的class属性，自定义绑定类的名称
 * 1. "类名"还是在模块包下的databinding包中
 * 2. ".类名"生成在模块包中
 * 3. "完整包名.类名"生成指定位置
 * <p>
 * PS：需要Rebuild Project，才能生成新的绑定类
 */
public class CustomClassActivity extends AppCompatActivity {

    // 自定义了绑定类的名称和路径
    private CustomClass mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_class);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_custom_class);

    }
}