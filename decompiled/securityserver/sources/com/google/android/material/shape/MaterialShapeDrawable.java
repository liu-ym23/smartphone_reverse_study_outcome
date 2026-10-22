package com.google.android.material.shape;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private static final String TAG = "MaterialShapeDrawable";
    private static final Paint clearPaint = null;
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    private MaterialShapeDrawableState drawableState;
    private final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private final Matrix matrix;
    private final Path path;

    @NonNull
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;

    @NonNull
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private final Paint strokePaint;
    private ShapeAppearanceModel strokeShapeAppearance;

    @Nullable
    private PorterDuffColorFilter strokeTintFilter;

    @Nullable
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CompatibilityShadowMode {
    }

    public static final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;

        @Nullable
        public ColorFilter colorFilter;
        public float elevation;

        @Nullable
        public ElevationOverlayProvider elevationOverlayProvider;

        @Nullable
        public ColorStateList fillColor;
        public float interpolation;

        @Nullable
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public int shadowCompatRotation;

        @NonNull
        public ShapeAppearanceModel shapeAppearanceModel;

        @Nullable
        public ColorStateList strokeColor;

        @Nullable
        public ColorStateList strokeTintList;
        public float strokeWidth;

        @Nullable
        public ColorStateList tintList;

        @Nullable
        public PorterDuff.Mode tintMode;
        public float translationZ;
        public boolean useTintColorForShadow;

        public MaterialShapeDrawableState(ShapeAppearanceModel r3, ElevationOverlayProvider r4) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r3;
            this.elevationOverlayProvider = r4;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            MaterialShapeDrawable r0 = new MaterialShapeDrawable(this, null);
            MaterialShapeDrawable.access$402(r0, true);
            return r0;
        }

        public MaterialShapeDrawableState(@NonNull MaterialShapeDrawableState r3) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = r3.shapeAppearanceModel;
            this.elevationOverlayProvider = r3.elevationOverlayProvider;
            this.strokeWidth = r3.strokeWidth;
            this.colorFilter = r3.colorFilter;
            this.fillColor = r3.fillColor;
            this.strokeColor = r3.strokeColor;
            this.tintMode = r3.tintMode;
            this.tintList = r3.tintList;
            this.alpha = r3.alpha;
            this.scale = r3.scale;
            this.shadowCompatOffset = r3.shadowCompatOffset;
            this.shadowCompatMode = r3.shadowCompatMode;
            this.useTintColorForShadow = r3.useTintColorForShadow;
            this.interpolation = r3.interpolation;
            this.parentAbsoluteElevation = r3.parentAbsoluteElevation;
            this.elevation = r3.elevation;
            this.translationZ = r3.translationZ;
            this.shadowCompatRadius = r3.shadowCompatRadius;
            this.shadowCompatRotation = r3.shadowCompatRotation;
            this.strokeTintList = r3.strokeTintList;
            this.paintStyle = r3.paintStyle;
            if (r3.padding == null) goto L6;
            this.padding = new Rect(r3.padding);
            return;
        }
    }

    static {
        clearPaint = new Paint(1);
    }

    public /* synthetic */ MaterialShapeDrawable(MaterialShapeDrawableState r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static /* synthetic */ BitSet access$000(MaterialShapeDrawable r0) {
        return r0.containsIncompatibleShadowOp;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$100(MaterialShapeDrawable r0) {
        return r0.cornerShadowOperation;
    }

    public static /* synthetic */ ShapePath.ShadowCompatOperation[] access$200(MaterialShapeDrawable r0) {
        return r0.edgeShadowOperation;
    }

    public static /* synthetic */ boolean access$402(MaterialShapeDrawable r0, boolean r1) {
        r0.pathDirty = r1;
        return r1;
    }

    @Nullable
    private PorterDuffColorFilter calculatePaintColorTintFilter(@NonNull Paint r1, boolean r2) {
        if (r2 == false) goto L7;
        int r3 = r1.getColor();
        int r0 = compositeElevationOverlayIfNeeded(r3);
        if (r0 != r3) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r0, PorterDuff.Mode.SRC_IN);
    L7:
        return null;
    }

    private void calculatePath(@NonNull RectF r5, @NonNull Path r6) {
        calculatePathForSize(r5, r6);
        if (this.drawableState.scale == 1.0f) goto L5;
        this.matrix.reset();
        Matrix r0 = this.matrix;
        float r1 = this.drawableState.scale;
        r0.setScale(r1, r1, r5.width() / 2.0f, r5.height() / 2.0f);
        r6.transform(this.matrix);
    L5:
        r6.computeBounds(this.pathBounds, true);
    }

    private void calculateStrokePath() {
        final float r0 = -getStrokeInsetLength();
        ShapeAppearanceModel r1 = getShapeAppearanceModel().withTransformedCornerSizes(new AnonymousClass2(this, r0));
        this.strokeShapeAppearance = r1;
        this.pathProvider.calculatePath(r1, this.drawableState.interpolation, getBoundsInsetByStroke(), this.pathInsetByStroke);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintColorTintFilter(@NonNull ColorStateList r3, @NonNull PorterDuff.Mode r4, boolean r5) {
        int r6 = r3.getColorForState(getState(), 0);
        if (r5 == false) goto L6;
        r6 = compositeElevationOverlayIfNeeded(r6);
    L6:
        return new PorterDuffColorFilter(r6, r4);
    }

    @NonNull
    private PorterDuffColorFilter calculateTintFilter(@Nullable ColorStateList r1, @Nullable PorterDuff.Mode r2, @NonNull Paint r3, boolean r4) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return calculateTintColorTintFilter(r1, r2, r4);
    L7:
        return calculatePaintColorTintFilter(r3, r4);
    }

    @ColorInt
    private int compositeElevationOverlayIfNeeded(@ColorInt int r3) {
        float r0 = getZ();
        float r1 = getParentAbsoluteElevation() + r0;
        ElevationOverlayProvider r2 = this.drawableState.elevationOverlayProvider;
        if (r2 != null) goto L5;
        return r3;
    L5:
        return r2.compositeOverlayIfNeeded(r3, r1);
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r1) {
        return createWithElevationOverlay(r1, 0.0f);
    }

    private void drawCompatShadow(@NonNull Canvas r5) {
        if (this.containsIncompatibleShadowOp.cardinality() <= 0) goto L6;
        Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
    L6:
        if (this.drawableState.shadowCompatOffset == 0) goto L8;
        r5.drawPath(this.path, this.shadowRenderer.getShadowPaint());
    L8:
        int r0 = 0;
    L10:
        if (r0 >= 4) goto L13;
        this.cornerShadowOperation[r0].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        this.edgeShadowOperation[r0].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, r5);
        r0 = r0 + 1;
        goto L10
    L13:
        if (this.shadowBitmapDrawingEnable == false) goto L17;
        int r1 = getShadowOffsetX();
        int r2 = getShadowOffsetY();
        r5.translate(-r1, -r2);
        r5.drawPath(this.path, clearPaint);
        r5.translate(r1, r2);
        return;
    }

    private void drawFillShape(@NonNull Canvas r7) {
        drawShape(r7, this.fillPaint, this.path, this.drawableState.shapeAppearanceModel, getBoundsAsRectF());
    }

    private void drawStrokeShape(@NonNull Canvas r7) {
        drawShape(r7, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearance, getBoundsInsetByStroke());
    }

    @NonNull
    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float r0 = getStrokeInsetLength();
        this.insetRectF.inset(r0, r0);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke() == true) goto L5;
        return 0.0f;
    L5:
        return this.strokePaint.getStrokeWidth() / 2.0f;
    }

    private boolean hasCompatShadow() {
        MaterialShapeDrawableState r0 = this.drawableState;
        int r1 = r0.shadowCompatMode;
        if (r1 != 1) goto L5;
    L11:
        return false;
    L5:
        if (r0.shadowCompatRadius <= 0) goto L11;
        if (r1 != 2) goto L9;
        return true;
    L9:
        if (requiresCompatShadow() == false) goto L11;
        return true;
    }

    private boolean hasFill() {
        Paint.Style r1 = this.drawableState.paintStyle;
        if (r1 != Paint.Style.FILL_AND_STROKE) goto L5;
    L8:
        return true;
    L5:
        if (r1 == Paint.Style.FILL) goto L8;
        return false;
    }

    private boolean hasStroke() {
        Paint.Style r0 = this.drawableState.paintStyle;
        if (r0 == Paint.Style.FILL_AND_STROKE) goto L7;
        if (r0 == Paint.Style.STROKE) goto L7;
    L9:
        return false;
    L7:
        if (this.strokePaint.getStrokeWidth() <= 0.0f) goto L9;
        return true;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private void maybeDrawCompatShadow(@NonNull Canvas r7) {
        if (hasCompatShadow() == true) goto L5;
        return;
    L5:
        r7.save();
        prepareCanvasForShadow(r7);
        if (this.shadowBitmapDrawingEnable == true) goto L9;
        drawCompatShadow(r7);
        r7.restore();
        return;
    L9:
        int r0 = (int) (this.pathBounds.width() - getBounds().width());
        int r1 = (int) (this.pathBounds.height() - getBounds().height());
        if (r0 < 0) goto L15;
        if (r1 < 0) goto L15;
        Bitmap r2 = Bitmap.createBitmap(((this.drawableState.shadowCompatRadius * 2) + ((int) this.pathBounds.width())) + r0, ((this.drawableState.shadowCompatRadius * 2) + ((int) this.pathBounds.height())) + r1, Bitmap.Config.ARGB_8888);
        Canvas r3 = new Canvas(r2);
        float r4 = (getBounds().left - this.drawableState.shadowCompatRadius) - r0;
        float r5 = (getBounds().top - this.drawableState.shadowCompatRadius) - r1;
        r3.translate(-r4, -r5);
        drawCompatShadow(r3);
        r7.drawBitmap(r2, r4, r5, null);
        r2.recycle();
        r7.restore();
        return;
    L15:
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int modulateAlpha(int r1, int r2) {
        return ((r2 + (r2 >>> 7)) * r1) >>> 8;
    }

    private void prepareCanvasForShadow(@NonNull Canvas r2) {
        r2.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private boolean updateColorsForState(int[] r5) {
        if (this.drawableState.fillColor == null) goto L7;
        int r0 = this.fillPaint.getColor();
        int r2 = this.drawableState.fillColor.getColorForState(r5, r0);
        if (r0 == r2) goto L7;
        this.fillPaint.setColor(r2);
        boolean r1 = true;
    L9:
        if (this.drawableState.strokeColor == null) goto L14;
        int r3 = this.strokePaint.getColor();
        int r6 = this.drawableState.strokeColor.getColorForState(r5, r3);
        if (r3 == r6) goto L14;
        this.strokePaint.setColor(r6);
        return true;
    L14:
        return r1;
    L7:
        r1 = false;
        goto L9
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter r0 = this.tintFilter;
        PorterDuffColorFilter r1 = this.strokeTintFilter;
        MaterialShapeDrawableState r2 = this.drawableState;
        this.tintFilter = calculateTintFilter(r2.tintList, r2.tintMode, this.fillPaint, true);
        MaterialShapeDrawableState r3 = this.drawableState;
        this.strokeTintFilter = calculateTintFilter(r3.strokeTintList, r3.tintMode, this.strokePaint, false);
        MaterialShapeDrawableState r4 = this.drawableState;
        if (r4.useTintColorForShadow == false) goto L6;
        this.shadowRenderer.setShadowColor(r4.tintList.getColorForState(getState(), 0));
    L6:
        if (ObjectsCompat.equals(r0, this.tintFilter) == true) goto L8;
        return true;
    L8:
        if (ObjectsCompat.equals(r1, this.strokeTintFilter) == true) goto L11;
        return true;
    L11:
        return false;
    }

    private void updateZ() {
        float r0 = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil(SHADOW_RADIUS_MULTIPLIER * r0);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(r0 * SHADOW_OFFSET_MULTIPLIER);
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void calculatePathForSize(@NonNull RectF r7, @NonNull Path r8) {
        ShapeAppearancePathProvider r0 = this.pathProvider;
        MaterialShapeDrawableState r1 = this.drawableState;
        r0.calculatePath(r1.shapeAppearanceModel, r1.interpolation, r7, this.pathShadowListener, r8);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r5) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int r0 = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(r0, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int r1 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(r1, this.drawableState.alpha));
        if (this.pathDirty == false) goto L5;
        calculateStrokePath();
        calculatePath(getBoundsAsRectF(), this.path);
        this.pathDirty = false;
    L5:
        maybeDrawCompatShadow(r5);
        if (hasFill() == false) goto L9;
        drawFillShape(r5);
    L9:
        if (hasStroke() == false) goto L11;
        drawStrokeShape(r5);
    L11:
        this.fillPaint.setAlpha(r0);
        this.strokePaint.setAlpha(r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void drawShape(@NonNull Canvas r8, @NonNull Paint r9, @NonNull Path r10, @NonNull RectF r11) {
        drawShape(r8, r9, r10, this.drawableState.shapeAppearanceModel, r11);
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    @NonNull
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    @Nullable
    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline r3) {
        if (this.drawableState.shadowCompatMode != 2) goto L6;
        return;
    L6:
        if (isRoundRect() == false) goto L9;
        float r0 = getTopLeftCornerResolvedSize() * this.drawableState.interpolation;
        r3.setRoundRect(getBounds(), r0);
        return;
    L9:
        calculatePath(getBoundsAsRectF(), this.path);
        this.path.isConvex();
        r3.setConvexPath(this.path);     // Catch: IllegalArgumentException -> L12
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect r2) {
        Rect r0 = this.drawableState.padding;
        if (r0 == null) goto L7;
        r2.set(r0);
        return true;
    L7:
        return super.getPadding(r2);
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    @Deprecated
    public void getPathForSize(int r3, int r4, @NonNull Path r5) {
        calculatePathForSize(new RectF(0.0f, 0.0f, r3, r4), r5);
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        MaterialShapeDrawableState r4 = this.drawableState;
        return (int) (Math.sin(Math.toRadians(r4.shadowCompatRotation)) * r4.shadowCompatOffset);
    }

    public int getShadowOffsetY() {
        MaterialShapeDrawableState r4 = this.drawableState;
        return (int) (Math.cos(Math.toRadians(r4.shadowCompatRotation)) * r4.shadowCompatOffset);
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearanceModel;
    }

    @Nullable
    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel r1 = getShapeAppearanceModel();
        if ((r1 instanceof ShapePathModel) == true) goto L7;
        return null;
    L7:
        return (ShapePathModel) r1;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    @Nullable
    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    @Nullable
    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.drawableState.shapeAppearanceModel.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect r0 = getBounds();
        this.transparentRegion.set(r0);
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        float r0 = getElevation();
        return getTranslationZ() + r0;
    }

    public void initializeElevationOverlay(Context r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        r0.elevationOverlayProvider = new ElevationOverlayProvider(r3);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        ElevationOverlayProvider r0 = this.drawableState.elevationOverlayProvider;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isThemeElevationOverlayEnabled() == false) goto L7;
        return true;
    }

    public boolean isElevationOverlayInitialized() {
        if (this.drawableState.elevationOverlayProvider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPointInTransparentRegion(int r1, int r2) {
        return getTransparentRegion().contains(r1, r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect() {
        return this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF());
    }

    @Deprecated
    public boolean isShadowEnabled() {
        int r1 = this.drawableState.shadowCompatMode;
        if (r1 != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 2) goto L8;
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful() == true) goto L22;
        ColorStateList r0 = this.drawableState.tintList;
        if (r0 != null) goto L7;
    L8:
        ColorStateList r1 = this.drawableState.strokeTintList;
        if (r1 != null) goto L11;
    L12:
        ColorStateList r2 = this.drawableState.strokeColor;
        if (r2 != null) goto L15;
    L16:
        ColorStateList r3 = this.drawableState.fillColor;
        if (r3 != null) goto L19;
    L21:
        return false;
    L19:
        if (r3.isStateful() == false) goto L21;
    L15:
        if (r2.isStateful() == true) goto L22;
    L11:
        if (r1.isStateful() == true) goto L22;
    L7:
        if (r0.isStateful() == false) goto L8;
    L22:
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        this.pathDirty = true;
        super.onBoundsChange(r2);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r2) {
        boolean r3 = updateColorsForState(r2);
        boolean r0 = updateTintFilter();
        if (r3 == true) goto L7;
        if (r0 == true) goto L7;
        boolean r4 = false;
    L8:
        if (r4 == false) goto L10;
        invalidateSelf();
    L10:
        return r4;
    L7:
        r4 = true;
        goto L8
    }

    public boolean requiresCompatShadow() {
        if (isRoundRect() == true) goto L7;
        this.path.isConvex();
        return false;
    L7:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.alpha == r3) goto L6;
        r0.alpha = r3;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r2) {
        this.drawableState.colorFilter = r2;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float r2) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r2));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEdgeIntersectionCheckEnable(boolean r1) {
        this.pathProvider.setEdgeIntersectionCheckEnable(r1);
    }

    public void setElevation(float r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.elevation == r3) goto L6;
        r0.elevation = r3;
        updateZ();
        return;
    }

    public void setFillColor(@Nullable ColorStateList r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.fillColor == r3) goto L6;
        r0.fillColor = r3;
        onStateChange(getState());
        return;
    }

    public void setInterpolation(float r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.interpolation == r3) goto L6;
        r0.interpolation = r3;
        this.pathDirty = true;
        invalidateSelf();
        return;
    }

    public void setPadding(int r3, int r4, int r5, int r6) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.padding != null) goto L5;
        r0.padding = new Rect();
    L5:
        this.drawableState.padding.set(r3, r4, r5, r6);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style r2) {
        this.drawableState.paintStyle = r2;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.parentAbsoluteElevation == r3) goto L6;
        r0.parentAbsoluteElevation = r3;
        updateZ();
        return;
    }

    public void setScale(float r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.scale == r3) goto L6;
        r0.scale = r3;
        invalidateSelf();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowBitmapDrawingEnable(boolean r1) {
        this.shadowBitmapDrawingEnable = r1;
    }

    public void setShadowColor(int r2) {
        this.shadowRenderer.setShadowColor(r2);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.shadowCompatRotation == r3) goto L6;
        r0.shadowCompatRotation = r3;
        invalidateSelfIgnoreShape();
        return;
    }

    public void setShadowCompatibilityMode(int r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.shadowCompatMode == r3) goto L6;
        r0.shadowCompatMode = r3;
        invalidateSelfIgnoreShape();
        return;
    }

    @Deprecated
    public void setShadowElevation(int r1) {
        setElevation(r1);
    }

    @Deprecated
    public void setShadowEnabled(boolean r1) {
        setShadowCompatibilityMode(!r1 ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int r1) {
        this.drawableState.shadowCompatRadius = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowVerticalOffset(int r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.shadowCompatOffset == r3) goto L6;
        r0.shadowCompatOffset = r3;
        invalidateSelfIgnoreShape();
        return;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r2) {
        this.drawableState.shapeAppearanceModel = r2;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(@NonNull ShapePathModel r1) {
        setShapeAppearanceModel(r1);
    }

    public void setStroke(float r1, @ColorInt int r2) {
        setStrokeWidth(r1);
        setStrokeColor(ColorStateList.valueOf(r2));
    }

    public void setStrokeColor(@Nullable ColorStateList r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.strokeColor == r3) goto L6;
        r0.strokeColor = r3;
        onStateChange(getState());
        return;
    }

    public void setStrokeTint(ColorStateList r2) {
        this.drawableState.strokeTintList = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float r2) {
        this.drawableState.strokeWidth = r2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int r1) {
        setTintList(ColorStateList.valueOf(r1));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList r2) {
        this.drawableState.tintList = r2;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.tintMode == r3) goto L6;
        r0.tintMode = r3;
        updateTintFilter();
        invalidateSelfIgnoreShape();
        return;
    }

    public void setTranslationZ(float r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.translationZ == r3) goto L6;
        r0.translationZ = r3;
        updateZ();
        return;
    }

    public void setUseTintColorForShadow(boolean r3) {
        MaterialShapeDrawableState r0 = this.drawableState;
        if (r0.useTintColorForShadow == r3) goto L6;
        r0.useTintColorForShadow = r3;
        invalidateSelf();
        return;
    }

    public void setZ(float r2) {
        setTranslationZ(r2 - getElevation());
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    @NonNull
    public static MaterialShapeDrawable createWithElevationOverlay(Context r2, float r3) {
        int r0 = MaterialColors.getColor(r2, R.attr.colorSurface, "MaterialShapeDrawable");
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r1.initializeElevationOverlay(r2);
        r1.setFillColor(ColorStateList.valueOf(r0));
        r1.setElevation(r3);
        return r1;
    }

    private void drawShape(@NonNull Canvas r2, @NonNull Paint r3, @NonNull Path r4, @NonNull ShapeAppearanceModel r5, @NonNull RectF r6) {
        if (r5.isRoundRect(r6) == false) goto L5;
        float r7 = r5.getTopRightCornerSize().getCornerSize(r6) * this.drawableState.interpolation;
        r2.drawRoundRect(r6, r7, r7, r3);
        return;
    L5:
        r2.drawPath(r4, r3);
    }

    public void setCornerSize(@NonNull CornerSize r2) {
        setShapeAppearanceModel(this.drawableState.shapeAppearanceModel.withCornerSize(r2));
    }

    public MaterialShapeDrawable(@NonNull Context r1, @Nullable AttributeSet r2, @AttrRes int r3, @StyleRes int r4) {
        this(ShapeAppearanceModel.builder(r1, r2, r3, r4).build());
    }

    public void setStroke(float r1, @Nullable ColorStateList r2) {
        setStrokeWidth(r1);
        setStrokeColor(r2);
    }

    @Deprecated
    public MaterialShapeDrawable(@NonNull ShapePathModel r1) {
        this(r1);
    }

    public void setStrokeTint(@ColorInt int r1) {
        setStrokeTint(ColorStateList.valueOf(r1));
    }

    public MaterialShapeDrawable(@NonNull ShapeAppearanceModel r3) {
        this(new MaterialShapeDrawableState(r3, null));
    }

    private MaterialShapeDrawable(@NonNull MaterialShapeDrawableState r5) {
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint r0 = new Paint(1);
        this.fillPaint = r0;
        Paint r2 = new Paint(1);
        this.strokePaint = r2;
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = new ShapeAppearancePathProvider();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = r5;
        r2.setStyle(Paint.Style.STROKE);
        r0.setStyle(Paint.Style.FILL);
        Paint r6 = clearPaint;
        r6.setColor(-1);
        r6.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass1(this);
    }
}
