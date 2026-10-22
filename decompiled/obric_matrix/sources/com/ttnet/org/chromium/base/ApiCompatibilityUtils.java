package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.provider.MediaStore;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.widget.ImageViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class ApiCompatibilityUtils {

    private static class ApisLmr1 {
        private ApisLmr1() {
        }

        static void setAccessibilityTraversalBefore(View r0, int r1) {
            r0.setAccessibilityTraversalBefore(r1);
        }
    }

    @RequiresApi(23)
    private static class ApisM {
        private ApisM() {
        }

        public static void setStatusBarIconColor(View r1, boolean r2) {
            int r0 = r1.getSystemUiVisibility();
            if (r2 == false) goto L5;
            int r3 = r0 | 8192;
        L6:
            r1.setSystemUiVisibility(r3);
            return;
        L5:
            r3 = r0 & (-8193);
            goto L6
        }
    }

    @RequiresApi(24)
    private static class ApisN {
        private ApisN() {
        }

        static String getLocale(InputMethodSubtype r0) {
            return r0.getLanguageTag();
        }

        @RequiresApi(25)
        static boolean isDemoUser() {
            return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
        }

        static boolean isInMultiWindowMode(Activity r0) {
            return r0.isInMultiWindowMode();
        }

        static String toHtml(Spanned r0, int r1) {
            return Html.toHtml(r0, r1);
        }
    }

    @RequiresApi(26)
    private static class ApisO {
        private ApisO() {
        }

        static Bundle createLaunchDisplayIdActivityOptions(int r1) {
            ActivityOptions r0 = ActivityOptions.makeBasic();
            r0.setLaunchDisplayId(r1);
            return r0.toBundle();
        }

        static void disableSmartSelectionTextClassifier(TextView r1) {
            r1.setTextClassifier(TextClassifier.NO_OP);
        }

        static void initNotificationSettingsIntent(Intent r1, String r2) {
            r1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            r1.putExtra("android.provider.extra.APP_PACKAGE", r2);
        }
    }

    @RequiresApi(28)
    private static class ApisP {
        private ApisP() {
        }

        static Bitmap getBitmapByUri(ContentResolver r0, Uri r1) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(r0, r1));
        }

        static String getProcessName() {
            return Application.getProcessName();
        }
    }

    @RequiresApi(29)
    private static class ApisQ {
        private ApisQ() {
        }

        static List<Integer> getTargetableDisplayIds(@Nullable Activity r9) {
            ArrayList r0 = new ArrayList();
            if (r9 != null) goto L5;
            return r0;
        L5:
            DisplayManager r1 = (DisplayManager) r9.getSystemService("display");
            if (r1 != null) goto L8;
            return r0;
        L8:
            Display[] r2 = r1.getDisplays();
            ActivityManager r3 = (ActivityManager) r9.getSystemService("activity");
            int r4 = r2.length;
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L16;
            Display r6 = r2[r5];
            if (r6.getState() != 2) goto L15;
            if (r3.isActivityStartAllowedOnDisplay(r9, r6.getDisplayId(), new Intent(r9, r9.getClass())) == false) goto L15;
            r0.add(Integer.valueOf(r6.getDisplayId()));
        L15:
            r5 = r5 + 1;
            goto L9
        L16:
            return r0;
        }

        static boolean isRunningInUserTestHarness() {
            return ActivityManager.isRunningInUserTestHarness();
        }
    }

    private ApiCompatibilityUtils() {
    }

    public static int checkPermission(Context r0, String r1, int r2, int r3) {
        return r0.checkPermission(r1, r2, r3);
    L4:
        return -1;
    }

    public static int compareBoolean(boolean r0, boolean r1) {
        if (r0 != r1) goto L4;
        return 0;
    L4:
        if (r0 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int compareLong(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 != r2) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return null;
    L5:
        return ApisO.createLaunchDisplayIdActivityOptions(r2);
    }

    public static void disableSmartSelectionTextClassifier(TextView r2) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        ApisO.disableSmartSelectionTextClassifier(r2);
        return;
    }

    public static Bitmap getBitmapByUri(ContentResolver r2, Uri r3) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return ApisP.getBitmapByUri(r2, r3);
    L7:
        return MediaStore.Images.Media.getBitmap(r2, r3);
    }

    public static byte[] getBytesUtf8(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static int getColor(Resources r0, int r1) {
        return r0.getColor(r1);
    }

    public static Drawable getDrawable(Resources r1, int r2) {
        return getDrawableForDensity(r1, r2, 0);
    }

    public static Drawable getDrawableForDensity(Resources r2, int r3, int r4) {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskReads();
        if (r4 != 0) goto L7;
        Drawable r5 = r2.getDrawable(r3, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return r5;
    L7:
        Drawable r6 = r2.getDrawableForDensity(r3, r4, null);     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return r6;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    public static String getLocale(InputMethodSubtype r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.getLocale(r2);
    L7:
        return r2.getLocale();
    }

    public static Intent getNotificationSettingsIntent() {
        Intent r0 = new Intent();
        String r1 = ContextUtils.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ApisO.initNotificationSettingsIntent(r0, r1);
    L6:
        return r0;
    L5:
        r0.setAction("android.settings.ACTION_APP_NOTIFICATION_SETTINGS");
        r0.putExtra("app_package", r1);
        r0.putExtra("app_uid", ContextUtils.getApplicationContext().getApplicationInfo().uid);
        goto L6
    }

    static String getProcessName() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return (String) Class.forName("android.app.ActivityThread").getMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        return ApisP.getProcessName();
    }

    @NonNull
    public static List<Integer> getTargetableDisplayIds(Activity r2) {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return ApisQ.getTargetableDisplayIds(r2);
    L7:
        return new ArrayList();
    }

    public static boolean isDemoUser() {
        if (Build.VERSION.SDK_INT >= 25) goto L5;
    L7:
        return false;
    L5:
        if (ApisN.isDemoUser() == false) goto L7;
        return true;
    }

    public static boolean isInMultiWindowMode(Activity r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return ApisN.isInMultiWindowMode(r2);
    }

    private static boolean isPasswordInputType(int r1) {
        int r2 = r1 & 4095;
        if (r2 != 129) goto L5;
    L10:
        return true;
    L5:
        if (r2 == 225) goto L10;
        if (r2 == 18) goto L10;
        return false;
    }

    public static boolean isRunningInUserTestHarness() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        return false;
    L5:
        return ApisQ.isRunningInUserTestHarness();
    }

    @NonNull
    public static <T> T requireNonNull(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    @NonNull
    public static <T> T requireNonNull(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }

    public static void setAccessibilityTraversalBefore(View r2, int r3) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        ApisLmr1.setAccessibilityTraversalBefore(r2, r3);
        return;
    }

    public static void setImageTintList(ImageView r3, @Nullable ColorStateList r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 21) goto L8;
        if (r4 == null) goto L8;
        if (r3.getImageTintMode() != null) goto L8;
        r3.setImageTintMode(PorterDuff.Mode.SRC_IN);
    L8:
        ImageViewCompat.setImageTintList(r3, r4);
        if (r0 != 21) goto L13;
        if (r4 != null) goto L14;
        r3.refreshDrawableState();
        return;
    L14:
        return;
    }

    public static void setPasswordEditTextContentDescription(EditText r2) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        return;
    L6:
        if (isPasswordInputType(r2.getInputType()) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r2.getHint()) == true) goto L12;
        r2.setContentDescription(r2.getHint());
        return;
    }

    public static void setStatusBarColor(Window r3, int r4) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
    L9:
        r3.addFlags(Integer.MIN_VALUE);
    L10:
        r3.setStatusBarColor(r4);
        return;
    L5:
        if (r4 != (-16777216)) goto L9;
        if (r3.getNavigationBarColor() != (-16777216)) goto L9;
        r3.clearFlags(Integer.MIN_VALUE);
        goto L10
    }

    public static void setStatusBarIconColor(View r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        ApisM.setStatusBarIconColor(r2, r3);
        return;
    }

    public static void setTextAppearance(TextView r1, int r2) {
        r1.setTextAppearance(r1.getContext(), r2);
    }

    public static String toHtml(Spanned r2, int r3) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return ApisN.toHtml(r2, r3);
    L7:
        return Html.toHtml(r2);
    }
}
