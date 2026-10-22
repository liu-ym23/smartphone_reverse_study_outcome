package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class OaidSettingsLayoutBinding implements ViewBinding {
    public final OBottomActionBarNormalVertical bottomActionBar;
    public final OSectionSupportiveText oaidDesc;
    public final RelativeLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem switchRetrieveOaid;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OaidSettingsLayoutBinding(RelativeLayout r1, OBottomActionBarNormalVertical r2, OSectionSupportiveText r3, RelativeLayout r4, OScrollView r5, OCardListItem r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.bottomActionBar = r2;
        this.oaidDesc = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.switchRetrieveOaid = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OaidSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OaidSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.oaid_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OaidSettingsLayoutBinding bind(View r10) {
        int r0 = R.id.bottom_action_bar;
        OBottomActionBarNormalVertical r4 = (OBottomActionBarNormalVertical) ViewBindings.findChildViewById(r10, R.id.bottom_action_bar);
        if (r4 == null) goto L17;
        r0 = R.id.oaid_desc;
        OSectionSupportiveText r5 = (OSectionSupportiveText) ViewBindings.findChildViewById(r10, R.id.oaid_desc);
        if (r5 == null) goto L17;
        r0 = R.id.page_container;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r6 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r7 == null) goto L17;
        r0 = R.id.switch_retrieve_oaid;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.switch_retrieve_oaid);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new OaidSettingsLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
