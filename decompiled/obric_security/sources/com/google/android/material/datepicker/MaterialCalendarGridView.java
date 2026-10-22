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

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

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

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r2) {
        if (r2 >= getAdapter().firstPositionInMonth()) goto L5;
        super.setSelection(getAdapter().firstPositionInMonth());
        return;
    L5:
        super.setSelection(r2);
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

    @Override // android.widget.GridView, android.widget.AdapterView
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r3) {
        if ((r3 instanceof MonthAdapter) == false) goto L7;
        super.setAdapter(r3);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas r26) {
        MaterialCalendarGridView r0 = this;
        super.onDraw(r26);
        MonthAdapter r1 = getAdapter();
        DateSelector<?> r2 = r1.dateSelector;
        CalendarStyle r3 = r1.calendarStyle;
        Long r4 = r1.getItem(r1.firstPositionInMonth());
        Long r5 = r1.getItem(r1.lastPositionInMonth());
        Iterator<Pair<Long, Long>> r6 = r2.getSelectedRanges().iterator();
    L4:
        if (r6.hasNext() == false) goto L50;
        Pair<Long, Long> r7 = r6.next();
        if (r7.first == null) goto L49;
        if (r7.second == null) goto L4;
        long r8 = r7.first.longValue();
        long r9 = r7.second.longValue();
        if (skipMonth(r4, r5, Long.valueOf(r8), Long.valueOf(r9)) == true) goto L4;
        boolean r10 = ViewUtils.isLayoutRtl(this);
        if (r8 >= r4.longValue()) goto L21;
        int r11 = r1.firstPositionInMonth();
        if (r1.isFirstInRow(r11) == false) goto L18;
        int r12 = 0;
    L23:
        if (r9 <= r5.longValue()) goto L30;
        int r13 = Math.min(r1.lastPositionInMonth(), getChildCount() - 1);
        if (r1.isLastInRow(r13) == false) goto L27;
        int r14 = getWidth();
    L31:
        int r15 = (int) r1.getItemId(r11);
        int r16 = (int) r1.getItemId(r13);
    L32:
        if (r15 > r16) goto L49;
        int r17 = getNumColumns() * r15;
        int r18 = (getNumColumns() + r17) - 1;
        View r19 = r0.getChildAt(r17);
        int r110 = r19.getTop() + r3.day.getTopInset();
        int r20 = r19.getBottom() - r3.day.getBottomInset();
        if (r10 == true) goto L41;
        if (r17 <= r11) goto L37;
        int r111 = 0;
    L38:
        if (r13 <= r18) goto L40;
        int r112 = getWidth();
    L48:
        r26.drawRect(r111, r110, r112, r20, r3.rangeFill);
        r15 = r15 + 1;
        r0 = this;
        r1 = r1;
        goto L32
    L40:
        r112 = r14;
        goto L48
    L37:
        r111 = r12;
        goto L38
    L41:
        if (r13 <= r18) goto L43;
        int r113 = 0;
    L44:
        if (r17 <= r11) goto L46;
        int r114 = getWidth();
    L47:
        int r24 = r113;
        r112 = r114;
        r111 = r24;
        goto L48
    L46:
        r114 = r12;
        goto L47
    L43:
        r113 = r14;
        goto L44
    L27:
        if (r10 == true) goto L29;
        r14 = r0.getChildAt(r13).getRight();
        goto L31
    L29:
        r14 = r0.getChildAt(r13).getLeft();
        goto L31
    L30:
        r0.dayCompute.setTimeInMillis(r9);
        r13 = r1.dayToPosition(r0.dayCompute.get(5));
        r14 = horizontalMidPoint(r0.getChildAt(r13));
        goto L31
    L18:
        if (r10 == true) goto L20;
        r12 = r0.getChildAt(r11 - 1).getRight();
        goto L23
    L20:
        r12 = r0.getChildAt(r11 - 1).getLeft();
        goto L23
    L21:
        r0.dayCompute.setTimeInMillis(r8);
        r11 = r1.dayToPosition(r0.dayCompute.get(5));
        r12 = horizontalMidPoint(r0.getChildAt(r11));
    L49:
        r0 = this;
        goto L4
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int r2, int r3) {
        if (this.nestedScrollable == false) goto L5;
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
        ViewGroup.LayoutParams r4 = getLayoutParams();
        r4.height = getMeasuredHeight();
        return;
    L5:
        super.onMeasure(r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean r1, int r2, Rect r3) {
        if (r1 == false) goto L4;
        gainFocus(r2, r3);
        return;
    L4:
        super.onFocusChanged(false, r2, r3);
    }

    private void gainFocus(int r2, Rect r3) {
        if (r2 != 33) goto L6;
        setSelection(getAdapter().lastPositionInMonth());
        return;
    L6:
        if (r2 != 130) goto L8;
        setSelection(getAdapter().firstPositionInMonth());
        return;
    L8:
        super.onFocusChanged(true, r2, r3);
    }

    private static boolean skipMonth(Long r3, Long r4, Long r5, Long r6) {
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

    private static int horizontalMidPoint(View r1) {
        return r1.getLeft() + (r1.getWidth() / 2);
    }
}
