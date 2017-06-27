package blvck.chausiku.nick.msaidizi;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick on 6/27/2017.
 */

public class PendingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pendingFragment = inflater.inflate(R.layout.pendingfragment, container, false);
        return pendingFragment;
    }
}
