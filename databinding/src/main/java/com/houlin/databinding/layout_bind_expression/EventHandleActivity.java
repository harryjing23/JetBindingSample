package com.houlin.databinding.layout_bind_expression;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityEventHandleBinding;

/**
 * ###事件处理：
 * 事件的特性名称由监听器方法的名称确定（eg. View.OnClickListener中的onClick方法），但也有一些例外情况
 * <p>
 * 处理事件的两种机制：
 * 1.方法引用：引用的方法必须与监听器方法的参数类型一致
 * 2.监听器绑定：引用的方法只要返回值与监听器方法的返回值类型一致即可
 * 方法引用的监听器实现是在绑定数据时（编译时）创建的；监听器绑定的监听器实现是在事件触发时（运行时）对表达式求值后创建的
 * <p>
 * 事件处理的逻辑要放在具体的方法中，保持布局文件的简洁、易读
 */
public class EventHandleActivity extends AppCompatActivity {

    private ActivityEventHandleBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handle);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_event_handle);

        mBinding.setMyHandler(new MyHandler());
    }

    public static class MyHandler {
        private static final String TAG = "MyHandler";

        // 方法引用：要与监听器方法onClick(View)的参数类型一致
        public void method(View view) {
            Log.d(TAG, "method references");
        }

        // 监听器绑定：
        public void listener() {
            Log.d(TAG, "listener bindings");
        }

        public void doSomething() {
            Log.d(TAG, "doSomething: ");
            // do something
        }
    }
}