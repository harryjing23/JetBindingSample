package com.houlin.databinding.binding_adapters;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingConversion;
import androidx.databinding.ObservableArrayMap;

import com.houlin.databinding.databinding.ActivityConvertBinding;

/**
 * 自动转换：
 * 当绑定表达式返回类型为Object时，Object会转换为所选方法的参数类型
 * <p>
 * 自定义转换：
 * 当自动转换无法转换为目标数据时，还可以用@BindingConversion实现自定义转换
 * BindingConversion方法定义在任何类中都可以，但访问权限必须是public static
 */
public class ConvertActivity extends AppCompatActivity {
    private static final String TAG = "ConvertActivity";
    ActivityConvertBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_convert);
        mBinding = ActivityConvertBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();
        user.put("firstName", "first");
        user.put("lastName", "last");
        user.put("age", 10);
        mBinding.setUser(user);
    }

    /**
     * 用自定义转换，将int类型转换成ColorDrawable
     */
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        Log.d(TAG, "convertColorToDrawable: " + color);
        return new ColorDrawable(color);
    }

}