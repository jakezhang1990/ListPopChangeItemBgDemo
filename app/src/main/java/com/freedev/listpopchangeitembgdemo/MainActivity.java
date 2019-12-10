package com.freedev.listpopchangeitembgdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    Button btn;
    ListPopupWindow listPopupWindow;
    PopServerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.buttonPanel);
        btn.setOnClickListener(this);
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
        List<ServerPopBean> list=new ArrayList<>();
        for (int i=0;i<5;i++){
            ServerPopBean bean=new ServerPopBean();
            bean.setServer_name("item "+i);
            list.add(bean);
        }
        adapter=new PopServerAdapter(this,list);
        listPopupWindow.setAdapter(adapter);
        listPopupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        listPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        listPopupWindow.setModal(true);
        listPopupWindow.setAnchorView(btn);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPopupWindow.setOnItemClickListener(this);
        listPopupWindow.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        if (listPopupWindow==null) {
            listPopupWindow = new ListPopupWindow(this);
            listPopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.dialog_bg));
        }
        listPopupWindow.show();
    }
//监听点击事件
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "msg="+((ServerPopBean)adapter.getItem(position)).getServer_name(), Toast.LENGTH_SHORT).show();
        listPopupWindow.dismiss();
    }

    //监听到获取了焦点的item的position并刷新整个列表绘制显示
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        adapter.setSelecPosition(position);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
