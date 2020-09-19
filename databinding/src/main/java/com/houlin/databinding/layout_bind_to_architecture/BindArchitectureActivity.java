package com.houlin.databinding.layout_bind_to_architecture;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityBindArchitectureBinding;

/**
 * 将布局视图绑定到架构组件：
 * 布局绑定到架构组件中的数据，可帮助您管理界面控制器生命周期并通知数据变化
 * 1.使用 LiveData 将数据变化通知给界面（将可观察字段替换为LiveData对象，LiveData还可以通过map()和switchMap()转换数据）
 * 2.使用 ViewModel 管理界面相关数据（将LiveData放在ViewModel中，将界面逻辑从布局移到ViewModel中）
 * 3.使用 Observable ViewModel 更好地控制绑定适配器
 */
public class BindArchitectureActivity extends AppCompatActivity {

    private ActivityBindArchitectureBinding mBinding;
    private MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_bind_architecture);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_architecture);

        // 为绑定类设置LifecycleOwner。要将LiveData与绑定类一起使用，需要指定生命周期所有者来定义LiveData对象的范围
        // ### 使用LiveData时一定要调用setLifecycleOwner()，否则LiveData不会被观察，导致数据变化不会更新视图
        mBinding.setLifecycleOwner(this);

        // 创建ViewModel实例
        mViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        // 为绑定类的ViewModel赋值
        mBinding.setViewModel(mViewModel);

    }

    public void append(View view) {
        mViewModel.username.setValue(mViewModel.username.getValue() + "m");
    }
}