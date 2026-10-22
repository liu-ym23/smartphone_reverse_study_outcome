package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.PreviewSettingItemView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherMultiBlockOptionsBinding implements ViewBinding {
    public final PreviewSettingItemView multiBlock36Grids;
    public final PreviewSettingItemView multiBlock81Grids;
    public final TextView multiBlockTips;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherMultiBlockOptionsBinding(LinearLayout r1, PreviewSettingItemView r2, PreviewSettingItemView r3, TextView r4) {
        this.rootView = r1;
        this.multiBlock36Grids = r2;
        this.multiBlock81Grids = r3;
        this.multiBlockTips = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LauncherMultiBlockOptionsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherMultiBlockOptionsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_multi_block_options, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherMultiBlockOptionsBinding bind(View r4) {
        int r0 = R.id.multi_block_36_grids;
        PreviewSettingItemView r1 = (PreviewSettingItemView) ViewBindings.findChildViewById(r4, R.id.multi_block_36_grids);
        if (r1 == null) goto L11;
        r0 = R.id.multi_block_81_grids;
        PreviewSettingItemView r2 = (PreviewSettingItemView) ViewBindings.findChildViewById(r4, R.id.multi_block_81_grids);
        if (r2 == null) goto L11;
        r0 = R.id.multi_block_tips;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.multi_block_tips);
        if (r3 == null) goto L11;
        return new LauncherMultiBlockOptionsBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
