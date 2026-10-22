package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.picker.reels.OReelPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OReelPickerMulti.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\u0019H\u0014J$\u0010\u0018\u001a\u00020\u0019*\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reelsContainer", "Landroid/widget/LinearLayout;", "reelsCount", "wheelViews", "", "Lcom/obric/oui/picker/reels/views/WheelView;", "addWheelView", MaterialConfigFormatNames.WIDTH, "weight", "", "minHeight", "(Ljava/lang/Integer;FI)Lcom/obric/oui/picker/reels/views/WheelView;", "asView", "Landroid/view/View;", "configure", "", "col", "reel", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "getReelView", "onAttachedToWindow", "colIndex", "maxColIndex", "Builder", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout implements OReelPicker {
    private final LinearLayout reelsContainer;
    private int reelsCount;
    private final List<WheelView> wheelViews;

    /* JADX INFO: compiled from: OReelPickerMulti.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\"\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti$Builder;", "Lcom/obric/oui/picker/reels/OReelPicker$Builder;", "()V", "mHeight", "", "mPaddingVerticalDp", "mReels", "", "Lcom/obric/oui/picker/reels/OReelPicker$Reel;", "mWidth", "addReel", "reel", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/oui/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "setHeight", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setWidth", MaterialConfigFormatNames.WIDTH, "setReels", "", "Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "reels", "", "reelMinHeight", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder implements OReelPicker.Builder {
        private int mHeight;
        private int mPaddingVerticalDp;
        private final List<OReelPicker.Reel> mReels;
        private int mWidth;

        public Builder() {
            this.mReels = new ArrayList();
            this.mWidth = -1;
            this.mHeight = -1;
            this.mPaddingVerticalDp = 16;
        }

        public final Builder setWidth(int r1) {
            this.mWidth = r1;
            return this;
        }

        public final Builder setHeight(int r1) {
            this.mHeight = r1;
            return this;
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker.Builder addReel(OReelPicker.Reel r2) {
            Intrinsics.checkNotNullParameter(r2, "reel");
            this.mReels.add(r2);
            return this;
        }

        @Override // com.obric.oui.picker.reels.OReelPicker.Builder
        public OReelPicker build(Context r3, AttributeSet r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            if (this.mWidth != (-1)) goto L6;
            this.mWidth = OUnitExtensionKt.cdp(r3, 328);
        L6:
            if (this.mHeight != (-1)) goto L8;
            this.mHeight = OUnitExtensionKt.cdp(r3, 240);
        L8:
            OReelPickerMulti r0 = new OReelPickerMulti(r3, r4, r5);
            r0.setLayoutParams(new LinearLayout.LayoutParams(this.mWidth, this.mHeight));
            setReels(r0, this.mReels, this.mHeight - (OUnitExtensionKt.cdp(r3, this.mPaddingVerticalDp) * 2));
            return r0;
        }

        private final void setReels(OReelPickerMulti r3, List<OReelPicker.Reel> r4, int r5) {
            OReelPickerMulti.access$setReelsCount$p(r3, r4.size());
            OReelPickerMulti.access$getWheelViews$p(r3).clear();
            OReelPickerMulti.access$getReelsContainer$p(r3).removeAllViews();
            List<OReelPicker.Reel> r6 = r4;
            Iterator<T> r2 = r6.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            OReelPicker.Reel r0 = (OReelPicker.Reel) r2.next();
            OReelPickerMulti.access$addWheelView(r3, r0.getWidth(), r0.getWidthWeight(), r5);
            goto L4
        L6:
            Iterator<T> r7 = r6.iterator();
            int r8 = 0;
        L8:
            if (r7.hasNext() == false) goto L13;
            Object r9 = r7.next();
            int r1 = r8 + 1;
            if (r8 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            r3.configure(r8, (OReelPicker.Reel) r9);
            r8 = r1;
            goto L8
        }
    }

    public OReelPickerMulti(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public OReelPickerMulti(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ OReelPickerMulti(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ WheelView access$addWheelView(OReelPickerMulti r0, Integer r1, float r2, int r3) {
        return r0.addWheelView(r1, r2, r3);
    }

    public static final /* synthetic */ LinearLayout access$getReelsContainer$p(OReelPickerMulti r0) {
        return r0.reelsContainer;
    }

    public static final /* synthetic */ List access$getWheelViews$p(OReelPickerMulti r0) {
        return r0.wheelViews;
    }

    public static final /* synthetic */ void access$setReelsCount$p(OReelPickerMulti r0, int r1) {
        r0.reelsCount = r1;
    }

    public OReelPickerMulti(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LinearLayout r5 = new LinearLayout(r2);
        r5.setId(ConstraintLayout.generateViewId());
        r5.setOrientation(0);
        r5.setGravity(17);
        r5.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.reelsContainer = r5;
        this.wheelViews = new ArrayList();
        addView(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r3 = this.reelsContainer;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L7;
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        ConstraintLayout.LayoutParams r2 = r1;
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r3.setLayoutParams(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final WheelView addWheelView(Integer r8, float r9, int r10) {
        if (r8 == null) goto L5;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r8.intValue(), -1);
    L6:
        Context r2 = getContext();
        Intrinsics.checkNotNullExpressionValue(r2, "context");
        WheelView r11 = new WheelView(r2, null, 0, 6, null);
        r11.setLayoutParams(r0);
        r11.setMinimumHeight(r10);
        r11.setCyclic(false);
        this.reelsContainer.addView(r11);
        this.wheelViews.add(r11);
        return r11;
    L5:
        r0 = new LinearLayout.LayoutParams(-2, -1);
        goto L6
    }

    private final void configure(WheelView r1, final OReelPicker.Reel r2, int r3, int r4) {
        r1.setItemCount(5);
        CharSequence r0 = r2.getTag();
        if (r0 == null) goto L6;
        r1.setTagText(r0);
    L6:
        Integer r5 = r2.getTagGap();
        if (r5 == null) goto L10;
        r1.setTagGap(Integer.valueOf(r5.intValue()));
    L10:
        Integer r6 = r2.getMinWidth();
        if (r6 == null) goto L14;
        r1.setMinimumWidth(r6.intValue());
    L14:
        r1.setOnWheelChangedListener(new AnonymousClass4(r2));
        r1.setEntries(r2.getEntries(), RangesKt.coerceIn(r2.getSelectedIndex(), 0, RangesKt.coerceAtLeast(r2.getEntries().size() - 1, 0)));
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public View asView() {
        return this;
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public WheelView getReelView(int r1) {
        return (WheelView) CollectionsKt.getOrNull(this.wheelViews, r1);
    }

    @Override // com.obric.oui.picker.reels.OReelPicker
    public void configure(int r3, OReelPicker.Reel r4) {
        Intrinsics.checkNotNullParameter(r4, "reel");
        WheelView r0 = getReelView(r3);
        if (r0 == null) goto L7;
        configure(r0, r4, r3, this.reelsCount - 1);
        return;
    }
}
