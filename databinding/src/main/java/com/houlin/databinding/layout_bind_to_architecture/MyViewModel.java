package com.houlin.databinding.layout_bind_to_architecture;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 使用ViewModel将数据绑定到布局
 * 在ViewModel中还可以用LiveData转换数据或合并多个数据源
 * ViewModel和dataBinding结合使用，可将界面逻辑从布局移出到ViewModel
 *
 * @author Harry Jing
 * @date 2020/9/13
 */
public class MyViewModel extends ViewModel {
    // 访问权限为public，才可以在布局中访问
    public MutableLiveData<String> username;

    public MyViewModel() {
        username = new MutableLiveData<>();
        username.setValue("Tom");
    }
}
