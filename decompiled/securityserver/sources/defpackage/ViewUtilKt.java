package defpackage;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ViewUtilKt {

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[AnimationProperty.FloatProperty.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            r0[3] = 4;
            r0[4] = 5;
            r0[7] = 6;
            r0[8] = 7;
            r0[5] = 8;
            r0[6] = 9;
            r0[9] = 10;
            int[] r1 = new int[AnimationProperty.IntProperty.values().length];
            r1[0] = 1;
            r1[1] = 2;
            r1[2] = 3;
            r1[3] = 4;
            r1[4] = 5;
            r1[5] = 6;
            int[] r2 = new int[AnimationProperty.IntProperty.values().length];
            r2[0] = 1;
            r2[1] = 2;
            r2[2] = 3;
            r2[3] = 4;
        }
    }

    public static final String a(String r2) {
        if (r2.length() <= 0) goto L6;
        StringBuilder r0 = new StringBuilder("set");
        r0.append(Character.toUpperCase(r2.charAt(0)));
        String r3 = r2.substring(1);
        Intrinsics.e(r3, "this as java.lang.String).substring(startIndex)");
        r0.append(r3);
        return r0.toString();
    L6:
        return r2;
    }

    public static final void b(View r2, String r3, Object r4) {
        Intrinsics.f(r3, "propertyName");
        Intrinsics.f(r4, "value");
        if (r3.equals("x") == false) goto L8;
        if ((r4 instanceof Float) == false) goto L128;
        r2.setX(((Number) r4).floatValue());
        return;
    L128:
        return;
    L8:
        if (r3.equals("y") == false) goto L13;
        if ((r4 instanceof Float) == false) goto L130;
        r2.setY(((Number) r4).floatValue());
        return;
    L130:
        return;
    L13:
        if (r3.equals("alpha") == false) goto L18;
        if ((r4 instanceof Float) == false) goto L132;
        r2.setAlpha(((Number) r4).floatValue());
        return;
    L132:
        return;
    L18:
        if (r3.equals(Key.ROTATION) == false) goto L23;
        if ((r4 instanceof Float) == false) goto L134;
        r2.setRotation(((Number) r4).floatValue());
        return;
    L134:
        return;
    L23:
        if (r3.equals("scaleX") == false) goto L28;
        if ((r4 instanceof Float) == false) goto L136;
        r2.setScaleX(((Number) r4).floatValue());
        return;
    L136:
        return;
    L28:
        if (r3.equals("scaleY") == false) goto L33;
        if ((r4 instanceof Float) == false) goto L138;
        r2.setScaleY(((Number) r4).floatValue());
        return;
    L138:
        return;
    L33:
        if (r3.equals("translationX") == false) goto L38;
        if ((r4 instanceof Float) == false) goto L140;
        r2.setTranslationX(((Number) r4).floatValue());
        return;
    L140:
        return;
    L38:
        if (r3.equals("translationY") == false) goto L43;
        if ((r4 instanceof Float) == false) goto L142;
        r2.setTranslationY(((Number) r4).floatValue());
        return;
    L142:
        return;
    L43:
        if (r3.equals("rotationX") == false) goto L48;
        if ((r4 instanceof Float) == false) goto L144;
        r2.setRotationX(((Number) r4).floatValue());
        return;
    L144:
        return;
    L48:
        if (r3.equals("rotationY") == false) goto L53;
        if ((r4 instanceof Float) == false) goto L146;
        r2.setRotationY(((Number) r4).floatValue());
        return;
    L146:
        return;
    L53:
        if (r3.equals("scale") == false) goto L58;
        if ((r4 instanceof Float) == false) goto L148;
        Number r5 = (Number) r4;
        r2.setScaleX(r5.floatValue());
        r2.setScaleY(r5.floatValue());
        return;
    L148:
        return;
    L58:
        if (r3.equals("backgroundColor") == false) goto L63;
        if ((r4 instanceof Integer) == false) goto L150;
        r2.setBackgroundColor(((Number) r4).intValue());
        return;
    L150:
        return;
    L63:
        if (r3.equals("textColor") == false) goto L70;
        if ((r2 instanceof TextView) == true) goto L67;
        return;
    L67:
        if ((r4 instanceof Integer) == false) goto L153;
        ((TextView) r2).setTextColor(((Number) r4).intValue());
        return;
    L153:
        return;
    L70:
        if (r3.equals("strokeColor") == false) goto L79;
        if ((r4 instanceof Integer) == false) goto L155;
        Drawable r6 = r2.getBackground();
        if ((r6 instanceof ShapeDrawable) == false) goto L156;
        Paint r7 = ((ShapeDrawable) r6).getPaint();
        Intrinsics.e(r7, "paint");
        if (r7.getStyle() != Paint.Style.STROKE) goto L157;
        r7.setColor(((Number) r4).intValue());
        r2.invalidate();
        return;
    L157:
        return;
    L156:
        return;
    L155:
        return;
    L79:
        if (r3.equals("fillColor") == true) goto L81;
        int r1 = 0;
        if (r3.equals("width") == false) goto L98;
        if ((r4 instanceof Integer) == false) goto L163;
        ViewGroup.LayoutParams r8 = r2.getLayoutParams();
        if ((r8 instanceof ViewGroup.LayoutParams) == false) goto L164;
        Number r9 = (Number) r4;
        if (r9.intValue() <= 0) goto L96;
        r1 = r9.intValue();
    L96:
        r8.width = r1;
        r2.setLayoutParams(r8);
        r2.requestLayout();
        return;
    L164:
        return;
    L163:
        return;
    L98:
        if (r3.equals("height") == true) goto L100;
        String r10 = a(r3);     // Catch: Exception -> L110 NoSuchMethodException -> L112
        if ((r4 instanceof Integer) == false) goto L115;
        Class<?> r0 = Integer.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L121:
        Method r11 = r2.getClass().getMethod(r10, new Class[]{r0});     // Catch: Exception -> L110 NoSuchMethodException -> L112
        Intrinsics.e(r11, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L110 NoSuchMethodException -> L112
        r11.invoke(r2, new Object[]{r4});     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L170:
        return;
    L115:
        if ((r4 instanceof Float) == false) goto L118;
        r0 = Float.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L118:
        if ((r4 instanceof Boolean) == false) goto L120;
        r0 = Boolean.TYPE;     // Catch: Exception -> L110 NoSuchMethodException -> L112
        goto L121
    L120:
        r0 = r4.getClass();     // Catch: Exception -> L110 NoSuchMethodException -> L112
    L112:
        e = move-exception;
        e.printStackTrace();
        return;
    L110:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if ((r4 instanceof Integer) == false) goto L166;
        ViewGroup.LayoutParams r12 = r2.getLayoutParams();
        if ((r12 instanceof ViewGroup.LayoutParams) == false) goto L167;
        Number r13 = (Number) r4;
        if (r13.intValue() <= 0) goto L106;
        r1 = r13.intValue();
    L106:
        r12.height = r1;
        r2.setLayoutParams(r12);
        r2.requestLayout();
        return;
    L167:
        return;
    L166:
        return;
    L81:
        if ((r4 instanceof Integer) == false) goto L159;
        Drawable r14 = r2.getBackground();
        if ((r14 instanceof ShapeDrawable) == false) goto L160;
        Paint r15 = ((ShapeDrawable) r14).getPaint();
        Intrinsics.e(r15, "paint");
        if (r15.getStyle() != Paint.Style.FILL) goto L161;
        r15.setColor(((Number) r4).intValue());
        r2.invalidate();
        return;
    L161:
        return;
    L160:
        return;
    }
}
