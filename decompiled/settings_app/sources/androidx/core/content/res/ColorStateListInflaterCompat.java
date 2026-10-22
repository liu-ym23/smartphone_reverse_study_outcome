package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.math.MathUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    static {
        sTempTypedValue = new ThreadLocal();
    }

    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList inflate(Resources r0, int r1, Resources.Theme r2) {
        return createFromXml(r0, r0.getXml(r1), r2);
    L4:
        e = move-exception;
        Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
        return null;
    }

    public static ColorStateList createFromXml(Resources r4, XmlPullParser r5, Resources.Theme r6) throws XmlPullParserException, IOException {
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

    public static ColorStateList createFromXmlInner(Resources r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) throws XmlPullParserException, IOException {
        String r0 = r3.getName();
        if (r0.equals("selector") == false) goto L7;
        return inflate(r2, r3, r4, r5);
    L7:
        throw new XmlPullParserException(r3.getPositionDescription() + ": invalid color state list tag " + r0);
    }

    private static ColorStateList inflate(Resources r17, XmlPullParser r18, AttributeSet r19, Resources.Theme r20) throws XmlPullParserException, IOException {
        int r4 = 1;
        int r3 = r18.getDepth() + 1;
        int[][] r6 = new int[20][];
        int[] r5 = new int[20];
        int r8 = 0;
    L3:
        int r9 = r18.next();
        if (r9 == r4) goto L51;
        int r10 = r18.getDepth();
        if (r10 >= r3) goto L10;
        if (r9 == 3) goto L51;
    L10:
        if (r9 != 2) goto L50;
        if (r10 > r3) goto L50;
        if (r18.getName().equals("item") == false) goto L50;
        TypedArray r11 = obtainAttributes(r17, r20, r19, R.styleable.ColorStateListItem);
        int r12 = r11.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
        if (r12 != (-1)) goto L18;
    L22:
        int r13 = r11.getColor(R.styleable.ColorStateListItem_android_color, -65281);
    L23:
        float r14 = 1.0f;
        if (r11.hasValue(R.styleable.ColorStateListItem_android_alpha) == false) goto L27;
        r14 = r11.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
    L30:
        if (r11.hasValue(R.styleable.ColorStateListItem_android_lStar) == false) goto L32;
        float r15 = r11.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f);
    L33:
        r11.recycle();
        int r16 = r19.getAttributeCount();
        int[] r110 = new int[r16];
        int r111 = 0;
        int r112 = 0;
    L34:
        if (r111 >= r16) goto L49;
        int r7 = r19.getAttributeNameResource(r111);
        if (r7 == 16843173) goto L48;
        if (r7 == 16843551) goto L48;
        if (r7 == R.attr.alpha) goto L48;
        if (r7 == R.attr.lStar) goto L48;
        int r21 = r112 + 1;
        if (r19.getAttributeBooleanValue(r111, false) == true) goto L47;
        r7 = -r7;
    L47:
        r110[r112] = r7;
        r112 = r21;
    L48:
        r111 = r111 + 1;
        goto L34
    L49:
        int[] r0 = StateSet.trimStateSet(r110, r112);
        r5 = GrowingArrayUtils.append(r5, r8, modulateColorAlpha(r13, r14, r15));
        r6 = (int[][]) GrowingArrayUtils.append(r6, r8, r0);
        r8 = r8 + 1;
        goto L50
    L32:
        r15 = r11.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f);
        goto L33
    L27:
        if (r11.hasValue(R.styleable.ColorStateListItem_alpha) == false) goto L30;
        r14 = r11.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
        goto L30
    L18:
        if (isColorInt(r17, r12) == true) goto L22;
        r13 = createFromXml(r17, r17.getXml(r12), r20).getDefaultColor();     // Catch: Exception -> L21
    L21:
        r13 = r11.getColor(R.styleable.ColorStateListItem_android_color, -65281);
    L50:
        r4 = 1;
    L51:
        int[] r1 = new int[r8];
        int[][] r2 = new int[r8][];
        System.arraycopy(r5, 0, r1, 0, r8);
        System.arraycopy(r6, 0, r2, 0, r8);
        return new ColorStateList(r2, r1);
    }

    private static boolean isColorInt(Resources r2, int r3) {
        TypedValue r0 = getTypedValue();
        r2.getValue(r3, r0, true);
        if (r0.type >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r0.type > 31) goto L7;
        return true;
    }

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

    private static TypedArray obtainAttributes(Resources r0, Resources.Theme r1, AttributeSet r2, int[] r3) {
        if (r1 != null) goto L5;
        return r0.obtainAttributes(r2, r3);
    L5:
        return r1.obtainStyledAttributes(r2, r3, 0, 0);
    }

    private static int modulateColorAlpha(int r3, float r4, float r5) {
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
        return (r3 & 16777215) | (r6 << 24);
    L5:
        if (r5 > 100.0f) goto L7;
        r0 = true;
        goto L9
    }
}
