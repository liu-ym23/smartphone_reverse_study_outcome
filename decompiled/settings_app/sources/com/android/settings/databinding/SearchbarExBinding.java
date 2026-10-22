package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchbarExBinding implements ViewBinding {
    public final TextView btnCancel;
    public final TextView btnEditClear;
    public final EditText edit;
    private final RelativeLayout rootView;
    public final LinearLayout searchbarEditLl;
    public final TextView searchbarLeftTv;
    public final TextView searchbarRightTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchbarExBinding(RelativeLayout r1, TextView r2, TextView r3, EditText r4, LinearLayout r5, TextView r6, TextView r7) {
        this.rootView = r1;
        this.btnCancel = r2;
        this.btnEditClear = r3;
        this.edit = r4;
        this.searchbarEditLl = r5;
        this.searchbarLeftTv = r6;
        this.searchbarRightTv = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SearchbarExBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchbarExBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.searchbar_ex, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchbarExBinding bind(View r10) {
        int r0 = R.id.btn_cancel;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.btn_cancel);
        if (r4 == null) goto L17;
        r0 = R.id.btn_edit_clear;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, R.id.btn_edit_clear);
        if (r5 == null) goto L17;
        r0 = R.id.edit;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r10, R.id.edit);
        if (r6 == null) goto L17;
        r0 = R.id.searchbar_edit_ll;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.searchbar_edit_ll);
        if (r7 == null) goto L17;
        r0 = R.id.searchbar_left_tv;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.searchbar_left_tv);
        if (r8 == null) goto L17;
        r0 = R.id.searchbar_right_tv;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, R.id.searchbar_right_tv);
        if (r9 == null) goto L17;
        return new SearchbarExBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
