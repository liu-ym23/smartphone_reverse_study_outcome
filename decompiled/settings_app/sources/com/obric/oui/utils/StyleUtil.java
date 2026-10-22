package com.obric.oui.utils;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: StyleUtil.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jt\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2K\u0010\n\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u0002H\u00040\u000bH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/utils/StyleUtil;", "", "()V", "createWidgetWithStyle", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "context", "Landroid/content/Context;", "styleResId", "", "ofStyle", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "styledContext", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "(Landroid/content/Context;ILkotlin/jvm/functions/Function3;)Landroid/view/View;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StyleUtil {
    public static final StyleUtil INSTANCE = null;

    static {
        INSTANCE = new StyleUtil();
    }

    private StyleUtil() {
    }

    @JvmStatic
    public static final <T extends View> T createWidgetWithStyle(Context r3, int r4, Function3<? super Context, ? super Integer, ? super Integer, ? extends T> r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "ofStyle");
        ContextThemeWrapper r0 = new ContextThemeWrapper(r3, r4);
        TypedArray r6 = r0.obtainStyledAttributes(null, new int[]{R.attr.layout_width, R.attr.layout_height}, 0, r4);
        Intrinsics.checkNotNullExpressionValue(r6, "contextThemeWrapper.obta…ll, attrs, 0, styleResId)");
        int r1 = r6.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r7 = r6.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        T r8 = r5.invoke(r0, Integer.valueOf(r1), Integer.valueOf(r7));     // Catch: Throwable -> L6
        r6.recycle();
        return r8;
    L6:
        th = move-exception;
        r6.recycle();
        throw th;
    }
}
