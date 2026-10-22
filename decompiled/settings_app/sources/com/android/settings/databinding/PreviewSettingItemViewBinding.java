package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreviewSettingItemViewBinding implements ViewBinding {
    public final ImageView checkedImage;
    public final ImageView previewImage;
    public final TextView previewTitle;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreviewSettingItemViewBinding(RelativeLayout r1, ImageView r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.checkedImage = r2;
        this.previewImage = r3;
        this.previewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PreviewSettingItemViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreviewSettingItemViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preview_setting_item_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreviewSettingItemViewBinding bind(View r4) {
        int r0 = R.id.checked_image;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.checked_image);
        if (r1 == null) goto L11;
        r0 = R.id.preview_image;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.preview_image);
        if (r2 == null) goto L11;
        r0 = R.id.preview_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.preview_title);
        if (r3 == null) goto L11;
        return new PreviewSettingItemViewBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
