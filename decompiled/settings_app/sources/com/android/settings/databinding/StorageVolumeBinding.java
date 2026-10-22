package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.PreferenceImageView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageVolumeBinding implements ViewBinding {
    public final PreferenceImageView icon;
    public final LinearLayout iconFrame;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageVolumeBinding(LinearLayout r1, PreferenceImageView r2, LinearLayout r3, ProgressBar r4, TextView r5, TextView r6, LinearLayout r7) {
        this.rootView = r1;
        this.icon = r2;
        this.iconFrame = r3;
        this.progress = r4;
        this.summary = r5;
        this.title = r6;
        this.widgetFrame = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StorageVolumeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageVolumeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_volume, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageVolumeBinding bind(View r10) {
        int r0 = android.R.id.icon;
        PreferenceImageView r4 = ViewBindings.findChildViewById(r10, android.R.id.icon);
        if (r4 == null) goto L17;
        r0 = R.id.icon_frame;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.icon_frame);
        if (r5 == null) goto L17;
        r0 = android.R.id.progress;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r10, android.R.id.progress);
        if (r6 == null) goto L17;
        r0 = android.R.id.summary;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, android.R.id.summary);
        if (r7 == null) goto L17;
        r0 = android.R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, android.R.id.title);
        if (r8 == null) goto L17;
        r0 = android.R.id.widget_frame;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r10, android.R.id.widget_frame);
        if (r9 == null) goto L17;
        return new StorageVolumeBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
