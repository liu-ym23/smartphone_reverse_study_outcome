package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationGridItemBinding implements ViewBinding {
    public final ImageView itemImage;
    private final ImageView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationGridItemBinding(ImageView r1, ImageView r2) {
        this.rootView = r1;
        this.itemImage = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static NotificationGridItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationGridItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_grid_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationGridItemBinding bind(View r1) {
        if (r1 == null) goto L6;
        ImageView r2 = (ImageView) r1;
        return new NotificationGridItemBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
