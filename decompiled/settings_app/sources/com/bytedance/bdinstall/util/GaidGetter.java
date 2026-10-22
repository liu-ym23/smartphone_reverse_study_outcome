package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes3.dex */
public class GaidGetter {
    private static final String KEY_GAID_LIMITED = "gaid_limited";
    private static volatile Pair<String, Boolean> sGaidPair;
    private static GaidMonitor sMonitor;

    public static class GaidMonitor {
        private long mFileLoadBeginTime;
        private long mFileLoadEndTime;
        private long mFileSaveBeginTime;
        private long mFileSaveEndTime;
        private String mGaid;
        private boolean mGaidLimited;
        private long mSysCallBeginTime;
        private long mSysCallEndTime;
        private boolean mUsed;

        private void setGaid(String r1) {
        }

        public GaidMonitor() {
            this.mGaid = null;
        }

        static /* synthetic */ void access$000(GaidMonitor r0) {
            r0.onSysCallBegin();
        }

        static /* synthetic */ void access$100(GaidMonitor r0) {
            r0.onSysCallEnd();
        }

        static /* synthetic */ void access$200(GaidMonitor r0, String r1) {
            r0.setGaid(r1);
        }

        static /* synthetic */ void access$300(GaidMonitor r0, boolean r1) {
            r0.setGaidLimited(r1);
        }

        static /* synthetic */ void access$400(GaidMonitor r0) {
            r0.onFileLoadBegin();
        }

        static /* synthetic */ void access$500(GaidMonitor r0) {
            r0.onFileLoadEnd();
        }

        static /* synthetic */ void access$600(GaidMonitor r0) {
            r0.onFileSaveBegin();
        }

        static /* synthetic */ void access$700(GaidMonitor r0) {
            r0.onFileSaveEnd();
        }

        private void onSysCallBegin() {
            this.mSysCallBeginTime = System.currentTimeMillis();
        }

        private void onSysCallEnd() {
            this.mSysCallEndTime = System.currentTimeMillis();
        }

        private void onFileLoadBegin() {
            this.mFileLoadBeginTime = System.currentTimeMillis();
        }

        private void onFileLoadEnd() {
            this.mFileLoadEndTime = System.currentTimeMillis();
        }

        private void onFileSaveBegin() {
            this.mFileSaveBeginTime = System.currentTimeMillis();
        }

        private void onFileSaveEnd() {
            this.mFileSaveEndTime = System.currentTimeMillis();
        }

        private void setGaidLimited(boolean r1) {
            this.mGaidLimited = r1;
        }

        public long getSysCallTs() {
            return this.mSysCallEndTime - this.mSysCallBeginTime;
        }

        public long getFileLoadTs() {
            return this.mFileLoadEndTime - this.mFileLoadBeginTime;
        }

        public long getFileSaveTs() {
            return this.mFileSaveEndTime - this.mFileSaveBeginTime;
        }

        public String getGaid() {
            return this.mGaid;
        }

        public boolean isGaidLimited() {
            return this.mGaidLimited;
        }

        public void markUsed() {
            this.mUsed = true;
        }

        public boolean isCache() {
            return this.mUsed;
        }
    }

    static {
    }

    public GaidGetter() {
    }

    public static Pair<String, Boolean> getGaid(Context r8) {
        if (isValidPair(sGaidPair) == true) goto L26;
        monitor-enter(GaidGetter.class);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (isValidPair(sGaidPair) == false) goto L11;
        Pair<String, Boolean> r9 = sGaidPair;     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        return r9;
    L11:
        GaidMonitor r2 = new GaidMonitor();     // Catch: Throwable -> L22
        sMonitor = r2;     // Catch: Throwable -> L22
        GaidMonitor.access$000(r2);     // Catch: Throwable -> L22
        Pair<String, Boolean> r3 = getGoogleAdid(r8);     // Catch: Throwable -> L22
        GaidMonitor.access$100(sMonitor);     // Catch: Throwable -> L22
        GaidMonitor.access$200(sMonitor, (String) r3.first);     // Catch: Throwable -> L22
        GaidMonitor.access$300(sMonitor, ((Boolean) r3.second).booleanValue());     // Catch: Throwable -> L22
        String r4 = (String) r3.first;     // Catch: Throwable -> L22
        boolean r5 = ((Boolean) r3.second).booleanValue();     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r4) == false) goto L14;
        DrLog.e("Gaid#getGaid failed . rst = " + r3);     // Catch: Throwable -> L22
        GaidMonitor.access$400(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r10 = LocalConstants.getCommonSp(r8);     // Catch: Throwable -> L22
        r4 = r10.getString(Api.KEY_GOOGLE_AID, null);     // Catch: Throwable -> L22
        r5 = r10.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        GaidMonitor.access$500(sMonitor);     // Catch: Throwable -> L22
    L19:
        sGaidPair = new Pair(r4, Boolean.valueOf(r5));     // Catch: Throwable -> L22
        monitor-exit(GaidGetter.class);     // Catch: Throwable -> L22
        goto L26
    L14:
        GaidMonitor.access$600(sMonitor);     // Catch: Throwable -> L22
        SharedPreferences r0 = LocalConstants.getCommonSp(r8);     // Catch: Throwable -> L22
        String r6 = r0.getString(Api.KEY_GOOGLE_AID, null);     // Catch: Throwable -> L22
        boolean r1 = r0.getBoolean("gaid_limited", false);     // Catch: Throwable -> L22
        if (TextUtils.equals(r6, r4) == false) goto L17;
        if (r1 != r5) goto L17;
    L18:
        GaidMonitor.access$700(sMonitor);     // Catch: Throwable -> L22
    L17:
        trySaveGoogleAid(r8, r4, r5);     // Catch: Throwable -> L22
    L26:
        return sGaidPair;
    }

    private static boolean isValidPair(Pair<String, Boolean> r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty((CharSequence) r0.first) == true) goto L6;
        return true;
    }

    private static Pair<String, Boolean> getGoogleAdid(Context r2) {
        String r0 = null;
        boolean r1 = false;
        AdvertisingIdClient.Info r3 = AdvertisingIdClient.getAdvertisingIdInfo(r2);     // Catch: Throwable -> L9
        if (r3 == null) goto L8;
        r0 = r3.getId();     // Catch: Throwable -> L9
        r1 = r3.isLimitAdTrackingEnabled();     // Catch: Throwable -> L9
    L8:
        return new Pair(r0, Boolean.valueOf(r1));
    }

    private static void trySaveGoogleAid(Context r1, String r2, boolean r3) {
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (r1 == null) goto L9;
        LocalConstants.getCommonSp(r1).edit().putString(Api.KEY_GOOGLE_AID, r2).putBoolean("gaid_limited", r3).apply();
        return;
    L9:
        return;
    }

    public static void clearSp(Context r1) {
        LocalConstants.getCommonSp(r1).edit().remove(Api.KEY_GOOGLE_AID).remove("gaid_limited").apply();
    }

    public static GaidMonitor getMonitor() {
        return sMonitor;
    }
}
