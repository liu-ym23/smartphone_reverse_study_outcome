package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private Paint offScreenPaint;
    private RectF offScreenRectF;
    private final Path path;
    private List<PathContent> pathContents;
    private final RectF rect;
    private TransformKeyframeAnimation transformAnimation;

    private static List<Content> contentsFromModels(LottieDrawable r3, BaseLayer r4, List<ContentModel> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L9;
        Content r2 = r5.get(r1).toContent(r3, r4);
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    static AnimatableTransform findTransform(List<ContentModel> r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.size()) goto L10;
        ContentModel r1 = r3.get(r0);
        if ((r1 instanceof AnimatableTransform) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return (AnimatableTransform) r1;
    L10:
        return null;
    }

    public ContentGroup(LottieDrawable r8, BaseLayer r9, ShapeGroup r10) {
        this(r8, r9, r10.getName(), r10.isHidden(), contentsFromModels(r8, r9, r10.getItems()), findTransform(r10.getItems()));
    }

    ContentGroup(LottieDrawable r2, BaseLayer r3, String r4, boolean r5, List<Content> r6, AnimatableTransform r7) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = r4;
        this.lottieDrawable = r2;
        this.hidden = r5;
        this.contents = r6;
        if (r7 == null) goto L5;
        TransformKeyframeAnimation r8 = r7.createAnimation();
        this.transformAnimation = r8;
        r8.addAnimationsToLayer(r3);
        this.transformAnimation.addListener(this);
    L5:
        ArrayList r1 = new ArrayList();
        int r9 = r6.size() - 1;
    L6:
        if (r9 < 0) goto L11;
        Content r10 = r6.get(r9);
        if ((r10 instanceof GreedyContent) == false) goto L10;
        r1.add((GreedyContent) r10);
    L10:
        r9 = r9 - 1;
        goto L6
    L11:
        int r11 = r1.size() - 1;
    L12:
        if (r11 < 0) goto L14;
        ((GreedyContent) r1.get(r11)).absorbContent(r6.listIterator(r6.size()));
        r11 = r11 - 1;
        goto L12
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r4, List<Content> r5) {
        ArrayList r6 = new ArrayList(r4.size() + this.contents.size());
        r6.addAll(r4);
        int r7 = this.contents.size() - 1;
    L3:
        if (r7 < 0) goto L5;
        Content r0 = this.contents.get(r7);
        r0.setContents(r6, this.contents.subList(0, r7));
        r6.add(r0);
        r7 = r7 - 1;
        goto L3
    }

    List<PathContent> getPathList() {
        if (this.pathContents != null) goto L12;
        this.pathContents = new ArrayList();
        int r0 = 0;
    L6:
        if (r0 >= this.contents.size()) goto L12;
        Content r1 = this.contents.get(r0);
        if ((r1 instanceof PathContent) == false) goto L10;
        this.pathContents.add((PathContent) r1);
    L10:
        r0 = r0 + 1;
    L12:
        return this.pathContents;
    }

    Matrix getTransformationMatrix() {
        TransformKeyframeAnimation r0 = this.transformAnimation;
        if (r0 != null) goto L5;
        this.matrix.reset();
        return this.matrix;
    L5:
        return r0.getMatrix();
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation r0 = this.transformAnimation;
        if (r0 == null) goto L5;
        this.matrix.set(r0.getMatrix());
    L5:
        this.path.reset();
        if (this.hidden == true) goto L8;
        int r1 = this.contents.size() - 1;
    L10:
        if (r1 < 0) goto L16;
        Content r2 = this.contents.get(r1);
        if ((r2 instanceof PathContent) == false) goto L14;
        this.path.addPath(((PathContent) r2).getPath(), this.matrix);
    L14:
        r1 = r1 - 1;
        goto L10
    L16:
        return this.path;
    L8:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r5, Matrix r6, int r7) {
        if (this.hidden == false) goto L5;
        return;
    L5:
        this.matrix.set(r6);
        TransformKeyframeAnimation r8 = this.transformAnimation;
        if (r8 == null) goto L13;
        this.matrix.preConcat(r8.getMatrix());
        if (this.transformAnimation.getOpacity() != null) goto L10;
        int r9 = 100;
    L11:
        r7 = (int) ((((r9 / 100.0f) * r7) / 255.0f) * 255.0f);
        goto L13
    L10:
        r9 = this.transformAnimation.getOpacity().getValue().intValue();
    L13:
        if (this.lottieDrawable.isApplyingOpacityToLayersEnabled() == true) goto L15;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == false) goto L21;
        this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        getBounds(this.offScreenRectF, this.matrix, true);
        this.offScreenPaint.setAlpha(r7);
        Utils.saveLayerCompat(r5, this.offScreenRectF, this.offScreenPaint);
    L21:
        if (r10 == false) goto L23;
        r7 = 255;
    L23:
        int r0 = this.contents.size() - 1;
    L24:
        if (r0 < 0) goto L29;
        Content r1 = this.contents.get(r0);
        if ((r1 instanceof DrawingContent) == false) goto L28;
        ((DrawingContent) r1).draw(r5, this.matrix, r7);
    L28:
        r0 = r0 - 1;
        goto L24
    L29:
        if (r10 == false) goto L35;
        r5.restore();
        return;
    L35:
        return;
    L15:
        if (hasTwoOrMoreDrawableContent() == false) goto L18;
        if (r7 == 255) goto L18;
        r10 = true;
        goto L19
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.contents.size()) goto L12;
        if ((this.contents.get(r1) instanceof DrawingContent) == false) goto L11;
        r2 = r2 + 1;
        if (r2 < 2) goto L11;
        return true;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return false;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r4, Matrix r5, boolean r6) {
        this.matrix.set(r5);
        TransformKeyframeAnimation r7 = this.transformAnimation;
        if (r7 == null) goto L5;
        this.matrix.preConcat(r7.getMatrix());
    L5:
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        int r8 = this.contents.size() - 1;
    L6:
        if (r8 < 0) goto L11;
        Content r0 = this.contents.get(r8);
        if ((r0 instanceof DrawingContent) == false) goto L10;
        ((DrawingContent) r0).getBounds(this.rect, this.matrix, r6);
        r4.union(this.rect);
    L10:
        r8 = r8 - 1;
        goto L6
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r4, int r5, List<KeyPath> r6, KeyPath r7) {
        if (r4.matches(getName(), r5) == true) goto L6;
        return;
    L6:
        if ("__container".equals(getName()) == true) goto L11;
        r7 = r7.addKey(getName());
        if (r4.fullyResolvesTo(getName(), r5) == false) goto L11;
        r6.add(r7.resolve(this));
    L11:
        if (r4.propagateToChildren(getName(), r5) == false) goto L19;
        int r8 = r5 + r4.incrementDepthBy(getName(), r5);
        int r0 = 0;
    L14:
        if (r0 >= this.contents.size()) goto L23;
        Content r1 = this.contents.get(r0);
        if ((r1 instanceof KeyPathElement) == false) goto L18;
        ((KeyPathElement) r1).resolveKeyPath(r4, r8, r6, r7);
    L18:
        r0 = r0 + 1;
        goto L14
    L23:
        return;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r1, LottieValueCallback<T> r2) {
        TransformKeyframeAnimation r0 = this.transformAnimation;
        if (r0 == null) goto L6;
        r0.applyValueCallback(r1, r2);
        return;
    }
}
