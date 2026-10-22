package vl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f22587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f22588b = null;

    static {
        f22587a = new Handler(Looper.getMainLooper());
        HandlerThread r5 = new HandlerThread("background_thread_utils");
        r5.start();
        f22588b = new Handler(r5.getLooper());
    }
}
