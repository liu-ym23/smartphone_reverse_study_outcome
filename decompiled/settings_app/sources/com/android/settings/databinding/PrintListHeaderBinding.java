package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PrintListHeaderBinding implements ViewBinding {
    public final OCardListItem itemProfile;
    public final OSectionTitleBar printJobTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PrintListHeaderBinding(LinearLayout r1, OCardListItem r2, OSectionTitleBar r3) {
        this.rootView = r1;
        this.itemProfile = r2;
        this.printJobTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PrintListHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PrintListHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.print_list_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PrintListHeaderBinding bind(View r3) {
        int r0 = R.id.item_profile;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.item_profile);
        if (r1 == null) goto L9;
        r0 = R.id.print_job_title;
        OSectionTitleBar r2 = (OSectionTitleBar) ViewBindings.findChildViewById(r3, R.id.print_job_title);
        if (r2 == null) goto L9;
        return new PrintListHeaderBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
