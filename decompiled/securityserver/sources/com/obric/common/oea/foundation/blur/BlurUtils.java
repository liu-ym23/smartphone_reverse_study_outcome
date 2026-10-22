package com.obric.common.oea.foundation.blur;

import android.annotation.SuppressLint;
import android.graphics.drawable.DrawableWrapper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class BlurUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f131a = null;

    public static class BackgroundBlurDrawable extends DrawableWrapper {
        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int r5, int r6, int r7, int r8) {
            HashMap r0 = BlurUtils.f131a;
            Method r2 = (Method) r0.get("setBounds");
            if (r2 == null) goto L17;
        L11:
            r2.invoke(getDrawable(), new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7), Integer.valueOf(r8)});     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
        L5:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L21:
            return;
        L17:
            Class<?> r3 = Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable");     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
            Class r4 = Integer.TYPE;     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
            r2 = r3.getDeclaredMethod("setBounds", new Class[]{r4, r4, r4, r4});     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
            r2.setAccessible(true);     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
            r0.put("setBounds", r2);     // Catch: ClassNotFoundException -> L5 InvocationTargetException -> L7 Throwable -> L9
            goto L11
        }
    }

    public static final enum BlurType extends Enum<BlurType> {
        public static final /* synthetic */ BlurType[] b = null;

        static {
            b = new BlurType[]{new BlurType("NONE", 0), new BlurType("NORMAL_BLUR", 1), new BlurType("PROGRESS_BLUR_DOWN_UP", 2), new BlurType("PROGRESS_BLUR_UP_DOWN", 3), new BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4), new BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5)};
        }

        public static BlurType valueOf(String r1) {
            return (BlurType) Enum.valueOf(BlurType.class, r1);
        }

        public static BlurType[] values() {
            return (BlurType[]) b.clone();
        }
    }

    public static class WindowBackgroundBlurDrawable {
    }

    static {
        f131a = new HashMap();
    }
}
