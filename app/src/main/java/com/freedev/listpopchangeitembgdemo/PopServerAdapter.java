package com.freedev.listpopchangeitembgdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * @Author: jakezhang
 * Company:DHC
 * Description： 描述内容
 * Date: 2019/7/22 17:50
 */
public class PopServerAdapter extends BaseAdapter {

    private Context context;
    private List<ServerPopBean> list;
    private int selecPosition=-1;

    public void setSelecPosition(int selecPosition){
        this.selecPosition=selecPosition;
    }

    public PopServerAdapter(Context context, List<ServerPopBean> list){
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.pop_item_server_ip_layout,parent,false);
        if (selecPosition==position){
            view.setBackgroundColor(context.getResources().getColor(R.color.white));

        }else{
            view.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        }
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
        TextView name=view.findViewById(R.id.item_serverIpTV);
        name.setText(list.get(position).getServer_name());
        return view;
    }
}
