package v6;

import android.os.SystemClock;
import com.bytedance.apm.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f22528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f22529c;
    public volatile long d;
    public volatile long e;
    public volatile long f;

    public final void a() {
        if (this.f22527a == false) goto L5;
        return;
    L5:
        this.f22527a = true;
        boolean r5 = j.f3887a;
        throw null;
    }

    public final void b() {
        if ((SystemClock.elapsedRealtime() - this.f) >= 1000) goto L5;
        return;
    L5:
        if (this.f == (-1)) goto L10;
        boolean r5 = j.f3887a;
        throw null;
    }
}
