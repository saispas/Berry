package org.berry.bean.android;

import org.berry.bean.MessageListBean;

/**
 * User: 卓小霖
 */
public class MyStatusTimeLineData {

    public MessageListBean msgList;
    public TimeLinePosition position;

    public MyStatusTimeLineData(MessageListBean msgList, TimeLinePosition position) {
        this.msgList = msgList;
        this.position = position;
    }
}
