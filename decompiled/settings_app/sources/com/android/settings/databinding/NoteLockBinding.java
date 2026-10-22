package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class NoteLockBinding implements ViewBinding {
    public final ListContentItemCheck itemNoteLock;
    public final LinearLayout noteLockLayout;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NoteLockBinding(RelativeLayout r1, ListContentItemCheck r2, LinearLayout r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.itemNoteLock = r2;
        this.noteLockLayout = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NoteLockBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NoteLockBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.note_lock, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NoteLockBinding bind(View r4) {
        int r0 = R.id.item_note_lock;
        ListContentItemCheck r1 = (ListContentItemCheck) ViewBindings.findChildViewById(r4, R.id.item_note_lock);
        if (r1 == null) goto L11;
        r0 = R.id.note_lock_layout;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.note_lock_layout);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new NoteLockBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
