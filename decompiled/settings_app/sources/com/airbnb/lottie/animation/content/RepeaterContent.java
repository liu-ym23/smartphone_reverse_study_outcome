package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private ContentGroup contentGroup;
    private final BaseKeyframeAnimation<Float, Float> copies;
    private final boolean hidden;
    private final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final BaseKeyframeAnimation<Float, Float> offset;
    private final Path path;
    private final TransformKeyframeAnimation transform;

    public RepeaterContent(LottieDrawable r2, BaseLayer r3, Repeater r4) {
        this.matrix = new Matrix();
        this.path = new Path();
        this.lottieDrawable = r2;
        this.layer = r3;
        this.name = r4.getName();
        this.hidden = r4.isHidden();
        BaseKeyframeAnimation<Float, Float> r5 = r4.getCopies().createAnimation();
        this.copies = r5;
        r3.addAnimation(r5);
        r5.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> r6 = r4.getOffset().createAnimation();
        this.offset = r6;
        r3.addAnimation(r6);
        r6.addUpdateListener(this);
        TransformKeyframeAnimation r7 = r4.getTransform().createAnimation();
        this.transform = r7;
        r7.addAnimationsToLayer(r3);
        r7.addListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public void absorbContent(ListIterator<Content> r9) {
        if (this.contentGroup == null) goto L6;
        return;
    L6:
        if (r9.hasPrevious() == false) goto L10;
        if (r9.previous() != this) goto L6;
    L10:
        ArrayList r6 = new ArrayList();
    L12:
        if (r9.hasPrevious() == false) goto L14;
        r6.add(r9.previous());
        r9.remove();
        goto L12
    L14:
        Collections.reverse(r6);
        this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", this.hidden, r6, null);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r1, List<Content> r2) {
        this.contentGroup.setContents(r1, r2);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        Path r0 = this.contentGroup.getPath();
        this.path.reset();
        float r1 = this.copies.getValue().floatValue();
        float r2 = this.offset.getValue().floatValue();
        int r3 = ((int) r1) - 1;
    L3:
        if (r3 < 0) goto L6;
        this.matrix.set(this.transform.getMatrixForRepeater(r3 + r2));
        this.path.addPath(r0, this.matrix);
        r3 = r3 - 1;
        goto L3
    L6:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r10, Matrix r11, int r12) {
        float r0 = this.copies.getValue().floatValue();
        float r1 = this.offset.getValue().floatValue();
        float r2 = this.transform.getStartOpacity().getValue().floatValue() / 100.0f;
        float r4 = this.transform.getEndOpacity().getValue().floatValue() / 100.0f;
        int r3 = ((int) r0) - 1;
    L3:
        if (r3 < 0) goto L5;
        this.matrix.set(r11);
        float r7 = r3;
        this.matrix.preConcat(this.transform.getMatrixForRepeater(r7 + r1));
        this.contentGroup.draw(r10, this.matrix, (int) (r12 * MiscUtils.lerp(r2, r4, r7 / r0)));
        r3 = r3 - 1;
        goto L3
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r1, Matrix r2, boolean r3) {
        this.contentGroup.getBounds(r1, r2, r3);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (this.transform.applyValueCallback(r2, r3) == false) goto L6;
        return;
    L6:
        if (r2 != LottieProperty.REPEATER_COPIES) goto L9;
        this.copies.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.REPEATER_OFFSET) goto L13;
        this.offset.setValueCallback(r3);
        return;
    }
}
