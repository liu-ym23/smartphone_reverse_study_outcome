package com.obric.matrix.platform.sdk.ones.safecushion.util;

import android.util.Log;
import com.obric.matrix.platform.sdk.ones.internal.util.MLog;
import com.obric.matrix.platform.sdk.ones.safecushion.SafeCushionConstant;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: FlagHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006J\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper;", "", "()V", "getSafeMode", "", "lastSafeModeFlagInfo", "Lkotlin/Pair;", "", "lastStartSafeModeInfo", "", "lastStartSafeModeProcessInfo", "markOpenSafeModePage", "", SearchConfigType.KEY_MODE, "markStartSafeMode", "markStartSafeModeProcess", "safeModeIsLegal", "updateSafeModeState", "state", "upgradeFinish", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlagHelper {
    public static final Companion Companion = null;
    private static final String TAG = "SafeModeFlagHelper";

    /* JADX INFO: compiled from: FlagHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/FlagHelper$Companion;", "", "()V", "TAG", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public FlagHelper() {
    }

    public final void markStartSafeMode() {
        SafeCushionFileUtils.INSTANCE.createOrUpdateSafeCushionFile(SafeCushionConstant.START_SAFE_MODE_FLAG_FILE_NAME_PREFIX, "startSafeModeFlag-" + System.currentTimeMillis());
    }

    public final Pair<Boolean, Long> lastStartSafeModeInfo() {
        File r1 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.START_SAFE_MODE_FLAG_FILE_NAME_PREFIX);
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d(TAG, "lastStartSafeMode: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "startSafeModeFlagFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default(r2, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 2) goto L13;
        long r4 = Long.parseLong((String) r3.get(1));     // Catch: Exception -> L10
        MLog.i$default(TAG, "lastStartSafeModeTime: " + r4, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(true, Long.valueOf(r4));
    L13:
        return TuplesKt.to(false, -1L);
    }

    public final void markStartSafeModeProcess(String r3) {
        Intrinsics.checkNotNullParameter(r3, SearchConfigType.KEY_MODE);
        SafeCushionFileUtils.INSTANCE.createOrUpdateSafeCushionFile(SafeCushionConstant.START_SAFE_MODE_PROCESS_FILE_NAME_PREFIX, "startSafeModeProcess-" + r3 + '-' + System.currentTimeMillis());
    }

    public final void markOpenSafeModePage(String r4) {
        Intrinsics.checkNotNullParameter(r4, SearchConfigType.KEY_MODE);
        File r3 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX);
        if (r3 != null) goto L5;
    L8:
        SafeCushionFileUtils.INSTANCE.createOrUpdateSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX, "safeModeFlag-" + r4 + "-init-" + System.currentTimeMillis());
        return;
    L5:
        if (r3.exists() == false) goto L8;
        MLog.i$default(TAG, "markOpenSafeModePage: already marked, skip", null, 4, null);
    }

    public final Pair<String, Long> lastStartSafeModeProcessInfo() {
        File r1 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.START_SAFE_MODE_PROCESS_FILE_NAME_PREFIX);
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d(TAG, "lastStartSafeModeProcessInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "startSafeModeProcessFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default(r2, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 3) goto L13;
        String r4 = (String) r3.get(1);     // Catch: Exception -> L10
        long r5 = Long.parseLong((String) r3.get(2));     // Catch: Exception -> L10
        MLog.d$default(TAG, "lastStartSafeModeProcessInfo mode:" + r4 + ",startTime:" + r5, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(r4, Long.valueOf(r5));
    L13:
        return TuplesKt.to(null, -1L);
    }

    public final Pair<String, Long> lastSafeModeFlagInfo() {
        File r1 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX);
        if (r1 == null) goto L13;
    L10:
        e = move-exception;
        Log.d(TAG, "lastStartSafeModeFlagInfo: " + e);
        goto L13
    L5:
        if (r1.exists() == false) goto L13;
        String r2 = r1.getName();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r2, "safeModeFlogFile.name");     // Catch: Exception -> L10
        List r3 = StringsKt.split$default(r2, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L10
        if (r3.size() != 4) goto L13;
        String r4 = (String) r3.get(1);     // Catch: Exception -> L10
        long r5 = Long.parseLong((String) r3.get(3));     // Catch: Exception -> L10
        MLog.d$default(TAG, "lastStartSafeModeFlagInfo mode:" + r4 + ",startTime:" + r5, null, 4, null);     // Catch: Exception -> L10
        return TuplesKt.to(r4, Long.valueOf(r5));
    L13:
        return TuplesKt.to(null, -1L);
    }

    public final String getSafeMode() {
        return SafeCushionFileUtils.INSTANCE.getSafeCushionSpiltFileName(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX, 4, 1);
    }

    public final void updateSafeModeState(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, SearchConfigType.KEY_MODE);
        Intrinsics.checkNotNullParameter(r12, "state");
        List r2 = null;
        MLog.i$default(TAG, "updateSafeModeState mode:" + r11 + ",state:" + r12, null, 4, null);     // Catch: Exception -> L19
        File r0 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX);     // Catch: Exception -> L19
        if (r0 == null) goto L8;
        String r3 = r0.getName();     // Catch: Exception -> L19
        if (r3 == null) goto L8;
        r2 = StringsKt.split$default(r3, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L19
    L8:
        boolean r4 = false;
        if (r2 == null) goto L14;
        if (r2.size() != 4) goto L14;
        r4 = true;
    L14:
        if (r4 == true) goto L16;
        new File(SafeCushionFileUtils.INSTANCE.getExistCrashInfoDir(), "safeModeFlag-" + r11 + '-' + r12 + '-' + System.currentTimeMillis()).createNewFile();     // Catch: Exception -> L19
        return;
    L16:
        SafeCushionFileUtils.INSTANCE.createOrUpdateFile(r0, new File(SafeCushionFileUtils.INSTANCE.getExistCrashInfoDir(), "safeModeFlag-" + r11 + '-' + r12 + '-' + ((String) r2.get(3))));     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        MLog.e(TAG, "updateSafeModeState error", e);
    }

    public final boolean safeModeIsLegal(String r1) {
        if (r1 != null) goto L4;
    L9:
        return true;
    L4:
        if (Intrinsics.areEqual("repair", r1) == true) goto L9;
        if (Intrinsics.areEqual(SafeCushionConstant.UPGRADE_MODE, r1) == true) goto L9;
        return false;
    }

    public final boolean upgradeFinish() {
        File r1 = SafeCushionFileUtils.INSTANCE.getSafeCushionFile(SafeCushionConstant.SAFE_MODE_FLAG_FILE_NAME_PREFIX);
        if (r1 != null) goto L5;
    L17:
        return false;
    L5:
        if (r1.exists() == false) goto L17;
        String r2 = r1.getName();     // Catch: Exception -> L15
        Intrinsics.checkNotNullExpressionValue(r2, "safeModeFlogFile.name");     // Catch: Exception -> L15
        List r3 = StringsKt.split$default(r2, new String[]{"-"}, false, 0, 6, null);     // Catch: Exception -> L15
        if (r3.size() != 4) goto L17;
        String r5 = (String) r3.get(1);     // Catch: Exception -> L15
        String r4 = (String) r3.get(2);     // Catch: Exception -> L15
        MLog.i$default(TAG, "lastStartSafeModeFlagInfo mode:" + r5 + ",state:" + r4, null, 4, null);     // Catch: Exception -> L15
        if (Intrinsics.areEqual(SafeCushionConstant.UPGRADE_MODE, r5) == false) goto L20;
        if (Intrinsics.areEqual(SafeCushionConstant.FINISH_STATE, r4) == true) goto L14;
        return false;
    L14:
        return true;
    L20:
        return false;
    L15:
        e = move-exception;
        MLog.e(TAG, "lastStartSafeModeFlagInfo error", e);
        goto L17
    }
}
