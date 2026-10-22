package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;

    public MaterialCalendarGridView(Context r2) {
        this(r2, null);
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

    private static int horizontalMidPoint(@NonNull View r1) {
        int r0 = r1.getLeft();
        return (r1.getWidth() / 2) + r0;
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

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(@NonNull Canvas r24) {
        MaterialCalendarGridView r0 = this;
        super.onDraw(r24);
        MonthAdapter r1 = getAdapter();
        DateSelector<?> r2 = r1.dateSelector;
        CalendarStyle r3 = r1.calendarStyle;
        Long r4 = r1.getItem(r1.firstPositionInMonth());
        Long r5 = r1.getItem(r1.lastPositionInMonth());
        Iterator<Pair<Long, Long>> r6 = r2.getSelectedRanges().iterator();
    L4:
        if (r6.hasNext() == false) goto L38;
        Pair<Long, Long> r7 = r6.next();
        Long r8 = r7.first;
        if (r8 == null) goto L37;
        if (r7.second == null) goto L4;
        Long r9 = r8;
        long r10 = r9.longValue();
        Long r11 = r7.second;
        long r12 = r11.longValue();
        if (skipMonth(r4, r5, r9, r11) == true) goto L12;
        if (r10 >= r4.longValue()) goto L19;
        int r13 = r1.firstPositionInMonth();
        if (r1.isFirstInRow(r13) == false) goto L18;
        int r14 = 0;
    L21:
        if (r12 <= r5.longValue()) goto L26;
        int r15 = Math.min(r1.lastPositionInMonth(), getChildCount() - 1);
        if (r1.isLastInRow(r15) == false) goto L25;
        int r16 = getWidth();
    L27:
        int r17 = (int) r1.getItemId(r13);
        int r18 = (int) r1.getItemId(r15);
    L28:
        if (r17 > r18) goto L37;
        int r19 = getNumColumns() * r17;
        int r110 = (getNumColumns() + r19) - 1;
        View r111 = r0.getChildAt(r19);
        int r112 = r111.getTop() + r3.day.getTopInset();
        int r113 = r111.getBottom() - r3.day.getBottomInset();
        if (r19 <= r13) goto L32;
        int r20 = 0;
    L33:
        if (r15 <= r110) goto L35;
        int r114 = getWidth();
    L36:
        r24.drawRect(r20, r112, r114, r113, r3.rangeFill);
        r17 = r17 + 1;
        r0 = this;
        goto L28
    L35:
        r114 = r16;
        goto L36
    L32:
        r20 = r14;
        goto L33
    L25:
        r16 = r0.getChildAt(r15).getRight();
        goto L27
    L26:
        r0.dayCompute.setTimeInMillis(r12);
        r15 = r1.dayToPosition(r0.dayCompute.get(5));
        r16 = horizontalMidPoint(r0.getChildAt(r15));
        goto L27
    L18:
        r14 = r0.getChildAt(r13 - 1).getRight();
        goto L21
    L19:
        r0.dayCompute.setTimeInMillis(r10);
        r13 = r1.dayToPosition(r0.dayCompute.get(5));
        r14 = horizontalMidPoint(r0.getChildAt(r13));
        goto L21
    L12:
        return;
    L37:
        r0 = this;
        goto L4
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean r1, int r2, Rect r3) {
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

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int r2) {
        if (r2 >= getAdapter().firstPositionInMonth()) goto L5;
        super.setSelection(getAdapter().firstPositionInMonth());
        return;
    L5:
        super.setSelection(r2);
    }

    public MaterialCalendarGridView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter r2) {
        if ((r2 instanceof MonthAdapter) == false) goto L7;
        super.setAdapter(r2);
        return;
    L7:
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()}));
    }

    public MaterialCalendarGridView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext()) == false) goto L5;
        setNextFocusLeftId(R.id.cancel_button);
        setNextFocusRightId(R.id.confirm_button);
    L5:
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @NonNull
    public MonthAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }
}
