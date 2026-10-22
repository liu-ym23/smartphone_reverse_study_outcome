package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.selection.OActionSheetButton;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerOrFaceItemBinding implements ViewBinding {
    public final OActionSheetButton faceItem;
    public final OActionSheetButton fingerItem;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerOrFaceItemBinding(LinearLayout r1, OActionSheetButton r2, OActionSheetButton r3) {
        this.rootView = r1;
        this.faceItem = r2;
        this.fingerItem = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FingerOrFaceItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerOrFaceItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.finger_or_face_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerOrFaceItemBinding bind(View r3) {
        int r0 = R.id.face_item;
        OActionSheetButton r1 = (OActionSheetButton) ViewBindings.findChildViewById(r3, R.id.face_item);
        if (r1 == null) goto L9;
        r0 = R.id.finger_item;
        OActionSheetButton r2 = (OActionSheetButton) ViewBindings.findChildViewById(r3, R.id.finger_item);
        if (r2 == null) goto L9;
        return new FingerOrFaceItemBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
