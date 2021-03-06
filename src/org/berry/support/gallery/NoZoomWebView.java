package org.berry.support.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 Berry
 */
public class NoZoomWebView extends WebView {
    public NoZoomWebView(Context context) {
        super(context);
    }

    public NoZoomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoZoomWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @SuppressWarnings("deprecation")
	public NoZoomWebView(Context context, AttributeSet attrs, int defStyle, boolean privateBrowsing) {
        super(context, attrs, defStyle, privateBrowsing);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public boolean canScrollHorizontally(int direction) {
        return false;
    }
}
