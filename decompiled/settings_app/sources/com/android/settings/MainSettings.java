package com.android.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.core.CategoryMixin;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;
import obric.api.INewIntentHandler;

/* JADX INFO: loaded from: classes2.dex */
public class MainSettings extends BaseActivity implements CategoryMixin.CategoryHandler {
    private CategoryMixin mCategoryMixin;

    @Override // com.android.settings.base.BaseActivity
    public int getContentLayoutResId() {
        return R.layout.main_settings_layout;
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_MainSettings_com_obric_hook_lancet_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        com_android_settings_MainSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(this, r1);
    }

    @Override // com.android.settings.base.BaseActivity
    public boolean shouldAutoBindFragment() {
        return true;
    }

    public MainSettings() {
    }

    public void com_android_settings_MainSettings__onCreate$___twin___(Bundle r3) {
        Trace.beginSection(this.TAG + "-onCreate");     // Catch: Throwable -> L5
        super.onCreate(r3);     // Catch: Throwable -> L5
        this.mCategoryMixin = new CategoryMixin(this);     // Catch: Throwable -> L5
        getLifecycle().addObserver(this.mCategoryMixin);     // Catch: Throwable -> L5
        Trace.endSection();
        return;
    L5:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public void com_android_settings_MainSettings__onNewIntent$___twin___(Intent r4) {
        super.onNewIntent(r4);
        OLog.d(this.TAG, "onNewIntent " + r4);
        ActivityResultCaller r3 = getTopFragment();
        if ((r3 instanceof INewIntentHandler) == false) goto L6;
        ((INewIntentHandler) r3).handleNewIntent(r4);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        Fragment r0 = getTopFragment();
        if (r0 == null) goto L6;
        r0.onActivityResult(r1, r2, r3);
        return;
    }

    @Override // com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        throw new RuntimeException("subclass of MainSettings must overwrite getBindFragment method,and return real fragment instance");
    }

    @Override // com.android.settings.core.CategoryMixin.CategoryHandler
    public CategoryMixin getCategoryMixin() {
        return this.mCategoryMixin;
    }

    @Insert("onCreate")
    public static void com_android_settings_MainSettings_com_obric_hook_lancet_PrivacyHook_onCreate(MainSettings r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MainSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MainSettings__onCreate$___twin___(r4);
    }

    @Insert("onNewIntent")
    public static void com_android_settings_MainSettings_com_obric_hook_lancet_PrivacyHook_onNewIntent(MainSettings r3, Intent r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MainSettings r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onNewIntentWhenPrivacyNotOk(null);
        r0.superOnNewIntent(r4);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MainSettings__onNewIntent$___twin___(r4);
    }
}
