package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class MmOptionItemLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ListContentItemCheck sendWay;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MmOptionItemLayoutBinding(RelativeLayout r1, ListContentItemCheck r2) {
        this.rootView = r1;
        this.sendWay = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MmOptionItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MmOptionItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.mm_option_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MmOptionItemLayoutBinding bind(View r2) {
        ListContentItemCheck r1 = (ListContentItemCheck) ViewBindings.findChildViewById(r2, R.id.send_way);
        if (r1 == null) goto L7;
        return new MmOptionItemLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.send_way)));
    }
}
