package com.bytedanceos.securitycenter.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
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

    public void init(Context context) {
        this.mContext = context;
        ContentResolver r5 = context.getContentResolver();
        boolean r1 = true;
        if (Settings.Global.getInt(r5, CUSTOMIZED_STATUS_BAR_SECURITY, 1) == 1) goto L6;
        r1 = false;
    L6:
        this.mCustomizedStatusBarEnable = r1;
        final Handler r2 = new Handler();
        r5.registerContentObserver(Settings.Global.getUriFor(CUSTOMIZED_STATUS_BAR_SECURITY), false, new AnonymousClass1(this, r2));
    }

    public boolean customizedStatusBarEnable() {
        return this.mCustomizedStatusBarEnable;
    }
}
