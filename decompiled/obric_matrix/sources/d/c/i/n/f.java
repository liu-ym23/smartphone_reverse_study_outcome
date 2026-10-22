package d.c.i.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.util.Pools;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(28)
public class f extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.c.l.b f16200e;

    public f(com.facebook.imagepipeline.memory.d r1, int r2, Pools.SynchronizedPool r3) {
        super(r1, r2, r3);
        this.f16200e = d.c.c.l.c.i();
    }

    @Override // d.c.i.n.b
    protected Bitmap d(InputStream r3, BitmapFactory.Options r4, int r5, int r6, Bitmap r7) {
        if (Build.VERSION.SDK_INT == 28) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L11;
        r7.reconfigure(r5, r6, r4.inPreferredConfig);
        Bitmap r2 = this.f16200e.b(r3, null, r4);
    L12:
        if (r2 == null) goto L14;
        return r2;
    L14:
        return BitmapFactory.decodeStream(r3, null, r4);
    L11:
        r2 = null;
        goto L12
    L5:
        if (this.f16200e == null) goto L7;
        r0 = true;
        goto L9
    }

    @Override // d.c.i.n.e, d.c.i.n.b
    public int f(int r1, int r2, BitmapFactory.Options r3) {
        return super.f(r1, r2, r3);
    }
}
