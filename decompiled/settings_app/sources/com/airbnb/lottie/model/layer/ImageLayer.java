package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;

/* JADX INFO: loaded from: classes.dex */
public class ImageLayer extends BaseLayer {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Rect dst;
    private final Paint paint;
    private final Rect src;

    ImageLayer(LottieDrawable r1, Layer r2) {
        super(r1, r2);
        this.paint = new LPaint(3);
        this.src = new Rect();
        this.dst = new Rect();
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas r5, Matrix r6, int r7) {
        Bitmap r0 = getBitmap();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRecycled() == true) goto L13;
        float r1 = Utils.dpScale();
        this.paint.setAlpha(r7);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r8 = this.colorFilterAnimation;
        if (r8 == null) goto L10;
        this.paint.setColorFilter(r8.getValue());
    L10:
        r5.save();
        r5.concat(r6);
        this.src.set(0, 0, r0.getWidth(), r0.getHeight());
        this.dst.set(0, 0, (int) (r0.getWidth() * r1), (int) (r0.getHeight() * r1));
        r5.drawBitmap(r0, this.src, this.dst, this.paint);
        r5.restore();
        return;
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r2, Matrix r3, boolean r4) {
        super.getBounds(r2, r3, r4);
        Bitmap r5 = getBitmap();
        if (r5 == null) goto L6;
        r2.set(0.0f, 0.0f, r5.getWidth() * Utils.dpScale(), r5.getHeight() * Utils.dpScale());
        this.boundsMatrix.mapRect(r2);
        return;
    }

    private Bitmap getBitmap() {
        String r0 = this.layerModel.getRefId();
        return this.lottieDrawable.getImageAsset(r0);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        super.addValueCallback(r2, r3);
        if (r2 != LottieProperty.COLOR_FILTER) goto L8;
        if (r3 != null) goto L6;
        this.colorFilterAnimation = null;
        return;
    L6:
        this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(r3);
        return;
    }
}
