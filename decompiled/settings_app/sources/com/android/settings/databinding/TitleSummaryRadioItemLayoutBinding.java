package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.swipeaction.OSwipeLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class TitleSummaryRadioItemLayoutBinding implements ViewBinding {
    public final LinearLayout bottomWrapper;
    public final OButton deleteBtn;
    public final OListItemSettings itemLayout;
    public final OListItemSettings itemLayoutWithDeleteIcon;
    public final OSwipeLayout itemSwipe;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TitleSummaryRadioItemLayoutBinding(RelativeLayout r1, LinearLayout r2, OButton r3, OListItemSettings r4, OListItemSettings r5, OSwipeLayout r6) {
        this.rootView = r1;
        this.bottomWrapper = r2;
        this.deleteBtn = r3;
        this.itemLayout = r4;
        this.itemLayoutWithDeleteIcon = r5;
        this.itemSwipe = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TitleSummaryRadioItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TitleSummaryRadioItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.title_summary_radio_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TitleSummaryRadioItemLayoutBinding bind(View r9) {
        int r0 = R.id.bottom_wrapper;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.bottom_wrapper);
        if (r4 == null) goto L15;
        r0 = R.id.delete_btn;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r9, R.id.delete_btn);
        if (r5 == null) goto L15;
        r0 = R.id.item_layout;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.item_layout);
        if (r6 == null) goto L15;
        r0 = R.id.item_layout_with_delete_icon;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.item_layout_with_delete_icon);
        if (r7 == null) goto L15;
        r0 = R.id.item_swipe;
        OSwipeLayout r8 = (OSwipeLayout) ViewBindings.findChildViewById(r9, R.id.item_swipe);
        if (r8 == null) goto L15;
        return new TitleSummaryRadioItemLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
