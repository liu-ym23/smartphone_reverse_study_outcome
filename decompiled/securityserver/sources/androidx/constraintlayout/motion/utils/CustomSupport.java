package androidx.constraintlayout.motion.utils;

import a.a;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class CustomSupport {
    private static final String TAG = "CustomSupport";

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.CustomSupport$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r0 = new int[ConstraintAttribute.AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r0;
            r0[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public CustomSupport() {
    }

    private static int clamp(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public static void setInterpolatedValue(ConstraintAttribute r15, View r16, float[] r17) {
        Class<?> r5 = r16.getClass();
        String r6 = "set" + r15.getName();
        boolean r10 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r15.getType().ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L13;
            case 7: goto L6;
            default: goto L30;
        };     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L6:
        r5.getMethod(r6, new Class[]{Float.TYPE}).invoke(r16, new Object[]{Float.valueOf(r17[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L13:
        Method r0 = r5.getMethod(r6, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        if (r17[0] > 0.5f) goto L17;
        r10 = false;
    L17:
        r0.invoke(r16, new Object[]{Boolean.valueOf(r10)});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L20:
        Method r1 = r5.getMethod(r6, new Class[]{Integer.TYPE});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r7 = clamp((int) (((float) Math.pow(r17[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r8 = clamp((int) (((float) Math.pow(r17[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r1.invoke(r16, new Object[]{Integer.valueOf((((r7 << 16) | (clamp((int) (r17[3] * 255.0f)) << 24)) | (r8 << 8)) | clamp((int) (((float) Math.pow(r17[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L21:
        Method r2 = r5.getMethod(r6, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r9 = clamp((int) (((float) Math.pow(r17[0], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r11 = clamp((int) (((float) Math.pow(r17[1], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        int r12 = (((r9 << 16) | (clamp((int) (r17[3] * 255.0f)) << 24)) | (r11 << 8)) | clamp((int) (((float) Math.pow(r17[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        ColorDrawable r13 = new ColorDrawable();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r13.setColor(r12);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        r2.invoke(r16, new Object[]{r13});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L22:
        r5.getMethod(r6, new Class[]{Float.TYPE}).invoke(r16, new Object[]{Float.valueOf(r17[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L23:
        r5.getMethod(r6, new Class[]{Integer.TYPE}).invoke(r16, new Object[]{Integer.valueOf((int) r17[0])});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
        return;
    L30:
        return;
    L19:
        throw new RuntimeException("unable to interpolate strings " + r15.getName());     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 NoSuchMethodException -> L11
    L9:
        e = move-exception;
        StringBuilder r3 = a.u("cannot access method ", r6, " on View \"");
        r3.append(Debug.getName(r16));
        r3.append("\"");
        Log.e(TAG, r3.toString());
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        StringBuilder r4 = a.u("no method ", r6, " on View \"");
        r4.append(Debug.getName(r16));
        r4.append("\"");
        Log.e(TAG, r4.toString());
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
