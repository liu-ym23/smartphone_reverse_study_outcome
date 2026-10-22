package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStatusNewItemBinding implements ViewBinding {
    public final ImageView endIcon;
    private final View rootView;
    public final OTextView titleTv;
    public final OTextView trailingText;

    private DeviceStatusNewItemBinding(View r1, ImageView r2, OTextView r3, OTextView r4) {
        this.rootView = r1;
        this.endIcon = r2;
        this.titleTv = r3;
        this.trailingText = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static DeviceStatusNewItemBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.device_status_new_item, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static DeviceStatusNewItemBinding bind(View r4) {
        int r0 = R.id.end_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.end_icon);
        if (r1 == null) goto L11;
        r0 = R.id.title_tv;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r4, R.id.title_tv);
        if (r2 == null) goto L11;
        r0 = R.id.trailing_text;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.trailing_text);
        if (r3 == null) goto L11;
        return new DeviceStatusNewItemBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
