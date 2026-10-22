package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    static class Api21Impl {
        private Api21Impl() {
        }

        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }

        static int getChangingConfigurations(TypedArray r0) {
            return r0.getChangingConfigurations();
        }
    }

    public static TintTypedArray obtainStyledAttributes(Context r1, AttributeSet r2, int[] r3) {
        return new TintTypedArray(r1, r1.obtainStyledAttributes(r2, r3));
    }

    public static TintTypedArray obtainStyledAttributes(Context r1, AttributeSet r2, int[] r3, int r4, int r5) {
        return new TintTypedArray(r1, r1.obtainStyledAttributes(r2, r3, r4, r5));
    }

    public static TintTypedArray obtainStyledAttributes(Context r1, int r2, int[] r3) {
        return new TintTypedArray(r1, r1.obtainStyledAttributes(r2, r3));
    }

    private TintTypedArray(Context r1, TypedArray r2) {
        this.mContext = r1;
        this.mWrapped = r2;
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public Drawable getDrawable(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L9;
        int r0 = this.mWrapped.getResourceId(r3, 0);
        if (r0 == 0) goto L9;
        return AppCompatResources.getDrawable(this.mContext, r0);
    L9:
        return this.mWrapped.getDrawable(r3);
    }

    public Drawable getDrawableIfKnown(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L8;
        int r4 = this.mWrapped.getResourceId(r3, 0);
        if (r4 != 0) goto L7;
        return null;
    L7:
        return AppCompatDrawableManager.get().getDrawable(this.mContext, r4, true);
    L8:
        return null;
    }

    public Typeface getFont(int r3, int r4, ResourcesCompat.FontCallback r5) {
        int r6 = this.mWrapped.getResourceId(r3, 0);
        if (r6 != 0) goto L7;
        return null;
    L7:
        if (this.mTypedValue != null) goto L10;
        this.mTypedValue = new TypedValue();
    L10:
        return ResourcesCompat.getFont(this.mContext, r6, this.mTypedValue, r4, r5);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getIndex(int r1) {
        return this.mWrapped.getIndex(r1);
    }

    public Resources getResources() {
        return this.mWrapped.getResources();
    }

    public CharSequence getText(int r1) {
        return this.mWrapped.getText(r1);
    }

    public String getString(int r1) {
        return this.mWrapped.getString(r1);
    }

    public String getNonResourceString(int r1) {
        return this.mWrapped.getNonResourceString(r1);
    }

    public boolean getBoolean(int r1, boolean r2) {
        return this.mWrapped.getBoolean(r1, r2);
    }

    public int getInt(int r1, int r2) {
        return this.mWrapped.getInt(r1, r2);
    }

    public float getFloat(int r1, float r2) {
        return this.mWrapped.getFloat(r1, r2);
    }

    public int getColor(int r1, int r2) {
        return this.mWrapped.getColor(r1, r2);
    }

    public ColorStateList getColorStateList(int r3) {
        if (this.mWrapped.hasValue(r3) == false) goto L10;
        int r0 = this.mWrapped.getResourceId(r3, 0);
        if (r0 == 0) goto L10;
        ColorStateList r1 = AppCompatResources.getColorStateList(this.mContext, r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        return this.mWrapped.getColorStateList(r3);
    }

    public int getInteger(int r1, int r2) {
        return this.mWrapped.getInteger(r1, r2);
    }

    public float getDimension(int r1, float r2) {
        return this.mWrapped.getDimension(r1, r2);
    }

    public int getDimensionPixelOffset(int r1, int r2) {
        return this.mWrapped.getDimensionPixelOffset(r1, r2);
    }

    public int getDimensionPixelSize(int r1, int r2) {
        return this.mWrapped.getDimensionPixelSize(r1, r2);
    }

    public int getLayoutDimension(int r1, String r2) {
        return this.mWrapped.getLayoutDimension(r1, r2);
    }

    public int getLayoutDimension(int r1, int r2) {
        return this.mWrapped.getLayoutDimension(r1, r2);
    }

    public float getFraction(int r1, int r2, int r3, float r4) {
        return this.mWrapped.getFraction(r1, r2, r3, r4);
    }

    public int getResourceId(int r1, int r2) {
        return this.mWrapped.getResourceId(r1, r2);
    }

    public CharSequence[] getTextArray(int r1) {
        return this.mWrapped.getTextArray(r1);
    }

    public boolean getValue(int r1, TypedValue r2) {
        return this.mWrapped.getValue(r1, r2);
    }

    public int getType(int r1) {
        return Api21Impl.getType(this.mWrapped, r1);
    }

    public boolean hasValue(int r1) {
        return this.mWrapped.hasValue(r1);
    }

    public TypedValue peekValue(int r1) {
        return this.mWrapped.peekValue(r1);
    }

    public String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public int getChangingConfigurations() {
        return Api21Impl.getChangingConfigurations(this.mWrapped);
    }
}
