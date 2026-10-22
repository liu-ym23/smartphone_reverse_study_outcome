package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.TextViewFontWeightUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: OMonthPickerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002MNB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0006\u0010$\u001a\u00020\u0007J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010)\u001a\u00020\u0007H\u0002J\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u0006\u0010+\u001a\u00020\u001aJ\u001a\u0010,\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u001a\u00107\u001a\u00020\u001e2\b\b\u0001\u0010\u0017\u001a\u00020\u00072\b\b\u0001\u0010\u001b\u001a\u00020\u0007J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0007J\u0010\u0010:\u001a\u00020\u001e2\b\b\u0001\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u0007J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007J\u0019\u0010B\u001a\u00020\u001e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140D¢\u0006\u0002\u0010EJ\u0014\u0010B\u001a\u00020\u001e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0010\u0010F\u001a\u00020\u001e2\b\u0010G\u001a\u0004\u0018\u00010\u0016J\u0014\u0010H\u001a\u00020\u001e2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013J\u000e\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\u001aJ\b\u0010L\u001a\u00020\u001eH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chips", "", "Lcom/obric/oui/calendar/OMonthPickerView$MonthDayChip;", "columnCount", "dayTextAppearance", "itemHorizontalPaddingPx", "itemSizePx", "itemVerticalPaddingPx", "labels", "", "", "onDaysChangedListener", "Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "selectedBackgroundColor", "selectedTextFontWeight", "selectionMode", "Lcom/obric/oui/calendar/PickerSelectionMode;", "unSelectedBackgroundColor", "unselectedTextFontWeight", "applyDayTextAppearance", "", "chip", "clearSelection", "createChildren", "dispatchSelection", "generateDefaultLabels", "getColumnCount", "getContentHeight", "getDayCount", "getFullRowWidth", "getLabels", "getRowCount", "getSelectedDays", "getSelectionMode", "initAttrs", "onLayout", "changed", "", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setBackgroundColorColor", "setColumnCount", "count", "setDayTextAppearance", "resourceId", "setItemDiameterDp", "itemDiameterDp", "setItemPaddingDp", "itemPaddingDp", "itemHorizontalPaddingDp", "itemVerticalPaddingDp", "setLabels", "newLabels", "", "([Ljava/lang/String;)V", "setOnDaysChangedListener", "listener", "setSelectedDays", "days", "setSelectionMode", SearchConfigType.KEY_MODE, "updateChildrenText", "MonthDayChip", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OMonthPickerView extends ViewGroup {
    private final List<MonthDayChip> chips;
    private int columnCount;
    private int dayTextAppearance;
    private final int defStyleAttr;
    private final int defStyleRes;
    private int itemHorizontalPaddingPx;
    private int itemSizePx;
    private int itemVerticalPaddingPx;
    private List<String> labels;
    private OnDaysChangedListener onDaysChangedListener;
    private int selectedBackgroundColor;
    private int selectedTextFontWeight;
    private PickerSelectionMode selectionMode;
    private int unSelectedBackgroundColor;
    private int unselectedTextFontWeight;

    /* JADX INFO: compiled from: OMonthPickerView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002J\u001a\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView$MonthDayChip;", "Landroidx/appcompat/widget/AppCompatCheckedTextView;", "context", "Landroid/content/Context;", "selectedTextFontWeight", "", "unselectedTextFontWeight", "(Landroid/content/Context;II)V", "selectedBackgroundColor", "sizePx", "unSelectedBackgroundColor", "applyTextFontWeight", "", "circleDrawable", "Landroid/graphics/drawable/ShapeDrawable;", "color", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "regenerateBackground", "setBackgroundColorColor", "setChecked", "checked", "", "setSize", "px", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class MonthDayChip extends AppCompatCheckedTextView {
        private int selectedBackgroundColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackgroundColor;
        private final int unselectedTextFontWeight;

        public MonthDayChip(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.selectedTextFontWeight = r3;
            this.unselectedTextFontWeight = r4;
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackgroundColor = r1;
            this.unSelectedBackgroundColor = r2;
            regenerateBackground();
        }

        @Override // android.widget.CheckedTextView, android.widget.Checkable
        public void setChecked(boolean r2) {
            if (isChecked() == r2) goto L5;
            boolean r0 = true;
        L6:
            super.setChecked(r2);
            if (r0 == false) goto L10;
            applyTextFontWeight();
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final void setSize(int r1) {
            this.sizePx = r1;
            requestLayout();
            regenerateBackground();
        }

        public final void applyTextFontWeight() {
            if (isChecked() == false) goto L5;
            int r0 = this.selectedTextFontWeight;
        L6:
            TextViewFontWeightUtils.applyTextFontWeight(this, r0);
            return;
        L5:
            r0 = this.unselectedTextFontWeight;
            goto L6
        }

        @Override // android.widget.TextView, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(this.sizePx, r2), AppCompatCheckedTextView.resolveSize(this.sizePx, r3));
        }

        private final void regenerateBackground() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, circleDrawable(this.selectedBackgroundColor));
            r0.addState(new int[]{R.attr.state_pressed}, circleDrawable(this.selectedBackgroundColor));
            r0.addState(new int[0], circleDrawable(this.unSelectedBackgroundColor));
            setBackground(r0);
        }

        private final ShapeDrawable circleDrawable(int r2) {
            ShapeDrawable r1 = new ShapeDrawable(new OvalShape());
            r1.getPaint().setColor(r2);
            return r1;
        }
    }

    /* JADX INFO: compiled from: OMonthPickerView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OMonthPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDaysChangedListener {
        void onChanged(List<Integer> r1);
    }

    public static /* synthetic */ void $r8$lambda$cTOGSA9xrD53tGQHFd5CZwA_FaI(OMonthPickerView r0, MonthDayChip r1, View r2) {
        m226createChildren$lambda3$lambda2$lambda1(r0, r1, r2);
    }

    public OMonthPickerView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OMonthPickerView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OMonthPickerView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OMonthPickerView(Context r1, AttributeSet r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = com.obric.common.oui.R.attr.omonthPickerViewStyle;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = com.obric.common.oui.R.style.OStyleV2_OMonthPickerView_DayNight;
    L11:
        this(r1, r2, r3, r4);
    }

    public OMonthPickerView(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.defStyleAttr = r4;
        this.defStyleRes = r5;
        this.selectionMode = PickerSelectionMode.MULTIPLE;
        this.columnCount = 1;
        this.labels = generateDefaultLabels();
        this.selectedTextFontWeight = getResources().getInteger(com.obric.common.oui.R.integer.oui_font_weight_bold);
        this.unselectedTextFontWeight = getResources().getInteger(com.obric.common.oui.R.integer.oui_font_weight_regular);
        this.chips = new ArrayList();
        initAttrs(r2, r3);
        setClipChildren(false);
        setClipToPadding(false);
        createChildren();
    }

    private final void initAttrs(Context r4, AttributeSet r5) {
        TypedArray r6 = r4.obtainStyledAttributes(r5, com.obric.common.oui.R.styleable.OMonthPickerView, this.defStyleAttr, this.defStyleRes);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…    defStyleRes\n        )");
    L33:
        th = move-exception;
        r6.recycle();
        throw th;
    L4:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor) == false) goto L7;
        this.selectedBackgroundColor = r6.getColor(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_selectedBackgroundColor, this.selectedBackgroundColor);     // Catch: Throwable -> L33
    L7:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor) == false) goto L10;
        this.unSelectedBackgroundColor = r6.getColor(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_unSelectedBackgroundColor, this.unSelectedBackgroundColor);     // Catch: Throwable -> L33
    L10:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_dayTextAppearance) == false) goto L13;
        this.dayTextAppearance = r6.getResourceId(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_dayTextAppearance, this.dayTextAppearance);     // Catch: Throwable -> L33
    L13:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_selectionMode) == false) goto L20;
        if (r6.getInt(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_selectionMode, this.selectionMode.ordinal()) != PickerSelectionMode.SINGLE.ordinal()) goto L17;
        PickerSelectionMode r7 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L33
    L18:
        this.selectionMode = r7;     // Catch: Throwable -> L33
        goto L20
    L17:
        r7 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L33
    L20:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_mpv_columnCount) == false) goto L23;
        this.columnCount = RangesKt.coerceAtLeast(r6.getInt(com.obric.common.oui.R.styleable.OMonthPickerView_o_mpv_columnCount, this.columnCount), 1);     // Catch: Throwable -> L33
    L23:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemSize) == false) goto L26;
        this.itemSizePx = r6.getDimensionPixelSize(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemSize, this.itemSizePx);     // Catch: Throwable -> L33
    L26:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemHPadding) == false) goto L29;
        this.itemHorizontalPaddingPx = r6.getDimensionPixelSize(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemHPadding, this.itemHorizontalPaddingPx);     // Catch: Throwable -> L33
    L29:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemVPadding) == false) goto L31;
        this.itemVerticalPaddingPx = r6.getDimensionPixelSize(com.obric.common.oui.R.styleable.OMonthPickerView_o_pv_itemVPadding, this.itemVerticalPaddingPx);     // Catch: Throwable -> L33
    L31:
        r6.recycle();
    }

    private final void createChildren() {
        removeAllViews();
        this.chips.clear();
        Iterator<T> r0 = this.labels.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        final MonthDayChip r2 = new MonthDayChip(r3, this.selectedTextFontWeight, this.unselectedTextFontWeight);
        r2.setText(r1);
        r2.setGravity(17);
        applyDayTextAppearance(r2);
        r2.applyTextFontWeight();
        r2.setIncludeFontPadding(false);
        r2.setSingleLine(true);
        r2.setTextAlignment(4);
        r2.setClickable(true);
        r2.setFocusable(true);
        r2.setSize(this.itemSizePx);
        r2.setBackgroundColorColor(this.selectedBackgroundColor, this.unSelectedBackgroundColor);
        r2.setOnClickListener(new OMonthPickerView$$ExternalSyntheticLambda0(this, r2));
        int r4 = this.itemSizePx;
        addView(r2, new ViewGroup.LayoutParams(r4, r4));
        this.chips.add(r2);
        goto L4
    }

    /* JADX INFO: renamed from: createChildren$lambda-3$lambda-2$lambda-1, reason: not valid java name */
    private static final void m226createChildren$lambda3$lambda2$lambda1(OMonthPickerView r2, MonthDayChip r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        if (r2.selectionMode != PickerSelectionMode.SINGLE) goto L8;
        Iterator<T> r5 = r2.chips.iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        MonthDayChip r0 = (MonthDayChip) r5.next();
        r0.setChecked(Intrinsics.areEqual(r0, r3));
    L9:
        r2.dispatchSelection();
        return;
    L8:
        r3.toggle();
        goto L9
    }

    private final int getRowCount() {
        int r0 = getDayCount();
        int r1 = this.columnCount;
        return ((r0 + r1) - 1) / r1;
    }

    private final int getFullRowWidth() {
        int r0 = this.columnCount;
        return (this.itemSizePx * r0) + ((r0 - 1) * this.itemHorizontalPaddingPx);
    }

    private final int getContentHeight() {
        return (getRowCount() * this.itemSizePx) + ((getRowCount() - 1) * this.itemVerticalPaddingPx);
    }

    @Override // android.view.View
    protected void onMeasure(int r8, int r9) {
        int r0 = View.MeasureSpec.getSize(r8);
        int r2 = 0;
        if (View.MeasureSpec.getMode(r8) == 0) goto L14;
        if (r0 <= 0) goto L14;
        int r1 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r3 = this.columnCount;
        int r4 = this.itemSizePx;
        if (((r3 * r4) + ((r3 - 1) * this.itemHorizontalPaddingPx)) <= r1) goto L14;
        int r5 = r1 - (r4 * r3);
        if (r5 > 0) goto L10;
    L12:
        int r6 = 0;
    L13:
        this.itemHorizontalPaddingPx = r6;
        goto L14
    L10:
        if (r3 <= 1) goto L12;
        r6 = r5 / (r3 - 1);
    L14:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + getFullRowWidth()) + getPaddingRight(), r8), ViewGroup.resolveSize((getPaddingTop() + getContentHeight()) + getPaddingBottom(), r9));
        int r10 = View.MeasureSpec.makeMeasureSpec(this.itemSizePx, 1073741824);
        int r11 = getChildCount();
    L15:
        if (r2 >= r11) goto L17;
        getChildAt(r2).measure(r10, r10);
        r2 = r2 + 1;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = r10 - r8;
        int r13 = (r12 - getPaddingLeft()) - getPaddingRight();
        int r14 = getFullRowWidth();
        int r15 = (r13 - r14) / 2;
        int r16 = 0;
        int r17 = getPaddingLeft() + RangesKt.coerceAtLeast(r15, 0);
        int r18 = (r12 - getPaddingRight()) - RangesKt.coerceAtLeast(r15, 0);
        int r19 = getChildCount();
    L3:
        if (r16 >= r19) goto L9;
        int r110 = r16 + 1;
        View r0 = getChildAt(r16);
        int r1 = this.columnCount;
        int r2 = r16 / r1;
        int r20 = r16 % r1;
        int r3 = getPaddingTop() + (r2 * (this.itemSizePx + this.itemVerticalPaddingPx));
        if (LocalUtils.isRTL() == false) goto L7;
        int r4 = this.itemSizePx;
        int r21 = r18 - (r20 * (this.itemHorizontalPaddingPx + r4));
        int r5 = r21 - r4;
    L8:
        r0.layout(r5, r3, r21, this.itemSizePx + r3);
        r16 = r110;
        goto L3
    L7:
        int r6 = this.itemSizePx;
        int r22 = (r20 * (this.itemHorizontalPaddingPx + r6)) + r17;
        int r23 = r6 + r22;
        r5 = r22;
        r21 = r23;
        goto L8
    }

    private final void dispatchSelection() {
        OnDaysChangedListener r0 = this.onDaysChangedListener;
        if (r0 == null) goto L7;
        r0.onChanged(getSelectedDays());
        return;
    }

    private final List<String> generateDefaultLabels() {
        ArrayList r3 = new ArrayList(31);
        int r1 = 0;
    L3:
        if (r1 >= 31) goto L6;
        r1 = r1 + 1;
        r3.add(String.valueOf(r1));
        goto L3
    L6:
        return r3;
    }

    public final void setSelectionMode(PickerSelectionMode r6) {
        Intrinsics.checkNotNullParameter(r6, SearchConfigType.KEY_MODE);
        this.selectionMode = r6;
        if (r6 != PickerSelectionMode.SINGLE) goto L31;
        Iterator<MonthDayChip> r7 = this.chips.iterator();
        int r1 = 0;
    L6:
        if (r7.hasNext() == false) goto L11;
        if (r7.next().isChecked() == true) goto L12;
        r1 = r1 + 1;
    L12:
        Iterator<T> r8 = this.chips.iterator();
        int r2 = 0;
    L14:
        if (r8.hasNext() == false) goto L24;
        Object r3 = r8.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        MonthDayChip r5 = (MonthDayChip) r3;
        if (r2 != r1) goto L22;
        if (r1 < 0) goto L22;
        boolean r9 = true;
    L23:
        r5.setChecked(r9);
        r2 = r4;
    L22:
        r9 = false;
        goto L23
    L24:
        dispatchSelection();
        return;
    L11:
        r1 = -1;
        goto L12
    }

    public final PickerSelectionMode getSelectionMode() {
        return this.selectionMode;
    }

    public final void setColumnCount(int r2) {
        int r3 = RangesKt.coerceAtLeast(r2, 1);
        if (this.columnCount != r3) goto L5;
        return;
    L5:
        this.columnCount = r3;
        requestLayout();
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final void setLabels(List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "newLabels");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        List<Integer> r0 = getSelectedDays();
        if (r7.size() == getChildCount()) goto L8;
        boolean r1 = true;
    L9:
        this.labels = CollectionsKt.toList(r7);
        if (r1 == false) goto L12;
        createChildren();
    L13:
        ArrayList r8 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L24;
        Object r3 = r2.next();
        int r4 = ((Number) r3).intValue();
        if (r4 >= 0) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == false) goto L15;
        r8.add(r3);
        goto L15
    L19:
        if (r4 >= this.labels.size()) goto L21;
        r5 = true;
        goto L22
    L24:
        setSelectedDays(r8);
        requestLayout();
        return;
    L12:
        updateChildrenText();
        goto L13
    L8:
        r1 = false;
        goto L9
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    public final List<String> getLabels() {
        return CollectionsKt.toList(this.labels);
    }

    private final int getDayCount() {
        return this.labels.size();
    }

    private final void updateChildrenText() {
        Iterator<T> r0 = this.chips.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((MonthDayChip) r2).setText(this.labels.get(r1));
        r1 = r3;
        goto L4
    }

    public final void setSelectedDays(List<Integer> r7) {
        Intrinsics.checkNotNullParameter(r7, "days");
        int r2 = 0;
        if (this.selectionMode != PickerSelectionMode.SINGLE) goto L18;
        Integer r8 = (Integer) CollectionsKt.firstOrNull(r7);
        Iterator<T> r0 = this.chips.iterator();
        int r1 = 0;
    L6:
        if (r0.hasNext() == false) goto L25;
        Object r3 = r0.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        MonthDayChip r5 = (MonthDayChip) r3;
        if (r8 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        r5.setChecked(r6);
        r1 = r4;
        goto L6
    L14:
        if (r1 != r8.intValue()) goto L16;
        r6 = true;
    L25:
        dispatchSelection();
        return;
    L18:
        Set r9 = CollectionsKt.toSet(r7);
        Iterator<T> r10 = this.chips.iterator();
    L20:
        if (r10.hasNext() == false) goto L25;
        Object r11 = r10.next();
        int r12 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((MonthDayChip) r11).setChecked(r9.contains(Integer.valueOf(r2)));
        r2 = r12;
        goto L20
    }

    public final List<Integer> getSelectedDays() {
        List<MonthDayChip> r4 = this.chips;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L16;
        Object r2 = r5.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((MonthDayChip) r2).isChecked() == false) goto L11;
        Integer r6 = Integer.valueOf(r1);
    L12:
        if (r6 == null) goto L14;
        r0.add(r6);
    L14:
        r1 = r3;
        goto L4
    L11:
        r6 = null;
        goto L12
    L16:
        return r0;
    }

    public final void clearSelection() {
        Iterator<T> r0 = this.chips.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((MonthDayChip) r0.next()).setChecked(false);
        goto L4
    L6:
        dispatchSelection();
    }

    public final void setOnDaysChangedListener(OnDaysChangedListener r1) {
        this.onDaysChangedListener = r1;
    }

    public final void setBackgroundColorColor(int r2, int r3) {
        this.selectedBackgroundColor = r2;
        this.unSelectedBackgroundColor = r3;
        Iterator<T> r1 = this.chips.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((MonthDayChip) r1.next()).setBackgroundColorColor(r2, r3);
        goto L4
    }

    public final void setDayTextAppearance(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        this.dayTextAppearance = r3;
        Iterator<T> r4 = this.chips.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        MonthDayChip r0 = (MonthDayChip) r4.next();
        applyDayTextAppearance(r0);
        r0.applyTextFontWeight();
        r0.setIncludeFontPadding(false);
        goto L6
    }

    public final void setItemDiameterDp(int r3) {
        this.itemSizePx = OUnitExtensionKt.vdp(this, r3);
        Iterator<T> r4 = this.chips.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((MonthDayChip) r4.next()).setSize(this.itemSizePx);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemPaddingDp(int r1) {
        setItemPaddingDp(r1, r1);
    }

    public final void setItemPaddingDp(int r2, int r3) {
        OMonthPickerView r0 = this;
        this.itemHorizontalPaddingPx = OUnitExtensionKt.vdp(r0, r2);
        this.itemVerticalPaddingPx = OUnitExtensionKt.vdp(r0, r3);
        requestLayout();
    }

    private final void applyDayTextAppearance(MonthDayChip r2) {
        if (this.dayTextAppearance == 0) goto L6;
        r2.setTextAppearance(getContext(), this.dayTextAppearance);
        return;
    }
}
