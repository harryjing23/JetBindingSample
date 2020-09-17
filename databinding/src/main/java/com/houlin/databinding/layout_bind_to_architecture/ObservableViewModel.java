package com.houlin.databinding.layout_bind_to_architecture;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

/**
 * 可观察的ViewModel：
 * 可让您更好地控制应用中的绑定适配器，即使这样会失去对LiveData的生命周期管理功能
 * 由于需要extends ViewModel，所以只能implements Observable来变为可观察的
 *
 * @author Harry Jing
 * @date 2020/9/14
 */
public class ObservableViewModel extends ViewModel implements Observable {
    private PropertyChangeRegistry callbacks = new PropertyChangeRegistry();

    /**
     * 提供观察器订阅
     */
    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    /**
     * 取消订阅通知
     */
    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    void notifyChange() {
        callbacks.notifyCallbacks(this, 0, null);
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    void notifyPropertyChanged(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

}
