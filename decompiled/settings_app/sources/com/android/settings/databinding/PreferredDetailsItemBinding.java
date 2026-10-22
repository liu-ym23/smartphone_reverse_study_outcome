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
public final class PreferredDetailsItemBinding implements ViewBinding {
    public final RelativeLayout containerDetailsItem;
    public final ImageView itemArrow;
    public final TextView itemSubtitle;
    public final TextView itemTitle;
    public final ImageView ringtoneBg;
    private final RelativeLayout rootView;
    public final RelativeLayout titleSummaryLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferredDetailsItemBinding(RelativeLayout r1, RelativeLayout r2, ImageView r3, TextView r4, TextView r5, ImageView r6, RelativeLayout r7) {
        this.rootView = r1;
        this.containerDetailsItem = r2;
        this.itemArrow = r3;
        this.itemSubtitle = r4;
        this.itemTitle = r5;
        this.ringtoneBg = r6;
        this.titleSummaryLayout = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PreferredDetailsItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferredDetailsItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preferred_details_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferredDetailsItemBinding bind(View r8) {
        RelativeLayout r2 = (RelativeLayout) r8;
        int r0 = R.id.item_arrow;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r8, R.id.item_arrow);
        if (r3 == null) goto L15;
        r0 = R.id.item_subtitle;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.item_subtitle);
        if (r4 == null) goto L15;
        r0 = R.id.item_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.item_title);
        if (r5 == null) goto L15;
        r0 = R.id.ringtone_bg;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r8, R.id.ringtone_bg);
        if (r6 == null) goto L15;
        r0 = R.id.title_summary_layout;
        RelativeLayout r7 = (RelativeLayout) ViewBindings.findChildViewById(r8, R.id.title_summary_layout);
        if (r7 == null) goto L15;
        return new PreferredDetailsItemBinding(r2, r2, r3, r4, r5, r6, r7);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
