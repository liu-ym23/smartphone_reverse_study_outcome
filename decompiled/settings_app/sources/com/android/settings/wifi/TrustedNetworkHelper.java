package com.android.settings.wifi;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockPassword;
import com.android.settings.ChooseLockPattern;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.LockPasswordQualityHelper;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.titlebar.OCTitleBar;

/* JADX INFO: loaded from: classes.dex */
public class TrustedNetworkHelper {
    public static final String EXTRA_REQUEST_RESULT = "extra_request_result";
    private static final int MIN_PASSWORD_LENGTH = 4;
    public static final int REQ_CODE_CHOOSE_LOCK_PASSWORD = 10;
    public static final int REQ_CODE_CONFIRM_LOCK_PASSWORD = 11;
    private Activity mActivity;
    private CancelCallback mCancelCallback;
    private DevicePolicyManager mDPM;
    private Fragment mFragment;
    private LockPatternUtils mLockPatternUtils;
    private LockPasswordQualityHelper mLockQualityHelper;
    private OInsetSheet mMenuDialog;
    private OAlertDialogBuilder mWarnToChoosePasswordDialog;
    private boolean passwordConfirmed;

    public interface CancelCallback {
        void onCancel();
    }

    class MenuClickListener implements View.OnClickListener {
        int mPinLength;
        int mQuality;
        final /* synthetic */ TrustedNetworkHelper this$0;

        public MenuClickListener(TrustedNetworkHelper r1, int r2) {
            this.this$0 = r1;
            this.mPinLength = 4;
            this.mQuality = r2;
        }

        public MenuClickListener(TrustedNetworkHelper r1, int r2, int r3) {
            this.this$0 = r1;
            this.mQuality = r2;
            this.mPinLength = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            this.this$0.updateUnlockMethodAndFinish(this.mQuality, this.mPinLength);
            if (TrustedNetworkHelper.access$200(this.this$0).isShowing() == false) goto L6;
            TrustedNetworkHelper.access$200(this.this$0).dismiss();
            return;
        }
    }

    static /* synthetic */ void access$000(TrustedNetworkHelper r0) {
        r0.showChooseLockscreenModeDialog();
    }

    static /* synthetic */ void access$100(TrustedNetworkHelper r0) {
        r0.cancel();
    }

    static /* synthetic */ OInsetSheet access$200(TrustedNetworkHelper r0) {
        return r0.mMenuDialog;
    }

    public TrustedNetworkHelper(Activity r2) {
        this.mActivity = r2;
        this.mLockPatternUtils = new LockPatternUtils(this.mActivity);
        this.mDPM = (DevicePolicyManager) this.mActivity.getSystemService("device_policy");
        this.mLockQualityHelper = new LockPasswordQualityHelper(this.mActivity);
    }

    public TrustedNetworkHelper(Fragment r2) {
        this(r2.getActivity());
        this.mFragment = r2;
    }

    public boolean isLockScreenSecure() {
        return this.mLockPatternUtils.isSecure(UserHandle.myUserId());
    }

    public boolean isPasswordConfirmedSuccess() {
        return this.passwordConfirmed;
    }

    public void resetPasswordConfirmedFlag() {
        this.passwordConfirmed = false;
    }

    public void setCancelCallback(CancelCallback r1) {
        this.mCancelCallback = r1;
    }

    private void cancel() {
        CancelCallback r0 = this.mCancelCallback;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public void handleChooseOrConfirmPasswordResult(int r1, int r2, Intent r3) {
        if (r2 == (-1)) goto L5;
        return;
    L5:
        if (r1 != 10) goto L7;
    L8:
        this.passwordConfirmed = true;
        return;
    L7:
        if (r1 == 11) goto L8;
    }

    public void chooseOrConfirmPasswordDialog() {
        if (isLockScreenSecure() == false) goto L12;
        if (this.passwordConfirmed == false) goto L7;
        return;
    L7:
        if (this.mFragment == null) goto L9;
        ChooseLockSettingsHelper r0 = new ChooseLockSettingsHelper(this.mActivity, this.mFragment);
    L10:
        r0.launchConfirmationActivity(11, this.mActivity.getResources().getString(R.string.trust_network_need_confirm_pwd), 2);
        return;
    L9:
        r0 = new ChooseLockSettingsHelper(this.mActivity);
        goto L10
    L12:
        if (this.mWarnToChoosePasswordDialog != null) goto L14;
        this.mWarnToChoosePasswordDialog = new OAlertDialogBuilder(this.mActivity).autoDismiss(false).title(R.string.trust_network_create_pwd_dialog_title).message(R.string.trust_network_create_pwd_dialog_msg).horizontalButton().negativeButton(R.string.cancel, new AnonymousClass2(this)).positiveButton(R.string.trust_network_create_pwd_dialog_ok_btn, new AnonymousClass1(this));
    L14:
        this.mWarnToChoosePasswordDialog.show();
    }

    public boolean isDialogShowing() {
        OAlertDialogBuilder r0 = this.mWarnToChoosePasswordDialog;
        if (r0 != null) goto L5;
    L6:
        OInsetSheet r1 = this.mMenuDialog;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.isShowing() == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.createDialog().isShowing() == true) goto L10;
        goto L6
    }

    private void showChooseLockscreenModeDialog() {
        if (this.mMenuDialog != null) goto L8;
        OInsetSheet r0 = new OInsetSheet(this.mActivity);
        this.mMenuDialog = r0;
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        OCTitleBar r1 = new OCTitleBar(this.mActivity);
        r1.setTitleText(this.mActivity.getString(R.string.trust_network_menu_dialog_title));
        r1.setShowLeftBack(false);
        OButton r2 = r1.createNeutralButton(this.mActivity, r1.mRightContainer);
        r2.setButtonSourceBitmap(R.drawable.o_ic_close);
        r2.setOnClickListener(new AnonymousClass3(this));
        this.mMenuDialog.setHeaderView(r1);
        View r3 = LayoutInflater.from(this.mActivity).inflate(R.layout.choose_lock_screen_mode, null);
        if (isDeviceEncrypted() == true) goto L7;
        OListItemSettings r4 = (OListItemSettings) r3.findViewById(R.id.pattern);
        r4.setVisibility(0);
        r4.mTrailingElement.setVisibility(8);
        r4.setOnClickListener(new MenuClickListener(this, 65536));
    L7:
        OListItemSettings r5 = (OListItemSettings) r3.findViewById(R.id.four_pin);
        r5.mTrailingElement.setVisibility(8);
        r5.setOnClickListener(new MenuClickListener(this, 131072, 4));
        OListItemSettings r6 = (OListItemSettings) r3.findViewById(R.id.six_pin);
        r6.mTrailingElement.setVisibility(8);
        r6.setOnClickListener(new MenuClickListener(this, 131072, 6));
        OListItemSettings r7 = (OListItemSettings) r3.findViewById(R.id.password);
        r7.mTrailingElement.setVisibility(8);
        r7.setOnClickListener(new MenuClickListener(this, 262144));
        this.mMenuDialog.setContainerView(r3);
    L8:
        this.mMenuDialog.show();
    }

    void updateUnlockMethodAndFinish(int r10, int r11) {
        int r12 = this.mLockQualityHelper.upgradeQuality(r10);
        Intent r0 = new Intent();
        if (r12 < 131072) goto L9;
        int r1 = this.mDPM.getPasswordMinimumLength(null);
        if (r1 >= 4) goto L7;
        r1 = 4;
    L7:
        int r6 = this.mDPM.getPasswordMaximumLength(r12);
        r0.setClass(this.mActivity, ChooseLockPassword.class);
        r0.putExtra("lockscreen.password_type", r12);
        r0.putExtra(ChooseLockPassword.PASSWORD_MIN_KEY, r1);
        r0.putExtra(ChooseLockPassword.PASSWORD_MAX_KEY, r6);
        r0.putExtra(ChooseLockPassword.EXTRA_PIN_LENGTH, r11);
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(EXTRA_REQUEST_RESULT, true);
    L11:
        Fragment r13 = this.mFragment;
        if (r13 == null) goto L14;
        com.android.settings.Utils.startActivity(r13, r0, 0, 10);
        return;
    L14:
        com.android.settings.Utils.startActivity(this.mActivity, r0, 0, 10);
        return;
    L9:
        if (r12 != 65536) goto L11;
        r0.setClass(this.mActivity, ChooseLockPattern.class);
        r0.putExtra("pattern_size", 3);
        r0.putExtra("key_lock_method", "pattern");
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, false);
        r0.putExtra(EXTRA_REQUEST_RESULT, true);
        goto L11
    }

    private boolean isDeviceEncrypted() {
        DevicePolicyManager r3 = (DevicePolicyManager) this.mActivity.getSystemService("device_policy");
        if (UserHandle.myUserId() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        int r4 = r3.getStorageEncryptionStatus();
        if (r4 == 1) goto L12;
        if (r4 != 3) goto L12;
        return true;
    L12:
        return false;
    L5:
        r0 = false;
        goto L6
    }
}
