package com.android.settings.enterprise;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.UserHandle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.settings.R;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.Utils;
import com.android.settingslib.enterprise.ActionDisabledByAdminController;
import com.android.settingslib.enterprise.ActionDisabledByAdminControllerFactory;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.ImageStyleController;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ActionDisabledByAdminDialogHelper {
    private static final String TAG = "com.android.settings.enterprise.ActionDisabledByAdminDialogHelper";
    private final ActionDisabledByAdminController mActionDisabledByAdminController;
    private final Activity mActivity;
    private OAlertDialogBuilder mBuilder;
    RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;
    private String mRestriction;

    static {
    }

    public ActionDisabledByAdminDialogHelper(Activity r2) {
        this(r2, null);
    }

    public ActionDisabledByAdminDialogHelper(Activity r3, String r4) {
        this.mActivity = r3;
        this.mActionDisabledByAdminController = ActionDisabledByAdminControllerFactory.createInstance(r3, r4, new DeviceAdminStringProviderImpl(r3), UserHandle.SYSTEM);
        DevicePolicyManager r5 = (DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class);
        OAlertDialogBuilder r0 = new OAlertDialogBuilder(r3);
        this.mBuilder = r0;
        r0.title(r5.getResources().getString("Settings.DISABLED_BY_IT_ADMIN_TITLE", new ActionDisabledByAdminDialogHelper$$ExternalSyntheticLambda1(this)), false);
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-enterprise-ActionDisabledByAdminDialogHelper, reason: not valid java name */
    /* synthetic */ String m452x666019b() {
        return this.mActivity.getString(R.string.disabled_by_policy_title);
    }

    private int getEnforcementAdminUserId(RestrictedLockUtils.EnforcedAdmin r1) {
        if (r1.user != null) goto L6;
        return -10000;
    L6:
        return r1.user.getIdentifier();
    }

    private int getEnforcementAdminUserId() {
        return getEnforcementAdminUserId(this.mEnforcedAdmin);
    }

    public OAlertDialog prepareDialogBuilder(String r5, RestrictedLockUtils.EnforcedAdmin r6) {
        final DialogInterface.OnClickListener r0 = this.mActionDisabledByAdminController.getPositiveButtonListener(this.mActivity, r6);
        OAlertDialogBuilder r1 = this.mBuilder;
        if (r0 != null) goto L5;
        int r2 = R.string.suggestion_button_close;
    L6:
        r1.positiveButton(r2, new ActionDisabledByAdminDialogHelper$$ExternalSyntheticLambda0(r0));
        OAlertDialog r3 = this.mBuilder.createDialog();
        if (r3.getPositiveButton() == null) goto L9;
        r3.getPositiveButton().setId(android.R.id.button1);
    L9:
        prepareDialogBuilder(r3, r5, r6);
        return r3;
    L5:
        r2 = R.string.okay;
        goto L6
    }

    static /* synthetic */ void lambda$prepareDialogBuilder$1(DialogInterface.OnClickListener r0, DialogInterface r1, int r2) {
        if (r0 == null) goto L4;
        r0.onClick(r1, r2);
    L4:
        r1.dismiss();
    }

    void prepareDialogBuilder(OAlertDialog r4, String r5, RestrictedLockUtils.EnforcedAdmin r6) {
        this.mActionDisabledByAdminController.initialize(new ActionDisabledLearnMoreButtonLauncherImpl(this.mActivity, r4));
        this.mEnforcedAdmin = r6;
        this.mRestriction = r5;
        initializeDialogViews(r4, r6, getEnforcementAdminUserId(), this.mRestriction);
        this.mActionDisabledByAdminController.setupLearnMoreButton(this.mActivity);
    }

    public void updateDialog(String r2, RestrictedLockUtils.EnforcedAdmin r3, OAlertDialog r4) {
        if (this.mEnforcedAdmin.equals(r3) == true) goto L5;
    L7:
        this.mEnforcedAdmin = r3;
        this.mRestriction = r2;
        initializeDialogViews(r4, r3, getEnforcementAdminUserId(), this.mRestriction);
        return;
    L5:
        if (Objects.equals(this.mRestriction, r2) == false) goto L7;
    }

    private void initializeDialogViews(OAlertDialog r3, RestrictedLockUtils.EnforcedAdmin r4, int r5, String r6) {
        ComponentName r0 = r4.component;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mActionDisabledByAdminController.updateEnforcedAdmin(r4, r5);
        setAdminSupportIcon(r3, r0, r5);
        UserHandle r1 = null;
        if (isNotCurrentUserOrProfile(r0, r5) == false) goto L8;
        r0 = null;
    L8:
        setAdminSupportTitle(r3, r6);
        if (r5 == (-10000)) goto L12;
        r1 = UserHandle.of(r5);
    L12:
        setAdminSupportDetails(this.mActivity, r3, new RestrictedLockUtils.EnforcedAdmin(r0, r1));
    }

    private boolean isNotCurrentUserOrProfile(ComponentName r2, int r3) {
        if (RestrictedLockUtilsInternal.isAdminInCurrentUserOrProfile(this.mActivity, r2) == true) goto L5;
    L8:
        return true;
    L5:
        if (RestrictedLockUtils.isCurrentUserOrProfile(this.mActivity, r3) == false) goto L8;
        return false;
    }

    void setAdminSupportIcon(OAlertDialog r2, ComponentName r3, int r4) {
        Drawable r5 = this.mActivity.getDrawable(R.drawable.ic_lock_closed);
        r5.setTintList(Utils.getColorAccent(this.mActivity));
        int r0 = 0;
        ImageStyleController r6 = new ImageStyleController(this.mActivity, 0);
        r6.setImageDrawable(r5);
        r2.setTopImageStyleController(r6);
        r6.attachToDialog(r2);
        FrameLayout r1 = r2.getIconSlot();
    L4:
        if (r0 >= r1.getChildCount()) goto L9;
        View r7 = r1.getChildAt(r0);
        if ((r7 instanceof ImageView) == false) goto L8;
        r7.setId(R.id.admin_support_icon);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    void setAdminSupportTitle(OAlertDialog r3, String r4) {
        if (r3.getTitleView() == null) goto L6;
        r3.getTitleView().setId(R.id.admin_support_dialog_title);
        r3.setTitle(this.mActionDisabledByAdminController.getAdminSupportTitle(r4));
        return;
    }

    void setAdminSupportDetails(Activity r4, OAlertDialog r5, RestrictedLockUtils.EnforcedAdmin r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.component == null) goto L24;
        DevicePolicyManager r0 = (DevicePolicyManager) r4.getSystemService("device_policy");
        CharSequence r2 = null;
        if (RestrictedLockUtilsInternal.isAdminInCurrentUserOrProfile(r4, r6.component) == true) goto L9;
    L17:
        r6.component = null;
    L18:
        CharSequence r3 = this.mActionDisabledByAdminController.getAdminSupportContentString(this.mActivity, r2);
        if (r5.getMessageView() == null) goto L23;
        r5.getMessageView().setId(R.id.admin_support_msg);
        r5.setMessage(r3, true);
        return;
    L23:
        return;
    L9:
        if (RestrictedLockUtils.isCurrentUserOrProfile(r4, getEnforcementAdminUserId(r6)) == false) goto L17;
        if (r6.user != null) goto L15;
        r6.user = UserHandle.of(UserHandle.myUserId());
    L15:
        if (UserHandle.isSameApp(Process.myUid(), 1000) == false) goto L18;
        r2 = r0.getShortSupportMessageForUser(r6.component, getEnforcementAdminUserId(r6));
        goto L18
    }
}
