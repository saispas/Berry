package org.berry.ui.userinfo;

import org.berry.bean.UserBean;
import org.berry.ui.interfaces.AbstractAppActivity;
import org.berry.ui.interfaces.IUserInfo;
import org.berry.ui.main.MainTimeLineActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * User: qii
 * Date: 13-6-21
 */
public class UserTimeLineActivity extends AbstractAppActivity implements IUserInfo {

    private UserBean bean;


    @Override
    public UserBean getUser() {
        return bean;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowTitleEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
        String token = getIntent().getStringExtra("token");
        bean = (UserBean) getIntent().getParcelableExtra("user");
        getActionBar().setTitle(bean.getScreen_name());
        if (getSupportFragmentManager()
                .findFragmentByTag(StatusesByIdTimeLineFragment.class.getName()) == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content,
                            new StatusesByIdTimeLineFragment(getUser(), token),
                            StatusesByIdTimeLineFragment.class.getName())
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
