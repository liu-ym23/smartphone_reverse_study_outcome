package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.editor.SimpleEditor;

/* JADX INFO: loaded from: classes2.dex */
public final class OwnerinfoBinding implements ViewBinding {
    public final SimpleEditor ownerInfoEditText;
    private final RelativeLayout rootView;
    public final SettingItemSwitch showOwnerInfoOnLockscreenCheckbox;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OwnerinfoBinding(RelativeLayout r1, SimpleEditor r2, SettingItemSwitch r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.ownerInfoEditText = r2;
        this.showOwnerInfoOnLockscreenCheckbox = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OwnerinfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OwnerinfoBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ownerinfo, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OwnerinfoBinding bind(View r4) {
        int r0 = R.id.owner_info_edit_text;
        SimpleEditor r1 = (SimpleEditor) ViewBindings.findChildViewById(r4, R.id.owner_info_edit_text);
        if (r1 == null) goto L11;
        r0 = R.id.show_owner_info_on_lockscreen_checkbox;
        SettingItemSwitch r2 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.show_owner_info_on_lockscreen_checkbox);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new OwnerinfoBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
