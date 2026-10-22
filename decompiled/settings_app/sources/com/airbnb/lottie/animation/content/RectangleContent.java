package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final RectF rect;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private CompoundTrimPathContent trimPaths;

    public RectangleContent(LottieDrawable r2, BaseLayer r3, RectangleShape r4) {
        this.path = new Path();
        this.rect = new RectF();
        this.trimPaths = new CompoundTrimPathContent();
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        this.lottieDrawable = r2;
        BaseKeyframeAnimation<PointF, PointF> r5 = r4.getPosition().createAnimation();
        this.positionAnimation = r5;
        BaseKeyframeAnimation<PointF, PointF> r0 = r4.getSize().createAnimation();
        this.sizeAnimation = r0;
        BaseKeyframeAnimation<Float, Float> r6 = r4.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = r6;
        r3.addAnimation(r5);
        r3.addAnimation(r0);
        r3.addAnimation(r6);
        r5.addUpdateListener(this);
        r0.addUpdateListener(this);
        r6.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidate();
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r4, List<Content> r5) {
        int r6 = 0;
    L4:
        if (r6 >= r4.size()) goto L11;
        Content r0 = r4.get(r6);
        if ((r0 instanceof TrimPathContent) == false) goto L10;
        TrimPathContent r1 = (TrimPathContent) r0;
        if (r1.getType() != ShapeTrimPath.Type.SIMULTANEOUSLY) goto L10;
        this.trimPaths.addTrimPath(r1);
        r1.addListener(this);
    L10:
        r6 = r6 + 1;
        goto L4
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        if (this.isPathValid == true) goto L5;
        this.path.reset();
        if (this.hidden == false) goto L10;
        this.isPathValid = true;
        return this.path;
    L10:
        PointF r0 = this.sizeAnimation.getValue();
        float r2 = r0.x / 2.0f;
        float r1 = r0.y / 2.0f;
        BaseKeyframeAnimation<?, Float> r4 = this.cornerRadiusAnimation;
        if (r4 != null) goto L13;
        float r5 = 0.0f;
    L14:
        float r6 = Math.min(r2, r1);
        if (r5 <= r6) goto L17;
        r5 = r6;
    L17:
        PointF r7 = this.positionAnimation.getValue();
        this.path.moveTo(r7.x + r2, (r7.y - r1) + r5);
        this.path.lineTo(r7.x + r2, (r7.y + r1) - r5);
        if (r5 <= 0.0f) goto L20;
        float r12 = r5 * 2.0f;
        this.rect.set((r7.x + r2) - r12, (r7.y + r1) - r12, r7.x + r2, r7.y + r1);
        this.path.arcTo(this.rect, 0.0f, 90.0f, false);
    L20:
        this.path.lineTo((r7.x - r2) + r5, r7.y + r1);
        if (r5 <= 0.0f) goto L23;
        float r13 = r5 * 2.0f;
        this.rect.set(r7.x - r2, (r7.y + r1) - r13, (r7.x - r2) + r13, r7.y + r1);
        this.path.arcTo(this.rect, 90.0f, 90.0f, false);
    L23:
        this.path.lineTo(r7.x - r2, (r7.y - r1) + r5);
        if (r5 <= 0.0f) goto L26;
        float r14 = r5 * 2.0f;
        this.rect.set(r7.x - r2, r7.y - r1, (r7.x - r2) + r14, (r7.y - r1) + r14);
        this.path.arcTo(this.rect, 180.0f, 90.0f, false);
    L26:
        this.path.lineTo((r7.x + r2) - r5, r7.y - r1);
        if (r5 <= 0.0f) goto L29;
        float r8 = r5 * 2.0f;
        this.rect.set((r7.x + r2) - r8, r7.y - r1, r7.x + r2, (r7.y - r1) + r8);
        this.path.arcTo(this.rect, 270.0f, 90.0f, false);
    L29:
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L13:
        r5 = ((FloatKeyframeAnimation) r4).getFloatValue();
        goto L14
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.RECTANGLE_SIZE) goto L6;
        this.sizeAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.POSITION) goto L9;
        this.positionAnimation.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.CORNER_RADIUS) goto L14;
        this.cornerRadiusAnimation.setValueCallback(r3);
        return;
    }
}
