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
public final class DialogPanelChannelNotificationBinding implements ViewBinding {
    public final OCardListItem highImportance;
    public final LinearLayout items;
    private final LinearLayout rootView;
    public final OCardListItem switchNotificationRingtone;
    public final OCardListItem switchNotificationVibrate;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DialogPanelChannelNotificationBinding(LinearLayout r1, OCardListItem r2, LinearLayout r3, OCardListItem r4, OCardListItem r5) {
        this.rootView = r1;
        this.highImportance = r2;
        this.items = r3;
        this.switchNotificationRingtone = r4;
        this.switchNotificationVibrate = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogPanelChannelNotificationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogPanelChannelNotificationBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dialog_panel_channel_notification, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DialogPanelChannelNotificationBinding bind(View r8) {
        int r0 = R.id.high_importance;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.high_importance);
        if (r4 == null) goto L11;
        LinearLayout r5 = (LinearLayout) r8;
        r0 = R.id.switch_notification_ringtone;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.switch_notification_ringtone);
        if (r6 == null) goto L11;
        r0 = R.id.switch_notification_vibrate;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.switch_notification_vibrate);
        if (r7 == null) goto L11;
        return new DialogPanelChannelNotificationBinding(r5, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
