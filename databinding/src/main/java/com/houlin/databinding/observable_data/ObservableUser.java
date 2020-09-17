package com.houlin.databinding.observable_data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.houlin.databinding.BR;

/**
 * 可观察对象：
 * <p>
 * 继承BaseObservable（必须提供getter和setter）：
 * 1.getter上加@Bindable
 * 2.setter中加notifyPropertyChanged()
 * <p>
 * 若数据类的基类无法更改为BaseObservable，则只能实现Observable接口：
 * Observable接口可以使用PropertyChangeRegistry对象实现，以便有效地注册和通知监听器
 *
 * @author Harry Jing
 * @date 2020/9/16
 */
public class ObservableUser extends BaseObservable {

    private String firstName;
    private String lastName;

    // getter上加@Bindable，会在BR类中生成字段的id
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        // 1)通知监听器，指定的属性已经更改
        // ###参数为getter在BR类中生成的id，以便调用getter获取新数据（BR类还会为布局中的变量生成id）
        notifyPropertyChanged(BR.firstName);
        // 2)通知监听器，所有的属性都已经更改
//        notifyChange();
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
