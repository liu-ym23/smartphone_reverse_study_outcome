package com.android.settings.users;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.os.UserHandle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EditUserPhotoController {
    private static final String CROP_PICTURE_FILE_NAME = "CropEditUserPhoto.jpg";
    private static final String NEW_USER_PHOTO_FILE_NAME = "NewUserPhoto.png";
    private static final int REQUEST_CODE_CHOOSE_PHOTO = 1001;
    private static final int REQUEST_CODE_CROP_PHOTO = 1003;
    private static final int REQUEST_CODE_TAKE_PHOTO = 1002;
    private static final String TAG = "EditUserPhotoController";
    private static final String TAKE_PICTURE_FILE_NAME = "TakeEditUserPhoto2.jpg";
    private final Context mContext;
    private final Uri mCropPictureUri;
    private final Fragment mFragment;
    private final ImageView mImageView;
    private Bitmap mNewUserPhotoBitmap;
    private Drawable mNewUserPhotoDrawable;
    private final int mPhotoSize;
    private final Uri mTakePictureUri;

    private static final class RestrictedMenuItem {
        private final Runnable mAction;
        private final RestrictedLockUtils.EnforcedAdmin mAdmin;
        private final Context mContext;
        private final boolean mIsRestrictedByBase;
        private final String mTitle;

        public RestrictedMenuItem(Context r1, String r2, String r3, Runnable r4) {
            this.mContext = r1;
            this.mTitle = r2;
            this.mAction = r4;
            int r5 = UserHandle.myUserId();
            this.mAdmin = MultiSDKAdapterNew.checkIfRestrictionEnforced(r1, r3, r5);
            this.mIsRestrictedByBase = MultiSDKAdapterNew.hasBaseUserRestriction(r1, r3, r5);
        }

        public String toString() {
            return this.mTitle;
        }

        final void doAction() {
            if (isRestrictedByBase() == false) goto L6;
            return;
        L6:
            if (isRestrictedByAdmin() == false) goto L9;
            RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, this.mAdmin);
            return;
        L9:
            this.mAction.run();
        }

        final boolean isRestrictedByAdmin() {
            if (this.mAdmin == null) goto L5;
            return true;
        L5:
            return false;
        }

        final boolean isRestrictedByBase() {
            return this.mIsRestrictedByBase;
        }
    }

    private static final class RestrictedPopupMenuAdapter extends ArrayAdapter<RestrictedMenuItem> {
        public RestrictedPopupMenuAdapter(Context r3, List<RestrictedMenuItem> r4) {
            super(r3, R.layout.restricted_popup_menu_item, R.id.text, r4);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            View r6 = super.getView(r3, r4, r5);
            RestrictedMenuItem r2 = getItem(r3);
            TextView r7 = (TextView) r6.findViewById(R.id.text);
            ImageView r8 = (ImageView) r6.findViewById(R.id.restricted_icon);
            int r1 = 0;
            if (r2.isRestrictedByAdmin() == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            r7.setEnabled(r0);
            if (r2.isRestrictedByAdmin() == true) goto L11;
        L13:
            r1 = 8;
        L14:
            r8.setVisibility(r1);
            return r6;
        L11:
            if (r2.isRestrictedByBase() == true) goto L13;
        L5:
            if (r2.isRestrictedByBase() == true) goto L7;
            r0 = true;
            goto L8
        }
    }

    static /* synthetic */ void access$000(EditUserPhotoController r0) {
        r0.showUpdatePhotoPopup();
    }

    static /* synthetic */ void access$100(EditUserPhotoController r0) {
        r0.takePhoto();
    }

    static /* synthetic */ void access$200(EditUserPhotoController r0) {
        r0.choosePhoto();
    }

    static /* synthetic */ Context access$300(EditUserPhotoController r0) {
        return r0.mContext;
    }

    static /* synthetic */ int access$400(EditUserPhotoController r0) {
        return r0.mPhotoSize;
    }

    static /* synthetic */ Bitmap access$500(EditUserPhotoController r0) {
        return r0.mNewUserPhotoBitmap;
    }

    static /* synthetic */ Bitmap access$502(EditUserPhotoController r0, Bitmap r1) {
        r0.mNewUserPhotoBitmap = r1;
        return r1;
    }

    static /* synthetic */ Drawable access$600(EditUserPhotoController r0) {
        return r0.mNewUserPhotoDrawable;
    }

    static /* synthetic */ Drawable access$602(EditUserPhotoController r0, Drawable r1) {
        r0.mNewUserPhotoDrawable = r1;
        return r1;
    }

    static /* synthetic */ ImageView access$700(EditUserPhotoController r0) {
        return r0.mImageView;
    }

    public EditUserPhotoController(Fragment r3, ImageView r4, Bitmap r5, Drawable r6, boolean r7) {
        Context r0 = r4.getContext();
        this.mContext = r0;
        this.mFragment = r3;
        this.mImageView = r4;
        this.mCropPictureUri = createTempImageUri(r0, CROP_PICTURE_FILE_NAME, !r7);
        this.mTakePictureUri = createTempImageUri(r0, TAKE_PICTURE_FILE_NAME, !r7);
        this.mPhotoSize = getPhotoSize(r0);
        r4.setOnClickListener(new AnonymousClass1(this));
        this.mNewUserPhotoBitmap = r5;
        this.mNewUserPhotoDrawable = r6;
    }

    public boolean onActivityResult(int r3, int r4, Intent r5) {
        if (r4 == (-1)) goto L5;
        return false;
    L5:
        if (r5 != null) goto L7;
    L9:
        Uri r6 = this.mTakePictureUri;
    L11:
        if ("content".equals(r6.getScheme()) == true) goto L15;
        OLog.e(TAG, "Invalid pictureUri scheme: " + r6.getScheme());
        return false;
    L15:
        switch(r3) {
            case 1001: goto L19;
            case 1002: goto L19;
            case 1003: goto L17;
            default: goto L16;
        };
    L16:
        return false;
    L17:
        onPhotoCropped(r6, true);
        return true;
    L19:
        cropPhoto(r6);
        return true;
    L7:
        if (r5.getData() == null) goto L9;
        r6 = r5.getData();
        goto L11
    }

    public Bitmap getNewUserPhotoBitmap() {
        return this.mNewUserPhotoBitmap;
    }

    public Drawable getNewUserPhotoDrawable() {
        return this.mNewUserPhotoDrawable;
    }

    private void showUpdatePhotoPopup() {
        boolean r0 = canTakePhoto();
        boolean r1 = canChoosePhoto();
        if (r0 == true) goto L6;
        if (r1 == true) goto L6;
        return;
    L6:
        Context r2 = this.mImageView.getContext();
        ArrayList r3 = new ArrayList();
        if (r0 == false) goto L9;
        r3.add(new RestrictedMenuItem(r2, r2.getString(R.string.user_image_take_photo), "no_set_user_icon", new AnonymousClass2(this)));
    L9:
        if (r1 == false) goto L11;
        r3.add(new RestrictedMenuItem(r2, r2.getString(R.string.user_image_choose_photo), "no_set_user_icon", new AnonymousClass3(this)));
    L11:
        final ListPopupWindow r4 = new ListPopupWindow(r2);
        r4.setAnchorView(this.mImageView);
        r4.setModal(true);
        r4.setInputMethodMode(2);
        r4.setAdapter(new RestrictedPopupMenuAdapter(r2, r3));
        r4.setWidth(Math.max(this.mImageView.getWidth(), r2.getResources().getDimensionPixelSize(R.dimen.update_user_photo_popup_min_width)));
        r4.setDropDownGravity(GravityCompat.START);
        r4.setOnItemClickListener(new AnonymousClass4(this, r4));
        r4.show();
    }

    private boolean canTakePhoto() {
        if (this.mImageView.getContext().getPackageManager().queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), 65536).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canChoosePhoto() {
        Intent r0 = new Intent("android.intent.action.GET_CONTENT");
        r0.setType("image/*");
        if (this.mImageView.getContext().getPackageManager().queryIntentActivities(r0, 0).size() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void takePhoto() {
        Intent r0 = new Intent("android.media.action.IMAGE_CAPTURE");
        appendOutputExtra(r0, this.mTakePictureUri);
        this.mFragment.startActivityForResult(r0, 1002);
    }

    private void choosePhoto() {
        Intent r0 = new Intent("android.intent.action.GET_CONTENT", null);
        r0.setType("image/*");
        appendOutputExtra(r0, this.mTakePictureUri);
        this.mFragment.startActivityForResult(r0, 1001);
    }

    private void cropPhoto(Uri r3) {
        Intent r0 = new Intent("com.android.camera.action.CROP");
        r0.setDataAndType(r3, "image/*");
        appendOutputExtra(r0, this.mCropPictureUri);
        appendCropExtras(r0);
        if (r0.resolveActivity(this.mContext.getPackageManager()) != null) goto L11;
        onPhotoCropped(r3, false);
        return;
    L11:
        StrictMode.disableDeathOnFileUriExposure();     // Catch: Throwable -> L6
        this.mFragment.startActivityForResult(r0, 1003);     // Catch: Throwable -> L6
        StrictMode.enableDeathOnFileUriExposure();
        return;
    L6:
        th = move-exception;
        StrictMode.enableDeathOnFileUriExposure();
        throw th;
    }

    private void appendOutputExtra(Intent r2, Uri r3) {
        r2.putExtra("output", r3);
        r2.addFlags(3);
        r2.setClipData(ClipData.newRawUri("output", r3));
    }

    private void appendCropExtras(Intent r3) {
        r3.putExtra("crop", "true");
        r3.putExtra("scale", true);
        r3.putExtra("scaleUpIfNeeded", true);
        r3.putExtra("aspectX", 1);
        r3.putExtra("aspectY", 1);
        r3.putExtra("outputX", this.mPhotoSize);
        r3.putExtra("outputY", this.mPhotoSize);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.users.EditUserPhotoController$5] */
    private void onPhotoCropped(final Uri r2, final boolean r3) {
        Void[] r4 = (Void[]) null;
        new AnonymousClass5(this, r3, r2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    private static int getPhotoSize(Context r7) {
        Cursor r0 = null;
        r0 = r7.getContentResolver().query(ContactsContract.DisplayPhoto.CONTENT_MAX_DIMENSIONS_URI, new String[]{"display_max_dim"}, null, null, null);     // Catch: Throwable -> L12
        if (r0 == null) goto L9;
        r0.moveToFirst();     // Catch: Throwable -> L12
        int r8 = r0.getInt(0);     // Catch: Throwable -> L12
        if (r0 == null) goto L8;
        r0.close();
    L8:
        return r8;
    L9:
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return 0;
    L12:
        th = move-exception;
        if (r0 == null) goto L15;
        r0.close();
    L15:
        throw th;
    }

    private Uri createTempImageUri(Context r2, String r3, boolean r4) {
        File r1 = r2.getCacheDir();
        r1.mkdirs();
        File r0 = new File(r1, r3);
        if (r4 == false) goto L6;
        r0.delete();
    L6:
        return FileProvider.getUriForFile(r2, "com.android.settings.files", r0);
    }

    File saveNewUserPhotoBitmap() {
        if (this.mNewUserPhotoBitmap != null) goto L10;
        return null;
    L10:
        File r0 = new File(this.mContext.getCacheDir(), NEW_USER_PHOTO_FILE_NAME);     // Catch: IOException -> L7
        FileOutputStream r2 = new FileOutputStream(r0);     // Catch: IOException -> L7
        this.mNewUserPhotoBitmap.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: IOException -> L7
        r2.flush();     // Catch: IOException -> L7
        r2.close();     // Catch: IOException -> L7
        return r0;
    L7:
        e = move-exception;
        OLog.e(TAG, "Cannot create temp file", e);
        return null;
    }

    static Bitmap loadNewUserPhotoBitmap(File r0) {
        return BitmapFactory.decodeFile(r0.getAbsolutePath());
    }

    void removeNewUserPhotoBitmapFile() {
        new File(this.mContext.getCacheDir(), NEW_USER_PHOTO_FILE_NAME).delete();
    }
}
