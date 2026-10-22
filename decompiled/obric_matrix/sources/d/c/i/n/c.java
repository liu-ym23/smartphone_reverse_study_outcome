package d.c.i.n;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import d.c.c.d.i;
import d.c.c.d.n;
import d.c.c.g.h;
import d.c.c.g.j;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f16197d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.c.l.b f16198c;

    public c() {
        this.f16198c = d.c.c.l.c.i();
    }

    private static MemoryFile i(d.c.c.h.a<h> r7, int r8, byte[] r9) {
        if (r9 != null) goto L5;
        int r1 = 0;
    L6:
        j r3 = null;
        OutputStream r4 = null;
        MemoryFile r2 = new MemoryFile(null, r1 + r8);
        r2.allowPurging(false);
        j r5 = new j(r7.N());     // Catch: Throwable -> L19
        d.c.c.j.a r6 = new d.c.c.j.a(r5, r8);     // Catch: Throwable -> L16
        r4 = r2.getOutputStream();     // Catch: Throwable -> L14
        d.c.c.d.a.a(r6, r4);     // Catch: Throwable -> L14
        if (r9 == null) goto L12;
        r2.writeBytes(r9, 0, r8, r9.length);     // Catch: Throwable -> L14
    L12:
        d.c.c.h.a.L(r7);
        d.c.c.d.b.b(r5);
        d.c.c.d.b.b(r6);
        d.c.c.d.b.a(r4, true);
        return r2;
    L14:
        th = th;
        OutputStream r10 = r4;
    L18:
        r3 = r5;
    L21:
        d.c.c.h.a.L(r7);
        d.c.c.d.b.b(r3);
        d.c.c.d.b.b(r6);
        d.c.c.d.b.a(r10, true);
        throw th;
    L16:
        th = th;
        r10 = null;
        r6 = null;
    L19:
        th = th;
        r10 = null;
        r6 = null;
        goto L21
    L5:
        r1 = r9.length;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Bitmap j(d.c.c.h.a<h> r2, int r3, byte[] r4, BitmapFactory.Options r5) {
        MemoryFile r0 = 0;
        MemoryFile r6 = i(r2, r3, r4);     // Catch: Throwable -> L16 IOException -> L18
        FileDescriptor r7 = l(r6);     // Catch: Throwable -> L12 IOException -> L14
        d.c.c.l.b r1 = this.f16198c;     // Catch: Throwable -> L12 IOException -> L14
        if (r1 == null) goto L11;
        Bitmap r8 = r1.d(r7, null, r5);     // Catch: Throwable -> L12 IOException -> L14
        i.h(r8, "BitmapFactory returned null");     // Catch: Throwable -> L12 IOException -> L14
        Bitmap r9 = r8;     // Catch: Throwable -> L12 IOException -> L14
        if (r6 == null) goto L9;
        r6.close();
    L9:
        return r9;
    L11:
        throw new IllegalStateException("WebpBitmapFactory is null");     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = e;
    L20:
        n.a(e);     // Catch: Throwable -> L12
        throw null;
    L12:
        th = th;
        r0 = r2;
    L22:
        if (r0 == 0) goto L24;
        r0.close();
    L24:
        throw th;
    L18:
        e = e;
    L16:
        th = th;
        goto L22
    }

    private synchronized Method k() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (f16197d == null) goto L17;
    L11:
        Method r0 = f16197d;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L17:
        f16197d = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);     // Catch: Exception -> L7 Throwable -> L14
    L7:
        e = move-exception;
        n.a(e);     // Catch: Throwable -> L14
        throw null;
    }

    private FileDescriptor l(MemoryFile r2) {
        return (FileDescriptor) k().invoke(r2, new Object[0]);
    L4:
        e = move-exception;
        n.a(e);
        throw null;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(d.c.c.h.a<h> r3, BitmapFactory.Options r4) {
        return j(r3, r3.N().size(), null, r4);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(d.c.c.h.a<h> r2, int r3, BitmapFactory.Options r4) {
        if (DalvikPurgeableDecoder.f(r2, r3) == false) goto L5;
        byte[] r0 = null;
    L7:
        return j(r2, r3, r0, r4);
    L5:
        r0 = DalvikPurgeableDecoder.f6751b;
        goto L7
    }
}
