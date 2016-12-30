package main_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varvind.congress.R;

import leg_frag.house_leg;
import leg_frag.senate_leg;
import leg_frag.state_leg;

/**
 * Created by v Arvind on 11/20/2016.
 */
public class frag_leg extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leg,container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("By States"),
                state_leg.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("Senate"),
                senate_leg.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentd").setIndicator("House"),
                house_leg.class, null);




        return rootView;
    }
}
