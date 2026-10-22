package com.obric.capabilitykit.common;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import cz.msebera.android.httpclient.message.TokenParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/common/ClockUtils;", "", "()V", "convertDaysOfWeekToDesc", "", "daysOfWeek", "", "", "convertTimeToDesc", "hour", "minutes", "genClockTimeDesc", "alarm", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "getTodayOrTomorrow", "date", "minute", "isSameDay", "", "cal1", "Ljava/util/Calendar;", "cal2", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ClockUtils {
    public static final ClockUtils INSTANCE = null;

    static {
        INSTANCE = new ClockUtils();
    }

    private ClockUtils() {
    }

    private final String convertDaysOfWeekToDesc(List<Integer> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r9 = r10.iterator();
    L4:
        if (r9.hasNext() == false) goto L17;
        switch(r9.next().intValue()) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L8:
        String r11 = "周日";
    L15:
        r0.add(r11);
        goto L4
    L9:
        r11 = "周六";
        goto L15
    L10:
        r11 = "周五";
        goto L15
    L11:
        r11 = "周四";
        goto L15
    L12:
        r11 = "周三";
        goto L15
    L13:
        r11 = "周二";
        goto L15
    L14:
        r11 = "周一";
        goto L15
    L17:
        if (r0.size() != 7) goto L20;
        return "每天";
    L20:
        return "每" + CollectionsKt.joinToString$default(r0, "、", null, null, 0, null, null, 62, null);
    }

    private final String convertTimeToDesc(int r5, int r6) {
        boolean r0 = true;
        if (r5 < 0) goto L6;
        if (r5 >= 5) goto L6;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        String r4 = "凌晨";
    L32:
        if (r5 <= 12) goto L35;
        r5 = r5 - 12;
    L35:
        if (r6 != 0) goto L37;
        StringBuilder r7 = new StringBuilder().append(r4).append(r5).append(28857);
    L39:
        return r7.toString();
    L37:
        r7 = new StringBuilder().append(r4).append(r5).append(28857).append(r6).append(20998);
        goto L39
    L10:
        if (5 > r5) goto L13;
        if (r5 >= 12) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == false) goto L16;
        r4 = "上午";
        goto L32
    L16:
        if (r5 != 12) goto L19;
        r4 = "中午";
        goto L32
    L19:
        if (13 > r5) goto L22;
        if (r5 >= 20) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L25;
        r4 = "下午";
        goto L32
    L25:
        if (20 <= r5) goto L27;
    L29:
        r0 = false;
    L30:
        if (r0 == false) goto L41;
        r4 = "晚上";
        goto L32
    L41:
        throw new IllegalArgumentException("小时必须在0到23之间");
    L27:
        if (r5 >= 24) goto L29;
    L22:
        r9 = false;
    L13:
        r8 = false;
    L6:
        r2 = false;
        goto L8
    }

    private final String getTodayOrTomorrow(String r5, int r6, int r7) {
        Date r8 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(r5 + TokenParser.SP + r6 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r7);
        Calendar r9 = Calendar.getInstance();
        r9.setTime(r8);
        Calendar r10 = Calendar.getInstance();
        Calendar r11 = Calendar.getInstance();
        r11.add(6, 1);
        Calendar r2 = Calendar.getInstance();
        r2.add(6, 2);
        Intrinsics.checkNotNullExpressionValue(r9, "calendar");
        Intrinsics.checkNotNullExpressionValue(r10, "todayCalendar");
        if (isSameDay(r9, r10) == false) goto L5;
        return "今天";
    L5:
        Intrinsics.checkNotNullExpressionValue(r11, "tomorrowCalendar");
        if (isSameDay(r9, r11) == false) goto L8;
        return "明天";
    L8:
        Intrinsics.checkNotNullExpressionValue(r2, "dayAfterTomorrowCalendar");
        if (isSameDay(r9, r2) == false) goto L12;
        return "后天";
    L12:
        return new StringBuilder().append(r9.get(2) + 1).append(26376).append(r9.get(5)).append(26085).toString();
    }

    private final boolean isSameDay(Calendar r3, Calendar r4) {
        if (r3.get(1) == r4.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r3.get(6) != r4.get(6)) goto L7;
        return true;
    }

    public final String genClockTimeDesc(AlarmEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "alarm");
        int r0 = Integer.parseInt(StringsKt.substringBefore$default(r6.getStartTime(), ":", null, 2, null));
        int r1 = Integer.parseInt(StringsKt.substringAfter$default(r6.getStartTime(), ":", null, 2, null));
        StringBuilder r2 = new StringBuilder();
        List<Integer> r3 = r6.getRepeatDayOfWeek();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        List<Integer> r7 = r6.getRepeatDayOfWeek();
        Intrinsics.checkNotNull(r7);
        String r8 = convertDaysOfWeekToDesc(r7);
    L12:
        r2.append(r8);
        r2.append(convertTimeToDesc(r0, r1));
        String r5 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "sb.toString()");
        return r5;
    L11:
        String r9 = r6.getDate();
        Intrinsics.checkNotNull(r9);
        r8 = getTodayOrTomorrow(r9, r0, r1);
        goto L12
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }
}
