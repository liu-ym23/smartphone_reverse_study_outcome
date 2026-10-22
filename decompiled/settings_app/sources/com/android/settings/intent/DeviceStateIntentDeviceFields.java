package com.android.settings.intent;

import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import cz.msebera.android.httpclient.message.TokenParser;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentDeviceFields;", "", "()V", "IPV4_REGEX", "Lkotlin/text/Regex;", "STORAGE_BASE_1000", "", "chooseStorageAvailableBytes", "", "statsFreeBytes", "settingsAvailableBytes", "legacyAvailableBytes", "formatStorageSize", "", PerfConsts.PERF_DISK_FILE_SIZE, "formatStorageSizeBase1000", "bytes", "getFirstIpv4Address", "addresses", "getScreenSizeForSoc", "brand", "socModel", "shouldQueryPrimaryStorageFreeBytes", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentDeviceFields {
    public static final DeviceStateIntentDeviceFields INSTANCE = null;
    private static final Regex IPV4_REGEX = null;
    private static final double STORAGE_BASE_1000 = 1000.0d;

    @JvmStatic
    public static final long chooseStorageAvailableBytes(long r3, long r5, long r7) {
        if (r5 <= 0) goto L6;
        return r5;
    L6:
        if (r3 <= 0) goto L9;
        return r3;
    L9:
        if (r7 <= 0) goto L12;
        return r7;
    L12:
        return 0;
    }

    @JvmStatic
    public static final boolean shouldQueryPrimaryStorageFreeBytes(long r2) {
        if (r2 > 0) goto L5;
        return true;
    L5:
        return false;
    }

    private DeviceStateIntentDeviceFields() {
    }

    @JvmStatic
    public static final String getScreenSizeForSoc(String r2, String r3) {
        if (StringsKt.equals(r2, "nubia", true) == true) goto L6;
        return "";
    L6:
        if (Intrinsics.areEqual(r3, "SM7450") == false) goto L9;
        return "6.7";
    L9:
        if (Intrinsics.areEqual(r3, "SM8750") == false) goto L13;
        return "6.78";
    L13:
        return "";
    }

    @JvmStatic
    public static final String getFirstIpv4Address(String r4) {
        String r5 = r4;
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return "";
    L12:
        Iterator r6 = SequencesKt.map(StringsKt.lineSequence(r5), AnonymousClass1.INSTANCE).iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Object r1 = r6.next();
        if (IPV4_REGEX.matches((String) r1) == false) goto L14;
    L19:
        String r2 = (String) r1;
        if (r2 != null) goto L23;
        return "";
    L23:
        return r2;
    L18:
        r1 = null;
        goto L19
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r0 = false;
        goto L10
    }

    @JvmStatic
    public static final String formatStorageSize(String r6) {
        if (r6 == null) goto L6;
        String r0 = StringsKt.trim(r6).toString();
        if (r0 == null) goto L6;
        String r7 = StringsKt.replace$default(r0, "kB", "KB", false, 4, null);
    L7:
        if (r7 != null) goto L10;
        return "";
    L10:
        return r7;
    L6:
        r7 = null;
        goto L7
    }

    @JvmStatic
    public static final String formatStorageSizeBase1000(long r8) {
        if (r8 > 0) goto L6;
        return "";
    L6:
        String[] r0 = {VCardConstants.PARAM_ENCODING_B, "KB", "MB", "GB", "TB"};
        double r9 = r8;
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= ArraysKt.getLastIndex(r0)) goto L12;
        if (r9 < STORAGE_BASE_1000) goto L12;
        r9 = r9 / STORAGE_BASE_1000;
        r2 = r2 + 1;
    L12:
        BigDecimal r10 = BigDecimal.valueOf(r9);
        if (r2 == 0) goto L16;
        r1 = 1;
    L16:
        BigDecimal r11 = r10.setScale(r1, RoundingMode.HALF_UP);
    L18:
        if (r2 >= ArraysKt.getLastIndex(r0)) goto L23;
        if (r11.doubleValue() < STORAGE_BASE_1000) goto L23;
        r2 = r2 + 1;
        r11 = BigDecimal.valueOf(r11.doubleValue() / STORAGE_BASE_1000).setScale(1, RoundingMode.HALF_UP);
    L23:
        return r11.stripTrailingZeros().toPlainString() + TokenParser.SP + r0[r2];
    }

    static {
        INSTANCE = new DeviceStateIntentDeviceFields();
        IPV4_REGEX = new Regex("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$");
    }
}
