package com.houlin.databinding.two_way_binding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.lifecycle.ViewModelProvider;

import com.houlin.databinding.databinding.ActivityCustomAttributeBinding;

/**
 * 自定义特性的双向绑定：
 * 通过@InverseBindingAdapter或@InverseBindingMethod实现"视图驱动数据"的逆向绑定（InverseBindingMethod没用过）
 * <p>
 * <p>
 * PS：大多数原生控件已经实现了对应的BindingAdapter(eg. TextViewBindingAdapter)，用于支持双向绑定
 */
public class CustomAttributeActivity extends AppCompatActivity {
    private static final String TAG = "CustomAttributeActivity";
    private ActivityCustomAttributeBinding mBinding;
    private CustomAttrViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCustomAttributeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.setLifecycleOwner(this);

        mViewModel = new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(CustomAttrViewModel.class);
        mBinding.setViewModel(mViewModel);
    }

    /**
     * 自定义特性 数据中设置值的方法
     * 数据->视图
     * 用@BindingAdapter
     * <p>
     * ### 在@BindingAdapter方法中，一定要先进行新、旧值对比
     */
    @BindingAdapter("data")
    public static void setData(EditText view, String newValue) {
        Log.d(TAG, "setData: ");
        // ### 先进行新、旧值对比，防止死循环 ###
        // 死循环：（用户）更新视图->@InverseBindingAdapter->对数据赋值->@BindingAdapter->更新视图->...
        if (!TextUtils.equals(view.getText().toString(), newValue)) {
            view.setText(newValue);
        }
    }

    /**
     * 自定义特性 从视图中取值的方法
     * 视图->数据
     * 用@InverseBindingAdapter，同样也要求是public static方法
     */
    @InverseBindingAdapter(attribute = "data", event = "dataAttrChanged")
    public static String getData(EditText view) {
        Log.d(TAG, "getData: ");
        return view.getText().toString();
    }

    /**
     * 每个双向绑定都会生成“合成事件特性”。该特性与基本特性具有相同的名称，但包含后缀 "AttrChanged"
     * 合成事件特性允许在@BindingAdapter注释的方法中，将控件的事件监听器与相应的View实例相关联
     * 在视图的事件回调中，调用InverseBindingListener的onChange()，用于将特性的更改告知dataBinding
     */
    @BindingAdapter("dataAttrChanged")
    public static void setDataListener(EditText view, final InverseBindingListener attrChange) {
        if (attrChange != null) {
            view.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    Log.d(TAG, "onTextChanged: ");
                    attrChange.onChange();
                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
        }
    }

    public void toastData(View view) {
        Toast.makeText(this, "" + mViewModel.data.getValue(), Toast.LENGTH_SHORT).show();
    }

    public void reset(View view) {
        mViewModel.data.setValue("reset");
    }
}