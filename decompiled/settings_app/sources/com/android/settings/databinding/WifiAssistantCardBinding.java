package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiAssistantCardBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout wifiAssistantCard;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiAssistantCardBinding(LinearLayout r1, LinearLayout r2) {
        this.rootView = r1;
        this.wifiAssistantCard = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiAssistantCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiAssistantCardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_assistant_card, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiAssistantCardBinding bind(View r1) {
        if (r1 == null) goto L6;
        LinearLayout r2 = (LinearLayout) r1;
        return new WifiAssistantCardBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
