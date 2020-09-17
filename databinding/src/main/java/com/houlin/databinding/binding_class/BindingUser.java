package com.houlin.databinding.binding_class;

import androidx.databinding.ObservableField;

/**
 * @author Harry Jing
 * @date 2020/9/17
 */
public class BindingUser {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
}
