package com.houlin.viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

import com.houlin.viewbinding.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

    private FragmentBlankBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_blank, container, false);

        // 获取绑定类实例。Fragment用3个参数的inflate方法
        mBinding = FragmentBlankBinding.inflate(inflater, container, false);
        // 如果布局已经inflate，可以使用绑定类的bind方法获取绑定类的实例
//        mBinding = FragmentBlankBinding.bind(view);

        FrameLayout root = mBinding.getRoot();
        // return根视图
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // ### Fragment的存在时间比视图长，所以在onDestroyView()中清除绑定类的引用
        mBinding = null;
    }
}