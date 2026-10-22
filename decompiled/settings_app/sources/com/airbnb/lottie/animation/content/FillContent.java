package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private final BaseKeyframeAnimation<Integer, Integer> colorAnimation;
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<Integer, Integer> opacityAnimation;
    private final Paint paint;
    private final Path path;
    private final List<PathContent> paths;

    public FillContent(LottieDrawable r4, BaseLayer r5, ShapeFill r6) {
        Path r0 = new Path();
        this.path = r0;
        this.paint = new LPaint(1);
        this.paths = new ArrayList();
        this.layer = r5;
        this.name = r6.getName();
        this.hidden = r6.isHidden();
        this.lottieDrawable = r4;
        if (r6.getColor() != null) goto L5;
    L9:
        this.colorAnimation = null;
        this.opacityAnimation = null;
        return;
    L5:
        if (r6.getOpacity() == null) goto L9;
        r0.setFillType(r6.getFillType());
        BaseKeyframeAnimation<Integer, Integer> r7 = r6.getColor().createAnimation();
        this.colorAnimation = r7;
        r7.addUpdateListener(this);
        r5.addAnimation(r7);
        BaseKeyframeAnimation<Integer, Integer> r8 = r6.getOpacity().createAnimation();
        this.opacityAnimation = r8;
        r8.addUpdateListener(this);
        r5.addAnimation(r8);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r3, List<Content> r4) {
        int r5 = 0;
    L4:
        if (r5 >= r4.size()) goto L9;
        Content r0 = r4.get(r5);
        if ((r0 instanceof PathContent) == false) goto L8;
        this.paths.add((PathContent) r0);
    L8:
        r5 = r5 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r5, Matrix r6, int r7) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        L.beginSection("FillContent#draw");
        this.paint.setColor(((ColorKeyframeAnimation) this.colorAnimation).getIntValue());
        int r3 = 0;
        this.paint.setAlpha(MiscUtils.clamp((int) ((((r7 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r8 = this.colorFilterAnimation;
        if (r8 == null) goto L8;
        this.paint.setColorFilter(r8.getValue());
    L8:
        this.path.reset();
    L10:
        if (r3 >= this.paths.size()) goto L12;
        this.path.addPath(this.paths.get(r3).getPath(), r6);
        r3 = r3 + 1;
        goto L10
    L12:
        r5.drawPath(this.path, this.paint);
        L.endSection("FillContent#draw");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r4, Matrix r5, boolean r6) {
        this.path.reset();
        int r0 = 0;
    L4:
        if (r0 >= this.paths.size()) goto L6;
        this.path.addPath(this.paths.get(r0).getPath(), r5);
        r0 = r0 + 1;
        goto L4
    L6:
        this.path.computeBounds(r4, false);
        r4.set(r4.left - 1.0f, r4.top - 1.0f, r4.right + 1.0f, r4.bottom + 1.0f);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.COLOR) goto L6;
        this.colorAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.OPACITY) goto L9;
        this.opacityAnimation.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.COLOR_FILTER) goto L16;
        if (r3 != null) goto L12;
        this.colorFilterAnimation = null;
        return;
    L12:
        ValueCallbackKeyframeAnimation r4 = new ValueCallbackKeyframeAnimation(r3);
        this.colorFilterAnimation = r4;
        r4.addUpdateListener(this);
        this.layer.addAnimation(this.colorFilterAnimation);
        return;
    }
}
