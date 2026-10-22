package com.android.settingslib.users;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.android.internal.util.UserIcons;
import com.android.settingslib.R;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.drawable.CircleFramedDrawable;
import com.android.settingslib.utils.CustomDialogHelper;
import java.io.File;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class EditUserInfoController {
    private static final String KEY_AWAITING_RESULT = "awaiting_result";
    private static final String KEY_SAVED_PHOTO = "pending_photo";
    private Dialog mEditUserInfoDialog;
    private EditUserPhotoController mEditUserPhotoController;
    private final String mFileAuthority;
    private Drawable mSavedDrawable;
    private Bitmap mSavedPhoto;
    private boolean mWaitingForActivityResult;

    public EditUserInfoController(String r2) {
        this.mWaitingForActivityResult = false;
        this.mFileAuthority = r2;
    }

    private void clear() {
        EditUserPhotoController r0 = this.mEditUserPhotoController;
        if (r0 == null) goto L5;
        r0.removeNewUserPhotoBitmapFile();
    L5:
        this.mEditUserInfoDialog = null;
        this.mSavedPhoto = null;
        this.mSavedDrawable = null;
    }

    public void onRestoreInstanceState(Bundle r3) {
        String r0 = r3.getString(KEY_SAVED_PHOTO);
        if (r0 == null) goto L5;
        this.mSavedPhoto = EditUserPhotoController.loadNewUserPhotoBitmap(new File(r0));
    L5:
        this.mWaitingForActivityResult = r3.getBoolean(KEY_AWAITING_RESULT, false);
    }

    public void onSaveInstanceState(Bundle r3) {
        if (this.mEditUserInfoDialog == null) goto L9;
        EditUserPhotoController r0 = this.mEditUserPhotoController;
        if (r0 == null) goto L9;
        File r1 = r0.saveNewUserPhotoBitmap();
        if (r1 == null) goto L9;
        r3.putString(KEY_SAVED_PHOTO, r1.getPath());
    L9:
        r3.putBoolean(KEY_AWAITING_RESULT, this.mWaitingForActivityResult);
    }

    public void startingActivityForResult() {
        this.mWaitingForActivityResult = true;
    }

    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mWaitingForActivityResult = false;
        EditUserPhotoController r0 = this.mEditUserPhotoController;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mEditUserInfoDialog == null) goto L9;
        r0.onActivityResult(r2, r3, r4);
        return;
    }

    public Dialog createDialog(final Activity r9, ActivityStarter r10, Drawable r11, String r12, BiConsumer<String, Drawable> r13, Runnable r14) {
        View r2 = LayoutInflater.from(r9).inflate(R.layout.edit_user_info_dialog_content, null);
        EditText r3 = (EditText) r2.findViewById(R.id.user_name);
        r3.setText(r12);
        ImageView r0 = (ImageView) r2.findViewById(R.id.user_photo);
        if (r11 == null) goto L5;
        Drawable r4 = r11;
    L6:
        r0.setImageDrawable(getUserIcon(r9, r4));
        if (isChangePhotoRestrictedByBase(r9) == false) goto L9;
        r2.findViewById(R.id.add_a_photo_icon).setVisibility(8);
    L13:
        Dialog r1 = buildDialog(r9, r2, r3, r11, r12, r13, r14);
        this.mEditUserInfoDialog = r1;
        r1.getWindow().setSoftInputMode(4);
        return this.mEditUserInfoDialog;
    L9:
        final RestrictedLockUtils.EnforcedAdmin r5 = getChangePhotoAdminRestriction(r9);
        if (r5 == null) goto L12;
        r0.setOnClickListener(new EditUserInfoController$$ExternalSyntheticLambda3(r9, r5));
        goto L13
    L12:
        this.mEditUserPhotoController = createEditUserPhotoController(r9, r10, r0);
        goto L13
    L5:
        r4 = UserIcons.getDefaultUserIcon(r9.getResources(), -10000, false);
        goto L6
    }

    static /* synthetic */ void lambda$createDialog$0(Activity r0, RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(r0, r1);
    }

    private Drawable getUserIcon(Activity r2, Drawable r3) {
        Bitmap r0 = this.mSavedPhoto;
        if (r0 == null) goto L6;
        CircleFramedDrawable r4 = CircleFramedDrawable.getInstance(r2, r0);
        this.mSavedDrawable = r4;
        return r4;
    L6:
        return r3;
    }

    private Dialog buildDialog(Activity r14, View r15, final EditText r16, final Drawable r17, final String r18, final BiConsumer<String, Drawable> r19, final Runnable r20) {
        final CustomDialogHelper r9 = new CustomDialogHelper(r14);
        r9.setTitle(R.string.user_info_settings_title).addCustomView(r15).setPositiveButton(R.string.okay, new EditUserInfoController$$ExternalSyntheticLambda0(this, r17, r16, r18, r19, r9)).setBackButton(R.string.cancel, new EditUserInfoController$$ExternalSyntheticLambda1(this, r20, r9));
        r9.getDialog().setOnCancelListener(new EditUserInfoController$$ExternalSyntheticLambda2(this, r20, r9));
        return r9.getDialog();
    }

    /* JADX INFO: renamed from: lambda$buildDialog$1$com-android-settingslib-users-EditUserInfoController, reason: not valid java name */
    /* synthetic */ void m788x83902b37(Drawable r1, EditText r2, String r3, BiConsumer r4, CustomDialogHelper r5, View r6) {
        EditUserPhotoController r7 = this.mEditUserPhotoController;
        if (r7 == null) goto L5;
        Drawable r8 = r7.getNewUserPhotoDrawable();
    L6:
        if (r8 == null) goto L8;
        r1 = r8;
    L8:
        String r9 = r2.getText().toString().trim();
        if (r9.isEmpty() == true) goto L11;
        r3 = r9;
    L11:
        clear();
        if (r4 == null) goto L14;
        r4.accept(r3, r1);
    L14:
        r5.getDialog().dismiss();
        return;
    L5:
        r8 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$buildDialog$2$com-android-settingslib-users-EditUserInfoController, reason: not valid java name */
    /* synthetic */ void m789x9daba9d6(Runnable r1, CustomDialogHelper r2, View r3) {
        clear();
        if (r1 == null) goto L5;
        r1.run();
    L5:
        r2.getDialog().dismiss();
    }

    /* JADX INFO: renamed from: lambda$buildDialog$3$com-android-settingslib-users-EditUserInfoController, reason: not valid java name */
    /* synthetic */ void m790xb7c72875(Runnable r1, CustomDialogHelper r2, DialogInterface r3) {
        clear();
        if (r1 == null) goto L5;
        r1.run();
    L5:
        r2.getDialog().dismiss();
    }

    boolean isChangePhotoRestrictedByBase(Context r2) {
        return RestrictedLockUtilsInternal.hasBaseUserRestriction(r2, "no_set_user_icon", UserHandle.myUserId());
    }

    RestrictedLockUtils.EnforcedAdmin getChangePhotoAdminRestriction(Context r2) {
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r2, "no_set_user_icon", UserHandle.myUserId());
    }

    EditUserPhotoController createEditUserPhotoController(Activity r10, ActivityStarter r11, ImageView r12) {
        return new EditUserPhotoController(r10, r11, r12, this.mSavedPhoto, this.mSavedDrawable, this.mFileAuthority, false);
    }
}
