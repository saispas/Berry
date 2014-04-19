package org.berry.bean.android;

import android.os.Bundle;

import org.berry.support.error.WeiboException;

/**
 * User: 卓小霖
 */
public class AsyncTaskLoaderResult<E> {
    public E data;
    public WeiboException exception;
    public Bundle args;
}
