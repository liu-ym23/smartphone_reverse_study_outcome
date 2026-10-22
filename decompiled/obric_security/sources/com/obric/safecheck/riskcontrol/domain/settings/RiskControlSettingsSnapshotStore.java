package com.obric.safecheck.riskcontrol.domain.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskAppControlRecord;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RiskControlSettingsSnapshotStore.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0007J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0007J(\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0007J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/safecheck/riskcontrol/domain/settings/RiskControlSettingsSnapshotStore;", "", "()V", "KEY_PREFIX", "", "TAG", "cachedFlagsByItemKey", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "getControlFlags", "context", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, AccountInfoBundleKey.USER_ID, "isFlagControlled", "", "flag", "refreshSnapshot", "", "controlledRecords", "", "Lcom/obric/safecheck/riskcontrol/api/model/RiskAppControlRecord;", "releaseControlFlags", "setControlFlags", "controlFlags", "settingsKey", "settingsKeyFromSnapshotItemKey", "itemKey", "snapshotItemKey", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskControlSettingsSnapshotStore {
    public static final RiskControlSettingsSnapshotStore INSTANCE = null;
    private static final String KEY_PREFIX = "security_risk_control";
    private static final String TAG = "RiskControlSnapshot";
    private static final LinkedHashMap<String, Integer> cachedFlagsByItemKey = null;

    static {
        INSTANCE = new RiskControlSettingsSnapshotStore();
        cachedFlagsByItemKey = new LinkedHashMap();
    }

    private RiskControlSettingsSnapshotStore() {
    }

    @JvmStatic
    public static final void refreshSnapshot(Context r5, List<RiskAppControlRecord> r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "controlledRecords");
        Context r7 = r5.getApplicationContext();     // Catch: Exception -> L31
        Intrinsics.checkNotNullExpressionValue(r7, "context.applicationContext");     // Catch: Exception -> L31
        ContentResolver r8 = r7.getContentResolver();     // Catch: Exception -> L31
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Exception -> L31
        Iterator<T> r9 = r6.iterator();     // Catch: Exception -> L31
    L5:
        if (r9.hasNext() == false) goto L10;
        RiskAppControlRecord r1 = (RiskAppControlRecord) r9.next();     // Catch: Exception -> L31
        if (r1.getControlFlags() == 0) goto L8;
        RiskControlSettingsSnapshotStore r2 = INSTANCE;     // Catch: Exception -> L31
        Settings.Secure.putString(r8, r2.settingsKey(r1.getPkg(), r1.getUserId()), String.valueOf(r1.getControlFlags()));     // Catch: Exception -> L31
        String r3 = r2.snapshotItemKey(r1.getPkg(), r1.getUserId());     // Catch: Exception -> L31
        r0.put(r3, Integer.valueOf(r1.getControlFlags()));     // Catch: Exception -> L31
        goto L5
    L8:
        Settings.Secure.putString(r8, INSTANCE.settingsKey(r1.getPkg(), r1.getUserId()), null);     // Catch: Exception -> L31
        goto L5
    L10:
        LinkedHashMap<String, Integer> r10 = cachedFlagsByItemKey;     // Catch: Exception -> L31
        monitor-enter(r10);     // Catch: Exception -> L31
        Set<String> r4 = r10.keySet();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r4, "cachedFlagsByItemKey.keys");     // Catch: Throwable -> L28
        Set r11 = CollectionsKt.toSet(r4);     // Catch: Throwable -> L28
        Set r12 = r0.keySet();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r12, "nextFlagsByItemKey.keys");     // Catch: Throwable -> L28
        Set r13 = SetsKt.minus(r11, r12);     // Catch: Throwable -> L28
        monitor-exit(r10);     // Catch: Exception -> L31
        Iterator r14 = r13.iterator();     // Catch: Exception -> L31
    L16:
        if (r14.hasNext() == false) goto L20;
        String r15 = (String) r14.next();     // Catch: Exception -> L31
        RiskControlSettingsSnapshotStore r16 = INSTANCE;     // Catch: Exception -> L31
        Intrinsics.checkNotNullExpressionValue(r15, "itemKey");     // Catch: Exception -> L31
        String r17 = r16.settingsKeyFromSnapshotItemKey(r15);     // Catch: Exception -> L31
        if (r17 == null) goto L16;
        Settings.Secure.putString(r8, r17, null);     // Catch: Exception -> L31
        goto L16
    L20:
        LinkedHashMap<String, Integer> r18 = cachedFlagsByItemKey;     // Catch: Exception -> L31
        monitor-enter(r18);     // Catch: Exception -> L31
        r18.clear();     // Catch: Throwable -> L25
        r18.putAll(r0);     // Catch: Throwable -> L25
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r18);     // Catch: Exception -> L31
        return;
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        Log.e(TAG, "refreshSnapshot failed", e);
    }

    @JvmStatic
    public static final void setControlFlags(Context r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, ApkVirusCheckProvider.KEY_PKG);
        if (StringsKt.isBlank(r4) == false) goto L26;
        return;
    L26:
        Context r7 = r3.getApplicationContext();     // Catch: Exception -> L23
        Intrinsics.checkNotNullExpressionValue(r7, "context.applicationContext");     // Catch: Exception -> L23
        ContentResolver r8 = r7.getContentResolver();     // Catch: Exception -> L23
        RiskControlSettingsSnapshotStore r0 = INSTANCE;     // Catch: Exception -> L23
        String r1 = r0.snapshotItemKey(r4, r5);     // Catch: Exception -> L23
        if (r6 != 0) goto L15;
        Settings.Secure.putString(r8, r0.settingsKey(r4, r5), null);     // Catch: Exception -> L23
        LinkedHashMap<String, Integer> r9 = cachedFlagsByItemKey;     // Catch: Exception -> L23
        monitor-enter(r9);     // Catch: Exception -> L23
        Integer r2 = r9.remove(r1);     // Catch: Throwable -> L12
        monitor-exit(r9);     // Catch: Exception -> L23
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L15:
        Settings.Secure.putString(r8, r0.settingsKey(r4, r5), String.valueOf(r6));     // Catch: Exception -> L23
        LinkedHashMap<String, Integer> r10 = cachedFlagsByItemKey;     // Catch: Exception -> L23
        monitor-enter(r10);     // Catch: Exception -> L23
        r10.put(r1, Integer.valueOf(r6));     // Catch: Throwable -> L20
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r10);     // Catch: Exception -> L23
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Exception -> L23
    L23:
        e = move-exception;
        Log.e(TAG, "setControlFlags failed, pkg=" + r4 + ", userId=" + r5 + ", flags=" + r6, e);
    }

    @JvmStatic
    public static final void releaseControlFlags(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        setControlFlags(r1, r2, r3, 0);
    }

    @JvmStatic
    public static final int getControlFlags(Context r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, ApkVirusCheckProvider.KEY_PKG);
        if (StringsKt.isBlank(r4) == false) goto L14;
        return 0;
    L14:
        Context r6 = r3.getApplicationContext();     // Catch: Exception -> L11
        Intrinsics.checkNotNullExpressionValue(r6, "context.applicationContext");     // Catch: Exception -> L11
        String r7 = Settings.Secure.getString(r6.getContentResolver(), INSTANCE.settingsKey(r4, r5));     // Catch: Exception -> L11
        if (r7 == null) goto L16;
        Integer r8 = StringsKt.toIntOrNull(r7);     // Catch: Exception -> L11
        if (r8 == null) goto L17;
        return r8.intValue();
    L17:
        return 0;
    L16:
        return 0;
    L11:
        e = move-exception;
        Log.e(TAG, "getControlFlags failed, pkg=" + r4 + ", userId=" + r5, e);
        return 0;
    }

    @JvmStatic
    public static final boolean isFlagControlled(Context r1, String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        return RiskControlFlags.hasFlag(getControlFlags(r1, r2, r3), r4);
    }

    private final String settingsKey(String r2, int r3) {
        return "security_risk_control_" + r2 + "_" + r3;
    }

    private final String snapshotItemKey(String r1, int r2) {
        return r2 + ":" + r1;
    }

    private final String settingsKeyFromSnapshotItemKey(String r8) {
        String r6 = r8;
        int r0 = StringsKt.indexOf$default(r6, ':', 0, false, 6, null);
        if (r0 > 0) goto L5;
    L11:
        return null;
    L5:
        if (r0 == StringsKt.getLastIndex(r6)) goto L11;
        String r2 = r8.substring(0, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L11;
        int r1 = r3.intValue();
        String r9 = r8.substring(r0 + 1);
        Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).substring(startIndex)");
        return settingsKey(r9, r1);
    }
}
