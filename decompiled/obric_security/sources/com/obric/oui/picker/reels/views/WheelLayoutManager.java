package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WheelLayoutManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0006H\u0002J\u0010\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0002J\b\u0010-\u001a\u00020\u0016H\u0016J\u000e\u0010.\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\b\u00100\u001a\u000201H\u0016J\u0006\u00102\u001a\u00020\bJ\u0014\u00103\u001a\u00020&2\n\u00104\u001a\u000605R\u000206H\u0002J \u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0002J\u001c\u0010;\u001a\u00020&2\n\u00104\u001a\u000605R\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u0010)\u001a\u00020\bH\u0016J$\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\n\u00104\u001a\u000605R\u0002062\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020\bJ\u000e\u0010C\u001a\u00020&2\u0006\u0010B\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u0014R\u000e\u0010\u001f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\u0014¨\u0006D"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelLayoutManager;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cameraDistancePx", "", "defaultEndColor", "", "getDefaultEndColor", "()I", "defaultEndColor$delegate", "Lkotlin/Lazy;", "defaultStartColor", "getDefaultStartColor", "defaultStartColor$delegate", "degToRad", "headTailPaddingItems", "getHeadTailPaddingItems", "setHeadTailPaddingItems", "(I)V", "isCyclic", "", "()Z", "setCyclic", "(Z)V", "itemAngle", "itemHeightPx", "normalColor", "getNormalColor", "setNormalColor", "quarterCount", "radiusPx", "scrollOffsetPx", "selectedColor", "getSelectedColor", "setSelectedColor", "applyTransform", "", "child", "Landroid/view/View;", "position", "scrollItems", "calculateRadius", "itemHeight", "canScrollVertically", "computeDeltaToCenterAtPosition", "computeSnapDeltaToNearestCenter", "generateDefaultLayoutParams", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$LayoutParams;", "getNearestCenterAdapterIndex", "layoutVisibleChildren", "recycler", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$Recycler;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "lerp", "start", TraceStatsConsts.STATS_KEY_END, "t", "onLayoutChildren", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "scrollToPosition", "scrollVerticallyBy", "dy", "setNormalTextColor", "color", "setSelectedTextColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelLayoutManager extends RecyclerView.LayoutManager {
    private final float cameraDistancePx;
    private final Lazy defaultEndColor$delegate;
    private final Lazy defaultStartColor$delegate;
    private final float degToRad;
    private int headTailPaddingItems;
    private boolean isCyclic;
    private final float itemAngle;
    private int itemHeightPx;
    private int normalColor;
    private final int quarterCount;
    private float radiusPx;
    private float scrollOffsetPx;
    private int selectedColor;

    private final float lerp(float r1, float r2, float r3) {
        return r1 + ((r2 - r1) * r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    public WheelLayoutManager(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.cameraDistancePx = OUnitExtensionKt.cdpFloat(r2, 8000.0f);
        this.defaultStartColor$delegate = LazyKt.lazy(new WheelLayoutManager$defaultStartColor$2(r2));
        this.defaultEndColor$delegate = LazyKt.lazy(new WheelLayoutManager$defaultEndColor$2(r2));
        this.selectedColor = getDefaultStartColor();
        this.normalColor = getDefaultEndColor();
        this.itemAngle = 30.0f;
        this.quarterCount = 3;
        this.degToRad = 0.017453292f;
    }

    private final int getDefaultStartColor() {
        return ((Number) this.defaultStartColor$delegate.getValue()).intValue();
    }

    private final int getDefaultEndColor() {
        return ((Number) this.defaultEndColor$delegate.getValue()).intValue();
    }

    public final int getSelectedColor() {
        return this.selectedColor;
    }

    public final void setSelectedColor(int r1) {
        this.selectedColor = r1;
    }

    public final int getNormalColor() {
        return this.normalColor;
    }

    public final void setNormalColor(int r1) {
        this.normalColor = r1;
    }

    public final boolean isCyclic() {
        return this.isCyclic;
    }

    public final void setCyclic(boolean r1) {
        this.isCyclic = r1;
    }

    public final int getHeadTailPaddingItems() {
        return this.headTailPaddingItems;
    }

    public final void setHeadTailPaddingItems(int r1) {
        this.headTailPaddingItems = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r3, RecyclerView.State r4) {
        Intrinsics.checkNotNullParameter(r3, "recycler");
        Intrinsics.checkNotNullParameter(r4, "state");
        if (getItemCount() != 0) goto L7;
        detachAndScrapAttachedViews(r3);
        this.scrollOffsetPx = 0.0f;
        return;
    L7:
        if (this.itemHeightPx != 0) goto L9;
        View r0 = r3.getViewForPosition(0);
        Intrinsics.checkNotNullExpressionValue(r0, "recycler.getViewForPosition(0)");
        addView(r0);
        measureChildWithMargins(r0, 0, 0);
        int r5 = getDecoratedMeasuredHeight(r0);
        this.itemHeightPx = r5;
        this.radiusPx = calculateRadius(r5);
        detachAndScrapView(r0, r3);
    L9:
        layoutVisibleChildren(r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r4, RecyclerView.Recycler r5, RecyclerView.State r6) {
        Intrinsics.checkNotNullParameter(r5, "recycler");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (getChildCount() == 0) goto L16;
        if (r4 == 0) goto L16;
        if (this.itemHeightPx == 0) goto L16;
        if (getItemCount() == 0) goto L16;
        float r7 = RangesKt.coerceAtLeast(getItemCount() - 1, 0) * this.itemHeightPx;
        if (this.isCyclic == false) goto L13;
        Pair r8 = TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(r7));
    L14:
        float r9 = RangesKt.coerceIn(this.scrollOffsetPx + r4, ((Number) r8.component1()).floatValue(), ((Number) r8.component2()).floatValue());
        float r10 = r9 - this.scrollOffsetPx;
        this.scrollOffsetPx = r9;
        layoutVisibleChildren(r5);
        return MathKt.roundToInt(r10);
    L13:
        int r11 = this.headTailPaddingItems;
        int r0 = RangesKt.coerceAtLeast((getItemCount() - this.headTailPaddingItems) - 1, r11);
        int r1 = this.itemHeightPx;
        r8 = TuplesKt.to(Float.valueOf(r11 * r1), Float.valueOf(r0 * r1));
    L16:
        return 0;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r4) {
        if (getItemCount() != 0) goto L5;
        return;
    L5:
        if (this.itemHeightPx != 0) goto L8;
        return;
    L8:
        if (this.isCyclic == false) goto L10;
        int r5 = RangesKt.coerceIn(r4, 0, getItemCount() - 1);
    L11:
        this.scrollOffsetPx = r5 * this.itemHeightPx;
        requestLayout();
        return;
    L10:
        int r0 = this.headTailPaddingItems;
        r5 = RangesKt.coerceIn(r4, r0, RangesKt.coerceAtLeast((getItemCount() - this.headTailPaddingItems) - 1, r0));
        goto L11
    }

    private final void layoutVisibleChildren(RecyclerView.Recycler r15) {
        detachAndScrapAttachedViews(r15);
        int r0 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (this.itemHeightPx == 0) goto L16;
        float r1 = getPaddingTop() + (r0 / 2.0f);
        float r2 = this.scrollOffsetPx / this.itemHeightPx;
        float r5 = 1;
        int r3 = RangesKt.coerceAtLeast((int) Math.floor((r2 - this.quarterCount) - r5), 0);
        int r4 = RangesKt.coerceAtMost((int) Math.ceil((this.quarterCount + r2) + r5), getItemCount() - 1);
        if (r3 > r4) goto L15;
    L9:
        int r6 = r3 + 1;
        View r13 = r15.getViewForPosition(r3);
        Intrinsics.checkNotNullExpressionValue(r13, "recycler.getViewForPosition(position)");
        addView(r13);
        measureChildWithMargins(r13, 0, 0);
        int r7 = getDecoratedMeasuredWidth(r13);
        int r9 = ((((getWidth() - getPaddingLeft()) - getPaddingRight()) - r7) / 2) + getPaddingLeft();
        int r10 = MathKt.roundToInt(r1 - (this.itemHeightPx / 2.0f));
        layoutDecorated(r13, r9, r10, r9 + r7, r10 + this.itemHeightPx);
        applyTransform(r13, r3, r2);
        if (r3 == r4) goto L17;
        r3 = r6;
        goto L9
    L17:
        return;
    L15:
        return;
    }

    private final void applyTransform(View r7, int r8, float r9) {
        float r10 = r8 - r9;
        float r11 = RangesKt.coerceIn(this.itemAngle * r10, -90.0f, 90.0f);
        float r0 = this.degToRad * r11;
        float r2 = RangesKt.coerceIn(Math.abs(r11) / 90.0f, 0.0f, 1.0f);
        float r12 = RangesKt.coerceIn(Math.abs(r10), 0.0f, 1.0f);
        float r1 = lerp(1.0f, 0.8f, r2);
        r7.setPivotX(r7.getWidth() / 2.0f);
        r7.setPivotY(r7.getHeight() / 2.0f);
        r7.setRotationX(r11);
        r7.setScaleX(r1);
        r7.setScaleY(r1);
        double r3 = r0;
        r7.setTranslationY(((float) Math.sin(r3)) * this.radiusPx);
        float r13 = (float) Math.cos(r3);
        float r4 = this.radiusPx;
        r7.setTranslationZ((r13 * r4) - r4);
        r7.setCameraDistance(this.cameraDistancePx);
        if ((r7 instanceof TextView) == false) goto L5;
        TextView r14 = (TextView) r7;
        r14.setTextColor(ColorUtils.blendARGB(this.selectedColor, this.normalColor, r12));
        r14.setTypeface(Typeface.create(Typeface.DEFAULT, MathKt.roundToInt(lerp(450.0f, 300.0f, r12)), false));
    L5:
        r7.setAlpha(lerp(1.0f, 0.2f, r2));
    }

    public final int computeSnapDeltaToNearestCenter() {
        if (this.itemHeightPx != 0) goto L5;
    L16:
        return 0;
    L5:
        if (getChildCount() == 0) goto L16;
        if (getItemCount() > 0) goto L10;
        return 0;
    L10:
        float r0 = this.scrollOffsetPx / this.itemHeightPx;
        if (this.isCyclic == false) goto L13;
        int r1 = RangesKt.coerceIn(MathKt.roundToInt(r0), 0, getItemCount() - 1);
    L15:
        return MathKt.roundToInt((r1 * this.itemHeightPx) - this.scrollOffsetPx);
    L13:
        int r2 = this.headTailPaddingItems;
        r1 = RangesKt.coerceIn(MathKt.roundToInt(r0), r2, RangesKt.coerceAtLeast((getItemCount() - this.headTailPaddingItems) - 1, r2));
        goto L15
    }

    public final int computeDeltaToCenterAtPosition(int r4) {
        if (this.itemHeightPx != 0) goto L5;
    L13:
        return 0;
    L5:
        if (getItemCount() == 0) goto L13;
        if (this.isCyclic == false) goto L10;
        int r5 = RangesKt.coerceIn(r4, 0, getItemCount() - 1);
    L12:
        return MathKt.roundToInt((r5 * this.itemHeightPx) - this.scrollOffsetPx);
    L10:
        int r0 = this.headTailPaddingItems;
        r5 = RangesKt.coerceIn(r4, r0, RangesKt.coerceAtLeast((getItemCount() - this.headTailPaddingItems) - 1, r0));
        goto L12
    }

    public final int getNearestCenterAdapterIndex() {
        if (this.itemHeightPx != 0) goto L5;
        return -1;
    L5:
        if (getItemCount() == 0) goto L15;
        int r0 = MathKt.roundToInt(this.scrollOffsetPx / this.itemHeightPx);
        if (this.isCyclic == true) goto L14;
        int r1 = this.headTailPaddingItems;
        return RangesKt.coerceIn(r0, r1, RangesKt.coerceAtLeast((getItemCount() - this.headTailPaddingItems) - 1, r1));
    L14:
        return RangesKt.coerceIn(r0, 0, getItemCount() - 1);
    L15:
        return -1;
    }

    private final float calculateRadius(int r3) {
        return r3 / ((float) Math.tan(this.itemAngle * this.degToRad));
    }

    public final void setSelectedTextColor(int r1) {
        this.selectedColor = r1;
    }

    public final void setNormalTextColor(int r1) {
        this.normalColor = r1;
    }
}
