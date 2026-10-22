package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.TickMarkView;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneTouchpadHeaderBinding implements ViewBinding {
    public final TickMarkView pointerSpeed;
    private final LinearLayout rootView;
    public final SettingItemCheck scrollDirectionForward;
    public final SettingItemCheck scrollDirectionReverse;
    public final SettingItemSwitch touchToClick;
    public final SettingItemCheck touchpadAlwaysOn;
    public final SettingItemCheck touchpadDisableWhenMouseConnected;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneTouchpadHeaderBinding(LinearLayout r1, TickMarkView r2, SettingItemCheck r3, SettingItemCheck r4, SettingItemSwitch r5, SettingItemCheck r6, SettingItemCheck r7) {
        this.rootView = r1;
        this.pointerSpeed = r2;
        this.scrollDirectionForward = r3;
        this.scrollDirectionReverse = r4;
        this.touchToClick = r5;
        this.touchpadAlwaysOn = r6;
        this.touchpadDisableWhenMouseConnected = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneTouchpadHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneTouchpadHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_touchpad_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneTouchpadHeaderBinding bind(View r10) {
        int r0 = R.id.pointer_speed;
        TickMarkView r4 = (TickMarkView) ViewBindings.findChildViewById(r10, R.id.pointer_speed);
        if (r4 == null) goto L17;
        r0 = R.id.scroll_direction_forward;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.scroll_direction_forward);
        if (r5 == null) goto L17;
        r0 = R.id.scroll_direction_reverse;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.scroll_direction_reverse);
        if (r6 == null) goto L17;
        r0 = R.id.touch_to_click;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.touch_to_click);
        if (r7 == null) goto L17;
        r0 = R.id.touchpad_always_on;
        SettingItemCheck r8 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.touchpad_always_on);
        if (r8 == null) goto L17;
        r0 = R.id.touchpad_disable_when_mouse_connected;
        SettingItemCheck r9 = (SettingItemCheck) ViewBindings.findChildViewById(r10, R.id.touchpad_disable_when_mouse_connected);
        if (r9 == null) goto L17;
        return new RevoneTouchpadHeaderBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
