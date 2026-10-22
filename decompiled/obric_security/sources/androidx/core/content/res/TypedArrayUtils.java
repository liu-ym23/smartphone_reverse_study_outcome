package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static boolean hasAttribute(XmlPullParser r1, String r2) {
        if (r1.getAttributeValue(NAMESPACE, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static float getNamedFloat(TypedArray r0, XmlPullParser r1, String r2, int r3, float r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getFloat(r3, r4);
    }

    public static boolean getNamedBoolean(TypedArray r0, XmlPullParser r1, String r2, int r3, boolean r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getBoolean(r3, r4);
    }

    public static int getNamedInt(TypedArray r0, XmlPullParser r1, String r2, int r3, int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getInt(r3, r4);
    }

    public static int getNamedColor(TypedArray r0, XmlPullParser r1, String r2, int r3, int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getColor(r3, r4);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray r1, XmlPullParser r2, Resources.Theme r3, String r4, int r5, int r6) {
        if (hasAttribute(r2, r4) == false) goto L14;
        TypedValue r7 = new TypedValue();
        r1.getValue(r5, r7);
        if (r7.type >= 28) goto L7;
    L10:
        ComplexColorCompat r8 = ComplexColorCompat.inflate(r1.getResources(), r1.getResourceId(r5, 0), r3);
        if (r8 == null) goto L14;
        return r8;
    L7:
        if (r7.type > 31) goto L10;
        return ComplexColorCompat.from(r7.data);
    L14:
        return ComplexColorCompat.from(r6);
    }

    public static ColorStateList getNamedColorStateList(TypedArray r1, XmlPullParser r2, Resources.Theme r3, String r4, int r5) {
        if (hasAttribute(r2, r4) == false) goto L16;
        TypedValue r6 = new TypedValue();
        r1.getValue(r5, r6);
        if (r6.type == 2) goto L15;
        if (r6.type < 28) goto L13;
        if (r6.type > 31) goto L13;
        return getNamedColorStateListFromInt(r6);
    L13:
        return ColorStateListInflaterCompat.inflate(r1.getResources(), r1.getResourceId(r5, 0), r3);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r5 + ": " + r6);
    L16:
        return null;
    }

    private static ColorStateList getNamedColorStateListFromInt(TypedValue r0) {
        return ColorStateList.valueOf(r0.data);
    }

    public static int getNamedResourceId(TypedArray r0, XmlPullParser r1, String r2, int r3, int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getResourceId(r3, r4);
    }

    public static String getNamedString(TypedArray r0, XmlPullParser r1, String r2, int r3) {
        if (hasAttribute(r1, r2) == true) goto L7;
        return null;
    L7:
        return r0.getString(r3);
    }

    public static TypedValue peekNamedValue(TypedArray r0, XmlPullParser r1, String r2, int r3) {
        if (hasAttribute(r1, r2) == true) goto L7;
        return null;
    L7:
        return r0.peekValue(r3);
    }

    public static TypedArray obtainAttributes(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L6;
        return r0.obtainAttributes(r2, r3);
    L6:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }

    public static boolean getBoolean(TypedArray r0, int r1, int r2, boolean r3) {
        return r0.getBoolean(r1, r0.getBoolean(r2, r3));
    }

    public static Drawable getDrawable(TypedArray r0, int r1, int r2) {
        Drawable r3 = r0.getDrawable(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getDrawable(r2);
    }

    public static int getInt(TypedArray r0, int r1, int r2, int r3) {
        return r0.getInt(r1, r0.getInt(r2, r3));
    }

    public static int getResourceId(TypedArray r0, int r1, int r2, int r3) {
        return r0.getResourceId(r1, r0.getResourceId(r2, r3));
    }

    public static String getString(TypedArray r0, int r1, int r2) {
        String r3 = r0.getString(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getString(r2);
    }

    public static CharSequence getText(TypedArray r0, int r1, int r2) {
        CharSequence r3 = r0.getText(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getText(r2);
    }

    public static CharSequence[] getTextArray(TypedArray r0, int r1, int r2) {
        CharSequence[] r3 = r0.getTextArray(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getTextArray(r2);
    }

    public static int getAttr(Context r2, int r3, int r4) {
        TypedValue r0 = new TypedValue();
        r2.getTheme().resolveAttribute(r3, r0, true);
        if (r0.resourceId == 0) goto L5;
        return r3;
    L5:
        return r4;
    }

    private TypedArrayUtils() {
    }
}
