package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.core.sdkmonitor.BuildConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SDKMonitorUtils {
    private static ConcurrentHashMap<String, List<String>> sAidToConfigUrl;
    private static ConcurrentHashMap<String, List<String>> sAidToDefaultReportUrl;
    private static ConcurrentHashMap<String, SDKMonitor> sAidToMonitorCommon;

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public SDKMonitorUtils() {
    }

    static {
        sAidToMonitorCommon = new ConcurrentHashMap();
        sAidToDefaultReportUrl = new ConcurrentHashMap();
        sAidToConfigUrl = new ConcurrentHashMap();
    }

    public static synchronized void setConfigUrl(String r5, List<String> r6) {
        monitor-enter(SDKMonitorUtils.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L20:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r6) == true) goto L20;
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L22
        Iterator<String> r7 = r6.iterator();     // Catch: Throwable -> L22
    L11:
        if (r7.hasNext() == false) goto L17;
        r1.add(("https://" + new URL(r7.next()).getHost()) + MonitorConstants.SETTING_V3_PATH);     // Catch: MalformedURLException -> L15 Throwable -> L22
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L11
    L17:
        sAidToConfigUrl.put(r5, r1);     // Catch: Throwable -> L22
        monitor-exit(SDKMonitorUtils.class);
    }

    @Deprecated
    public static synchronized void setDeafultReportUrl(String r2, List<String> r3) {
        monitor-enter(SDKMonitorUtils.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L12:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r3) == true) goto L12;
        sAidToDefaultReportUrl.put(r2, convertReportUrl(r3));     // Catch: Throwable -> L14
        monitor-exit(SDKMonitorUtils.class);
    }

    public static synchronized void setDefaultReportUrl(String r2, List<String> r3) {
        monitor-enter(SDKMonitorUtils.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L12:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r3) == true) goto L12;
        sAidToDefaultReportUrl.put(r2, convertReportUrl(r3));     // Catch: Throwable -> L14
        monitor-exit(SDKMonitorUtils.class);
    }

    public static List<String> convertReportUrl(List<String> r4) {
        LinkedList r0 = new LinkedList();
        Iterator<String> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        r0.add(("https://" + new URL(r5.next()).getHost()) + MonitorConstants.COLLECT_PATH);     // Catch: MalformedURLException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        return r0;
    }

    @Deprecated
    public static synchronized void init(Context r3, String r4, JSONObject r5, SDKMonitor.IGetCommonParams r6) {
        monitor-enter(SDKMonitorUtils.class);
        if (r3 != null) goto L29;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L29:
    L26:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (r5 == null) goto L23;
        if (sAidToMonitorCommon.get(r4) != null) goto L13;
    L16:
        SDKMonitor r1 = sAidToMonitorCommon.get(r4);     // Catch: Throwable -> L26
        if (r1 != null) goto L19;
        r1 = new SDKMonitor(r4);     // Catch: Throwable -> L26
        sAidToMonitorCommon.put(r4, r1);     // Catch: Throwable -> L26
    L19:
        r1.resetConfigUrls(sAidToConfigUrl.remove(r4));     // Catch: Throwable -> L26
        r1.resetReportUrls(sAidToDefaultReportUrl.remove(r4));     // Catch: Throwable -> L26
        r1.init(r3, r5, r6);     // Catch: Throwable -> L26
        monitor-exit(SDKMonitorUtils.class);
        return;
    L13:
        if (sAidToMonitorCommon.get(r4).isHasInit() == false) goto L16;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L23:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L26
    L25:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L26
    }

    public static synchronized void initMonitor(Context r3, String r4, JSONObject r5, SDKMonitor.IGetExtendParams r6) {
        monitor-enter(SDKMonitorUtils.class);
        if (r3 != null) goto L29;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L29:
    L26:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        if (r5 == null) goto L23;
        if (sAidToMonitorCommon.get(r4) != null) goto L13;
    L16:
        SDKMonitor r1 = sAidToMonitorCommon.get(r4);     // Catch: Throwable -> L26
        if (r1 != null) goto L19;
        r1 = new SDKMonitor(r4);     // Catch: Throwable -> L26
        sAidToMonitorCommon.put(r4, r1);     // Catch: Throwable -> L26
    L19:
        r1.resetConfigUrls(sAidToConfigUrl.remove(r4));     // Catch: Throwable -> L26
        r1.resetReportUrls(sAidToDefaultReportUrl.remove(r4));     // Catch: Throwable -> L26
        r1.init(r3, r5, r6);     // Catch: Throwable -> L26
        monitor-exit(SDKMonitorUtils.class);
        return;
    L13:
        if (sAidToMonitorCommon.get(r4).isHasInit() == false) goto L16;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L23:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L26
    L25:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L26
    }

    public static SDKMonitor getInstance(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L19;
        if (sAidToMonitorCommon.get(r3) != null) goto L17;
        monitor-enter(SDKMonitorUtils.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (sAidToMonitorCommon.get(r3) != null) goto L11;
        SDKMonitor r1 = new SDKMonitor(r3);     // Catch: Throwable -> L13
        sAidToMonitorCommon.put(r3, r1);     // Catch: Throwable -> L13
    L11:
        monitor-exit(SDKMonitorUtils.class);     // Catch: Throwable -> L13
    L17:
        return sAidToMonitorCommon.get(r3);
    L19:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }
}
