package org.berry.dao.maintimeline;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.berry.bean.GroupListBean;
import org.berry.dao.URLHelper;
import org.berry.support.debug.AppLogger;
import org.berry.support.error.WeiboException;
import org.berry.support.http.HttpMethod;
import org.berry.support.http.HttpUtility;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 卓小霖
 */
public class FriendGroupDao {


    public GroupListBean getGroup() throws WeiboException {

        String url = URLHelper.FRIENDSGROUP_INFO;

        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);

        String jsonData = HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, url, map);

        Gson gson = new Gson();

        GroupListBean value = null;
        try {
            value = gson.fromJson(jsonData, GroupListBean.class);
        } catch (JsonSyntaxException e) {
            AppLogger.e(e.getMessage());
        }


        return value;
    }


    public FriendGroupDao(String token) {
        this.access_token = token;
    }

    private String access_token;
}
