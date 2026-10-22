package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OUnitExtension.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0016\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r\u001a\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r\u001a\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r\u001a\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020 \u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020 \u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020\u0001\u001a\n\u0010%\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010'\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010(\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010)\u001a\u00020\u0001*\u00020\u001c\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010+\u001a\u00020\r\u001a\f\u0010,\u001a\u00020\u0001*\u00020-H\u0000\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020 \u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"+\u0010\u0005\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"+\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0011\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"+\u0010\u0013\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"+\u0010\u0016\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0010¨\u00062"}, d2 = {"color", "", "", "getColor", "(Ljava/lang/String;)I", "dp", ExifInterface.GPS_DIRECTION_TRUE, "", "getDp$annotations", "(Ljava/lang/Number;)V", "getDp", "(Ljava/lang/Number;)I", "dpFloat", "", "getDpFloat$annotations", "getDpFloat", "(Ljava/lang/Number;)F", "px", "getPx", CloudControlInf.SP, "getSp$annotations", "getSp", "spFloat", "getSpFloat$annotations", "getSpFloat", "dp2px", "dpValue", "context", "Landroid/content/Context;", "density", "dp2pxFloat", "cdp", "", "Landroid/content/res/Resources;", "cdpFloat", "cspFloat", "spValue", "getAppScreenHeight", "getRealScreenHeight", "getRealScreenWidth", "getScreenHeight", "getScreenWidth", "px2dp", "pxValue", "toInt", "", "vdp", "Landroid/view/View;", "vdpFloat", "vspFloat", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class OUnitExtensionKt {
    public static final int dp2px(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return (int) ((r2 * r3) + 0.5f);
    L5:
        r0 = false;
        goto L6
    }

    public static final int dp2px(int r0, float r1) {
        if (r0 != 0) goto L6;
        return 0;
    L6:
        return (int) ((r0 * r1) + 0.5f);
    }

    public static final float dp2pxFloat(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return r2 * r3;
    L5:
        r1 = false;
        goto L6
    }

    public static final float dp2pxFloat(int r0, float r1) {
        if (r0 != 0) goto L6;
        return 0.0f;
    L6:
        return r0 * r1;
    }

    @Deprecated(message = "use View.vdp(dpValue: Int) or Context.cdp(dpValue: Int) instead")
    public static /* synthetic */ void getDp$annotations(Number r0) {
    }

    @Deprecated(message = "use View.vdpFloat(dpValue: Int) or Context.cdpFloat(dpValue: Int) instead")
    public static /* synthetic */ void getDpFloat$annotations(Number r0) {
    }

    @Deprecated(message = "use View.vspFloat(spValue: Int).toInt() or Context.cspFloat(spValue: Int).toInt() instead")
    public static /* synthetic */ void getSp$annotations(Number r0) {
    }

    @Deprecated(message = "use View.vspFloat(spValue: Int) or Context.cspFloat(spValue: Int) instead")
    public static /* synthetic */ void getSpFloat$annotations(Number r0) {
    }

    public static final int toInt(boolean r0) {
        return r0 ? 1 : 0;
    }

    public static final int px2dp(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return MathKt.roundToInt(r2 / r1.getResources().getDisplayMetrics().density);
    }

    public static final float dp2px(float r1) {
        return r1 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float dp2px(float r1, Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return r1 * r2.getResources().getDisplayMetrics().density;
    }

    @Deprecated(message = "use dp2px(dpValue: Int, context: Context) instead")
    public static final int dp2px(int r1) {
        return (int) ((r1 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int vdp(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return vdp(r1, r2);
    }

    public static final int vdp(View r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return vdp(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final int vdp(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * r2.getResources().getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float vdpFloat(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return vdpFloat(r1, r2);
    }

    public static final float vdpFloat(View r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return vdpFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float vdpFloat(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, r3.getResources().getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final float vspFloat(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return vspFloat(r1, r2);
    }

    public static final float vspFloat(View r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return vspFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float vspFloat(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, r2.getResources().getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final int cdp(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return cdp(r1, r2);
    }

    public static final int cdp(Context r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return cdp(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final int cdp(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * r2.getResources().getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cdpFloat(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return cdpFloat(r1, r2);
    }

    public static final float cdpFloat(Context r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return cdpFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cdpFloat(Context r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, r3.getResources().getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final float cspFloat(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return cspFloat(r1, r2);
    }

    public static final float cspFloat(Context r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return cspFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cspFloat(Context r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, r2.getResources().getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final int cdp(Resources r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return cdp(r1, r2);
    }

    public static final int cdp(Resources r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return cdp(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final int cdp(Resources r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * r2.getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cdpFloat(Resources r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return cdpFloat(r1, r2);
    }

    public static final float cdpFloat(Resources r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return cdpFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cdpFloat(Resources r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, r3.getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final float cspFloat(Resources r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return cspFloat(r1, r2);
    }

    public static final float cspFloat(Resources r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return cspFloat(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float cspFloat(Resources r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, r2.getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ <T extends Number> int getDp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return MathKt.roundToInt(TypedValue.applyDimension(1, r2.floatValue(), Resources.getSystem().getDisplayMetrics()));
    }

    public static final /* synthetic */ <T extends Number> float getDpFloat(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return TypedValue.applyDimension(1, r2.floatValue(), Resources.getSystem().getDisplayMetrics());
    }

    public static final /* synthetic */ <T extends Number> int getSp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return MathKt.roundToInt(TypedValue.applyDimension(2, r2.floatValue(), Resources.getSystem().getDisplayMetrics()));
    }

    public static final /* synthetic */ <T extends Number> float getSpFloat(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return TypedValue.applyDimension(2, r2.floatValue(), Resources.getSystem().getDisplayMetrics());
    }

    public static final /* synthetic */ <T extends Number> int getPx(T r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.intValue();
    }

    public static final int getScreenWidth(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.widthPixels;
    }

    public static final int getScreenHeight(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.heightPixels;
    }

    public static final int getRealScreenWidth(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        WindowManager r0 = (WindowManager) r2.getSystemService(WindowManager.class);
        Integer r1 = null;
        if (r0 == null) goto L12;
        WindowMetrics r3 = r0.getCurrentWindowMetrics();
        if (r3 == null) goto L12;
        Rect r4 = r3.getBounds();
        if (r4 == null) goto L12;
        r1 = Integer.valueOf(r4.width());
    L12:
        if (r1 != null) goto L15;
        return getScreenWidth(r2);
    L15:
        return r1.intValue();
    }

    public static final int getRealScreenHeight(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        WindowManager r0 = (WindowManager) r2.getSystemService(WindowManager.class);
        Integer r1 = null;
        if (r0 == null) goto L12;
        WindowMetrics r3 = r0.getCurrentWindowMetrics();
        if (r3 == null) goto L12;
        Rect r4 = r3.getBounds();
        if (r4 == null) goto L12;
        r1 = Integer.valueOf(r4.height());
    L12:
        if (r1 != null) goto L15;
        return getScreenHeight(r2);
    L15:
        return r1.intValue();
    }

    public static final int getAppScreenHeight(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        WindowManager r0 = (WindowManager) r4.getSystemService(WindowManager.class);
        Integer r1 = null;
        if (r0 != null) goto L5;
        WindowMetrics r2 = null;
    L6:
        if (r2 != null) goto L8;
    L7:
        Insets r3 = null;
    L12:
        if (r2 == null) goto L18;
        Rect r5 = r2.getBounds();
        if (r5 == null) goto L18;
        r1 = Integer.valueOf(r5.height());
    L18:
        if (r1 != null) goto L20;
        int r6 = getScreenHeight(r4);
    L21:
        int r7 = 0;
        if (r3 != null) goto L24;
        int r8 = 0;
    L25:
        if (r3 == null) goto L29;
        r7 = r3.bottom;
    L29:
        return (r6 - r8) - r7;
    L24:
        r8 = r3.top;
        goto L25
    L20:
        r6 = r1.intValue();
        goto L21
    L8:
        WindowInsets r9 = r2.getWindowInsets();
        if (r9 == null) goto L7;
        r3 = r9.getInsets(WindowInsets.Type.systemBars());
        goto L12
    L5:
        r2 = r0.getCurrentWindowMetrics();
        goto L6
    }

    public static final int getColor(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Color.parseColor(r1);
    }
}
