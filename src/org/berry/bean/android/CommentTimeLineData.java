package org.berry.bean.android;

import org.berry.bean.CommentListBean;

/**
 * User: 卓小霖
 */
public class CommentTimeLineData {
    public CommentListBean cmtList;
    public TimeLinePosition position;

    public CommentTimeLineData(CommentListBean cmtList, TimeLinePosition position) {
        this.cmtList = cmtList;
        this.position = position;
    }
}
