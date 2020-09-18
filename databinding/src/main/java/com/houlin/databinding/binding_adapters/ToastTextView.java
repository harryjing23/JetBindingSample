package com.houlin.databinding.binding_adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * 指定自定义方法名称：
 * 相当于自定义View中的自定义属性，可在布局中设置，在View中获取特性值并在方法中处理逻辑
 * 使用@BindingMethods，可包含多个@BindingMethod
 * 在@BindingMethod中，attribute对应的特性在布局中用"app:特性"设置，不能用"android:特性"
 * 注意：布局中的特性值，要用表达式，不能像设置系统自带的特性值那样
 *
 * @author Harry Jing
 * @date 2020/9/10
 */

// BindingMethod可以定义在任意类的外面，详见Methods类
//@BindingMethods({
//        @BindingMethod(type = ToastTextView.class, attribute = "toast", method = "showToast"),
//        @BindingMethod(type = ToastTextView.class, attribute = "content", method = "showContent")
//})
public class ToastTextView extends TextView {
    private static final String TAG = "ToastTextView";

    public ToastTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void showToast(String str) {
        Log.d(TAG, "showToast: " + str);
        Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void showContent(String str) {
        Log.d(TAG, "showContent: " + str);
        setText(str);
    }

}
