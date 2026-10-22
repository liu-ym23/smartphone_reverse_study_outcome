package d.c.i.n;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class a extends b {
    public a(com.facebook.imagepipeline.memory.d r1, int r2, Pools.SynchronizedPool r3) {
        super(r1, r2, r3);
    }

    @Override // d.c.i.n.b
    public int f(int r1, int r2, BitmapFactory.Options r3) {
        return com.facebook.imageutils.b.d(r1, r2, r3.inPreferredConfig);
    }
}
