package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingCommonSeekbarBinding implements ViewBinding {
    public final ListContentItemCustom idButtonContainer;
    public final GroupListItemVerticalGapLayoutBinding idGapView;
    public final SeekBar idSeekbar;
    public final ListContentItemCustom idSeekbarInLayout;
    public final TextView idSeekbarLeft;
    public final Button idSeekbarReset;
    public final TextView idSeekbarRight;
    public final TextView idSeekbarTips;
    public final TextView idSeekbarTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingCommonSeekbarBinding(LinearLayout r1, ListContentItemCustom r2, GroupListItemVerticalGapLayoutBinding r3, SeekBar r4, ListContentItemCustom r5, TextView r6, Button r7, TextView r8, TextView r9, TextView r10) {
        this.rootView = r1;
        this.idButtonContainer = r2;
        this.idGapView = r3;
        this.idSeekbar = r4;
        this.idSeekbarInLayout = r5;
        this.idSeekbarLeft = r6;
        this.idSeekbarReset = r7;
        this.idSeekbarRight = r8;
        this.idSeekbarTips = r9;
        this.idSeekbarTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingCommonSeekbarBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingCommonSeekbarBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_common_seekbar, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingCommonSeekbarBinding bind(View r13) {
        int r0 = R.id.id_button_container;
        ListContentItemCustom r4 = (ListContentItemCustom) ViewBindings.findChildViewById(r13, R.id.id_button_container);
        if (r4 == null) goto L23;
        r0 = R.id.id_gap_view;
        View r1 = ViewBindings.findChildViewById(r13, R.id.id_gap_view);
        if (r1 == null) goto L23;
        GroupListItemVerticalGapLayoutBinding r5 = GroupListItemVerticalGapLayoutBinding.bind(r1);
        r0 = R.id.id_seekbar;
        SeekBar r6 = (SeekBar) ViewBindings.findChildViewById(r13, R.id.id_seekbar);
        if (r6 == null) goto L23;
        r0 = R.id.id_seekbar_in_layout;
        ListContentItemCustom r7 = (ListContentItemCustom) ViewBindings.findChildViewById(r13, R.id.id_seekbar_in_layout);
        if (r7 == null) goto L23;
        r0 = R.id.id_seekbar_left;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_seekbar_left);
        if (r8 == null) goto L23;
        r0 = R.id.id_seekbar_reset;
        Button r9 = (Button) ViewBindings.findChildViewById(r13, R.id.id_seekbar_reset);
        if (r9 == null) goto L23;
        r0 = R.id.id_seekbar_right;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_seekbar_right);
        if (r10 == null) goto L23;
        r0 = R.id.id_seekbar_tips;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_seekbar_tips);
        if (r11 == null) goto L23;
        r0 = R.id.id_seekbar_title;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_seekbar_title);
        if (r12 == null) goto L23;
        return new SettingCommonSeekbarBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
