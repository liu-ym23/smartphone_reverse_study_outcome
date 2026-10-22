package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPreferenceCategoryBinding implements ViewBinding {
    public final LinearLayout container;
    public final ODownloadProgressView loadingView;
    public final OTextView refresh;
    public final FrameLayout refreshContainer;
    private final LinearLayout rootView;
    public final OTextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothPreferenceCategoryBinding(LinearLayout r1, LinearLayout r2, ODownloadProgressView r3, OTextView r4, FrameLayout r5, OTextView r6) {
        this.rootView = r1;
        this.container = r2;
        this.loadingView = r3;
        this.refresh = r4;
        this.refreshContainer = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothPreferenceCategoryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothPreferenceCategoryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_preference_category, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothPreferenceCategoryBinding bind(View r9) {
        int r0 = R.id.container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.container);
        if (r4 == null) goto L15;
        r0 = R.id.loading_view;
        ODownloadProgressView r5 = (ODownloadProgressView) ViewBindings.findChildViewById(r9, R.id.loading_view);
        if (r5 == null) goto L15;
        r0 = R.id.refresh;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r9, R.id.refresh);
        if (r6 == null) goto L15;
        r0 = R.id.refresh_container;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r9, R.id.refresh_container);
        if (r7 == null) goto L15;
        r0 = android.R.id.title;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r8 == null) goto L15;
        return new BluetoothPreferenceCategoryBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
