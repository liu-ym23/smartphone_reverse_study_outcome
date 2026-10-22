package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class PinKeyboardLayoutBinding implements ViewBinding {
    public final View bottomGap;
    public final LinearLayout easyPasswordKeyboard0;
    public final LinearLayout easyPasswordKeyboard1;
    public final LinearLayout easyPasswordKeyboard2;
    public final LinearLayout easyPasswordKeyboard3;
    public final LinearLayout easyPasswordKeyboard4;
    public final LinearLayout easyPasswordKeyboard5;
    public final LinearLayout easyPasswordKeyboard6;
    public final LinearLayout easyPasswordKeyboard7;
    public final LinearLayout easyPasswordKeyboard8;
    public final LinearLayout easyPasswordKeyboard9;
    public final Button easyPasswordKeyboardBlank;
    public final TextView forgetPassword;
    public final RelativeLayout keyboard;
    public final OButton pinDel;
    private final FrameLayout rootView;
    public final ConstraintLayout row1;
    public final ConstraintLayout row2;
    public final ConstraintLayout row3;
    public final ConstraintLayout row4;
    public final TextView switchDigit;
    public final TextView useSmilingUnlock;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PinKeyboardLayoutBinding(FrameLayout r3, View r4, LinearLayout r5, LinearLayout r6, LinearLayout r7, LinearLayout r8, LinearLayout r9, LinearLayout r10, LinearLayout r11, LinearLayout r12, LinearLayout r13, LinearLayout r14, Button r15, TextView r16, RelativeLayout r17, OButton r18, ConstraintLayout r19, ConstraintLayout r20, ConstraintLayout r21, ConstraintLayout r22, TextView r23, TextView r24) {
        this.rootView = r3;
        this.bottomGap = r4;
        this.easyPasswordKeyboard0 = r5;
        this.easyPasswordKeyboard1 = r6;
        this.easyPasswordKeyboard2 = r7;
        this.easyPasswordKeyboard3 = r8;
        this.easyPasswordKeyboard4 = r9;
        this.easyPasswordKeyboard5 = r10;
        this.easyPasswordKeyboard6 = r11;
        this.easyPasswordKeyboard7 = r12;
        this.easyPasswordKeyboard8 = r13;
        this.easyPasswordKeyboard9 = r14;
        this.easyPasswordKeyboardBlank = r15;
        this.forgetPassword = r16;
        this.keyboard = r17;
        this.pinDel = r18;
        this.row1 = r19;
        this.row2 = r20;
        this.row3 = r21;
        this.row4 = r22;
        this.switchDigit = r23;
        this.useSmilingUnlock = r24;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PinKeyboardLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PinKeyboardLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.pin_keyboard_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PinKeyboardLayoutBinding bind(View r25) {
        int r1 = R.id.bottom_gap;
        View r4 = ViewBindings.findChildViewById(r25, R.id.bottom_gap);
        if (r4 == null) goto L47;
        r1 = R.id.easy_password_keyboard_0;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_0);
        if (r5 == null) goto L47;
        r1 = R.id.easy_password_keyboard_1;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_1);
        if (r6 == null) goto L47;
        r1 = R.id.easy_password_keyboard_2;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_2);
        if (r7 == null) goto L47;
        r1 = R.id.easy_password_keyboard_3;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_3);
        if (r8 == null) goto L47;
        r1 = R.id.easy_password_keyboard_4;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_4);
        if (r9 == null) goto L47;
        r1 = R.id.easy_password_keyboard_5;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_5);
        if (r10 == null) goto L47;
        r1 = R.id.easy_password_keyboard_6;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_6);
        if (r11 == null) goto L47;
        r1 = R.id.easy_password_keyboard_7;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_7);
        if (r12 == null) goto L47;
        r1 = R.id.easy_password_keyboard_8;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_8);
        if (r13 == null) goto L47;
        r1 = R.id.easy_password_keyboard_9;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_9);
        if (r14 == null) goto L47;
        r1 = R.id.easy_password_keyboard_blank;
        Button r15 = (Button) ViewBindings.findChildViewById(r25, R.id.easy_password_keyboard_blank);
        if (r15 == null) goto L47;
        r1 = R.id.forget_password;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r25, R.id.forget_password);
        if (r16 == null) goto L47;
        r1 = R.id.keyboard;
        RelativeLayout r17 = (RelativeLayout) ViewBindings.findChildViewById(r25, R.id.keyboard);
        if (r17 == null) goto L47;
        r1 = R.id.pinDel;
        OButton r18 = (OButton) ViewBindings.findChildViewById(r25, R.id.pinDel);
        if (r18 == null) goto L47;
        r1 = R.id.row_1;
        ConstraintLayout r19 = (ConstraintLayout) ViewBindings.findChildViewById(r25, R.id.row_1);
        if (r19 == null) goto L47;
        r1 = R.id.row_2;
        ConstraintLayout r20 = (ConstraintLayout) ViewBindings.findChildViewById(r25, R.id.row_2);
        if (r20 == null) goto L47;
        r1 = R.id.row_3;
        ConstraintLayout r21 = (ConstraintLayout) ViewBindings.findChildViewById(r25, R.id.row_3);
        if (r21 == null) goto L47;
        r1 = R.id.row_4;
        ConstraintLayout r22 = (ConstraintLayout) ViewBindings.findChildViewById(r25, R.id.row_4);
        if (r22 == null) goto L47;
        r1 = R.id.switch_digit;
        TextView r23 = (TextView) ViewBindings.findChildViewById(r25, R.id.switch_digit);
        if (r23 == null) goto L47;
        r1 = R.id.use_smiling_unlock;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r25, R.id.use_smiling_unlock);
        if (r24 == null) goto L47;
        return new PinKeyboardLayoutBinding((FrameLayout) r25, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L47:
        throw new NullPointerException("Missing required view with ID: ".concat(r25.getResources().getResourceName(r1)));
    }
}
