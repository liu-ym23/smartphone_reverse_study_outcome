package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class RingtoneSettingsListViewHeaderViewLayoutBinding implements ViewBinding {
    public final LinearLayout customHeaderContainer;
    public final LinearLayout ringSwitchContainer;
    public final OCardListItem ringtoneSwitchCardListItem;
    private final LinearLayout rootView;
    public final OCardListItem sameToSms1CardListItem;
    public final OCardListItem vibrationCardListItem;
    public final LinearLayout vibrationItemContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RingtoneSettingsListViewHeaderViewLayoutBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, LinearLayout r7) {
        this.rootView = r1;
        this.customHeaderContainer = r2;
        this.ringSwitchContainer = r3;
        this.ringtoneSwitchCardListItem = r4;
        this.sameToSms1CardListItem = r5;
        this.vibrationCardListItem = r6;
        this.vibrationItemContainer = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RingtoneSettingsListViewHeaderViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RingtoneSettingsListViewHeaderViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ringtone_settings_list_view_header_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RingtoneSettingsListViewHeaderViewLayoutBinding bind(View r8) {
        LinearLayout r2 = (LinearLayout) r8;
        int r0 = R.id.ring_switch_container;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.ring_switch_container);
        if (r3 == null) goto L15;
        r0 = R.id.ringtone_switch_card_list_item;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.ringtone_switch_card_list_item);
        if (r4 == null) goto L15;
        r0 = R.id.same_to_sms1_card_list_item;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.same_to_sms1_card_list_item);
        if (r5 == null) goto L15;
        r0 = R.id.vibration_card_list_item;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.vibration_card_list_item);
        if (r6 == null) goto L15;
        r0 = R.id.vibration_item_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.vibration_item_container);
        if (r7 == null) goto L15;
        return new RingtoneSettingsListViewHeaderViewLayoutBinding(r2, r2, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
