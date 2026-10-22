package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    public static final Option<Resources.Theme> THEME = null;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;
    private final Context context;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ Resource<Drawable> decode(Uri r1, int r2, int r3, Options r4) throws IOException {
        return decode2(r1, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public /* bridge */ /* synthetic */ boolean handles(Uri r1, Options r2) throws IOException {
        return handles2(r1, r2);
    }

    static {
        THEME = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    }

    public ResourceDrawableDecoder(Context r1) {
        this.context = r1.getApplicationContext();
    }

    /* JADX INFO: renamed from: handles, reason: avoid collision after fix types in other method */
    public boolean handles2(Uri r1, Options r2) {
        String r0 = r1.getScheme();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals("android.resource") == false) goto L7;
        return true;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public Resource<Drawable> decode2(Uri r2, int r3, int r4, Options r5) {
        String r6 = r2.getAuthority();
        if (TextUtils.isEmpty(r6) == true) goto L14;
        Context r7 = findContextForPackage(r2, r6);
        int r8 = findResourceIdFromUri(r7, r2);
        if (((String) Preconditions.checkNotNull(r6)).equals(this.context.getPackageName()) == false) goto L7;
        Resources.Theme r9 = (Resources.Theme) r5.get(THEME);
    L8:
        if (r9 != null) goto L10;
        Drawable r1 = DrawableDecoderCompat.getDrawable(this.context, r7, r8);
    L12:
        return NonOwnedDrawableResource.newInstance(r1);
    L10:
        r1 = DrawableDecoderCompat.getDrawable(this.context, r8, r9);
        goto L12
    L7:
        r9 = null;
        goto L8
    L14:
        throw new IllegalStateException("Package name for " + r2 + " is null or empty");
    }

    private Context findContextForPackage(Uri r3, String r4) {
        if (r4.equals(this.context.getPackageName()) == true) goto L5;
        return this.context.createPackageContext(r4, 0);
    L8:
        e = move-exception;
        if (r4.contains(this.context.getPackageName()) == false) goto L14;
        return this.context;
    L14:
        throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + r3, e);
    L5:
        return this.context;
    }

    private int findResourceIdFromUri(Context r4, Uri r5) {
        List<String> r0 = r5.getPathSegments();
        if (r0.size() != 2) goto L7;
        return findResourceIdFromTypeAndNameResourceUri(r4, r5);
    L7:
        if (r0.size() != 1) goto L11;
        return findResourceIdFromResourceIdUri(r5);
    L11:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r5);
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context r4, Uri r5) {
        List<String> r3 = r5.getPathSegments();
        String r0 = r5.getAuthority();
        String r1 = r3.get(0);
        String r6 = r3.get(1);
        int r7 = r4.getResources().getIdentifier(r6, r1, r0);
        if (r7 != 0) goto L5;
        r7 = Resources.getSystem().getIdentifier(r6, r1, ANDROID_PACKAGE_NAME);
    L5:
        if (r7 == 0) goto L8;
        return r7;
    L8:
        throw new IllegalArgumentException("Failed to find resource id for: " + r5);
    }

    private int findResourceIdFromResourceIdUri(Uri r4) {
        return Integer.parseInt(r4.getPathSegments().get(0));
    L5:
        e = move-exception;
        throw new IllegalArgumentException("Unrecognized Uri format: " + r4, e);
    }
}
