package com.houlin.databinding.binding_adapters;

import android.widget.TextView;

import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/**
 * 单独存放@BindingMethods
 *
 * @author Harry Jing
 * @date 2020/9/10
 */

@BindingMethods({
        @BindingMethod(type = ToastTextView.class, attribute = "toast", method = "showToast"),
        @BindingMethod(type = TextView.class, attribute = "content", method = "showContent")
})
public final class Methods {
    private Methods() {
    }
}
