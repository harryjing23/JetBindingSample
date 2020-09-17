package com.houlin.databinding.two_way_binding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.houlin.databinding.databinding.ActivityConverterBinding;

public class ConverterActivity extends AppCompatActivity {

    private ActivityConverterBinding mBinding;
    private ConverterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_converter);
        mBinding = ActivityConverterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(ConverterViewModel.class);
        mBinding.setViewModel(mViewModel);
    }

    public void reverse(View view) {
        mViewModel.mLiveData.setValue(!mViewModel.mLiveData.getValue());
    }

    public static class ConverterViewModel extends ViewModel {
        public MutableLiveData<Boolean> mLiveData = new MutableLiveData<>();

        public ConverterViewModel() {
            mLiveData.setValue(false);
        }
    }
}