package com.gechuangms.factory;

import com.gechuangms.R;
import com.gechuangms.ui.fragment.BaseFragment;
import com.gechuangms.ui.fragment.CommunityDynamicFragment;
import com.gechuangms.ui.fragment.CommunityFriendsFragment;
import com.gechuangms.ui.fragment.RelatedToMeFragment;

/**
 * Created by Ezra on 2017/5/29.
 */

public class FragmentFactory {

    public static final String TAG = "FragmentFactory";

    private static FragmentFactory sFragmentFactory;

    private BaseFragment mCommunityDynamicFragment;
    private BaseFragment mCommunityFriendsFragment;
    private BaseFragment mRelatedToMeFragment;

    public static FragmentFactory getInstance() {
        if (sFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (sFragmentFactory == null) {
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    public BaseFragment getFragment(int id) {
        switch (id) {
            case R.id.dynamic:
            return getCommunityDynamicFragment();
            case R.id.contacts:
            return getCommunityFriendsFragment();
            case R.id.related:
            return getRelatedToMeFragment();
        }
        return null;
    }

    private BaseFragment getCommunityDynamicFragment() {
        if (mCommunityDynamicFragment == null) {
            mCommunityDynamicFragment = new CommunityDynamicFragment();
        }
        return mCommunityDynamicFragment;
    }

    private BaseFragment getCommunityFriendsFragment() {
        if (mCommunityFriendsFragment == null) {
            mCommunityFriendsFragment = new CommunityFriendsFragment();
        }
        return mCommunityFriendsFragment;
    }

    private BaseFragment getRelatedToMeFragment() {
        if (mRelatedToMeFragment == null) {
            mRelatedToMeFragment = new RelatedToMeFragment();
        }
        return mRelatedToMeFragment;
    }

}
