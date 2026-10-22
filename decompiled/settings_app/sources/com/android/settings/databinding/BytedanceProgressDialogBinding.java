package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BytedanceProgressDialogBinding implements ViewBinding {
    public final TextView message;
    public final ProgressBar progress;
    public final LinearLayout progressDialogContent;
    public final TextView progressDialogTitle;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BytedanceProgressDialogBinding(RelativeLayout r1, TextView r2, ProgressBar r3, LinearLayout r4, TextView r5) {
        this.rootView = r1;
        this.message = r2;
        this.progress = r3;
        this.progressDialogContent = r4;
        this.progressDialogTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BytedanceProgressDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BytedanceProgressDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bytedance_progress_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BytedanceProgressDialogBinding bind(View r8) {
        int r0 = R.id.message;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.message);
        if (r4 == null) goto L13;
        r0 = R.id.progress;
        ProgressBar r5 = (ProgressBar) ViewBindings.findChildViewById(r8, R.id.progress);
        if (r5 == null) goto L13;
        r0 = R.id.progress_dialog_content;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.progress_dialog_content);
        if (r6 == null) goto L13;
        r0 = R.id.progress_dialog_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.progress_dialog_title);
        if (r7 == null) goto L13;
        return new BytedanceProgressDialogBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
