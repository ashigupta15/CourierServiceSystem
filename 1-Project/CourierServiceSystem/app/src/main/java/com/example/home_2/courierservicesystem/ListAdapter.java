package com.ashi.courierservicesystem;

/**
 * Created by Home-2 on 3/10/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.home_2.courierservicesystem.R;

import java.util.List;

public class ListAdapter extends BaseAdapter
{
    Context context;
    List<com.ashi.courierservicesystem.cources> valueList;
    public ListAdapter(List<com.ashi.courierservicesystem.cources> listValue, Context context)
    {
        this.context = context;
        this.valueList = listValue;
    }

    @Override
    public int getCount()
    {
        return this.valueList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return this.valueList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewItem viewItem = null;
        if(convertView == null)
        {
            viewItem = new ViewItem();
            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //LayoutInflater layoutInfiater = LayoutInflater.from(context);
            convertView = layoutInfiater.inflate(R.layout.list_adapter_view, null);

            viewItem.txtTitle = (TextView)convertView.findViewById(R.id.adapter_text_title);
            viewItem.txtDescription = (TextView)convertView.findViewById(R.id.adapter_text_description);
            viewItem.txtDescription1 = (TextView)convertView.findViewById(R.id.adapter_text_description1);
            viewItem.txtDescription2 = (TextView)convertView.findViewById(R.id.adapter_text_description2);
            viewItem.txtDescription3 = (TextView)convertView.findViewById(R.id.adapter_text_description3);
            viewItem.txtDescription4 = (TextView)convertView.findViewById(R.id.adapter_text_description4);
            viewItem.txtDescription5 = (TextView)convertView.findViewById(R.id.adapter_text_description5);
            viewItem.txtDescription6 = (TextView)convertView.findViewById(R.id.adapter_text_description6);
            viewItem.txtDescription7 = (TextView)convertView.findViewById(R.id.adapter_text_description7);
            convertView.setTag(viewItem);
        }
        else
        {
            viewItem = (ViewItem) convertView.getTag();
        }

        viewItem.txtTitle.setText(valueList.get(position).driverName);
        viewItem.txtDescription.setText(valueList.get(position).fromPlace);
        viewItem.txtDescription1.setText(valueList.get(position).toPlace);
        viewItem.txtDescription2.setText(valueList.get(position).arrivalDate);
        viewItem.txtDescription3.setText(valueList.get(position).arrivalTime);
        viewItem.txtDescription4.setText(valueList.get(position).departureDate);
        viewItem.txtDescription5.setText(valueList.get(position).departureTime);
        viewItem.txtDescription6.setText(valueList.get(position).durationTime);
        viewItem.txtDescription7.setText(valueList.get(position).amountPayable);

        return convertView;
    }
}

class ViewItem
{
    TextView txtTitle;
    TextView txtDescription;
    TextView txtDescription1;
    TextView txtDescription2;
    TextView txtDescription3;
    TextView txtDescription4;
    TextView txtDescription5;
    TextView txtDescription6;
    TextView txtDescription7;
}

