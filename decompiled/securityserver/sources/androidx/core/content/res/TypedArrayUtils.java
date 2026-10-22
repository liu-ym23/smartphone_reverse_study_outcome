package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@NonNull Context r2, int r3, int r4) {
        TypedValue r0 = new TypedValue();
        r2.getTheme().resolveAttribute(r3, r0, true);
        if (r0.resourceId == 0) goto L5;
        return r3;
    L5:
        return r4;
    }

    public static boolean getBoolean(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2, boolean r3) {
        return r0.getBoolean(r1, r0.getBoolean(r2, r3));
    }

    @Nullable
    public static Drawable getDrawable(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2) {
        Drawable r3 = r0.getDrawable(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getDrawable(r2);
    }

    public static int getInt(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2, int r3) {
        return r0.getInt(r1, r0.getInt(r2, r3));
    }

    public static boolean getNamedBoolean(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3, boolean r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getBoolean(r3, r4);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3, @ColorInt int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getColor(r3, r4);
    }

    @Nullable
    public static ColorStateList getNamedColorStateList(@NonNull TypedArray r1, @NonNull XmlPullParser r2, @Nullable Resources.Theme r3, @NonNull String r4, @StyleableRes int r5) {
        if (hasAttribute(r2, r4) == false) goto L16;
        TypedValue r6 = new TypedValue();
        r1.getValue(r5, r6);
        int r7 = r6.type;
        if (r7 == 2) goto L15;
        if (r7 < 28) goto L13;
        if (r7 > 31) goto L13;
        return getNamedColorStateListFromInt(r6);
    L13:
        return ColorStateListInflaterCompat.inflate(r1.getResources(), r1.getResourceId(r5, 0), r3);
    L15:
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + r5 + ": " + r6);
    L16:
        return null;
    }

    @NonNull
    private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue r0) {
        return ColorStateList.valueOf(r0.data);
    }

    public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray r1, @NonNull XmlPullParser r2, @Nullable Resources.Theme r3, @NonNull String r4, @StyleableRes int r5, @ColorInt int r6) {
        if (hasAttribute(r2, r4) == false) goto L14;
        TypedValue r7 = new TypedValue();
        r1.getValue(r5, r7);
        int r8 = r7.type;
        if (r8 >= 28) goto L7;
    L10:
        ComplexColorCompat r9 = ComplexColorCompat.inflate(r1.getResources(), r1.getResourceId(r5, 0), r3);
        if (r9 == null) goto L14;
        return r9;
    L7:
        if (r8 > 31) goto L10;
        return ComplexColorCompat.from(r7.data);
    L14:
        return ComplexColorCompat.from(r6);
    }

    public static float getNamedFloat(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3, float r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getFloat(r3, r4);
    }

    public static int getNamedInt(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3, int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getInt(r3, r4);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3, @AnyRes int r4) {
        if (hasAttribute(r1, r2) == true) goto L6;
        return r4;
    L6:
        return r0.getResourceId(r3, r4);
    }

    @Nullable
    public static String getNamedString(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, @StyleableRes int r3) {
        if (hasAttribute(r1, r2) == true) goto L7;
        return null;
    L7:
        return r0.getString(r3);
    }

    @AnyRes
    public static int getResourceId(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2, @AnyRes int r3) {
        return r0.getResourceId(r1, r0.getResourceId(r2, r3));
    }

    @Nullable
    public static String getString(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2) {
        String r3 = r0.getString(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getString(r2);
    }

    @Nullable
    public static CharSequence getText(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2) {
        CharSequence r3 = r0.getText(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getText(r2);
    }

    @Nullable
    public static CharSequence[] getTextArray(@NonNull TypedArray r0, @StyleableRes int r1, @StyleableRes int r2) {
        CharSequence[] r3 = r0.getTextArray(r1);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return r0.getTextArray(r2);
    }

    public static boolean hasAttribute(@NonNull XmlPullParser r1, @NonNull String r2) {
        if (r1.getAttributeValue(NAMESPACE, r2) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NonNull
    public static TypedArray obtainAttributes(@NonNull Resources r0, @Nullable Resources.Theme r1, @NonNull AttributeSet r2, @NonNull int[] r3) {
        if (r1 != null) goto L6;
        return r0.obtainAttributes(r2, r3);
    L6:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }

    @Nullable
    public static TypedValue peekNamedValue(@NonNull TypedArray r0, @NonNull XmlPullParser r1, @NonNull String r2, int r3) {
        if (hasAttribute(r1, r2) == true) goto L7;
        return null;
    L7:
        return r0.peekValue(r3);
    }
}
