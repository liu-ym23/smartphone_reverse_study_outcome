package com.obric.oui.utils.log;

import a.a;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AndroidLogger implements L.Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f312a;
    public final boolean b;

    public AndroidLogger() {
        this.f312a = "OUI_SDK";
        this.b = false;
    }

    public final void a(String r3, int r4, String r5, Throwable r6) {
        Intrinsics.f(r5, NotificationCompat.CATEGORY_MESSAGE);
        if (r3 == null) goto L9;
        if (r3.length() == 0) goto L9;
        r5 = a.B(r3, "-->", r5);
    L9:
        if (this.b == false) goto L11;
        StringBuilder r7 = new StringBuilder("[");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "Thread.currentThread()");
        r7.append(r0.getName());
        r7.append("]|");
        r7.append(r5);
        r5 = r7.toString();
    L11:
        String r2 = this.f312a;
        if (r4 != 1) goto L14;
        Log.v(r2, r5);
        return;
    L14:
        if (r4 != 2) goto L16;
        Log.d(r2, r5);
        return;
    L16:
        if (r4 != 4) goto L18;
        Log.i(r2, r5);
        return;
    L18:
        if (r4 != 8) goto L20;
        if (r6 != null) goto L27;
        Log.w(r2, r5);
        return;
    L27:
        Log.w(r2, r5, r6);
        return;
    L20:
        if (r4 != 16) goto L38;
        if (r6 != null) goto L24;
        Log.e(r2, r5);
        return;
    L24:
        Log.e(r2, r5, r6);
        return;
    }
}
