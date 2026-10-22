package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDictionarySettingsLayoutBinding implements ViewBinding {
    public final TextView empty;
    private final RelativeLayout rootView;
    public final OListView userDictionaryList;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserDictionarySettingsLayoutBinding(RelativeLayout r1, TextView r2, OListView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.empty = r2;
        this.userDictionaryList = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UserDictionarySettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserDictionarySettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_dictionary_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserDictionarySettingsLayoutBinding bind(View r4) {
        int r0 = android.R.id.empty;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.empty);
        if (r1 == null) goto L11;
        r0 = R.id.user_dictionary_list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r4, R.id.user_dictionary_list);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new UserDictionarySettingsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
