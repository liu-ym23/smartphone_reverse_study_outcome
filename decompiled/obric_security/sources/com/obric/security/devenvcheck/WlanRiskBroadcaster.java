package com.obric.security.devenvcheck;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanRiskBroadcaster.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/security/devenvcheck/WlanRiskBroadcaster;", "", "()V", "ACTION_WIFI_RISK_DETECTED", "", "EXTRA_BSSID", "EXTRA_RISKS", "EXTRA_SSID", "EXTRA_TIMESTAMP", "PERMISSION_RECEIVE", "sendRisk", "", "context", "Landroid/content/Context;", "ssid", "bssid", "risks", "", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanRiskBroadcaster {
    public static final String ACTION_WIFI_RISK_DETECTED = "com.obric.security.wlan.ACTION_WIFI_RISK_DETECTED";
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_RISKS = "risks";
    public static final String EXTRA_SSID = "ssid";
    public static final String EXTRA_TIMESTAMP = "timestamp";
    public static final WlanRiskBroadcaster INSTANCE = null;
    public static final String PERMISSION_RECEIVE = "com.obric.security.permission.broadcast";

    static {
        INSTANCE = new WlanRiskBroadcaster();
    }

    private WlanRiskBroadcaster() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendRisk$default(WlanRiskBroadcaster r0, Context r1, String r2, String r3, List r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = CollectionsKt.emptyList();
    L5:
        r0.sendRisk(r1, r2, r3, r4);
    }

    public final void sendRisk(Context r4, String r5, String r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "ssid");
        Intrinsics.checkNotNullParameter(r6, "bssid");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        WlanRiskBroadcaster r3 = this;     // Catch: Throwable -> L9
        Intent r8 = new Intent(ACTION_WIFI_RISK_DETECTED);     // Catch: Throwable -> L9
        r8.putExtra("ssid", r5);     // Catch: Throwable -> L9
        r8.putExtra("bssid", r6);     // Catch: Throwable -> L9
        if (r7 == null) goto L6;
        ArrayList<String> r9 = new ArrayList(r7);     // Catch: Throwable -> L9
    L7:
        r8.putStringArrayListExtra("risks", r9);     // Catch: Throwable -> L9
        r8.putExtra("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L9
        r4.sendBroadcast(r8, PERMISSION_RECEIVE);     // Catch: Throwable -> L9
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L6:
        r9 = null;
    L9:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }
}
