package com.obric.matrix.push.m.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class h implements e {
    public h() {
    }

    private static void c(int r2, int r3, int r4, int r5, BitmapFactory.Options r6) {
        if (r5 > r3) goto L6;
        if (r4 > r2) goto L6;
        int r7 = 1;
    L9:
        r6.inSampleSize = r7;
        r6.inJustDecodeBounds = false;
        return;
    L6:
        int r8 = (int) Math.floor(r5 / r3);
        r7 = (int) Math.floor(r4 / r2);
        if (r8 >= r7) goto L9;
        r7 = r8;
        goto L9
    }

    private static void d(int r2, int r3, BitmapFactory.Options r4) {
        c(r2, r3, r4.outWidth, r4.outHeight, r4);
    }

    private static BitmapFactory.Options e(g r3) {
        boolean r0 = r3.b();
        if (r3.f9695d == null) goto L5;
        boolean r1 = true;
    L6:
        BitmapFactory.Options r2 = null;
        if (r0 == true) goto L9;
        if (r1 == true) goto L9;
    L12:
        return r2;
    L9:
        r2 = new BitmapFactory.Options();
        r2.inJustDecodeBounds = r0;
        if (r1 == false) goto L12;
        r2.inPreferredConfig = r3.f9695d;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    private Bitmap f(InputStream r5, g r6) {
        f r4 = new f(r5);
        long r0 = r4.b(65536);
        BitmapFactory.Options r7 = e(r6);
        boolean r2 = h(r7);
        boolean r3 = i.a(r4);
        r4.a(r0);
        if (r3 == false) goto L10;
        byte[] r8 = i.b(r4);
        if (r2 == false) goto L8;
        BitmapFactory.decodeByteArray(r8, 0, r8.length, r7);
        d(r6.f9693b, r6.f9694c, r7);
    L8:
        return BitmapFactory.decodeByteArray(r8, 0, r8.length, r7);
    L10:
        if (r2 == false) goto L12;
        BitmapFactory.decodeStream(r4, null, r7);
        d(r6.f9693b, r6.f9694c, r7);
        r4.a(r0);
    L12:
        Bitmap r9 = BitmapFactory.decodeStream(r4, null, r7);
        if (r9 == null) goto L16;
        return r9;
    L16:
        throw new IOException("Failed to decode stream.");
    }

    private Bitmap g(g r8) {
        HttpURLConnection r0 = (HttpURLConnection) new URL(r8.f9692a.toString()).openConnection();
        r0.setConnectTimeout(15000);
        r0.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        r0.setUseCaches(true);
        int r1 = r0.getResponseCode();
        if (r1 >= 300) goto L19;
        InputStream r2 = r0.getInputStream();
        if (r2 != null) goto L8;
        return null;
    L8:
        if (r0.getHeaderFieldInt("Content-Length", -1) != 0) goto L21;
        com.bytedance.common.utility.n.b.a(r2);
        throw new IOException("Received response with 0 content-length header.");
    L21:
        Bitmap r7 = f(r2, r8);     // Catch: Throwable -> L12 Exception -> L15
        com.bytedance.common.utility.n.b.a(r2);
        return r7;
    L15:
        com.bytedance.common.utility.n.b.a(r2);
        return null;
    L12:
        th = move-exception;
        com.bytedance.common.utility.n.b.a(r2);
        throw th;
    L19:
        r0.disconnect();
        throw new IOException(r1 + " " + r0.getResponseMessage());
    }

    private static boolean h(BitmapFactory.Options r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.inJustDecodeBounds == false) goto L6;
        return true;
    }

    @Override // com.obric.matrix.push.m.g.e
    public Bitmap b(g r1) {
        return g(r1);
    L4:
        return null;
    }
}
