package com.houlin.databinding.two_way_binding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author Harry Jing
 * @date 2020/9/14
 */
public class TwoWayViewModel extends ViewModel {

    public MutableLiveData<Boolean> mLiveDataIsRemember = new MutableLiveData<>();

    public TwoWayViewModel() {
        mLiveDataIsRemember.setValue(true);
    }

}
