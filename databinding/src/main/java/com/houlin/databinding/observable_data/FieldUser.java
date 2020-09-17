package com.houlin.databinding.observable_data;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * 可观察字段：
 * 访问权限要用public final或kotlin的只读属性，避免在访问期间开箱和封箱
 *
 * @author Harry Jing
 * @date 2020/9/16
 */
public class FieldUser {

    // 可观察字段
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();

}
