package com.android.settings.users;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.R;
import com.android.settingslib.drawable.CircleFramedDrawable;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class EditUserInfoController {
    private static final String KEY_AWAITING_RESULT = "awaiting_result";
    private static final String KEY_SAVED_PHOTO = "pending_photo";
    private Dialog mEditUserInfoDialog;
    private EditUserPhotoController mEditUserPhotoController;
    private Bitmap mSavedPhoto;
    private UserHandle mUser;
    private UserManager mUserManager;
    private boolean mWaitingForActivityResult;

    public interface OnContentChangedCallback {
        void onLabelChanged(CharSequence r1);

        void onPhotoChanged(Drawable r1);
    }

    public EditUserInfoController() {
        this.mWaitingForActivityResult = false;
    }

    static /* synthetic */ UserHandle access$000(EditUserInfoController r0) {
        return r0.mUser;
    }

    static /* synthetic */ UserManager access$100(EditUserInfoController r0) {
        return r0.mUserManager;
    }

    static /* synthetic */ EditUserPhotoController access$200(EditUserInfoController r0) {
        return r0.mEditUserPhotoController;
    }

    public void clear() {
        this.mEditUserPhotoController.removeNewUserPhotoBitmapFile();
        this.mEditUserInfoDialog = null;
        this.mSavedPhoto = null;
    }

    public Dialog getDialog() {
        return this.mEditUserInfoDialog;
    }

    public void onRestoreInstanceState(Bundle r3) {
        String r0 = r3.getString(KEY_SAVED_PHOTO);
        if (r0 == null) goto L5;
        this.mSavedPhoto = EditUserPhotoController.loadNewUserPhotoBitmap(new File(r0));
    L5:
        this.mWaitingForActivityResult = r3.getBoolean(KEY_AWAITING_RESULT, false);
    }

    public void onSaveInstanceState(Bundle r3) {
        Dialog r0 = this.mEditUserInfoDialog;
        if (r0 != null) goto L5;
    L11:
        boolean r2 = this.mWaitingForActivityResult;
        if (r2 == false) goto L15;
        r3.putBoolean(KEY_AWAITING_RESULT, r2);
        return;
    L15:
        return;
    L5:
        if (r0.isShowing() == false) goto L11;
        EditUserPhotoController r1 = this.mEditUserPhotoController;
        if (r1 == null) goto L11;
        File r4 = r1.saveNewUserPhotoBitmap();
        if (r4 == null) goto L11;
        r3.putString(KEY_SAVED_PHOTO, r4.getPath());
        goto L11
    }

    public void startingActivityForResult() {
        this.mWaitingForActivityResult = true;
    }

    public void onActivityResult(int r2, int r3, Intent r4) {
        this.mWaitingForActivityResult = false;
        Dialog r0 = this.mEditUserInfoDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mEditUserPhotoController.onActivityResult(r2, r3, r4);
        return;
    }

    public Dialog createDialog(final Fragment r15, final Drawable r16, final CharSequence r17, int r18, final OnContentChangedCallback r19, UserHandle r20) {
        FragmentActivity r0 = r15.getActivity();
        this.mUser = r20;
        if (this.mUserManager != null) goto L5;
        this.mUserManager = UserManager.get(r0);
    L5:
        View r1 = r0.getLayoutInflater().inflate(R.layout.edit_user_info_dialog_content, null);
        UserInfo r2 = this.mUserManager.getUserInfo(this.mUser.getIdentifier());
        final EditText r3 = (EditText) r1.findViewById(R.id.user_name);
        r3.setText(r2.name);
        ImageView r10 = (ImageView) r1.findViewById(R.id.user_photo);
        Bitmap r4 = this.mSavedPhoto;
        if (r4 == null) goto L8;
        Drawable r12 = CircleFramedDrawable.getInstance(r0, r4);
    L9:
        r10.setImageDrawable(r12);
        this.mEditUserPhotoController = new EditUserPhotoController(r15, r10, this.mSavedPhoto, r12, this.mWaitingForActivityResult);
        AlertDialog r5 = new AlertDialog.Builder(r0).setTitle(R.string.profile_info_settings_title).setView(r1).setCancelable(true).setPositiveButton(android.R.string.ok, new AnonymousClass2(this, r3, r17, r19, r16, r15)).setNegativeButton(android.R.string.cancel, new AnonymousClass1(this)).create();
        this.mEditUserInfoDialog = r5;
        r5.getWindow().setSoftInputMode(4);
        return this.mEditUserInfoDialog;
    L8:
        r12 = r16;
        goto L9
    }
}
