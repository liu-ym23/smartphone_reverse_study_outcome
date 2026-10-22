package com.qihoo360.mobilesafe.common.ui.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.qihoo360.mobilesafe.ui.common.other.ImmerseView;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import obric.view.WindowManagerHelper;

/* JADX INFO: loaded from: classes4.dex */
public class CommonUtils {
    private static final boolean DEBUG = false;
    private static final float NUMBER_SIZE_G = 1.0737418E9f;
    private static final float NUMBER_SIZE_K = 1024.0f;
    private static final float NUMBER_SIZE_M = 1048576.0f;
    private static final String TAG = "CommonUtils";
    private static final AtomicInteger sNextGeneratedId = null;
    private static Class<?> sRidClazz = null;
    private static int screenHeight = -1;
    private static int screenWidth = -1;
    private static int statusBarHeight = -1;

    public static int getLayoutParamsType() {
        return WindowManagerHelper.LayoutParamsSmt.TYPE_APPLICATION_OVERLAY;
    }

    public CommonUtils() {
    }

    public static final String[] getFormatSizeSource(long r10) {
        String[] r1 = new String[2];
        NumberFormat r2 = NumberFormat.getInstance();
        r2.setMaximumFractionDigits(0);
        r2.setMinimumFractionDigits(0);
        float r4 = r10;
        if (r4 < 1.048576E9f) goto L15;
        r1[1] = "GB";
        if (r4 <= 1.0726681E12f) goto L8;
        r1[0] = "999";
    L42:
        return r1;
    L8:
        if (r4 < 1.0737418E11f) goto L11;
        r2.setMaximumFractionDigits(0);
        r2.setMinimumFractionDigits(0);
        r1[0] = r2.format(r4 / NUMBER_SIZE_G);
        goto L42
    L11:
        if (r4 < 1.0737418E10f) goto L13;
        r2.setMaximumFractionDigits(1);
        r2.setMinimumFractionDigits(1);
        r1[0] = r2.format(r4 / NUMBER_SIZE_G);
        goto L42
    L13:
        r2.setMaximumFractionDigits(2);
        r2.setMinimumFractionDigits(2);
        r1[0] = r2.format(r4 / NUMBER_SIZE_G);
        goto L42
    L15:
        if (r4 < 1024000.0f) goto L27;
        r1[1] = "MB";
        if (r4 < 1.0475274E9f) goto L20;
        r1[0] = "999";
        goto L42
    L20:
        if (r4 < 1.048576E8f) goto L23;
        r2.setMaximumFractionDigits(0);
        r2.setMinimumFractionDigits(0);
        r1[0] = r2.format(r4 / NUMBER_SIZE_M);
        goto L42
    L23:
        if (r4 < 1.048576E7f) goto L25;
        r2.setMaximumFractionDigits(1);
        r2.setMinimumFractionDigits(1);
        r1[0] = r2.format(r4 / NUMBER_SIZE_M);
        goto L42
    L25:
        r2.setMaximumFractionDigits(2);
        r2.setMinimumFractionDigits(2);
        r1[0] = r2.format(r4 / NUMBER_SIZE_M);
        goto L42
    L27:
        if (r10 < 1000) goto L39;
        r1[1] = "KB";
        if (r4 < 1022976.0f) goto L32;
        r1[0] = "999";
        goto L42
    L32:
        if (r4 < 102400.0f) goto L35;
        r2.setMaximumFractionDigits(0);
        r2.setMinimumFractionDigits(0);
        r1[0] = r2.format(r4 / NUMBER_SIZE_K);
        goto L42
    L35:
        if (r4 < 10240.0f) goto L37;
        r2.setMaximumFractionDigits(1);
        r2.setMinimumFractionDigits(1);
        r1[0] = r2.format(r4 / NUMBER_SIZE_K);
        goto L42
    L37:
        r2.setMaximumFractionDigits(2);
        r2.setMinimumFractionDigits(2);
        r1[0] = r2.format(r4 / NUMBER_SIZE_K);
        goto L42
    L39:
        if (r10 >= 0) goto L41;
        r10 = 0;
    L41:
        r1[1] = "B";
        r1[0] = String.valueOf(r10);
        goto L42
    }

    public static final String getFormatSize(long r1) {
        String[] r2 = getFormatSizeSource(r1);
        return r2[0] + r2[1];
    }

    public static final String getAppName(String r1, PackageManager r2) {
        ApplicationInfo r0 = r2.getApplicationInfo(r1, 128);     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r1 = r0.loadLabel(r2).toString();     // Catch: Throwable -> L9
    L6:
        if (r1 != null) goto L12;
        return "";
    L12:
        return r1;
    }

    public static Drawable getApplicationIcon(String r0, PackageManager r1) {
        return r1.getApplicationIcon(r0);
    L6:
        System.gc();
        return r1.getDefaultActivityIcon();
    L9:
        return r1.getDefaultActivityIcon();
    L5:
        return r1.getDefaultActivityIcon();
    }

    public static void enableImmersiveStatusBar(Activity r2) {
        r2.getWindow().setFlags(67108864, 67108864);     // Catch: Exception -> L6
        View r0 = r2.getWindow().getDecorView().findViewWithTag(ImmerseView.IMMERSE_TAG);     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.setPadding(0, getStatusBarHeight(r2), 0, 0);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static ImmerseView getImmersiveView(Activity r1) {
        return (ImmerseView) r1.getWindow().getDecorView().findViewWithTag(ImmerseView.IMMERSE_TAG);
    L4:
        return null;
    }

    public static void setImmersiveColor(Activity r1, int r2) {
        View r3 = r1.getWindow().getDecorView().findViewWithTag(ImmerseView.IMMERSE_TAG);     // Catch: Exception -> L6
        if (r3 == null) goto L9;
        r3.setBackgroundColor(r2);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static int getStatusBarHeight(Context r4) {
        int r0 = statusBarHeight;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        statusBarHeight = 0;
        int r1 = r4.getResources().getIdentifier("status_bar_height", "dimen", "android");     // Catch: Exception -> L14
        if (r1 <= 0) goto L10;
        statusBarHeight = r4.getResources().getDimensionPixelSize(r1);     // Catch: Exception -> L14
    L10:
        if (statusBarHeight != 0) goto L13;
        statusBarHeight = dip2px(r4, 25.0f);
    L13:
        return statusBarHeight;
    }

    public static int getScreenWidth(Context r2) {
        int r0 = screenWidth;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        if (r2 == null) goto L9;
        Display r3 = ((WindowManager) r2.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        Point r1 = new Point();
        r3.getSize(r1);
        int r4 = r1.x;
        screenWidth = r4;
        return r4;
    L9:
        throw new RuntimeException("context can not be null when getScreenWidth(...)");
    }

    public static int getScreenHeight(Context r2) {
        int r0 = screenHeight;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        if (r2 == null) goto L9;
        Display r3 = ((WindowManager) r2.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        Point r1 = new Point();
        r3.getSize(r1);
        int r4 = r1.y;
        screenHeight = r4;
        return r4;
    L9:
        throw new RuntimeException("context can not be null when getScreenHeight(...)");
    }

    public static int getId(String r1) {
    L7:
        th = move-exception;
        th.printStackTrace();
        return 0;
    L3:
        if (sRidClazz != null) goto L5;
        sRidClazz = Class.forName("com.qihoo.cleandroid_cn.R$id");     // Catch: Throwable -> L7
    L5:
        Field r2 = sRidClazz.getField(r1);     // Catch: Throwable -> L7
        r2.setAccessible(true);     // Catch: Throwable -> L7
        return r2.getInt(null);
    }

    public static Drawable getBorderDrawable(int r1, int r2, int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(r2);
        r0.setStroke(1, r1);
        r0.setCornerRadius(r3);
        return r0;
    }

    public static Drawable getBorderDrawable(Context r1, int r2, int r3) {
        return getBorderDrawable(r2, r3, dip2px(r1, 3.0f));
    }

    public static Drawable getRoundRectDrawable(Context r1, int r2) {
        return getRoundRectDrawable(r2, dip2px(r1, 3.0f));
    }

    public static Drawable getRoundRectDrawable(int r1, int r2) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setCornerRadius(r2);
        r0.setColor(r1);
        return r0;
    }

    public static Drawable getBtnDrawable(Drawable r5, Drawable r6, Drawable r7) {
        StateListDrawable r0 = new StateListDrawable();
        r0.addState(new int[]{R.attr.state_pressed}, r6);
        r0.addState(new int[]{-16842910}, r7);
        r0.addState(new int[]{0}, r5);
        return r0;
    }

    public static int getWordCount(String r2) {
        return r2.replaceAll("[^\\x00-\\xff]", "**").length();
    }

    public static boolean isInteger(String r1) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(r1).matches();
    }

    public static int dip2px(Context r0, float r1) {
        return (int) ((r1 * r0.getResources().getDisplayMetrics().density) + 0.5f);
    L5:
        return 0;
    }

    public static int px2dip(Context r0, float r1) {
        return (int) ((r1 / r0.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int sp2px(Context r0, float r1) {
        return (int) ((r1 * r0.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static <T extends View> T $(View r0, int r1) {
        return (T) r0.findViewById(r1);
    }

    public static Typeface getHelveticaNeueLTProFonts(Context r1) {
        return Typeface.createFromAsset(r1.getAssets(), "fonts/HelveticaNeueLTPro-Th-1.otf");
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String getTextFromAttrs(Context r1, AttributeSet r2) {
        return getTextFromAttrs(r1, r2, "text");
    }

    public static String getTextFromAttrs(Context r1, AttributeSet r2, String r3) {
        String r4 = getValueFromAttrs(r1, r2, r3);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r4;
    L5:
        if (r4.startsWith("@") == false) goto L14;
        int r5 = str2Int(r4.substring(1), -1);
        if (r5 == (-1)) goto L15;
        return r1.getString(r5);
    L16:
        return r4;
    L15:
        return r4;
    L14:
        return r4;
    }

    public static int str2Int(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return Integer.parseInt(r1.trim());
    L10:
        return r2;
    L11:
        return r2;
    }

    public static int getColorFromAttrs(Context r0, AttributeSet r1, String r2) {
        String r3 = getValueFromAttrs(r0, r1, r2);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return 0;
    L5:
        if (r3.startsWith("@") == false) goto L15;
        int r4 = str2Int(r3.substring(1), -1);
        if (r4 == (-1)) goto L16;
        return r0.getResources().getColor(r4);
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static int str2Int(String r1, int r2, int r3) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return Integer.parseInt(r1.trim(), r3);
    L10:
        return r2;
    L11:
        return r2;
    }

    public static String getValueFromAttrs(Context r3, AttributeSet r4, String r5) {
        if (r4 == null) goto L12;
        int r6 = r4.getAttributeCount();
        int r0 = 0;
    L4:
        if (r0 >= r6) goto L18;
        String r1 = r4.getAttributeName(r0);
        if (TextUtils.isEmpty(r1) == true) goto L11;
        if (r1.equals(r5) == false) goto L11;
        return r4.getAttributeValue(r0);
    L11:
        r0 = r0 + 1;
        goto L4
    L18:
        return null;
    L12:
        return null;
    }

    public static Drawable getDrawableFromAttrs(Context r0, AttributeSet r1, String r2) {
        String r3 = getValueFromAttrs(r0, r1, r2);
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (r3.startsWith("@") == false) goto L15;
        int r4 = str2Int(r3.substring(1), -1);
        if (r4 == (-1)) goto L16;
        return r0.getResources().getDrawable(r4);
    L17:
        return null;
    L16:
        return null;
    L15:
        return null;
    }

    public static int getTextSizeFromAttrs(Context r1, AttributeSet r2) {
        String r3 = getValueFromAttrs(r1, r2, "textSize");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return 0;
    L5:
        if (r3.startsWith("@") == false) goto L15;
        int r4 = str2Int(r3.substring(1), -1);
        if (r4 == (-1)) goto L16;
        return r1.getResources().getDimensionPixelOffset(r4);
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static void setViewGroupEnabled(ViewGroup r2, boolean r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.getChildCount()) goto L6;
        setViewGroupEnabled(r2.getChildAt(r0), r3);
        r0 = r0 + 1;
        goto L4
    }

    private static void setViewGroupEnabled(View r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof ViewGroup) == false) goto L10;
        ViewGroup r4 = (ViewGroup) r2;
        r4.setEnabled(r3);
        int r0 = 0;
    L8:
        if (r0 >= r4.getChildCount()) goto L13;
        setViewGroupEnabled(r4.getChildAt(r0), r3);
        r0 = r0 + 1;
        goto L8
    L13:
        return;
    L10:
        r2.setEnabled(r3);
    }

    static {
        sNextGeneratedId = new AtomicInteger(1);
    }

    public static int getId() {
        return View.generateViewId();
    }

    private static int generateViewId() {
    L2:
        AtomicInteger r0 = sNextGeneratedId;
        int r1 = r0.get();
        int r2 = r1 + 1;
        if (r2 <= 16777215) goto L6;
        r2 = 1;
    L6:
        if (r0.compareAndSet(r1, r2) == false) goto L2;
        return r1;
    }

    public static boolean isMiuiUpper8() {
        if (isMiuiRom() == true) goto L12;
        return false;
    L12:
        if (Integer.valueOf(getSystemProperty("ro.miui.ui.version.code")).intValue() < 6) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isMeizuRom() {
        String r0 = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return false;
    L6:
        if (r0.contains("flyme") == false) goto L8;
        return true;
    L8:
        if (r0.toLowerCase().contains("flyme") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static boolean isMiuiRom() {
        String r3 = getSystemProperty("ro.miui.ui.version.name");     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r3) == true) goto L7;
        int r4 = Integer.parseInt(r3.substring(1));     // Catch: Exception -> L8
    L9:
        if (r4 != (-1)) goto L12;
        return false;
    L12:
        if (Build.FINGERPRINT.toLowerCase().contains("xiaomi") == false) goto L14;
    L17:
        return true;
    L14:
        if (Build.FINGERPRINT.toLowerCase().contains("miui") == true) goto L17;
        return false;
    L7:
        r4 = 0;
    L8:
        r4 = -1;
        goto L9
    }

    public static String getSystemProperty(String r7) {
        Class<?> r1 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L10
        Object r8 = r1.getMethod("get", new Class[]{String.class}).invoke(r1, new Object[]{r7});     // Catch: Exception -> L10
        if (r8 != null) goto L6;
        return null;
    L6:
        if ((r8 instanceof String) == false) goto L14;
        return (String) r8;
    L14:
        return null;
    L15:
        return null;
    }
}
