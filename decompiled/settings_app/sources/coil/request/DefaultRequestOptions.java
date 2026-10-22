package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.icu.text.PluralRules;
import coil.size.Precision;
import coil.transition.Transition;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: DefaultRequestOptions.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0002\u0010\u0018J¢\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\u0017\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcoil/request/DefaultRequestOptions;", "", "interceptorDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "fetcherDispatcher", "decoderDispatcher", "transformationDispatcher", "transitionFactory", "Lcoil/transition/Transition$Factory;", "precision", "Lcoil/size/Precision;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "allowHardware", "", "allowRgb565", "placeholder", "Landroid/graphics/drawable/Drawable;", "error", "fallback", "memoryCachePolicy", "Lcoil/request/CachePolicy;", "diskCachePolicy", "networkCachePolicy", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcoil/transition/Transition$Factory;Lcoil/size/Precision;Landroid/graphics/Bitmap$Config;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;Lcoil/request/CachePolicy;)V", "getAllowHardware", "()Z", "getAllowRgb565", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getDecoderDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDiskCachePolicy", "()Lcoil/request/CachePolicy;", "getError", "()Landroid/graphics/drawable/Drawable;", "getFallback", "getFetcherDispatcher", "getInterceptorDispatcher", "getMemoryCachePolicy", "getNetworkCachePolicy", "getPlaceholder", "getPrecision", "()Lcoil/size/Precision;", "getTransformationDispatcher", "getTransitionFactory", "()Lcoil/transition/Transition$Factory;", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultRequestOptions {
    private final boolean allowHardware;
    private final boolean allowRgb565;
    private final Bitmap.Config bitmapConfig;
    private final CoroutineDispatcher decoderDispatcher;
    private final CachePolicy diskCachePolicy;
    private final Drawable error;
    private final Drawable fallback;
    private final CoroutineDispatcher fetcherDispatcher;
    private final CoroutineDispatcher interceptorDispatcher;
    private final CachePolicy memoryCachePolicy;
    private final CachePolicy networkCachePolicy;
    private final Drawable placeholder;
    private final Precision precision;
    private final CoroutineDispatcher transformationDispatcher;
    private final Transition.Factory transitionFactory;

    public DefaultRequestOptions() {
        this(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);
    }

    public DefaultRequestOptions(CoroutineDispatcher r1, CoroutineDispatcher r2, CoroutineDispatcher r3, CoroutineDispatcher r4, Transition.Factory r5, Precision r6, Bitmap.Config r7, boolean r8, boolean r9, Drawable r10, Drawable r11, Drawable r12, CachePolicy r13, CachePolicy r14, CachePolicy r15) {
        this.interceptorDispatcher = r1;
        this.fetcherDispatcher = r2;
        this.decoderDispatcher = r3;
        this.transformationDispatcher = r4;
        this.transitionFactory = r5;
        this.precision = r6;
        this.bitmapConfig = r7;
        this.allowHardware = r8;
        this.allowRgb565 = r9;
        this.placeholder = r10;
        this.error = r11;
        this.fallback = r12;
        this.memoryCachePolicy = r13;
        this.diskCachePolicy = r14;
        this.networkCachePolicy = r15;
    }

    public /* synthetic */ DefaultRequestOptions(CoroutineDispatcher r16, CoroutineDispatcher r17, CoroutineDispatcher r18, CoroutineDispatcher r19, Transition.Factory r20, Precision r21, Bitmap.Config r22, boolean r23, boolean r24, Drawable r25, Drawable r26, Drawable r27, CachePolicy r28, CachePolicy r29, CachePolicy r30, int r31, DefaultConstructorMarker r32) {
        if ((r31 & 1) == 0) goto L5;
        MainCoroutineDispatcher r1 = Dispatchers.getMain().getImmediate();
    L7:
        if ((r31 & 2) == 0) goto L9;
        CoroutineDispatcher r2 = Dispatchers.getIO();
    L11:
        if ((r31 & 4) == 0) goto L13;
        CoroutineDispatcher r3 = Dispatchers.getIO();
    L15:
        if ((r31 & 8) == 0) goto L17;
        CoroutineDispatcher r4 = Dispatchers.getIO();
    L19:
        if ((r31 & 16) == 0) goto L21;
        Transition.Factory r5 = Transition.Factory.NONE;
    L23:
        if ((r31 & 32) == 0) goto L25;
        Precision r6 = Precision.AUTOMATIC;
    L27:
        if ((r31 & 64) == 0) goto L29;
        Bitmap.Config r7 = Utils.getDEFAULT_BITMAP_CONFIG();
    L31:
        if ((r31 & 128) == 0) goto L33;
        boolean r8 = true;
    L35:
        if ((r31 & 256) == 0) goto L37;
        boolean r9 = false;
    L38:
        Drawable r11 = null;
        if ((r31 & 512) == 0) goto L41;
        Drawable r10 = null;
    L43:
        if ((r31 & 1024) == 0) goto L45;
        Drawable r12 = null;
    L47:
        if ((r31 & 2048) != 0) goto L51;
        r11 = r27;
    L51:
        if ((r31 & 4096) == 0) goto L53;
        CachePolicy r13 = CachePolicy.ENABLED;
    L55:
        if ((r31 & 8192) == 0) goto L57;
        CachePolicy r14 = CachePolicy.ENABLED;
    L59:
        if ((r31 & 16384) == 0) goto L61;
        CachePolicy r0 = CachePolicy.ENABLED;
    L62:
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r11, r13, r14, r0);
        return;
    L61:
        r0 = r30;
        goto L62
    L57:
        r14 = r29;
        goto L59
    L53:
        r13 = r28;
        goto L55
    L45:
        r12 = r26;
        goto L47
    L41:
        r10 = r25;
        goto L43
    L37:
        r9 = r24;
        goto L38
    L33:
        r8 = r23;
        goto L35
    L29:
        r7 = r22;
        goto L31
    L25:
        r6 = r21;
        goto L27
    L21:
        r5 = r20;
        goto L23
    L17:
        r4 = r19;
        goto L19
    L13:
        r3 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public final CoroutineDispatcher getInterceptorDispatcher() {
        return this.interceptorDispatcher;
    }

    public final CoroutineDispatcher getFetcherDispatcher() {
        return this.fetcherDispatcher;
    }

    public final CoroutineDispatcher getDecoderDispatcher() {
        return this.decoderDispatcher;
    }

    public final CoroutineDispatcher getTransformationDispatcher() {
        return this.transformationDispatcher;
    }

    public final Transition.Factory getTransitionFactory() {
        return this.transitionFactory;
    }

    public final Precision getPrecision() {
        return this.precision;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final boolean getAllowHardware() {
        return this.allowHardware;
    }

    public final boolean getAllowRgb565() {
        return this.allowRgb565;
    }

    public final Drawable getPlaceholder() {
        return this.placeholder;
    }

    public final Drawable getError() {
        return this.error;
    }

    public final Drawable getFallback() {
        return this.fallback;
    }

    public final CachePolicy getMemoryCachePolicy() {
        return this.memoryCachePolicy;
    }

    public final CachePolicy getDiskCachePolicy() {
        return this.diskCachePolicy;
    }

    public final CachePolicy getNetworkCachePolicy() {
        return this.networkCachePolicy;
    }

    public static /* synthetic */ DefaultRequestOptions copy$default(DefaultRequestOptions r16, CoroutineDispatcher r17, CoroutineDispatcher r18, CoroutineDispatcher r19, CoroutineDispatcher r20, Transition.Factory r21, Precision r22, Bitmap.Config r23, boolean r24, boolean r25, Drawable r26, Drawable r27, Drawable r28, CachePolicy r29, CachePolicy r30, CachePolicy r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        CoroutineDispatcher r2 = r16.interceptorDispatcher;
    L7:
        if ((r32 & 2) == 0) goto L9;
        CoroutineDispatcher r3 = r16.fetcherDispatcher;
    L11:
        if ((r32 & 4) == 0) goto L13;
        CoroutineDispatcher r4 = r16.decoderDispatcher;
    L15:
        if ((r32 & 8) == 0) goto L17;
        CoroutineDispatcher r5 = r16.transformationDispatcher;
    L19:
        if ((r32 & 16) == 0) goto L21;
        Transition.Factory r6 = r16.transitionFactory;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Precision r7 = r16.precision;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Bitmap.Config r8 = r16.bitmapConfig;
    L31:
        if ((r32 & 128) == 0) goto L33;
        boolean r9 = r16.allowHardware;
    L35:
        if ((r32 & 256) == 0) goto L37;
        boolean r10 = r16.allowRgb565;
    L39:
        if ((r32 & 512) == 0) goto L41;
        Drawable r11 = r16.placeholder;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        Drawable r12 = r16.error;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Drawable r13 = r16.fallback;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        CachePolicy r14 = r16.memoryCachePolicy;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        CachePolicy r15 = r16.diskCachePolicy;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        CachePolicy r1 = r16.networkCachePolicy;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final DefaultRequestOptions copy(CoroutineDispatcher r18, CoroutineDispatcher r19, CoroutineDispatcher r20, CoroutineDispatcher r21, Transition.Factory r22, Precision r23, Bitmap.Config r24, boolean r25, boolean r26, Drawable r27, Drawable r28, Drawable r29, CachePolicy r30, CachePolicy r31, CachePolicy r32) {
        return new DefaultRequestOptions(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DefaultRequestOptions) == false) goto L38;
        DefaultRequestOptions r5 = (DefaultRequestOptions) r4;
        if (Intrinsics.areEqual(this.interceptorDispatcher, r5.interceptorDispatcher) == false) goto L38;
        if (Intrinsics.areEqual(this.fetcherDispatcher, r5.fetcherDispatcher) == false) goto L38;
        if (Intrinsics.areEqual(this.decoderDispatcher, r5.decoderDispatcher) == false) goto L38;
        if (Intrinsics.areEqual(this.transformationDispatcher, r5.transformationDispatcher) == false) goto L38;
        if (Intrinsics.areEqual(this.transitionFactory, r5.transitionFactory) == false) goto L38;
        if (this.precision != r5.precision) goto L38;
        if (this.bitmapConfig != r5.bitmapConfig) goto L38;
        if (this.allowHardware != r5.allowHardware) goto L38;
        if (this.allowRgb565 != r5.allowRgb565) goto L38;
        if (Intrinsics.areEqual(this.placeholder, r5.placeholder) == false) goto L38;
        if (Intrinsics.areEqual(this.error, r5.error) == false) goto L38;
        if (Intrinsics.areEqual(this.fallback, r5.fallback) == false) goto L38;
        if (this.memoryCachePolicy != r5.memoryCachePolicy) goto L38;
        if (this.diskCachePolicy != r5.diskCachePolicy) goto L38;
        if (this.networkCachePolicy != r5.networkCachePolicy) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((this.interceptorDispatcher.hashCode() * 31) + this.fetcherDispatcher.hashCode()) * 31) + this.decoderDispatcher.hashCode()) * 31) + this.transformationDispatcher.hashCode()) * 31) + this.transitionFactory.hashCode()) * 31) + this.precision.hashCode()) * 31) + this.bitmapConfig.hashCode()) * 31) + Boolean.hashCode(this.allowHardware)) * 31) + Boolean.hashCode(this.allowRgb565)) * 31;
        Drawable r1 = this.placeholder;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Drawable r5 = this.error;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Drawable r8 = this.fallback;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return ((((((r7 + r2) * 31) + this.memoryCachePolicy.hashCode()) * 31) + this.diskCachePolicy.hashCode()) * 31) + this.networkCachePolicy.hashCode();
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
