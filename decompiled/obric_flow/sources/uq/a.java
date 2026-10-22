package uq;

import android.util.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final ThreadLocal f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap f22425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f22426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.c f22427c;
    public i4.a d;
    public boolean e;

    static {
        f = new ThreadLocal();
    }

    public a() {
        this.f22425a = new ArrayMap();
        this.f22426b = new ArrayList();
        this.f22427c = new android.support.v4.media.c(this);
        this.e = false;
    }
}
