package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingItemPopupInfoViewBinding implements ViewBinding {
    public final TextView popupInfoText;
    private final LinearLayout rootView;
    public final FrameLayout transparentView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingItemPopupInfoViewBinding(LinearLayout r1, TextView r2, FrameLayout r3) {
        this.rootView = r1;
        this.popupInfoText = r2;
        this.transparentView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingItemPopupInfoViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingItemPopupInfoViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_item_popup_info_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingItemPopupInfoViewBinding bind(View r3) {
        int r0 = R.id.popup_info_text;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.popup_info_text);
        if (r1 == null) goto L9;
        r0 = R.id.transparent_view;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(r3, R.id.transparent_view);
        if (r2 == null) goto L9;
        return new SettingItemPopupInfoViewBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
