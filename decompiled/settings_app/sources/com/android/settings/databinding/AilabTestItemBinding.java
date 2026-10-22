package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckBox;

/* JADX INFO: loaded from: classes2.dex */
public final class AilabTestItemBinding implements ViewBinding {
    public final View divider;
    public final OCheckBox option1;
    public final OCheckBox option2;
    public final OCheckBox option3;
    public final OCheckBox option4;
    public final LinearLayout optionLayout1;
    public final LinearLayout optionLayout2;
    public final LinearLayout optionLayout3;
    public final LinearLayout optionLayout4;
    public final TextView optionText1;
    public final TextView optionText2;
    public final TextView optionText3;
    public final TextView optionText4;
    public final TextView questionCode;
    public final TextView questionTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AilabTestItemBinding(LinearLayout r3, View r4, OCheckBox r5, OCheckBox r6, OCheckBox r7, OCheckBox r8, LinearLayout r9, LinearLayout r10, LinearLayout r11, LinearLayout r12, TextView r13, TextView r14, TextView r15, TextView r16, TextView r17, TextView r18) {
        this.rootView = r3;
        this.divider = r4;
        this.option1 = r5;
        this.option2 = r6;
        this.option3 = r7;
        this.option4 = r8;
        this.optionLayout1 = r9;
        this.optionLayout2 = r10;
        this.optionLayout3 = r11;
        this.optionLayout4 = r12;
        this.optionText1 = r13;
        this.optionText2 = r14;
        this.optionText3 = r15;
        this.optionText4 = r16;
        this.questionCode = r17;
        this.questionTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AilabTestItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AilabTestItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ailab_test_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AilabTestItemBinding bind(View r19) {
        int r1 = R.id.divider;
        View r4 = ViewBindings.findChildViewById(r19, R.id.divider);
        if (r4 == null) goto L35;
        r1 = R.id.option_1;
        OCheckBox r5 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.option_1);
        if (r5 == null) goto L35;
        r1 = R.id.option_2;
        OCheckBox r6 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.option_2);
        if (r6 == null) goto L35;
        r1 = R.id.option_3;
        OCheckBox r7 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.option_3);
        if (r7 == null) goto L35;
        r1 = R.id.option_4;
        OCheckBox r8 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.option_4);
        if (r8 == null) goto L35;
        r1 = R.id.option_layout_1;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.option_layout_1);
        if (r9 == null) goto L35;
        r1 = R.id.option_layout_2;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.option_layout_2);
        if (r10 == null) goto L35;
        r1 = R.id.option_layout_3;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.option_layout_3);
        if (r11 == null) goto L35;
        r1 = R.id.option_layout_4;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.option_layout_4);
        if (r12 == null) goto L35;
        r1 = R.id.option_text_1;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r19, R.id.option_text_1);
        if (r13 == null) goto L35;
        r1 = R.id.option_text_2;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r19, R.id.option_text_2);
        if (r14 == null) goto L35;
        r1 = R.id.option_text_3;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r19, R.id.option_text_3);
        if (r15 == null) goto L35;
        r1 = R.id.option_text_4;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r19, R.id.option_text_4);
        if (r16 == null) goto L35;
        r1 = R.id.question_code;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r19, R.id.question_code);
        if (r17 == null) goto L35;
        r1 = R.id.question_title;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r19, R.id.question_title);
        if (r18 == null) goto L35;
        return new AilabTestItemBinding((LinearLayout) r19, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
