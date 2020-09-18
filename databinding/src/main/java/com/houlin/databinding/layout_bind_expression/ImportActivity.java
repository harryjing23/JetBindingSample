package com.houlin.databinding.layout_bind_expression;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.houlin.databinding.databinding.ActivityImportBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入、变量和包含：
 * 导入：在layout标签中用import标签导入绑定表达式中使用的类。类名冲突时，可以使用alias属性设置别名
 * <p>
 * 变量：在layout标签中用variable标签声明变量，再用绑定类给变量赋值
 * 绑定类对每个变量都生成getter和setter，在调用setter赋值之前，变量都为默认值
 * 若多个适配的布局文件，则变量会合并在一起，所以变量不要冲突
 * 系统会在布局文件中生成一个特殊变量context，是根视图的getContext()。可以被显式变量声明覆盖
 * <p>
 * 包含：在使用include标签时，用属性 bind:xxx=@{变量} 可以将变量传递到子布局中，前提是子布局也声明了该变量
 * 变量传递 不支持include作为merge的直接子标签
 */

public class ImportActivity extends AppCompatActivity {

    ActivityImportBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_import);

        mBinding = ActivityImportBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        List<User> list = new ArrayList<>();
        list.add(new User("first", "last"));
        mBinding.setList(list);
    }
}