package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List<BaseKeyframeAnimation<?, ?>> animations;
    final Matrix boundsMatrix;
    private final Paint clearPaint;
    private final Paint contentPaint;
    private final String drawTraceName;
    private final Paint dstInPaint;
    private final Paint dstOutPaint;
    final Layer layerModel;
    final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final Matrix matrix;
    private final RectF matteBoundsRect;
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    private BaseLayer parentLayer;
    private List<BaseLayer> parentLayers;
    private final Path path;
    private final RectF rect;
    private final RectF tempMaskBoundsRect;
    final TransformKeyframeAnimation transform;
    private boolean visible;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.BaseLayer$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = null;
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = null;

        static {
            int[] r0 = new int[Mask.MaskMode.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = r0;
            r0[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L32:
            $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L40:
            $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L50:
            $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L10:
            int[] r4 = new int[Layer.LayerType.values().length];
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = r4;
            r4[Layer.LayerType.SHAPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L34:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.PRE_COMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L38:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.SOLID.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L44:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L30:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L36:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.TEXT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L48:
            $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[Layer.LayerType.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    abstract void drawLayer(Canvas r1, Matrix r2, int r3);

    void resolveChildKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4) {
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> r1, List<Content> r2) {
    }

    static /* synthetic */ void access$000(BaseLayer r0, boolean r1) {
        r0.setVisible(r1);
    }

    static BaseLayer forModel(Layer r2, LottieDrawable r3, LottieComposition r4) {
        switch(AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[r2.getLayerType().ordinal()]) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        Logger.warning("Unknown layer type " + r2.getLayerType());
        return null;
    L7:
        return new TextLayer(r3, r2);
    L9:
        return new NullLayer(r3, r2);
    L11:
        return new ImageLayer(r3, r2);
    L13:
        return new SolidLayer(r3, r2);
    L15:
        return new CompositionLayer(r3, r2, r4.getPrecomps(r2.getRefId()), r4);
    L17:
        return new ShapeLayer(r3, r2);
    }

    BaseLayer(LottieDrawable r5, Layer r6) {
        this.path = new Path();
        this.matrix = new Matrix();
        this.contentPaint = new LPaint(1);
        this.dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
        this.dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
        LPaint r0 = new LPaint(1);
        this.mattePaint = r0;
        this.clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
        this.rect = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.boundsMatrix = new Matrix();
        this.animations = new ArrayList();
        this.visible = true;
        this.lottieDrawable = r5;
        this.layerModel = r6;
        this.drawTraceName = r6.getName() + "#draw";
        if (r6.getMatteType() != Layer.MatteType.INVERT) goto L5;
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    L6:
        TransformKeyframeAnimation r7 = r6.getTransform().createAnimation();
        this.transform = r7;
        r7.addListener(this);
        if (r6.getMasks() != null) goto L9;
    L18:
        setupInOutAnimations();
        return;
    L9:
        if (r6.getMasks().isEmpty() == true) goto L18;
        MaskKeyframeAnimation r8 = new MaskKeyframeAnimation(r6.getMasks());
        this.mask = r8;
        Iterator<BaseKeyframeAnimation<ShapeData, Path>> r9 = r8.getMaskAnimations().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        r9.next().addUpdateListener(this);
        goto L12
    L14:
        Iterator<BaseKeyframeAnimation<Integer, Integer>> r10 = this.mask.getOpacityAnimations().iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        BaseKeyframeAnimation<Integer, Integer> r11 = r10.next();
        addAnimation(r11);
        r11.addUpdateListener(this);
        goto L16
    L5:
        r0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        goto L6
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        invalidateSelf();
    }

    Layer getLayerModel() {
        return this.layerModel;
    }

    void setMatteLayer(BaseLayer r1) {
        this.matteLayer = r1;
    }

    boolean hasMatteOnThisLayer() {
        if (this.matteLayer == null) goto L5;
        return true;
    L5:
        return false;
    }

    void setParentLayer(BaseLayer r1) {
        this.parentLayer = r1;
    }

    private void setupInOutAnimations() {
        boolean r1 = true;
        if (this.layerModel.getInOutKeyframes().isEmpty() == true) goto L9;
        final FloatKeyframeAnimation r0 = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
        r0.setIsDiscrete();
        r0.addUpdateListener(new AnonymousClass1(this, r0));
        if (r0.getValue().floatValue() == 1.0f) goto L8;
        r1 = false;
    L8:
        setVisible(r1);
        addAnimation(r0);
        return;
    L9:
        setVisible(true);
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.animations.add(r1);
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> r1) {
        this.animations.remove(r1);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF r2, Matrix r3, boolean r4) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        buildParentLayerListIfNeeded();
        this.boundsMatrix.set(r3);
        if (r4 == false) goto L12;
        List<BaseLayer> r5 = this.parentLayers;
        if (r5 == null) goto L9;
        int r6 = r5.size() - 1;
    L7:
        if (r6 < 0) goto L12;
        this.boundsMatrix.preConcat(this.parentLayers.get(r6).transform.getMatrix());
        r6 = r6 - 1;
        goto L7
    L9:
        BaseLayer r7 = this.parentLayer;
        if (r7 == null) goto L12;
        this.boundsMatrix.preConcat(r7.transform.getMatrix());
    L12:
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas r7, Matrix r8, int r9) {
        L.beginSection(this.drawTraceName);
        if (this.visible == true) goto L5;
    L34:
        L.endSection(this.drawTraceName);
        return;
    L5:
        if (this.layerModel.isHidden() == true) goto L34;
        buildParentLayerListIfNeeded();
        L.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(r8);
        int r1 = this.parentLayers.size() - 1;
    L8:
        if (r1 < 0) goto L10;
        this.matrix.preConcat(this.parentLayers.get(r1).transform.getMatrix());
        r1 = r1 - 1;
        goto L8
    L10:
        L.endSection("Layer#parentMatrix");
        if (this.transform.getOpacity() != null) goto L13;
        int r0 = 100;
    L14:
        int r10 = (int) ((((r9 / 255.0f) * r0) / 100.0f) * 255.0f);
        if (hasMatteOnThisLayer() == false) goto L17;
    L20:
        L.beginSection("Layer#computeBounds");
        getBounds(this.rect, this.matrix, false);
        intersectBoundsWithMatte(this.rect, r8);
        this.matrix.preConcat(this.transform.getMatrix());
        intersectBoundsWithMask(this.rect, this.matrix);
        if (this.rect.intersect(0.0f, 0.0f, r7.getWidth(), r7.getHeight()) == true) goto L23;
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
    L23:
        L.endSection("Layer#computeBounds");
        if (this.rect.isEmpty() == true) goto L32;
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(r7, this.rect, this.contentPaint);
        L.endSection("Layer#saveLayer");
        clearCanvas(r7);
        L.beginSection("Layer#drawLayer");
        drawLayer(r7, this.matrix, r10);
        L.endSection("Layer#drawLayer");
        if (hasMasksOnThisLayer() == false) goto L29;
        applyMasks(r7, this.matrix);
    L29:
        if (hasMatteOnThisLayer() == false) goto L31;
        L.beginSection("Layer#drawMatte");
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(r7, this.rect, this.mattePaint, 19);
        L.endSection("Layer#saveLayer");
        clearCanvas(r7);
        this.matteLayer.draw(r7, r8, r10);
        L.beginSection("Layer#restoreLayer");
        r7.restore();
        L.endSection("Layer#restoreLayer");
        L.endSection("Layer#drawMatte");
    L31:
        L.beginSection("Layer#restoreLayer");
        r7.restore();
        L.endSection("Layer#restoreLayer");
    L32:
        recordRenderTime(L.endSection(this.drawTraceName));
        return;
    L17:
        if (hasMasksOnThisLayer() == true) goto L20;
        this.matrix.preConcat(this.transform.getMatrix());
        L.beginSection("Layer#drawLayer");
        drawLayer(r7, this.matrix, r10);
        L.endSection("Layer#drawLayer");
        recordRenderTime(L.endSection(this.drawTraceName));
        return;
    L13:
        r0 = this.transform.getOpacity().getValue().intValue();
        goto L14
    }

    private void recordRenderTime(float r2) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), r2);
    }

    private void clearCanvas(Canvas r10) {
        L.beginSection("Layer#clearLayer");
        r10.drawRect(this.rect.left - 1.0f, this.rect.top - 1.0f, this.rect.right + 1.0f, this.rect.bottom + 1.0f, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    private void intersectBoundsWithMask(RectF r11, Matrix r12) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (hasMasksOnThisLayer() == true) goto L5;
        return;
    L5:
        int r0 = this.mask.getMasks().size();
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L26;
        Mask r4 = this.mask.getMasks().get(r3);
        this.path.set(this.mask.getMaskAnimations().get(r3).getValue());
        this.path.transform(r12);
        int r5 = AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[r4.getMaskMode().ordinal()];
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L35;
        if (r5 == 3) goto L17;
        if (r5 == 4) goto L17;
    L19:
        this.path.computeBounds(this.tempMaskBoundsRect, false);
        if (r3 != 0) goto L22;
        this.maskBoundsRect.set(this.tempMaskBoundsRect);
    L23:
        r3 = r3 + 1;
        goto L6
    L22:
        RectF r6 = this.maskBoundsRect;
        r6.set(Math.min(r6.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
    L17:
        if (r4.isInverted() == false) goto L19;
        return;
    L35:
        return;
    L24:
        return;
    L26:
        if (r11.intersect(this.maskBoundsRect) == true) goto L36;
        r11.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    }

    private void intersectBoundsWithMatte(RectF r5, Matrix r6) {
        if (hasMatteOnThisLayer() == true) goto L6;
        return;
    L6:
        if (this.layerModel.getMatteType() != Layer.MatteType.INVERT) goto L8;
        return;
    L8:
        this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.matteLayer.getBounds(this.matteBoundsRect, r6, true);
        if (r5.intersect(this.matteBoundsRect) == true) goto L12;
        r5.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    }

    private void applyMasks(Canvas r9, Matrix r10) {
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(r9, this.rect, this.dstInPaint, 19);
        L.endSection("Layer#saveLayer");
        int r0 = 0;
    L4:
        if (r0 >= this.mask.getMasks().size()) goto L32;
        Mask r5 = this.mask.getMasks().get(r0);
        BaseKeyframeAnimation<ShapeData, Path> r6 = this.mask.getMaskAnimations().get(r0);
        BaseKeyframeAnimation<Integer, Integer> r7 = this.mask.getOpacityAnimations().get(r0);
        int r1 = AnonymousClass2.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[r5.getMaskMode().ordinal()];
        if (r1 == 1) goto L29;
        if (r1 != 2) goto L10;
        if (r0 != 0) goto L25;
        this.contentPaint.setColor(-16777216);
        this.contentPaint.setAlpha(255);
        r9.drawRect(this.rect, this.contentPaint);
    L25:
        if (r5.isInverted() == false) goto L27;
        applyInvertedSubtractMask(r9, r10, r5, r6, r7);
    L31:
        r0 = r0 + 1;
        goto L4
    L27:
        applySubtractMask(r9, r10, r5, r6, r7);
        goto L31
    L10:
        if (r1 == 3) goto L19;
        if (r1 != 4) goto L31;
        if (r5.isInverted() == false) goto L17;
        applyInvertedAddMask(r9, r10, r5, r6, r7);
        goto L31
    L17:
        applyAddMask(r9, r10, r5, r6, r7);
        goto L31
    L19:
        if (r5.isInverted() == false) goto L21;
        applyInvertedIntersectMask(r9, r10, r5, r6, r7);
        goto L31
    L21:
        applyIntersectMask(r9, r10, r5, r6, r7);
        goto L31
    L29:
        if (areAllMasksNone() == false) goto L31;
        this.contentPaint.setAlpha(255);
        r9.drawRect(this.rect, this.contentPaint);
        goto L31
    L32:
        L.beginSection("Layer#restoreLayer");
        r9.restore();
        L.endSection("Layer#restoreLayer");
    }

    private boolean areAllMasksNone() {
        if (this.mask.getMaskAnimations().isEmpty() == false) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mask.getMasks().size()) goto L12;
        if (this.mask.getMasks().get(r0).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private void applyAddMask(Canvas r1, Matrix r2, Mask r3, BaseKeyframeAnimation<ShapeData, Path> r4, BaseKeyframeAnimation<Integer, Integer> r5) {
        this.path.set(r4.getValue());
        this.path.transform(r2);
        this.contentPaint.setAlpha((int) (r5.getValue().intValue() * 2.55f));
        r1.drawPath(this.path, this.contentPaint);
    }

    private void applyInvertedAddMask(Canvas r2, Matrix r3, Mask r4, BaseKeyframeAnimation<ShapeData, Path> r5, BaseKeyframeAnimation<Integer, Integer> r6) {
        Utils.saveLayerCompat(r2, this.rect, this.contentPaint);
        r2.drawRect(this.rect, this.contentPaint);
        this.path.set(r5.getValue());
        this.path.transform(r3);
        this.contentPaint.setAlpha((int) (r6.getValue().intValue() * 2.55f));
        r2.drawPath(this.path, this.dstOutPaint);
        r2.restore();
    }

    private void applySubtractMask(Canvas r1, Matrix r2, Mask r3, BaseKeyframeAnimation<ShapeData, Path> r4, BaseKeyframeAnimation<Integer, Integer> r5) {
        Path r6 = r4.getValue();
        this.path.set(r6);
        this.path.transform(r2);
        r1.drawPath(this.path, this.dstOutPaint);
    }

    private void applyInvertedSubtractMask(Canvas r2, Matrix r3, Mask r4, BaseKeyframeAnimation<ShapeData, Path> r5, BaseKeyframeAnimation<Integer, Integer> r6) {
        Utils.saveLayerCompat(r2, this.rect, this.dstOutPaint);
        r2.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (r6.getValue().intValue() * 2.55f));
        this.path.set(r5.getValue());
        this.path.transform(r3);
        r2.drawPath(this.path, this.dstOutPaint);
        r2.restore();
    }

    private void applyIntersectMask(Canvas r2, Matrix r3, Mask r4, BaseKeyframeAnimation<ShapeData, Path> r5, BaseKeyframeAnimation<Integer, Integer> r6) {
        Utils.saveLayerCompat(r2, this.rect, this.dstInPaint);
        this.path.set(r5.getValue());
        this.path.transform(r3);
        this.contentPaint.setAlpha((int) (r6.getValue().intValue() * 2.55f));
        r2.drawPath(this.path, this.contentPaint);
        r2.restore();
    }

    private void applyInvertedIntersectMask(Canvas r2, Matrix r3, Mask r4, BaseKeyframeAnimation<ShapeData, Path> r5, BaseKeyframeAnimation<Integer, Integer> r6) {
        Utils.saveLayerCompat(r2, this.rect, this.dstInPaint);
        r2.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (r6.getValue().intValue() * 2.55f));
        this.path.set(r5.getValue());
        this.path.transform(r3);
        r2.drawPath(this.path, this.dstOutPaint);
        r2.restore();
    }

    boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation r0 = this.mask;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getMaskAnimations().isEmpty() == true) goto L7;
        return true;
    }

    private void setVisible(boolean r2) {
        if (r2 == this.visible) goto L6;
        this.visible = r2;
        invalidateSelf();
        return;
    }

    void setProgress(float r4) {
        this.transform.setProgress(r4);
        int r1 = 0;
        if (this.mask == null) goto L9;
        int r0 = 0;
    L6:
        if (r0 >= this.mask.getMaskAnimations().size()) goto L9;
        this.mask.getMaskAnimations().get(r0).setProgress(r4);
        r0 = r0 + 1;
    L9:
        if (this.layerModel.getTimeStretch() == 0.0f) goto L11;
        r4 = r4 / this.layerModel.getTimeStretch();
    L11:
        BaseLayer r2 = this.matteLayer;
        if (r2 == null) goto L15;
        this.matteLayer.setProgress(r2.layerModel.getTimeStretch() * r4);
    L15:
        if (r1 >= this.animations.size()) goto L17;
        this.animations.get(r1).setProgress(r4);
        r1 = r1 + 1;
        goto L15
    }

    private void buildParentLayerListIfNeeded() {
        if (this.parentLayers == null) goto L6;
        return;
    L6:
        if (this.parentLayer != null) goto L9;
        this.parentLayers = Collections.emptyList();
        return;
    L9:
        this.parentLayers = new ArrayList();
        BaseLayer r0 = this.parentLayer;
    L10:
        if (r0 == null) goto L12;
        this.parentLayers.add(r0);
        r0 = r0.parentLayer;
        goto L10
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.layerModel.getName();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath r3, int r4, List<KeyPath> r5, KeyPath r6) {
        if (r3.matches(getName(), r4) == true) goto L6;
        return;
    L6:
        if ("__container".equals(getName()) == true) goto L11;
        r6 = r6.addKey(getName());
        if (r3.fullyResolvesTo(getName(), r4) == false) goto L11;
        r5.add(r6.resolve(this));
    L11:
        if (r3.propagateToChildren(getName(), r4) == false) goto L14;
        resolveChildKeyPath(r3, r4 + r3.incrementDepthBy(getName(), r4), r5, r6);
        return;
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T r1, LottieValueCallback<T> r2) {
        this.transform.applyValueCallback(r1, r2);
    }
}
