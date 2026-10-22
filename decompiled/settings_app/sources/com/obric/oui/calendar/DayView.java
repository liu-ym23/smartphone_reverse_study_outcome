package com.obric.oui.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import com.obric.common.oui.R;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.TextViewFontWeightUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class DayView extends AppCompatCheckedTextView {
    private final Rect circleDrawableRect;
    private int circleSizeDp;
    private DayFormatter contentDescriptionFormatter;
    private Drawable customBackground;
    private CalendarDay date;
    private final int fadeTime;
    private DayFormatter formatter;
    private boolean isDecoratedDisabled;
    private boolean isInMonth;
    private boolean isInRange;
    private boolean isInVisibleEnabled;
    private Drawable mCircleDrawable;
    private int selectedTextFontWeight;
    private int selectionColor;
    private Drawable selectionDrawable;
    private int showOtherDates;
    private final Rect tempRect;
    private int unselectedTextFontWeight;

    public DayView(Context r4, CalendarDay r5) {
        super(r4);
        this.selectionColor = -7829368;
        this.circleSizeDp = 40;
        this.fadeTime = 50;
        this.customBackground = null;
        DayFormatter r6 = DayFormatter.DEFAULT;
        this.formatter = r6;
        this.contentDescriptionFormatter = r6;
        this.isInRange = true;
        this.isInMonth = true;
        this.isInVisibleEnabled = true;
        this.isDecoratedDisabled = false;
        this.showOtherDates = 4;
        this.tempRect = new Rect();
        this.circleDrawableRect = new Rect();
        this.selectedTextFontWeight = getResources().getInteger(R.integer.oui_font_weight_bold);
        this.unselectedTextFontWeight = getResources().getInteger(R.integer.oui_font_weight_regular);
        setSelectionColor(this.selectionColor);
        setGravity(17);
        setIncludeFontPadding(false);
        setTextAlignment(4);
        setDay(r5);
    }

    public void setDay(CalendarDay r1) {
        this.date = r1;
        setText(getLabel());
    }

    public void setDayFormatter(DayFormatter r8) {
        DayFormatter r0 = this.contentDescriptionFormatter;
        if (r0 != this.formatter) goto L5;
        r0 = r8;
    L5:
        this.contentDescriptionFormatter = r0;
        if (r8 != null) goto L8;
        r8 = DayFormatter.DEFAULT;
    L8:
        this.formatter = r8;
        CharSequence r9 = getText();
        if ((r9 instanceof Spanned) == false) goto L11;
        Object[] r10 = ((Spanned) r9).getSpans(0, r9.length(), Object.class);
    L12:
        SpannableString r1 = new SpannableString(getLabel());
        if (r10 == null) goto L17;
        int r2 = r10.length;
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L17;
        r1.setSpan(r10[r3], 0, r1.length(), 33);
        r3 = r3 + 1;
    L17:
        setText(r1);
        return;
    L11:
        r10 = null;
        goto L12
    }

    public void setDayFormatterContentDescription(DayFormatter r1) {
        if (r1 != null) goto L4;
        r1 = this.formatter;
    L4:
        this.contentDescriptionFormatter = r1;
        setContentDescription(getContentDescriptionLabel());
    }

    public String getLabel() {
        return this.formatter.format(this.date);
    }

    public String getContentDescriptionLabel() {
        DayFormatter r0 = this.contentDescriptionFormatter;
        if (r0 != null) goto L6;
        return this.formatter.format(this.date);
    L6:
        return r0.format(this.date);
    }

    public void setSelectionColor(int r1) {
        this.selectionColor = r1;
        regenerateBackground();
    }

    public void setCalendarMode(CalendarMode r1) {
        regenerateBackground();
    }

    public void setSelectionDrawable(Drawable r2) {
        if (r2 != null) goto L4;
        this.selectionDrawable = null;
    L5:
        regenerateBackground();
        return;
    L4:
        this.selectionDrawable = r2.getConstantState().newDrawable(getResources());
        goto L5
    }

    public void setCustomBackground(Drawable r2) {
        if (r2 != null) goto L4;
        this.customBackground = null;
    L5:
        invalidate();
        return;
    L4:
        this.customBackground = r2.getConstantState().newDrawable(getResources());
        goto L5
    }

    public CalendarDay getDate() {
        return this.date;
    }

    private void setEnabled() {
        int r2 = 0;
        if (this.isInMonth == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (this.isInRange == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        super.setEnabled(r3);
        boolean r4 = MaterialCalendarView.showOtherMonths(this.showOtherDates);
        if (MaterialCalendarView.showOutOfRange(this.showOtherDates) == true) goto L21;
        if (r4 == true) goto L21;
        boolean r5 = false;
    L22:
        boolean r6 = MaterialCalendarView.showDecoratedDisabled(this.showOtherDates);
        boolean r7 = this.isInMonth;
        if (r7 == true) goto L26;
        if (r4 == false) goto L26;
        r0 = true;
    L26:
        boolean r8 = this.isInRange;
        if (r8 == true) goto L31;
        if (r5 == false) goto L31;
        r0 = r0 | r7;
    L31:
        if (this.isDecoratedDisabled == false) goto L38;
        if (r6 == false) goto L38;
        if (r7 == false) goto L36;
        if (r8 == false) goto L36;
        boolean r9 = true;
    L37:
        r0 = r0 | r9;
    L36:
        r9 = false;
    L38:
        if (r7 == true) goto L41;
        if (r0 == false) goto L41;
        this.isInVisibleEnabled = false;
        setTextColor(getTextColors().getColorForState(new int[]{-16842910}, -7829368));
    L42:
        if (r0 == true) goto L45;
        r2 = 4;
    L45:
        setVisibility(r2);
        return;
    L41:
        this.isInVisibleEnabled = true;
    L21:
        r5 = true;
        goto L22
    L13:
        if (this.isDecoratedDisabled == true) goto L15;
        r3 = true;
        goto L16
    L5:
        if (this.isInRange == false) goto L9;
        if (this.isDecoratedDisabled == true) goto L9;
        r0 = true;
        goto L11
    }

    public boolean isVisibleEnabled() {
        return this.isInVisibleEnabled;
    }

    protected void setupSelection(int r1, boolean r2, boolean r3) {
        this.showOtherDates = r1;
        this.isInMonth = r3;
        this.isInRange = r2;
        setEnabled();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r3) {
        Drawable r0 = this.customBackground;
        if (r0 == null) goto L5;
        r0.setBounds(this.tempRect);
        this.customBackground.setState(getDrawableState());
        this.customBackground.draw(r3);
    L5:
        this.mCircleDrawable.setBounds(this.circleDrawableRect);
        super.onDraw(r3);
    }

    private void regenerateBackground() {
        Drawable r0 = this.selectionDrawable;
        if (r0 == null) goto L5;
        setBackgroundDrawable(r0);
        return;
    L5:
        Drawable r1 = generateBackground(this.selectionColor, 50, this.circleDrawableRect);
        this.mCircleDrawable = r1;
        setBackgroundDrawable(r1);
    }

    private Drawable generateBackground(int r3, int r4, Rect r5) {
        StateListDrawable r6 = new StateListDrawable();
        r6.setExitFadeDuration(r4);
        r6.addState(new int[]{android.R.attr.state_checked}, generateShapeDrawable(r3));
        r6.addState(new int[0], generateShapeDrawable(0));
        return r6;
    }

    private Drawable generateShapeDrawable(int r2) {
        ShapeDrawable r1 = new ShapeDrawable(new OvalShape());
        r1.getPaint().setColor(r2);
        return r1;
    }

    private Drawable generateRippleDrawable(int r2, Rect r3) {
        return new RippleDrawable(ColorStateList.valueOf(r2), null, generateShapeDrawable(-1));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckedTextView, android.widget.TextView
    public void setTextAppearance(Context r1, int r2) {
        super.setTextAppearance(r1, r2);
        setIncludeFontPadding(false);
        applyTextFontWeight();
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

    private void applyTextFontWeight() {
        if (isChecked() == false) goto L5;
        int r0 = this.selectedTextFontWeight;
    L6:
        TextViewFontWeightUtils.applyTextFontWeight(this, r0);
        return;
    L5:
        r0 = this.unselectedTextFontWeight;
        goto L6
    }

    void applyFacade(DayViewFacade r7) {
        this.isDecoratedDisabled = r7.areDaysDisabled();
        setEnabled();
        setCustomBackground(r7.getBackgroundDrawable());
        setSelectionDrawable(r7.getSelectionDrawable());
        List<DayViewFacade.Span> r8 = r7.getSpans();
        if (r8.isEmpty() == true) goto L9;
        String r0 = getLabel();
        SpannableString r1 = new SpannableString(getLabel());
        Iterator<DayViewFacade.Span> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L8;
        r1.setSpan(r9.next().span, 0, r0.length(), 33);
        goto L6
    L8:
        setText(r1);
        return;
    L9:
        setText(getLabel());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        calculateBounds(r4 - r2, r5 - r3);
        regenerateBackground();
    }

    private void calculateBounds(int r4, int r5) {
        int r0 = Math.min((int) dpToPx(this.circleSizeDp), Math.min(r4, r5));
        int r6 = (r4 - r0) / 2;
        int r7 = (r5 - r0) / 2;
        int r2 = r6 + r0;
        int r1 = r0 + r7;
        this.tempRect.set(r6, r7, r2, r1);
        this.circleDrawableRect.set(r6, r7, r2, r1);
    }

    private float dpToPx(float r1) {
        return r1 * getResources().getDisplayMetrics().density;
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        VibratorSmt.vibrateEffectWithHapticPlayer(getContext(), 1);
        return r0;
    }
}
