package coil.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.Metadata;

/* JADX INFO: renamed from: coil.util.-Bitmaps, reason: invalid class name */
/* JADX INFO: compiled from: Bitmaps.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a\u000e\u0010\u0015\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\" \u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r\"\u0018\u0010\u000e\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"allocationByteCountCompat", "", "Landroid/graphics/Bitmap;", "getAllocationByteCountCompat", "(Landroid/graphics/Bitmap;)I", "bytesPerPixel", "Landroid/graphics/Bitmap$Config;", "getBytesPerPixel$annotations", "(Landroid/graphics/Bitmap$Config;)V", "getBytesPerPixel", "(Landroid/graphics/Bitmap$Config;)I", "isHardware", "", "(Landroid/graphics/Bitmap$Config;)Z", "safeConfig", "getSafeConfig", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap$Config;", "toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "context", "Landroid/content/Context;", "toSoftware", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Bitmaps {
    public static /* synthetic */ void getBytesPerPixel$annotations(Bitmap.Config r0) {
    }

    public static final int getBytesPerPixel(Bitmap.Config r2) {
        if (r2 != Bitmap.Config.ALPHA_8) goto L6;
        return 1;
    L6:
        if (r2 != Bitmap.Config.RGB_565) goto L9;
    L17:
        return 2;
    L9:
        if (r2 == Bitmap.Config.ARGB_4444) goto L17;
        if (r2 != Bitmap.Config.RGBA_F16) goto L14;
        return 8;
    L14:
        return 4;
    }

    public static final int getAllocationByteCountCompat(Bitmap r2) {
        if ((!r2.isRecycled()) == false) goto L9;
        return r2.getAllocationByteCount();
    L7:
        return getBytesPerPixel(r2.getConfig()) * (r2.getWidth() * r2.getHeight());
    L9:
        throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + r2 + " [" + r2.getWidth() + " x " + r2.getHeight() + "] + " + r2.getConfig()).toString());
    }

    public static final boolean isHardware(Bitmap.Config r1) {
        if (r1 != Bitmap.Config.HARDWARE) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Bitmap.Config getSafeConfig(Bitmap r0) {
        Bitmap.Config r1 = r0.getConfig();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return Bitmap.Config.ARGB_8888;
    }

    public static final BitmapDrawable toDrawable(Bitmap r1, Context r2) {
        return new BitmapDrawable(r2.getResources(), r1);
    }

    public static final Bitmap.Config toSoftware(Bitmap.Config r1) {
        if (r1 == null) goto L6;
        if (isHardware(r1) == true) goto L6;
        return r1;
    L6:
        return Bitmap.Config.ARGB_8888;
    }
}
