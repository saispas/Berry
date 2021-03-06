package org.berry.dao.dm;

import org.berry.dao.URLHelper;
import org.berry.support.error.WeiboException;
import org.berry.support.http.HttpMethod;
import org.berry.support.http.HttpUtility;

import java.util.HashMap;
import java.util.Map;

/**
 * User: qii
 * Date: 13-3-2
 * http://open.weibo.com/wiki/2/direct_messages/new
 */
public class SendDMDao {


    public boolean send() throws WeiboException {
        String apiUrl = URLHelper.DM_SENT;

        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);
        map.put("text", text);
        map.put("uid", uid);
        HttpUtility.getInstance().executeNormalTask(HttpMethod.Post, apiUrl, map);

        return true;

    }

    public SendDMDao(String token, String uid, String text) {
        this.access_token = token;
        this.uid = uid;
        this.text = text;
    }

    private String access_token;
    private String text;
    private String uid;
}
