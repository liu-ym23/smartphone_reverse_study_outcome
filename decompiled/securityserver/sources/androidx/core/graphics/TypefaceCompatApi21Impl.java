package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class<?> sFontFamily = null;
    private static Constructor<?> sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    public TypefaceCompatApi21Impl() {
    }

    private static boolean addFontWeightStyle(Object r1, String r2, int r3, boolean r4) {
        init();
        return ((Boolean) sAddFontWeightStyle.invoke(r1, new Object[]{r2, Integer.valueOf(r3), Boolean.valueOf(r4)})).booleanValue();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static Typeface createFromFamiliesWithDefault(Object r2) {
        init();
        Object r0 = Array.newInstance(sFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r0, 0, r2);     // Catch: Throwable -> L5
        return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0});
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private File getFile(@NonNull ParcelFileDescriptor r3) {
        String r2 = Os.readlink("/proc/self/fd/" + r3.getFd());     // Catch: ErrnoException -> L8
        if (OsConstants.S_ISREG(Os.stat(r2).st_mode) == false) goto L7;
        return new File(r2);
    L7:
        return null;
    }

    private static void init() {
        if (sHasInitBeenCalled == false) goto L5;
        return;
    L5:
        sHasInitBeenCalled = true;
        Constructor<?> r1 = null;
        Class<?> r2 = Class.forName(FONT_FAMILY_CLASS);     // Catch: Throwable -> L8
        Constructor<?> r3 = r2.getConstructor(null);     // Catch: Throwable -> L8
        Method r4 = r2.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L8
        Method r0 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(r2, 1).getClass()});     // Catch: Throwable -> L8
        r1 = r3;
    L10:
        sFontFamilyCtor = r1;
        sFontFamily = r2;
        sAddFontWeightStyle = r4;
        sCreateFromFamiliesWithDefault = r0;
        return;
    L8:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r0 = null;
        r2 = null;
        r4 = null;
        goto L10
    }

    private static Object newFamily() {
        init();
        return sFontFamilyCtor.newInstance(null);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        Object r6 = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] r11 = r8.getEntries();
        int r12 = r11.length;
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L22;
        FontResourcesParserCompat.FontFileResourceEntry r1 = r11[r0];
        File r2 = TypefaceCompatUtil.getTempFile(r7);
        if (r2 == null) goto L6;
    L19:
        r2.delete();
        return null;
    L16:
        th = move-exception;
        r2.delete();
        throw th;
    L8:
        if (TypefaceCompatUtil.copyToFile(r2, r9, r1.getResourceId()) == false) goto L9;
        if (addFontWeightStyle(r6, r2.getPath(), r1.getWeight(), r1.isItalic()) == false) goto L13;
        r2.delete();
        r0 = r0 + 1;
        goto L3
    L13:
        r2.delete();
        return null;
    L9:
        r2.delete();
        return null;
    L6:
        return null;
    L22:
        return createFromFamiliesWithDefault(r6);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context r4, CancellationSignal r5, @NonNull FontsContractCompat.FontInfo[] r6, int r7) {
        if (r6.length >= 1) goto L5;
        return null;
    L5:
        FontsContractCompat.FontInfo r8 = findBestInfo(r6, r7);
        ContentResolver r9 = r4.getContentResolver();
        ParcelFileDescriptor r10 = r9.openFileDescriptor(r8.getUri(), "r", r5);     // Catch: IOException -> L37
        if (r10 != null) goto L40;
        if (r10 == null) goto L10;
        r10.close();     // Catch: IOException -> L37
    L10:
        return null;
    L40:
        File r11 = getFile(r10);     // Catch: Throwable -> L19
        if (r11 != null) goto L14;
    L21:
        FileInputStream r12 = new FileInputStream(r10.getFileDescriptor());     // Catch: Throwable -> L19
        Typeface r3 = super.createFromInputStream(r4, r12);     // Catch: Throwable -> L26
        r12.close();     // Catch: Throwable -> L19
        r10.close();     // Catch: IOException -> L37
        return r3;
    L26:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L19
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
        goto L31
    L14:
        if (r11.canRead() == false) goto L21;
        Typeface r13 = Typeface.createFromFile(r11);     // Catch: Throwable -> L19
        r10.close();     // Catch: IOException -> L37
        return r13;
    L19:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: IOException -> L37
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L37
    L37:
        return null;
    }
}
