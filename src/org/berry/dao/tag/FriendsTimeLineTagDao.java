package org.berry.dao.tag;

import org.berry.bean.TagBean;
import org.berry.dao.URLHelper;
import org.berry.support.debug.AppLogger;
import org.berry.support.error.WeiboException;
import org.berry.support.http.HttpMethod;
import org.berry.support.http.HttpUtility;
import org.berry.support.settinghelper.SettingUtility;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * User: qii
 * Date: 12-8-5
 */
public class FriendsTimeLineTagDao {

    private String getMsgListJson() throws WeiboException {
        String url = URLHelper.TAGS;

        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", access_token);
        map.put("uid", uid);
        map.put("count", count);
        map.put("page", page);


        String jsonData = HttpUtility.getInstance().executeNormalTask(HttpMethod.Get, url, map);


        return jsonData;
    }

    public List<TagBean> getGSONMsgList() throws WeiboException {

        String json = getMsgListJson();
        List<TagBean> tagBeanList = new ArrayList<TagBean>();

        try {
            JSONArray array = new JSONArray(json);
            int size = array.length();
            for (int i = 0; i < size; i++) {
                TagBean bean = new TagBean();
                JSONObject jsonObject = array.getJSONObject(i);
                Iterator<String> iterator = jsonObject.keys();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (key.equalsIgnoreCase("weight")) {
                        String value = jsonObject.optString(key);
                        bean.setWeight(value);
                    } else {
                        String value = jsonObject.optString(key);
                        bean.setId(Integer.valueOf(key));
                        bean.setName(value);
                    }
                }
                tagBeanList.add(bean);
            }

        } catch (JSONException e) {
            AppLogger.e(e.getMessage());
        }


        return tagBeanList;
    }


    private String access_token;
    private String uid;
    private String count;
    private String page;

    public FriendsTimeLineTagDao(String access_token, String uid) {

        this.access_token = access_token;
        this.uid = uid;
        this.count = SettingUtility.getMsgCount();
    }


    public void setCount(String count) {
        this.count = count;
    }


    public void setPage(String page) {
        this.page = page;
    }
}
