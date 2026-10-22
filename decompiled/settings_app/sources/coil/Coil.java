package coil;

import android.content.Context;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import com.obric.capabilitykit.common.Ext;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: Coil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcoil/Coil;", "", "()V", "imageLoader", "Lcoil/ImageLoader;", "imageLoaderFactory", "Lcoil/ImageLoaderFactory;", "enqueue", "Lcoil/request/Disposable;", Ext.KEY_REQUEST, "Lcoil/request/ImageRequest;", "execute", "Lcoil/request/ImageResult;", "(Lcoil/request/ImageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Landroid/content/Context;", "newImageLoader", "reset", "", "setImageLoader", "factory", "coil-singleton_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Coil {
    public static final Coil INSTANCE = null;
    private static ImageLoader imageLoader;
    private static ImageLoaderFactory imageLoaderFactory;

    static {
        INSTANCE = new Coil();
    }

    private Coil() {
    }

    @JvmStatic
    public static final ImageLoader imageLoader(Context r1) {
        ImageLoader r0 = imageLoader;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return INSTANCE.newImageLoader(r1);
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoader r2) {
        monitor-enter(Coil.class);
        imageLoaderFactory = null;     // Catch: Throwable -> L8
        imageLoader = r2;     // Catch: Throwable -> L8
        monitor-exit(Coil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void setImageLoader(ImageLoaderFactory r1) {
        monitor-enter(Coil.class);
        imageLoaderFactory = r1;     // Catch: Throwable -> L7
        imageLoader = null;     // Catch: Throwable -> L7
        monitor-exit(Coil.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final synchronized void reset() {
        monitor-enter(Coil.class);
        imageLoader = null;     // Catch: Throwable -> L8
        imageLoaderFactory = null;     // Catch: Throwable -> L8
        monitor-exit(Coil.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final synchronized ImageLoader newImageLoader(Context r4) {
        monitor-enter(this);
        ImageLoader r0 = imageLoader;     // Catch: Throwable -> L21
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        ImageLoaderFactory r1 = imageLoaderFactory;     // Catch: Throwable -> L21
        if (r1 == null) goto L11;
        ImageLoader r2 = r1.newImageLoader();     // Catch: Throwable -> L21
        if (r2 == null) goto L11;
    L18:
        imageLoaderFactory = null;     // Catch: Throwable -> L21
        imageLoader = r2;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L11:
        Object r3 = r4.getApplicationContext();     // Catch: Throwable -> L21
        if ((r3 instanceof ImageLoaderFactory) == false) goto L14;
        ImageLoaderFactory r5 = (ImageLoaderFactory) r3;     // Catch: Throwable -> L21
    L15:
        if (r5 == null) goto L17;
        r2 = r5.newImageLoader();     // Catch: Throwable -> L21
        goto L18
    L17:
        r2 = ImageLoaders.create(r4);     // Catch: Throwable -> L21
        goto L18
    L14:
        r5 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.enqueue(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.enqueue(request)", imports = {"coil.imageLoader"}))
    @JvmStatic
    public static final Disposable enqueue(ImageRequest r1) {
        throw new IllegalStateException("Unsupported".toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replace with 'context.imageLoader.execute(request)'.", replaceWith = @ReplaceWith(expression = "request.context.imageLoader.execute(request)", imports = {"coil.imageLoader"}))
    @JvmStatic
    public static final Object execute(ImageRequest r0, Continuation<? super ImageResult> r1) {
        throw new IllegalStateException("Unsupported".toString());
    }
}
