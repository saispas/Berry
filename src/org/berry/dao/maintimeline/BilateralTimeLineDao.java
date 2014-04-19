package org.berry.dao.maintimeline;

import org.berry.dao.URLHelper;

/**
 * User: 卓小霖
 */
public class BilateralTimeLineDao extends MainFriendsTimeLineDao {

    public BilateralTimeLineDao(String access_token) {
        super(access_token);
    }

    @Override
    protected String getUrl() {
        return URLHelper.BILATERAL_TIMELINE;
    }
}
