package com.obric.matrix.badge;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.matrix.r.c.c;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class CommonBadgeNumProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UriMatcher f8830f = null;

    static {
        UriMatcher r0 = new UriMatcher(-1);
        f8830f = r0;
        r0.addURI("com.android.badge", "badge", 1);
        r0.addURI("com.android.badge", "badge/#", 2);
    }

    public CommonBadgeNumProvider() {
    }

    public boolean a(int r5, ArrayList<String> r6) {
        boolean r0 = false;
        if (r5 >= 0) goto L6;
        return false;
    L6:
        if (r6 != null) goto L9;
    L7:
        r0 = true;
    L13:
        c.b("WeiXinMsgNumProvider", "setAppBadgeCount   badgeCount: " + r5 + "   shortcutCustomIds:" + r6 + "  needSend: " + r0);
        if (r0 == false) goto L16;
        MessageBadgeProvider.e(getContext(), getCallingPackage(), r5, "WeiXinMsgNumProvider");
    L16:
        StringBuffer r4 = new StringBuffer();
        if (r6 != null) goto L19;
    L24:
        c.b("WeiXinMsgNumProvider", "onCall: method $method");
        return true;
    L19:
        if (r6.size() <= 0) goto L24;
        Iterator<String> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L24;
        r4.append("id [" + r7.next() + "], ");
        goto L22
    L9:
        if (r6.size() != 1) goto L13;
        if (r6.get(0) != null) goto L13;
        goto L13
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r6, String r7, Bundle r8) {
        boolean r1 = false;
        int r2 = -1;
    L13:
        e = move-exception;
        c.g("WeiXinMsgNumProvider", "call method error:" + r6, e);
        return r8;
    L5:
        if ("setAppBadgeCount".equals(r6) == false) goto L8;
        r2 = r8.getInt("app_badge_count");     // Catch: Exception -> L13
        r1 = a(r2, r8.getStringArrayList("app_shortcut_custom_id"));     // Catch: Exception -> L13
    L11:
        c.j("WeiXinMsgNumProvider", "call method:" + r6 + ", arg:" + r7 + ", count:" + r2 + ", result:" + r1 + "  badgeCount:" + r2 + "  extras:" + r8);     // Catch: Exception -> L13
        r8.putBoolean("result", r1);     // Catch: Exception -> L13
        return r8;
    L8:
        if ("setBadge".equals(r6) == false) goto L10;
        r2 = r8.getInt("count");     // Catch: Exception -> L13
        r1 = a(r2, null);     // Catch: Exception -> L13
        goto L11
    L10:
        c.s("WeiXinMsgNumProvider", "unknown method:" + r6 + ", arg:" + r7);     // Catch: Exception -> L13
        goto L11
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r3) {
        int r2 = f8830f.match(r3);
        if (r2 != 1) goto L5;
        return "vnd.android.cursor.dir/vnd.tencent.badge";
    L5:
        if (r2 != 2) goto L9;
        return "vnd.android.cursor.item/vnd.tencent.badge";
    L9:
        throw new IllegalArgumentException("Unknown URI: " + r3);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        c.j("WeiXinMsgNumProvider", "onCreate()");
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
