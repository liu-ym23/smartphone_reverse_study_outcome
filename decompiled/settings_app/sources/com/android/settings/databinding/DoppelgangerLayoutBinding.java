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
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DoppelgangerLayoutBinding implements ViewBinding {
    public final LinearLayout closeContainer;
    public final LinearLayout closeListContainer;
    public final OSectionSupportiveText doppelgangerDesc;
    public final OPageStatus emptyView;
    public final LinearLayout loadingContainer;
    public final LinearLayout openContainer;
    public final LinearLayout openListContainer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DoppelgangerLayoutBinding(RelativeLayout r1, LinearLayout r2, LinearLayout r3, OSectionSupportiveText r4, OPageStatus r5, LinearLayout r6, LinearLayout r7, LinearLayout r8, LinearLayout r9, OScrollView r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.closeContainer = r2;
        this.closeListContainer = r3;
        this.doppelgangerDesc = r4;
        this.emptyView = r5;
        this.loadingContainer = r6;
        this.openContainer = r7;
        this.openListContainer = r8;
        this.pageContainer = r9;
        this.pageScrollview = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DoppelgangerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DoppelgangerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.doppelganger_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DoppelgangerLayoutBinding bind(View r14) {
        int r0 = R.id.close_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.close_container);
        if (r4 == null) goto L25;
        r0 = R.id.close_list_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.close_list_container);
        if (r5 == null) goto L25;
        r0 = R.id.doppelganger_desc;
        OSectionSupportiveText r6 = (OSectionSupportiveText) ViewBindings.findChildViewById(r14, R.id.doppelganger_desc);
        if (r6 == null) goto L25;
        r0 = R.id.empty_view;
        OPageStatus r7 = (OPageStatus) ViewBindings.findChildViewById(r14, R.id.empty_view);
        if (r7 == null) goto L25;
        r0 = R.id.loading_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.loading_container);
        if (r8 == null) goto L25;
        r0 = R.id.open_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.open_container);
        if (r9 == null) goto L25;
        r0 = R.id.open_list_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.open_list_container);
        if (r10 == null) goto L25;
        r0 = R.id.page_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.page_container);
        if (r11 == null) goto L25;
        r0 = R.id.page_scrollview;
        OScrollView r12 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.page_scrollview);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new DoppelgangerLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
