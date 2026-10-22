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
public final class AccessibilityAutoClickFragmentBinding implements ViewBinding {
    public final OCardListItem autoClick;
    public final OCardListItem clickDelay1000;
    public final OCardListItem clickDelay200;
    public final OCardListItem clickDelay300;
    public final OCardListItem clickDelay400;
    public final OCardListItem clickDelay500;
    public final OCardListItem clickDelay600;
    public final OCardListItem clickDelay700;
    public final OCardListItem clickDelay800;
    public final OCardListItem clickDelay900;
    public final LinearLayout itemsContainer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessibilityAutoClickFragmentBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, LinearLayout r12, LinearLayout r13, OScrollView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.autoClick = r2;
        this.clickDelay1000 = r3;
        this.clickDelay200 = r4;
        this.clickDelay300 = r5;
        this.clickDelay400 = r6;
        this.clickDelay500 = r7;
        this.clickDelay600 = r8;
        this.clickDelay700 = r9;
        this.clickDelay800 = r10;
        this.clickDelay900 = r11;
        this.itemsContainer = r12;
        this.pageContainer = r13;
        this.pageScrollview = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccessibilityAutoClickFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessibilityAutoClickFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.accessibility_auto_click_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessibilityAutoClickFragmentBinding bind(View r19) {
        int r1 = R.id.auto_click;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.auto_click);
        if (r5 == null) goto L33;
        r1 = R.id.click_delay_1000;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_1000);
        if (r6 == null) goto L33;
        r1 = R.id.click_delay_200;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_200);
        if (r7 == null) goto L33;
        r1 = R.id.click_delay_300;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_300);
        if (r8 == null) goto L33;
        r1 = R.id.click_delay_400;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_400);
        if (r9 == null) goto L33;
        r1 = R.id.click_delay_500;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_500);
        if (r10 == null) goto L33;
        r1 = R.id.click_delay_600;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_600);
        if (r11 == null) goto L33;
        r1 = R.id.click_delay_700;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_700);
        if (r12 == null) goto L33;
        r1 = R.id.click_delay_800;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_800);
        if (r13 == null) goto L33;
        r1 = R.id.click_delay_900;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.click_delay_900);
        if (r14 == null) goto L33;
        r1 = R.id.items_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.items_container);
        if (r15 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r16 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new AccessibilityAutoClickFragmentBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
