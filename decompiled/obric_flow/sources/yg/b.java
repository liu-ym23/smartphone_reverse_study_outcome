package yg;

import android.net.Uri;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final Gson g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f23260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f23262c;
    public final boolean d;
    public final boolean e;
    public final boolean f;

    static {
        g = new Gson();
    }

    public b(Uri r5, String r10, Uri r11, boolean r12, boolean r13, boolean r14) {
        this.f23260a = r5;
        this.f23261b = r10;
        this.f23262c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }
}
