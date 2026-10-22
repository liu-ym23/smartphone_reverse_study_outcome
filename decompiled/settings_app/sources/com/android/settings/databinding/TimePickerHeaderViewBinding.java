package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class TimePickerHeaderViewBinding implements ViewBinding {
    public final OIconButton btnNegative;
    public final OIconButton btnPositive;
    private final RelativeLayout rootView;
    public final OTextView tvTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TimePickerHeaderViewBinding(RelativeLayout r1, OIconButton r2, OIconButton r3, OTextView r4) {
        this.rootView = r1;
        this.btnNegative = r2;
        this.btnPositive = r3;
        this.tvTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TimePickerHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TimePickerHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.time_picker_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TimePickerHeaderViewBinding bind(View r4) {
        int r0 = R.id.btn_negative;
        OIconButton r1 = (OIconButton) ViewBindings.findChildViewById(r4, R.id.btn_negative);
        if (r1 == null) goto L11;
        r0 = R.id.btn_positive;
        OIconButton r2 = (OIconButton) ViewBindings.findChildViewById(r4, R.id.btn_positive);
        if (r2 == null) goto L11;
        r0 = R.id.tv_title;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.tv_title);
        if (r3 == null) goto L11;
        return new TimePickerHeaderViewBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
