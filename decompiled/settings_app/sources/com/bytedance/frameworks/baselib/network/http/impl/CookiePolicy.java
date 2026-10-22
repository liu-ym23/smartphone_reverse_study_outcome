package com.bytedance.frameworks.baselib.network.http.impl;

import java.net.URI;

/* JADX INFO: loaded from: classes3.dex */
public interface CookiePolicy {
    public static final CookiePolicy ACCEPT_ALL = null;
    public static final CookiePolicy ACCEPT_NONE = null;
    public static final CookiePolicy ACCEPT_ORIGINAL_SERVER = null;

    boolean shouldAccept(URI r1, HttpCookie r2);

    static {
        ACCEPT_ALL = new AnonymousClass1();
        ACCEPT_NONE = new AnonymousClass2();
        ACCEPT_ORIGINAL_SERVER = new AnonymousClass3();
    }
}
