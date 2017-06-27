package blvck.chausiku.nick.msaidizi;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick on 6/27/2017.
 */

public class HomePageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View homePage = inflater.inflate(R.layout.homepage, container, false);
        return homePage;
    }
}
