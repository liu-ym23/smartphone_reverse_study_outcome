package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class BugreportOptionsDialogBinding implements ViewBinding {
    public final TextView bugreportOptionFullSummary;
    public final CheckedTextView bugreportOptionFullTitle;
    public final TextView bugreportOptionInteractiveSummary;
    public final CheckedTextView bugreportOptionInteractiveTitle;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BugreportOptionsDialogBinding(OScrollView r1, TextView r2, CheckedTextView r3, TextView r4, CheckedTextView r5) {
        this.rootView = r1;
        this.bugreportOptionFullSummary = r2;
        this.bugreportOptionFullTitle = r3;
        this.bugreportOptionInteractiveSummary = r4;
        this.bugreportOptionInteractiveTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static BugreportOptionsDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BugreportOptionsDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bugreport_options_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BugreportOptionsDialogBinding bind(View r8) {
        int r0 = R.id.bugreport_option_full_summary;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.bugreport_option_full_summary);
        if (r4 == null) goto L13;
        r0 = R.id.bugreport_option_full_title;
        CheckedTextView r5 = (CheckedTextView) ViewBindings.findChildViewById(r8, R.id.bugreport_option_full_title);
        if (r5 == null) goto L13;
        r0 = R.id.bugreport_option_interactive_summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.bugreport_option_interactive_summary);
        if (r6 == null) goto L13;
        r0 = R.id.bugreport_option_interactive_title;
        CheckedTextView r7 = (CheckedTextView) ViewBindings.findChildViewById(r8, R.id.bugreport_option_interactive_title);
        if (r7 == null) goto L13;
        return new BugreportOptionsDialogBinding((OScrollView) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
