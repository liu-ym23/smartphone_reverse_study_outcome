package com.obric.safecheck.dataSync.miitAntiFraud;

import android.content.Context;
import android.content.SharedPreferences;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.olog.OLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GxbUpdateVersionRecordSP.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateVersionRecordSP;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "getLatestVersion", "", "getLatestVersionTimeMs", "", "updateLatestVersionFailed", "", "version", "updateLatestVersionSuccess", "writeInternal", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbUpdateVersionRecordSP {
    public static final Companion Companion = null;
    private static final String KEY_LATEST_VERSION = "latest_version";
    private static final String KEY_LATEST_VERSION_TIME = "latest_version_time_ms";
    private static final String SP_NAME = "gxb_update_version_record";
    private static final String TAG = "GxbUpdateVersionRecordSP";
    private final SharedPreferences sp;

    /* JADX INFO: compiled from: GxbUpdateVersionRecordSP.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbUpdateVersionRecordSP$Companion;", "", "()V", "KEY_LATEST_VERSION", "", "KEY_LATEST_VERSION_TIME", "SP_NAME", "TAG", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GxbUpdateVersionRecordSP(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        SharedPreferences r4 = r3.getApplicationContext().getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(r4, "context.applicationConte…ME, Context.MODE_PRIVATE)");
        this.sp = r4;
    }

    public final synchronized void updateLatestVersionSuccess(String r6) {
        monitor-enter(this);
        String r2 = r6;     // Catch: Throwable -> L24
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        String r4 = this.sp.getString(KEY_LATEST_VERSION, null);     // Catch: Throwable -> L24
        if (r4 != null) goto L17;
    L21:
        writeInternal(r6);     // Catch: Throwable -> L24
        OLog.d(TAG, "update latest version on success, version is " + r6);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L17:
        if (r6.compareTo(r4) >= 0) goto L21;
        OLog.d(TAG, "skip regression on success, current is " + r4 + ", new is " + r6);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L7:
        if (StringsKt.isBlank(r2) == true) goto L10;
        r3 = false;
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void updateLatestVersionFailed(String r4) {
        monitor-enter(this);
        String r1 = r4;     // Catch: Throwable -> L17
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        monitor-exit(this);
        return;
    L14:
        writeInternal(r4);     // Catch: Throwable -> L17
        OLog.d(TAG, "update latest version on failure, version is " + r4);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        if (StringsKt.isBlank(r1) == true) goto L10;
        r2 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final String getLatestVersion() {
        return this.sp.getString(KEY_LATEST_VERSION, null);
    }

    public final long getLatestVersionTimeMs() {
        return this.sp.getLong(KEY_LATEST_VERSION_TIME, 0);
    }

    private final void writeInternal(String r3) {
        this.sp.edit().putString(KEY_LATEST_VERSION, r3).putLong(KEY_LATEST_VERSION_TIME, System.currentTimeMillis()).apply();
    }
}
