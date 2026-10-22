package com.obric;

import androidx.core.app.NotificationCompat;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.NameRegex;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: LogLancet.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J9\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\bø\u0001\u0000J\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0014\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J&\u0010\u0015\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017*\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/LogLancet;", "", "()V", "NAME_REGEX", "", "TARGET_CLASS", DayFormatter.DEFAULT_FORMAT, "", PushLog.KEY_TAG, NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", "splitLogIfNeed", "", "originLogBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", BaseSwitches.V, "w", "splitLog", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class LogLancet {
    public static final LogLancet INSTANCE = null;
    public static final String NAME_REGEX = "((^com/obric/security.*)|(^com/bytedanceos.*))";
    public static final String TARGET_CLASS = "android.util.Log";

    static {
        INSTANCE = new LogLancet();
    }

    private LogLancet() {
    }

    @JvmStatic
    public static final void splitLogIfNeed(String r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "originLogBlock");
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.length() <= 4096) goto L11;
        Iterator<T> r0 = splitLog(r4).iterator();
    L9:
        if (r0.hasNext() == false) goto L14;
        r5.invoke("===long log fragment head(hash:" + r4.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L9
    L14:
        return;
    L11:
        r5.invoke(r4);
    }

    @JvmStatic
    public static final List<String> splitLog(String r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$splitLog");
        ArrayList r0 = new ArrayList();
    L4:
        if (r4.length() <= 3800) goto L6;
        String r1 = r4.substring(0, 3800);
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        r0.add(r1);
        r4 = r4.substring(3800, r4.length());
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L4
    L6:
        r0.add(r4);
        return r0;
    }

    @JvmStatic
    @Proxy(globalProxyClass = true, value = DayFormatter.DEFAULT_FORMAT)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int d(String r4, String r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L10;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        OLog.d(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L8
    L15:
        return 0;
    L10:
        OLog.d(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy(DayFormatter.DEFAULT_FORMAT)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int d(String r4, String r5, Throwable r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L13;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L26;
        String r1 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===";
        if (r6 != null) goto L11;
        OLog.d(r4, r1);
        goto L8
    L11:
        OLog.d(r4, r1, r6);
        goto L8
    L26:
        return 0;
    L13:
        if (r6 == null) goto L15;
        OLog.d(r4, r5, r6);
        return 0;
    L15:
        OLog.d(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int i(String r4, String r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L10;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        OLog.i(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L8
    L15:
        return 0;
    L10:
        OLog.i(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("i")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int i(String r4, String r5, Throwable r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L13;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L26;
        String r1 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===";
        if (r6 != null) goto L11;
        OLog.i(r4, r1);
        goto L8
    L11:
        OLog.i(r4, r1, r6);
        goto L8
    L26:
        return 0;
    L13:
        if (r6 == null) goto L15;
        OLog.i(r4, r5, r6);
        return 0;
    L15:
        OLog.i(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int v(String r4, String r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L10;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        OLog.v(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L8
    L15:
        return 0;
    L10:
        OLog.v(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy(BaseSwitches.V)
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int v(String r4, String r5, Throwable r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L13;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L26;
        String r1 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===";
        if (r6 != null) goto L11;
        OLog.v(r4, r1);
        goto L8
    L11:
        OLog.v(r4, r1, r6);
        goto L8
    L26:
        return 0;
    L13:
        if (r6 == null) goto L15;
        OLog.v(r4, r5, r6);
        return 0;
    L15:
        OLog.v(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int e(String r4, String r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L10;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        OLog.e(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L8
    L15:
        return 0;
    L10:
        OLog.e(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("e")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int e(String r4, String r5, Throwable r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L13;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L26;
        String r1 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===";
        if (r6 != null) goto L11;
        OLog.e(r4, r1);
        goto L8
    L11:
        OLog.e(r4, r1, r6);
        goto L8
    L26:
        return 0;
    L13:
        if (r6 == null) goto L15;
        OLog.e(r4, r5, r6);
        return 0;
    L15:
        OLog.e(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int w(String r4, String r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L10;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L15;
        OLog.w(r4, "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===");
        goto L8
    L15:
        return 0;
    L10:
        OLog.w(r4, r5);
        return 0;
    }

    @JvmStatic
    @Proxy("w")
    @NameRegex(NAME_REGEX)
    @TargetClass(TARGET_CLASS)
    public static final int w(String r4, String r5, Throwable r6) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.length() <= 4096) goto L13;
        Iterator<T> r0 = splitLog(r5).iterator();
    L8:
        if (r0.hasNext() == false) goto L26;
        String r1 = "===long log fragment head(hash:" + r5.hashCode() + ")===" + ((String) r0.next()) + "===long log fragment tail===";
        if (r6 != null) goto L11;
        OLog.w(r4, r1);
        goto L8
    L11:
        OLog.w(r4, r1, r6);
        goto L8
    L26:
        return 0;
    L13:
        if (r6 == null) goto L15;
        OLog.w(r4, r5, r6);
        return 0;
    L15:
        OLog.w(r4, r5);
        return 0;
    }
}
