package example.com.glynk.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import example.com.glynk.R;
import example.com.glynk.fragment.DesignFragment;
import example.com.glynk.fragment.MoviesFragment;
import example.com.glynk.fragment.PoliticsFragment;
import example.com.glynk.fragment.SportsFragment;
import example.com.glynk.fragment.TechnologiesFragment;

/**
 * Created by ayushgarg on 15/12/17.
 */

public class SectionPagerAdapter extends FragmentStatePagerAdapter {

    Context context;

    public SectionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SportsFragment.newInstance();
            case 1:
                return TechnologiesFragment.newInstance();
            case 2:
                return PoliticsFragment.newInstance();
            case 3:
                return MoviesFragment.newInstance();
            case 4:
                return DesignFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.sport);
            case 1:
                return context.getString(R.string.technology);
            case 2:
                return context.getString(R.string.movie);
            case 3:
                return context.getString(R.string.politics);
            case 4:
                return context.getString(R.string.design);
        }
        return null;
    }
}
