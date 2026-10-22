package com.obric.safecheck.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.standard.tools.date.DateUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlacklistRecordSP.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/safecheck/service/BlacklistRecordSP;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DATE_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "cacheApkCount", "", "cacheCommonDate", "", "cachePhoneCount", "cacheUrlCount", "getContext", "()Landroid/content/Context;", "isCacheLoaded", "", CloudControlInf.SP, "Landroid/content/SharedPreferences;", "clearAllRecords", "", "getApkHitCount", "getCurrentDateString", "getPhoneHitCount", "getUrlHitCount", "lazyLoadCache", "recordApkHit", "Lcom/obric/safecheck/service/BlacklistRecordSP$DailyHitCounts;", "recordHit", "countKey", "recordPhoneHit", "recordUrlHit", "Companion", "DailyHitCounts", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BlacklistRecordSP {
    public static final Companion Companion = null;
    public static final String KEY_APK_COUNT = "apk_count";
    public static final String KEY_COMMON_DATE = "common_date";
    public static final String KEY_PHONE_COUNT = "phone_count";
    public static final String KEY_URL_COUNT = "url_count";
    public static final String SP_NAME = "blacklist_record_sp";
    private final DateTimeFormatter DATE_FORMATTER;
    private int cacheApkCount;
    private String cacheCommonDate;
    private int cachePhoneCount;
    private int cacheUrlCount;
    private final Context context;
    private boolean isCacheLoaded;
    private final SharedPreferences sp;

    /* JADX INFO: compiled from: BlacklistRecordSP.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/service/BlacklistRecordSP$Companion;", "", "()V", "KEY_APK_COUNT", "", "KEY_COMMON_DATE", "KEY_PHONE_COUNT", "KEY_URL_COUNT", "SP_NAME", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: BlacklistRecordSP.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/safecheck/service/BlacklistRecordSP$DailyHitCounts;", "", "phoneCount", "", "urlCount", "apkCount", "(III)V", "getApkCount", "()I", "getPhoneCount", "getUrlCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DailyHitCounts {
        private final int apkCount;
        private final int phoneCount;
        private final int urlCount;

        public static /* synthetic */ DailyHitCounts copy$default(DailyHitCounts r0, int r1, int r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.phoneCount;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.urlCount;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.apkCount;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.phoneCount;
        }

        public final int component2() {
            return this.urlCount;
        }

        public final int component3() {
            return this.apkCount;
        }

        public final DailyHitCounts copy(int r1, int r2, int r3) {
            return new DailyHitCounts(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof DailyHitCounts) == false) goto L12;
            DailyHitCounts r4 = (DailyHitCounts) r3;
            if (this.phoneCount == r4.phoneCount) goto L8;
            return false;
        L8:
            if (this.urlCount == r4.urlCount) goto L10;
            return false;
        L10:
            if (this.apkCount == r4.apkCount) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.phoneCount) * 31) + Integer.hashCode(this.urlCount)) * 31) + Integer.hashCode(this.apkCount);
        }

        public String toString() {
            return "DailyHitCounts(phoneCount=" + this.phoneCount + ", urlCount=" + this.urlCount + ", apkCount=" + this.apkCount + ")";
        }

        public DailyHitCounts(int r1, int r2, int r3) {
            this.phoneCount = r1;
            this.urlCount = r2;
            this.apkCount = r3;
        }

        public final int getPhoneCount() {
            return this.phoneCount;
        }

        public final int getUrlCount() {
            return this.urlCount;
        }

        public final int getApkCount() {
            return this.apkCount;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public BlacklistRecordSP(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.context = r3;
        this.DATE_FORMATTER = DateTimeFormatter.ofPattern(DateUtils.PATTERN_YEAR);
        SharedPreferences r4 = r3.getApplicationContext().getSharedPreferences(SP_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(r4, "context.applicationConte…ME, Context.MODE_PRIVATE)");
        this.sp = r4;
        this.cacheCommonDate = "";
    }

    public final Context getContext() {
        return this.context;
    }

    private final void lazyLoadCache() {
        if (this.isCacheLoaded == true) goto L10;
        String r2 = "";
        String r0 = this.sp.getString(KEY_COMMON_DATE, "");
        if (r0 == null) goto L8;
        r2 = r0;
    L8:
        this.cacheCommonDate = r2;
        this.cachePhoneCount = this.sp.getInt(KEY_PHONE_COUNT, 0);
        this.cacheUrlCount = this.sp.getInt(KEY_URL_COUNT, 0);
        this.cacheApkCount = this.sp.getInt(KEY_APK_COUNT, 0);
        this.isCacheLoaded = true;
        return;
    }

    public final DailyHitCounts recordHit(String r12) {
        Intrinsics.checkNotNullParameter(r12, "countKey");
        lazyLoadCache();
        String r0 = getCurrentDateString();
        int r2 = 0;
        new DailyHitCounts(0, 0, 0);
        if ((!Intrinsics.areEqual(r0, this.cacheCommonDate)) == false) goto L33;
        this.cacheCommonDate = r0;
        this.cachePhoneCount = 0;
        this.cacheUrlCount = 0;
        this.cacheApkCount = 0;
        int r1 = r12.hashCode();
        if (r1 == (-722819330)) goto L16;
        if (r1 == (-26121665)) goto L13;
        if (r1 == 1685072172) goto L10;
    L18:
        SharedPreferences.Editor r3 = this.sp.edit();
        r3.putString(KEY_COMMON_DATE, r0);
        int r4 = r12.hashCode();
        if (r4 == (-722819330)) goto L30;
        if (r4 == (-26121665)) goto L27;
        if (r4 == 1685072172) goto L24;
    L32:
        r3.putInt(r12, r2);
        r3.apply();
    L63:
        return new DailyHitCounts(this.cachePhoneCount, this.cacheUrlCount, this.cacheApkCount);
    L24:
        if (r12.equals(KEY_APK_COUNT) == false) goto L32;
    L31:
        r2 = 1;
        goto L32
    L27:
        if (r12.equals(KEY_URL_COUNT) == false) goto L32;
    L30:
        if (r12.equals(KEY_PHONE_COUNT) == false) goto L32;
    L10:
        if (r12.equals(KEY_APK_COUNT) == false) goto L18;
        this.cacheApkCount = 1;
        goto L18
    L13:
        if (r12.equals(KEY_URL_COUNT) == false) goto L18;
        this.cacheUrlCount = 1;
        goto L18
    L16:
        if (r12.equals(KEY_PHONE_COUNT) == false) goto L18;
        this.cachePhoneCount = 1;
        goto L18
    L33:
        int r5 = r12.hashCode();
        if (r5 == (-722819330)) goto L45;
        if (r5 == (-26121665)) goto L42;
        if (r5 == 1685072172) goto L39;
    L47:
        SharedPreferences.Editor r6 = this.sp.edit();
        int r7 = r12.hashCode();
        if (r7 == (-722819330)) goto L59;
        if (r7 == (-26121665)) goto L56;
        if (r7 == 1685072172) goto L53;
    L61:
        r6.putInt(r12, r2).apply();
        goto L63
    L53:
        if (r12.equals(KEY_APK_COUNT) == false) goto L61;
        r2 = this.cacheApkCount;
        goto L61
    L56:
        if (r12.equals(KEY_URL_COUNT) == false) goto L61;
        r2 = this.cacheUrlCount;
        goto L61
    L59:
        if (r12.equals(KEY_PHONE_COUNT) == false) goto L61;
        r2 = this.cachePhoneCount;
        goto L61
    L39:
        if (r12.equals(KEY_APK_COUNT) == false) goto L47;
        this.cacheApkCount++;
        goto L47
    L42:
        if (r12.equals(KEY_URL_COUNT) == false) goto L47;
        this.cacheUrlCount++;
        goto L47
    L45:
        if (r12.equals(KEY_PHONE_COUNT) == false) goto L47;
        this.cachePhoneCount++;
        goto L47
    }

    public final DailyHitCounts recordPhoneHit() {
        return recordHit(KEY_PHONE_COUNT);
    }

    public final DailyHitCounts recordUrlHit() {
        return recordHit(KEY_URL_COUNT);
    }

    public final DailyHitCounts recordApkHit() {
        return recordHit(KEY_APK_COUNT);
    }

    public final int getPhoneHitCount() {
        lazyLoadCache();
        if (Intrinsics.areEqual(getCurrentDateString(), this.cacheCommonDate) == true) goto L7;
        return 0;
    L7:
        return this.cachePhoneCount;
    }

    public final int getUrlHitCount() {
        lazyLoadCache();
        if (Intrinsics.areEqual(getCurrentDateString(), this.cacheCommonDate) == true) goto L7;
        return 0;
    L7:
        return this.cacheUrlCount;
    }

    public final int getApkHitCount() {
        lazyLoadCache();
        if (Intrinsics.areEqual(getCurrentDateString(), this.cacheCommonDate) == true) goto L7;
        return 0;
    L7:
        return this.cacheApkCount;
    }

    public final String getCurrentDateString() {
        String r1 = LocalDate.now().format(this.DATE_FORMATTER);
        Intrinsics.checkNotNullExpressionValue(r1, "currentDate.format(DATE_FORMATTER)");
        return r1;
    }

    public final void clearAllRecords() {
        this.cacheCommonDate = "";
        this.cachePhoneCount = 0;
        this.cacheUrlCount = 0;
        this.cacheApkCount = 0;
        this.isCacheLoaded = false;
        this.sp.edit().clear().apply();
    }
}
