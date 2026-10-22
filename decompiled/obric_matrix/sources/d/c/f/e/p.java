package d.c.f.e;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class p {

    public static abstract class a implements b {
        public a() {
        }

        @Override // d.c.f.e.p.b
        public Matrix a(Matrix r11, Rect r12, int r13, int r14, float r15, float r16) {
            b(r11, r12, r13, r14, r15, r16, r12.width() / r13, r12.height() / r14);
            return r11;
        }

        public abstract void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8);
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f15662a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f15663b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f15664c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f15665d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f15666e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f15667f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f15668g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f15669h = null;

        static {
            f15662a = j.f15677i;
            f15663b = i.f15676i;
            f15664c = g.f15674i;
            f15665d = h.f15675i;
            f15666e = c.f15670i;
            f15667f = e.f15672i;
            f15668g = d.f15671i;
            f15669h = k.f15678i;
            b r0 = f.f15673i;
        }

        Matrix a(Matrix r1, Rect r2, int r3, int r4, float r5, float r6);
    }

    private static class c extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15670i = null;

        static {
            f15670i = new c();
        }

        private c() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            r1.setTranslate((int) ((r2.left + ((r2.width() - r3) * 0.5f)) + 0.5f), (int) ((r2.top + ((r2.height() - r4) * 0.5f)) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    private static class d extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15671i = null;

        static {
            f15671i = new d();
        }

        private d() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            if (r8 <= r7) goto L5;
            float r0 = r2.left + ((r2.width() - (r3 * r8)) * 0.5f);
            float r9 = r2.top;
            r7 = r8;
        L6:
            r1.setScale(r7, r7);
            r1.postTranslate((int) (r0 + 0.5f), (int) (r9 + 0.5f));
            return;
        L5:
            r0 = r2.left;
            r9 = ((r2.height() - (r4 * r7)) * 0.5f) + r2.top;
            goto L6
        }

        public String toString() {
            return "center_crop";
        }
    }

    private static class e extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15672i = null;

        static {
            f15672i = new e();
        }

        private e() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = Math.min(Math.min(r7, r8), 1.0f);
            float r9 = r2.left + ((r2.width() - (r3 * r0)) * 0.5f);
            float r10 = r2.top + ((r2.height() - (r4 * r0)) * 0.5f);
            r1.setScale(r0, r0);
            r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        }

        public String toString() {
            return "center_inside";
        }
    }

    private static class f extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15673i = null;

        static {
            f15673i = new f();
        }

        private f() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = Math.min(r7, r8);
            float r9 = r2.left;
            float r10 = r2.top + (r2.height() - (r4 * r0));
            r1.setScale(r0, r0);
            r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    private static class g extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15674i = null;

        static {
            f15674i = new g();
        }

        private g() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = Math.min(r7, r8);
            float r9 = r2.left + ((r2.width() - (r3 * r0)) * 0.5f);
            float r10 = r2.top + ((r2.height() - (r4 * r0)) * 0.5f);
            r1.setScale(r0, r0);
            r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        }

        public String toString() {
            return "fit_center";
        }
    }

    private static class h extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15675i = null;

        static {
            f15675i = new h();
        }

        private h() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = Math.min(r7, r8);
            float r9 = r2.left + (r2.width() - (r3 * r0));
            float r10 = r2.top + (r2.height() - (r4 * r0));
            r1.setScale(r0, r0);
            r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        }

        public String toString() {
            return "fit_end";
        }
    }

    private static class i extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15676i = null;

        static {
            f15676i = new i();
        }

        private i() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = Math.min(r7, r8);
            float r9 = r2.left;
            float r10 = r2.top;
            r1.setScale(r0, r0);
            r1.postTranslate((int) (r9 + 0.5f), (int) (r10 + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    private static class j extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15677i = null;

        static {
            f15677i = new j();
        }

        private j() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r1, Rect r2, int r3, int r4, float r5, float r6, float r7, float r8) {
            float r0 = r2.left;
            float r9 = r2.top;
            r1.setScale(r7, r8);
            r1.postTranslate((int) (r0 + 0.5f), (int) (r9 + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    private static class k extends a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b f15678i = null;

        static {
            f15678i = new k();
        }

        private k() {
        }

        @Override // d.c.f.e.p.a
        public void b(Matrix r3, Rect r4, int r5, int r6, float r7, float r8, float r9, float r10) {
            if (r10 <= r9) goto L5;
            float r11 = r5 * r10;
            float r12 = r4.left + Math.max(Math.min((r4.width() * 0.5f) - (r7 * r11), 0.0f), r4.width() - r11);
            float r2 = r4.top;
            r9 = r10;
        L6:
            r3.setScale(r9, r9);
            r3.postTranslate((int) (r12 + 0.5f), (int) (r2 + 0.5f));
            return;
        L5:
            float r13 = r4.left;
            float r14 = r6 * r9;
            float r15 = (r4.height() * 0.5f) - (r8 * r14);
            float r16 = Math.max(Math.min(r15, 0.0f), r4.height() - r14) + r4.top;
            r12 = r13;
            r2 = r16;
            goto L6
        }

        public String toString() {
            return "focus_crop";
        }
    }

    public interface l {
        Object getState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static o a(Drawable r4) {
        if (r4 != 0) goto L6;
        return null;
    L6:
        if ((r4 instanceof o) == false) goto L10;
        return (o) r4;
    L10:
        if ((r4 instanceof d.c.f.e.b) == false) goto L14;
        return a(((d.c.f.e.b) r4).k());
    L14:
        if ((r4 instanceof d.c.f.e.a) == false) goto L21;
        d.c.f.e.a r5 = (d.c.f.e.a) r4;
        int r1 = r5.f();
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L21;
        o r3 = a(r5.c(r2));
        if (r3 != null) goto L19;
        r2 = r2 + 1;
        goto L16
    L19:
        return r3;
    L21:
        return null;
    }
}
