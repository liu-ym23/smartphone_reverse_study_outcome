package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class DngExifUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6761a = "DngExifUtil";

    @d.c.c.d.d
    private static class DngExifUtilAndroidN {
        private DngExifUtilAndroidN() {
        }

        @RequiresApi(api = 24)
        static int a(InputStream r2) {
            return new ExifInterface(r2).getAttributeInt("Orientation", 1);
        L4:
            e = move-exception;
            d.c.c.e.a.e(DngExifUtil.f6761a, "Failed reading Dng Exif orientation -> ignoring", e);
            return 0;
        }
    }

    static {
    }

    public static int a(InputStream r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        d.c.c.e.a.c(f6761a, "Trying to read Dng Exif information before Android N -> ignoring");
        return 0;
    L5:
        return DngExifUtilAndroidN.a(r2);
    }
}
