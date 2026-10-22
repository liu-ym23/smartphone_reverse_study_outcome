package d.c.i.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    @RequiresApi(17)
    public static void a(Bitmap r2, Bitmap r3, Context r4, int r5) {
        i.g(r2);
        i.g(r3);
        i.g(r4);
        if (r5 > 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        i.b(r0);
        RenderScript r1 = null;
        r1 = RenderScript.create(r4);     // Catch: Throwable -> L13
        ScriptIntrinsicBlur r6 = ScriptIntrinsicBlur.create(r1, Element.U8_4(r1));     // Catch: Throwable -> L13
        Allocation r7 = Allocation.createFromBitmap(r1, r3);     // Catch: Throwable -> L13
        Allocation r8 = Allocation.createFromBitmap(r1, r2);     // Catch: Throwable -> L13
        r6.setRadius(r5);     // Catch: Throwable -> L13
        r6.setInput(r7);     // Catch: Throwable -> L13
        r6.forEach(r8);     // Catch: Throwable -> L13
        r8.copyTo(r2);     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        r1.destroy();
        return;
    L19:
        return;
    L13:
        th = move-exception;
        if (r1 == null) goto L16;
        r1.destroy();
    L16:
        throw th;
    L5:
        if (r5 > 25) goto L7;
        r0 = true;
        goto L8
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        return true;
    L5:
        return false;
    }
}
