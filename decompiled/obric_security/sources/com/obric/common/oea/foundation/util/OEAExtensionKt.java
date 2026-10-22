package com.obric.common.oea.foundation.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.exifinterface.media.ExifInterface;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OEAExtension.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\u0001*\u00020\u0017\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0017\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000b\u001a\f\u0010\u001b\u001a\u00020\u0001*\u00020\u001cH\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0005\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\u00020\u000b\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\"\u0010\u000e\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"\"\u0010\u0010\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t\"\"\u0010\u0012\u001a\u00020\u000b\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u001d"}, d2 = {"color", "", "", "getColor", "(Ljava/lang/String;)I", "dp", ExifInterface.GPS_DIRECTION_TRUE, "", "getDp", "(Ljava/lang/Number;)I", "dpFloat", "", "getDpFloat", "(Ljava/lang/Number;)F", "px", "getPx", CloudControlInf.SP, "getSp", "spFloat", "getSpFloat", "dp2px", "dpValue", "getScreenHeight", "Landroid/content/Context;", "getScreenWidth", "px2dp", "pxValue", "toInt", "", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class OEAExtensionKt {
    public static final int toInt(boolean r0) {
        return r0 ? 1 : 0;
    }

    public static final int px2dp(Context r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$px2dp");
        Resources r3 = r1.getResources();
        Intrinsics.checkNotNullExpressionValue(r3, "resources");
        return MathKt.roundToInt(r2 / r3.getDisplayMetrics().density);
    }

    public static final float dp2px(float r2) {
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return r2 * r0.getDisplayMetrics().density;
    }

    public static final int dp2px(int r2) {
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return (int) ((r2 * r0.getDisplayMetrics().density) + 0.5f);
    }

    public static final /* synthetic */ <T extends Number> int getDp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dp");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return MathKt.roundToInt(TypedValue.applyDimension(1, r3, r0.getDisplayMetrics()));
    }

    public static final /* synthetic */ <T extends Number> float getDpFloat(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dpFloat");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return TypedValue.applyDimension(1, r3, r0.getDisplayMetrics());
    }

    public static final /* synthetic */ <T extends Number> int getSp(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$sp");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return MathKt.roundToInt(TypedValue.applyDimension(2, r3, r0.getDisplayMetrics()));
    }

    public static final /* synthetic */ <T extends Number> float getSpFloat(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$spFloat");
        float r3 = r2.floatValue();
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        return TypedValue.applyDimension(2, r3, r0.getDisplayMetrics());
    }

    public static final /* synthetic */ <T extends Number> int getPx(T r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$px");
        return r1.intValue();
    }

    public static final int getScreenWidth(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getScreenWidth");
        Resources r2 = r1.getResources();
        Intrinsics.checkNotNullExpressionValue(r2, "resources");
        DisplayMetrics r3 = r2.getDisplayMetrics();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.widthPixels;
    }

    public static final int getScreenHeight(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getScreenHeight");
        Resources r2 = r1.getResources();
        Intrinsics.checkNotNullExpressionValue(r2, "resources");
        DisplayMetrics r3 = r2.getDisplayMetrics();
        if (r3 != null) goto L7;
        return 0;
    L7:
        return r3.heightPixels;
    }

    public static final int getColor(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$color");
        return Color.parseColor(r1);
    }
}
