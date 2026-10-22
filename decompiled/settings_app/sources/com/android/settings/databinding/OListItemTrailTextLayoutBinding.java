package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class OListItemTrailTextLayoutBinding implements ViewBinding {
    private final OTextView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OListItemTrailTextLayoutBinding(OTextView r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OTextView getRoot() {
        return this.rootView;
    }

    public static OListItemTrailTextLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OListItemTrailTextLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_list_item_trail_text_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OListItemTrailTextLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new OListItemTrailTextLayoutBinding((OTextView) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
