package org.berry.ui.maintimeline;

import org.berry.bean.GroupListBean;
import org.berry.dao.maintimeline.FriendGroupDao;
import org.berry.support.database.GroupDBTask;
import org.berry.support.error.WeiboException;
import org.berry.support.lib.MyAsyncTask;
import org.berry.support.utils.GlobalContext;

/**
 * User: qii
 * Date: 12-12-28
 */
public class GroupInfoTask extends MyAsyncTask<Void, GroupListBean, GroupListBean> {


    private WeiboException e;

    private String token;
    private String accountId;

    public GroupInfoTask(String token, String accountId) {
        this.token = token;
        this.accountId = accountId;
    }

    @Override
    protected GroupListBean doInBackground(Void... params) {
        try {
            return new FriendGroupDao(token).getGroup();
        } catch (WeiboException e) {
            this.e = e;
            cancel(true);
        }
        return null;
    }


    @Override
    protected void onPostExecute(GroupListBean groupListBean) {
        super.onPostExecute(groupListBean);

        GroupDBTask.update(groupListBean, accountId);
        if (accountId.equalsIgnoreCase(GlobalContext.getInstance().getCurrentAccountId()))
            GlobalContext.getInstance().setGroup(groupListBean);

    }

}