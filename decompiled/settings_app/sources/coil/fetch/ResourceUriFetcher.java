package coil.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSources;
import coil.decode.ResourceMetadata;
import coil.request.Options;
import coil.util.Contexts;
import coil.util.DrawableUtils;
import coil.util.Utils;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Okio;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: ResourceUriFetcher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/fetch/ResourceUriFetcher;", "Lcoil/fetch/Fetcher;", "data", "Landroid/net/Uri;", "options", "Lcoil/request/Options;", "(Landroid/net/Uri;Lcoil/request/Options;)V", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwInvalidUriException", "", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceUriFetcher implements Fetcher {
    public static final Companion Companion = null;
    private static final String MIME_TYPE_XML = "text/xml";
    private final Uri data;
    private final Options options;

    /* JADX INFO: compiled from: ResourceUriFetcher.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/fetch/ResourceUriFetcher$Companion;", "", "()V", "MIME_TYPE_XML", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: ResourceUriFetcher.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"Lcoil/fetch/ResourceUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "()V", "create", "Lcoil/fetch/Fetcher;", "data", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            return new ResourceUriFetcher(r1, r2);
        }

        private final boolean isApplicable(Uri r1) {
            return Intrinsics.areEqual(r1.getScheme(), "android.resource");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ResourceUriFetcher(Uri r1, Options r2) {
        this.data = r1;
        this.options = r2;
    }

    @Override // coil.fetch.Fetcher
    public Object fetch(Continuation<? super FetchResult> r12) {
        String r13 = this.data.getAuthority();
        if (r13 != null) goto L5;
    L31:
        throwInvalidUriException(this.data);
        throw new KotlinNothingValueException();
    L5:
        if ((!StringsKt.isBlank(r13)) == true) goto L8;
        r13 = null;
    L8:
        if (r13 == null) goto L31;
        String r0 = (String) CollectionsKt.lastOrNull(this.data.getPathSegments());
        if (r0 == null) goto L29;
        Integer r1 = StringsKt.toIntOrNull(r0);
        if (r1 == null) goto L29;
        int r2 = r1.intValue();
        Context r3 = this.options.getContext();
        if (Intrinsics.areEqual(r13, r3.getPackageName()) == false) goto L16;
        Resources r4 = r3.getResources();
    L17:
        TypedValue r5 = new TypedValue();
        r4.getValue(r2, r5, true);
        CharSequence r6 = r5.string;
        String r7 = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), r6.subSequence(StringsKt.lastIndexOf$default(r6, IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, null), r6.length()).toString());
        if (Intrinsics.areEqual(r7, MIME_TYPE_XML) == true) goto L20;
        TypedValue r11 = new TypedValue();
        return new SourceResult(ImageSources.create(Okio.buffer(Okio.source(r4.openRawResource(r2, r11))), r3, new ResourceMetadata(r13, r2, r11.density)), r7, DataSource.DISK);
    L20:
        if (Intrinsics.areEqual(r13, r3.getPackageName()) == false) goto L22;
        Drawable r14 = Contexts.getDrawableCompat(r3, r2);
    L23:
        BitmapDrawable r8 = r14;
        boolean r15 = Utils.isVector(r8);
        if (r15 == false) goto L33;
        r8 = new BitmapDrawable(r3.getResources(), DrawableUtils.INSTANCE.convertToBitmap(r8, this.options.getConfig(), this.options.getSize(), this.options.getScale(), this.options.getAllowInexactSize()));
    L33:
        return new DrawableResult(r8, r15, DataSource.DISK);
    L22:
        r14 = Contexts.getXmlDrawableCompat(r3, r4, r2);
        goto L23
    L16:
        r4 = r3.getPackageManager().getResourcesForApplication(r13);
    L29:
        throwInvalidUriException(this.data);
        throw new KotlinNothingValueException();
    }

    private final Void throwInvalidUriException(Uri r3) {
        throw new IllegalStateException("Invalid android.resource URI: " + r3);
    }
}
