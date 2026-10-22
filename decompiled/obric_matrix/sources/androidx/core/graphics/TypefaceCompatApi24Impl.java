package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle = null;
    private static final Method sCreateFromFamiliesWithDefault = null;
    private static final Class<?> sFontFamily = null;
    private static final Constructor<?> sFontFamilyCtor = null;

    static {
        Constructor<?> r0 = null;
        Class<?> r1 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L5
        Constructor<?> r3 = r1.getConstructor(new Class[0]);     // Catch: Throwable -> L5
        Class<?> r6 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r4 = r1.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{ByteBuffer.class, r6, List.class, r6, Boolean.TYPE});     // Catch: Throwable -> L5
        Method r2 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r1, 1).getClass()});     // Catch: Throwable -> L5
        r0 = r3;
    L7:
        sFontFamilyCtor = r0;
        sFontFamily = r1;
        sAddFontWeightStyle = r4;
        sCreateFromFamiliesWithDefault = r2;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r1 = null;
        r2 = null;
        r4 = null;
        goto L7
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object r3, ByteBuffer r4, int r5, int r6, boolean r7) {
        return ((Boolean) sAddFontWeightStyle.invoke(r3, new Object[]{r4, Integer.valueOf(r5), null, Integer.valueOf(r6), Boolean.valueOf(r7)})).booleanValue();
    L5:
        return false;
    }

    private static Typeface createFromFamiliesWithDefault(Object r4) {
        Object r1 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r1});
    L5:
        return null;
    }

    public static boolean isUsable() {
        Method r0 = sAddFontWeightStyle;
        if (r0 != null) goto L5;
        Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
    L5:
        if (r0 == null) goto L7;
        return true;
    L7:
        return false;
    }

    private static Object newFamily() {
        return sFontFamilyCtor.newInstance(new Object[0]);
    L4:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        Object r6 = newFamily();
        if (r6 != null) goto L5;
        return null;
    L5:
        FontResourcesParserCompat.FontFileResourceEntry[] r11 = r8.getEntries();
        int r0 = r11.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r2 = r11[r1];
        ByteBuffer r3 = TypefaceCompatUtil.copyToDirectBuffer(r7, r9, r2.getResourceId());
        if (r3 == null) goto L9;
        if (addFontWeightStyle(r6, r3, r2.getTtcIndex(), r2.getWeight(), r2.isItalic()) == false) goto L12;
        r1 = r1 + 1;
        goto L6
    L12:
        return null;
    L9:
        return null;
    L15:
        return createFromFamiliesWithDefault(r6);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r9, @Nullable CancellationSignal r10, @NonNull FontsContractCompat.FontInfo[] r11, int r12) {
        Object r8 = newFamily();
        if (r8 != null) goto L5;
        return null;
    L5:
        SimpleArrayMap r1 = new SimpleArrayMap();
        int r2 = r11.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L16;
        FontsContractCompat.FontInfo r4 = r11[r3];
        Uri r5 = r4.getUri();
        ByteBuffer r6 = (ByteBuffer) r1.get(r5);
        if (r6 != null) goto L10;
        r6 = TypefaceCompatUtil.mmap(r9, r10, r5);
        r1.put(r5, r6);
    L10:
        if (r6 == null) goto L11;
        if (addFontWeightStyle(r8, r6, r4.getTtcIndex(), r4.getWeight(), r4.isItalic()) == false) goto L14;
        r3 = r3 + 1;
        goto L6
    L14:
        return null;
    L11:
        return null;
    L16:
        Typeface r13 = createFromFamiliesWithDefault(r8);
        if (r13 != null) goto L20;
        return null;
    L20:
        return Typeface.create(r13, r12);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    Typeface createWeightStyle(@NonNull Context r2, @NonNull Typeface r3, int r4, boolean r5) {
        Typeface r0 = WeightTypefaceApi21.createWeightStyle(r3, r4, r5);     // Catch: RuntimeException -> L4
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return super.createWeightStyle(r2, r3, r4, r5);
    L4:
        r0 = null;
        goto L5
    }
}
