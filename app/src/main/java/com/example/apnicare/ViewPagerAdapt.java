package com.example.apnicare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapt extends PagerAdapter {
    Context context;
    int images[]={
            R.drawable._23456,
            R.drawable._6174,
            R.drawable._5487,
            R.drawable._23456,
            R.drawable._6174

    };

    int desc[]={
            R.string.pres_desc1,
            R.string.presc_desc2,
            R.string.presc_desc3,
            R.string.presc_desc4,
            R.string.presc_desc5,
    };

    int heading[]={
            R.string.pres_title1,
            R.string.presc_title2,
            R.string.presc_title3,
            R.string.presc_title4,
            R.string.presc_title5
    };

    public ViewPagerAdapt(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.pres_layout,container,false);

        ImageView slidetitleimage=(ImageView) view.findViewById(R.id.presimage);
        TextView sliderheading=(TextView) view.findViewById(R.id.texttitle);
        TextView sliderDesc=(TextView)  view.findViewById(R.id.textdesc);

        slidetitleimage.setImageResource(images[position]);
        sliderheading.setText(heading[position]);
        sliderDesc.setText(desc[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
