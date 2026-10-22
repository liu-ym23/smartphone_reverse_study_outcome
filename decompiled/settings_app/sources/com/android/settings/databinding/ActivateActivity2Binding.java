package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivateActivity2Binding implements ViewBinding {
    public final ODownloadProgressView progressViewProcessing1;
    private final RelativeLayout rootView;
    public final TextView tvProcessing1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivateActivity2Binding(RelativeLayout r1, ODownloadProgressView r2, TextView r3) {
        this.rootView = r1;
        this.progressViewProcessing1 = r2;
        this.tvProcessing1 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivateActivity2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivateActivity2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activate_activity_2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivateActivity2Binding bind(View r3) {
        int r0 = R.id.progress_view_processing_1;
        ODownloadProgressView r1 = (ODownloadProgressView) ViewBindings.findChildViewById(r3, R.id.progress_view_processing_1);
        if (r1 == null) goto L9;
        r0 = R.id.tv_processing_1;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.tv_processing_1);
        if (r2 == null) goto L9;
        return new ActivateActivity2Binding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
