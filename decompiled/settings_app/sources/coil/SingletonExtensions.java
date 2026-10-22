package coil;

import android.content.Context;
import android.widget.ImageView;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.util.CoilUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: coil.-SingletonExtensions, reason: invalid class name */
/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0007H\u0086\b\u001a<\u0010\u0011\u001a\u00020\u0012*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0018H\u0086\b\u001a<\u0010\u0019\u001a\u00020\u0012*\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0000\u001a\u00020\u00012\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000f0\u0016¢\u0006\u0002\b\u0018H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001a"}, d2 = {"imageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "getImageLoader", "(Landroid/content/Context;)Lcoil/ImageLoader;", "metadata", "Lcoil/request/ImageResult;", "Landroid/widget/ImageView;", "getMetadata$annotations", "(Landroid/widget/ImageView;)V", "getMetadata", "(Landroid/widget/ImageView;)Lcoil/request/ImageResult;", "result", "getResult", "clear", "", "dispose", "load", "Lcoil/request/Disposable;", "data", "", "builder", "Lkotlin/Function1;", "Lcoil/request/ImageRequest$Builder;", "Lkotlin/ExtensionFunctionType;", "loadAny", "coil-singleton_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SingletonExtensions {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'result'.", replaceWith = @ReplaceWith(expression = "result", imports = {"coil.result"}))
    public static /* synthetic */ void getMetadata$annotations(ImageView r0) {
    }

    public static final ImageLoader getImageLoader(Context r0) {
        return Coil.imageLoader(r0);
    }

    public static /* synthetic */ Disposable load$default(ImageView r0, Object r1, ImageLoader r2, AnonymousClass1 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Coil.imageLoader(r0.getContext());
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = AnonymousClass1.INSTANCE;
    L8:
        ImageRequest.Builder r6 = new ImageRequest.Builder(r0.getContext()).data(r1).target(r0);
        r3.invoke(r6);
        return r2.enqueue(r6.build());
    }

    public static final Disposable load(ImageView r2, Object r3, ImageLoader r4, Function1<? super ImageRequest.Builder, Unit> r5) {
        ImageRequest.Builder r6 = new ImageRequest.Builder(r2.getContext()).data(r3).target(r2);
        r5.invoke(r6);
        return r4.enqueue(r6.build());
    }

    public static final void dispose(ImageView r0) {
        CoilUtils.dispose(r0);
    }

    public static final ImageResult getResult(ImageView r0) {
        return CoilUtils.result(r0);
    }

    public static /* synthetic */ Disposable loadAny$default(ImageView r0, Object r1, ImageLoader r2, C01361 r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = Coil.imageLoader(r0.getContext());
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = C01361.INSTANCE;
    L8:
        ImageRequest.Builder r6 = new ImageRequest.Builder(r0.getContext()).data(r1).target(r0);
        r3.invoke(r6);
        return r2.enqueue(r6.build());
    }

    public static final ImageResult getMetadata(ImageView r0) {
        return CoilUtils.result(r0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'load'.", replaceWith = @ReplaceWith(expression = "load(data, imageLoader, builder)", imports = {"coil.imageLoader", "coil.load"}))
    public static final Disposable loadAny(ImageView r2, Object r3, ImageLoader r4, Function1<? super ImageRequest.Builder, Unit> r5) {
        ImageRequest.Builder r6 = new ImageRequest.Builder(r2.getContext()).data(r3).target(r2);
        r5.invoke(r6);
        return r4.enqueue(r6.build());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Migrate to 'dispose'.", replaceWith = @ReplaceWith(expression = "dispose()", imports = {"coil.dispose"}))
    public static final void clear(ImageView r0) {
        CoilUtils.dispose(r0);
    }
}
