package com.android.settingslib.users;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.multiuser.Flags;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.GlobalProxyLancet;
import com.android.internal.util.UserIcons;
import com.android.settingslib.drawable.CircleFramedDrawable;
import com.android.settingslib.utils.ThreadUtils;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class EditUserPhotoController {
    private static final String AVATAR_PICKER_ACTION = "com.android.avatarpicker.FULL_SCREEN_ACTIVITY";
    private static final String EXTRA_DEFAULT_ICON_TINT_COLOR = "default_icon_tint_color";
    private static final String EXTRA_FILE_AUTHORITY = "file_authority";
    static final String EXTRA_IS_USER_NEW = "is_user_new";
    private static final String IMAGES_DIR = "multi_user";
    private static final String NEW_USER_PHOTO_FILE_NAME = "NewUserPhoto.png";
    private static final int REQUEST_CODE_PICK_AVATAR = 1004;
    private static final String TAG = "EditUserPhotoController";
    private final Activity mActivity;
    private final ActivityStarter mActivityStarter;
    private String mCachedDrawablePath;
    private final ListeningExecutorService mExecutorService;
    private final String mFileAuthority;
    private final ImageView mImageView;
    private final File mImagesDir;
    private Bitmap mNewUserPhotoBitmap;
    private Drawable mNewUserPhotoDrawable;

    static /* synthetic */ void access$000(EditUserPhotoController r0, Bitmap r1) {
        r0.onPhotoProcessed(r1);
    }

    public EditUserPhotoController(Activity r9, ActivityStarter r10, ImageView r11, Bitmap r12, Drawable r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, true);
    }

    public EditUserPhotoController(Activity r1, ActivityStarter r2, ImageView r3, Bitmap r4, Drawable r5, String r6, final boolean r7) {
        this.mActivity = r1;
        this.mActivityStarter = r2;
        this.mFileAuthority = r6;
        File r8 = new File(r1.getCacheDir(), IMAGES_DIR);
        this.mImagesDir = r8;
        r8.mkdir();
        this.mImageView = r3;
        r3.setOnClickListener(new EditUserPhotoController$$ExternalSyntheticLambda1(this, r7));
        this.mNewUserPhotoBitmap = r4;
        this.mNewUserPhotoDrawable = r5;
        this.mExecutorService = ThreadUtils.getBackgroundExecutor();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settingslib-users-EditUserPhotoController, reason: not valid java name */
    /* synthetic */ void m791x883584ca(boolean r1, View r2) {
        showAvatarPicker(r1);
    }

    public boolean onActivityResult(int r4, int r5, Intent r6) {
        if (r5 == (-1)) goto L6;
        return false;
    L6:
        if (r4 == 1004) goto L8;
    L15:
        return false;
    L8:
        if (r6.hasExtra(EXTRA_DEFAULT_ICON_TINT_COLOR) == false) goto L12;
        onDefaultIconSelected(r6.getIntExtra(EXTRA_DEFAULT_ICON_TINT_COLOR, -1));
        return true;
    L12:
        if (r6.getData() == null) goto L15;
        onPhotoCropped(r6.getData());
        return true;
    }

    public Drawable getNewUserPhotoDrawable() {
        return this.mNewUserPhotoDrawable;
    }

    private void showAvatarPicker(boolean r3) {
        Intent r0 = new Intent(AVATAR_PICKER_ACTION);
        r0.addCategory("android.intent.category.DEFAULT");
        if (Flags.avatarSync() == false) goto L5;
        r0.putExtra(EXTRA_IS_USER_NEW, r3);
    L6:
        r0.putExtra(EXTRA_FILE_AUTHORITY, this.mFileAuthority);
        this.mActivityStarter.startActivityForResult(r0, 1004);
        return;
    L5:
        r0.setPackage(this.mImageView.getContext().getApplicationContext().getPackageName());
        goto L6
    }

    private void onDefaultIconSelected(final int r3) {
        Futures.addCallback(this.mExecutorService.submit(new EditUserPhotoController$$ExternalSyntheticLambda2(this, r3)), new AnonymousClass1(this), this.mImageView.getContext().getMainExecutor());
    }

    /* JADX INFO: renamed from: lambda$onDefaultIconSelected$1$com-android-settingslib-users-EditUserPhotoController, reason: not valid java name */
    /* synthetic */ Bitmap m792x73336661(int r1) throws Exception {
        Resources r0 = this.mActivity.getResources();
        return UserIcons.convertToBitmapAtUserIconSize(r0, UserIcons.getDefaultUserIconInColor(r0, r1));
    }

    private void onPhotoCropped(final Uri r3) {
        Futures.addCallback(this.mExecutorService.submit(new EditUserPhotoController$$ExternalSyntheticLambda0(this, r3)), new AnonymousClass2(this), this.mImageView.getContext().getMainExecutor());
    }

    /* JADX INFO: renamed from: lambda$onPhotoCropped$2$com-android-settingslib-users-EditUserPhotoController, reason: not valid java name */
    /* synthetic */ Bitmap m793xe221b1f2(Uri r5) throws Exception {
        Bitmap r2 = null;
        r2 = null;
        r2 = null;
        InputStream r3 = null;
        InputStream r4 = this.mActivity.getContentResolver().openInputStream(r5);     // Catch: Throwable -> L12 FileNotFoundException -> L14
        r2 = BitmapFactory.decodeStream(r4);     // Catch: FileNotFoundException -> L10 Throwable -> L20
        if (r4 == null) goto L19;
        r4.close();     // Catch: IOException -> L8
    L28:
    L19:
        return r2;
    L10:
        e = e;
    L16:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Cannot find image file", e);     // Catch: Throwable -> L20
        if (r4 == null) goto L19;
        r4.close();     // Catch: IOException -> L8
    L20:
        th = th;
        r3 = r4;
    L22:
        if (r3 != null) goto L31;
    L27:
        throw th;
    L31:
        r3.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Cannot close image stream", e);
        goto L27
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Cannot close image stream", e);
    L14:
        e = e;
        r4 = null;
    L12:
        th = th;
        goto L22
    }

    private void onPhotoProcessed(Bitmap r2) {
        if (r2 == null) goto L5;
        this.mNewUserPhotoBitmap = r2;
        this.mExecutorService.submit(new EditUserPhotoController$$ExternalSyntheticLambda3(this));
        CircleFramedDrawable r3 = CircleFramedDrawable.getInstance(this.mImageView.getContext(), this.mNewUserPhotoBitmap);
        this.mNewUserPhotoDrawable = r3;
        this.mImageView.setImageDrawable(r3);
        return;
    }

    /* JADX INFO: renamed from: lambda$onPhotoProcessed$3$com-android-settingslib-users-EditUserPhotoController, reason: not valid java name */
    /* synthetic */ void m794x5163ba82() {
        this.mCachedDrawablePath = saveNewUserPhotoBitmap().getPath();
    }

    File saveNewUserPhotoBitmap() {
        if (this.mNewUserPhotoBitmap != null) goto L10;
        return null;
    L10:
        File r0 = new File(this.mImagesDir, NEW_USER_PHOTO_FILE_NAME);     // Catch: IOException -> L7
        FileOutputStream r2 = new FileOutputStream(r0);     // Catch: IOException -> L7
        this.mNewUserPhotoBitmap.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: IOException -> L7
        r2.flush();     // Catch: IOException -> L7
        r2.close();     // Catch: IOException -> L7
        return r0;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Cannot create temp file", e);
        return null;
    }

    static Bitmap loadNewUserPhotoBitmap(File r0) {
        return BitmapFactory.decodeFile(r0.getAbsolutePath());
    }

    void removeNewUserPhotoBitmapFile() {
        new File(this.mImagesDir, NEW_USER_PHOTO_FILE_NAME).delete();
    }

    String getCachedDrawablePath() {
        return this.mCachedDrawablePath;
    }
}
