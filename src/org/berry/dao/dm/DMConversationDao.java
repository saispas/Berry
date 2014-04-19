package org.berry.dao.dm;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.berry.bean.DMListBean;
import org.berry.dao.URLHelper;
import org.berry.support.debug.AppLogger;
import org.berry.support.error.WeiboException;
import org.berry.support.http.HttpMethod;
import org.berry.support.http.HttpUtility;
import org.berry.support.settinghelper.SettingUtility;

import java.util.HashMap;
import java.util.Map;

/**
 * User: qii
 * Date: 12-11-15
 */
public class DMConversationDao {
    private String access_token;
    private String uid;

    private String page;
    private String count;

    public DMConversationDao(String token) {
        this.access_token = token;
        this.count = SettingUtility.getMsgCount();
    }

    public DMConversationDao setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public DMConversationDao setPage(int page) {
        this.page = String.valueOf(page);
        return this;
    }

    public DMListBean getConversationList() throws WeiboException {
        String url = URLHelper.DM_CONVERSATION;
        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);
        map.put("uid", uid);
        map.put("page", page);
        map.put("count", count);

        String jsonData = HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, url, map);
        DMListBean value = null;
        try {
            value = new Gson().fromJson(jsonData, DMListBean.class);
        } catch (JsonSyntaxException e) {

            AppLogger.e(e.getMessage());

        }
        return value;
    }
}
