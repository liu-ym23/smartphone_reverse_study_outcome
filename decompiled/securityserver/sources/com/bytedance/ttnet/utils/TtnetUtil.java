package com.bytedance.ttnet.utils;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TtnetUtil {
    private static final String LOG_TAG = "TtnetUtil";
    private static final int RECEIVER_NOT_EXPORTED = 4;
    private static volatile boolean mDisableOkHttpDispatch = false;

    private TtnetUtil() {
    }

    public static void enableOkhttpBoeProxy(boolean r0) {
        BoeUtils.enableOkhttpBoeProxy(r0);
    }

    public static boolean getDisableOkHttpDispatch() {
        return mDisableOkHttpDispatch;
    }

    public static boolean inCookieHostList(String r4, List<String> r5) {
        if (StringUtils.isEmpty(r4) == false) goto L5;
    L21:
        return false;
    L5:
        if (Lists.isEmpty(r5) == true) goto L21;
        Iterator<String> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L21;
        String r0 = r6.next();
        if (StringUtils.isEmpty(r0) == true) goto L9;
        if (TTCookieConfig.isDisableCookieHostMatchFix() == true) goto L16;
        if (isMatchAllowHost(r4, r0) == false) goto L9;
        return true;
    L16:
        if (r4.endsWith(r0) == false) goto L9;
        return true;
    }

    public static boolean isMatchAllowHost(String r2, String r3) {
        if (StringUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r2.equalsIgnoreCase(r3) == false) goto L11;
        return true;
    L11:
        String r4 = r2.toLowerCase();
        if (r3.startsWith(LibrarianImpl.Constants.DOT) == false) goto L16;
        return r4.endsWith(r3.toLowerCase());
    L16:
        return r4.endsWith(LibrarianImpl.Constants.DOT + r3.toLowerCase());
    }

    public static String outputThrowableStackTrace(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L15
        r3.printStackTrace(r2);     // Catch: Throwable -> L11
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L11
        if (r4 == null) goto L13;
        r4.printStackTrace(r2);     // Catch: Throwable -> L11
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L11
        if (r5 == null) goto L13;
        r5.printStackTrace(r2);     // Catch: Throwable -> L11
    L13:
        r0 = r1.toString();     // Catch: Throwable -> L11
    L14:
        r2.close();
    L20:
        return r0;
    L11:
        th = th;
    L27:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
    L21:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.close();
    L24:
        throw th;
    L15:
        th = th;
        r2 = null;
        goto L27
    }

    public static void parseShareCookieHostList(String r4, List<String> r5) {
        if (StringUtils.isEmpty(r4) == true) goto L14;
        if (r5 == null) goto L19;
        String[] r6 = r4.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r6[r1];
        if (StringUtils.isEmpty(r2) == true) goto L13;
        if (inCookieHostList(r2, r5) == true) goto L13;
        r5.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    private static Intent registerBroadcastReceiver(Context r0, BroadcastReceiver r1, IntentFilter r2, String r3, Handler r4, int r5) {
        return r0.registerReceiver(r1, r2, r3, r4, r5);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8) {
        return registerBroadcastReceiver(r6, r7, r8, null, null, 4);
    }

    public static void safeAddInterceptorInRetrofitCache(LRUCache<String, Retrofit> r3, Interceptor r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.size() <= 0) goto L31;
        Map<String, Retrofit> r5 = r3.map();
        Collection<Retrofit> r0 = r5.values();
        monitor-enter(r5);
        Iterator<Retrofit> r1 = r0.iterator();     // Catch: Throwable -> L15
    L9:
        if (r1.hasNext() == false) goto L17;
        List<Interceptor> r2 = r1.next().interceptors();     // Catch: Throwable -> L15
        if (r2 == null) goto L9;
        if (r2.contains(r4) == true) goto L9;
        r2.add(r4);     // Catch: Throwable -> L15
        goto L9
    L17:
        monitor-exit(r5);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void safeRemoveInterceptorInRetrofitCache(LRUCache<String, Retrofit> r2, Interceptor r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.size() <= 0) goto L27;
        Map<String, Retrofit> r4 = r2.map();
        Collection<Retrofit> r0 = r4.values();
        monitor-enter(r4);
        Iterator<Retrofit> r1 = r0.iterator();     // Catch: Throwable -> L13
    L9:
        if (r1.hasNext() == false) goto L15;
        List<Interceptor> r5 = r1.next().interceptors();     // Catch: Throwable -> L13
        if (r5 == null) goto L9;
        r5.remove(r3);     // Catch: Throwable -> L13
        goto L9
    L15:
        monitor-exit(r4);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void setBroadcastReceiverEnabled(Context r4, Class<? extends BroadcastReceiver> r5, boolean r6) {
        if (r6 == false) goto L5;
        int r1 = 1;
    L19:
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (Logger.debug() == false) goto L15;
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L11
        if (r6 == false) goto L13;
        String r7 = "enabling";
    L14:
        r3.append(r7);     // Catch: Throwable -> L11
        r3.append(" connectivity receiver");     // Catch: Throwable -> L11
        Logger.d(LOG_TAG, r3.toString());     // Catch: Throwable -> L11
        goto L15
    L13:
        r7 = "disabling";
    L15:
        r4.getPackageManager().setComponentEnabledSetting(new ComponentName(r4, r5), r1, 1);     // Catch: Throwable -> L11
        return;
    L5:
        r1 = 2;
        goto L19
    }

    public static void setDisableOkHttpDispatch(boolean r0) {
        mDisableOkHttpDispatch = r0;
    }

    public static void setOkhttpBypassBoeJson(String r0) {
        BoeUtils.setOkhttpBypassBoeJson(r0);
    }

    public static Intent registerNonExportedBroadcastReceiver(Context r6, BroadcastReceiver r7, IntentFilter r8, Handler r9) {
        return registerBroadcastReceiver(r6, r7, r8, null, r9, 4);
    }
}
