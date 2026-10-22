package t2;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22090b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f22091c = null;
    public static final wt.d d = null;

    static {
        f22089a = new a(f.f22095a);
        f22090b = new a(f.f22096b);
        new a(f.f22097c);
        f22091c = new a(f.d);
        new a(f.e);
        Looper r5 = Looper.getMainLooper();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Handler r10 = Handler.createAsync(r5);
        int r11 = wt.e.f22907a;
        d = new wt.d(r10, "fast-main", false);
    }
}
