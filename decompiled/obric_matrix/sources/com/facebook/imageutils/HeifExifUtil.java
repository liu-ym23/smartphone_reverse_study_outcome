package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class HeifExifUtil {

    @d.c.c.d.d
    private static class HeifExifUtilAndroidN {
        private HeifExifUtilAndroidN() {
        }

        @RequiresApi(api = 24)
        static int a(InputStream r2) {
            return new ExifInterface(r2).getAttributeInt("Orientation", 1);
        L4:
            e = move-exception;
            d.c.c.e.a.e("HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", e);
            return 0;
        }
    }

    public static int a(InputStream r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        d.c.c.e.a.c("HeifExifUtil", "Trying to read Heif Exif information before Android N -> ignoring");
        return 0;
    L5:
        return HeifExifUtilAndroidN.a(r2);
    }
}
