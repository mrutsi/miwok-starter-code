package com.example.android.miwok;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by codeTribe on 2017/06/30.
 */


public class WordAdapter extends ArrayAdapter<Word>{

private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word>androidFlavours,int colorResourceId){
        super(context,0,androidFlavours);
        mColorResourceId=colorResourceId;
    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent)
    {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_itemlist, parent, false);
        }
        Word currentWord = getItem(position);

        TextView mikokTextView = (TextView) listItemView.findViewById(R.id.miwork_text_view);
        mikokTextView.setText(currentWord.getmMiworkTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasimage())
        {
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else
        {
           imageView.setVisibility(View.GONE);
        }
        View textContainer=listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}

