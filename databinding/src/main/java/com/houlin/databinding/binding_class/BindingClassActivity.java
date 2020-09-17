package com.houlin.databinding.binding_class;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.houlin.databinding.databinding.ActivityBindingClassBinding;

/**
 * 布局文件转换成数据绑定后，系统会生成绑定类，用于访问布局中的变量和具有id的视图。基类是ViewDataBinding
 * 绑定类的类名默认为布局文件名的Pascal写法并加Binding后缀
 * 获取绑定类实例：
 * 1. 绑定类的inflate(), bind()
 * 2. DataBindingUtil的inflate(), bind(), setContentView()
 * 其中：bind()用于已经inflate过的布局；inflate()有多个参数的重载，用于Fragment和RecyclerView等
 * <p>
 * 绑定类对布局中的变量都生成了getter和setter
 */
public class BindingClassActivity extends AppCompatActivity {

    private ActivityBindingClassBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_binding_class);

        // 获取绑定类实例
        mBinding = ActivityBindingClassBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // 访问布局中的变量
        mBinding.setCount(99);
        int count = mBinding.getCount();
        // 访问布局中具有id的视图
        TextView tvShow = mBinding.tvShow;
    }
}