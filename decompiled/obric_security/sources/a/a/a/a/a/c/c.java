package a.a.a.a.a.c;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.obric.oui.calendar.format.DayFormatter;
import com.ss.android.message.log.PushLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0003J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0003J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001c\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J$\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/matrix/push/common/log/Logger;", "", "()V", "TAG", "", "androidLogger", "Lcom/obric/matrix/push/common/log/ILogger;", "enableAndroidLog", "", "proxyLogger", DayFormatter.DEFAULT_FORMAT, "", NotificationCompat.CATEGORY_MESSAGE, PushLog.KEY_TAG, "e", "tr", "", "formatMsg", "formatTag", "i", "init", "impl", BaseSwitches.V, "w", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9a = null;
    public static boolean b = true;
    public static b c;
    public static final b d = null;

    static {
        f9a = new c();
        d = new a();
    }

    public c() {
    }

    @JvmStatic
    public static final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        String r5 = b(r3, r4);
        if (b == false) goto L5;
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_MESSAGE);
        Log.d("MATRIX_PUSH", r5);
    L5:
        b r6 = c;
        if (r6 == null) goto L9;
        r6.a("MATRIX_PUSH", r5);
        return;
    }

    @JvmStatic
    public static final String b(String r1, String r2) {
        if (r1 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r2;
    L11:
        return r1 + "-->" + r2;
    L4:
        if (r1.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @JvmStatic
    public static final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        a("", r2, null);
    }

    @JvmStatic
    public static final void a(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_MESSAGE);
        String r6 = b(r3, r4);
        if (b == false) goto L5;
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r6, NotificationCompat.CATEGORY_MESSAGE);
        Log.e("MATRIX_PUSH", r6, r5);
    L5:
        b r7 = c;
        if (r7 == null) goto L9;
        r7.a("MATRIX_PUSH", r6, r5);
        return;
    }
}
