package com.android.settings.users;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RestrictedProfileSettings extends AppRestrictionsFragment implements EditUserInfoController.OnContentChangedCallback {
    private static final int DIALOG_CONFIRM_REMOVE = 2;
    static final int DIALOG_ID_EDIT_USER_INFO = 1;
    public static final String FILE_PROVIDER_AUTHORITY = "com.android.settings.files";
    private ImageView mDeleteButton;
    private EditUserInfoController mEditUserInfoController;
    private View mHeaderView;
    private ImageView mUserIconView;
    private TextView mUserNameView;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.users.AppRestrictionsFragment, com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RestrictedProfileSettings() {
        this.mEditUserInfoController = new EditUserInfoController();
    }

    static /* synthetic */ void access$000(RestrictedProfileSettings r0) {
        r0.removeUser();
    }

    public void com_android_settings_users_RestrictedProfileSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        if (r2 == null) goto L5;
        this.mEditUserInfoController.onRestoreInstanceState(r2);
    L5:
        init(r2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        View r0 = setPinnedHeaderView(R.layout.user_info_header);
        this.mHeaderView = r0;
        r0.setOnClickListener(this);
        this.mUserIconView = (ImageView) this.mHeaderView.findViewById(android.R.id.icon);
        this.mUserNameView = (TextView) this.mHeaderView.findViewById(android.R.id.title);
        ImageView r1 = (ImageView) this.mHeaderView.findViewById(R.id.delete);
        this.mDeleteButton = r1;
        r1.setOnClickListener(this);
        super.onActivityCreated(r3);
    }

    @Override // com.android.settings.users.AppRestrictionsFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r1) {
        super.onSaveInstanceState(r1);
        this.mEditUserInfoController.onSaveInstanceState(r1);
    }

    public void com_android_settings_users_RestrictedProfileSettings__onResume$___twin___() {
        super.onResume();
        UserInfo r0 = Utils.getExistingUser(this.mUserManager, this.mUser);
        if (r0 != null) goto L5;
        finishFragment();
        return;
    L5:
        ((TextView) this.mHeaderView.findViewById(android.R.id.title)).setText(r0.name);
        ((ImageView) this.mHeaderView.findViewById(android.R.id.icon)).setImageDrawable(com.android.settingslib.Utils.getUserIcon(getActivity(), this.mUserManager, r0));
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void startActivityForResult(Intent r2, int r3) {
        this.mEditUserInfoController.startingActivityForResult();
        super.startActivityForResult(r2, r3);
    }

    @Override // com.android.settings.users.AppRestrictionsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        this.mEditUserInfoController.onActivityResult(r1, r2, r3);
    }

    @Override // com.android.settings.users.AppRestrictionsFragment, android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mHeaderView) goto L6;
        showDialog(1);
        return;
    L6:
        if (r2 != this.mDeleteButton) goto L8;
        showDialog(2);
        return;
    L8:
        super.onClick(r2);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r9) {
        if (r9 != 1) goto L7;
        return this.mEditUserInfoController.createDialog(this, this.mUserIconView.getDrawable(), this.mUserNameView.getText(), R.string.profile_info_settings_title, this, this.mUser);
    L7:
        if (r9 == 2) goto L9;
        return null;
    L9:
        return UserDialogs.createRemoveDialog(getActivity(), this.mUser.getIdentifier(), new AnonymousClass1(this));
    }

    private void removeUser() {
        getView().post(new AnonymousClass2(this));
    }

    @Override // com.android.settings.users.EditUserInfoController.OnContentChangedCallback
    public void onPhotoChanged(Drawable r1) {
        this.mUserIconView.setImageDrawable(r1);
    }

    @Override // com.android.settings.users.EditUserInfoController.OnContentChangedCallback
    public void onLabelChanged(CharSequence r1) {
        this.mUserNameView.setText(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RestrictedProfileSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_RestrictedProfileSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RestrictedProfileSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_users_RestrictedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RestrictedProfileSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_users_RestrictedProfileSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
