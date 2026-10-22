package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityProvisionUnlockmethodselectBinding implements ViewBinding {
    public final OCardListItem methodFace;
    public final OCardListItem methodFingerPrint;
    public final OCardListItem methodSimplepwd;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityProvisionUnlockmethodselectBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4) {
        this.rootView = r1;
        this.methodFace = r2;
        this.methodFingerPrint = r3;
        this.methodSimplepwd = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityProvisionUnlockmethodselectBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityProvisionUnlockmethodselectBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_provision_unlockmethodselect, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityProvisionUnlockmethodselectBinding bind(View r4) {
        int r0 = R.id.method_face;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.method_face);
        if (r1 == null) goto L11;
        r0 = R.id.method_finger_print;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.method_finger_print);
        if (r2 == null) goto L11;
        r0 = R.id.method_simplepwd;
        OCardListItem r3 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.method_simplepwd);
        if (r3 == null) goto L11;
        return new ActivityProvisionUnlockmethodselectBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
