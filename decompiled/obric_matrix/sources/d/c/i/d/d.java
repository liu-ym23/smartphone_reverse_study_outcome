package d.c.i.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.imagepipeline.memory.e0;
import com.facebook.imagepipeline.memory.p;
import d.c.c.g.h;

/* JADX INFO: loaded from: classes2.dex */
public class d implements d.c.c.l.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f15908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f15909b;

    public d(e0 r2) {
        this.f15909b = r2.c();
        this.f15908a = new b(r2.g());
    }

    private static BitmapFactory.Options b(int r2, Bitmap.Config r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inDither = true;
        r0.inPreferredConfig = r3;
        r0.inPurgeable = true;
        r0.inInputShareable = true;
        r0.inSampleSize = r2;
        if (Build.VERSION.SDK_INT < 11) goto L5;
        r0.inMutable = true;
    L5:
        return r0;
    }

    @Override // d.c.c.l.a
    @TargetApi(12)
    public Bitmap a(int r5, int r6, Bitmap.Config r7) {
        d.c.c.h.a<h> r8 = this.f15908a.a((short) r5, (short) r6);
        d.c.c.h.a<byte[]> r9 = null;
        d.c.i.l.e r0 = new d.c.i.l.e(r8);     // Catch: Throwable -> L9
        r0.D0(d.c.h.c.f15819a);     // Catch: Throwable -> L7
        BitmapFactory.Options r10 = b(r0.V(), r7);     // Catch: Throwable -> L7
        int r1 = r8.N().size();     // Catch: Throwable -> L7
        h r2 = r8.N();     // Catch: Throwable -> L7
        r9 = this.f15909b.a(r1 + 2);     // Catch: Throwable -> L7
        byte[] r4 = r9.N();     // Catch: Throwable -> L7
        r2.h(0, r4, 0, r1);     // Catch: Throwable -> L7
        Bitmap r11 = BitmapFactory.decodeByteArray(r4, 0, r1, r10);     // Catch: Throwable -> L7
        r11.setHasAlpha(true);     // Catch: Throwable -> L7
        r11.eraseColor(0);     // Catch: Throwable -> L7
        d.c.c.h.a.L(r9);
        d.c.i.l.e.g(r0);
        d.c.c.h.a.L(r8);
        return r11;
    L7:
        th = th;
    L11:
        d.c.c.h.a.L(r9);
        d.c.i.l.e.g(r0);
        d.c.c.h.a.L(r8);
        throw th;
    L9:
        th = th;
        r0 = null;
        goto L11
    }
}
