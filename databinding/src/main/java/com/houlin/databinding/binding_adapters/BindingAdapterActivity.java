package com.houlin.databinding.binding_adapters;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.adapters.ViewBindingAdapter;

import com.houlin.databinding.R;
import com.houlin.databinding.databinding.ActivityBindingAdapterBinding;
import com.squareup.picasso.Picasso;

public class BindingAdapterActivity extends AppCompatActivity {
    private static final String TAG = "BindingAdapterActivity";

    private ActivityBindingAdapterBinding mBinding;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_binding_adapter);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapter);

        mUser = new User();
        mBinding.setUser(mUser);
        mBinding.setAttach(mAttached);
        mBinding.setDetach(mDetached);
    }

    public void addLeft(View view) {
        mUser.age += 50;
        mBinding.setUser(mUser);
    }

    /**
     * 提供自定义逻辑：
     * 用@BindingAdapter可以指定多个attribute。requireAll默认为true，代表所有特性都设置了，才会调用方法
     * 注意：必须要public static方法，第一个参数必须是特性所属的视图
     */
    @BindingAdapter(value = {"imageUrl", "error"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable error) {
        Log.d(TAG, "loadImage: url: " + url + ", error: " + error);
        if (url == null) {
            url = "test";
        }
        if (error == null) {
            error = imageView.getContext().getResources()
                    .getDrawable(R.drawable.ic_launcher_background);
        }
        Picasso.get().load(url).error(error).into(imageView);
    }

    /**
     * 还可以在方法中同时接收旧值和新值：在参数中先声明旧值，再声明新值
     * BindingAdapter中还可以定义"android:特性"，与系统特性冲突时会替换系统的方法
     */
    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldLeft, int newLeft) {
        Log.d(TAG, "setPaddingLeft: oldLeft: " + oldLeft + ", newLeft: " + newLeft);
        if (oldLeft != newLeft) {
            view.setPadding(newLeft,
                    view.getPaddingTop(),
                    view.getPaddingRight(),
                    view.getPaddingBottom());
        }
    }

    /**
     * ###事件处理脚本只能与仅有一种抽象方法的接口或抽象类一起使用
     * 当监听器有多个方法时，必须将它拆分为多个监听器
     */
    @BindingAdapter(value = {"OnViewAttachedToWindow", "OnViewDetachedFromWindow"}, requireAll = false)
    public static void setListener(View view, final ViewBindingAdapter.OnViewAttachedToWindow attach,
                                   final ViewBindingAdapter.OnViewDetachedFromWindow detach) {
        View.OnAttachStateChangeListener newListener;
        if (detach == null && attach == null) {
            newListener = null;
        } else {
            // 本来就是将View.OnAttachStateChangeListener拆成了两个attach和detach接口，
            // 再在方法中将这两个拼成View.OnAttachStateChangeListener
            newListener = new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    if (attach != null) {
                        attach.onViewAttachedToWindow(v);
                    }
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    if (detach != null) {
                        detach.onViewDetachedFromWindow(v);
                    }
                }
            };
        }

        // 使用ListenerUtil可以避免旧listener无法释放导致内存泄漏
        // 使用ListenerUtil.trackListener()记录View的新listener，返回一个之前的旧listener
        // 也可以用ListenerUtil.getListener()获取View目前的listener
        View.OnAttachStateChangeListener oldListener = ListenerUtil.trackListener(view, newListener,
                R.id.onAttachStateChangeListener);

        if (oldListener != null) {
            view.removeOnAttachStateChangeListener(oldListener);
        }
        if (newListener != null) {
            view.addOnAttachStateChangeListener(newListener);
        }

    }

    // View.OnAttachStateChangeListener有两个方法，需要拆分成只有一个方法的两个接口
    private ViewBindingAdapter.OnViewAttachedToWindow mAttached = new ViewBindingAdapter.OnViewAttachedToWindow() {
        @Override
        public void onViewAttachedToWindow(View v) {
            Log.d(TAG, "onViewAttachedToWindow: ");
        }
    };
    private ViewBindingAdapter.OnViewDetachedFromWindow mDetached = new ViewBindingAdapter.OnViewDetachedFromWindow() {
        @Override
        public void onViewDetachedFromWindow(View v) {
            Log.d(TAG, "onViewDetachedFromWindow: ");
        }
    };
}