package com.bytedance.bdturing.x;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.bdturing.g;
import com.bytedance.common.utility.i;
import com.bytedance.common.wschannel.WsConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.b0;
import kotlin.n0.d.o;
import kotlin.u0.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final StringBuilder a(StringBuilder r1, String r2, String r3) {
        o.g(r1, "$this$appendFirstParam");
        o.g(r2, "key");
        if (r3 != null) goto L10;
        return r1;
    L10:
        r1.append(r2);     // Catch: UnsupportedEncodingException -> L7
        r1.append("=");     // Catch: UnsupportedEncodingException -> L7
        r1.append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        g.e(e);
        goto L9
    }

    public static final StringBuilder b(StringBuilder r1, String r2, int r3) {
        o.g(r1, "$this$appendParams");
        o.g(r2, "key");
        c(r1, r2, String.valueOf(r3));
        return r1;
    }

    public static final StringBuilder c(StringBuilder r1, String r2, String r3) {
        o.g(r1, "$this$appendParams");
        o.g(r2, "key");
        if (r3 != null) goto L10;
        return r1;
    L10:
        r1.append("&");     // Catch: UnsupportedEncodingException -> L7
        r1.append(r2);     // Catch: UnsupportedEncodingException -> L7
        r1.append("=");     // Catch: UnsupportedEncodingException -> L7
        r1.append(URLEncoder.encode(r3, "utf-8"));     // Catch: UnsupportedEncodingException -> L7
    L9:
        return r1;
    L7:
        e = move-exception;
        g.e(e);
        goto L9
    }

    public static final StringBuilder d(String r7, JSONObject r8) {
        o.g(r7, WsConstants.KEY_CONNECTION_URL);
        o.g(r8, "params");
        StringBuilder r0 = new StringBuilder(r7);
        if (k.P(r7, '?', 0, false, 6, null) >= 0) goto L5;
        String r9 = "?";
    L6:
        r0.append(r9);
        ArrayList r10 = new ArrayList();
        Iterator<String> r1 = r8.keys();
    L8:
        if (r1.hasNext() == false) goto L15;
        String r2 = r1.next();
        String r3 = null;
        r3 = r8.getString(r2);     // Catch: Exception -> L12
    L14:
        r10.add(new Pair(r2, r3));
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    L15:
        r0.append(i.e(r10, "UTF-8"));
        return r0;
    L5:
        r9 = "&";
        goto L6
    }

    public static final StringBuilder e(JSONObject r6) {
        o.g(r6, "params");
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        Iterator<String> r2 = r6.keys();
    L4:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        String r4 = null;
        r4 = r6.getString(r3);     // Catch: Exception -> L8
    L10:
        r1.add(new Pair(r3, r4));
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        r0.append(i.e(r1, "UTF-8"));
        return r0;
    }

    public static final int f(Activity r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        WindowManager r4 = r3.getWindowManager();
        o.b(r4, "activity.windowManager");
        Display r5 = r4.getDefaultDisplay();
        o.b(r5, "activity.windowManager.defaultDisplay");
        int r6 = r5.getRotation();
        g.c("AbstractRequest", "rotation current " + r6);
        int r1 = 2;
        if (r6 == 0) goto L13;
        if (r6 == 1) goto L12;
        if (r6 == 2) goto L13;
        if (r6 == 3) goto L12;
        return 0;
    L12:
        r1 = 1;
    L13:
        com.bytedance.bdturing.e.m(r1);
        return r1;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static final float g(Context r4) {
        o.g(r4, "context");
        Method r0 = DisplayMetrics.class.getDeclaredMethod("getDeviceDensity", new Class[0]);     // Catch: Exception -> L8
        o.b(r0, "method");     // Catch: Exception -> L8
        r0.setAccessible(true);     // Catch: Exception -> L8
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
        if (r1 == null) goto L7;
        return ((Integer) r1).intValue() / 160.0f;
    L7:
        throw new b0("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        Context r5 = r4.getApplicationContext();
        o.b(r5, "context.applicationContext");
        Resources r6 = r5.getResources();
        o.b(r6, "context.applicationContext.resources");
        return r6.getDisplayMetrics().density;
    }

    public static final String h(Activity r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Resources r3 = r2.getResources();
        o.b(r3, "activity.resources");
        DisplayMetrics r4 = r3.getDisplayMetrics();
        int r0 = r4.widthPixels;
        int r5 = r4.heightPixels;
        StringBuilder r1 = new StringBuilder();
        r1.append(r0);
        r1.append('*');
        r1.append(r5);
        return r1.toString();
    }
}
