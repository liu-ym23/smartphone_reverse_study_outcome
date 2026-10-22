package d.c.i.c.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.i.c.a.a f15895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f15896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f15897c;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15898a = null;

        static {
            int[] r0 = new int[c.values().length];
            f15898a = r0;
            r0[c.f15899f.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f15898a[c.f15900g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f15898a[c.f15902i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f15898a[c.f15901h.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public interface b {
        void a(int r1, Bitmap r2);

        d.c.c.h.a<Bitmap> b(int r1);
    }

    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f15899f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f15900g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f15901h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f15902i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f15903j = null;

        static {
            c r0 = new c("REQUIRED", 0);
            f15899f = r0;
            c r1 = new c("NOT_REQUIRED", 1);
            f15900g = r1;
            c r3 = new c("SKIP", 2);
            f15901h = r3;
            c r5 = new c("ABORT", 3);
            f15902i = r5;
            f15903j = new c[]{r0, r1, r3, r5};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        public static c valueOf(String r1) {
            return (c) Enum.valueOf(c.class, r1);
        }

        public static c[] values() {
            return (c[]) f15903j.clone();
        }
    }

    public d(d.c.i.c.a.a r1, b r2) {
        this.f15895a = r1;
        this.f15896b = r2;
        Paint r3 = new Paint();
        this.f15897c = r3;
        r3.setColor(0);
        r3.setStyle(Paint.Style.FILL);
        r3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void a(Canvas r8, d.c.i.c.a.b r9) {
        int r0 = r9.f15843a;
        int r1 = r9.f15844b;
        r8.drawRect(r0, r1, r0 + r9.f15845c, r1 + r9.f15846d, this.f15897c);
    }

    private c b(int r3) {
        d.c.i.c.a.b r4 = this.f15895a.c(r3);
        d.c.i.c.a.b.EnumC0426b r0 = r4.f15848f;
        if (r0 != d.c.i.c.a.b.EnumC0426b.f15852f) goto L7;
        return c.f15899f;
    L7:
        if (r0 != d.c.i.c.a.b.EnumC0426b.f15853g) goto L15;
        if (c(r4) == false) goto L13;
        return c.f15900g;
    L13:
        return c.f15899f;
    L15:
        if (r0 != d.c.i.c.a.b.EnumC0426b.f15854h) goto L19;
        return c.f15901h;
    L19:
        return c.f15902i;
    }

    private boolean c(d.c.i.c.a.b r3) {
        if (r3.f15843a == 0) goto L5;
    L11:
        return false;
    L5:
        if (r3.f15844b != 0) goto L11;
        if (r3.f15845c != this.f15895a.h()) goto L11;
        if (r3.f15846d != this.f15895a.g()) goto L11;
        return true;
    }

    private boolean d(int r5) {
        if (r5 != 0) goto L5;
        return true;
    L5:
        d.c.i.c.a.b r1 = this.f15895a.c(r5);
        d.c.i.c.a.b r6 = this.f15895a.c(r5 - 1);
        if (r1.f15847e != d.c.i.c.a.b.a.f15850g) goto L11;
        if (c(r1) == false) goto L11;
        return true;
    L11:
        if (r6.f15848f == d.c.i.c.a.b.EnumC0426b.f15853g) goto L13;
    L15:
        return false;
    L13:
        if (c(r6) == false) goto L15;
        return true;
    }

    private int e(int r7, Canvas r8) {
    L2:
        if (r7 < 0) goto L27;
        int r0 = a.f15898a[b(r7).ordinal()];
        if (r0 != 1) goto L6;
        d.c.i.c.a.b r1 = this.f15895a.c(r7);
        d.c.c.h.a<Bitmap> r2 = this.f15896b.b(r7);
        if (r2 == null) goto L24;
        r8.drawBitmap(r2.N(), 0.0f, 0.0f, null);     // Catch: Throwable -> L20
        if (r1.f15848f != d.c.i.c.a.b.EnumC0426b.f15853g) goto L18;
        a(r8, r1);     // Catch: Throwable -> L20
    L18:
        int r9 = r7 + 1;
        r2.close();
        return r9;
    L20:
        th = move-exception;
        r2.close();
        throw th;
    L24:
        if (d(r7) == false) goto L26;
        return r7;
    L26:
        r7 = r7 - 1;
        goto L2
    L6:
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L26;
        return r7;
    L12:
        return r7 + 1;
    L27:
        return 0;
    }

    public void f(int r7, Bitmap r8) {
        Canvas r0 = new Canvas(r8);
        r0.drawColor(0, PorterDuff.Mode.SRC);
        if (d(r7) == true) goto L5;
        int r1 = e(r7 - 1, r0);
    L6:
        if (r1 >= r7) goto L17;
        d.c.i.c.a.b r2 = this.f15895a.c(r1);
        d.c.i.c.a.b.EnumC0426b r3 = r2.f15848f;
        if (r3 == d.c.i.c.a.b.EnumC0426b.f15854h) goto L16;
        if (r2.f15847e != d.c.i.c.a.b.a.f15850g) goto L13;
        a(r0, r2);
    L13:
        this.f15895a.d(r1, r0);
        this.f15896b.a(r1, r8);
        if (r3 != d.c.i.c.a.b.EnumC0426b.f15853g) goto L16;
        a(r0, r2);
    L16:
        r1 = r1 + 1;
        goto L6
    L17:
        d.c.i.c.a.b r9 = this.f15895a.c(r7);
        if (r9.f15847e != d.c.i.c.a.b.a.f15850g) goto L20;
        a(r0, r9);
    L20:
        this.f15895a.d(r7, r0);
        return;
    L5:
        r1 = r7;
        goto L6
    }
}
