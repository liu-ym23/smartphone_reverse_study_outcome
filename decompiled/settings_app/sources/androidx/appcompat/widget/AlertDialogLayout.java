package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context r1) {
        super(r1);
    }

    public AlertDialogLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int r2, int r3) {
        if (tryOnMeasure(r2, r3) == true) goto L6;
        super.onMeasure(r2, r3);
        return;
    }

    private boolean tryOnMeasure(int r17, int r18) {
        int r3 = getChildCount();
        View r4 = null;
        View r6 = null;
        View r7 = null;
        int r8 = 0;
    L4:
        if (r8 >= r3) goto L24;
        View r10 = getChildAt(r8);
        if (r10.getVisibility() == 8) goto L23;
        int r9 = r10.getId();
        if (r9 != R.id.topPanel) goto L12;
        r4 = r10;
        goto L23
    L12:
        if (r9 != R.id.buttonPanel) goto L15;
        r6 = r10;
        goto L23
    L15:
        if (r9 != R.id.contentPanel) goto L17;
    L20:
        if (r7 != null) goto L21;
        r7 = r10;
        goto L23
    L21:
        return false;
    L17:
        if (r9 == R.id.customPanel) goto L20;
        return false;
    L23:
        r8 = r8 + 1;
        goto L4
    L24:
        int r11 = View.MeasureSpec.getMode(r18);
        int r12 = View.MeasureSpec.getSize(r18);
        int r13 = View.MeasureSpec.getMode(r17);
        int r14 = getPaddingTop() + getPaddingBottom();
        if (r4 == null) goto L27;
        r4.measure(r17, 0);
        r14 = r14 + r4.getMeasuredHeight();
        int r5 = View.combineMeasuredStates(0, r4.getMeasuredState());
    L28:
        if (r6 == null) goto L30;
        r6.measure(r17, 0);
        int r15 = resolveMinimumHeight(r6);
        int r16 = r6.getMeasuredHeight() - r15;
        r14 = r14 + r15;
        r5 = View.combineMeasuredStates(r5, r6.getMeasuredState());
    L31:
        if (r7 == null) goto L36;
        if (r11 != 0) goto L34;
        int r19 = 0;
    L35:
        r7.measure(r17, r19);
        int r110 = r7.getMeasuredHeight();
        r14 = r14 + r110;
        r5 = View.combineMeasuredStates(r5, r7.getMeasuredState());
    L37:
        int r111 = r12 - r14;
        if (r6 == null) goto L43;
        int r112 = r14 - r15;
        int r113 = Math.min(r111, r16);
        if (r113 <= 0) goto L42;
        r111 = r111 - r113;
        r15 = r15 + r113;
    L42:
        r6.measure(r17, View.MeasureSpec.makeMeasureSpec(r15, 1073741824));
        r14 = r112 + r6.getMeasuredHeight();
        r5 = View.combineMeasuredStates(r5, r6.getMeasuredState());
    L43:
        if (r7 == null) goto L46;
        if (r111 <= 0) goto L46;
        r7.measure(r17, View.MeasureSpec.makeMeasureSpec(r110 + r111, r11));
        r14 = (r14 - r110) + r7.getMeasuredHeight();
        r5 = View.combineMeasuredStates(r5, r7.getMeasuredState());
    L46:
        int r20 = 0;
        int r21 = 0;
    L47:
        if (r20 >= r3) goto L52;
        View r22 = getChildAt(r20);
        if (r22.getVisibility() == 8) goto L51;
        r21 = Math.max(r21, r22.getMeasuredWidth());
    L51:
        r20 = r20 + 1;
        goto L47
    L52:
        setMeasuredDimension(View.resolveSizeAndState(r21 + (getPaddingLeft() + getPaddingRight()), r17, r5), View.resolveSizeAndState(r14, r18, 0));
        if (r13 == 1073741824) goto L67;
        forceUniformWidth(r3, r18);
        return true;
    L67:
        return true;
    L34:
        r19 = View.MeasureSpec.makeMeasureSpec(Math.max(0, r12 - r14), r11);
        goto L35
    L36:
        r110 = 0;
        goto L37
    L30:
        r15 = 0;
        r16 = 0;
        goto L31
    L27:
        r5 = 0;
        goto L28
    }

    private void forceUniformWidth(int r11, int r12) {
        int r0 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L10;
        View r3 = getChildAt(r1);
        if (r3.getVisibility() == 8) goto L9;
        LinearLayoutCompat.LayoutParams r8 = (LinearLayoutCompat.LayoutParams) r3.getLayoutParams();
        if (r8.width != (-1)) goto L9;
        int r9 = r8.height;
        r8.height = r3.getMeasuredHeight();
        measureChildWithMargins(r3, r0, 0, r12, 0);
        r8.height = r9;
    L9:
        r1 = r1 + 1;
        goto L3
    }

    private static int resolveMinimumHeight(View r3) {
        int r0 = ViewCompat.getMinimumHeight(r3);
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r3;
        if (r4.getChildCount() != 1) goto L11;
        return resolveMinimumHeight(r4.getChildAt(0));
    L11:
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        int r7 = getPaddingLeft();
        int r0 = r21 - r19;
        int r8 = r0 - getPaddingRight();
        int r9 = (r0 - r7) - getPaddingRight();
        int r1 = getMeasuredHeight();
        int r10 = getChildCount();
        int r2 = getGravity();
        int r3 = r2 & 112;
        int r11 = r2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (r3 != 16) goto L5;
        int r4 = getPaddingTop() + (((r22 - r20) - r1) / 2);
    L9:
        Drawable r5 = getDividerDrawable();
        if (r5 != null) goto L12;
        int r12 = 0;
    L13:
        int r13 = 0;
    L14:
        if (r13 >= r10) goto L35;
        View r6 = getChildAt(r13);
        if (r6 == null) goto L34;
        if (r6.getVisibility() == 8) goto L34;
        int r14 = r6.getMeasuredWidth();
        int r15 = r6.getMeasuredHeight();
        LinearLayoutCompat.LayoutParams r16 = (LinearLayoutCompat.LayoutParams) r6.getLayoutParams();
        int r17 = r16.gravity;
        if (r17 >= 0) goto L22;
        r17 = r11;
    L22:
        int r23 = GravityCompat.getAbsoluteGravity(r17, ViewCompat.getLayoutDirection(this)) & 7;
        if (r23 != 1) goto L25;
        int r24 = (((r9 - r14) / 2) + r7) + r16.leftMargin;
        int r25 = r16.rightMargin;
    L29:
        int r26 = r24 - r25;
    L31:
        if (hasDividerBeforeChildAt(r13) == false) goto L33;
        r4 = r4 + r12;
    L33:
        int r110 = r4 + r16.topMargin;
        setChildFrame(r6, r26, r110, r14, r15);
        r4 = r110 + (r15 + r16.bottomMargin);
        goto L34
    L25:
        if (r23 == 5) goto L27;
        r26 = r16.leftMargin + r7;
        goto L31
    L27:
        r24 = r8 - r14;
        r25 = r16.rightMargin;
    L34:
        r13 = r13 + 1;
        goto L14
    L35:
        return;
    L12:
        r12 = r5.getIntrinsicHeight();
        goto L13
    L5:
        if (r3 == 80) goto L7;
        r4 = getPaddingTop();
        goto L9
    L7:
        r4 = ((getPaddingTop() + r22) - r20) - r1;
        goto L9
    }

    private void setChildFrame(View r1, int r2, int r3, int r4, int r5) {
        r1.layout(r2, r3, r4 + r2, r5 + r3);
    }
}
