package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RingtoneSettingsItemMidLayoutBinding implements ViewBinding {
    public final ImageView imageSoundPlay;
    public final TextView itemSummary;
    public final TextView itemTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RingtoneSettingsItemMidLayoutBinding(LinearLayout r1, ImageView r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.imageSoundPlay = r2;
        this.itemSummary = r3;
        this.itemTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RingtoneSettingsItemMidLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RingtoneSettingsItemMidLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ringtone_settings_item_mid_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RingtoneSettingsItemMidLayoutBinding bind(View r4) {
        int r0 = R.id.image_sound_play;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.image_sound_play);
        if (r1 == null) goto L11;
        r0 = R.id.item_summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.item_summary);
        if (r2 == null) goto L11;
        r0 = R.id.item_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.item_title);
        if (r3 == null) goto L11;
        return new RingtoneSettingsItemMidLayoutBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
