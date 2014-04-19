package org.berry.ui.userinfo;

import org.berry.R;
import org.berry.bean.UserBean;
import org.berry.ui.interfaces.AbstractAppActivity;
import org.berry.ui.interfaces.IUserInfo;
import org.berry.ui.main.MainTimeLineActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * User: Jiang Qi
 * Date: 12-8-16
 */
public class FanListActivity extends AbstractAppActivity implements IUserInfo {

    private String token;

    private UserBean bean;


    @Override
    public UserBean getUser() {
        return bean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getString(R.string.fan_list));
        getActionBar().setIcon(R.drawable.ic_ab_friendship);

        token = getIntent().getStringExtra("token");
        bean = (UserBean) getIntent().getParcelableExtra("user");

        if (getSupportFragmentManager().findFragmentByTag(FanListFragment.class.getName())
                == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new FanListFragment(bean.getId()),
                            FanListFragment.class.getName())
                    .commit();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                intent = MainTimeLineActivity.newIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
        }
        return false;
    }
}

