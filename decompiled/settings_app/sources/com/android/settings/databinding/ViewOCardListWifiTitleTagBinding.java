package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.tag.OTextTag;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewOCardListWifiTitleTagBinding implements ViewBinding {
    public final LinearLayout customTitleContainer;
    public final OTextTag customTitleTag;
    public final OTextView customTitleText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewOCardListWifiTitleTagBinding(LinearLayout r1, LinearLayout r2, OTextTag r3, OTextView r4) {
        this.rootView = r1;
        this.customTitleContainer = r2;
        this.customTitleTag = r3;
        this.customTitleText = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewOCardListWifiTitleTagBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewOCardListWifiTitleTagBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_o_card_list_wifi_title_tag, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewOCardListWifiTitleTagBinding bind(View r4) {
        LinearLayout r0 = (LinearLayout) r4;
        int r1 = R.id.custom_title_tag;
        OTextTag r2 = (OTextTag) ViewBindings.findChildViewById(r4, R.id.custom_title_tag);
        if (r2 == null) goto L9;
        r1 = R.id.custom_title_text;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.custom_title_text);
        if (r3 == null) goto L9;
        return new ViewOCardListWifiTitleTagBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r1)));
    }
}
