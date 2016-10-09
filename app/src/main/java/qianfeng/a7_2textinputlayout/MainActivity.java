package qianfeng.a7_2textinputlayout;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.et);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(s.toString().contains("@"))
                {
                    editText.setError(null);// 看API，这里设置为null，错误的图标和文本都会被清除
                }else
                {
                    editText.setError("邮箱地址非法");
                }
                Log.d("google-my:", "afterTextChanged: " + s);
            }
        });




        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        EditText et = textInputLayout.getEditText();

        textInputLayout.setHint("请输入邮箱地址");
        textInputLayout.setCounterEnabled(true); // 右下方会出现计数的数字

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().contains("@"))
                {
                    textInputLayout.setErrorEnabled(false); // 取消错误提示
                }else
                {
                    textInputLayout.setError("邮箱地址非法");
                    textInputLayout.setErrorEnabled(true); // 显示错误提示
                }
            }
        });

    }
}
