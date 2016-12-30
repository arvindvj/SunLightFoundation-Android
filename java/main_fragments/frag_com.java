package main_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varvind.congress.R;

import com_frag.house_com;
import com_frag.joint_com;
import com_frag.senate_com;

/**
 * Created by v Arvind on 11/20/2016.
 */
public class frag_com extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_com,container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent2);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("House"),
                house_com.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("Senate"),
                senate_com.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentd").setIndicator("Joint"),
                joint_com.class, null);


        return rootView;
    }
}
