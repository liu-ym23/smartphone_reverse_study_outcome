package d.c.i.f;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f15989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f15990b;

    static class a extends b {
        a() {
        }

        @Override // d.c.i.f.b
        public Bitmap.Config a(boolean r1, d.c.h.d r2) {
            return Bitmap.Config.ARGB_8888;
        }
    }

    static {
        a r0 = new a();
        f15989a = r0;
        f15990b = r0;
    }

    public b() {
    }

    public static b b() {
        return f15990b;
    }

    public abstract Bitmap.Config a(boolean r1, d.c.h.d r2);
}
