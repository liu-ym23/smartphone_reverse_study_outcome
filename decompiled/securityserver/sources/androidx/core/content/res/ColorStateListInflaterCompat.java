package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.R;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat {
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

    @Nullable
    public static ColorStateList inflate(@NonNull Resources r0, @XmlRes int r1, @Nullable Resources.Theme r2) {
        return createFromXml(r0, r0.getXml(r1), r2);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    @ColorInt
    private static int modulateColorAlpha(@ColorInt int r1, @FloatRange(from = 0.0d, to = 1.0d) float r2) {
        return (r1 & ViewCompat.MEASURED_SIZE_MASK) | (Math.round(Color.alpha(r1) * r2) << 24);
    }

    private static TypedArray obtainAttributes(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L5;
        return r0.obtainAttributes(r2, r3);
    L5:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }

    private static ColorStateList inflate(@NonNull Resources r17, @NonNull XmlPullParser r18, @NonNull AttributeSet r19, @Nullable Resources.Theme r20) {
        int r2 = 1;
        int r1 = r18.getDepth() + 1;
        int[][] r4 = new int[20][];
        int[] r3 = new int[20];
        int r6 = 0;
    L3:
        int r7 = r18.next();
        if (r7 == r2) goto L37;
        int r8 = r18.getDepth();
        if (r8 >= r1) goto L10;
        if (r7 == 3) goto L37;
    L10:
        if (r7 != 2) goto L36;
        if (r8 > r1) goto L36;
        if (r18.getName().equals("item") == false) goto L36;
        TypedArray r9 = obtainAttributes(r17, r20, r19, R.styleable.ColorStateListItem);
        int r10 = r9.getColor(R.styleable.ColorStateListItem_android_color, -65281);
        float r12 = 1.0f;
        if (r9.hasValue(R.styleable.ColorStateListItem_android_alpha) == false) goto L19;
        r12 = r9.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
    L21:
        r9.recycle();
        int r11 = r19.getAttributeCount();
        int[] r13 = new int[r11];
        int r14 = 0;
        int r15 = 0;
    L22:
        if (r14 >= r11) goto L35;
        int r16 = r19.getAttributeNameResource(r14);
        if (r16 == 16843173) goto L34;
        if (r16 == 16843551) goto L34;
        if (r16 == R.attr.alpha) goto L34;
        int r5 = r15 + 1;
        if (r19.getAttributeBooleanValue(r14, false) == true) goto L33;
        r16 = -r16;
    L33:
        r13[r15] = r16;
        r15 = r5;
    L34:
        r14 = r14 + 1;
        goto L22
    L35:
        int[] r21 = StateSet.trimStateSet(r13, r15);
        r3 = GrowingArrayUtils.append(r3, r6, modulateColorAlpha(r10, r12));
        r4 = (int[][]) GrowingArrayUtils.append(r4, r6, r21);
        r6 = r6 + 1;
        goto L36
    L19:
        if (r9.hasValue(R.styleable.ColorStateListItem_alpha) == false) goto L21;
        r12 = r9.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
    L36:
        r2 = 1;
    L37:
        int[] r0 = new int[r6];
        int[][] r22 = new int[r6][];
        System.arraycopy(r3, 0, r0, 0, r6);
        System.arraycopy(r4, 0, r22, 0, r6);
        return new ColorStateList(r22, r0);
    }
}
