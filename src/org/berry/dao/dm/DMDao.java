package org.berry.dao.dm;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.berry.bean.DMUserBean;
import org.berry.bean.DMUserListBean;
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
 * Date: 12-11-14
 */
public class DMDao {

    private String access_token;
    private String cursor = "0";
    private String count;

    public DMDao(String token) {
        this.access_token = token;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
        this.count = SettingUtility.getMsgCount();
    }

    public DMUserListBean getUserList() throws WeiboException {
        String url = URLHelper.DM_USERLIST;
        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);
        map.put("count", count);
        map.put("cursor", cursor);

        String jsonData = HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, url, map);
        DMUserListBean value = null;
        try {
            value = new Gson().fromJson(jsonData, DMUserListBean.class);
            for (DMUserBean b : value.getItemList()) {
                b.getListViewSpannableString();
                b.getListviewItemShowTime();
            }
        } catch (JsonSyntaxException e) {

            AppLogger.e(e.getMessage());

        }
        return value;
    }

}
