package com.android.settings.provision.NextPageRouting;

import android.app.Activity;
import android.content.Intent;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.Utils;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.biometrics.FaceRecognitionHelper;
import com.android.settings.biometrics.facejigan.LiteManager;
import com.android.settings.provision.PasswordActivity;
import com.android.settings.provision.ProvisionConstants;
import com.android.settings.provision.WizardManagerHelper;
import com.android.settings.teaevent.ProvisionTeaEvent;
import com.android.settings.teaevent.TeaEventConst;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class NextHandlerBase implements INextHandler {
    private INextHandler mNext;

    public static class NextToAccount extends NextHandlerBase {
        private static final String TAG = "NextToAccount";

        public NextToAccount() {
        }

        @Override // com.android.settings.provision.NextPageRouting.NextHandlerBase, com.android.settings.provision.NextPageRouting.INextHandler
        public boolean handleNextPage(Activity r4) {
            OLog.e(TAG, "handleNextPage");
            if (OAccountHelper.isLogin() == true) goto L11;
            if (WizardManagerHelper.isAnySetupWizard(r4.getIntent()) == false) goto L8;
            OLog.i(TAG, "nextStep isAnySetupWizard");
            RoutingUtils.startActivityDefault2(r4, WizardManagerHelper.getNextIntent(r4.getIntent(), -1), ProvisionConstants.REQ_ENTER_ACCOUNT);
            return true;
        L8:
            OLog.e(TAG, "handleNextPage 2");
            Intent r3 = new Intent();
            r3.setClassName("com.obric.account", "com.obric.account.phone_setup.PhoneSetupLoginActivity");
            ProvisionTeaEvent.overrideOutEnterPage(TeaEventConst.PAGE_LOGIN_DOUBAO, TeaEventConst.PAGE_UNLOCK_SETTING, r3);
            RoutingUtils.startActivityDefault2(r4, r3, ProvisionConstants.REQ_ENTER_ACCOUNT);
            return true;
        L11:
            return super.handleNextPage(r4);
        }
    }

    public static class NextToAssistant extends NextHandlerBase {
        private static final String TAG = "NextToAssistant";

        public NextToAssistant() {
        }

        @Override // com.android.settings.provision.NextPageRouting.NextHandlerBase, com.android.settings.provision.NextPageRouting.INextHandler
        public boolean handleNextPage(Activity r3) {
            OLog.e(TAG, "handleNextPage");
            Intent r2 = new Intent();
            r2.setClassName("com.android.provision", "com.android.provision.AssistantActivity");
            RoutingUtils.startActivityDefault(r3, r2, 0);
            return true;
        }
    }

    public static class NextToCloud extends NextHandlerBase {
        private static final String TAG = "NextToCloud";

        public NextToCloud() {
        }

        @Override // com.android.settings.provision.NextPageRouting.NextHandlerBase, com.android.settings.provision.NextPageRouting.INextHandler
        public boolean handleNextPage(Activity r4) {
            OLog.e(TAG, "handleNextPage");
            OLog.e(TAG, "handleNextPage 2");
            if (WizardManagerHelper.isAnySetupWizard(r4.getIntent()) == false) goto L6;
            OLog.i(TAG, "nextStep isAnySetupWizard");
            RoutingUtils.startActivityDefault2(r4, WizardManagerHelper.getNextIntent(r4.getIntent(), 201), ProvisionConstants.REQ_ENTER_CLOUD);
            return true;
        L6:
            Intent r3 = new Intent();
            r3.setClassName("com.obric.cloudservice", "com.obric.cloudservice.phone_setup.PhoneSetupSettingActivity");
            ProvisionTeaEvent.overrideOutEnterPage(TeaEventConst.PAGE_CLOUD_SERVICE, TeaEventConst.PAGE_UNLOCK_SETTING, r3);
            RoutingUtils.startActivityDefault2(r4, r3, ProvisionConstants.REQ_ENTER_CLOUD);
            return true;
        }
    }

    public static class NextToFace extends NextHandlerBase {
        private static final String TAG = "NextToFace";

        public NextToFace() {
        }

        @Override // com.android.settings.provision.NextPageRouting.NextHandlerBase, com.android.settings.provision.NextPageRouting.INextHandler
        public boolean handleNextPage(Activity r6) {
            OLog.e(TAG, "handleNextPage");
            initLiteManager(r6);
            boolean r0 = new FaceRecognitionHelper(r6).isFaceRecognitionDataExist();
            boolean r2 = Utils.isSeDevice();
            OLog.i(TAG, "isSeDevice " + r2);
            if (r2 == false) goto L8;
            if (r0 == true) goto L8;
            OLog.e(TAG, "handleNextPage 2");
            Intent r5 = new Intent();
            r5.setClassName("com.android.settings", "com.android.settings.provision.FaceActivity");
            r5.putExtra(ProvisionConstants.EXTRA_SETUPWIZARD, true);
            RoutingUtils.startActivityDefault(r6, r5, ProvisionConstants.REQ_ENTER_FACE);
            return true;
        L8:
            return super.handleNextPage(r6);
        }

        private void initLiteManager(Activity r3) {
            OLog.e(TAG, "initLiteManager");
            LiteManager.getInstance().initLite(r3, new AnonymousClass1(this));
        }
    }

    public static class NextToPassword extends NextHandlerBase {
        private static final String TAG = "NextToPassword";

        public NextToPassword() {
        }

        @Override // com.android.settings.provision.NextPageRouting.NextHandlerBase, com.android.settings.provision.NextPageRouting.INextHandler
        public boolean handleNextPage(Activity r4) {
            OLog.e(TAG, "handleNextPage");
            if (new LockPatternUtils(r4).isSecure(UserHandle.myUserId()) == true) goto L7;
            OLog.e(TAG, "handleNextPage 2");
            RoutingUtils.startActivityDefault(r4, new Intent(r4, PasswordActivity.class), ProvisionConstants.REQ_ENTER_PASSWORD);
            return true;
        L7:
            return super.handleNextPage(r4);
        }
    }

    public NextHandlerBase() {
    }

    @Override // com.android.settings.provision.NextPageRouting.INextHandler
    public INextHandler setNext(INextHandler r1) {
        this.mNext = r1;
        return r1;
    }

    @Override // com.android.settings.provision.NextPageRouting.INextHandler
    public boolean handleNextPage(Activity r1) {
        INextHandler r0 = this.mNext;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.handleNextPage(r1);
    }
}
