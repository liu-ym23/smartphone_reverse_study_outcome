package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;

/* JADX INFO: loaded from: classes3.dex */
public class RequestOptions extends BaseRequestOptions<RequestOptions> {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public RequestOptions() {
    }

    public static RequestOptions sizeMultiplierOf(float r1) {
        return new RequestOptions().sizeMultiplier(r1);
    }

    public static RequestOptions diskCacheStrategyOf(DiskCacheStrategy r1) {
        return new RequestOptions().diskCacheStrategy(r1);
    }

    public static RequestOptions priorityOf(Priority r1) {
        return new RequestOptions().priority(r1);
    }

    public static RequestOptions placeholderOf(Drawable r1) {
        return new RequestOptions().placeholder(r1);
    }

    public static RequestOptions placeholderOf(int r1) {
        return new RequestOptions().placeholder(r1);
    }

    public static RequestOptions errorOf(Drawable r1) {
        return new RequestOptions().error(r1);
    }

    public static RequestOptions errorOf(int r1) {
        return new RequestOptions().error(r1);
    }

    public static RequestOptions skipMemoryCacheOf(boolean r1) {
        if (r1 == false) goto L9;
        if (skipMemoryCacheTrueOptions != null) goto L7;
        skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
    L7:
        return skipMemoryCacheTrueOptions;
    L9:
        if (skipMemoryCacheFalseOptions != null) goto L12;
        skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
    L12:
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions overrideOf(int r1, int r2) {
        return new RequestOptions().override(r1, r2);
    }

    public static RequestOptions overrideOf(int r0) {
        return overrideOf(r0, r0);
    }

    public static RequestOptions signatureOf(Key r1) {
        return new RequestOptions().signature(r1);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions != null) goto L6;
        fitCenterOptions = new RequestOptions().fitCenter().autoClone();
    L6:
        return fitCenterOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions != null) goto L6;
        centerInsideOptions = new RequestOptions().centerInside().autoClone();
    L6:
        return centerInsideOptions;
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions != null) goto L6;
        centerCropOptions = new RequestOptions().centerCrop().autoClone();
    L6:
        return centerCropOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions != null) goto L6;
        circleCropOptions = new RequestOptions().circleCrop().autoClone();
    L6:
        return circleCropOptions;
    }

    public static RequestOptions bitmapTransform(Transformation<Bitmap> r1) {
        return new RequestOptions().transform(r1);
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions != null) goto L6;
        noTransformOptions = new RequestOptions().dontTransform().autoClone();
    L6:
        return noTransformOptions;
    }

    public static <T> RequestOptions option(Option<T> r1, T r2) {
        return new RequestOptions().set(r1, r2);
    }

    public static RequestOptions decodeTypeOf(Class<?> r1) {
        return new RequestOptions().decode(r1);
    }

    public static RequestOptions formatOf(DecodeFormat r1) {
        return new RequestOptions().format(r1);
    }

    public static RequestOptions frameOf(long r1) {
        return new RequestOptions().frame(r1);
    }

    public static RequestOptions downsampleOf(DownsampleStrategy r1) {
        return new RequestOptions().downsample(r1);
    }

    public static RequestOptions timeoutOf(int r1) {
        return new RequestOptions().timeout(r1);
    }

    public static RequestOptions encodeQualityOf(int r1) {
        return new RequestOptions().encodeQuality(r1);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat r1) {
        return new RequestOptions().encodeFormat(r1);
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions != null) goto L6;
        noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
    L6:
        return noAnimationOptions;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public boolean equals(Object r2) {
        if ((r2 instanceof RequestOptions) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.equals(r2) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    public int hashCode() {
        return super.hashCode();
    }
}
