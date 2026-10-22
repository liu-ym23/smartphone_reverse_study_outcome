package com.tencent.qqimagecompare;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageScreenshortDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30a;
    private int b;
    private BitmapFactory.Options c;

    public QQImageScreenshortDetector(Context r2) {
        Display r3 = ((WindowManager) r2.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics r0 = new DisplayMetrics();
        r3.getRealMetrics(r0);
        this.f30a = r0.widthPixels;
        this.b = r0.heightPixels;
        BitmapFactory.Options r4 = new BitmapFactory.Options();
        this.c = r4;
        r4.inJustDecodeBounds = true;
    }

    public boolean isScreenshort(String r4) {
        ExifInterface r0 = new ExifInterface(r4);     // Catch: Exception -> L4
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0) == 0) goto L11;
        return false;
    L11:
        if (r0.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH, 0) != 0) goto L22;
        BitmapFactory.decodeFile(r4, this.c);
        BitmapFactory.Options r5 = this.c;
        if (r5.outWidth == this.f30a) goto L15;
        return false;
    L15:
        if (r5.outHeight != this.b) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L7
    }
}
