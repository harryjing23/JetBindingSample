package com.houlin.databinding.two_way_binding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Harry Jing
 * @date 2020/9/14
 */
public class CustomAttrViewModel extends ViewModel {

    public MutableLiveData<String> data = new MutableLiveData<>();

    public CustomAttrViewModel() {
        data.setValue("abc");
    }

}
