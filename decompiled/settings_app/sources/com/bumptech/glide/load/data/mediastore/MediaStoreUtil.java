package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 384;
    private static final int MINI_THUMB_WIDTH = 512;

    public static boolean isThumbnailSize(int r1, int r2) {
        if (r1 == Integer.MIN_VALUE) goto L10;
        if (r2 == Integer.MIN_VALUE) goto L10;
        if (r1 > 512) goto L10;
        if (r2 > MINI_THUMB_HEIGHT) goto L10;
        return true;
    L10:
        return false;
    }

    private MediaStoreUtil() {
    }

    public static boolean isMediaStoreUri(Uri r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if ("content".equals(r2.getScheme()) == false) goto L8;
        if ("media".equals(r2.getAuthority()) == false) goto L8;
        return true;
    }

    public static boolean isAndroidPickerUri(Uri r1) {
        if (isMediaStoreUri(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.getPathSegments().contains("picker") == false) goto L7;
        return true;
    }

    private static boolean isVideoUri(Uri r1) {
        return r1.getPathSegments().contains("video");
    }

    public static boolean isMediaStoreVideoUri(Uri r1) {
        if (isMediaStoreUri(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r1) == false) goto L7;
        return true;
    }

    public static boolean isMediaStoreImageUri(Uri r1) {
        if (isMediaStoreUri(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isVideoUri(r1) == true) goto L7;
        return true;
    }
}
