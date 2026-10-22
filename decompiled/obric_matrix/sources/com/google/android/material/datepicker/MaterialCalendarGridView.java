package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;

    public MaterialCalendarGridView(Context r2) {
        this(r2, null);
    }

    public MaterialCalendarGridView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MaterialCalendarGridView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext()) == false) goto L5;
        setNextFocusLeftId(R.id.cancel_button);
        setNextFocusRightId(R.id.confirm_button);
    L5:
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    private void gainFocus(int r2, Rect r3) {
        if (r2 != 33) goto L7;
        int r4 = getAdapter().lastPositionInMonth();
    L5:
        setSelection(r4);
        return;
    L7:
        if (r2 != 130) goto L9;
        r4 = getAdapter().firstPositionInMonth();
        goto L5
    L9:
        super.onFocusChanged(true, r2, r3);
    }

    private View getChildAtPosition(int r2) {
        return getChildAt(r2 - getFirstVisiblePosition());
    }

    private static int horizontalMidPoint(@NonNull View r1) {
        return r1.getLeft() + (r1.getWidth() / 2);
    }

    private static boolean skipMonth(@Nullable Long r3, @Nullable Long r4, @Nullable Long r5, @Nullable Long r6) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L16;
        if (r5 == null) goto L17;
        if (r6 != null) goto L9;
        return true;
    L9:
        if (r5.longValue() <= r4.longValue()) goto L11;
        return true;
    L11:
        if (r6.longValue() < r3.longValue()) goto L20;
        return false;
    L20:
        return true;
    L17:
        return true;
    L16:
        return true;
    L15:
        return true;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@NonNull Canvas r27) {
        MaterialCalendarGridView r0 = this;
        super.onDraw(r27);
        MonthAdapter r1 = getAdapter();
        DateSelector<?> r2 = r1.dateSelector;
        CalendarStyle r3 = r1.calendarStyle;
        int r4 = Math.max(r1.firstPositionInMonth(), getFirstVisiblePosition());
        int r5 = Math.min(r1.lastPositionInMonth(), getLastVisiblePosition());
        Long r6 = r1.getItem(r4);
        Long r7 = r1.getItem(r5);
        Iterator<Pair<Long, Long>> r8 = r2.getSelectedRanges().iterator();
    L4:
        if (r8.hasNext() == false) goto L55;
        Pair<Long, Long> r9 = r8.next();
        Long r10 = r9.first;
        if (r10 != null) goto L8;
        r0 = this;
        goto L4
    L8:
        if (r9.second == null) goto L4;
        long r11 = r10.longValue();
        long r12 = r9.second.longValue();
        if (skipMonth(r6, r7, Long.valueOf(r11), Long.valueOf(r12)) == true) goto L4;
        boolean r13 = ViewUtils.isLayoutRtl(this);
        if (r11 < r6.longValue()) goto L16;
        r0.dayCompute.setTimeInMillis(r11);
        int r14 = r1.dayToPosition(r0.dayCompute.get(5));
        int r15 = horizontalMidPoint(r0.getChildAtPosition(r14));
    L25:
        if (r12 > r7.longValue()) goto L27;
        r0.dayCompute.setTimeInMillis(r12);
        int r16 = r1.dayToPosition(r0.dayCompute.get(5));
        int r17 = horizontalMidPoint(r0.getChildAtPosition(r16));
    L35:
        int r18 = (int) r1.getItemId(r14);
        int r19 = r4;
        int r110 = r5;
        int r20 = (int) r1.getItemId(r16);
    L36:
        if (r18 > r20) goto L53;
        int r21 = getNumColumns() * r18;
        int r111 = (r21 + getNumColumns()) - 1;
        View r112 = r0.getChildAtPosition(r21);
        int r22 = r112.getTop() + r3.day.getTopInset();
        MonthAdapter r113 = r1;
        int r23 = r112.getBottom() - r3.day.getBottomInset();
        if (r13 == true) goto L45;
        if (r21 <= r14) goto L41;
        int r24 = 0;
    L42:
        if (r16 <= r111) goto L44;
        int r114 = getWidth();
    L52:
        r27.drawRect(r24, r22, r114, r23, r3.rangeFill);
        r18 = r18 + 1;
        r0 = this;
        r8 = r8;
        r1 = r113;
        goto L36
    L44:
        r114 = r17;
        goto L52
    L41:
        r24 = r15;
        goto L42
    L45:
        if (r16 <= r111) goto L47;
        int r115 = 0;
    L48:
        if (r21 <= r14) goto L50;
        int r25 = getWidth();
    L51:
        int r26 = r115;
        r114 = r25;
        r24 = r26;
        goto L52
    L50:
        r25 = r15;
        goto L51
    L47:
        r115 = r17;
        goto L48
    L53:
        r0 = this;
        r4 = r19;
        r5 = r110;
        goto L4
    L27:
        if (r1.isLastInRow(r5) == false) goto L29;
        int r116 = getWidth();
    L33:
        r17 = r116;
        r16 = r5;
        goto L35
    L29:
        View r117 = r0.getChildAtPosition(r5);
        if (r13 == true) goto L32;
        r116 = r117.getRight();
        goto L33
    L32:
        r116 = r117.getLeft();
        goto L33
    L16:
        if (r1.isFirstInRow(r4) == false) goto L18;
        int r28 = 0;
    L22:
        r15 = r28;
        r14 = r4;
        goto L25
    L18:
        View r29 = r0.getChildAtPosition(r4 - 1);
        if (r13 == true) goto L21;
        r28 = r29.getRight();
        goto L22
    L21:
        r28 = r29.getLeft();
        goto L22
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        if (r1 == false) goto L4;
        gainFocus(r2, r3);
        return;
    L4:
        super.onFocusChanged(false, r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r4, KeyEvent r5) {
        if (super.onKeyDown(r4, r5) == true) goto L6;
        return false;
    L6:
        if (getSelectedItemPosition() != (-1)) goto L8;
    L15:
        return true;
    L8:
        if (getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) goto L15;
        if (19 != r4) goto L14;
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    L14:
        return false;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.nestedScrollable == false) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r2, r3);
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r3) {
        if ((r3 instanceof MonthAdapter) == false) goto L7;
        super.setAdapter(r3);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r2) {
        if (r2 >= getAdapter().firstPositionInMonth()) goto L5;
        r2 = getAdapter().firstPositionInMonth();
    L5:
        super.setSelection(r2);
    }
}
