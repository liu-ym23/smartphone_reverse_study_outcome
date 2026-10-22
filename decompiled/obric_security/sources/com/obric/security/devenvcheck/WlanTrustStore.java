package com.obric.security.devenvcheck;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanTrustStore.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/security/devenvcheck/WlanTrustStore;", "", "()V", "CALL_URI", "Landroid/net/Uri;", "KEY_TRUSTED_WIFI", "", "SP_NAME", "addTrusted", "", "context", "Landroid/content/Context;", "key", "isTrusted", "", "removeTrusted", "removeTrustedBySsid", "ssid", "writeRemoveTrusted", "writeRemoveTrustedBySsid", "writeTrusted", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WlanTrustStore {
    private static final Uri CALL_URI = null;
    public static final WlanTrustStore INSTANCE = null;
    private static final String KEY_TRUSTED_WIFI = "trusted_wifi";
    private static final String SP_NAME = "wlan_security_detect";

    static {
        INSTANCE = new WlanTrustStore();
        Uri r0 = Uri.parse("content://com.obric.security.wlan.provider");
        Intrinsics.checkNotNullExpressionValue(r0, "Uri.parse(\"content://${W…sultProvider.AUTHORITY}\")");
        CALL_URI = r0;
    }

    private WlanTrustStore() {
    }

    public final boolean isTrusted(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        Set<String> r1 = r2.getSharedPreferences(SP_NAME, 0).getStringSet(KEY_TRUSTED_WIFI, SetsKt.emptySet());
        if (r1 != null) goto L6;
        r1 = SetsKt.emptySet();
    L6:
        return r1.contains(r3);
    }

    public final void addTrusted(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        WlanTrustStore r2 = this;     // Catch: Throwable -> L5
        Bundle r5 = new Bundle();     // Catch: Throwable -> L5
        r5.putString(WlanCheckResultProvider.PARAM_TRUSTED_KEY, r4);     // Catch: Throwable -> L5
        Result.m774constructorimpl(r3.getContentResolver().call(CALL_URI, WlanCheckResultProvider.METHOD_ADD_TRUSTED, null, r5));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }

    public final void writeTrusted(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        SharedPreferences r1 = r2.getSharedPreferences(SP_NAME, 0);
        Set<String> r4 = r1.getStringSet(KEY_TRUSTED_WIFI, SetsKt.emptySet());
        if (r4 != null) goto L5;
        r4 = SetsKt.emptySet();
    L5:
        Set<String> r5 = CollectionsKt.toMutableSet(r4);
        r5.add(r3);
        r1.edit().putStringSet(KEY_TRUSTED_WIFI, r5).apply();
    }

    public final void removeTrusted(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        WlanTrustStore r2 = this;     // Catch: Throwable -> L5
        Bundle r5 = new Bundle();     // Catch: Throwable -> L5
        r5.putString(WlanCheckResultProvider.PARAM_TRUSTED_KEY, r4);     // Catch: Throwable -> L5
        Result.m774constructorimpl(r3.getContentResolver().call(CALL_URI, WlanCheckResultProvider.METHOD_REMOVE_TRUSTED, null, r5));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }

    public final void writeRemoveTrusted(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "key");
        SharedPreferences r1 = r2.getSharedPreferences(SP_NAME, 0);
        Set<String> r4 = r1.getStringSet(KEY_TRUSTED_WIFI, SetsKt.emptySet());
        if (r4 != null) goto L5;
        r4 = SetsKt.emptySet();
    L5:
        Set<String> r5 = CollectionsKt.toMutableSet(r4);
        if (r5.remove(r3) == true) goto L8;
        return;
    L8:
        r1.edit().putStringSet(KEY_TRUSTED_WIFI, r5).apply();
    }

    public final void removeTrustedBySsid(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "ssid");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        WlanTrustStore r2 = this;     // Catch: Throwable -> L5
        Bundle r5 = new Bundle();     // Catch: Throwable -> L5
        r5.putString("ssid", r4);     // Catch: Throwable -> L5
        Result.m774constructorimpl(r3.getContentResolver().call(CALL_URI, WlanCheckResultProvider.METHOD_REMOVE_TRUSTED_BY_SSID, null, r5));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }

    public final void writeRemoveTrustedBySsid(Context r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "ssid");
        SharedPreferences r3 = r4.getSharedPreferences(SP_NAME, 0);
        Set<String> r6 = r3.getStringSet(KEY_TRUSTED_WIFI, SetsKt.emptySet());
        if (r6 != null) goto L5;
        r6 = SetsKt.emptySet();
    L5:
        Set<String> r7 = CollectionsKt.toMutableSet(r6);
        if (CollectionsKt.removeAll(r7, new WlanTrustStore$writeRemoveTrustedBySsid$removed$1(r5)) == true) goto L8;
        return;
    L8:
        r3.edit().putStringSet(KEY_TRUSTED_WIFI, r7).apply();
    }
}
