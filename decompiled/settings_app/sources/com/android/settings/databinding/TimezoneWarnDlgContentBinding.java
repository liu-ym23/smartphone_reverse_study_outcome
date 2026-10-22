package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class TimezoneWarnDlgContentBinding implements ViewBinding {
    public final TextView message;
    public final TextView messageTitle;
    private final OScrollView rootView;
    public final OScrollView scrollView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TimezoneWarnDlgContentBinding(OScrollView r1, TextView r2, TextView r3, OScrollView r4) {
        this.rootView = r1;
        this.message = r2;
        this.messageTitle = r3;
        this.scrollView = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static TimezoneWarnDlgContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TimezoneWarnDlgContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.timezone_warn_dlg_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TimezoneWarnDlgContentBinding bind(View r3) {
        int r0 = R.id.message;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.message);
        if (r1 == null) goto L9;
        r0 = R.id.message_title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.message_title);
        if (r2 == null) goto L9;
        OScrollView r4 = (OScrollView) r3;
        return new TimezoneWarnDlgContentBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
