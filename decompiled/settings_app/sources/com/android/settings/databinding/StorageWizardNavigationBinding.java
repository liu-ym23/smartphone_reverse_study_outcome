package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageWizardNavigationBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout suwLayoutNavigationBar;
    public final Button suwNavbarBack;
    public final Button suwNavbarMore;
    public final Button suwNavbarNext;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardNavigationBinding(LinearLayout r1, LinearLayout r2, Button r3, Button r4, Button r5) {
        this.rootView = r1;
        this.suwLayoutNavigationBar = r2;
        this.suwNavbarBack = r3;
        this.suwNavbarMore = r4;
        this.suwNavbarNext = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardNavigationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardNavigationBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_navigation, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardNavigationBinding bind(View r6) {
        LinearLayout r2 = (LinearLayout) r6;
        int r0 = R.id.suw_navbar_back;
        Button r3 = (Button) ViewBindings.findChildViewById(r6, R.id.suw_navbar_back);
        if (r3 == null) goto L11;
        r0 = R.id.suw_navbar_more;
        Button r4 = (Button) ViewBindings.findChildViewById(r6, R.id.suw_navbar_more);
        if (r4 == null) goto L11;
        r0 = R.id.suw_navbar_next;
        Button r5 = (Button) ViewBindings.findChildViewById(r6, R.id.suw_navbar_next);
        if (r5 == null) goto L11;
        return new StorageWizardNavigationBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
