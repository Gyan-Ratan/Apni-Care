package com.example.apnicare.YourOrders;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Orderviewpager extends FragmentStateAdapter {

    /*private String[] titles= new String[]{"Delivered","Pending","Confirmed"};*/
    private String[] titles= new String[]{"Pending"};
    public Orderviewpager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Pendingorder();
/*            case 1:
                return new Deliveredorder();
            case 2:
                return new Confirmedorder();*/
        }
        return new Pendingorder();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

}
