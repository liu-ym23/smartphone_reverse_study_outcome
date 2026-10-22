package com.obric.security.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.olog.OLog;
import com.obric.security.trafficHigh.TrafficHighWarningReceiver;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoticeEventRecorder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/security/util/NoticeEventRecorder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "clearRecord", "", "recordKey", "", "getCycleStartTime", "", ProviderConstants.Sms.DATE, "Ljava/util/Date;", "cycleType", "Lcom/obric/security/util/NoticeEventRecorder$CycleType;", "getLastRecordTime", "getMonthlyStartTime", "getNoonToNoonStartTime", "hasRecordInCurrentCycle", "", "recordCurrentTime", "Companion", "CycleType", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class NoticeEventRecorder {
    public static final Companion Companion = null;
    private static final int NOON_HOUR = 12;
    private static final String PREF_NAME = "NoticeEventPrefs";
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: compiled from: NoticeEventRecorder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/util/NoticeEventRecorder$Companion;", "", "()V", "NOON_HOUR", "", "PREF_NAME", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: NoticeEventRecorder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/security/util/NoticeEventRecorder$CycleType;", "", "(Ljava/lang/String;I)V", "NOON_TO_NOON", "MONTHLY", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CycleType extends Enum<CycleType> {
        private static final /* synthetic */ CycleType[] $VALUES = null;
        public static final CycleType MONTHLY = null;
        public static final CycleType NOON_TO_NOON = null;

        static {
            CycleType r1 = new CycleType("NOON_TO_NOON", 0);
            NOON_TO_NOON = r1;
            CycleType r2 = new CycleType("MONTHLY", 1);
            MONTHLY = r2;
            $VALUES = new CycleType[]{r1, r2};
        }

        public static CycleType valueOf(String r1) {
            return (CycleType) Enum.valueOf(CycleType.class, r1);
        }

        public static CycleType[] values() {
            return (CycleType[]) $VALUES.clone();
        }

        private CycleType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[CycleType.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[CycleType.NOON_TO_NOON.ordinal()] = 1;
            r0[CycleType.MONTHLY.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public NoticeEventRecorder(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        SharedPreferences r4 = r3.getSharedPreferences(PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.sharedPreferences = r4;
    }

    public final boolean hasRecordInCurrentCycle(String r11, CycleType r12) {
        Intrinsics.checkNotNullParameter(r11, "recordKey");
        Intrinsics.checkNotNullParameter(r12, "cycleType");
        long r3 = this.sharedPreferences.getLong(r11, 0);
        OLog.d(TrafficHighWarningReceiver.TAG, "hasRecordInCurrentCycle:,recordKey:" + r11 + ",cycleType:" + r12 + ",lastRecordTime:" + r3);
        if (r3 != 0) goto L5;
        return false;
    L5:
        long r8 = getCycleStartTime(new Date(), r12);
        long r2 = getCycleStartTime(new Date(r3), r12);
        OLog.d(TrafficHighWarningReceiver.TAG, "hasRecordInCurrentCycle:,recordKey:" + r11 + ",cycleType:" + r12 + ",currentCycleStart:" + r8 + ",lastRecordCycleStart:" + r2);
        if (r8 != r2) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean recordCurrentTime(String r5, CycleType r6) {
        Intrinsics.checkNotNullParameter(r5, "recordKey");
        Intrinsics.checkNotNullParameter(r6, "cycleType");
        if (hasRecordInCurrentCycle(r5, r6) == false) goto L6;
        return false;
    L6:
        long r0 = System.currentTimeMillis();
        OLog.d(TrafficHighWarningReceiver.TAG, "recordCurrentTime:,recordKey:" + r5 + ",cycleType:" + r6 + ",currentTime:" + r0);
        this.sharedPreferences.edit().putLong(r5, r0).apply();
        return true;
    }

    private final long getCycleStartTime(Date r2, CycleType r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r3.ordinal()];
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L8;
        return getMonthlyStartTime(r2);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return getNoonToNoonStartTime(r2);
    }

    private final long getNoonToNoonStartTime(Date r4) {
        Calendar r3 = Calendar.getInstance();
        r3.setTime(r4);
        if (r3.get(11) >= 12) goto L5;
        r3.add(5, -1);
    L5:
        r3.set(11, 12);
        r3.set(12, 0);
        r3.set(13, 0);
        r3.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(r3, "Calendar.getInstance().a…MILLISECOND, 0)\n        }");
        return r3.getTimeInMillis();
    }

    private final long getMonthlyStartTime(Date r2) {
        Calendar r1 = Calendar.getInstance();
        r1.setTime(r2);
        r1.set(5, 1);
        r1.set(11, 0);
        r1.set(12, 0);
        r1.set(13, 0);
        r1.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(r1, "Calendar.getInstance().a…MILLISECOND, 0)\n        }");
        return r1.getTimeInMillis();
    }

    public final void clearRecord(String r2) {
        Intrinsics.checkNotNullParameter(r2, "recordKey");
        this.sharedPreferences.edit().remove(r2).apply();
    }

    public final long getLastRecordTime(String r3) {
        Intrinsics.checkNotNullParameter(r3, "recordKey");
        return this.sharedPreferences.getLong(r3, 0);
    }
}
