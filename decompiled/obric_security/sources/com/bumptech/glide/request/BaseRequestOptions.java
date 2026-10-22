package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isCacheable;
    private boolean isLocked;
    private boolean isScaleOnlyOrNoTransform;
    private boolean isTransformationAllowed;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private Class<?> resourceClass;
    private Key signature;
    private float sizeMultiplier;
    private Resources.Theme theme;
    private Map<Class<?>, Transformation<?>> transformations;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;

    private static boolean isSet(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private T self() {
        return this;
    }

    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo67clone() throws CloneNotSupportedException {
        return clone();
    }

    public BaseRequestOptions() {
        this.sizeMultiplier = 1.0f;
        this.diskCacheStrategy = DiskCacheStrategy.AUTOMATIC;
        this.priority = Priority.NORMAL;
        this.isCacheable = true;
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.signature = EmptySignature.obtain();
        this.isTransformationAllowed = true;
        this.options = new Options();
        this.transformations = new CachedHashCodeArrayMap();
        this.resourceClass = Object.class;
        this.isScaleOnlyOrNoTransform = true;
    }

    public T sizeMultiplier(float r2) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().sizeMultiplier(r2);
    L7:
        if (r2 < 0.0f) goto L13;
        if (r2 > 1.0f) goto L13;
        this.sizeMultiplier = r2;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T useUnlimitedSourceGeneratorsPool(boolean r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useUnlimitedSourceGeneratorsPool = r2;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useUnlimitedSourceGeneratorsPool(r2);
    }

    public T useAnimationPool(boolean r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.useAnimationPool = r2;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().useAnimationPool(r2);
    }

    public T onlyRetrieveFromCache(boolean r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.onlyRetrieveFromCache = r2;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().onlyRetrieveFromCache(r2);
    }

    public T diskCacheStrategy(DiskCacheStrategy r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.diskCacheStrategy = (DiskCacheStrategy) Preconditions.checkNotNull(r2);
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().diskCacheStrategy(r2);
    }

    public T priority(Priority r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.priority = (Priority) Preconditions.checkNotNull(r2);
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().priority(r2);
    }

    public T placeholder(Drawable r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderDrawable = r2;
        int r3 = this.fields | 64;
        this.placeholderId = 0;
        this.fields = r3 & (-129);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r2);
    }

    public T placeholder(int r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.placeholderId = r2;
        int r3 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = r3 & (-65);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().placeholder(r2);
    }

    public T fallback(Drawable r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackDrawable = r2;
        int r3 = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = r3 & (-16385);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r2);
    }

    public T fallback(int r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.fallbackId = r2;
        int r3 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = r3 & (-8193);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().fallback(r2);
    }

    public T error(Drawable r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorPlaceholder = r2;
        int r3 = this.fields | 16;
        this.errorId = 0;
        this.fields = r3 & (-33);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r2);
    }

    public T error(int r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.errorId = r2;
        int r3 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = r3 & (-17);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().error(r2);
    }

    public T theme(Resources.Theme r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.theme = r3;
        if (r3 == null) goto L10;
        this.fields |= 32768;
        return (T) set(ResourceDrawableDecoder.THEME, r3);
    L10:
        this.fields &= -32769;
        return (T) removeOption(ResourceDrawableDecoder.THEME);
    L5:
        return (T) clone().theme(r3);
    }

    public T skipMemoryCache(boolean r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.isCacheable = !r3;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().skipMemoryCache(true);
    }

    public T override(int r2, int r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.overrideWidth = r2;
        this.overrideHeight = r3;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().override(r2, r3);
    }

    public T override(int r1) {
        return (T) override(r1, r1);
    }

    public T signature(Key r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.signature = (Key) Preconditions.checkNotNull(r2);
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().signature(r2);
    }

    public T clone() {
        T r0 = (T) super.clone();     // Catch: CloneNotSupportedException -> L4
        Options r1 = new Options();     // Catch: CloneNotSupportedException -> L4
        r0.options = r1;     // Catch: CloneNotSupportedException -> L4
        r1.putAll(this.options);     // Catch: CloneNotSupportedException -> L4
        CachedHashCodeArrayMap r2 = new CachedHashCodeArrayMap();     // Catch: CloneNotSupportedException -> L4
        r0.transformations = r2;     // Catch: CloneNotSupportedException -> L4
        r2.putAll(this.transformations);     // Catch: CloneNotSupportedException -> L4
        r0.isLocked = false;     // Catch: CloneNotSupportedException -> L4
        r0.isAutoCloneEnabled = false;     // Catch: CloneNotSupportedException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public <Y> T set(Option<Y> r2, Y r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        this.options.set(r2, r3);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().set(r2, r3);
    }

    T removeOption(Option<?> r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.options.remove(r2);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().removeOption(r2);
    }

    public T decode(Class<?> r2) {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.resourceClass = (Class) Preconditions.checkNotNull(r2);
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().decode(r2);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public T encodeFormat(Bitmap.CompressFormat r2) {
        return (T) set(BitmapEncoder.COMPRESSION_FORMAT, Preconditions.checkNotNull(r2));
    }

    public T encodeQuality(int r2) {
        return (T) set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(r2));
    }

    public T frame(long r2) {
        return (T) set(VideoDecoder.TARGET_FRAME, Long.valueOf(r2));
    }

    public T format(DecodeFormat r2) {
        Preconditions.checkNotNull(r2);
        return (T) set(Downsampler.DECODE_FORMAT, r2).set(GifOptions.DECODE_FORMAT, r2);
    }

    public T disallowHardwareConfig() {
        return (T) set(Downsampler.ALLOW_HARDWARE_CONFIG, false);
    }

    public T downsample(DownsampleStrategy r2) {
        return (T) set(DownsampleStrategy.OPTION, Preconditions.checkNotNull(r2));
    }

    public T timeout(int r2) {
        return (T) set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(r2));
    }

    public T optionalCenterCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T centerCrop() {
        return (T) transform(DownsampleStrategy.CENTER_OUTSIDE, new CenterCrop());
    }

    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public T fitCenter() {
        return (T) scaleOnlyTransform(DownsampleStrategy.FIT_CENTER, new FitCenter());
    }

    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T centerInside() {
        return (T) scaleOnlyTransform(DownsampleStrategy.CENTER_INSIDE, new CenterInside());
    }

    public T optionalCircleCrop() {
        return (T) optionalTransform(DownsampleStrategy.CENTER_OUTSIDE, new CircleCrop());
    }

    public T circleCrop() {
        return (T) transform(DownsampleStrategy.CENTER_INSIDE, new CircleCrop());
    }

    final T optionalTransform(DownsampleStrategy r2, Transformation<Bitmap> r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r2);
        return (T) transform(r3, false);
    L5:
        return (T) clone().optionalTransform(r2, r3);
    }

    final T transform(DownsampleStrategy r2, Transformation<Bitmap> r3) {
        if (this.isAutoCloneEnabled == true) goto L5;
        downsample(r2);
        return (T) transform(r3);
    L5:
        return (T) clone().transform(r2, r3);
    }

    private T scaleOnlyTransform(DownsampleStrategy r2, Transformation<Bitmap> r3) {
        return (T) scaleOnlyTransform(r2, r3, true);
    }

    private T optionalScaleOnlyTransform(DownsampleStrategy r2, Transformation<Bitmap> r3) {
        return (T) scaleOnlyTransform(r2, r3, false);
    }

    private T scaleOnlyTransform(DownsampleStrategy r1, Transformation<Bitmap> r2, boolean r3) {
        if (r3 == false) goto L4;
        T r0 = (T) transform(r1, r2);
    L5:
        r0.isScaleOnlyOrNoTransform = true;
        return r0;
    L4:
        r0 = (T) optionalTransform(r1, r2);
        goto L5
    }

    public T transform(Transformation<Bitmap> r2) {
        return (T) transform(r2, true);
    }

    public T transform(Transformation<Bitmap>... r3) {
        if (r3.length <= 1) goto L7;
        return (T) transform(new MultiTransformation(r3), true);
    L7:
        if (r3.length != 1) goto L11;
        return (T) transform(r3[0]);
    L11:
        return (T) selfOrThrowIfLocked();
    }

    @Deprecated
    public T transforms(Transformation<Bitmap>... r2) {
        return (T) transform(new MultiTransformation(r2), true);
    }

    public T optionalTransform(Transformation<Bitmap> r2) {
        return (T) transform(r2, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    T transform(Transformation<Bitmap> r3, boolean r4) {
        if (this.isAutoCloneEnabled == true) goto L5;
        DrawableTransformation r0 = new DrawableTransformation(r3, r4);
        transform(Bitmap.class, r3, r4);
        transform(Drawable.class, r0, r4);
        transform(BitmapDrawable.class, r0.asBitmapDrawable(), r4);
        transform(GifDrawable.class, new GifDrawableTransformation(r3), r4);
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r3, r4);
    }

    public <Y> T optionalTransform(Class<Y> r2, Transformation<Y> r3) {
        return (T) transform(r2, r3, false);
    }

    <Y> T transform(Class<Y> r2, Transformation<Y> r3, boolean r4) {
        if (this.isAutoCloneEnabled == true) goto L5;
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r3);
        this.transformations.put(r2, r3);
        int r5 = this.fields | 2048;
        this.isTransformationAllowed = true;
        int r6 = r5 | 65536;
        this.fields = r6;
        this.isScaleOnlyOrNoTransform = false;
        if (r4 == false) goto L10;
        this.fields = r6 | 131072;
        this.isTransformationRequired = true;
    L10:
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().transform(r2, r3, r4);
    }

    public <Y> T transform(Class<Y> r2, Transformation<Y> r3) {
        return (T) transform(r2, r3, true);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled == true) goto L5;
        this.transformations.clear();
        int r0 = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (r0 & (-131073)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    L5:
        return (T) clone().dontTransform();
    }

    public T dontAnimate() {
        return (T) set(GifOptions.DISABLE_ANIMATION, true);
    }

    public T apply(BaseRequestOptions<?> r5) {
        if (this.isAutoCloneEnabled == false) goto L7;
        return (T) clone().apply(r5);
    L7:
        if (isSet(r5.fields, 2) == false) goto L10;
        this.sizeMultiplier = r5.sizeMultiplier;
    L10:
        if (isSet(r5.fields, 262144) == false) goto L13;
        this.useUnlimitedSourceGeneratorsPool = r5.useUnlimitedSourceGeneratorsPool;
    L13:
        if (isSet(r5.fields, 1048576) == false) goto L16;
        this.useAnimationPool = r5.useAnimationPool;
    L16:
        if (isSet(r5.fields, 4) == false) goto L19;
        this.diskCacheStrategy = r5.diskCacheStrategy;
    L19:
        if (isSet(r5.fields, 8) == false) goto L22;
        this.priority = r5.priority;
    L22:
        if (isSet(r5.fields, 16) == false) goto L25;
        this.errorPlaceholder = r5.errorPlaceholder;
        this.errorId = 0;
        this.fields &= -33;
    L25:
        if (isSet(r5.fields, 32) == false) goto L28;
        this.errorId = r5.errorId;
        this.errorPlaceholder = null;
        this.fields &= -17;
    L28:
        if (isSet(r5.fields, 64) == false) goto L31;
        this.placeholderDrawable = r5.placeholderDrawable;
        this.placeholderId = 0;
        this.fields &= -129;
    L31:
        if (isSet(r5.fields, 128) == false) goto L34;
        this.placeholderId = r5.placeholderId;
        this.placeholderDrawable = null;
        this.fields &= -65;
    L34:
        if (isSet(r5.fields, 256) == false) goto L37;
        this.isCacheable = r5.isCacheable;
    L37:
        if (isSet(r5.fields, 512) == false) goto L40;
        this.overrideWidth = r5.overrideWidth;
        this.overrideHeight = r5.overrideHeight;
    L40:
        if (isSet(r5.fields, 1024) == false) goto L43;
        this.signature = r5.signature;
    L43:
        if (isSet(r5.fields, 4096) == false) goto L46;
        this.resourceClass = r5.resourceClass;
    L46:
        if (isSet(r5.fields, 8192) == false) goto L49;
        this.fallbackDrawable = r5.fallbackDrawable;
        this.fallbackId = 0;
        this.fields &= -16385;
    L49:
        if (isSet(r5.fields, 16384) == false) goto L52;
        this.fallbackId = r5.fallbackId;
        this.fallbackDrawable = null;
        this.fields &= -8193;
    L52:
        if (isSet(r5.fields, 32768) == false) goto L55;
        this.theme = r5.theme;
    L55:
        if (isSet(r5.fields, 65536) == false) goto L58;
        this.isTransformationAllowed = r5.isTransformationAllowed;
    L58:
        if (isSet(r5.fields, 131072) == false) goto L61;
        this.isTransformationRequired = r5.isTransformationRequired;
    L61:
        if (isSet(r5.fields, 2048) == false) goto L64;
        this.transformations.putAll(r5.transformations);
        this.isScaleOnlyOrNoTransform = r5.isScaleOnlyOrNoTransform;
    L64:
        if (isSet(r5.fields, 524288) == false) goto L67;
        this.onlyRetrieveFromCache = r5.onlyRetrieveFromCache;
    L67:
        if (this.isTransformationAllowed == true) goto L69;
        this.transformations.clear();
        int r0 = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.fields = r0 & (-131073);
        this.isScaleOnlyOrNoTransform = true;
    L69:
        this.fields |= r5.fields;
        this.options.putAll(r5.options);
        return (T) selfOrThrowIfLocked();
    }

    public final boolean isEquivalentTo(BaseRequestOptions<?> r3) {
        if (Float.compare(r3.sizeMultiplier, this.sizeMultiplier) == 0) goto L5;
    L45:
        return false;
    L5:
        if (this.errorId != r3.errorId) goto L45;
        if (Util.bothNullOrEqual(this.errorPlaceholder, r3.errorPlaceholder) == false) goto L45;
        if (this.placeholderId != r3.placeholderId) goto L45;
        if (Util.bothNullOrEqual(this.placeholderDrawable, r3.placeholderDrawable) == false) goto L45;
        if (this.fallbackId != r3.fallbackId) goto L45;
        if (Util.bothNullOrEqual(this.fallbackDrawable, r3.fallbackDrawable) == false) goto L45;
        if (this.isCacheable != r3.isCacheable) goto L45;
        if (this.overrideHeight != r3.overrideHeight) goto L45;
        if (this.overrideWidth != r3.overrideWidth) goto L45;
        if (this.isTransformationRequired != r3.isTransformationRequired) goto L45;
        if (this.isTransformationAllowed != r3.isTransformationAllowed) goto L45;
        if (this.useUnlimitedSourceGeneratorsPool != r3.useUnlimitedSourceGeneratorsPool) goto L45;
        if (this.onlyRetrieveFromCache != r3.onlyRetrieveFromCache) goto L45;
        if (this.diskCacheStrategy.equals(r3.diskCacheStrategy) == false) goto L45;
        if (this.priority != r3.priority) goto L45;
        if (this.options.equals(r3.options) == false) goto L45;
        if (this.transformations.equals(r3.transformations) == false) goto L45;
        if (this.resourceClass.equals(r3.resourceClass) == false) goto L45;
        if (Util.bothNullOrEqual(this.signature, r3.signature) == false) goto L45;
        if (Util.bothNullOrEqual(this.theme, r3.theme) == false) goto L45;
        return true;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof BaseRequestOptions) == true) goto L5;
        return false;
    L5:
        return isEquivalentTo((BaseRequestOptions) r2);
    }

    public int hashCode() {
        int r0 = Util.hashCode(this.sizeMultiplier);
        int r1 = Util.hashCode(this.errorId, r0);
        int r2 = Util.hashCode(this.errorPlaceholder, r1);
        int r3 = Util.hashCode(this.placeholderId, r2);
        int r4 = Util.hashCode(this.placeholderDrawable, r3);
        int r5 = Util.hashCode(this.fallbackId, r4);
        int r6 = Util.hashCode(this.fallbackDrawable, r5);
        int r7 = Util.hashCode(this.isCacheable, r6);
        int r8 = Util.hashCode(this.overrideHeight, r7);
        int r9 = Util.hashCode(this.overrideWidth, r8);
        int r10 = Util.hashCode(this.isTransformationRequired, r9);
        int r11 = Util.hashCode(this.isTransformationAllowed, r10);
        int r12 = Util.hashCode(this.useUnlimitedSourceGeneratorsPool, r11);
        int r13 = Util.hashCode(this.onlyRetrieveFromCache, r12);
        int r14 = Util.hashCode(this.diskCacheStrategy, r13);
        int r15 = Util.hashCode(this.priority, r14);
        int r16 = Util.hashCode(this.options, r15);
        int r17 = Util.hashCode(this.transformations, r16);
        int r18 = Util.hashCode(this.resourceClass, r17);
        int r19 = Util.hashCode(this.signature, r18);
        return Util.hashCode(this.theme, r19);
    }

    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    public T autoClone() {
        if (this.isLocked == true) goto L5;
    L9:
        this.isAutoCloneEnabled = true;
        return (T) lock();
    L5:
        if (this.isAutoCloneEnabled == true) goto L9;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    protected final T selfOrThrowIfLocked() {
        if (this.isLocked == true) goto L7;
        return (T) self();
    L7:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    protected final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final Key getSignature() {
        return this.signature;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public final Priority getPriority() {
        return this.priority;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final boolean isValidOverride() {
        return Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    private boolean isSet(int r1) {
        return isSet(this.fields, r1);
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }
}
