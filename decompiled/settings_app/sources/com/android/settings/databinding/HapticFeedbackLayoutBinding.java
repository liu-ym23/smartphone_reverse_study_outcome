package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class HapticFeedbackLayoutBinding implements ViewBinding {
    public final OCardListItem closeHapticFeedback;
    public final OCardListItem highHapticFeedback;
    public final OCardListItem lowHapticFeedback;
    public final OCardListItem midHapticFeedback;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HapticFeedbackLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, LinearLayout r6, OScrollView r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.closeHapticFeedback = r2;
        this.highHapticFeedback = r3;
        this.lowHapticFeedback = r4;
        this.midHapticFeedback = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HapticFeedbackLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HapticFeedbackLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.haptic_feedback_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HapticFeedbackLayoutBinding bind(View r11) {
        int r0 = R.id.close_haptic_feedback;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.close_haptic_feedback);
        if (r4 == null) goto L19;
        r0 = R.id.high_haptic_feedback;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.high_haptic_feedback);
        if (r5 == null) goto L19;
        r0 = R.id.low_haptic_feedback;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.low_haptic_feedback);
        if (r6 == null) goto L19;
        r0 = R.id.mid_haptic_feedback;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.mid_haptic_feedback);
        if (r7 == null) goto L19;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r8 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new HapticFeedbackLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
