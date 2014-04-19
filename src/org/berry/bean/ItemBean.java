package org.berry.bean;

import android.text.SpannableString;

/**
 * User: 卓小霖
 */
public abstract class ItemBean {
    public abstract SpannableString getListViewSpannableString();

    public abstract String getListviewItemShowTime();

    public abstract String getText();

    public abstract String getCreated_at();

    public abstract void setMills(long mills);

    public abstract long getMills();

    public abstract String getId();

    public abstract long getIdLong();

    public abstract UserBean getUser();

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemBean && ((ItemBean) o).getId().equals(getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
