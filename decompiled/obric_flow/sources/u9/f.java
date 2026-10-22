package u9;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f22301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f22302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f22303c;
    public ArrayList d;
    public ArrayList e;
    public HashSet f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f22305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile int f22306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f22307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f22308l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22309m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f22310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f22311o;

    public f(ArrayList r5, ArrayList r10) {
        this.f22301a = r5;
        this.f22302b = r10;
        this.f22307k = SystemClock.uptimeMillis();
        this.f22306j = 0;
        this.f22304h = Integer.MAX_VALUE;
        this.g = 0;
        this.f22308l = false;
        this.f22305i = UUID.randomUUID().toString();
        this.f22310n = false;
        this.f22309m = 4000;
        this.f22311o = true;
    }
}
