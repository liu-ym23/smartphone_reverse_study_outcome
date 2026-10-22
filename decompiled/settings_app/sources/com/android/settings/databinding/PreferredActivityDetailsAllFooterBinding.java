package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferredActivityDetailsAllFooterBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView textView1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferredActivityDetailsAllFooterBinding(RelativeLayout r1, TextView r2) {
        this.rootView = r1;
        this.textView1 = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PreferredActivityDetailsAllFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferredActivityDetailsAllFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preferred_activity_details_all_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferredActivityDetailsAllFooterBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, R.id.textView1);
        if (r1 == null) goto L7;
        return new PreferredActivityDetailsAllFooterBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.textView1)));
    }
}
