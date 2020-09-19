package com.houlin.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.binding_adapters.BindingAdapterActivity;
import com.houlin.databinding.binding_adapters.BindingMethodActivity;
import com.houlin.databinding.binding_adapters.ConversionActivity;
import com.houlin.databinding.binding_class.AdvanceBindingActivity;
import com.houlin.databinding.binding_class.BindingClassActivity;
import com.houlin.databinding.binding_class.CustomClassActivity;
import com.houlin.databinding.binding_class.ViewStubActivity;
import com.houlin.databinding.layout_bind_expression.EventHandleActivity;
import com.houlin.databinding.layout_bind_expression.ExpressionActivity;
import com.houlin.databinding.layout_bind_expression.ImportActivity;
import com.houlin.databinding.layout_bind_to_architecture.BindArchitectureActivity;
import com.houlin.databinding.layout_bind_expression.BindDataActivity;
import com.houlin.databinding.observable_data.ObservableActivity;
import com.houlin.databinding.two_way_binding.ConverterActivity;
import com.houlin.databinding.two_way_binding.CustomAttributeActivity;
import com.houlin.databinding.two_way_binding.TwoWayActivity;

/**
 * https://developer.android.google.cn/topic/libraries/data-binding
 * <p>
 * dataBinding将数据直接分配到view上，使用可观察对象、字段或集合刷新界面
 * 优点：
 * 1. 可以移除 Activity 中的许多界面框架调用，使其维护起来更简单、方便
 * 2. 还可以提高应用性能，并且有助于防止内存泄漏以及避免发生 Null 指针异常
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void gotoActivity(Class<?> tClass) {
        Intent intent = new Intent(this, tClass);
        startActivity(intent);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            // ---------布局和绑定表达式
            case R.id.bt_bind_data:
                gotoActivity(BindDataActivity.class);
                break;
            case R.id.bt_expression:
                gotoActivity(ExpressionActivity.class);
                break;
            case R.id.bt_event_handle:
                gotoActivity(EventHandleActivity.class);
                break;
            case R.id.bt_import:
                gotoActivity(ImportActivity.class);
                break;
            // ---------使用可观察的数据对象
            case R.id.bt_observable:
                gotoActivity(ObservableActivity.class);
                break;
            // ---------生成的绑定类
            case R.id.bt_binding_class:
                gotoActivity(BindingClassActivity.class);
                break;
            case R.id.bt_view_stub:
                gotoActivity(ViewStubActivity.class);
                break;
            case R.id.bt_advance_binding:
                gotoActivity(AdvanceBindingActivity.class);
                break;
            case R.id.bt_custom_class:
                gotoActivity(CustomClassActivity.class);
                break;
            // ---------绑定适配器
            case R.id.bt_binding_method:
                gotoActivity(BindingMethodActivity.class);
                break;
            case R.id.bt_binding_adapter:
                gotoActivity(BindingAdapterActivity.class);
                break;
            case R.id.bt_convert:
                gotoActivity(ConversionActivity.class);
                break;
            // ---------将布局视图绑定到架构组件
            case R.id.bt_live_data:
                gotoActivity(BindArchitectureActivity.class);
                break;
            // ---------双向数据绑定
            case R.id.bt_two_way:
                gotoActivity(TwoWayActivity.class);
                break;
            case R.id.bt_custom_Attribute:
                gotoActivity(CustomAttributeActivity.class);
                break;
            case R.id.bt_converter:
                gotoActivity(ConverterActivity.class);
                break;
            default:
                break;
        }
    }
}