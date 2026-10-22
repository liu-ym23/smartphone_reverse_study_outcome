package tm;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f22142c;
    public int d;
    public int e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f22147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f22148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f22149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22150o;

    public b() {
        this.f22147l = -1;
        this.f22149n = -1;
        this.f22150o = -1;
    }

    public static b b(ReadableArray r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        r10.size();
        b r5 = new b();
        r5.f22140a = r10.getString(0);
        r5.f22141b = (long) r10.getDouble(1);
        int r11 = r5.a(2, r10);
        r5.f22142c = (long) r10.getDouble(r11);
        r5.f22146k = r10.getInt(r11 + 1) - 1;
        int r12 = r11 + 3;
        r5.f22148m = r10.getInt(r11 + 2);
        r5.f22147l = r10.getInt(r12);
        r5.f22149n = r10.getInt(r11 + 4);
        return r5;
    }

    public final int a(int r5, ReadableArray r10) {
        if (r10 != null) goto L4;
    L8:
        this.e = 0;
        this.f22145j = 0;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f22143h = 0.0f;
        this.f22144i = 0.0f;
        return r5;
    L4:
        if (r10.size() < 6) goto L8;
        this.e = r10.getInt(r5);
        this.f22145j = r10.getInt(r5 + 1);
        this.f = (float) r10.getDouble(r5 + 2);
        this.g = (float) r10.getDouble(r5 + 3);
        this.f22143h = (float) r10.getDouble(r5 + 4);
        this.f22144i = (float) r10.getDouble(r5 + 5);
        return r5 + 6;
    }

    public final boolean c(b r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (this.f22140a.equals(r5.f22140a) == true) goto L6;
        return false;
    L6:
        if (this.f22141b == r5.f22141b) goto L8;
        return false;
    L8:
        if (this.f22142c == r5.f22142c) goto L10;
        return false;
    L10:
        if (this.d == r5.d) goto L12;
        return false;
    L12:
        if (this.e == r5.e) goto L14;
        return false;
    L14:
        if (this.f == r5.f) goto L16;
        return false;
    L16:
        if (this.g == r5.g) goto L18;
        return false;
    L18:
        if (this.f22143h == r5.f22143h) goto L20;
        return false;
    L20:
        if (this.f22144i == r5.f22144i) goto L22;
        return false;
    L22:
        if (this.f22145j == r5.f22145j) goto L24;
        return false;
    L24:
        if (this.f22146k == r5.f22146k) goto L26;
        return false;
    L26:
        if (this.f22147l == r5.f22147l) goto L28;
        return false;
    L28:
        if (this.f22148m != r5.f22148m) goto L45;
        return true;
    L45:
        return false;
    }
}
