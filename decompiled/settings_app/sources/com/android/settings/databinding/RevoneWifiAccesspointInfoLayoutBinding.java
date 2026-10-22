package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneWifiAccesspointInfoLayoutBinding implements ViewBinding {
    public final TextView apTitle;
    public final ListContentItemCustom listItemContainer;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final ImageView signal;
    public final ViewStub summaryViewstub;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneWifiAccesspointInfoLayoutBinding(LinearLayout r1, TextView r2, ListContentItemCustom r3, ProgressBar r4, ImageView r5, ViewStub r6) {
        this.rootView = r1;
        this.apTitle = r2;
        this.listItemContainer = r3;
        this.progressBar = r4;
        this.signal = r5;
        this.summaryViewstub = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneWifiAccesspointInfoLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneWifiAccesspointInfoLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_wifi_accesspoint_info_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneWifiAccesspointInfoLayoutBinding bind(View r9) {
        int r0 = R.id.ap_title;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.ap_title);
        if (r4 == null) goto L15;
        r0 = R.id.list_item_container;
        ListContentItemCustom r5 = (ListContentItemCustom) ViewBindings.findChildViewById(r9, R.id.list_item_container);
        if (r5 == null) goto L15;
        r0 = R.id.progress_bar;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r9, R.id.progress_bar);
        if (r6 == null) goto L15;
        r0 = R.id.signal;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r9, R.id.signal);
        if (r7 == null) goto L15;
        r0 = R.id.summary_viewstub;
        ViewStub r8 = (ViewStub) ViewBindings.findChildViewById(r9, R.id.summary_viewstub);
        if (r8 == null) goto L15;
        return new RevoneWifiAccesspointInfoLayoutBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
