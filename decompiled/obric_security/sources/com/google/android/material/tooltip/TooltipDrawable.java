package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

/* JADX INFO: loaded from: classes2.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int DEFAULT_STYLE = 0;
    private static final int DEFAULT_THEME_ATTR = 0;
    private int arrowSize;
    private final View.OnLayoutChangeListener attachedViewLayoutChangeListener;
    private final Context context;
    private final Rect displayFrame;
    private final Paint.FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    static /* synthetic */ void access$000(TooltipDrawable r0, View r1) {
        r0.updateLocationOnScreen(r1);
    }

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Tooltip;
        DEFAULT_THEME_ATTR = R.attr.tooltipStyle;
    }

    public static TooltipDrawable createFromAttributes(Context r1, AttributeSet r2, int r3, int r4) {
        TooltipDrawable r0 = new TooltipDrawable(r1, r2, r3, r4);
        r0.loadFromAttributes(r2, r3, r4);
        return r0;
    }

    public static TooltipDrawable createFromAttributes(Context r2, AttributeSet r3) {
        return createFromAttributes(r2, r3, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static TooltipDrawable create(Context r3) {
        return createFromAttributes(r3, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    private TooltipDrawable(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.fontMetrics = new Paint.FontMetrics();
        TextDrawableHelper r5 = new TextDrawableHelper(this);
        this.textDrawableHelper = r5;
        this.attachedViewLayoutChangeListener = new AnonymousClass1(this);
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1.0f;
        this.tooltipScaleY = 1.0f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1.0f;
        this.context = r1;
        TextPaint r0 = r5.getTextPaint();
        r0.density = r1.getResources().getDisplayMetrics().density;
        r5.getTextPaint().setTextAlign(Paint.Align.CENTER);
    }

    private void loadFromAttributes(AttributeSet r8, int r9, int r10) {
        TypedArray r11 = ThemeEnforcement.obtainStyledAttributes(this.context, r8, R.styleable.Tooltip, r9, r10, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
        setText(r11.getText(R.styleable.Tooltip_android_text));
        setTextAppearance(MaterialResources.getTextAppearance(this.context, r11, R.styleable.Tooltip_android_textAppearance));
        int r12 = MaterialColors.getColor(this.context, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName());
        int r13 = MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(r12, 153));
        setFillColor(ColorStateList.valueOf(r11.getColor(R.styleable.Tooltip_backgroundTint, r13)));
        setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
        this.padding = r11.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.minWidth = r11.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.minHeight = r11.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = r11.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        r11.recycle();
    }

    public CharSequence getText() {
        return this.text;
    }

    public void setTextResource(int r2) {
        setText(this.context.getResources().getString(r2));
    }

    public void setText(CharSequence r2) {
        if (TextUtils.equals(this.text, r2) == true) goto L6;
        this.text = r2;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        return;
    }

    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public void setTextAppearanceResource(int r3) {
        setTextAppearance(new TextAppearance(this.context, r3));
    }

    public void setTextAppearance(TextAppearance r2) {
        this.textDrawableHelper.setTextAppearance(r2, this.context);
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public void setMinWidth(int r1) {
        this.minWidth = r1;
        invalidateSelf();
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public void setMinHeight(int r1) {
        this.minHeight = r1;
        invalidateSelf();
    }

    public int getTextPadding() {
        return this.padding;
    }

    public void setTextPadding(int r1) {
        this.padding = r1;
        invalidateSelf();
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public void setLayoutMargin(int r1) {
        this.layoutMargin = r1;
        invalidateSelf();
    }

    public void setRevealFraction(float r4) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = r4;
        this.tooltipScaleY = r4;
        this.labelOpacity = AnimationUtils.lerp(0.0f, 1.0f, 0.19f, 1.0f, r4);
        invalidateSelf();
    }

    public void setRelativeToView(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        updateLocationOnScreen(r1);
        r1.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void detachView(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.padding * 2) + getTextWidth(), this.minWidth);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), this.minHeight);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas r9) {
        r9.save();
        float r0 = calculatePointerOffset();
        float r1 = (float) (-((((double) this.arrowSize) * Math.sqrt(2.0d)) - ((double) this.arrowSize)));
        r9.scale(this.tooltipScaleX, this.tooltipScaleY, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.tooltipPivotY));
        r9.translate(r0, r1);
        super.draw(r9);
        drawText(r9);
        r9.restore();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        super.onBoundsChange(r2);
        setShapeAppearanceModel(getShapeAppearanceModel().toBuilder().setBottomEdge(createMarkerEdge()).build());
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r1) {
        return super.onStateChange(r1);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    private void updateLocationOnScreen(View r3) {
        int[] r0 = new int[2];
        r3.getLocationOnScreen(r0);
        this.locationOnScreenX = r0[0];
        r3.getWindowVisibleDisplayFrame(this.displayFrame);
    }

    private float calculatePointerOffset() {
        if ((((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin) >= 0) goto L7;
        int r0 = ((this.displayFrame.right - getBounds().right) - this.locationOnScreenX) - this.layoutMargin;
    L11:
        return r0;
    L7:
        if ((((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin) <= 0) goto L9;
        r0 = ((this.displayFrame.left - getBounds().left) - this.locationOnScreenX) + this.layoutMargin;
        goto L11
    L9:
        return 0.0f;
    }

    private EdgeTreatment createMarkerEdge() {
        float r0 = -calculatePointerOffset();
        float r1 = ((float) (((double) getBounds().width()) - (((double) this.arrowSize) * Math.sqrt(2.0d)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.arrowSize), Math.min(Math.max(r0, -r1), r1));
    }

    private void drawText(Canvas r12) {
        if (this.text != null) goto L5;
        return;
    L5:
        Rect r0 = getBounds();
        int r1 = (int) calculateTextOriginAndAlignment(r0);
        if (this.textDrawableHelper.getTextAppearance() == null) goto L8;
        this.textDrawableHelper.getTextPaint().drawableState = getState();
        this.textDrawableHelper.updateTextPaintDrawState(this.context);
        this.textDrawableHelper.getTextPaint().setAlpha((int) (this.labelOpacity * 255.0f));
    L8:
        CharSequence r5 = this.text;
        r12.drawText(r5, 0, r5.length(), r0.centerX(), r1, this.textDrawableHelper.getTextPaint());
    }

    private float getTextWidth() {
        CharSequence r0 = this.text;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return this.textDrawableHelper.getTextWidth(r0.toString());
    }

    private float calculateTextOriginAndAlignment(Rect r1) {
        return r1.centerY() - calculateTextCenterFromBaseline();
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }
}
