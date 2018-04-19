package br.usjt.viewpagercomfragmets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by arqdsis on 18/04/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BlankFragment1();
            case 1:
                return new BlankFragment2();
            default:
                return new BlankFragment3();

            }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
