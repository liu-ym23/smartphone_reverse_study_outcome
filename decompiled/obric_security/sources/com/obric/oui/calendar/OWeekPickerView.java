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
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.utils.TextViewFontWeightUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import obric.widget.search.data.SearchConfigType;

/* JADX INFO: compiled from: OWeekPickerView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002HIB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020 H\u0002J#\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010&J\u001a\u0010'\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0016\u0010.\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0018J\u0010\u00102\u001a\u00020 2\b\b\u0001\u00103\u001a\u00020\u0007J\u000e\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u0007J\u000e\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0007J\u000e\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020\u0007J\u0019\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010<J\u0014\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130=J\u0010\u0010>\u001a\u00020 2\b\u0010?\u001a\u0004\u0018\u00010\u0016J\u0014\u0010@\u001a\u00020 2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070=J\u000e\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020\u001cJ\u0010\u0010D\u001a\u00020 2\u0006\u0010E\u001a\u00020\u0007H\u0002J\b\u0010F\u001a\u00020 H\u0002J\u001b\u0010G\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010<R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chips", "", "Lcom/obric/oui/calendar/OWeekPickerView$DayChip;", "dayTextAppearance", "firstDayOfWeek", "itemHorizontalPaddingPx", "itemSizePx", "labels", "", "", "[Ljava/lang/String;", "onDaysChangedListener", "Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "selectable", "", "selectedBackgroundColor", "selectedTextFontWeight", "selectionMode", "Lcom/obric/oui/calendar/PickerSelectionMode;", "unSelectedBackgroundColor", "unselectedTextFontWeight", "applyDayTextAppearance", "", "chip", "createChildren", "dispatchSelection", "generateLabels", "startValue", "(Landroid/content/Context;I)[Ljava/lang/String;", "initAttrs", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetSelectable", PerfConsts.PERF_DISK_FILE_SIZE, "resizeSelectable", "setBackgroundColorColor", "setDaySelectable", Utils.INTENT_KEY_INDEX, "enabled", "setDayTextAppearance", "resourceId", "setFirstDayOfWeek", "first", "setItemHorizontalPaddingDp", "itemPaddingDp", "setItemSizeDp", "itemDiameterDp", "setLabels", "newLabels", "([Ljava/lang/String;)V", "", "setOnDaysChangedListener", "listener", "setSelectedDays", "days", "setSelectionMode", SearchConfigType.KEY_MODE, "updateChildMargins", "spacingPx", "updateChildrenText", "updateLabels", "DayChip", "OnDaysChangedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OWeekPickerView extends LinearLayout {
    private final List<DayChip> chips;
    private int dayTextAppearance;
    private final int defStyleAttr;
    private final int defStyleRes;
    private int firstDayOfWeek;
    private int itemHorizontalPaddingPx;
    private int itemSizePx;
    private String[] labels;
    private OnDaysChangedListener onDaysChangedListener;
    private final List<Boolean> selectable;
    private int selectedBackgroundColor;
    private int selectedTextFontWeight;
    private PickerSelectionMode selectionMode;
    private int unSelectedBackgroundColor;
    private int unselectedTextFontWeight;

    /* JADX INFO: compiled from: OWeekPickerView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\b\u0010\u0013\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView$DayChip;", "Landroidx/appcompat/widget/AppCompatCheckedTextView;", "context", "Landroid/content/Context;", "selectedTextFontWeight", "", "unselectedTextFontWeight", "(Landroid/content/Context;II)V", "selectedBackGroudColor", "sizePx", "unSelectedBackGroudColor", "applyTextFontWeight", "", "circleDrawable", "Landroid/graphics/drawable/ShapeDrawable;", "color", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "regenerateBackground", "setBackgroundColorColor", "selectedBackgroundColor", "unSelectedBackgroundColor", "setChecked", "checked", "", "setSize", "px", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DayChip extends AppCompatCheckedTextView {
        private int selectedBackGroudColor;
        private final int selectedTextFontWeight;
        private int sizePx;
        private int unSelectedBackGroudColor;
        private final int unselectedTextFontWeight;

        public DayChip(Context r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2);
            this.selectedTextFontWeight = r3;
            this.unselectedTextFontWeight = r4;
        }

        public final void setBackgroundColorColor(int r1, int r2) {
            this.selectedBackGroudColor = r1;
            this.unSelectedBackGroudColor = r2;
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
            int r0 = this.sizePx;
            setMeasuredDimension(AppCompatCheckedTextView.resolveSize(r0, r2), AppCompatCheckedTextView.resolveSize(r0, r3));
        }

        private final void regenerateBackground() {
            StateListDrawable r0 = new StateListDrawable();
            r0.addState(new int[]{R.attr.state_checked}, circleDrawable(this.selectedBackGroudColor));
            r0.addState(new int[]{R.attr.state_pressed}, circleDrawable(this.selectedBackGroudColor));
            r0.addState(new int[0], circleDrawable(this.unSelectedBackGroudColor));
            setBackground(r0);
        }

        private final ShapeDrawable circleDrawable(int r2) {
            ShapeDrawable r1 = new ShapeDrawable(new OvalShape());
            r1.getPaint().setColor(r2);
            return r1;
        }
    }

    /* JADX INFO: compiled from: OWeekPickerView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/calendar/OWeekPickerView$OnDaysChangedListener;", "", "onChanged", "", "selectedDays", "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDaysChangedListener {
        void onChanged(List<Integer> r1);
    }

    public static /* synthetic */ void $r8$lambda$ewGUl9CT2QM6cYtDOUSkhuzb81Y(OWeekPickerView r0, int r1, DayChip r2, View r3) {
        m227createChildren$lambda1$lambda0(r0, r1, r2, r3);
    }

    public OWeekPickerView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public OWeekPickerView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public OWeekPickerView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ OWeekPickerView(Context r1, AttributeSet r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = com.obric.common.oui.R.attr.oweekPickerViewStyle;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = com.obric.common.oui.R.style.OStyleV2_OWeekPickerView_DayNight;
    L11:
        this(r1, r2, r3, r4);
    }

    public OWeekPickerView(Context r2, AttributeSet r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.defStyleAttr = r4;
        this.defStyleRes = r5;
        this.selectionMode = PickerSelectionMode.MULTIPLE;
        this.selectedTextFontWeight = getResources().getInteger(com.obric.common.oui.R.integer.oui_font_weight_bold);
        this.unselectedTextFontWeight = getResources().getInteger(com.obric.common.oui.R.integer.oui_font_weight_regular);
        this.firstDayOfWeek = 2;
        this.labels = generateLabels(r2, 2);
        this.chips = new ArrayList();
        this.selectable = new ArrayList();
        initAttrs(r2, r3);
        String[] r6 = generateLabels(r2, this.firstDayOfWeek);
        this.labels = r6;
        resetSelectable(r6.length);
        setOrientation(0);
        setGravity(17);
        createChildren();
    }

    private final void initAttrs(Context r4, AttributeSet r5) {
        TypedArray r6 = r4.obtainStyledAttributes(r5, com.obric.common.oui.R.styleable.OWeekPickerView, this.defStyleAttr, this.defStyleRes);
        Intrinsics.checkNotNullExpressionValue(r6, "context.obtainStyledAttr…    defStyleRes\n        )");
    L30:
        th = move-exception;
        r6.recycle();
        throw th;
    L4:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor) == false) goto L7;
        this.selectedBackgroundColor = r6.getColor(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_selectedBackgroundColor, this.selectedBackgroundColor);     // Catch: Throwable -> L30
    L7:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor) == false) goto L10;
        this.unSelectedBackgroundColor = r6.getColor(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_unSelectedBackgroundColor, this.unSelectedBackgroundColor);     // Catch: Throwable -> L30
    L10:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_dayTextAppearance) == false) goto L13;
        this.dayTextAppearance = r6.getResourceId(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_dayTextAppearance, this.dayTextAppearance);     // Catch: Throwable -> L30
    L13:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_selectionMode) == false) goto L20;
        if (r6.getInt(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_selectionMode, this.selectionMode.ordinal()) != PickerSelectionMode.SINGLE.ordinal()) goto L17;
        PickerSelectionMode r7 = PickerSelectionMode.SINGLE;     // Catch: Throwable -> L30
    L18:
        this.selectionMode = r7;     // Catch: Throwable -> L30
        goto L20
    L17:
        r7 = PickerSelectionMode.MULTIPLE;     // Catch: Throwable -> L30
    L20:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_itemSize) == false) goto L23;
        this.itemSizePx = r6.getDimensionPixelSize(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_itemSize, this.itemSizePx);     // Catch: Throwable -> L30
    L23:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_itemHPadding) == false) goto L26;
        this.itemHorizontalPaddingPx = r6.getDimensionPixelSize(com.obric.common.oui.R.styleable.OWeekPickerView_o_pv_itemHPadding, this.itemHorizontalPaddingPx);     // Catch: Throwable -> L30
    L26:
        if (r6.hasValue(com.obric.common.oui.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek) == false) goto L28;
        this.firstDayOfWeek = r6.getInt(com.obric.common.oui.R.styleable.OWeekPickerView_o_wpv_firstDayOfWeek, this.firstDayOfWeek);     // Catch: Throwable -> L30
    L28:
        r6.recycle();
    }

    private static final String generateLabels$labelOf(Context r0, int r1) {
        switch(r1) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        String r2 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_sat);
        Intrinsics.checkNotNullExpressionValue(r2, "context.getString(R.stri…calendar_day_of_week_sat)");
        return r2;
    L5:
        String r3 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_fri);
        Intrinsics.checkNotNullExpressionValue(r3, "context.getString(R.stri…calendar_day_of_week_fri)");
        return r3;
    L6:
        String r4 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_thu);
        Intrinsics.checkNotNullExpressionValue(r4, "context.getString(R.stri…calendar_day_of_week_thu)");
        return r4;
    L7:
        String r5 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_wed);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri…calendar_day_of_week_wed)");
        return r5;
    L8:
        String r6 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_tue);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.stri…calendar_day_of_week_tue)");
        return r6;
    L9:
        String r7 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_mon);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.stri…calendar_day_of_week_mon)");
        return r7;
    L10:
        String r8 = r0.getString(com.obric.common.oui.R.string.oui_calendar_day_of_week_sun);
        Intrinsics.checkNotNullExpressionValue(r8, "context.getString(R.stri…calendar_day_of_week_sun)");
        return r8;
    }

    private final String[] generateLabels(Context r5, int r6) {
        String[] r0 = new String[7];
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= 7) goto L5;
        r0[r2] = "";
        r2 = r2 + 1;
    L5:
        if (r1 >= 7) goto L7;
        r0[r1] = generateLabels$labelOf(r5, r6);
        r6 = (r6 % 7) + 1;
        r1 = r1 + 1;
        goto L5
    L7:
        return r0;
    }

    private final void createChildren() {
        removeAllViews();
        this.chips.clear();
        int r0 = this.labels.length;
        final int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        int r3 = r2 + 1;
        Context r5 = getContext();
        Intrinsics.checkNotNullExpressionValue(r5, "context");
        final DayChip r4 = new DayChip(r5, this.selectedTextFontWeight, this.unselectedTextFontWeight);
        r4.setText(this.labels[r2]);
        r4.setGravity(17);
        applyDayTextAppearance(r4);
        r4.applyTextFontWeight();
        r4.setSingleLine(true);
        r4.setTextAlignment(4);
        r4.setClickable(true);
        r4.setFocusable(true);
        if (this.selectable.get(r2).booleanValue() == false) goto L7;
        float r6 = 1.0f;
    L8:
        r4.setAlpha(r6);
        r4.setSize(this.itemSizePx);
        r4.setBackgroundColorColor(this.selectedBackgroundColor, this.unSelectedBackgroundColor);
        r4.setChecked(false);
        r4.setOnClickListener(new OWeekPickerView$$ExternalSyntheticLambda0(this, r2, r4));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-2, -2);
        int r8 = this.itemHorizontalPaddingPx / 2;
        if (r2 != 0) goto L11;
        int r9 = 0;
    L13:
        if (r2 != ArraysKt.getLastIndex(this.labels)) goto L15;
        r8 = 0;
    L15:
        r7.setMargins(r9, 0, r8, 0);
        r7.gravity = 17;
        addView(r4, r7);
        this.chips.add(r4);
        r2 = r3;
        goto L3
    L11:
        r9 = r8;
        goto L13
    L7:
        r6 = 0.45f;
        goto L8
    }

    /* JADX INFO: renamed from: createChildren$lambda-1$lambda-0, reason: not valid java name */
    private static final void m227createChildren$lambda1$lambda0(OWeekPickerView r1, int r2, DayChip r3, View r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        if (r1.selectable.get(r2).booleanValue() == true) goto L6;
        return;
    L6:
        if (r1.selectionMode != PickerSelectionMode.SINGLE) goto L11;
        Iterator<DayChip> r5 = r1.chips.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        DayChip r6 = r5.next();
        r6.setChecked(Intrinsics.areEqual(r6, r3));
    L12:
        r1.dispatchSelection();
        return;
    L11:
        r3.toggle();
        goto L12
    }

    private final void resetSelectable(int r4) {
        this.selectable.clear();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.selectable.add(true);
        r0 = r0 + 1;
        goto L3
    }

    private final void resizeSelectable(int r5) {
        List r0 = CollectionsKt.toList(this.selectable);
        this.selectable.clear();
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L9;
        List<Boolean> r2 = this.selectable;
        Boolean r3 = (Boolean) CollectionsKt.getOrNull(r0, r1);
        if (r3 != null) goto L7;
        boolean r4 = true;
    L8:
        r2.add(Boolean.valueOf(r4));
        r1 = r1 + 1;
        goto L3
    L7:
        r4 = r3.booleanValue();
        goto L8
    }

    private final void updateLabels(String[] r7) {
        List<DayChip> r0 = this.chips;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DayChip) r4).isChecked() == false) goto L11;
        Integer r6 = Integer.valueOf(r3);
    L12:
        if (r6 == null) goto L14;
        r1.add(r6);
    L14:
        r3 = r5;
        goto L4
    L11:
        r6 = null;
        goto L12
    L15:
        ArrayList r8 = r1;
        if (r7.length == getChildCount()) goto L18;
        boolean r9 = true;
    L19:
        Object[] r10 = Arrays.copyOf(r7, r7.length);
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(this, size)");
        String[] r11 = (String[]) r10;
        this.labels = r11;
        if (r9 == false) goto L22;
        resizeSelectable(r11.length);
        createChildren();
    L23:
        ArrayList r12 = new ArrayList();
        Iterator r13 = r8.iterator();
    L25:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        int r15 = ((Number) r14).intValue();
        if (r15 >= 0) goto L29;
    L31:
        boolean r16 = false;
    L32:
        if (r16 == false) goto L25;
        r12.add(r14);
        goto L25
    L29:
        if (r15 >= this.labels.length) goto L31;
        r16 = true;
        goto L32
    L34:
        setSelectedDays(r12);
        requestLayout();
        return;
    L22:
        updateChildrenText();
        goto L23
    L18:
        r9 = false;
        goto L19
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
        ((DayChip) r2).setText(this.labels[r1]);
        r1 = r3;
        goto L4
    }

    private final void dispatchSelection() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.chips.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((DayChip) r3).isChecked() == false) goto L11;
        r0.add(Integer.valueOf(r2));
    L11:
        r2 = r4;
        goto L4
    L12:
        OnDaysChangedListener r5 = this.onDaysChangedListener;
        if (r5 == null) goto L20;
        r5.onChanged(r0);
        return;
    }

    public final void setSelectionMode(PickerSelectionMode r6) {
        Intrinsics.checkNotNullParameter(r6, SearchConfigType.KEY_MODE);
        this.selectionMode = r6;
        if (r6 != PickerSelectionMode.SINGLE) goto L31;
        Iterator<DayChip> r7 = this.chips.iterator();
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
        DayChip r5 = (DayChip) r3;
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

    public final void setBackgroundColorColor(int r2, int r3) {
        this.selectedBackgroundColor = r2;
        this.unSelectedBackgroundColor = r3;
        Iterator<T> r1 = this.chips.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((DayChip) r1.next()).setBackgroundColorColor(r2, r3);
        goto L4
    }

    public final void setDayTextAppearance(int r2) {
        if (r2 != 0) goto L4;
        return;
    L4:
        this.dayTextAppearance = r2;
        Iterator<T> r3 = this.chips.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        DayChip r0 = (DayChip) r3.next();
        applyDayTextAppearance(r0);
        r0.applyTextFontWeight();
        goto L6
    }

    public final void setItemSizeDp(int r3) {
        this.itemSizePx = OUnitExtensionKt.vdp(this, r3);
        Iterator<T> r4 = this.chips.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((DayChip) r4.next()).setSize(this.itemSizePx);
        goto L4
    L6:
        requestLayout();
    }

    public final void setItemHorizontalPaddingDp(int r2) {
        int r3 = OUnitExtensionKt.vdp(this, r2);
        this.itemHorizontalPaddingPx = r3;
        updateChildMargins(r3);
    }

    public final void setOnDaysChangedListener(OnDaysChangedListener r1) {
        this.onDaysChangedListener = r1;
    }

    public final void setFirstDayOfWeek(int r2) {
        this.firstDayOfWeek = r2;
        Context r3 = getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "context");
        updateLabels(generateLabels(r3, this.firstDayOfWeek));
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
        DayChip r5 = (DayChip) r3;
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
        Iterator<T> r9 = this.chips.iterator();
    L20:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        int r11 = r2 + 1;
        if (r2 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();
    L24:
        ((DayChip) r10).setChecked(r7.contains(Integer.valueOf(r2)));
        r2 = r11;
        goto L20
    }

    public final void setDaySelectable(int r3, boolean r4) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        this.selectable.set(r3, Boolean.valueOf(r4));
        DayChip r2 = (DayChip) CollectionsKt.getOrNull(this.chips, r3);
        if (r2 == null) goto L17;
        if (r4 == false) goto L14;
        float r5 = 1.0f;
    L15:
        r2.setAlpha(r5);
        return;
    L14:
        r5 = 0.45f;
        goto L15
    L17:
        return;
    L5:
        if (r3 >= this.labels.length) goto L7;
        r0 = true;
        goto L7
    }

    public final void setLabels(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        Object[] r3 = r2.toArray(new String[0]);
        if (r3 == null) goto L10;
        updateLabels((String[]) r3);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public final void setLabels(String[] r2) {
        Intrinsics.checkNotNullParameter(r2, "newLabels");
        setLabels(ArraysKt.toList(r2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r9, int r10) {
        int r0 = View.MeasureSpec.getSize(r9);
        int r1 = View.MeasureSpec.getMode(r9);
        int r2 = this.itemHorizontalPaddingPx;
        if (r1 == 0) goto L12;
        if (r0 <= 0) goto L12;
        int r3 = (r0 - getPaddingLeft()) - getPaddingRight();
        int r4 = getChildCount();
        int r5 = RangesKt.coerceAtLeast(r4 - 1, 0);
        int r6 = this.itemSizePx;
        if (((r4 * r6) + (this.itemHorizontalPaddingPx * r5)) <= r3) goto L12;
        int r7 = r3 - (r4 * r6);
        if (r7 <= 0) goto L11;
        if (r5 <= 0) goto L11;
        r2 = r7 / r5;
    L11:
        r2 = 0;
    L12:
        updateChildMargins(r2);
        super.onMeasure(r9, r10);
    }

    private final void updateChildMargins(int r9) {
        int r10 = r9 / 2;
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        int r3 = r2 + 1;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L18;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L20;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5;
        if (r2 != 0) goto L12;
        int r7 = 0;
    L14:
        if (r2 != (getChildCount() - 1)) goto L16;
        int r8 = 0;
    L17:
        r6.setMargins(r7, 0, r8, 0);
        r4.setLayoutParams(r6);
        goto L18
    L16:
        r8 = r10;
        goto L17
    L12:
        r7 = r10;
        goto L14
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L18:
        r2 = r3;
        goto L3
    }

    private final void applyDayTextAppearance(DayChip r2) {
        if (this.dayTextAppearance == 0) goto L6;
        r2.setTextAppearance(getContext(), this.dayTextAppearance);
        return;
    }
}
