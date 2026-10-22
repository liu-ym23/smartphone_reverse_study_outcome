package com.android.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class AppHeader {
    public static final String EXTRA_HIDE_INFO_BUTTON = "hideInfoButton";
    private static final int INSTALLED_APP_DETAILS = 1;

    public static void createAppHeader(SettingsPreferenceFragment r0, Drawable r1, CharSequence r2, String r3, int r4, int r5, Intent r6) {
    }

    public AppHeader() {
    }

    public static void createAppHeader(SettingsPreferenceFragment r7, Drawable r8, CharSequence r9, String r10, int r11) {
        createAppHeader(r7, r8, r9, r10, r11, 0, null);
    }

    public static void createAppHeader(SettingsPreferenceFragment r7, Drawable r8, CharSequence r9, String r10, int r11, Intent r12) {
        createAppHeader(r7, r8, r9, r10, r11, 0, r12);
    }

    public static void createAppHeader(Activity r13, Drawable r14, CharSequence r15, String r16, int r17, ViewGroup r18) {
        View r1 = r13.getLayoutInflater().inflate(R.layout.app_header, r18, false);
        setupHeaderView(r13, r14, r15, r16, r17, false, 0, r1, null);
        r18.addView(r1);
    }

    public static void createAppHeader(SettingsPreferenceFragment r7, Drawable r8, CharSequence r9, String r10, int r11, int r12) {
        createAppHeader(r7, r8, r9, r10, r11, r12, null);
    }

    public static View setupHeaderView(final Activity r1, Drawable r2, CharSequence r3, final String r4, final int r5, final boolean r6, int r7, View r8, final Intent r9) {
        ImageView r0 = (ImageView) r8.findViewById(R.id.app_icon);
        r0.setImageDrawable(r2);
        if (r7 == 0) goto L5;
        r0.setImageTintList(ColorStateList.valueOf(r1.getColor(r7)));
    L5:
        ((TextView) r8.findViewById(R.id.app_name)).setText(r3);
        if (r4 != null) goto L8;
    L12:
        return r8;
    L8:
        if (r4.equals("os") == true) goto L12;
        r8.setClickable(true);
        r8.setOnClickListener(new AnonymousClass1(r6, r4, r5, r1));
        if (r9 == null) goto L12;
        View r10 = r8.findViewById(R.id.app_settings);
        r10.setVisibility(0);
        r10.setOnClickListener(new AnonymousClass2(r1, r9));
        goto L12
    }
}
