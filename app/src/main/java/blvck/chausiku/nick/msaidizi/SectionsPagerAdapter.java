package blvck.chausiku.nick.msaidizi;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * Created by Nick on 6/27/2017.
 */

class SectionsPagerAdapter extends FragmentPagerAdapter{

    public SectionsPagerAdapter(FragmentManager fragmentManager)
    {
        super(fragmentManager);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return null;

            case 1:

                return null;

            default:

                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch(position)
        {
            case 0:

                return "";

            case 1:

                return "";

            default:

                return null;
        }
    }
}
