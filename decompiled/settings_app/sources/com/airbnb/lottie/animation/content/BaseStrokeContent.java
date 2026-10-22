package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    protected final BaseLayer layer;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    final Paint paint;
    private final Path path;
    private final List<PathGroup> pathGroups;
    private final PathMeasure pm;
    private final RectF rect;
    private final Path trimPathPath;
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.BaseStrokeContent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class PathGroup {
        private final List<PathContent> paths;
        private final TrimPathContent trimPath;

        /* synthetic */ PathGroup(TrimPathContent r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ List access$100(PathGroup r0) {
            return r0.paths;
        }

        static /* synthetic */ TrimPathContent access$200(PathGroup r0) {
            return r0.trimPath;
        }

        private PathGroup(TrimPathContent r2) {
            this.paths = new ArrayList();
            this.trimPath = r2;
        }
    }

    BaseStrokeContent(LottieDrawable r3, BaseLayer r4, Paint.Cap r5, Paint.Join r6, float r7, AnimatableIntegerValue r8, AnimatableFloatValue r9, List<AnimatableFloatValue> r10, AnimatableFloatValue r11) {
        this.pm = new PathMeasure();
        this.path = new Path();
        this.trimPathPath = new Path();
        this.rect = new RectF();
        this.pathGroups = new ArrayList();
        LPaint r0 = new LPaint(1);
        this.paint = r0;
        this.lottieDrawable = r3;
        this.layer = r4;
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeCap(r5);
        r0.setStrokeJoin(r6);
        r0.setStrokeMiter(r7);
        this.opacityAnimation = r8.createAnimation();
        this.widthAnimation = r9.createAnimation();
        if (r11 != null) goto L5;
        this.dashPatternOffsetAnimation = null;
    L6:
        this.dashPatternAnimations = new ArrayList(r10.size());
        this.dashPatternValues = new float[r10.size()];
        int r12 = 0;
        int r13 = 0;
    L8:
        if (r13 >= r10.size()) goto L10;
        this.dashPatternAnimations.add(r10.get(r13).createAnimation());
        r13 = r13 + 1;
        goto L8
    L10:
        r4.addAnimation(this.opacityAnimation);
        r4.addAnimation(this.widthAnimation);
        int r14 = 0;
    L12:
        if (r14 >= this.dashPatternAnimations.size()) goto L14;
        r4.addAnimation(this.dashPatternAnimations.get(r14));
        r14 = r14 + 1;
        goto L12
    L14:
        BaseKeyframeAnimation<?, Float> r15 = this.dashPatternOffsetAnimation;
        if (r15 == null) goto L17;
        r4.addAnimation(r15);
    L17:
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
    L19:
        if (r12 >= r10.size()) goto L21;
        this.dashPatternAnimations.get(r12).addUpdateListener(this);
        r12 = r12 + 1;
        goto L19
    L21:
        BaseKeyframeAnimation<?, Float> r16 = this.dashPatternOffsetAnimation;
        if (r16 == null) goto L28;
        r16.addUpdateListener(this);
        return;
    L28:
        return;
    L5:
        this.dashPatternOffsetAnimation = r11.createAnimation();
        goto L6
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r8, List<Content> r9) {
        int r0 = r8.size() - 1;
        AnonymousClass1 r1 = null;
        TrimPathContent r2 = null;
    L3:
        if (r0 < 0) goto L10;
        Content r3 = r8.get(r0);
        if ((r3 instanceof TrimPathContent) == false) goto L9;
        TrimPathContent r4 = (TrimPathContent) r3;
        if (r4.getType() != ShapeTrimPath.Type.INDIVIDUALLY) goto L9;
        r2 = r4;
    L9:
        r0 = r0 - 1;
        goto L3
    L10:
        if (r2 == null) goto L12;
        r2.addListener(this);
    L12:
        int r10 = r9.size() - 1;
        PathGroup r5 = null;
    L13:
        if (r10 < 0) goto L27;
        Content r6 = r9.get(r10);
        if ((r6 instanceof TrimPathContent) == false) goto L22;
        TrimPathContent r7 = (TrimPathContent) r6;
        if (r7.getType() != ShapeTrimPath.Type.INDIVIDUALLY) goto L22;
        if (r5 == null) goto L20;
        this.pathGroups.add(r5);
    L20:
        r5 = new PathGroup(r7, r1);
        r7.addListener(this);
    L26:
        r10 = r10 - 1;
    L22:
        if ((r6 instanceof PathContent) == false) goto L26;
        if (r5 != null) goto L25;
        r5 = new PathGroup(r2, r1);
    L25:
        PathGroup.access$100(r5).add((PathContent) r6);
        goto L26
    L27:
        if (r5 == null) goto L38;
        this.pathGroups.add(r5);
        return;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r7, Matrix r8, int r9) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(r8) == false) goto L6;
        L.endSection("StrokeContent#draw");
        return;
    L6:
        int r3 = 0;
        this.paint.setAlpha(MiscUtils.clamp((int) ((((r9 / 255.0f) * ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue()) / 100.0f) * 255.0f), 0, 255));
        this.paint.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(r8));
        if (this.paint.getStrokeWidth() > 0.0f) goto L10;
        L.endSection("StrokeContent#draw");
        return;
    L10:
        applyDashPatternIfNeeded(r8);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> r10 = this.colorFilterAnimation;
        if (r10 == null) goto L14;
        this.paint.setColorFilter(r10.getValue());
    L14:
        if (r3 >= this.pathGroups.size()) goto L23;
        PathGroup r11 = this.pathGroups.get(r3);
        if (PathGroup.access$200(r11) == null) goto L18;
        applyTrimPath(r7, r11, r8);
    L22:
        r3 = r3 + 1;
        goto L14
    L18:
        L.beginSection("StrokeContent#buildPath");
        this.path.reset();
        int r2 = PathGroup.access$100(r11).size() - 1;
    L19:
        if (r2 < 0) goto L21;
        this.path.addPath(((PathContent) PathGroup.access$100(r11).get(r2)).getPath(), r8);
        r2 = r2 - 1;
        goto L19
    L21:
        L.endSection("StrokeContent#buildPath");
        L.beginSection("StrokeContent#drawPath");
        r7.drawPath(this.path, this.paint);
        L.endSection("StrokeContent#drawPath");
        goto L22
    L23:
        L.endSection("StrokeContent#draw");
    }

    private void applyTrimPath(Canvas r13, PathGroup r14, Matrix r15) {
        L.beginSection("StrokeContent#applyTrimPath");
        if (PathGroup.access$200(r14) != null) goto L6;
        L.endSection("StrokeContent#applyTrimPath");
        return;
    L6:
        this.path.reset();
        int r1 = PathGroup.access$100(r14).size() - 1;
    L7:
        if (r1 < 0) goto L9;
        this.path.addPath(((PathContent) PathGroup.access$100(r14).get(r1)).getPath(), r15);
        r1 = r1 - 1;
        goto L7
    L9:
        this.pm.setPath(this.path, false);
        float r2 = this.pm.getLength();
    L11:
        if (this.pm.nextContour() == false) goto L13;
        r2 = r2 + this.pm.getLength();
        goto L11
    L13:
        float r3 = (PathGroup.access$200(r14).getOffset().getValue().floatValue() * r2) / 360.0f;
        float r4 = ((PathGroup.access$200(r14).getStart().getValue().floatValue() * r2) / 100.0f) + r3;
        float r6 = ((PathGroup.access$200(r14).getEnd().getValue().floatValue() * r2) / 100.0f) + r3;
        int r5 = PathGroup.access$100(r14).size() - 1;
        float r7 = 0.0f;
    L14:
        if (r5 < 0) goto L46;
        this.trimPathPath.set(((PathContent) PathGroup.access$100(r14).get(r5)).getPath());
        this.trimPathPath.transform(r15);
        this.pm.setPath(this.trimPathPath, false);
        float r8 = this.pm.getLength();
        float r10 = 1.0f;
        if (r6 <= r2) goto L26;
        float r9 = r6 - r2;
        if (r9 >= (r7 + r8)) goto L26;
        if (r7 >= r9) goto L26;
        if (r4 <= r2) goto L24;
        float r11 = (r4 - r2) / r8;
    L25:
        Utils.applyTrimPathIfNeeded(this.trimPathPath, r11, Math.min(r9 / r8, 1.0f), 0.0f);
        r13.drawPath(this.trimPathPath, this.paint);
    L45:
        r7 = r7 + r8;
        r5 = r5 - 1;
        goto L14
    L24:
        r11 = 0.0f;
    L26:
        float r12 = r7 + r8;
        if (r12 < r4) goto L45;
        if (r7 > r6) goto L45;
        if (r12 > r6) goto L37;
        if (r4 >= r7) goto L37;
        r13.drawPath(this.trimPathPath, this.paint);
    L37:
        if (r4 >= r7) goto L39;
        float r16 = 0.0f;
    L41:
        if (r6 > r12) goto L44;
        r10 = (r6 - r7) / r8;
    L44:
        Utils.applyTrimPathIfNeeded(this.trimPathPath, r16, r10, 0.0f);
        r13.drawPath(this.trimPathPath, this.paint);
        goto L45
    L39:
        r16 = (r4 - r7) / r8;
        goto L41
    L46:
        L.endSection("StrokeContent#applyTrimPath");
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r7, Matrix r8, boolean r9) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        int r1 = 0;
    L4:
        if (r1 >= this.pathGroups.size()) goto L10;
        PathGroup r2 = this.pathGroups.get(r1);
        int r3 = 0;
    L7:
        if (r3 >= PathGroup.access$100(r2).size()) goto L9;
        this.path.addPath(((PathContent) PathGroup.access$100(r2).get(r3)).getPath(), r8);
        r3 = r3 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    L10:
        this.path.computeBounds(this.rect, false);
        float r10 = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF r0 = this.rect;
        float r11 = r10 / 2.0f;
        r0.set(r0.left - r11, this.rect.top - r11, this.rect.right + r11, this.rect.bottom + r11);
        r7.set(this.rect);
        r7.set(r7.left - 1.0f, r7.top - 1.0f, r7.right + 1.0f, r7.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    private void applyDashPatternIfNeeded(Matrix r6) {
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty() == false) goto L6;
        L.endSection("StrokeContent#applyDashPattern");
        return;
    L6:
        float r7 = Utils.getScale(r6);
        int r1 = 0;
    L8:
        if (r1 >= this.dashPatternAnimations.size()) goto L18;
        this.dashPatternValues[r1] = this.dashPatternAnimations.get(r1).getValue().floatValue();
        if ((r1 % 2) != 0) goto L14;
        float[] r2 = this.dashPatternValues;
        if (r2[r1] >= 1.0f) goto L17;
        r2[r1] = 1.0f;
    L17:
        float[] r3 = this.dashPatternValues;
        r3[r1] = r3[r1] * r7;
        r1 = r1 + 1;
        goto L8
    L14:
        float[] r4 = this.dashPatternValues;
        if (r4[r1] >= 0.1f) goto L17;
        r4[r1] = 0.1f;
        goto L17
    L18:
        BaseKeyframeAnimation<?, Float> r5 = this.dashPatternOffsetAnimation;
        if (r5 != null) goto L21;
        float r8 = 0.0f;
    L22:
        this.paint.setPathEffect(new DashPathEffect(this.dashPatternValues, r8));
        L.endSection("StrokeContent#applyDashPattern");
        return;
    L21:
        r8 = r7 * r5.getValue().floatValue();
        goto L22
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.OPACITY) goto L6;
        this.opacityAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.STROKE_WIDTH) goto L9;
        this.widthAnimation.setValueCallback(r3);
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
