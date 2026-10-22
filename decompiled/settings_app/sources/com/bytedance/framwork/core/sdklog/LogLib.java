package com.bytedance.framwork.core.sdklog;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class LogLib {
    public static final String CHARSET_NAME = "UTF-8";
    private static boolean sInited;
    private static ILogDelegate sLogDelegateImpl;

    public static class DefaultLogDelegateImpl implements ILogDelegate {
        @Override // com.bytedance.framwork.core.sdklog.LogLib.ILogDelegate
        public boolean isNetworkAvailable(Context r1) {
            return false;
        }

        public DefaultLogDelegateImpl() {
        }
    }

    public interface ILogDelegate {
        boolean isNetworkAvailable(Context r1);
    }

    public LogLib() {
    }

    static {
        sLogDelegateImpl = new DefaultLogDelegateImpl();
    }

    public static void init(ILogDelegate r1) {
        if (sInited == false) goto L5;
        return;
    L5:
        if (r1 == null) goto L7;
        sLogDelegateImpl = r1;
    L7:
        sInited = true;
    }

    static boolean isNetworkAvailable(Context r1) {
        return sLogDelegateImpl.isNetworkAvailable(r1);
    }

    public static byte[] safeGetBytes(String r1) {
        if (r1 != null) goto L10;
    L8:
        return null;
    L10:
        if (r1.length() <= 0) goto L8;
        return r1.getBytes("UTF-8");
    L12:
        return r1.getBytes();
    }
}
