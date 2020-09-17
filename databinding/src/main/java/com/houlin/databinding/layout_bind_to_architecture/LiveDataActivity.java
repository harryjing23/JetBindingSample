package com.houlin.databinding.layout_bind_to_architecture;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding mBinding;
    private MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_live_data);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_live_data);

        // 为绑定类设置LifecycleOwner。LiveData与绑定类一起使用，所以这样可以定义LiveData的范围
        // ### 使用LiveData时一定要调用setLifecycleOwner()，否则LiveData不会被观察，导致数据变化不会更新视图
        mBinding.setLifecycleOwner(this);

        // 创建ViewModel实例
        mViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(MyViewModel.class);
        // 为绑定类的ViewMode赋值
        mBinding.setViewModel(mViewModel);

    }

    public void append(View view) {
        mViewModel.username.setValue(mViewModel.username.getValue() + "m");
    }
}