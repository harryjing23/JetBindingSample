package com.houlin.viewbinding;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.viewbinding.databinding.ActivityMainBinding;

/**
 * 启用viewBinding后，每个布局文件都会生成一个绑定类，绑定类中包含具有id的控件的引用，可代替findViewById
 * 不想让某个布局文件生成绑定类，可以在根布局加上tools:viewBindingIgnore="true"
 * <p>
 * 与findViewById相比：1.不会出现空指针异常，因为是对控件的直接引用 2.不会出现类型转换异常，因为无需类型转换
 * 与dataBinding相比：1.编译速度更快 2.易于使用，不需要在布局文件中添加layout标签
 * <p>
 * 简单展示的布局使用viewBinding，复杂交互的布局使用dataBinding
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 获取绑定类实例。与dataBinding相同，需要用绑定类inflate方法
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        // 绑定类getRoot()可以获取布局的根视图
        LinearLayout root = mBinding.getRoot();
        // 设置根视图成为Activity的视图
        setContentView(root);

        // 绑定类即可获取控件
        TextView tvShow = mBinding.tvShow;
        Button btnShow = mBinding.btnShow;
    }
}
