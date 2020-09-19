package com.houlin.databinding.two_way_binding;

import android.util.Log;

import androidx.databinding.InverseMethod;

/**
 * 转换器：
 * 将数据类型A转换为数据类型B
 * 用于当控件的特性值的数据类型与绑定的数据的数据类型不同时（需要数据类型转换时）
 * 若特性使用了双向绑定，还需要用@InverseMethod指定反向转换器（特性值的数据类型->绑定数据的数据类型）的方法名
 *
 * @author Harry Jing
 * @date 2020/9/14
 */
public class Converter {
    private static final String TAG = "Converter";

    @InverseMethod("stringToBoolean")
    public static String boolToString(Boolean newValue) {
        Log.d(TAG, "boolToString: ");
        return newValue ? "1" : "0";
    }

    public static Boolean stringToBoolean(String newValue) {
        Log.d(TAG, "stringToBoolean: ");
        return !"0".equals(newValue);// 非0则为true
    }

}
