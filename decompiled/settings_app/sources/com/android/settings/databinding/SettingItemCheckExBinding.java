package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingItemCheckExBinding implements ViewBinding {
    public final CheckBox checkbox;
    private final RelativeLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingItemCheckExBinding(RelativeLayout r1, CheckBox r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.checkbox = r2;
        this.summary = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingItemCheckExBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingItemCheckExBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_item_check_ex, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingItemCheckExBinding bind(View r4) {
        int r0 = R.id.checkbox;
        CheckBox r1 = (CheckBox) ViewBindings.findChildViewById(r4, R.id.checkbox);
        if (r1 == null) goto L11;
        r0 = R.id.summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.summary);
        if (r2 == null) goto L11;
        r0 = R.id.title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.title);
        if (r3 == null) goto L11;
        return new SettingItemCheckExBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
