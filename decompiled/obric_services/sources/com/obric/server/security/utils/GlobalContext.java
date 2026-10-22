package com.obric.server.security.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class GlobalContext {
    private static Context mContext;

    public GlobalContext() {
    }

    public static void setContext(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        return mContext;
    }
}
