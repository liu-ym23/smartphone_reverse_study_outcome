package com.android.settings.accounts.obric;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.UserHandle;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.android.settings.SettingsApplication;
import com.obric.olog.OLog;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ObricIconUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J@\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/settings/accounts/obric/ObricIconUtils;", "", "()V", "TAG", "", "drawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "sizeDp", "Landroid/graphics/PointF;", "getDrawable", "info", "Landroid/content/pm/ApplicationInfo;", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "uid", "", "getRoundedDrawable", "context", "Landroid/content/Context;", "borderWidthDp", "", "borderColor", "cornersDp", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ObricIconUtils {
    public static final ObricIconUtils INSTANCE = null;
    private static final String TAG = "ObricIconUtils";

    static {
        INSTANCE = new ObricIconUtils();
    }

    @JvmStatic
    public static final Drawable getRoundedDrawable(Context r9, Drawable r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "drawable");
        return getRoundedDrawable$default(r9, r10, null, 0.0f, 0, 0.0f, 60, null);
    }

    @JvmStatic
    public static final Drawable getRoundedDrawable(Context r9, Drawable r10, PointF r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "drawable");
        Intrinsics.checkNotNullParameter(r11, "sizeDp");
        return getRoundedDrawable$default(r9, r10, r11, 0.0f, 0, 0.0f, 56, null);
    }

    @JvmStatic
    public static final Drawable getRoundedDrawable(Context r9, Drawable r10, PointF r11, float r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "drawable");
        Intrinsics.checkNotNullParameter(r11, "sizeDp");
        return getRoundedDrawable$default(r9, r10, r11, r12, 0, 0.0f, 48, null);
    }

    @JvmStatic
    public static final Drawable getRoundedDrawable(Context r9, Drawable r10, PointF r11, float r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "drawable");
        Intrinsics.checkNotNullParameter(r11, "sizeDp");
        return getRoundedDrawable$default(r9, r10, r11, r12, r13, 0.0f, 32, null);
    }

    private ObricIconUtils() {
    }

    @JvmStatic
    public static final Drawable getDrawable(String r4) {
        Intrinsics.checkNotNullParameter(r4, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        PackageManager r0 = SettingsApplication.getContext().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getPackageManager(...)");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        ApplicationInfo r3 = r0.getPackageInfo(r4, 0).applicationInfo;     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        Drawable r5 = r3.loadIcon(r0);     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.m1508constructorimpl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.m1511exceptionOrNullimpl(r6) == null) goto L15;
        OLog.e(TAG, "Couldn't load icon for package " + r4);
    L15:
        if (Result.m1514isFailureimpl(r6) == true) goto L19;
        r1 = r6;
    L19:
        return (Drawable) r1;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @JvmStatic
    public static final Drawable getDrawable(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        PackageManager r0 = SettingsApplication.getContext().getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r0, "getPackageManager(...)");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        if (UserHandle.getUserId(r5) != 10) goto L13;
        PackageInfo r6 = r0.getPackageInfo(r4, 0);     // Catch: Throwable -> L16
        if (r6 == null) goto L12;
        ApplicationInfo r7 = r6.applicationInfo;     // Catch: Throwable -> L16
        if (r7 == null) goto L12;
        Drawable r8 = r7.loadUnbadgedIcon(r0);     // Catch: Throwable -> L16
        if (r8 == null) goto L12;
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L16
        Drawable r9 = r0.getUserBadgedIcon(r8, UserHandle.of(UserHandle.getUserId(r5)));     // Catch: Throwable -> L16
    L14:
        Object r10 = Result.m1508constructorimpl(r9);     // Catch: Throwable -> L16
    L19:
        if (Result.m1514isFailureimpl(r10) == true) goto L23;
        r1 = r10;
    L23:
        return (Drawable) r1;
    L12:
        r9 = null;
        goto L14
    L13:
        r9 = getDrawable(r4);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @JvmStatic
    public static final Drawable getDrawable(ApplicationInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        String r0 = r2.packageName;
        Intrinsics.checkNotNullExpressionValue(r0, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        return getDrawable(r0, r2.uid);
    }

    public static /* synthetic */ Drawable getRoundedDrawable$default(Context r6, Drawable r7, PointF r8, float r9, int r10, float r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r8 = new PointF(28.0f, 28.0f);
    L5:
        PointF r2 = r8;
        if ((r12 & 8) == 0) goto L8;
        r9 = 0.6f;
    L8:
        float r3 = r9;
        if ((r12 & 16) == 0) goto L11;
        r10 = Color.parseColor("#0f000000");
    L11:
        int r4 = r10;
        if ((r12 & 32) == 0) goto L15;
        r11 = 8.0f;
    L15:
        return getRoundedDrawable(r6, r7, r2, r3, r4, r11);
    }

    @JvmStatic
    public static final Drawable getRoundedDrawable(Context r2, Drawable r3, PointF r4, float r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "drawable");
        Intrinsics.checkNotNullParameter(r4, "sizeDp");
        GradientDrawable r0 = new GradientDrawable();     // Catch: Exception -> L5
        r0.setShape(0);     // Catch: Exception -> L5
        r0.setColor(0);     // Catch: Exception -> L5
        r0.setStroke((int) OUnitExtensionKt.dp2px(r5), r6);     // Catch: Exception -> L5
        r0.setCornerRadius(OUnitExtensionKt.dp2px(r7));     // Catch: Exception -> L5
        RoundedBitmapDrawable r8 = RoundedBitmapDrawableFactory.create(r2.getResources(), INSTANCE.drawableToBitmap(r3, r4));     // Catch: Exception -> L5
        r8.setCornerRadius(OUnitExtensionKt.dp2px(r7));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r8, "apply(...)");     // Catch: Exception -> L5
        return new LayerDrawable(new Drawable[]{r8, r0});
    L5:
        return r3;
    }

    private final Bitmap drawableToBitmap(Drawable r9, PointF r10) {
        int r8 = RangesKt.coerceAtLeast(MathKt.roundToInt(OUnitExtensionKt.dp2px(r10.x)), 1);
        int r11 = RangesKt.coerceAtLeast(MathKt.roundToInt(OUnitExtensionKt.dp2px(r10.y)), 1);
        Bitmap r1 = Bitmap.createBitmap(r8, r11, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(r1, "createBitmap(...)");
        Canvas r2 = new Canvas(r1);
        Integer r3 = Integer.valueOf(r9.getIntrinsicWidth());
        if (r3.intValue() <= 0) goto L5;
        boolean r4 = true;
    L6:
        Integer r6 = null;
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L12;
        int r5 = r3.intValue();
    L13:
        Integer r7 = Integer.valueOf(r9.getIntrinsicHeight());
        if (r7.intValue() <= 0) goto L16;
        boolean r12 = true;
    L17:
        if (r12 == false) goto L19;
        r6 = r7;
    L19:
        if (r6 == null) goto L21;
        int r13 = r6.intValue();
    L22:
        float r14 = r8;
        float r15 = r5;
        float r16 = r11;
        float r17 = r13;
        float r18 = Math.max(r14 / r15, r16 / r17);
        float r19 = r15 * r18;
        float r20 = r17 * r18;
        float r21 = (r14 - r19) / 2.0f;
        float r110 = (r16 - r20) / 2.0f;
        Drawable.ConstantState r22 = r9.getConstantState();
        if (r22 == null) goto L28;
        Drawable r23 = r22.newDrawable();
        if (r23 == null) goto L28;
        r9 = r23;
    L28:
        Drawable r24 = r9.mutate();
        Intrinsics.checkNotNullExpressionValue(r24, "mutate(...)");
        Rect r25 = r24.copyBounds();
        Intrinsics.checkNotNullExpressionValue(r25, "copyBounds(...)");
        r24.setBounds(0, 0, MathKt.roundToInt(r19), MathKt.roundToInt(r20));
        int r26 = r2.save();
        r2.translate(r21, r110);
        if ((r24 instanceof BitmapDrawable) == false) goto L31;
        ((BitmapDrawable) r24).setFilterBitmap(true);
    L31:
        r24.draw(r2);
        r2.restoreToCount(r26);
        r24.setBounds(r25);
        return r1;
    L21:
        r13 = r11;
        goto L22
    L16:
        r12 = false;
        goto L17
    L12:
        r5 = r8;
        goto L13
    L5:
        r4 = false;
        goto L6
    }
}
