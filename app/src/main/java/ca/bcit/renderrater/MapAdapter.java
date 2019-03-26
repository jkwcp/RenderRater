package ca.bcit.renderrater;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;


public class MapAdapter extends FragmentPagerAdapter {
    LayoutInflater layoutInflater;
    Context mContext;

    public MapAdapter(FragmentManager fm, Context context){
        super(fm);
        layoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return new MapFragment();
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.95f;
    }


}