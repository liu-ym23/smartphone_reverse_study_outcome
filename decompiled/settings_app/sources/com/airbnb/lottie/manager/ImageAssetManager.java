package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
public class ImageAssetManager {
    private static final Object bitmapHashLock = null;
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    static {
        bitmapHashLock = new Object();
    }

    public ImageAssetManager(Drawable.Callback r3, String r4, ImageAssetDelegate r5, Map<String, LottieImageAsset> r6) {
        this.imagesFolder = r4;
        if (TextUtils.isEmpty(r4) == true) goto L8;
        String r7 = this.imagesFolder;
        if (r7.charAt(r7.length() - 1) == '/') goto L8;
        this.imagesFolder += IOUtils.DIR_SEPARATOR_UNIX;
    L8:
        if ((r3 instanceof View) == true) goto L11;
        Logger.warning("LottieDrawable must be inside of a view for images to work.");
        this.imageAssets = new HashMap();
        this.context = null;
        return;
    L11:
        this.context = ((View) r3).getContext();
        this.imageAssets = r6;
        setDelegate(r5);
    }

    public void setDelegate(ImageAssetDelegate r1) {
        this.delegate = r1;
    }

    public Bitmap updateBitmap(String r2, Bitmap r3) {
        if (r3 != null) goto L5;
        LottieImageAsset r1 = this.imageAssets.get(r2);
        Bitmap r4 = r1.getBitmap();
        r1.setBitmap(null);
        return r4;
    L5:
        Bitmap r0 = this.imageAssets.get(r2).getBitmap();
        putBitmap(r2, r3);
        return r0;
    }

    public Bitmap bitmapForId(String r8) {
        LottieImageAsset r0 = this.imageAssets.get(r8);
        if (r0 != null) goto L5;
        return null;
    L5:
        Bitmap r2 = r0.getBitmap();
        if (r2 == null) goto L8;
        return r2;
    L8:
        ImageAssetDelegate r3 = this.delegate;
        if (r3 == null) goto L14;
        Bitmap r1 = r3.fetchBitmap(r0);
        if (r1 == null) goto L13;
        putBitmap(r8, r1);
    L13:
        return r1;
    L14:
        String r4 = r0.getFileName();
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inScaled = true;
        r5.inDensity = 160;
        if (r4.startsWith("data:") == true) goto L17;
    L35:
    L32:
        e = move-exception;
        Logger.warning("Unable to open asset.", e);
        return null;
    L26:
        if (TextUtils.isEmpty(this.imagesFolder) == true) goto L31;
        return putBitmap(r8, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(this.context.getAssets().open(this.imagesFolder + r4), null, r5), r0.getWidth(), r0.getHeight()));
    L31:
        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");     // Catch: IOException -> L32
    L17:
        if (r4.indexOf("base64,") <= 0) goto L35;
        byte[] r6 = Base64.decode(r4.substring(r4.indexOf(44) + 1), 0);     // Catch: IllegalArgumentException -> L22
        return putBitmap(r8, BitmapFactory.decodeByteArray(r6, 0, r6.length, r5));
    L22:
        e = move-exception;
        Logger.warning("data URL did not have correct base64 format.", e);
        return null;
    }

    public boolean hasSameContext(Context r2) {
        if (r2 != null) goto L6;
        if (this.context != null) goto L6;
    L7:
        return true;
    L6:
        if (this.context.equals(r2) == true) goto L7;
        return false;
    }

    private Bitmap putBitmap(String r2, Bitmap r3) {
        Object r0 = bitmapHashLock;
        monitor-enter(r0);
        this.imageAssets.get(r2).setBitmap(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
