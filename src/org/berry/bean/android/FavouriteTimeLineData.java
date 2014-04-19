package org.berry.bean.android;

import org.berry.bean.FavListBean;

/**
 * User: 卓小霖
 */
public class FavouriteTimeLineData {
    public FavListBean favList;
    public TimeLinePosition position;
    public int page;

    public FavouriteTimeLineData(FavListBean favList, int page, TimeLinePosition position) {
        this.favList = favList;
        this.page = page;
        this.position = position;
    }
}
