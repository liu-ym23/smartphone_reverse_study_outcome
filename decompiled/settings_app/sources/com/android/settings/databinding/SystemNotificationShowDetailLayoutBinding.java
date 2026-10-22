package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemNotificationShowDetailLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OCardListItem showDetailDisable;
    public final OCardListItem showDetailHide;
    public final OCardListItem showDetailShow;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SystemNotificationShowDetailLayoutBinding(RelativeLayout r1, LinearLayout r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.showDetailDisable = r3;
        this.showDetailHide = r4;
        this.showDetailShow = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SystemNotificationShowDetailLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SystemNotificationShowDetailLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.system_notification_show_detail_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SystemNotificationShowDetailLayoutBinding bind(View r9) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r4 == null) goto L15;
        r0 = R.id.show_detail_disable;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.show_detail_disable);
        if (r5 == null) goto L15;
        r0 = R.id.show_detail_hide;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.show_detail_hide);
        if (r6 == null) goto L15;
        r0 = R.id.show_detail_show;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.show_detail_show);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new SystemNotificationShowDetailLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
