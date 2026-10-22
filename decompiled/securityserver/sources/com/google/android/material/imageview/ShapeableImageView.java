package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    private static final int DEF_STYLE_RES = 0;
    private final Paint borderPaint;
    private final Paint clearPaint;
    private final RectF destination;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;

    @Dimension
    private float strokeWidth;

    @TargetApi(21)
    public class OutlineProvider extends ViewOutlineProvider {
        private Rect rect;
        final /* synthetic */ ShapeableImageView this$0;

        public OutlineProvider(ShapeableImageView r1) {
            this.this$0 = r1;
            this.rect = new Rect();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r2, Outline r3) {
            if (ShapeableImageView.access$000(this.this$0) != null) goto L5;
            return;
        L5:
            if (ShapeableImageView.access$000(this.this$0).isRoundRect(ShapeableImageView.access$100(this.this$0)) == false) goto L9;
            ShapeableImageView.access$100(this.this$0).round(this.rect);
            float r4 = ShapeableImageView.access$000(this.this$0).getBottomLeftCornerSize().getCornerSize(ShapeableImageView.access$100(this.this$0));
            r3.setRoundRect(this.rect, r4);
            return;
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
    }

    public ShapeableImageView(Context r3) {
        this(r3, null, 0);
    }

    public static /* synthetic */ ShapeAppearanceModel access$000(ShapeableImageView r0) {
        return r0.shapeAppearanceModel;
    }

    public static /* synthetic */ RectF access$100(ShapeableImageView r0) {
        return r0.destination;
    }

    private void drawStroke(Canvas r4) {
        if (this.strokeColor != null) goto L5;
        return;
    L5:
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int r0 = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth <= 0.0f) goto L10;
        if (r0 == 0) goto L11;
        this.borderPaint.setColor(r0);
        r4.drawPath(this.path, this.borderPaint);
        return;
    L11:
        return;
    }

    private void updateShapeMask(int r6, int r7) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), r6 - getPaddingRight(), r7 - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, r6, r7);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r3) {
        super.onDraw(r3);
        r3.drawPath(this.maskPath, this.clearPaint);
        drawStroke(r3);
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateShapeMask(r1, r2);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel r2) {
        this.shapeAppearanceModel = r2;
        updateShapeMask(getWidth(), getHeight());
        invalidate();
    }

    public void setStrokeColor(@Nullable ColorStateList r1) {
        this.strokeColor = r1;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int r2) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), r2));
    }

    public void setStrokeWidth(@Dimension float r2) {
        if (this.strokeWidth == r2) goto L6;
        this.strokeWidth = r2;
        invalidate();
        return;
    }

    public void setStrokeWidthResource(@DimenRes int r2) {
        setStrokeWidth(getResources().getDimensionPixelSize(r2));
    }

    public ShapeableImageView(Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, 0);
    }

    public ShapeableImageView(Context r6, @Nullable AttributeSet r7, int r8) {
        int r0 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r6, r7, r8, r0), r7, r8);
        this.pathProvider = new ShapeAppearancePathProvider();
        this.path = new Path();
        Context r9 = getContext();
        Paint r1 = new Paint();
        this.clearPaint = r1;
        r1.setAntiAlias(true);
        r1.setColor(-1);
        r1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.destination = new RectF();
        this.maskRect = new RectF();
        this.maskPath = new Path();
        TypedArray r2 = r9.obtainStyledAttributes(r7, R.styleable.ShapeableImageView, r8, r0);
        this.strokeColor = MaterialResources.getColorStateList(r9, r2, R.styleable.ShapeableImageView_strokeColor);
        this.strokeWidth = r2.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        Paint r3 = new Paint();
        this.borderPaint = r3;
        r3.setStyle(Paint.Style.STROKE);
        r3.setAntiAlias(true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(r9, r7, r8, r0).build();
        setOutlineProvider(new OutlineProvider(this));
    }
}
