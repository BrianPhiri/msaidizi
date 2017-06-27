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
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;

            case 1:
                PendingFragment pendingFragment = new PendingFragment();
                return pendingFragment;

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

                return "Request";

            case 1:

                return "Pending";

            default:

                return null;
        }
    }
}
