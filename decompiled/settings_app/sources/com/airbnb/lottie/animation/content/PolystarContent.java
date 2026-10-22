package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path;
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private CompoundTrimPathContent trimPaths;
    private final PolystarShape.Type type;

    /* JADX INFO: renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = null;

        static {
            int[] r0 = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = r0;
            r0[PolystarShape.Type.STAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public PolystarContent(LottieDrawable r7, BaseLayer r8, PolystarShape r9) {
        this.path = new Path();
        this.trimPaths = new CompoundTrimPathContent();
        this.lottieDrawable = r7;
        this.name = r9.getName();
        PolystarShape.Type r10 = r9.getType();
        this.type = r10;
        this.hidden = r9.isHidden();
        BaseKeyframeAnimation<Float, Float> r0 = r9.getPoints().createAnimation();
        this.pointsAnimation = r0;
        BaseKeyframeAnimation<PointF, PointF> r1 = r9.getPosition().createAnimation();
        this.positionAnimation = r1;
        BaseKeyframeAnimation<Float, Float> r2 = r9.getRotation().createAnimation();
        this.rotationAnimation = r2;
        BaseKeyframeAnimation<Float, Float> r3 = r9.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = r3;
        BaseKeyframeAnimation<Float, Float> r4 = r9.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = r4;
        if (r10 != PolystarShape.Type.STAR) goto L5;
        this.innerRadiusAnimation = r9.getInnerRadius().createAnimation();
        this.innerRoundednessAnimation = r9.getInnerRoundedness().createAnimation();
    L6:
        r8.addAnimation(r0);
        r8.addAnimation(r1);
        r8.addAnimation(r2);
        r8.addAnimation(r3);
        r8.addAnimation(r4);
        if (r10 != PolystarShape.Type.STAR) goto L9;
        r8.addAnimation(this.innerRadiusAnimation);
        r8.addAnimation(this.innerRoundednessAnimation);
    L9:
        r0.addUpdateListener(this);
        r1.addUpdateListener(this);
        r2.addUpdateListener(this);
        r3.addUpdateListener(this);
        r4.addUpdateListener(this);
        if (r10 != PolystarShape.Type.STAR) goto L13;
        this.innerRadiusAnimation.addUpdateListener(this);
        this.innerRoundednessAnimation.addUpdateListener(this);
        return;
    L13:
        return;
    L5:
        this.innerRadiusAnimation = null;
        this.innerRoundednessAnimation = null;
        goto L6
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
        int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (r0 != 1) goto L13;
        createStarPath();
    L17:
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    L13:
        if (r0 != 2) goto L17;
        createPolygonPath();
        goto L17
    L5:
        return this.path;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    private void createStarPath() {
        float r1 = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> r2 = this.rotationAnimation;
        if (r2 != null) goto L5;
        double r3 = 0.0d;
    L6:
        double r4 = Math.toRadians(r3 - 90.0d);
        double r5 = r1;
        float r6 = (float) (6.283185307179586d / r5);
        float r8 = r6 / 2.0f;
        float r7 = r1 - ((int) r1);
        if (r7 == 0.0f) goto L9;
        r4 = r4 + ((double) ((1.0f - r7) * r8));
    L9:
        float r11 = this.outerRadiusAnimation.getValue().floatValue();
        float r12 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> r13 = this.innerRoundednessAnimation;
        if (r13 == null) goto L12;
        float r14 = r13.getValue().floatValue() / 100.0f;
    L13:
        BaseKeyframeAnimation<?, Float> r15 = this.outerRoundednessAnimation;
        if (r15 == null) goto L16;
        float r16 = r15.getValue().floatValue() / 100.0f;
    L17:
        if (r7 == 0.0f) goto L19;
        float r17 = ((r11 - r12) * r7) + r12;
        double r9 = r17;
        float r10 = (float) (r9 * Math.cos(r4));
        float r18 = (float) (r9 * Math.sin(r4));
        this.path.moveTo(r10, r18);
        double r19 = r4 + ((double) ((r6 * r7) / 2.0f));
        float r110 = r10;
        float r20 = r8;
    L20:
        double r21 = Math.ceil(r5) * 2.0d;
        int r22 = 0;
        float r23 = r20;
        float r24 = r110;
        boolean r111 = false;
    L21:
        double r112 = r22;
        if (r112 >= r21) goto L65;
        if (r111 == false) goto L25;
        float r25 = r11;
    L27:
        if (r17 != 0.0f) goto L29;
    L31:
        float r26 = r23;
    L33:
        if (r17 != 0.0f) goto L35;
    L37:
        r17 = r25;
    L38:
        double r113 = r17;
        double r33 = r21;
        float r27 = (float) (r113 * Math.cos(r19));
        float r28 = (float) (r113 * Math.sin(r19));
        if (r14 == 0.0f) goto L41;
    L43:
        float r29 = r14;
        double r114 = (float) (Math.atan2(r18, r24) - 1.5707963267948966d);
        float r115 = (float) Math.cos(r114);
        float r116 = (float) Math.sin(r114);
        float r117 = r16;
        double r30 = (float) (Math.atan2(r28, r27) - 1.5707963267948966d);
        float r118 = (float) Math.cos(r30);
        float r31 = (float) Math.sin(r30);
        if (r111 == false) goto L46;
        float r32 = r29;
    L47:
        if (r111 == false) goto L49;
        float r119 = r117;
    L50:
        if (r111 == false) goto L52;
        float r34 = r12;
    L53:
        if (r111 == false) goto L55;
        float r35 = r11;
    L56:
        float r36 = (r34 * r32) * POLYSTAR_MAGIC_NUMBER;
        float r120 = r115 * r36;
        float r37 = r36 * r116;
        float r38 = (r35 * r119) * POLYSTAR_MAGIC_NUMBER;
        float r121 = r118 * r38;
        float r39 = r38 * r31;
        if (r7 == 0.0f) goto L63;
        if (r22 != 0) goto L61;
        r120 = r120 * r7;
        r37 = r37 * r7;
        goto L63
    L61:
        if (r112 != (r33 - 1.0d)) goto L63;
        r121 = r121 * r7;
        r39 = r39 * r7;
    L63:
        this.path.cubicTo(r24 - r120, r18 - r37, r27 + r121, r28 + r39, r27, r28);
    L64:
        r19 = r19 + ((double) r26);
        r111 = !r111;
        r22 = r22 + 1;
        r24 = r27;
        r18 = r28;
        r16 = r117;
        r14 = r29;
        r17 = r17;
        r6 = r6;
        r21 = r33;
        goto L21
    L55:
        r35 = r12;
        goto L56
    L52:
        r34 = r11;
        goto L53
    L49:
        r119 = r29;
        goto L50
    L46:
        r32 = r117;
        goto L47
    L41:
        if (r16 != 0.0f) goto L43;
        this.path.lineTo(r27, r28);
        r29 = r14;
        r117 = r16;
        goto L64
    L35:
        if (r112 != (r21 - 1.0d)) goto L37;
    L29:
        if (r112 != (r21 - 2.0d)) goto L31;
        r26 = (r6 * r7) / 2.0f;
        goto L33
    L25:
        r25 = r12;
        goto L27
    L65:
        PointF r40 = this.positionAnimation.getValue();
        this.path.offset(r40.x, r40.y);
        this.path.close();
        return;
    L19:
        double r41 = r11;
        float r42 = (float) (Math.cos(r4) * r41);
        float r43 = (float) (r41 * Math.sin(r4));
        this.path.moveTo(r42, r43);
        r110 = r42;
        r20 = r8;
        r19 = r4 + ((double) r20);
        r18 = r43;
        r17 = 0.0f;
        goto L20
    L16:
        r16 = 0.0f;
        goto L17
    L12:
        r14 = 0.0f;
        goto L13
    L5:
        r3 = r2.getValue().floatValue();
        goto L6
    }

    private void createPolygonPath() {
        int r1 = (int) Math.floor(this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> r2 = this.rotationAnimation;
        if (r2 != null) goto L5;
        double r3 = 0.0d;
    L6:
        double r4 = Math.toRadians(r3 - 90.0d);
        double r5 = r1;
        float r6 = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float r7 = this.outerRadiusAnimation.getValue().floatValue();
        double r8 = r7;
        float r10 = (float) (Math.cos(r4) * r8);
        float r11 = (float) (Math.sin(r4) * r8);
        this.path.moveTo(r10, r11);
        double r12 = (float) (6.283185307179586d / r5);
        double r9 = r4 + r12;
        double r13 = Math.ceil(r5);
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L14;
        float r15 = (float) (Math.cos(r9) * r8);
        double r23 = r13;
        float r16 = (float) (r8 * Math.sin(r9));
        if (r6 == 0.0f) goto L12;
        double r17 = (float) (Math.atan2(r11, r10) - 1.5707963267948966d);
        float r18 = (float) Math.cos(r17);
        float r19 = (float) Math.sin(r17);
        double r20 = (float) (Math.atan2(r16, r15) - 1.5707963267948966d);
        float r21 = (float) Math.cos(r20);
        float r22 = (float) Math.sin(r20);
        float r24 = (r7 * r6) * POLYGON_MAGIC_NUMBER;
        this.path.cubicTo(r10 - (r18 * r24), r11 - (r19 * r24), r15 + (r21 * r24), r16 + (r24 * r22), r15, r16);
    L13:
        r9 = r9 + r12;
        r14 = r14 + 1;
        r11 = r16;
        r10 = r15;
        r13 = r23;
        r8 = r8;
        r12 = r12;
        goto L8
    L12:
        this.path.lineTo(r15, r16);
        goto L13
    L14:
        PointF r25 = this.positionAnimation.getValue();
        this.path.offset(r25.x, r25.y);
        this.path.close();
        return;
    L5:
        r3 = r2.getValue().floatValue();
        goto L6
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
        MiscUtils.resolveKeyPath(r1, r2, r3, r4, this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r2, LottieValueCallback<T> r3) {
        if (r2 != LottieProperty.POLYSTAR_POINTS) goto L6;
        this.pointsAnimation.setValueCallback(r3);
        return;
    L6:
        if (r2 != LottieProperty.POLYSTAR_ROTATION) goto L9;
        this.rotationAnimation.setValueCallback(r3);
        return;
    L9:
        if (r2 != LottieProperty.POSITION) goto L12;
        this.positionAnimation.setValueCallback(r3);
        return;
    L12:
        if (r2 != LottieProperty.POLYSTAR_INNER_RADIUS) goto L17;
        BaseKeyframeAnimation<?, Float> r0 = this.innerRadiusAnimation;
        if (r0 == null) goto L17;
        r0.setValueCallback(r3);
        return;
    L17:
        if (r2 != LottieProperty.POLYSTAR_OUTER_RADIUS) goto L20;
        this.outerRadiusAnimation.setValueCallback(r3);
        return;
    L20:
        if (r2 != LottieProperty.POLYSTAR_INNER_ROUNDEDNESS) goto L25;
        BaseKeyframeAnimation<?, Float> r1 = this.innerRoundednessAnimation;
        if (r1 == null) goto L25;
        r1.setValueCallback(r3);
        return;
    L25:
        if (r2 != LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) goto L34;
        this.outerRoundednessAnimation.setValueCallback(r3);
        return;
    }
}
