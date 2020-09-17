package com.houlin.databinding.observable_data;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;

import com.houlin.databinding.databinding.ActivityObservableBinding;

/**
 * 可观察数据分为：对象、字段、集合
 * 使用可观察数据可以在数据发生改变时自动刷新界面
 * <p>
 * 可观察字段：
 * 当类中只有少数属性时，推荐使用可观察字段
 * 可观察字段的访问权限要用public final或kotlin的只读属性，避免在访问期间开箱和封箱
 * 可以使用ObservableField&lt;T>或特定的类（eg.ObservableByte, ObservableInt， ObservableParcelable）
 * 在访问字段时，用getter和setter
 * 还可以用LiveData替换可观察字段
 * <p>
 * 可观察对象：
 * 要实现Observable接口，自己完成添加和移除监听器
 * BaseObservable实现了Observable接口，将它作为基类即可在属性发生变化时发出通知
 * 需要在BaseObservable中：
 * 1.在getter上添加@Bindable
 * 2.在setter中调用notifyPropertyChanged()
 * <p>
 * 可观察集合：
 * ObservableMap和ObservableList，实现类分别是ObservableArrayMap和ObservableArrayList
 * 当key为int类型时，用ObservableList；当key为引用类型时，用ObservableMap
 */
public class ObservableActivity extends AppCompatActivity {

    private ActivityObservableBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observable);

        mBinding = ActivityObservableBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());


        // 可观察字段：
        FieldUser fieldUser = new FieldUser();
        // 可观察字段setter
        fieldUser.firstName.set("first");
        fieldUser.lastName.set("last");
        fieldUser.age.set(80);
        // 可观察字段getter
        String last = fieldUser.lastName.get();
        mBinding.setFieldUser(fieldUser);

        // 可观察集合：
        // Map
        ObservableMap<String, Object> map = new ObservableArrayMap<>();
        map.put("firstName", "first");
        map.put("lastName", "last");
        map.put("age", 10);
        mBinding.setMap(map);
        // List
        ObservableList<String> list = new ObservableArrayList<>();
        list.add("first");
        list.add("last");
        mBinding.setList(list);

        // 可观察对象：
        ObservableUser observableUser = new ObservableUser();
        observableUser.setFirstName("first");
        observableUser.setLastName("last");
        mBinding.setUser(observableUser);
    }
}