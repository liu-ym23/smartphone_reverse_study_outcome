package rh;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.pia.core.utils.j;
import com.obric.launcher.widget.R$raw;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21738a = null;

    static {
        Application r5 = zg.b.f23438a;
        String r10 = null;
        if (r5 == null) goto L13;
        long r11 = System.currentTimeMillis();
        InputStream r12 = r5.getResources().openRawResource(R$raw.pia_worker_polyfill);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r12, "<this>");     // Catch: Throwable -> L8
        String r13 = j.m(r12, "");     // Catch: Throwable -> L8
    L10:
        j.A("[Worker] load worker polyfill success, cost: " + (System.currentTimeMillis() - r11));
        if (TextUtils.isEmpty(r13) == true) goto L13;
        r10 = r13;
    L8:
        th = move-exception;
        Intrinsics.checkNotNullParameter("[Worker] load worker polyfill error:", "message");
        j.x("[Worker] load worker polyfill error:", th);
        r13 = null;
    L13:
        f21738a = r10;
    }
}
