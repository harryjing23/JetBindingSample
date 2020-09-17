package com.houlin.databinding.binding_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;

import com.houlin.databinding.databinding.ActivityViewStubBinding;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;

import com.houlin.databinding.R;

/**
 * 由于ViewStub是不可见的视图，在inflate后会被另一个布局所取代
 * 所以绑定类不能引用ViewStub，才能让ViewStub被回收
 * <p>
 * 绑定类使用ViewStubProxy引用ViewStub。ViewStubProxy既可以访问ViewStub，也可以访问inflate的布局
 * 为ViewStubProxy设置ViewStub被inflate成功的回调setOnInflateListener()，以便在回调中获取inflate的布局
 */
public class ViewStubActivity extends AppCompatActivity {
    private static final String TAG = "ViewStubActivity";

    private ActivityViewStubBinding mBinding;
    private ViewStub mViewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_view_stub);

        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_view_stub,
                null, false);
        setContentView(mBinding.getRoot());

        final ViewStubProxy vsShow = mBinding.vsShow;
        // 获取inflate前的ViewStub
        mViewStub = vsShow.getViewStub();
        // 设置ViewStub被inflate成功的回调
        vsShow.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                Log.d(TAG, "onInflate: ");
                // 清除ViewStub的引用
                mViewStub = null;
                // 获取inflate后的布局的根视图
                View root = vsShow.getRoot();
                // 获取inflate后的布局的绑定类
                ViewDataBinding binding = vsShow.getBinding();
            }
        });

        mBinding.btInflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inflate ViewStub
                if (mViewStub != null) {
                    mViewStub.inflate();
                }
            }
        });
    }
}