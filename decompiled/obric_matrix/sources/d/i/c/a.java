package d.i.c;

import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f17035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f17036b;

    static {
        new AtomicInteger(0);
    }

    public static void a() {
        HandlerThread r0 = f17035a;
        if (r0 == null) goto L6;
        r0.quit();
        f17036b.onStop();
        f17035a = null;
        f17036b = null;
        return;
    }
}
