package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;

/* JADX INFO: loaded from: classes2.dex */
public final class LoadingViewLayoutBinding implements ViewBinding {
    public final ODownloadProgressView progressViewProcessing1;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LoadingViewLayoutBinding(FrameLayout r1, ODownloadProgressView r2) {
        this.rootView = r1;
        this.progressViewProcessing1 = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LoadingViewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LoadingViewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.loading_view_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LoadingViewLayoutBinding bind(View r2) {
        ODownloadProgressView r1 = (ODownloadProgressView) ViewBindings.findChildViewById(r2, R.id.progress_view_processing_1);
        if (r1 == null) goto L7;
        return new LoadingViewLayoutBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.progress_view_processing_1)));
    }
}
