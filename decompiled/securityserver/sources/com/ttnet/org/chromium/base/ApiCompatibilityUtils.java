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
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.UserManager;
import android.text.Html;
import android.text.Spanned;
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

/* JADX INFO: loaded from: classes2.dex */
public class ApiCompatibilityUtils {

    public static class ApisLmr1 {
        private ApisLmr1() {
        }

        public static void setAccessibilityTraversalBefore(View r0, int r1) {
            r0.setAccessibilityTraversalBefore(r1);
        }
    }

    @RequiresApi(23)
    public static class ApisM {
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
    public static class ApisN {
        private ApisN() {
        }

        public static String getLocale(InputMethodSubtype r0) {
            return r0.getLanguageTag();
        }

        @RequiresApi(25)
        public static boolean isDemoUser() {
            return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
        }

        public static boolean isInMultiWindowMode(Activity r0) {
            return r0.isInMultiWindowMode();
        }

        public static String toHtml(Spanned r0, int r1) {
            return Html.toHtml(r0, r1);
        }
    }

    @RequiresApi(26)
    public static class ApisO {
        private ApisO() {
        }

        public static Bundle createLaunchDisplayIdActivityOptions(int r1) {
            ActivityOptions r0 = ActivityOptions.makeBasic();
            r0.setLaunchDisplayId(r1);
            return r0.toBundle();
        }

        public static void disableSmartSelectionTextClassifier(TextView r1) {
            r1.setTextClassifier(TextClassifier.NO_OP);
        }

        public static void initNotificationSettingsIntent(Intent r1, String r2) {
            r1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            r1.putExtra("android.provider.extra.APP_PACKAGE", r2);
        }
    }

    @RequiresApi(28)
    public static class ApisP {
        private ApisP() {
        }

        public static Bitmap getBitmapByUri(ContentResolver r0, Uri r1) {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(r0, r1));
        }

        public static String getProcessName() {
            return Application.getProcessName();
        }
    }

    @RequiresApi(29)
    public static class ApisQ {
        private ApisQ() {
        }

        public static List<Integer> getTargetableDisplayIds(@Nullable Activity r9) {
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

        public static boolean isRunningInUserTestHarness() {
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

    public static Bundle createLaunchDisplayIdActivityOptions(int r0) {
        return ApisO.createLaunchDisplayIdActivityOptions(r0);
    }

    public static void disableSmartSelectionTextClassifier(TextView r0) {
        ApisO.disableSmartSelectionTextClassifier(r0);
    }

    public static Bitmap getBitmapByUri(ContentResolver r0, Uri r1) {
        return ApisP.getBitmapByUri(r0, r1);
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
        if (r4 != 0) goto L9;
        Drawable r5 = r2.getDrawable(r3, null);     // Catch: Throwable -> L7
        StrictMode.setThreadPolicy(r0);
        return r5;
    L9:
        Drawable r6 = r2.getDrawableForDensity(r3, r4, null);     // Catch: Throwable -> L7
        StrictMode.setThreadPolicy(r0);
        return r6;
    L7:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    public static String getLocale(InputMethodSubtype r0) {
        return ApisN.getLocale(r0);
    }

    public static Intent getNotificationSettingsIntent() {
        Intent r0 = new Intent();
        ApisO.initNotificationSettingsIntent(r0, ContextUtils.getApplicationContext().getPackageName());
        return r0;
    }

    public static String getProcessName() {
        return ApisP.getProcessName();
    }

    @NonNull
    public static List<Integer> getTargetableDisplayIds(Activity r0) {
        return ApisQ.getTargetableDisplayIds(r0);
    }

    public static boolean isDemoUser() {
        return ApisN.isDemoUser();
    }

    public static boolean isInMultiWindowMode(Activity r0) {
        return ApisN.isInMultiWindowMode(r0);
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
        return ApisQ.isRunningInUserTestHarness();
    }

    @NonNull
    public static <T> T requireNonNull(T r0) {
        r0.getClass();
        return r0;
    }

    public static void setAccessibilityTraversalBefore(View r0, int r1) {
        ApisLmr1.setAccessibilityTraversalBefore(r0, r1);
    }

    public static void setImageTintList(ImageView r0, @Nullable ColorStateList r1) {
        ImageViewCompat.setImageTintList(r0, r1);
    }

    public static void setPasswordEditTextContentDescription(EditText r0) {
    }

    public static void setStatusBarColor(Window r1, int r2) {
        r1.addFlags(Integer.MIN_VALUE);
        r1.setStatusBarColor(r2);
    }

    public static void setStatusBarIconColor(View r0, boolean r1) {
        ApisM.setStatusBarIconColor(r0, r1);
    }

    public static void setTextAppearance(TextView r1, int r2) {
        r1.setTextAppearance(r1.getContext(), r2);
    }

    public static String toHtml(Spanned r0, int r1) {
        return ApisN.toHtml(r0, r1);
    }

    @NonNull
    public static <T> T requireNonNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }
}
