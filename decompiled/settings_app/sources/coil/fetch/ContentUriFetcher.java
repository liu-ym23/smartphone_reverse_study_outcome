package coil.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import coil.ImageLoader;
import coil.decode.ContentMetadata;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.request.Options;
import coil.size.Dimension;
import java.io.FileInputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;

/* JADX INFO: compiled from: ContentUriFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\fJ\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\b\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcoil/fetch/ContentUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContactPhotoUri", "", "isContactPhotoUri$coil_base_release", "isMusicThumbnailUri", "isMusicThumbnailUri$coil_base_release", "newMusicThumbnailSizeOptions", "Landroid/os/Bundle;", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentUriFetcher implements Fetcher {
    private final Uri data;
    private final Options options;

    /* JADX INFO: compiled from: ContentUriFetcher.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcoil/fetch/ContentUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        public Factory() {
        }

        @Override // coil.fetch.Fetcher.Factory
        public /* bridge */ /* synthetic */ Fetcher create(Uri r1, Options r2, ImageLoader r3) {
            return create2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: create, reason: avoid collision after fix types in other method */
        public Fetcher create2(Uri r1, Options r2, ImageLoader r3) {
            if (isApplicable(r1) == true) goto L7;
            return null;
        L7:
            return new ContentUriFetcher(r1, r2);
        }

        private final boolean isApplicable(Uri r1) {
            return Intrinsics.areEqual(r1.getScheme(), "content");
        }
    }

    public ContentUriFetcher(Uri r1, Options r2) {
        this.data = r1;
        this.options = r2;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> r6) {
        ContentResolver r7 = this.options.getContext().getContentResolver();
        FileInputStream r2 = null;
        if (isContactPhotoUri$coil_base_release(this.data) == false) goto L12;
        AssetFileDescriptor r0 = r7.openAssetFileDescriptor(this.data, "r");
        if (r0 == null) goto L7;
        r2 = r0.createInputStream();
    L7:
        if (r2 == null) goto L10;
        FileInputStream r3 = r2;
    L23:
        return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(r3)), this.options.getContext(), new ContentMetadata(this.data)), r7.getType(this.data), DataSource.DISK);
    L10:
        throw new IllegalStateException(("Unable to find a contact photo associated with '" + this.data + "'.").toString());
    L12:
        if (isMusicThumbnailUri$coil_base_release(this.data) == false) goto L20;
        AssetFileDescriptor r1 = r7.openTypedAssetFile(this.data, "image/*", newMusicThumbnailSizeOptions(), null);
        if (r1 == null) goto L16;
        r2 = r1.createInputStream();
    L16:
        if (r2 == null) goto L19;
        r3 = r2;
        goto L23
    L19:
        throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + this.data + "'.").toString());
    L20:
        r3 = r7.openInputStream(this.data);
        if (r3 != null) goto L23;
        throw new IllegalStateException(("Unable to open '" + this.data + "'.").toString());
    }

    public final boolean isContactPhotoUri$coil_base_release(Uri r2) {
        if (Intrinsics.areEqual(r2.getAuthority(), "com.android.contacts") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getLastPathSegment(), "display_photo") == false) goto L7;
        return true;
    }

    public final boolean isMusicThumbnailUri$coil_base_release(Uri r4) {
        if (Intrinsics.areEqual(r4.getAuthority(), "media") == true) goto L5;
        return false;
    L5:
        List<String> r3 = r4.getPathSegments();
        int r5 = r3.size();
        if (r5 >= 3) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r3.get(r5 - 3), "audio") == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r3.get(r5 - 2), "albums") == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension r0 = this.options.getSize().getWidth();
        if ((r0 instanceof Dimension.Pixels) == false) goto L5;
        Dimension.Pixels r1 = (Dimension.Pixels) r0;
    L6:
        if (r1 == null) goto L14;
        int r2 = r1.px;
        Dimension r3 = this.options.getSize().getHeight();
        if ((r3 instanceof Dimension.Pixels) == false) goto L10;
        Dimension.Pixels r4 = (Dimension.Pixels) r3;
    L11:
        if (r4 == null) goto L14;
        int r5 = r4.px;
        Bundle r6 = new Bundle(1);
        r6.putParcelable("android.content.extra.SIZE", new Point(r2, r5));
        return r6;
    L10:
        r4 = null;
    L14:
        return null;
    L5:
        r1 = null;
        goto L6
    }
}
