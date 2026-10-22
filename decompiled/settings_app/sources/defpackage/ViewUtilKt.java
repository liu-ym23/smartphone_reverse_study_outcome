package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t\u001a\u001a\u0010\r\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"buildMethodName", "", "propertyName", "buildSetterMethodName", "getPropertyValue", "", "Landroid/view/View;", "isValidColorValue", "", "", "setColorPropertyValue", "", "value", "setPropertyValue", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class ViewUtilKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;

        static {
            int[] r0 = new int[AnimationProperty.FloatProperty.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[AnimationProperty.FloatProperty.X.ordinal()] = 1;
            r0[AnimationProperty.FloatProperty.Y.ordinal()] = 2;
            r0[AnimationProperty.FloatProperty.SCALE_X.ordinal()] = 3;
            r0[AnimationProperty.FloatProperty.SCALE_Y.ordinal()] = 4;
            r0[AnimationProperty.FloatProperty.ROTATION.ordinal()] = 5;
            r0[AnimationProperty.FloatProperty.TRANSLATION_X.ordinal()] = 6;
            r0[AnimationProperty.FloatProperty.TRANSLATION_Y.ordinal()] = 7;
            r0[AnimationProperty.FloatProperty.ROTATION_X.ordinal()] = 8;
            r0[AnimationProperty.FloatProperty.ROTATION_Y.ordinal()] = 9;
            r0[AnimationProperty.FloatProperty.ALPHA.ordinal()] = 10;
            int[] r1 = new int[AnimationProperty.IntProperty.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[AnimationProperty.IntProperty.BACKGROUND_COLOR.ordinal()] = 1;
            r1[AnimationProperty.IntProperty.TEXT_COLOR.ordinal()] = 2;
            r1[AnimationProperty.IntProperty.STROKE_COLOR.ordinal()] = 3;
            r1[AnimationProperty.IntProperty.FILL_COLOR.ordinal()] = 4;
            r1[AnimationProperty.IntProperty.WIDTH.ordinal()] = 5;
            r1[AnimationProperty.IntProperty.HEIGHT.ordinal()] = 6;
            int[] r2 = new int[AnimationProperty.IntProperty.values().length];
            $EnumSwitchMapping$2 = r2;
            r2[AnimationProperty.IntProperty.BACKGROUND_COLOR.ordinal()] = 1;
            r2[AnimationProperty.IntProperty.TEXT_COLOR.ordinal()] = 2;
            r2[AnimationProperty.IntProperty.STROKE_COLOR.ordinal()] = 3;
            r2[AnimationProperty.IntProperty.FILL_COLOR.ordinal()] = 4;
        }
    }

    public static final Object getPropertyValue(View r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$getPropertyValue");
        Intrinsics.checkNotNullParameter(r8, "propertyName");
        AnimationProperty.FloatProperty[] r0 = AnimationProperty.FloatProperty.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L20;
        AnimationProperty.FloatProperty r4 = r0[r3];
        r3 = r3 + 1;
        if (Intrinsics.areEqual(r4.getPropertyName(), r8) == false) goto L3;
        switch(WhenMappings.$EnumSwitchMapping$0[r4.ordinal()]) {
            case 1: goto L19;
            case 2: goto L71;
            case 3: goto L70;
            case 4: goto L69;
            case 5: goto L68;
            case 6: goto L67;
            case 7: goto L66;
            case 8: goto L65;
            case 9: goto L64;
            case 10: goto L63;
            default: goto L62;
        };
    L62:
        return Unit.INSTANCE;
    L63:
        return Float.valueOf(r7.getAlpha());
    L64:
        return Float.valueOf(r7.getRotationY());
    L65:
        return Float.valueOf(r7.getRotationX());
    L66:
        return Float.valueOf(r7.getTranslationY());
    L67:
        return Float.valueOf(r7.getTranslationX());
    L68:
        return Float.valueOf(r7.getRotation());
    L69:
        return Float.valueOf(r7.getScaleY());
    L70:
        return Float.valueOf(r7.getScaleX());
    L71:
        return Float.valueOf(r7.getY());
    L19:
        return Float.valueOf(r7.getX());
    L20:
        AnimationProperty.IntProperty[] r2 = AnimationProperty.IntProperty.values();
        int r5 = r2.length;
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L55;
        AnimationProperty.IntProperty r9 = r2[r6];
        r6 = r6 + 1;
        if (Intrinsics.areEqual(r9.getPropertyName(), r8) == false) goto L22;
        switch(WhenMappings.$EnumSwitchMapping$1[r9.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L36;
            case 4: goto L31;
            case 5: goto L73;
            case 6: goto L72;
            default: goto L28;
        };
    L31:
        Drawable r10 = r7.getBackground();
        if ((r10 instanceof ShapeDrawable) == false) goto L74;
        Paint r11 = ((ShapeDrawable) r10).getPaint();
        Intrinsics.checkNotNullExpressionValue(r11, "paint");
        if (r11.getStyle() == Paint.Style.FILL) goto L76;
        return null;
    L76:
        return Integer.valueOf(r11.getColor());
    L74:
        return null;
    L36:
        Drawable r12 = r7.getBackground();
        if ((r12 instanceof ShapeDrawable) == false) goto L77;
        Paint r13 = ((ShapeDrawable) r12).getPaint();
        Intrinsics.checkNotNullExpressionValue(r13, "paint");
        if (r13.getStyle() == Paint.Style.STROKE) goto L79;
        return null;
    L79:
        return Integer.valueOf(r13.getColor());
    L77:
        return null;
    L44:
        Drawable r14 = r7.getBackground();
        if ((r14 instanceof ColorDrawable) == true) goto L47;
        return null;
    L47:
        return Integer.valueOf(((ColorDrawable) r14).getColor());
    L28:
        throw new NoWhenBranchMatchedException();
    L72:
        return Integer.valueOf(r7.getHeight());
    L73:
        return Integer.valueOf(r7.getWidth());
    L42:
        if ((r7 instanceof TextView) == false) goto L80;
        ColorStateList r15 = ((TextView) r7).getTextColors();
        Intrinsics.checkNotNullExpressionValue(r15, "this.textColors");
        return Integer.valueOf(r15.getDefaultColor());
    L80:
        return null;
    L55:
        Method r16 = r7.getClass().getMethod(buildMethodName(r8), new Class[0]);     // Catch: Exception -> L50 NoSuchMethodException -> L52
        Intrinsics.checkNotNullExpressionValue(r16, "this.javaClass.getMethod(methodName)");     // Catch: Exception -> L50 NoSuchMethodException -> L52
        return r16.invoke(r7, new Object[0]);
    L52:
        e = move-exception;
        e.printStackTrace();
    L54:
        return null;
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L54
    }

    public static final void setColorPropertyValue(View r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "$this$setColorPropertyValue");
        Intrinsics.checkNotNullParameter(r9, "propertyName");
        Log.d("AnimationManager", "Setting " + r9 + " to " + r10);
        AnimationProperty.IntProperty[] r1 = AnimationProperty.IntProperty.values();
        int r3 = r1.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L7;
        AnimationProperty.IntProperty r6 = r1[r5];
        r5 = r5 + 1;
        if (Intrinsics.areEqual(r6.getPropertyName(), r9) == false) goto L3;
    L9:
        if (r6 == null) goto L56;
        int r11 = WhenMappings.$EnumSwitchMapping$2[r6.ordinal()];
        if (r11 != 1) goto L28;
        r8.setBackgroundColor(r10);
        return;
    L28:
        if (r11 == 2) goto L51;
        if (r11 == 3) goto L43;
        if (r11 == 4) goto L35;
        return;
    L35:
        if ((r8.getBackground() instanceof ShapeDrawable) == true) goto L37;
        r8.setBackground(new ShapeDrawable(new RectShape()));
    L37:
        Drawable r12 = r8.getBackground();
        if (r12 == null) goto L41;
        Paint r13 = ((ShapeDrawable) r12).getPaint();
        Intrinsics.checkNotNullExpressionValue(r13, "paint");
        r13.setStyle(Paint.Style.FILL);
        r13.setColor(r10);
        return;
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
    L43:
        if ((r8.getBackground() instanceof ShapeDrawable) == true) goto L45;
        r8.setBackground(new ShapeDrawable(new RectShape()));
    L45:
        Drawable r14 = r8.getBackground();
        if (r14 == null) goto L49;
        Paint r15 = ((ShapeDrawable) r14).getPaint();
        Intrinsics.checkNotNullExpressionValue(r15, "paint");
        r15.setStyle(Paint.Style.STROKE);
        r15.setStrokeWidth(5.0f);
        r15.setColor(r10);
        return;
    L49:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.ShapeDrawable");
    L51:
        if ((r8 instanceof TextView) == false) goto L53;
        ((TextView) r8).setTextColor(r10);
        return;
    L53:
        Log.w("AnimationManager", "Cannot set textColor on non - TextView view.");
        return;
    L56:
        StringBuilder r4 = new StringBuilder().append("set");     // Catch: Exception -> L21 NoSuchMethodException -> L23
        if (r9.length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        char r16 = Character.toUpperCase(r9.charAt(0));     // Catch: Exception -> L21 NoSuchMethodException -> L23
        String r17 = r9.substring(1);     // Catch: Exception -> L21 NoSuchMethodException -> L23
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).substring(startIndex)");     // Catch: Exception -> L21 NoSuchMethodException -> L23
        String r18 = r16 + r17;     // Catch: Exception -> L21 NoSuchMethodException -> L23
    L17:
        Method r19 = r8.getClass().getMethod(r4.append(r18).toString(), new Class[]{Integer.TYPE});     // Catch: Exception -> L21 NoSuchMethodException -> L23
        if (r19 == null) goto L61;
        r19.invoke(r8, new Object[]{Integer.valueOf(r10)});     // Catch: Exception -> L21 NoSuchMethodException -> L23
    L68:
        return;
    L61:
        return;
    L16:
        r18 = "";
        goto L17
    L13:
        r7 = false;
    L23:
        e = move-exception;
        Log.w("AnimationManager", "No method found to set " + r9 + ": " + e.getMessage());
        return;
    L21:
        e = move-exception;
        Log.e("AnimationManager", "Error setting " + r9 + ": " + e.getMessage(), e);
        return;
    L7:
        r6 = null;
        goto L9
    }

    public static final void setPropertyValue(View r5, String r6, Object r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$setPropertyValue");
        Intrinsics.checkNotNullParameter(r6, "propertyName");
        Intrinsics.checkNotNullParameter(r7, "value");
        if (Intrinsics.areEqual(r6, MaterialConfigFormatNames.X) == false) goto L8;
        if ((r7 instanceof Float) == false) goto L126;
        r5.setX(((Number) r7).floatValue());
        return;
    L126:
        return;
    L8:
        if (Intrinsics.areEqual(r6, "y") == false) goto L13;
        if ((r7 instanceof Float) == false) goto L128;
        r5.setY(((Number) r7).floatValue());
        return;
    L128:
        return;
    L13:
        if (Intrinsics.areEqual(r6, "alpha") == false) goto L18;
        if ((r7 instanceof Float) == false) goto L130;
        r5.setAlpha(((Number) r7).floatValue());
        return;
    L130:
        return;
    L18:
        if (Intrinsics.areEqual(r6, "rotation") == false) goto L23;
        if ((r7 instanceof Float) == false) goto L132;
        r5.setRotation(((Number) r7).floatValue());
        return;
    L132:
        return;
    L23:
        if (Intrinsics.areEqual(r6, "scaleX") == false) goto L28;
        if ((r7 instanceof Float) == false) goto L134;
        r5.setScaleX(((Number) r7).floatValue());
        return;
    L134:
        return;
    L28:
        if (Intrinsics.areEqual(r6, "scaleY") == false) goto L33;
        if ((r7 instanceof Float) == false) goto L136;
        r5.setScaleY(((Number) r7).floatValue());
        return;
    L136:
        return;
    L33:
        if (Intrinsics.areEqual(r6, "translationX") == false) goto L38;
        if ((r7 instanceof Float) == false) goto L138;
        r5.setTranslationX(((Number) r7).floatValue());
        return;
    L138:
        return;
    L38:
        if (Intrinsics.areEqual(r6, "translationY") == false) goto L43;
        if ((r7 instanceof Float) == false) goto L140;
        r5.setTranslationY(((Number) r7).floatValue());
        return;
    L140:
        return;
    L43:
        if (Intrinsics.areEqual(r6, "rotationX") == false) goto L48;
        if ((r7 instanceof Float) == false) goto L142;
        r5.setRotationX(((Number) r7).floatValue());
        return;
    L142:
        return;
    L48:
        if (Intrinsics.areEqual(r6, "rotationY") == false) goto L53;
        if ((r7 instanceof Float) == false) goto L144;
        r5.setRotationY(((Number) r7).floatValue());
        return;
    L144:
        return;
    L53:
        if (Intrinsics.areEqual(r6, "scale") == false) goto L58;
        if ((r7 instanceof Float) == false) goto L146;
        Number r8 = (Number) r7;
        r5.setScaleX(r8.floatValue());
        r5.setScaleY(r8.floatValue());
        return;
    L146:
        return;
    L58:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L63;
        if ((r7 instanceof Integer) == false) goto L148;
        r5.setBackgroundColor(((Number) r7).intValue());
        return;
    L148:
        return;
    L63:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L70;
        if ((r5 instanceof TextView) == true) goto L67;
        return;
    L67:
        if ((r7 instanceof Integer) == false) goto L151;
        ((TextView) r5).setTextColor(((Number) r7).intValue());
        return;
    L151:
        return;
    L70:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L79;
        if ((r7 instanceof Integer) == false) goto L153;
        Drawable r9 = r5.getBackground();
        if ((r9 instanceof ShapeDrawable) == false) goto L154;
        Paint r10 = ((ShapeDrawable) r9).getPaint();
        Intrinsics.checkNotNullExpressionValue(r10, "paint");
        if (r10.getStyle() != Paint.Style.STROKE) goto L155;
        r10.setColor(((Number) r7).intValue());
        r5.invalidate();
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L79:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.FILL_COLOR.getPropertyName()) == true) goto L81;
        int r1 = 0;
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.WIDTH.getPropertyName()) == false) goto L98;
        if ((r7 instanceof Integer) == false) goto L161;
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof ViewGroup.LayoutParams) == false) goto L162;
        Number r12 = (Number) r7;
        if (r12.intValue() <= 0) goto L96;
        r1 = r12.intValue();
    L96:
        r11.width = r1;
        r5.setLayoutParams(r11);
        r5.requestLayout();
        return;
    L162:
        return;
    L161:
        return;
    L98:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.HEIGHT.getPropertyName()) == true) goto L100;
        String r13 = buildSetterMethodName(r6);     // Catch: Exception -> L119 NoSuchMethodException -> L121
        if ((r7 instanceof Integer) == false) goto L111;
        Class<?> r0 = Integer.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L117:
        Method r14 = r5.getClass().getMethod(r13, new Class[]{r0});     // Catch: Exception -> L119 NoSuchMethodException -> L121
        Intrinsics.checkNotNullExpressionValue(r14, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L119 NoSuchMethodException -> L121
        r14.invoke(r5, new Object[]{r7});     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L168:
        return;
    L111:
        if ((r7 instanceof Float) == false) goto L114;
        r0 = Float.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L114:
        if ((r7 instanceof Boolean) == false) goto L116;
        r0 = Boolean.TYPE;     // Catch: Exception -> L119 NoSuchMethodException -> L121
        goto L117
    L116:
        r0 = r7.getClass();     // Catch: Exception -> L119 NoSuchMethodException -> L121
    L121:
        e = move-exception;
        e.printStackTrace();
        return;
    L119:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        if ((r7 instanceof Integer) == false) goto L164;
        ViewGroup.LayoutParams r15 = r5.getLayoutParams();
        if ((r15 instanceof ViewGroup.LayoutParams) == false) goto L165;
        Number r16 = (Number) r7;
        if (r16.intValue() <= 0) goto L106;
        r1 = r16.intValue();
    L106:
        r15.height = r1;
        r5.setLayoutParams(r15);
        r5.requestLayout();
        return;
    L165:
        return;
    L164:
        return;
    L81:
        if ((r7 instanceof Integer) == false) goto L157;
        Drawable r17 = r5.getBackground();
        if ((r17 instanceof ShapeDrawable) == false) goto L158;
        Paint r18 = ((ShapeDrawable) r17).getPaint();
        Intrinsics.checkNotNullExpressionValue(r18, "paint");
        if (r18.getStyle() != Paint.Style.FILL) goto L159;
        r18.setColor(((Number) r7).intValue());
        r5.invalidate();
        return;
    L159:
        return;
    L158:
        return;
    }

    private static final String buildMethodName(String r4) {
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder("get").append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    private static final String buildSetterMethodName(String r4) {
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder("set").append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean isValidColorValue(int r5) {
        int r1 = Color.alpha(r5);     // Catch: Exception -> L19
        int r2 = Color.red(r5);     // Catch: Exception -> L19
        int r3 = Color.green(r5);     // Catch: Exception -> L19
        int r6 = Color.blue(r5);     // Catch: Exception -> L19
        if (r1 >= 0) goto L7;
        return false;
    L7:
        if (255 < r1) goto L22;
        if (r2 < 0) goto L27;
        if (255 < r2) goto L23;
        if (r3 < 0) goto L28;
        if (255 < r3) goto L24;
        if (r6 < 0) goto L29;
        if (255 >= r6) goto L18;
        return false;
    L18:
        return true;
    L29:
        return false;
    L24:
        return false;
    L28:
        return false;
    L23:
        return false;
    L27:
        return false;
    L22:
        return false;
    L30:
        return false;
    }
}
