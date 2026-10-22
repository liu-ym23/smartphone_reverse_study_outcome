package d.c.c.b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public class h extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static h f15376g;

    static {
    }

    private h() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static h g() {
        if (f15376g != null) goto L6;
        f15376g = new h();
    L6:
        return f15376g;
    }

    @Override // d.c.c.b.e, java.util.concurrent.Executor
    public void execute(Runnable r2) {
        if (a() == false) goto L5;
        r2.run();
        return;
    L5:
        super.execute(r2);
    }
}
