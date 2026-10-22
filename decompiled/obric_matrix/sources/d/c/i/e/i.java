package d.c.i.e;

import android.app.ActivityManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class i implements d.c.c.d.l<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityManager f15964a;

    public i(ActivityManager r1) {
        this.f15964a = r1;
    }

    private int b() {
        int r2 = Math.min(this.f15964a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r2 >= 33554432) goto L7;
        return 4194304;
    L7:
        if (r2 >= 67108864) goto L11;
        return 6291456;
    L11:
        if (Build.VERSION.SDK_INT >= 11) goto L15;
        return 8388608;
    L15:
        return r2 / 4;
    }

    public r a() {
        return new r(b(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ r get() {
        return a();
    }
}
