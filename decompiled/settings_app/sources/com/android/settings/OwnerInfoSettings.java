package com.android.settings;

import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OwnerInfoSettings extends Fragment {
    public static final String EXTRA_SHOW_NICKNAME = "show_nickname";
    private CheckBox mCheckbox;
    private LockPatternUtils mLockPatternUtils;
    private EditText mNickname;
    private EditText mOwnerInfo;
    private boolean mShowNickname;
    private int mUserId;
    private View mView;

    private void initView() {
    }

    public void com_android_settings_OwnerInfoSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OwnerInfoSettings() {
    }

    public void com_android_settings_OwnerInfoSettings__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.containsKey(EXTRA_SHOW_NICKNAME) == false) goto L9;
        this.mShowNickname = r4.getBoolean(EXTRA_SHOW_NICKNAME);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mView = r2.inflate(R.layout.ownerinfo, r3, false);
        this.mUserId = UserHandle.myUserId();
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
        initView();
        return this.mView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        saveChanges();
    }

    void saveChanges() {
        String r0 = this.mOwnerInfo.getText().toString();
        this.mLockPatternUtils.setOwnerInfoEnabled(!TextUtils.isEmpty(r0), this.mUserId);
        this.mLockPatternUtils.setOwnerInfo(r0, this.mUserId);
        if (this.mShowNickname == false) goto L10;
        String r1 = UserManager.get(getActivity()).getUserName();
        Editable r2 = this.mNickname.getText();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return;
    L7:
        if (TextUtils.equals(r2, r1) == true) goto L12;
        UserManager.get(getActivity()).setUserName(UserHandle.myUserId(), r2.toString());
        return;
    L12:
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OwnerInfoSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OwnerInfoSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OwnerInfoSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_OwnerInfoSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OwnerInfoSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_OwnerInfoSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
