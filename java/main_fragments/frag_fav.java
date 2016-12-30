package main_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.varvind.congress.R;

import fav_frag.bill_fav;
import fav_frag.com_fav;
import fav_frag.leg_fav;

/**
 * Created by v Arvind on 11/20/2016.
 */
public class frag_fav extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fav,container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent3);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("Legislators"),
                leg_fav.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("Bills"),
                bill_fav.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentd").setIndicator("Committees"),
                com_fav.class, null);
        TextView x = (TextView) mTabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        x.setTextSize(12);
        TextView y = (TextView) mTabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        y.setTextSize(12);

        return rootView;
    }
}
