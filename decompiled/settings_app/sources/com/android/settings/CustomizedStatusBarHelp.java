package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import java.util.Observable;

/* JADX INFO: loaded from: classes2.dex */
public class CustomizedStatusBarHelp extends Observable {
    private static final String CUSTOMIZED_STATUS_BAR_SECURITY = "system_app_customized_status_bar_com.bytedanceos.security";
    private static final CustomizedStatusBarHelp INSTANCE = null;
    private Context mContext;
    private boolean mCustomizedStatusBarEnable;

    static /* synthetic */ Context access$000(CustomizedStatusBarHelp r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$100(CustomizedStatusBarHelp r0) {
        return r0.mCustomizedStatusBarEnable;
    }

    static /* synthetic */ boolean access$102(CustomizedStatusBarHelp r0, boolean r1) {
        r0.mCustomizedStatusBarEnable = r1;
        return r1;
    }

    static /* synthetic */ void access$200(CustomizedStatusBarHelp r0) {
        r0.setChanged();
    }

    static {
        INSTANCE = new CustomizedStatusBarHelp();
    }

    public static CustomizedStatusBarHelp getInstance() {
        return INSTANCE;
    }

    private CustomizedStatusBarHelp() {
        this.mCustomizedStatusBarEnable = true;
    }

    public void init(Context r5) {
        this.mContext = r5;
        ContentResolver r6 = r5.getContentResolver();
        boolean r3 = true;
        if (android.provider.Settings.Global.getInt(r6, CUSTOMIZED_STATUS_BAR_SECURITY, 0) == 1) goto L6;
        r3 = false;
    L6:
        this.mCustomizedStatusBarEnable = r3;
        final Handler r4 = new Handler();
        r6.registerContentObserver(android.provider.Settings.Global.getUriFor(CUSTOMIZED_STATUS_BAR_SECURITY), false, new AnonymousClass1(this, r4));
    }

    public boolean customizedStatusBarEnable() {
        return this.mCustomizedStatusBarEnable;
    }
}
