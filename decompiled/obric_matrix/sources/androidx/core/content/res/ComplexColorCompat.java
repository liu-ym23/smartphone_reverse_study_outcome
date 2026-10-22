package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat {
    private static final String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final ColorStateList mColorStateList;
    private final Shader mShader;

    private ComplexColorCompat(Shader r1, ColorStateList r2, @ColorInt int r3) {
        this.mShader = r1;
        this.mColorStateList = r2;
        this.mColor = r3;
    }

    @NonNull
    private static ComplexColorCompat createFromXml(@NonNull Resources r4, @ColorRes int r5, @Nullable Resources.Theme r6) {
        XmlResourceParser r7 = r4.getXml(r5);
        AttributeSet r0 = Xml.asAttributeSet(r7);
    L3:
        int r1 = r7.next();
        if (r1 == 2) goto L8;
        if (r1 != 1) goto L3;
    L8:
        if (r1 != 2) goto L20;
        String r2 = r7.getName();
        r2.hashCode();
        if (r2.equals("gradient") == true) goto L18;
        if (r2.equals("selector") == false) goto L16;
        return from(ColorStateListInflaterCompat.createFromXmlInner(r4, r7, r0, r6));
    L16:
        throw new XmlPullParserException(r7.getPositionDescription() + ": unsupported complex color tag " + r2);
    L18:
        return from(GradientColorInflaterCompat.createFromXmlInner(r4, r7, r0, r6));
    L20:
        throw new XmlPullParserException("No start tag found");
    }

    static ComplexColorCompat from(@ColorInt int r2) {
        return new ComplexColorCompat(null, null, r2);
    }

    static ComplexColorCompat from(@NonNull ColorStateList r3) {
        return new ComplexColorCompat(null, r3, r3.getDefaultColor());
    }

    static ComplexColorCompat from(@NonNull Shader r3) {
        return new ComplexColorCompat(r3, null, 0);
    }

    @Nullable
    public static ComplexColorCompat inflate(@NonNull Resources r0, @ColorRes int r1, @Nullable Resources.Theme r2) {
        return createFromXml(r0, r1, r2);
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to inflate ComplexColor.", e);
        return null;
    }

    @ColorInt
    public int getColor() {
        return this.mColor;
    }

    @Nullable
    public Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        if (this.mShader == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStateful() {
        if (this.mShader != null) goto L9;
        ColorStateList r1 = this.mColorStateList;
        if (r1 == null) goto L9;
        if (r1.isStateful() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onStateChanged(int[] r3) {
        if (isStateful() == false) goto L7;
        ColorStateList r0 = this.mColorStateList;
        int r4 = r0.getColorForState(r3, r0.getDefaultColor());
        if (r4 == this.mColor) goto L7;
        this.mColor = r4;
        return true;
    L7:
        return false;
    }

    public void setColor(@ColorInt int r1) {
        this.mColor = r1;
    }

    public boolean willDraw() {
        if (isGradient() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mColor != 0) goto L8;
        return false;
    }
}
