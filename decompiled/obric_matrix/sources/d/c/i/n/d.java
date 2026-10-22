package d.c.i.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.imagepipeline.memory.p;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import d.c.c.d.i;
import d.c.c.g.h;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(19)
public class d extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f16199c;

    public d(p r1) {
        this.f16199c = r1;
    }

    private static void i(byte[] r1, int r2) {
        r1[r2] = -1;
        r1[r2 + 1] = -39;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(d.c.c.h.a<h> r4, BitmapFactory.Options r5) {
        h r6 = r4.N();
        int r0 = r6.size();
        d.c.c.h.a<byte[]> r3 = this.f16199c.a(r0);
        byte[] r1 = r3.N();     // Catch: Throwable -> L6
        r6.h(0, r1, 0, r0);     // Catch: Throwable -> L6
        Bitmap r7 = BitmapFactory.decodeByteArray(r1, 0, r0, r5);     // Catch: Throwable -> L6
        i.h(r7, "BitmapFactory returned null");     // Catch: Throwable -> L6
        Bitmap r8 = r7;     // Catch: Throwable -> L6
        d.c.c.h.a.L(r3);
        return r8;
    L6:
        th = move-exception;
        d.c.c.h.a.L(r3);
        throw th;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(d.c.c.h.a<h> r5, int r6, BitmapFactory.Options r7) {
        if (DalvikPurgeableDecoder.f(r5, r6) == false) goto L5;
        byte[] r0 = null;
    L6:
        h r8 = r5.N();
        if (r6 > r8.size()) goto L9;
        boolean r1 = true;
    L10:
        i.b(r1);
        int r2 = r6 + 2;
        d.c.c.h.a<byte[]> r4 = this.f16199c.a(r2);
        byte[] r3 = r4.N();     // Catch: Throwable -> L17
        r8.h(0, r3, 0, r6);     // Catch: Throwable -> L17
        if (r0 == null) goto L14;
        i(r3, r6);     // Catch: Throwable -> L17
        r6 = r2;
    L14:
        Bitmap r9 = BitmapFactory.decodeByteArray(r3, 0, r6, r7);     // Catch: Throwable -> L17
        i.h(r9, "BitmapFactory returned null");     // Catch: Throwable -> L17
        Bitmap r10 = r9;     // Catch: Throwable -> L17
        d.c.c.h.a.L(r4);
        return r10;
    L17:
        th = move-exception;
        d.c.c.h.a.L(r4);
        throw th;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = DalvikPurgeableDecoder.f6751b;
        goto L6
    }
}
