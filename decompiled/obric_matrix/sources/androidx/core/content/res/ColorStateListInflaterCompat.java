package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    static {
        sTempTypedValue = new ThreadLocal();
    }

    private ColorStateListInflaterCompat() {
    }

    @NonNull
    public static ColorStateList createFromXml(@NonNull Resources r4, @NonNull XmlPullParser r5, @Nullable Resources.Theme r6) {
        AttributeSet r0 = Xml.asAttributeSet(r5);
    L3:
        int r1 = r5.next();
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L3;
    L8:
        if (r1 != 2) goto L12;
        return createFromXmlInner(r4, r5, r0, r6);
    L12:
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static ColorStateList createFromXmlInner(@NonNull Resources r2, @NonNull XmlPullParser r3, @NonNull AttributeSet r4, @Nullable Resources.Theme r5) {
        String r0 = r3.getName();
        if (r0.equals("selector") == false) goto L7;
        return inflate(r2, r3, r4, r5);
    L7:
        throw new XmlPullParserException(r3.getPositionDescription() + ": invalid color state list tag " + r0);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r0 = sTempTypedValue;
        TypedValue r1 = r0.get();
        if (r1 != null) goto L6;
        TypedValue r2 = new TypedValue();
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }

    @Nullable
    public static ColorStateList inflate(@NonNull Resources r0, @XmlRes int r1, @Nullable Resources.Theme r2) {
        return createFromXml(r0, r0.getXml(r1), r2);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    private static ColorStateList inflate(@NonNull Resources r17, @NonNull XmlPullParser r18, @NonNull AttributeSet r19, @Nullable Resources.Theme r20) {
        int r4 = 1;
        int r3 = r18.getDepth() + 1;
        int[][] r6 = new int[20][];
        int[] r5 = new int[20];
        int r8 = 0;
    L3:
        int r9 = r18.next();
        if (r9 == r4) goto L53;
        int r10 = r18.getDepth();
        if (r10 >= r3) goto L10;
        if (r9 == 3) goto L53;
    L10:
        if (r9 != 2) goto L52;
        if (r10 > r3) goto L52;
        if (r18.getName().equals("item") == false) goto L52;
        TypedArray r11 = obtainAttributes(r17, r20, r19, R.styleable.ColorStateListItem);
        int r12 = R.styleable.ColorStateListItem_android_color;
        int r13 = r11.getResourceId(r12, -1);
        if (r13 != (-1)) goto L18;
    L22:
        int r14 = r11.getColor(r12, -65281);
    L23:
        float r15 = 1.0f;
        int r16 = R.styleable.ColorStateListItem_android_alpha;
        if (r11.hasValue(r16) == false) goto L26;
    L25:
        r15 = r11.getFloat(r16, 1.0f);
    L30:
        if (Build.VERSION.SDK_INT < 31) goto L34;
        int r110 = R.styleable.ColorStateListItem_android_lStar;
        if (r11.hasValue(r110) == false) goto L34;
    L35:
        float r111 = r11.getFloat(r110, -1.0f);
        r11.recycle();
        int r21 = r19.getAttributeCount();
        int[] r112 = new int[r21];
        int r113 = 0;
        int r114 = 0;
    L36:
        if (r113 >= r21) goto L51;
        int r7 = r19.getAttributeNameResource(r113);
        if (r7 == 16843173) goto L50;
        if (r7 == 16843551) goto L50;
        if (r7 == R.attr.alpha) goto L50;
        if (r7 == R.attr.lStar) goto L50;
        int r22 = r114 + 1;
        if (r19.getAttributeBooleanValue(r113, false) == true) goto L49;
        r7 = -r7;
    L49:
        r112[r114] = r7;
        r114 = r22;
    L50:
        r113 = r113 + 1;
        goto L36
    L51:
        int[] r0 = StateSet.trimStateSet(r112, r114);
        r5 = GrowingArrayUtils.append(r5, r8, modulateColorAlpha(r14, r15, r111));
        r6 = (int[][]) GrowingArrayUtils.append(r6, r8, r0);
        r8 = r8 + 1;
    L34:
        r110 = R.styleable.ColorStateListItem_lStar;
        goto L35
    L26:
        r16 = R.styleable.ColorStateListItem_alpha;
        if (r11.hasValue(r16) == false) goto L30;
    L18:
        if (isColorInt(r17, r13) == true) goto L22;
        r14 = createFromXml(r17, r17.getXml(r13), r20).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r12 = R.styleable.ColorStateListItem_android_color;
    L52:
        r4 = 1;
    L53:
        int[] r1 = new int[r8];
        int[][] r2 = new int[r8][];
        System.arraycopy(r5, 0, r1, 0, r8);
        System.arraycopy(r6, 0, r2, 0, r8);
        return new ColorStateList(r2, r1);
    }

    private static boolean isColorInt(@NonNull Resources r2, @ColorRes int r3) {
        TypedValue r0 = getTypedValue();
        r2.getValue(r3, r0, true);
        int r4 = r0.type;
        if (r4 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r4 > 31) goto L7;
        return true;
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int r3, @FloatRange(from = 0.0d, to = 1.0d) float r4, @FloatRange(from = 0.0d, to = 100.0d) float r5) {
        if (r5 >= 0.0f) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r4 != 1.0f) goto L12;
        if (r0 == true) goto L12;
        return r3;
    L12:
        int r6 = MathUtils.clamp((int) ((Color.alpha(r3) * r4) + 0.5f), 0, 255);
        if (r0 == false) goto L16;
        CamColor r7 = CamColor.fromColor(r3);
        r3 = CamColor.toColor(r7.getHue(), r7.getChroma(), r5);
    L16:
        return (r3 & ViewCompat.MEASURED_SIZE_MASK) | (r6 << 24);
    L5:
        if (r5 > 100.0f) goto L7;
        r0 = true;
        goto L9
    }

    private static TypedArray obtainAttributes(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L5;
        return r0.obtainAttributes(r2, r3);
    L5:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }
}
