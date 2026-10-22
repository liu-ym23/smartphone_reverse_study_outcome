package com.obric.security.cleaner.bigfile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.oui.common.style.OUIDisplayHelper;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoadHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J0\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J \u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ(\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u0006¨\u0006\u0017"}, d2 = {"Lcom/obric/security/cleaner/bigfile/ImageLoadHelper;", "", "()V", "getAppIconFromApk", "Landroid/graphics/drawable/Drawable;", "apkPath", "", "loadImageFromBytes", "", "context", "Landroid/content/Context;", "imageData", "", "imageView", "Landroid/widget/ImageView;", "cornerRadiusDp", "", "loadImageFromPath", "path", "placeholder", "loadLocalResourceImage", "resourceId", "loadMusicThumbnail", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageLoadHelper {
    public static final ImageLoadHelper INSTANCE = null;

    static {
        INSTANCE = new ImageLoadHelper();
    }

    private ImageLoadHelper() {
    }

    public final void loadLocalResourceImage(Context r1, int r2, ImageView r3) {
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNull(r1);
        Glide.with(r1).load(Integer.valueOf(r2)).into(r3);
    }

    public final void loadLocalResourceImage(Context r4, int r5, ImageView r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "imageView");
        if (r4 != null) goto L5;
        return;
    L5:
        int r3 = OUIDisplayHelper.dp2px(r4, r7);
        RequestOptions r8 = new RequestOptions().transform(new Transformation[]{new CenterCrop(), new RoundedCorners(r3)});
        Intrinsics.checkNotNullExpressionValue(r8, "RequestOptions()\n       …dCorners(cornerRadiusPx))");
        Glide.with(r4).load(Integer.valueOf(r5)).apply(r8).override(OUIDisplayHelper.dp2px(r4, 48), OUIDisplayHelper.dp2px(r4, 48)).into(r6);
    }

    public final void loadImageFromPath(Context r4, String r5, int r6, ImageView r7, int r8) {
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r7, "imageView");
        File r3 = new File(r5);
        if (r3.exists() == true) goto L5;
        return;
    L5:
        if (r3.isFile() == false) goto L9;
        int r9 = OUIDisplayHelper.dp2px(r4, r8);
        RequestOptions r10 = new RequestOptions().transform(new Transformation[]{new CenterCrop(), new RoundedCorners(r9)});
        Intrinsics.checkNotNullExpressionValue(r10, "RequestOptions()\n       …dCorners(cornerRadiusPx))");
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullExpressionValue(Glide.with(r4).load(r3).apply(r10).placeholder(r6).override(OUIDisplayHelper.dp2px(r4, 48), OUIDisplayHelper.dp2px(r4, 48)).into(r7), "Glide.with(context!!)\n  …         .into(imageView)");
        return;
    }

    public final Drawable getAppIconFromApk(String r3) {
        Intrinsics.checkNotNullParameter(r3, "apkPath");
        SecurityCenterApplication r0 = SecurityCenterApplication.getApplication();     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r0, "SecurityCenterApplication.getApplication()");     // Catch: Exception -> L9
        PackageManager r1 = r0.getPackageManager();     // Catch: Exception -> L9
        PackageInfo r2 = r1.getPackageArchiveInfo(r3, 1);     // Catch: Exception -> L9
        if (r2 == null) goto L14;
        ApplicationInfo r4 = r2.applicationInfo;     // Catch: Exception -> L9
        if (r4 == null) goto L15;
        r4.sourceDir = r3;     // Catch: Exception -> L9
        r4.publicSourceDir = r3;     // Catch: Exception -> L9
        return r1.getApplicationIcon(r4);
    L15:
        return null;
    L14:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final byte[] loadMusicThumbnail(String r3) {
        Intrinsics.checkNotNullParameter(r3, "path");
        MediaMetadataRetriever r2 = new MediaMetadataRetriever();
        ParcelFileDescriptor.AutoCloseInputStream r0 = null;
        ParcelFileDescriptor.AutoCloseInputStream r1 = (ParcelFileDescriptor.AutoCloseInputStream) null;
        ParcelFileDescriptor r4 = ParcelFileDescriptor.open(new File(r3), 268435456);     // Catch: Throwable -> L10 Exception -> L15
        ParcelFileDescriptor.AutoCloseInputStream r5 = new ParcelFileDescriptor.AutoCloseInputStream(r4);     // Catch: Throwable -> L10 Exception -> L15
        r2.setDataSource(r4.getFileDescriptor());     // Catch: Throwable -> L8 Exception -> L24
        byte[] r6 = r2.getEmbeddedPicture();     // Catch: Throwable -> L8 Exception -> L24
        r5.close();     // Catch: IOException -> L20
    L29:
        r2.release();     // Catch: Exception -> L21
    L7:
        return r6;
    L8:
        th = th;
        r0 = r5;
    L11:
        if (r0 == null) goto L31;
        r0.close();     // Catch: IOException -> L22
    L31:
        r2.release();     // Catch: Exception -> L23
        throw th;
    L43:
        throw th;
    L16:
        if (r5 == null) goto L35;
        r5.close();     // Catch: IOException -> L25
    L35:
        r2.release();     // Catch: Exception -> L26
    L19:
        return null;
    L15:
        r5 = null;
    L10:
        th = th;
        goto L11
    }

    public final void loadImageFromBytes(Context r1, byte[] r2, ImageView r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Glide.with(r1).load(r2).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(false).into(r3);
    }

    public final void loadImageFromBytes(Context r4, byte[] r5, ImageView r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "imageView");
        if (r5 != null) goto L5;
        return;
    L5:
        int r3 = OUIDisplayHelper.dp2px(r4, r7);
        RequestOptions r8 = new RequestOptions().transform(new Transformation[]{new CenterCrop(), new RoundedCorners(r3)});
        Intrinsics.checkNotNullExpressionValue(r8, "RequestOptions()\n       …dCorners(cornerRadiusPx))");
        Glide.with(r4).load(r5).apply(r8).override(OUIDisplayHelper.dp2px(r4, 48), OUIDisplayHelper.dp2px(r4, 48)).into(r6);
    }
}
