package com.android.settings.accounts;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.enterprise.EnterprisePrivacyFeatureProvider;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.obric.olog.OLog;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSettingsFragment extends BaseFragment {
    private EnterprisePrivacyFeatureProvider mFeatureProvider;
    private boolean mFlagAddBtnClicked;
    private OPopover mOPopover;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ boolean access$000(AccountSettingsFragment r0) {
        return r0.isShowMenu();
    }

    static /* synthetic */ void access$100(AccountSettingsFragment r0, View r1) {
        r0.showAddUserMenu(r1);
    }

    static /* synthetic */ boolean access$200(AccountSettingsFragment r0) {
        return r0.mFlagAddBtnClicked;
    }

    static /* synthetic */ boolean access$202(AccountSettingsFragment r0, boolean r1) {
        r0.mFlagAddBtnClicked = r1;
        return r1;
    }

    static /* synthetic */ EnterprisePrivacyFeatureProvider access$300(AccountSettingsFragment r0) {
        return r0.mFeatureProvider;
    }

    public AccountSettingsFragment() {
        super(R.layout.account_settings_activity);
    }

    public void com_android_settings_accounts_AccountSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mFeatureProvider = FeatureFactory.getFeatureFactory().getEnterprisePrivacyFeatureProvider();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        final AccountSettings r6 = (AccountSettings) getChildFragmentManager().findFragmentById(R.id.account_settings_fragment);
        OFloatingTitleBar r7 = this.mTitleView;
        if (r7 == null) goto L5;
        r7.addEndAction(R.drawable.oui_icon_oic_plus, -1, null).setOnClickListener(new AnonymousClass1(this, r6));
    L5:
        initFooter();
    }

    private void initFooter() {
        OSectionSupportiveText r0 = (OSectionSupportiveText) findViewById(R.id.disclosure_with_name);
        TextView r1 = (TextView) findViewById(R.id.learn_more_content_description);
        final boolean r2 = this.mFeatureProvider.hasDeviceOwner();
        final boolean r3 = this.mFeatureProvider.isInCompMode();
        boolean r4 = this.mFeatureProvider.hasWorkPolicyInfo();
        CharSequence r5 = this.mFeatureProvider.getDeviceOwnerDisclosure();
        if (r2 == true) goto L7;
        if (r4 == true) goto L7;
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
        r0.setVisibility(8);
        r1.setVisibility(8);
        return;
    L10:
        r0.setVisibility(0);
        if (r2 == false) goto L13;
        r0.setSectionDes(r5.toString());
    L14:
        r1.setVisibility(0);
        String r7 = this.mContext.getString(R.string.footer_learn_more_content_description, new Object[]{this.mContext.getString(R.string.header_add_an_account)});
        SpannableString r8 = new SpannableString(r7);
        r8.setSpan(new AnonymousClass2(this, r3, r2), 0, r7.length(), 33);
        r1.setText(r8);
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        r1.setHighlightColor(0);
        return;
    L13:
        r0.setSectionDes(this.mContext.getString(R.string.do_disclosure_generic));
    L7:
        r6 = true;
        goto L8
    }

    private boolean isShowMenu() {
        UserManager r2 = (UserManager) this._mActivity.getSystemService(PickApplicationActivity.EXTRA_USER);
        r2.getUserProfiles();
        Iterator<UserHandle> r0 = r2.getUserProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r2.isManagedProfile(r0.next().getIdentifier()) == false) goto L4;
        return true;
    L8:
        return false;
    }

    private void showAddUserMenu(View r9) {
        ArrayList r0 = new ArrayList();
        String r1 = this._mActivity.getString(R.string.accessibility_personal_account_title, new Object[]{""});
        String r2 = this._mActivity.getString(R.string.accessibility_work_account_title, new Object[]{""});
        r0.add(new Item(r1.replace("-", "").trim(), false, null));
        r0.add(new Item(r2.replace("-", "").trim(), false, null));
        this.mOPopover = OPopoverHelper.showPopoverList(this._mActivity, r9, r0, new AccountSettingsFragment$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$showAddUserMenu$0$com-android-settings-accounts-AccountSettingsFragment, reason: not valid java name */
    /* synthetic */ void m270xeedecc72(View r1, int r2) {
        OPopover r3 = this.mOPopover;
        if (r3 == null) goto L5;
        r3.dismiss();
    L5:
        startModifyAccount(r2);
    }

    private void startModifyAccount(int r7) {
        AccountSettings r0 = (AccountSettings) getChildFragmentManager().findFragmentById(R.id.account_settings_fragment);
        if (r7 != 0) goto L11;
        int r8 = UserHandle.myUserId();
        RestrictedLockUtils.EnforcedAdmin r9 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_modify_accounts", r8);
        if (r9 == null) goto L9;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r9);
        return;
    L9:
        if (this.mFlagAddBtnClicked == true) goto L23;
        this.mFlagAddBtnClicked = true;
        Intent r10 = r0.createAddWritableAccountIntent();
        r10.putExtra("FROM", 1);
        startActivity(r10);
        return;
    L23:
        return;
    L11:
        if (r7 != 1) goto L25;
        UserHandle r11 = Utils.getManagedProfile(UserManager.get(this._mActivity));
        if (r11 != null) goto L15;
        return;
    L15:
        int r4 = r11.getIdentifier();
        RestrictedLockUtils.EnforcedAdmin r2 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_modify_accounts", r4);
        if (r2 == null) goto L20;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r2);
        return;
    L20:
        if (this.mFlagAddBtnClicked == true) goto L26;
        this.mFlagAddBtnClicked = true;
        Intent r1 = r0.createAddWritableAccountIntent();
        r1.putExtra("FROM", 1);
        r1.putExtra("android.intent.extra.USER", r11);
        this._mActivity.startActivityAsUser(r1, r11);
        return;
    L26:
        return;
    }

    private void resetFlag() {
        this.mFlagAddBtnClicked = false;
    }

    public void com_android_settings_accounts_AccountSettingsFragment__onResume$___twin___() {
        super.onResume();
        resetFlag();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccountSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccountSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_AccountSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccountSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_AccountSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
