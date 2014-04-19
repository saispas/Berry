package org.berry.dao.maintimeline;

import org.berry.bean.CommentListBean;
import org.berry.support.error.WeiboException;

/**
 * User: 卓小霖
 */
public interface ICommentsTimeLineDao {
    public CommentListBean getGSONMsgList() throws WeiboException;

    public void setSince_id(String since_id);

    public void setMax_id(String max_id);
}
