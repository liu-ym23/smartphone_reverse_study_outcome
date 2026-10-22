package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.RoundCornerListView;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintListPopupwindowLayoutBinding implements ViewBinding {
    public final FrameLayout reminderFrame;
    public final RoundCornerListView reminderList;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintListPopupwindowLayoutBinding(FrameLayout r1, FrameLayout r2, RoundCornerListView r3) {
        this.rootView = r1;
        this.reminderFrame = r2;
        this.reminderList = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintListPopupwindowLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintListPopupwindowLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_list_popupwindow_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintListPopupwindowLayoutBinding bind(View r3) {
        FrameLayout r0 = (FrameLayout) r3;
        RoundCornerListView r2 = (RoundCornerListView) ViewBindings.findChildViewById(r3, R.id.reminder_list);
        if (r2 == null) goto L7;
        return new FingerprintListPopupwindowLayoutBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.reminder_list)));
    }
}
