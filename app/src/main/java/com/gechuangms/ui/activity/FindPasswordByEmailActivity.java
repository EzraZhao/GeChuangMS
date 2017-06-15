package com.gechuangms.ui.activity;

import com.gechuangms.R;
import com.gechuangms.view.IFindPasswordByEmail;

/**
 * Created by Ezra on 2017/6/13.
 */

public class FindPasswordByEmailActivity extends BaseActivity implements IFindPasswordByEmail {

    private static final String TAG = "FindPasswordByEmailActi";
    
    @Override
    public int getLayoutRes() {
        return R.layout.activity_find_by_email;
    }

    @Override
    public void onSendEmailSuccess() {
        
    }
}
