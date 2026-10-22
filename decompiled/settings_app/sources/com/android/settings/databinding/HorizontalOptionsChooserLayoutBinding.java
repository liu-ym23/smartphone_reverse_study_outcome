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
public final class HorizontalOptionsChooserLayoutBinding implements ViewBinding {
    public final LinearLayout idContainer;
    public final PreviewSettingItemView itemPreviewLeft;
    public final PreviewSettingItemView itemPreviewMiddle;
    public final PreviewSettingItemView itemPreviewRight;
    private final View rootView;
    public final TextView title;

    private HorizontalOptionsChooserLayoutBinding(View r1, LinearLayout r2, PreviewSettingItemView r3, PreviewSettingItemView r4, PreviewSettingItemView r5, TextView r6) {
        this.rootView = r1;
        this.idContainer = r2;
        this.itemPreviewLeft = r3;
        this.itemPreviewMiddle = r4;
        this.itemPreviewRight = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static HorizontalOptionsChooserLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.horizontal_options_chooser_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static HorizontalOptionsChooserLayoutBinding bind(View r9) {
        int r0 = R.id.id_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.id_container);
        if (r4 == null) goto L15;
        r0 = R.id.item_preview_left;
        PreviewSettingItemView r5 = (PreviewSettingItemView) ViewBindings.findChildViewById(r9, R.id.item_preview_left);
        if (r5 == null) goto L15;
        r0 = R.id.item_preview_middle;
        PreviewSettingItemView r6 = (PreviewSettingItemView) ViewBindings.findChildViewById(r9, R.id.item_preview_middle);
        if (r6 == null) goto L15;
        r0 = R.id.item_preview_right;
        PreviewSettingItemView r7 = (PreviewSettingItemView) ViewBindings.findChildViewById(r9, R.id.item_preview_right);
        if (r7 == null) goto L15;
        r0 = R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.title);
        if (r8 == null) goto L15;
        return new HorizontalOptionsChooserLayoutBinding(r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
