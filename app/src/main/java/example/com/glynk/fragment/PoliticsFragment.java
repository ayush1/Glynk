package example.com.glynk.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.glynk.R;

/**
 * Created by ayushgarg on 15/12/17.
 */

public class PoliticsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_politics, container, false);
        return view;
    }

    public static PoliticsFragment newInstance() {
        PoliticsFragment fragment = new PoliticsFragment();
        return fragment;
    }

}
