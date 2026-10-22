package tmsdkobf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import tmsdk.fg.module.spacemanager.SpaceScanResult;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p0 {
    public static Bitmap a(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L16;
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        int r2 = 1;
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r6, r0);
        int r3 = Math.max(r0.outWidth, r0.outHeight);
        if (r3 <= 480) goto L8;
        r2 = (int) Math.floor(((double) r3) / 480.0d);
    L8:
        r0.inSampleSize = r2;
        r0.inJustDecodeBounds = false;
        BufferedInputStream r4 = new BufferedInputStream(Files.newInputStream(Paths.get(r6, new String[0]), new OpenOption[0]));     // Catch: Throwable -> L13
        Bitmap r7 = BitmapFactory.decodeStream(r4, null, r0);     // Catch: Throwable -> L18
        r4.close();     // Catch: Throwable -> L17
    L12:
        return r7;
    L14:
        if (r4 == null) goto L16;
        r4.close();     // Catch: Throwable -> L19
    L13:
        r4 = null;
    L16:
        return null;
    }

    public static Bitmap a(SpaceScanResult r6) {
        if (r6 != null) goto L5;
    L18:
        return null;
    L5:
        if (TextUtils.isEmpty(r6.mPath) == true) goto L18;
        BitmapFactory.Options r1 = new BitmapFactory.Options();
        int r2 = 1;
        r1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r6.mPath, r1);
        int r3 = r1.outWidth;
        r6.mWidth = r3;
        int r4 = r1.outHeight;
        r6.mHeight = r4;
        int r5 = Math.max(r3, r4);
        if (r5 <= 480) goto L10;
        r2 = (int) Math.floor(((double) r5) / 480.0d);
    L10:
        r1.inSampleSize = r2;
        r1.inJustDecodeBounds = false;
        BufferedInputStream r7 = new BufferedInputStream(Files.newInputStream(Paths.get(r6.mPath, new String[0]), new OpenOption[0]));     // Catch: Throwable -> L15
        Bitmap r8 = BitmapFactory.decodeStream(r7, null, r1);     // Catch: Throwable -> L20
        r7.close();     // Catch: Throwable -> L19
    L14:
        return r8;
    L16:
        if (r7 == null) goto L18;
        r7.close();     // Catch: Throwable -> L21
    L15:
        r7 = null;
        goto L16
    }

    public static void a(long r1) {
        System.gc();     // Catch: Exception -> L4
        Thread.sleep(r1);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("BlurImageUtils", "scan sleep exception=" + e.toString());
    }
}
