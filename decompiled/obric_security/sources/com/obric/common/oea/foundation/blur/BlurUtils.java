package com.obric.common.oea.foundation.blur;

import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.hardware.HardwareBuffer;
import android.view.SurfaceControl;
import android.view.View;
import com.obric.oui.material.OMaterialHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class BlurUtils {
    public static final int COLOR_FILTER_TYPE_DARK0 = 0;
    public static final int COLOR_FILTER_TYPE_DARK1 = 2;
    public static final int COLOR_FILTER_TYPE_LIGHT0 = 1;
    public static final int COLOR_FILTER_TYPE_LIGHT1 = 3;
    public static final int COLOR_FILTER_TYPE_PHONE = 4;
    private static HashMap<String, Method> METH0D_CACHE = null;
    public static final int TYPE_COLOR = 1;
    public static final int TYPE_HSB = 2;
    public static final int TYPE_UV = 0;
    private SurfaceControl mSurfaceControl;
    private SurfaceControl.Transaction mTransaction;
    private View mView;
    private Object mViewRootImpl;
    private float[] tmpFloat;

    public static final enum BLEND_MODE extends Enum<BLEND_MODE> {
        private static final /* synthetic */ BLEND_MODE[] $VALUES = null;
        public static final BLEND_MODE COLOR_BURN = null;
        public static final BLEND_MODE COLOR_DODGE = null;
        public static final BLEND_MODE DEFAULT = null;
        public static final BLEND_MODE LUMINOSITY = null;
        public static final BLEND_MODE OVERLAY = null;
        public static final BLEND_MODE PLUS_DARKER = null;
        public static final BLEND_MODE PLUS_LIGHTER = null;
        public static final BLEND_MODE SOFT_LIGHT = null;

        private BLEND_MODE(String r1, int r2) {
            super(r1, r2);
        }

        public static BLEND_MODE valueOf(String r1) {
            return (BLEND_MODE) Enum.valueOf(BLEND_MODE.class, r1);
        }

        public static BLEND_MODE[] values() {
            return (BLEND_MODE[]) $VALUES.clone();
        }

        static {
            BLEND_MODE r0 = new BLEND_MODE("DEFAULT", 0);
            DEFAULT = r0;
            BLEND_MODE r1 = new BLEND_MODE("COLOR_BURN", 1);
            COLOR_BURN = r1;
            BLEND_MODE r3 = new BLEND_MODE("COLOR_DODGE", 2);
            COLOR_DODGE = r3;
            BLEND_MODE r5 = new BLEND_MODE("PLUS_DARKER", 3);
            PLUS_DARKER = r5;
            BLEND_MODE r7 = new BLEND_MODE("PLUS_LIGHTER", 4);
            PLUS_LIGHTER = r7;
            BLEND_MODE r9 = new BLEND_MODE("LUMINOSITY", 5);
            LUMINOSITY = r9;
            BLEND_MODE r11 = new BLEND_MODE("OVERLAY", 6);
            OVERLAY = r11;
            BLEND_MODE r13 = new BLEND_MODE("SOFT_LIGHT", 7);
            SOFT_LIGHT = r13;
            $VALUES = new BLEND_MODE[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    public static class BackgroundBlurDrawable extends DrawableWrapper {
        public BackgroundBlurDrawable(Drawable r1) {
            super(r1);
        }

        public void setBlurRadius(int r8) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurRadiusNative");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r8)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBlurRadius", new Class[]{Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurRadiusNative", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setCornerRadius(float r10, float r11, float r12, float r13) {
            Method r0 = (Method) BlurUtils.access$000().get("setCornerRadius");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Float.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setCornerRadius", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setCornerRadius", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int r10, int r11, int r12, int r13) {
            Method r0 = (Method) BlurUtils.access$000().get("setBounds");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBounds", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBounds", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlendColorExt(float r10, float r11, float r12, int r13) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlendColorExt");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Integer.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBlendColorExt", new Class[]{Float.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlendColorExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlendColorExt2(int... r8) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlendColorExt2");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{r8});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBlendColorExt", new Class[]{int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlendColorExt2", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlurUvOffsetsExt(float r8, float r9) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurUvOffsetsExt");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Float.valueOf(r8), Float.valueOf(r9)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBlurUvOffsetsExt", new Class[]{Float.TYPE, Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurUvOffsetsExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void setBlurDirectionExt(int r7) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurDirectionExt");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(getDrawable(), new Object[]{Integer.valueOf(r7)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("com.android.internal.graphics.drawable.BackgroundBlurDrawable"), "setBlurDirectionExt", new Class[]{Integer.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurDirectionExt", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }
    }

    public static final enum BlurType extends Enum<BlurType> {
        private static final /* synthetic */ BlurType[] $VALUES = null;
        public static final BlurType NONE = null;
        public static final BlurType NORMAL_BLUR = null;
        public static final BlurType PROGRESS_BLUR_DOWN_UP = null;
        public static final BlurType PROGRESS_BLUR_LEFT_RIGHT = null;
        public static final BlurType PROGRESS_BLUR_RIGHT_LEFT = null;
        public static final BlurType PROGRESS_BLUR_UP_DOWN = null;

        private BlurType(String r1, int r2) {
            super(r1, r2);
        }

        public static BlurType valueOf(String r1) {
            return (BlurType) Enum.valueOf(BlurType.class, r1);
        }

        public static BlurType[] values() {
            return (BlurType[]) $VALUES.clone();
        }

        static {
            BlurType r0 = new BlurType("NONE", 0);
            NONE = r0;
            BlurType r1 = new BlurType("NORMAL_BLUR", 1);
            NORMAL_BLUR = r1;
            BlurType r3 = new BlurType("PROGRESS_BLUR_DOWN_UP", 2);
            PROGRESS_BLUR_DOWN_UP = r3;
            BlurType r5 = new BlurType("PROGRESS_BLUR_UP_DOWN", 3);
            PROGRESS_BLUR_UP_DOWN = r5;
            BlurType r7 = new BlurType("PROGRESS_BLUR_LEFT_RIGHT", 4);
            PROGRESS_BLUR_LEFT_RIGHT = r7;
            BlurType r9 = new BlurType("PROGRESS_BLUR_RIGHT_LEFT", 5);
            PROGRESS_BLUR_RIGHT_LEFT = r9;
            $VALUES = new BlurType[]{r0, r1, r3, r5, r7, r9};
        }
    }

    public static class WindowBackgroundBlurDrawable {
        private float mBlurBrightness;
        private int mBlurColor;
        private float mBlurHue;
        private float mBlurSaturation;
        private Object mDrawable;

        static /* synthetic */ Object access$100(WindowBackgroundBlurDrawable r0) {
            return r0.mDrawable;
        }

        public WindowBackgroundBlurDrawable(Object r2) {
            this.mBlurSaturation = 1.0f;
            this.mBlurBrightness = 1.0f;
            this.mBlurHue = 0.0f;
            this.mBlurColor = 0;
            this.mDrawable = r2;
        }

        public WindowBackgroundBlurDrawable setBlurRadius(float r7) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurRadius");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Float.valueOf(r7)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L13:
            return this;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "setBlurRadius", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurRadius", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public WindowBackgroundBlurDrawable setBlurHSB(float r2, float r3, float r4) {
            return setBlurHSB(this.mBlurColor, r2, r3, r4);
        }

        public WindowBackgroundBlurDrawable setBlurSaturation(float r4) {
            return setBlurHSB(this.mBlurColor, this.mBlurHue, r4, this.mBlurBrightness);
        }

        public WindowBackgroundBlurDrawable setBlurBrightness(float r4) {
            return setBlurHSB(this.mBlurColor, this.mBlurHue, this.mBlurSaturation, r4);
        }

        public WindowBackgroundBlurDrawable setBlurHue(float r4) {
            return setBlurHSB(this.mBlurColor, r4, this.mBlurSaturation, this.mBlurBrightness);
        }

        public WindowBackgroundBlurDrawable setBlurColor(int r4) {
            return setBlurHSB(r4, this.mBlurHue, this.mBlurSaturation, this.mBlurBrightness);
        }

        public WindowBackgroundBlurDrawable setBlurAlpha(float r7) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurAlpha");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Float.valueOf(r7)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L13:
            return this;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "setBlurAlpha", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurAlpha", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public WindowBackgroundBlurDrawable setBlurHSB(int r10, float r11, float r12, float r13) {
            this.mBlurColor = r10;
            this.mBlurHue = r11;
            this.mBlurSaturation = r12;
            this.mBlurBrightness = r13;
            Method r0 = (Method) BlurUtils.access$000().get("setBlurHSB");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Integer.valueOf(r10), Float.valueOf(r11), Float.valueOf(r12), Float.valueOf(r13)});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L13:
            return this;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "setBlurHSB", new Class[]{Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurHSB", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public WindowBackgroundBlurDrawable setBlendColor(int... r7) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlendColor");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{r7});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L13:
            return this;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "setBlendColor", new Class[]{int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlendColor", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void applyBlurShader(boolean r9, Paint r10, int... r11) {
            Method r0 = (Method) BlurUtils.access$000().get("applyBlurShader");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Boolean.valueOf(r9), r10, r11});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "applyBlurShader", new Class[]{Boolean.TYPE, Paint.class, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("applyBlurShader", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void applyBlurShaderToShadow(boolean r9, Paint r10, int... r11) {
            Method r0 = (Method) BlurUtils.access$000().get("applyBlurShaderToShadow");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Boolean.valueOf(r9), r10, r11});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "applyBlurShaderToShadow", new Class[]{Boolean.TYPE, Paint.class, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("applyBlurShaderToShadow", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void applyBlurShader(boolean r10, Drawable r11, int... r12) {
            Method r0 = (Method) BlurUtils.access$000().get("applyBlurShader_Drawable");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Boolean.valueOf(r10), r11, r12});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "applyBlurShader", new Class[]{Boolean.TYPE, Drawable.class, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("applyBlurShader_Drawable", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public void applyBlurShaderToShadow(boolean r10, Drawable r11, int... r12) {
            Method r0 = (Method) BlurUtils.access$000().get("applyBlurShaderToShadow_Drawable");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{Boolean.valueOf(r10), r11, r12});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L9:
            e = move-exception;
            e.printStackTrace();
            return;
        L18:
            return;
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "applyBlurShaderToShadow", new Class[]{Boolean.TYPE, Drawable.class, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("applyBlurShaderToShadow_Drawable", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public WindowBackgroundBlurDrawable setBlurForegroundImage(FutureTask<HardwareBuffer> r7) {
            Method r0 = (Method) BlurUtils.access$000().get("setBlurForegroundImage");
            if (r0 == null) goto L14;
        L5:
            r0.invoke(this.mDrawable, new Object[]{r7});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        L13:
            return this;
        L7:
            e = move-exception;
            e.printStackTrace();
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "setBlurForegroundImage", new Class[]{FutureTask.class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("setBlurForegroundImage", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }

        public static FutureTask<HardwareBuffer> makeSnapshot(View r7) {
            Method r0 = (Method) BlurUtils.access$000().get("makeSnapshot");
            if (r0 == null) goto L14;
        L5:
            return (FutureTask) r0.invoke(null, new Object[]{r7});
        L7:
            e = move-exception;
            e.printStackTrace();
        L13:
            return null;
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L13
        L14:
            r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.WindowBackgroundDrawable"), "makeSnapshot", new Class[]{View.class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            BlurUtils.access$000().put("makeSnapshot", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
            goto L5
        }
    }

    static /* synthetic */ HashMap access$000() {
        return METH0D_CACHE;
    }

    static {
        METH0D_CACHE = new HashMap();
    }

    public BlurUtils(View r2) {
        this.tmpFloat = new float[0];
        this.mView = r2;
        this.mTransaction = new SurfaceControl.Transaction();
    }

    public void setWindowBackgroundBlurRadiusExt(int r2, float r3, float r4) {
        setWindowBackgroundBlurRadiusExt(this.mTransaction, r2, r3, r4);
        this.mTransaction.apply();
    }

    public void setWindowBackgroundBlurRadiusExt(SurfaceControl.Transaction r10, int r11, float r12, float r13) {
        setWindowBackgroundBlurRadiusExt(r10, r11, r12, r13, 0.0f, 1.0f, 1.0f, 0);
    }

    public void setWindowBackgroundBlurRadiusExt(int r8, float r9, float r10, float r11, int r12) {
        setWindowBackgroundBlurRadiusExt(this.mTransaction, r8, r9, r10, r11, r12);
        this.mTransaction.apply();
    }

    public void setWindowBackgroundBlurRadiusExt(SurfaceControl.Transaction r9, int r10, float r11, float r12, float r13, int r14) {
        int r2 = 3;
        if (r11 == 0.0f) goto L5;
    L8:
        int r4 = 3;
    L10:
        if (r13 == 0.0f) goto L14;
        if (r14 == (-1)) goto L14;
        r4 = r4 + 3;
    L14:
        if (this.tmpFloat.length == r4) goto L16;
        this.tmpFloat = new float[r4];
    L16:
        if (r11 == 0.0f) goto L18;
    L21:
        float[] r1 = this.tmpFloat;
        r1[0] = 0.0f;
        r1[1] = r11;
        r1[2] = r12;
    L22:
        if (r13 == 0.0f) goto L25;
        if (r14 == (-1)) goto L25;
        float[] r15 = this.tmpFloat;
        int r16 = r2 + 1;
        r15[r2] = 1.0f;
        r15[r16] = r13;
        r15[r16 + 1] = r14;
    L25:
        setBackgroundBlurRadiusExt(r9, r10, this.tmpFloat);
        return;
    L18:
        if (r12 != 0.0f) goto L21;
        r2 = 0;
        goto L22
    L5:
        if (r12 != 0.0f) goto L8;
        r4 = 0;
        goto L10
    }

    private void setBackgroundBlurRadiusExt(SurfaceControl.Transaction r3, int r4, float[] r5) {
        if (this.mViewRootImpl != null) goto L5;
        this.mViewRootImpl = getViewRootImpl(this.mView);
    L5:
        Object r0 = this.mViewRootImpl;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.mSurfaceControl != null) goto L11;
        this.mSurfaceControl = getSurfaceControl(r0);
    L11:
        SurfaceControl r1 = this.mSurfaceControl;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.isValid() == false) goto L19;
        setBackgroundBlurRadiusExt(r3, this.mSurfaceControl, r4, r5);
        this.mTransaction.apply();
        return;
    }

    private static void setBackgroundBlurRadiusExt(SurfaceControl.Transaction r8, SurfaceControl r9, int r10, float[] r11) {
        Method r0 = METH0D_CACHE.get("setBackgroundBlurRadiusExt");
        if (r0 == null) goto L13;
    L5:
        r0.invoke(r8, new Object[]{r9, Integer.valueOf(r10), r11});     // Catch: InvocationTargetException -> L7 Throwable -> L10
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        r0 = NativeReflect.getDeclaredMethod(SurfaceControl.Transaction.class, "setBackgroundBlurRadiusExt", new Class[]{SurfaceControl.class, Integer.TYPE, float[].class});     // Catch: InvocationTargetException -> L7 Throwable -> L10
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        METH0D_CACHE.put("setBackgroundBlurRadiusExt", r0);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        goto L5
    }

    public void setWindowBackgroundBlurRadius(int r2) {
        setWindowBackgroundBlurRadius(this.mTransaction, r2);
        this.mTransaction.apply();
    }

    public void setWindowBackgroundBlurRadius(SurfaceControl.Transaction r3, int r4) {
        if (this.mViewRootImpl != null) goto L5;
        this.mViewRootImpl = getViewRootImpl(this.mView);
    L5:
        Object r0 = this.mViewRootImpl;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.mSurfaceControl != null) goto L11;
        this.mSurfaceControl = getSurfaceControl(r0);
    L11:
        SurfaceControl r1 = this.mSurfaceControl;
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.isValid() == false) goto L19;
        setBackgroundBlurRadius(r3, this.mSurfaceControl, r4);
        return;
    }

    public void setWindowBackgroundBlurRadiusExt(int r11, float r12, float r13, float r14, float r15, float r16, int r17) {
        setWindowBackgroundBlurRadiusExt(this.mTransaction, r11, r12, r13, r14, r15, r16, r17);
        this.mTransaction.apply();
    }

    public void setWindowBackgroundBlurRadiusExt(SurfaceControl.Transaction r10, int r11, float r12, float r13, float r14, float r15, float r16, int r17) {
        int r3 = 3;
        if (r12 == 0.0f) goto L5;
    L8:
        int r5 = 3;
    L10:
        if (r14 == 0.0f) goto L12;
    L16:
        r5 = r5 + 5;
    L18:
        if (this.tmpFloat.length == r5) goto L20;
        this.tmpFloat = new float[r5];
    L20:
        if (r12 == 0.0f) goto L22;
    L25:
        float[] r2 = this.tmpFloat;
        r2[0] = 0.0f;
        r2[1] = r12;
        r2[2] = r13;
    L26:
        if (r14 == 0.0f) goto L28;
    L32:
        float[] r1 = this.tmpFloat;
        int r4 = r3 + 1;
        r1[r3] = 2.0f;
        int r6 = r4 + 1;
        r1[r4] = r14;
        int r7 = r6 + 1;
        r1[r6] = r15;
        r1[r7] = r16;
        r1[r7 + 1] = Float.intBitsToFloat(r17);
    L33:
        setBackgroundBlurRadiusExt(r10, r11, this.tmpFloat);
        return;
    L28:
        if (r15 != 1.0f) goto L32;
        if (r16 != 1.0f) goto L32;
        if (r17 == 0) goto L33;
    L22:
        if (r13 != 0.0f) goto L25;
        r3 = 0;
        goto L26
    L12:
        if (r15 != 1.0f) goto L16;
        if (r16 != 1.0f) goto L16;
        if (r17 == 0) goto L18;
    L5:
        if (r13 != 0.0f) goto L8;
        r5 = 0;
        goto L10
    }

    private static void setBackgroundBlurRadius(SurfaceControl.Transaction r7, SurfaceControl r8, int r9) {
        Method r0 = METH0D_CACHE.get("setBackgroundBlurRadius");
        if (r0 == null) goto L13;
    L5:
        r0.invoke(r7, new Object[]{r8, Integer.valueOf(r9)});     // Catch: InvocationTargetException -> L7 Throwable -> L10
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        r0 = NativeReflect.getDeclaredMethod(SurfaceControl.Transaction.class, "setBackgroundBlurRadius", new Class[]{SurfaceControl.class, Integer.TYPE});     // Catch: InvocationTargetException -> L7 Throwable -> L10
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        METH0D_CACHE.put("setBackgroundBlurRadius", r0);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        goto L5
    }

    private static Object getViewRootImpl(View r4) {
        Method r0 = METH0D_CACHE.get("getViewRootImpl");
        if (r0 == null) goto L13;
    L5:
        return r0.invoke(r4, new Object[0]);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        r0 = NativeReflect.getDeclaredMethod(View.class, "getViewRootImpl", new Class[0]);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        METH0D_CACHE.put("getViewRootImpl", r0);     // Catch: InvocationTargetException -> L7 Throwable -> L10
        goto L5
    }

    private static SurfaceControl getSurfaceControl(Object r4) {
        Method r0 = METH0D_CACHE.get("getSurfaceControl");
        if (r0 == null) goto L16;
    L5:
        return (SurfaceControl) r0.invoke(r4, new Object[0]);
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName("android.view.ViewRootImpl"), "getSurfaceControl", new Class[0]);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L10 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L10 Throwable -> L13
        METH0D_CACHE.put("getSurfaceControl", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L10 Throwable -> L13
        goto L5
    }

    public static void setBackdropBlurEffect(View r0, BlurType r1, float r2, int... r3) {
        setBackdropBlurEffectExt(r0, r1.ordinal() - 1, r2, r3);
    }

    public static void setBlurEffect(View r0, BlurType r1, float r2, int... r3) {
        setBlurEffectExt(r0, r1.ordinal() - 1, r2, r3);
    }

    private static void setBackdropBlurEffectExt(View r9, int r10, float r11, int... r12) {
        Object r13 = getExt(r9);
        Method r0 = METH0D_CACHE.get("setBackdropBlurEffect");
        if (r0 == null) goto L14;
    L5:
        r0.invoke(r13, new Object[]{Integer.valueOf(r10), Float.valueOf(r11), r12});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        return;
    L14:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setBackdropBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        METH0D_CACHE.put("setBackdropBlurEffect", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        goto L5
    }

    private static void setBlurEffectExt(View r9, int r10, float r11, int... r12) {
        Object r13 = getExt(r9);
        Method r0 = METH0D_CACHE.get("setBlurEffect");
        if (r0 == null) goto L14;
    L5:
        r0.invoke(r13, new Object[]{Integer.valueOf(r10), Float.valueOf(r11), r12});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        return;
    L14:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setBlurEffectExt", new Class[]{Integer.TYPE, Float.TYPE, int[].class});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        METH0D_CACHE.put("setBlurEffect", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        goto L5
    }

    public static BackgroundBlurDrawable createBackgroundBlurDrawable(View r6) {
        Object r0 = getViewRootImpl(r6);
        if (r0 != null) goto L5;
        return null;
    L5:
        Method r2 = METH0D_CACHE.get("createBackgroundBlurDrawable");
        if (r2 == null) goto L22;
    L8:
        Drawable r1 = (Drawable) r2.invoke(r0, new Object[0]);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L16 Throwable -> L19
        if (r1 == null) goto L12;
        r6.setBackground(r1);
        return new BackgroundBlurDrawable(r1);
    L12:
        return null;
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        r2 = NativeReflect.getDeclaredMethod(Class.forName("android.view.ViewRootImpl"), "createBackgroundBlurDrawable", new Class[0]);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L16 Throwable -> L19
        r2.setAccessible(true);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L16 Throwable -> L19
        METH0D_CACHE.put("createBackgroundBlurDrawable", r2);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L16 Throwable -> L19
        goto L8
    }

    public static Paint getWindowBackgroundBlurPaint(View r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r6 = getExt(r5);
        Method r1 = METH0D_CACHE.get("getWindowBackgroundBlurPaint");
        if (r1 == null) goto L17;
    L8:
        return (Paint) r1.invoke(r6, new Object[0]);
    L10:
        e = move-exception;
        e.printStackTrace();
    L16:
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L17:
        r1 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "getWindowBackgroundBlurPaint", new Class[0]);     // Catch: ClassNotFoundException -> L10 InvocationTargetException -> L12 Throwable -> L14
        r1.setAccessible(true);     // Catch: ClassNotFoundException -> L10 InvocationTargetException -> L12 Throwable -> L14
        METH0D_CACHE.put("getWindowBackgroundBlurPaint", r1);     // Catch: ClassNotFoundException -> L10 InvocationTargetException -> L12 Throwable -> L14
        goto L8
    }

    public static void setWindowBackgroundBlurOutLine(View r6, Outline r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurOutLine");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r8, new Object[]{r7});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurOutLine", new Class[]{Outline.class});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurOutLine", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void setWindowBackgroundBlurUvOffset(View r7, int r8, int r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        Object r10 = getExt(r7);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurUvOffset");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r10, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurUvOffset", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurUvOffset", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void setWindowBackgroundBlurOffset(View r7, int r8, int r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        Object r10 = getExt(r7);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurOffset");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r10, new Object[]{Integer.valueOf(r8), Integer.valueOf(r9)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurOffset", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurOffset", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void disableAutoDrawWindowBackgroundBlur(View r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Object r5 = getExt(r4);
        Method r0 = METH0D_CACHE.get("disableAutoDrawWindowBackgroundBlur");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r5, new Object[0]);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "disableAutoDrawWindowBackgroundBlur", new Class[0]);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("disableAutoDrawWindowBackgroundBlur", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static WindowBackgroundBlurDrawable makeWindowBackgroundDrawable(float r7) {
        Method r0 = METH0D_CACHE.get("makeWindowBackgroundBlurDrawable");
        if (r0 == null) goto L14;
    L5:
        return new WindowBackgroundBlurDrawable(r0.invoke(null, new Object[]{Float.valueOf(r7)}));
    L7:
        e = move-exception;
        e.printStackTrace();
    L13:
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L14:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "makeWindowBackgroundBlurDrawable", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        METH0D_CACHE.put("makeWindowBackgroundBlurDrawable", r0);     // Catch: ClassNotFoundException -> L7 InvocationTargetException -> L9 Throwable -> L11
        goto L5
    }

    public static void setWindowBackgroundBlurDrawable(View r6, WindowBackgroundBlurDrawable r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurDrawable");
        if (r0 == null) goto L20;
    L7:
        Object[] r1 = new Object[1];     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        if (r7 == null) goto L10;
        Object r9 = WindowBackgroundBlurDrawable.access$100(r7);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
    L11:
        r1[0] = r9;     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        r0.invoke(r8, r1);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L24:
        return;
    L10:
        r9 = null;
        goto L11
    L20:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurDrawable", new Class[]{Class.forName("android.view.WindowBackgroundDrawable")});     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        METH0D_CACHE.put("setWindowBackgroundBlurDrawable", r0);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        goto L7
    }

    public static WindowBackgroundBlurDrawable getWindowBackgroundBlurDrawable(View r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        Object r6 = getExt(r5);
        Method r1 = METH0D_CACHE.get("getWindowBackgroundBlurDrawable");
        if (r1 == null) goto L20;
    L8:
        Object r7 = r1.invoke(r6, new Object[0]);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        if (r7 == null) goto L22;
    L13:
        e = move-exception;
        e.printStackTrace();
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L12:
        return new WindowBackgroundBlurDrawable(r7);
    L22:
        return null;
    L20:
        r1 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "getWindowBackgroundBlurDrawable", new Class[0]);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        r1.setAccessible(true);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        METH0D_CACHE.put("getWindowBackgroundBlurDrawable", r1);     // Catch: ClassNotFoundException -> L13 InvocationTargetException -> L15 Throwable -> L17
        goto L8
    }

    public static void setWindowBackgroundBlurSaturation(View r6, float r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurSaturation");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r8, new Object[]{Float.valueOf(r7)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurSaturation", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurSaturation", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void setWindowBackgroundBlurBrightness(View r6, float r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurBrightness");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r8, new Object[]{Float.valueOf(r7)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurBrightness", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurBrightness", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void setWindowBackgroundBlurColor(View r6, int r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurColor");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r8, new Object[]{Integer.valueOf(r7)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurColor", new Class[]{Integer.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurColor", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    public static void setWindowBackgroundBlurHue(View r6, float r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        Object r8 = getExt(r6);
        Method r0 = METH0D_CACHE.get("setWindowBackgroundBlurHue");
        if (r0 == null) goto L16;
    L7:
        r0.invoke(r8, new Object[]{Float.valueOf(r7)});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        return;
    L16:
        r0 = NativeReflect.getDeclaredMethod(Class.forName(OMaterialHelper.IEXT_VIEW), "setWindowBackgroundBlurHue", new Class[]{Float.TYPE});     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        r0.setAccessible(true);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        METH0D_CACHE.put("setWindowBackgroundBlurHue", r0);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 Throwable -> L13
        goto L7
    }

    private static Object getExt(View r4) {
        Method r0 = METH0D_CACHE.get("getExt");
        if (r0 == null) goto L13;
    L5:
        return r0.invoke(r4, new Object[0]);
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        r0 = NativeReflect.getDeclaredMethod(View.class, "getExt", new Class[0]);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        r0.setAccessible(true);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        METH0D_CACHE.put("getExt", r0);     // Catch: InvocationTargetException -> L7 Throwable -> L9
        goto L5
    }
}
