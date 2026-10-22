package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageProgressLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ProgressBar storageProgress;
    public final LinearLayout storageProgressContent;
    public final TextView storageProgressSummary;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageProgressLayoutBinding(LinearLayout r1, ProgressBar r2, LinearLayout r3, TextView r4) {
        this.rootView = r1;
        this.storageProgress = r2;
        this.storageProgressContent = r3;
        this.storageProgressSummary = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StorageProgressLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageProgressLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_progress_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageProgressLayoutBinding bind(View r4) {
        int r0 = R.id.storage_progress;
        ProgressBar r1 = (ProgressBar) ViewBindings.findChildViewById(r4, R.id.storage_progress);
        if (r1 == null) goto L10;
        LinearLayout r2 = (LinearLayout) r4;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.storage_progress_summary);
        if (r3 != null) goto L7;
        r0 = R.id.storage_progress_summary;
        goto L10
    L7:
        return new StorageProgressLayoutBinding(r2, r1, r2, r3);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
