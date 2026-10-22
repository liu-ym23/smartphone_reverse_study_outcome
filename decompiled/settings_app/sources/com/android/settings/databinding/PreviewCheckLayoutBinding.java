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
public final class PreviewCheckLayoutBinding implements ViewBinding {
    public final PreviewSettingItemView itemPreviewLeft;
    public final PreviewSettingItemView itemPreviewRight;
    public final LinearLayout previewContainer;
    public final TextView previewTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreviewCheckLayoutBinding(LinearLayout r1, PreviewSettingItemView r2, PreviewSettingItemView r3, LinearLayout r4, TextView r5) {
        this.rootView = r1;
        this.itemPreviewLeft = r2;
        this.itemPreviewRight = r3;
        this.previewContainer = r4;
        this.previewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreviewCheckLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreviewCheckLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preview_check_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreviewCheckLayoutBinding bind(View r8) {
        int r0 = R.id.item_preview_left;
        PreviewSettingItemView r4 = (PreviewSettingItemView) ViewBindings.findChildViewById(r8, R.id.item_preview_left);
        if (r4 == null) goto L13;
        r0 = R.id.item_preview_right;
        PreviewSettingItemView r5 = (PreviewSettingItemView) ViewBindings.findChildViewById(r8, R.id.item_preview_right);
        if (r5 == null) goto L13;
        r0 = R.id.preview_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.preview_container);
        if (r6 == null) goto L13;
        r0 = R.id.preview_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.preview_title);
        if (r7 == null) goto L13;
        return new PreviewCheckLayoutBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
