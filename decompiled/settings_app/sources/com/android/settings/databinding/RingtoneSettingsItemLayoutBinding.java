package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.swipeaction.OSwipeLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class RingtoneSettingsItemLayoutBinding implements ViewBinding {
    public final LinearLayout bottomWrapper;
    public final OButton deleteBtn;
    public final OSwipeLayout itemSwipe;
    public final LinearLayout pageContainer;
    public final OListItemSettings ringtoneItem;
    public final OListItemSettings ringtoneItemWithDelete;
    private final RelativeLayout rootView;
    public final OSectionTitleBar title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RingtoneSettingsItemLayoutBinding(RelativeLayout r1, LinearLayout r2, OButton r3, OSwipeLayout r4, LinearLayout r5, OListItemSettings r6, OListItemSettings r7, OSectionTitleBar r8) {
        this.rootView = r1;
        this.bottomWrapper = r2;
        this.deleteBtn = r3;
        this.itemSwipe = r4;
        this.pageContainer = r5;
        this.ringtoneItem = r6;
        this.ringtoneItemWithDelete = r7;
        this.title = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RingtoneSettingsItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RingtoneSettingsItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ringtone_settings_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RingtoneSettingsItemLayoutBinding bind(View r11) {
        int r0 = R.id.bottom_wrapper;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.bottom_wrapper);
        if (r4 == null) goto L19;
        r0 = R.id.delete_btn;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r11, R.id.delete_btn);
        if (r5 == null) goto L19;
        r0 = R.id.item_swipe;
        OSwipeLayout r6 = (OSwipeLayout) ViewBindings.findChildViewById(r11, R.id.item_swipe);
        if (r6 == null) goto L19;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r7 == null) goto L19;
        r0 = R.id.ringtone_item;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r11, R.id.ringtone_item);
        if (r8 == null) goto L19;
        r0 = R.id.ringtone_item_with_delete;
        OListItemSettings r9 = (OListItemSettings) ViewBindings.findChildViewById(r11, R.id.ringtone_item_with_delete);
        if (r9 == null) goto L19;
        r0 = R.id.title;
        OSectionTitleBar r10 = (OSectionTitleBar) ViewBindings.findChildViewById(r11, R.id.title);
        if (r10 == null) goto L19;
        return new RingtoneSettingsItemLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
