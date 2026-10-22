package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.PreviewSettingItemView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OneHandSettingsItemLayoutBinding implements ViewBinding {
    public final PreviewSettingItemView itemPreviewLeft;
    public final PreviewSettingItemView itemPreviewRight;
    public final LinearLayout oneHandPreview;
    private final LinearLayout rootView;
    public final TextView textItemTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OneHandSettingsItemLayoutBinding(LinearLayout r1, PreviewSettingItemView r2, PreviewSettingItemView r3, LinearLayout r4, TextView r5) {
        this.rootView = r1;
        this.itemPreviewLeft = r2;
        this.itemPreviewRight = r3;
        this.oneHandPreview = r4;
        this.textItemTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OneHandSettingsItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OneHandSettingsItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.one_hand_settings_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OneHandSettingsItemLayoutBinding bind(View r8) {
        int r0 = R.id.item_preview_left;
        PreviewSettingItemView r4 = (PreviewSettingItemView) ViewBindings.findChildViewById(r8, R.id.item_preview_left);
        if (r4 == null) goto L13;
        r0 = R.id.item_preview_right;
        PreviewSettingItemView r5 = (PreviewSettingItemView) ViewBindings.findChildViewById(r8, R.id.item_preview_right);
        if (r5 == null) goto L13;
        r0 = R.id.one_hand_preview;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.one_hand_preview);
        if (r6 == null) goto L13;
        r0 = R.id.text_item_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.text_item_title);
        if (r7 == null) goto L13;
        return new OneHandSettingsItemLayoutBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
