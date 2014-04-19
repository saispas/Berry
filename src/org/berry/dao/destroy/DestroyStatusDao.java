package org.berry.dao.destroy;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.berry.bean.MessageBean;
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
public class DestroyStatusDao {

    private String access_token;
    private String id;

    public DestroyStatusDao(String access_token, String id) {
        this.access_token = access_token;
        this.id = id;
    }

    public boolean destroy() throws WeiboException {
        String url = URLHelper.STATUSES_DESTROY;
        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);
        map.put("id", id);


        String jsonData = HttpUtility.getInstance().executeNormalTask(HttpMethod.Post, url, map);
        Gson gson = new Gson();

        try {
            MessageBean value = gson.fromJson(jsonData, MessageBean.class);
        } catch (JsonSyntaxException e) {
            AppLogger.e(e.getMessage());
            return false;
        }

        return true;


    }
}
