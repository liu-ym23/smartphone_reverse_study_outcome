package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class ProxyBinding implements ViewBinding {
    public final Button action;
    public final Button clear;
    public final Button defaultView;
    public final EditText exclusionlist;
    public final EditText hostname;
    public final EditText port;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProxyBinding(OScrollView r1, Button r2, Button r3, Button r4, EditText r5, EditText r6, EditText r7) {
        this.rootView = r1;
        this.action = r2;
        this.clear = r3;
        this.defaultView = r4;
        this.exclusionlist = r5;
        this.hostname = r6;
        this.port = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static ProxyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProxyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.proxy, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProxyBinding bind(View r10) {
        int r0 = R.id.action;
        Button r4 = (Button) ViewBindings.findChildViewById(r10, R.id.action);
        if (r4 == null) goto L17;
        r0 = R.id.clear;
        Button r5 = (Button) ViewBindings.findChildViewById(r10, R.id.clear);
        if (r5 == null) goto L17;
        r0 = R.id.defaultView;
        Button r6 = (Button) ViewBindings.findChildViewById(r10, R.id.defaultView);
        if (r6 == null) goto L17;
        r0 = R.id.exclusionlist;
        EditText r7 = (EditText) ViewBindings.findChildViewById(r10, R.id.exclusionlist);
        if (r7 == null) goto L17;
        r0 = R.id.hostname;
        EditText r8 = (EditText) ViewBindings.findChildViewById(r10, R.id.hostname);
        if (r8 == null) goto L17;
        r0 = R.id.port;
        EditText r9 = (EditText) ViewBindings.findChildViewById(r10, R.id.port);
        if (r9 == null) goto L17;
        return new ProxyBinding((OScrollView) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
