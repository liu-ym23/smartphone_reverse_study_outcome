package d.c.i.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
public class e extends b {
    public e(com.facebook.imagepipeline.memory.d r1, int r2, Pools.SynchronizedPool r3) {
        super(r1, r2, r3);
    }

    private static boolean h(BitmapFactory.Options r1) {
        ColorSpace r0 = r1.outColorSpace;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.isWideGamut() == false) goto L9;
        if (r1.inPreferredConfig == Bitmap.Config.RGBA_F16) goto L9;
        return true;
    }

    @Override // d.c.i.n.b
    public int f(int r1, int r2, BitmapFactory.Options r3) {
        if (h(r3) == false) goto L6;
        return (r1 * r2) * 8;
    L6:
        return com.facebook.imageutils.b.d(r1, r2, r3.inPreferredConfig);
    }
}
