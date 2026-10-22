package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityAilabBinding implements ViewBinding {
    public final RelativeLayout aboutRootView;
    public final View ailabBottomLine;
    public final OTextView ailabSysteminfo;
    public final ConstraintLayout constraintRootView;
    public final FrameLayout headerBg;
    public final ImageView logoImg;
    private final RelativeLayout rootView;
    public final OCardListItem screenMemoryItem;
    public final OScrollView scrollContent;
    public final TextView subTitle;
    public final TextView title;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem voiceMemoryItem;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityAilabBinding(RelativeLayout r1, RelativeLayout r2, View r3, OTextView r4, ConstraintLayout r5, FrameLayout r6, ImageView r7, OCardListItem r8, OScrollView r9, TextView r10, TextView r11, OFloatingTitleBar r12, OCardListItem r13) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.ailabBottomLine = r3;
        this.ailabSysteminfo = r4;
        this.constraintRootView = r5;
        this.headerBg = r6;
        this.logoImg = r7;
        this.screenMemoryItem = r8;
        this.scrollContent = r9;
        this.subTitle = r10;
        this.title = r11;
        this.viewTitle = r12;
        this.voiceMemoryItem = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAilabBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAilabBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_ailab, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityAilabBinding bind(View r14) {
        RelativeLayout r2 = (RelativeLayout) r14;
        int r0 = R.id.ailab_bottom_line;
        View r3 = ViewBindings.findChildViewById(r14, R.id.ailab_bottom_line);
        if (r3 == null) goto L27;
        r0 = R.id.ailab_systeminfo;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r14, R.id.ailab_systeminfo);
        if (r4 == null) goto L27;
        r0 = R.id.constraint_root_view;
        ConstraintLayout r5 = (ConstraintLayout) ViewBindings.findChildViewById(r14, R.id.constraint_root_view);
        if (r5 == null) goto L27;
        r0 = R.id.header_bg;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r14, R.id.header_bg);
        if (r6 == null) goto L27;
        r0 = R.id.logo_img;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r14, R.id.logo_img);
        if (r7 == null) goto L27;
        r0 = R.id.screen_memory_item;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.screen_memory_item);
        if (r8 == null) goto L27;
        r0 = R.id.scroll_content;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.scroll_content);
        if (r9 == null) goto L27;
        r0 = R.id.sub_title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r14, R.id.sub_title);
        if (r10 == null) goto L27;
        r0 = R.id.title;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r14, R.id.title);
        if (r11 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r12 == null) goto L27;
        r0 = R.id.voice_memory_item;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.voice_memory_item);
        if (r13 == null) goto L27;
        return new ActivityAilabBinding(r2, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
