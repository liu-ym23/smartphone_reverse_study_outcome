package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
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

    static {
        sAidToMonitorCommon = new ConcurrentHashMap();
        sAidToDefaultReportUrl = new ConcurrentHashMap();
        sAidToConfigUrl = new ConcurrentHashMap();
    }

    public SDKMonitorUtils() {
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

    public static SDKMonitor getInstance(@NonNull String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L20;
        if (sAidToMonitorCommon.get(r3) != null) goto L18;
        monitor-enter(SDKMonitorUtils.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (sAidToMonitorCommon.get(r3) != null) goto L13;
        SDKMonitor r1 = new SDKMonitor(r3);     // Catch: Throwable -> L11
        sAidToMonitorCommon.put(r3, r1);     // Catch: Throwable -> L11
    L13:
        monitor-exit(SDKMonitorUtils.class);     // Catch: Throwable -> L11
    L18:
        return sAidToMonitorCommon.get(r3);
    L20:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Deprecated
    public static synchronized void init(@NonNull Context r3, @NonNull String r4, @NonNull JSONObject r5, SDKMonitor.IGetCommonParams r6) {
        monitor-enter(SDKMonitorUtils.class);
        if (r3 != null) goto L30;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L30:
    L16:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L27;
        if (r5 == null) goto L25;
        if (sAidToMonitorCommon.get(r4) != null) goto L13;
    L18:
        SDKMonitor r1 = sAidToMonitorCommon.get(r4);     // Catch: Throwable -> L16
        if (r1 != null) goto L21;
        r1 = new SDKMonitor(r4);     // Catch: Throwable -> L16
        sAidToMonitorCommon.put(r4, r1);     // Catch: Throwable -> L16
    L21:
        r1.resetConfigUrls(sAidToConfigUrl.remove(r4));     // Catch: Throwable -> L16
        r1.resetReportUrls(sAidToDefaultReportUrl.remove(r4));     // Catch: Throwable -> L16
        r1.init(r3, r5, r6);     // Catch: Throwable -> L16
        monitor-exit(SDKMonitorUtils.class);
        return;
    L13:
        if (sAidToMonitorCommon.get(r4).isHasInit() == false) goto L18;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L25:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L16
    L27:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L16
    }

    public static synchronized void initMonitor(@NonNull Context r3, @NonNull String r4, @NonNull JSONObject r5, SDKMonitor.IGetExtendParams r6) {
        monitor-enter(SDKMonitorUtils.class);
        if (r3 != null) goto L30;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L30:
    L16:
        th = move-exception;
        throw th;
    L8:
        if (TextUtils.isEmpty(r4) == true) goto L27;
        if (r5 == null) goto L25;
        if (sAidToMonitorCommon.get(r4) != null) goto L13;
    L18:
        SDKMonitor r1 = sAidToMonitorCommon.get(r4);     // Catch: Throwable -> L16
        if (r1 != null) goto L21;
        r1 = new SDKMonitor(r4);     // Catch: Throwable -> L16
        sAidToMonitorCommon.put(r4, r1);     // Catch: Throwable -> L16
    L21:
        r1.resetConfigUrls(sAidToConfigUrl.remove(r4));     // Catch: Throwable -> L16
        r1.resetReportUrls(sAidToDefaultReportUrl.remove(r4));     // Catch: Throwable -> L16
        r1.init(r3, r5, r6);     // Catch: Throwable -> L16
        monitor-exit(SDKMonitorUtils.class);
        return;
    L13:
        if (sAidToMonitorCommon.get(r4).isHasInit() == false) goto L18;
        monitor-exit(SDKMonitorUtils.class);
        return;
    L25:
        throw new IllegalArgumentException("param 'headerInfo' is not allowed to be null");     // Catch: Throwable -> L16
    L27:
        throw new IllegalArgumentException("param 'aid' is not allowed to assigned empty string");     // Catch: Throwable -> L16
    }

    public static synchronized void setConfigUrl(@NonNull String r5, @NonNull List<String> r6) {
        monitor-enter(SDKMonitorUtils.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
    L22:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r6) == true) goto L22;
        LinkedList r1 = new LinkedList();     // Catch: Throwable -> L15
        Iterator<String> r7 = r6.iterator();     // Catch: Throwable -> L15
    L11:
        if (r7.hasNext() == false) goto L19;
        r1.add(("https://" + new URL(r7.next()).getHost()) + MonitorConstants.SETTING_V3_PATH);     // Catch: Throwable -> L15 MalformedURLException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L11
    L19:
        sAidToConfigUrl.put(r5, r1);     // Catch: Throwable -> L15
        monitor-exit(SDKMonitorUtils.class);
    }

    @Deprecated
    public static synchronized void setDeafultReportUrl(@NonNull String r2, @NonNull List<String> r3) {
        monitor-enter(SDKMonitorUtils.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L14:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r3) == true) goto L14;
        sAidToDefaultReportUrl.put(r2, convertReportUrl(r3));     // Catch: Throwable -> L12
        monitor-exit(SDKMonitorUtils.class);
    }

    public static synchronized void setDefaultReportUrl(@NonNull String r2, @NonNull List<String> r3) {
        monitor-enter(SDKMonitorUtils.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L14:
        monitor-exit(SDKMonitorUtils.class);
        return;
    L7:
        if (ListUtils.isEmpty(r3) == true) goto L14;
        sAidToDefaultReportUrl.put(r2, convertReportUrl(r3));     // Catch: Throwable -> L12
        monitor-exit(SDKMonitorUtils.class);
    }
}
