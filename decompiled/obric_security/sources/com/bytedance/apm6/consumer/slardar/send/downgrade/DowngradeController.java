package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DowngradeController {
    public static final String FIELD_LOG_TYPE = "log_type";
    public static final String FIELD_SERVICE = "service";
    private DowngradeDataStorage mDataStorage;
    public volatile DowngradeInfo mInfo;

    private static class SINGLETON {
        private static final DowngradeController sInstance = null;

        private SINGLETON() {
        }

        static /* synthetic */ DowngradeController access$000() {
            return sInstance;
        }

        static {
            sInstance = new DowngradeController();
        }
    }

    public DowngradeController() {
    }

    public void init(Context r2) {
        DowngradeDataStorage r0 = new DowngradeDataStorage(r2);
        this.mDataStorage = r0;
        setDowngradeInfo(r0.loadFromSp(), false);
    }

    public void setDowngradeInfo(DowngradeInfo r1, boolean r2) {
        if (r1 == null) goto L13;
        monitor-enter(this);
        this.mInfo = r1;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r2 == false) goto L16;
        DowngradeDataStorage r0 = this.mDataStorage;
        if (r0 == null) goto L17;
        r0.save(r1);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean uploadEnabled(JSONObject r7, int r8) {
        boolean r1 = true;
        if (this.mInfo != null) goto L5;
    L46:
        return true;
    L5:
        if (System.currentTimeMillis() > this.mInfo.expireTime) goto L46;
        String r9 = String.valueOf(r8);
        String r0 = r7.optString("log_type");
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L10:
        if (DowngradeInfo.LogType.SERVICE_MONITOR.logType.equals(r0) == false) goto L26;
        String r10 = r7.optString("service");     // Catch: Throwable -> L43
        DowngradeInfo.SubInfo r2 = this.mInfo.mEventMap.get(DowngradeInfo.LogType.SERVICE_MONITOR);     // Catch: Throwable -> L43
        if (r2 == null) goto L41;
        JSONObject r11 = r2.aidMap.get(r9);     // Catch: Throwable -> L43
        if (r11 != null) goto L16;
    L23:
        boolean r12 = r2.defaultRate;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r12;
    L16:
        if (r11.optInt(r10, -1) == (-1)) goto L23;
        if (r11.optInt(r10, -1) == 1) goto L21;
        r1 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        return true;
    L26:
        DowngradeInfo.SubInfo r13 = this.mInfo.mEventMap.get(DowngradeInfo.LogType.OTHER_LOG_TYPE);     // Catch: Throwable -> L43
        if (r13 == null) goto L41;
        JSONObject r14 = r13.aidMap.get(r9);     // Catch: Throwable -> L43
        if (r14 != null) goto L31;
    L38:
        boolean r15 = r13.defaultRate;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return r15;
    L31:
        if (r14.optInt(r0, -1) == (-1)) goto L38;
        if (r14.optInt(r0, -1) == 1) goto L36;
        r1 = false;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L43
        return r1;
    }

    public static DowngradeController getInstance() {
        return SINGLETON.access$000();
    }
}
