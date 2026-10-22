package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class OLocalListItemTextBinding implements ViewBinding {
    public final FrameLayout iconContainer;
    public final OImageAppIcon ivContentImg;
    public final ImageView ivDopplegangerIcon;
    private final View rootView;
    public final TextView tvContentSubtitle;
    public final OTextView tvContentTitle;

    private OLocalListItemTextBinding(View r1, FrameLayout r2, OImageAppIcon r3, ImageView r4, TextView r5, OTextView r6) {
        this.rootView = r1;
        this.iconContainer = r2;
        this.ivContentImg = r3;
        this.ivDopplegangerIcon = r4;
        this.tvContentSubtitle = r5;
        this.tvContentTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static OLocalListItemTextBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.o_local_list_item_text, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static OLocalListItemTextBinding bind(View r9) {
        int r0 = R.id.icon_container;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r9, R.id.icon_container);
        if (r4 == null) goto L15;
        r0 = R.id.iv_content_img;
        OImageAppIcon r5 = (OImageAppIcon) ViewBindings.findChildViewById(r9, R.id.iv_content_img);
        if (r5 == null) goto L15;
        r0 = R.id.iv_doppleganger_icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, R.id.iv_doppleganger_icon);
        if (r6 == null) goto L15;
        r0 = R.id.tv_content_subtitle;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.tv_content_subtitle);
        if (r7 == null) goto L15;
        r0 = R.id.tv_content_title;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r9, R.id.tv_content_title);
        if (r8 == null) goto L15;
        return new OLocalListItemTextBinding(r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
