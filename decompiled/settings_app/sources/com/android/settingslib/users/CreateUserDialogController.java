package com.android.settingslib.users;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.android.internal.util.UserIcons;
import com.android.settingslib.R;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.drawable.CircleFramedDrawable;
import com.android.settingslib.utils.CustomDialogHelper;
import com.android.settingslib.utils.ThreadUtils;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CreateUserDialogController {
    private static final int CREATE_USER_AND_CLOSE = 3;
    private static final int EDIT_NAME_DIALOG = 2;
    private static final int EXIT_DIALOG = -1;
    private static final int GRANT_ADMIN_DIALOG = 1;
    private static final int INITIAL_DIALOG = 0;
    private static final String KEY_ADD_USER_LONG_MESSAGE_DISPLAYED = "key_add_user_long_message_displayed";
    private static final String KEY_AWAITING_RESULT = "awaiting_result";
    private static final String KEY_CURRENT_STATE = "current_state";
    private static final String KEY_IS_ADMIN = "admin_status";
    private static final String KEY_SAVED_NAME = "saved_name";
    private static final String KEY_SAVED_PHOTO = "pending_photo";
    public static final int MESSAGE_PADDING = 10;
    private Activity mActivity;
    private ActivityStarter mActivityStarter;
    private String mCachedDrawablePath;
    private Runnable mCancelCallback;
    private int mCurrentState;
    private CustomDialogHelper mCustomDialogHelper;
    private View mEditUserInfoView;
    private EditUserPhotoController mEditUserPhotoController;
    private final String mFileAuthority;
    private View mGrantAdminView;
    private Boolean mIsAdmin;
    private Drawable mNewUserIcon;
    private Drawable mSavedDrawable;
    private String mSavedName;
    private Bitmap mSavedPhoto;
    private NewUserData mSuccessCallback;
    private Dialog mUserCreationDialog;
    private String mUserName;
    private EditText mUserNameView;
    private boolean mWaitingForActivityResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AddUserState {
    }

    public CreateUserDialogController(String r1) {
        this.mFileAuthority = r1;
    }

    public void clear() {
        this.mUserCreationDialog = null;
        this.mCustomDialogHelper = null;
        this.mEditUserPhotoController = null;
        this.mSavedPhoto = null;
        this.mSavedName = null;
        this.mSavedDrawable = null;
        this.mIsAdmin = null;
        this.mActivity = null;
        this.mActivityStarter = null;
        this.mGrantAdminView = null;
        this.mEditUserInfoView = null;
        this.mUserNameView = null;
        this.mSuccessCallback = null;
        this.mCancelCallback = null;
        this.mCachedDrawablePath = null;
        this.mCurrentState = 0;
    }

    public void onRestoreInstanceState(Bundle r3) {
        this.mCachedDrawablePath = r3.getString(KEY_SAVED_PHOTO);
        this.mCurrentState = r3.getInt(KEY_CURRENT_STATE);
        if (r3.containsKey(KEY_IS_ADMIN) == false) goto L5;
        this.mIsAdmin = Boolean.valueOf(r3.getBoolean(KEY_IS_ADMIN));
    L5:
        this.mSavedName = r3.getString(KEY_SAVED_NAME);
        this.mWaitingForActivityResult = r3.getBoolean(KEY_AWAITING_RESULT, false);
    }

    public void onSaveInstanceState(Bundle r3) {
        if (this.mUserCreationDialog == null) goto L9;
        EditUserPhotoController r0 = this.mEditUserPhotoController;
        if (r0 == null) goto L9;
        if (this.mCachedDrawablePath != null) goto L9;
        this.mCachedDrawablePath = r0.getCachedDrawablePath();
    L9:
        String r1 = this.mCachedDrawablePath;
        if (r1 == null) goto L13;
        r3.putString(KEY_SAVED_PHOTO, r1);
    L13:
        if (this.mIsAdmin == null) goto L15;
        r3.putBoolean(KEY_IS_ADMIN, Boolean.TRUE.equals(this.mIsAdmin));
    L15:
        r3.putString(KEY_SAVED_NAME, this.mUserNameView.getText().toString().trim());
        r3.putInt(KEY_CURRENT_STATE, this.mCurrentState);
        r3.putBoolean(KEY_AWAITING_RESULT, this.mWaitingForActivityResult);
    }

    public void startingActivityForResult() {
        this.mWaitingForActivityResult = true;
    }

    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mWaitingForActivityResult = false;
        EditUserPhotoController r1 = this.mEditUserPhotoController;
        if (r1 == null) goto L6;
        r1.onActivityResult(r2, r3, r4);
        return;
    }

    public Dialog createDialog(Activity r2, ActivityStarter r3, boolean r4, NewUserData r5, Runnable r6) {
        this.mActivity = r2;
        this.mCustomDialogHelper = new CustomDialogHelper(r2);
        this.mSuccessCallback = r5;
        this.mCancelCallback = r6;
        this.mActivityStarter = r3;
        addCustomViews(r4);
        this.mUserCreationDialog = this.mCustomDialogHelper.getDialog();
        updateLayout();
        this.mUserCreationDialog.setOnDismissListener(new CreateUserDialogController$$ExternalSyntheticLambda3(this));
        this.mCustomDialogHelper.setMessagePadding(10);
        this.mUserCreationDialog.setCanceledOnTouchOutside(true);
        return this.mUserCreationDialog;
    }

    /* JADX INFO: renamed from: lambda$createDialog$0$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ void m786x4a401cbc(DialogInterface r1) {
        finish();
    }

    private void addCustomViews(final boolean r4) {
        addGrantAdminView();
        addUserInfoEditView();
        this.mCustomDialogHelper.setPositiveButton(R.string.next, new CreateUserDialogController$$ExternalSyntheticLambda0(this, r4));
        this.mCustomDialogHelper.setNegativeButton(R.string.back, new CreateUserDialogController$$ExternalSyntheticLambda1(this, r4));
    }

    /* JADX INFO: renamed from: lambda$addCustomViews$1$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ void m782x23dc7363(boolean r2, View r3) {
        int r4 = this.mCurrentState + 1;
        this.mCurrentState = r4;
        if (r4 != 1) goto L6;
        if (r2 == true) goto L6;
        this.mCurrentState = r4 + 1;
    L6:
        updateLayout();
    }

    /* JADX INFO: renamed from: lambda$addCustomViews$2$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ void m783xb0c98a82(boolean r2, View r3) {
        int r4 = this.mCurrentState - 1;
        this.mCurrentState = r4;
        if (r4 != 1) goto L6;
        if (r2 == true) goto L6;
        this.mCurrentState = r4 - 1;
    L6:
        updateLayout();
    }

    private void updateLayout() {
        int r0 = this.mCurrentState;
        if (r0 != (-1)) goto L5;
        this.mCustomDialogHelper.getDialog().dismiss();
        return;
    L5:
        if (r0 == 0) goto L28;
        if (r0 == 1) goto L25;
        if (r0 != 2) goto L9;
        this.mCustomDialogHelper.setVisibility(0, false).setVisibility(2, false).setTitle(R.string.user_info_settings_title).setNegativeButtonText(R.string.back).setPositiveButtonText(R.string.done);
        this.mCustomDialogHelper.requestFocusOnTitle();
        this.mEditUserInfoView.setVisibility(0);
        this.mGrantAdminView.setVisibility(8);
        return;
    L9:
        if (r0 == 3) goto L13;
        if (r0 >= (-1)) goto L12;
        this.mCurrentState = -1;
        updateLayout();
        return;
    L12:
        this.mCurrentState = 3;
        updateLayout();
        return;
    L13:
        EditUserPhotoController r1 = this.mEditUserPhotoController;
        if (r1 != null) goto L16;
    L18:
        Drawable r2 = this.mSavedDrawable;
    L19:
        this.mNewUserIcon = r2;
        String r3 = this.mUserNameView.getText().toString().trim();
        String r4 = this.mActivity.getString(R.string.user_new_user_name);
        if (r3.isEmpty() == false) goto L23;
        r3 = r4;
    L23:
        this.mUserName = r3;
        this.mCustomDialogHelper.getDialog().dismiss();
        return;
    L16:
        if (r1.getNewUserPhotoDrawable() == null) goto L18;
        r2 = this.mEditUserPhotoController.getNewUserPhotoDrawable();
        goto L19
    L25:
        this.mEditUserInfoView.setVisibility(8);
        this.mGrantAdminView.setVisibility(0);
        this.mCustomDialogHelper.setVisibility(0, true).setVisibility(2, true).setIcon(this.mActivity.getDrawable(R.drawable.ic_admin_panel_settings)).setTitle(R.string.user_grant_admin_title).setMessage(R.string.user_grant_admin_message).setNegativeButtonText(R.string.back).setPositiveButtonText(R.string.next);
        this.mCustomDialogHelper.requestFocusOnTitle();
        if (this.mIsAdmin != null) goto L41;
        this.mCustomDialogHelper.setButtonEnabled(false);
        return;
    L41:
        return;
    L28:
        this.mEditUserInfoView.setVisibility(8);
        this.mGrantAdminView.setVisibility(8);
        SharedPreferences r5 = this.mActivity.getPreferences(0);
        boolean r6 = r5.getBoolean(KEY_ADD_USER_LONG_MESSAGE_DISPLAYED, false);
        if (r6 == false) goto L31;
        int r7 = R.string.user_add_user_message_short;
    L32:
        if (r6 == true) goto L34;
        r5.edit().putBoolean(KEY_ADD_USER_LONG_MESSAGE_DISPLAYED, true).apply();
    L34:
        Drawable r8 = this.mActivity.getDrawable(R.drawable.ic_person_add);
        this.mCustomDialogHelper.setVisibility(0, true).setVisibility(2, true).setIcon(r8).setButtonEnabled(true).setTitle(R.string.user_add_user_title).setMessage(r7).setNegativeButtonText(R.string.cancel).setPositiveButtonText(R.string.next);
        this.mCustomDialogHelper.requestFocusOnTitle();
        return;
    L31:
        r7 = R.string.user_add_user_message_long;
        goto L32
    }

    private void setUserIcon(Drawable r2, final ImageView r3) {
        if (this.mCachedDrawablePath == null) goto L5;
        Futures.addCallback(ThreadUtils.getBackgroundExecutor().submit(new CreateUserDialogController$$ExternalSyntheticLambda2(this)), new AnonymousClass1(this, r3), this.mActivity.getMainExecutor());
        return;
    L5:
        r3.setImageDrawable(r2);
    }

    /* JADX INFO: renamed from: lambda$setUserIcon$3$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ Drawable m787x6dcd4031() throws Exception {
        Bitmap r0 = EditUserPhotoController.loadNewUserPhotoBitmap(new File(this.mCachedDrawablePath));
        this.mSavedPhoto = r0;
        CircleFramedDrawable r1 = CircleFramedDrawable.getInstance(this.mActivity, r0);
        this.mSavedDrawable = r1;
        return r1;
    }

    private void addUserInfoEditView() {
        View r0 = View.inflate(this.mActivity, R.layout.edit_user_info_dialog_content, null);
        this.mEditUserInfoView = r0;
        this.mCustomDialogHelper.addCustomView(r0);
        setUserName();
        ImageView r1 = (ImageView) this.mEditUserInfoView.findViewById(R.id.user_photo);
        setUserIcon(UserIcons.getDefaultUserIcon(this.mActivity.getResources(), -10000, false), r1);
        if (isChangePhotoRestrictedByBase(this.mActivity) == false) goto L5;
        this.mEditUserInfoView.findViewById(R.id.add_a_photo_icon).setVisibility(8);
        return;
    L5:
        final RestrictedLockUtils.EnforcedAdmin r2 = getChangePhotoAdminRestriction(this.mActivity);
        if (r2 == null) goto L8;
        r1.setOnClickListener(new CreateUserDialogController$$ExternalSyntheticLambda4(this, r2));
        return;
    L8:
        this.mEditUserPhotoController = createEditUserPhotoController(r1);
    }

    /* JADX INFO: renamed from: lambda$addUserInfoEditView$4$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ void m785x504a90d(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mActivity, r1);
    }

    private void setUserName() {
        EditText r0 = (EditText) this.mEditUserInfoView.findViewById(R.id.user_name);
        this.mUserNameView = r0;
        String r2 = this.mSavedName;
        if (r2 != null) goto L5;
        r0.setText(R.string.user_new_user_name);
        return;
    L5:
        r0.setText(r2);
    }

    private void addGrantAdminView() {
        View r0 = View.inflate(this.mActivity, R.layout.grant_admin_dialog_content, null);
        this.mGrantAdminView = r0;
        this.mCustomDialogHelper.addCustomView(r0);
        RadioGroup r1 = (RadioGroup) this.mGrantAdminView.findViewById(R.id.choose_admin);
        r1.setOnCheckedChangeListener(new CreateUserDialogController$$ExternalSyntheticLambda5(this));
        if (Boolean.TRUE.equals(this.mIsAdmin) == false) goto L6;
        ((RadioButton) r1.findViewById(R.id.grant_admin_yes)).setChecked(true);
        return;
    L6:
        if (Boolean.FALSE.equals(this.mIsAdmin) == false) goto L10;
        ((RadioButton) r1.findViewById(R.id.grant_admin_no)).setChecked(true);
        return;
    }

    /* JADX INFO: renamed from: lambda$addGrantAdminView$5$com-android-settingslib-users-CreateUserDialogController, reason: not valid java name */
    /* synthetic */ void m784x5a9e2e5c(RadioGroup r2, int r3) {
        boolean r0 = true;
        this.mCustomDialogHelper.setButtonEnabled(true);
        if (r3 == R.id.grant_admin_yes) goto L6;
        r0 = false;
    L6:
        this.mIsAdmin = Boolean.valueOf(r0);
    }

    boolean isChangePhotoRestrictedByBase(Context r2) {
        return RestrictedLockUtilsInternal.hasBaseUserRestriction(r2, "no_set_user_icon", UserHandle.myUserId());
    }

    RestrictedLockUtils.EnforcedAdmin getChangePhotoAdminRestriction(Context r2) {
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r2, "no_set_user_icon", UserHandle.myUserId());
    }

    EditUserPhotoController createEditUserPhotoController(ImageView r9) {
        return new EditUserPhotoController(this.mActivity, this.mActivityStarter, r9, this.mSavedPhoto, this.mSavedDrawable, this.mFileAuthority);
    }

    public boolean isActive() {
        CustomDialogHelper r0 = this.mCustomDialogHelper;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getDialog() == null) goto L7;
        return true;
    }

    public void finish() {
        if (this.mCurrentState != 3) goto L7;
        NewUserData r0 = this.mSuccessCallback;
        if (r0 == null) goto L10;
        r0.onSuccess(this.mUserName, this.mNewUserIcon, Boolean.valueOf(Boolean.TRUE.equals(this.mIsAdmin)));
    L10:
        clear();
        return;
    L7:
        Runnable r1 = this.mCancelCallback;
        if (r1 == null) goto L10;
        r1.run();
        goto L10
    }
}
