package com.houlin.databinding.binding_adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * 自动选择方法：
 * 在布局中设置attribute，会根据参数类型自动匹配setter
 * 在系统搜索setter时，不会考虑特性的命名空间。所以在布局中设置既可以用"android:特性"，也可以用"app:特性"
 * 注意：布局中的特性值，要用表达式，不能像设置系统自带的特性值那样
 *
 * @author Harry Jing
 * @date 2020/9/11
 */
public class MyTextView extends TextView {
    private static final String TAG = "MyTextView";

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setContent(String str) {
        Log.d(TAG, "setContent: " + str);
        setText(str);
    }
}
