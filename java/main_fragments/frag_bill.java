package main_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.varvind.congress.R;

import bill_frag.active_bill;
import bill_frag.new_bill;

/**
 * Created by v Arvind on 11/20/2016.
 */
public class frag_bill extends Fragment {
    private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bil,container, false);


        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent1);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("Active Bills"),
                active_bill.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("New Bills"),
                new_bill.class, null);


        return rootView;
    }
}
