package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class RingtoneSettingsItemLayoutNewBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OCardListItem ringtoneItem;
    private final RelativeLayout rootView;
    public final OSectionTitleBar title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RingtoneSettingsItemLayoutNewBinding(RelativeLayout r1, LinearLayout r2, OCardListItem r3, OSectionTitleBar r4) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.ringtoneItem = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RingtoneSettingsItemLayoutNewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RingtoneSettingsItemLayoutNewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ringtone_settings_item_layout_new, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RingtoneSettingsItemLayoutNewBinding bind(View r4) {
        int r0 = R.id.page_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.page_container);
        if (r1 == null) goto L11;
        r0 = R.id.ringtone_item;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.ringtone_item);
        if (r2 == null) goto L11;
        r0 = R.id.title;
        OSectionTitleBar r3 = (OSectionTitleBar) ViewBindings.findChildViewById(r4, R.id.title);
        if (r3 == null) goto L11;
        return new RingtoneSettingsItemLayoutNewBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
