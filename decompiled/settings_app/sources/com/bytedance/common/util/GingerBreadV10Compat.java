package com.bytedance.common.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;

/* JADX INFO: loaded from: classes3.dex */
public class GingerBreadV10Compat {
    static final BaseImpl IMPL = null;

    static class BaseImpl {
        BaseImpl() {
        }

        public Bitmap createVideoThumbnail(String r1, int r2, int r3) {
            return ThumbnailUtils.createVideoThumbnail(r1, r2);
        }

        public Bitmap createVideoThumbnail(String r1, int r2, int r3, int r4) {
            return ThumbnailUtils.createVideoThumbnail(r1, r2);
        }
    }

    static class V10Impl extends BaseImpl {
        V10Impl() {
        }

        @Override // com.bytedance.common.util.GingerBreadV10Compat.BaseImpl
        public Bitmap createVideoThumbnail(String r3, int r4, int r5) {
            MediaMetadataRetriever r2 = new MediaMetadataRetriever();
            r2.setDataSource(r3);     // Catch: Throwable -> L6 Throwable -> L9
            Bitmap r6 = r2.getFrameAtTime(-1);     // Catch: Throwable -> L6 Throwable -> L9
            r2.release();     // Catch: RuntimeException -> L14
        L11:
            if (r6 != null) goto L13;
            return null;
        L13:
            return r6;
        L9:
            r2.release();     // Catch: RuntimeException -> L16
        L6:
            th = move-exception;
            r2.release();     // Catch: RuntimeException -> L15
        L8:
            throw th;
        L10:
            r6 = null;
            goto L11
        }

        @Override // com.bytedance.common.util.GingerBreadV10Compat.BaseImpl
        public Bitmap createVideoThumbnail(String r3, int r4, int r5, int r6) {
            MediaMetadataRetriever r2 = new MediaMetadataRetriever();
            r2.setDataSource(r3);     // Catch: Throwable -> L6 Throwable -> L9
            Bitmap r7 = r2.getFrameAtTime(-1);     // Catch: Throwable -> L6 Throwable -> L9
            r2.release();     // Catch: RuntimeException -> L15
        L11:
            if (r7 != null) goto L14;
            return null;
        L14:
            return Bitmap.createScaledBitmap(r7, r5, r6, true);
        L9:
            r2.release();     // Catch: RuntimeException -> L17
        L6:
            th = move-exception;
            r2.release();     // Catch: RuntimeException -> L16
        L8:
            throw th;
        L10:
            r7 = null;
            goto L11
        }
    }

    public GingerBreadV10Compat() {
    }

    static {
        IMPL = new V10Impl();
    }

    public static Bitmap createVideoThumbnail(String r1, int r2, int r3) {
        return IMPL.createVideoThumbnail(r1, r2, r3);
    }

    public static Bitmap createVideoThumbnail(String r1, int r2, int r3, int r4) {
        return IMPL.createVideoThumbnail(r1, r2, r3, r4);
    }
}
