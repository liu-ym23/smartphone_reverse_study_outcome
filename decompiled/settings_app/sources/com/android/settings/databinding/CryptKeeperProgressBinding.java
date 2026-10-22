package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperProgressBinding implements ViewBinding {
    public final ImageView encroid;
    public final Button factoryReset;
    public final ProgressBar progressBar;
    private final LinearLayout rootView;
    public final TextView status;
    public final TextView title;
    public final RelativeLayout topDivider;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CryptKeeperProgressBinding(LinearLayout r1, ImageView r2, Button r3, ProgressBar r4, TextView r5, TextView r6, RelativeLayout r7) {
        this.rootView = r1;
        this.encroid = r2;
        this.factoryReset = r3;
        this.progressBar = r4;
        this.status = r5;
        this.title = r6;
        this.topDivider = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CryptKeeperProgressBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CryptKeeperProgressBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.crypt_keeper_progress, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CryptKeeperProgressBinding bind(View r10) {
        int r0 = R.id.encroid;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, R.id.encroid);
        if (r4 == null) goto L17;
        r0 = R.id.factory_reset;
        Button r5 = (Button) ViewBindings.findChildViewById(r10, R.id.factory_reset);
        if (r5 == null) goto L17;
        r0 = R.id.progress_bar;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(r10, R.id.progress_bar);
        if (r6 == null) goto L17;
        r0 = R.id.status;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.status);
        if (r7 == null) goto L17;
        r0 = R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.title);
        if (r8 == null) goto L17;
        r0 = R.id.top_divider;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(r10, R.id.top_divider);
        if (r9 == null) goto L17;
        return new CryptKeeperProgressBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
