package com.obric.oui.constraintlayout.motion.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.Debug;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class CustomSupport {
    private static final boolean DEBUG = false;
    private static final String TAG = "CustomSupport";

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.utils.CustomSupport$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r0 = new int[ConstraintAttribute.AttributeType.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType = r0;
            r0[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public CustomSupport() {
    }

    public static void setInterpolatedValue(ConstraintAttribute r16, View r17, float[] r18) {
        Class<?> r5 = r17.getClass();
        String r6 = "set" + r16.getName();
        boolean r13 = true;
        switch(AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$widget$ConstraintAttribute$AttributeType[r16.getType().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L27;
        };     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L6:
        r5.getMethod(r6, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L7:
        Method r0 = r5.getMethod(r6, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        Object[] r7 = new Object[1];     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        if (r18[0] > 0.5f) goto L11;
        r13 = false;
    L11:
        r7[0] = Boolean.valueOf(r13);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r0.invoke(r17, r7);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L14:
        r5.getMethod(r6, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((((clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L15:
        Method r1 = r5.getMethod(r6, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        int r8 = (((clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        ColorDrawable r9 = new ColorDrawable();     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r9.setColor(r8);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r1.invoke(r17, new Object[]{r9});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L16:
        r5.getMethod(r6, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L17:
        r5.getMethod(r6, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L27:
        return;
    L13:
        throw new RuntimeException("unable to interpolate strings " + r16.getName());     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L21:
        e = move-exception;
        Log.e(TAG, "Cannot access method " + r6 + " on View \"" + Debug.getName(r17) + "\"", e);
        return;
    L23:
        e = move-exception;
        Log.e(TAG, "No method " + r6 + " on View \"" + Debug.getName(r17) + "\"", e);
        return;
    L19:
        e = move-exception;
        Log.e(TAG, "Cannot invoke method " + r6 + " on View \"" + Debug.getName(r17) + "\"", e);
    }
}
