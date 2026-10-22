package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class<?> mFontFamily;
    protected final Constructor<?> mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Class<?> r0 = obtainFontFamily();     // Catch: Throwable -> L5
        Constructor<?> r1 = obtainFontFamilyCtor(r0);     // Catch: Throwable -> L5
        Method r2 = obtainAddFontFromAssetManagerMethod(r0);     // Catch: Throwable -> L5
        Method r3 = obtainAddFontFromBufferMethod(r0);     // Catch: Throwable -> L5
        Method r4 = obtainFreezeMethod(r0);     // Catch: Throwable -> L5
        Method r5 = obtainAbortCreationMethod(r0);     // Catch: Throwable -> L5
        Method r6 = obtainCreateFromFamiliesWithDefaultMethod(r0);     // Catch: Throwable -> L5
    L7:
        this.mFontFamily = r0;
        this.mFontFamilyCtor = r1;
        this.mAddFontFromAssetManager = r2;
        this.mAddFontFromBuffer = r3;
        this.mFreeze = r4;
        this.mAbortCreation = r5;
        this.mCreateFromFamiliesWithDefault = r6;
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
        r0 = null;
        r1 = null;
        r2 = null;
        r3 = null;
        r4 = null;
        r5 = null;
        r6 = null;
        goto L7
    }

    private void abortCreation(Object r2) {
        this.mAbortCreation.invoke(r2, null);     // Catch: Throwable -> L4
        return;
    }

    private boolean addFontFromAssetManager(Context r11, Object r12, String r13, int r14, int r15, int r16, @Nullable FontVariationAxis[] r17) {
        return ((Boolean) this.mAddFontFromAssetManager.invoke(r12, new Object[]{r11.getAssets(), r13, 0, Boolean.FALSE, Integer.valueOf(r14), Integer.valueOf(r15), Integer.valueOf(r16), r17})).booleanValue();
    L8:
        return false;
    }

    private boolean addFontFromBuffer(Object r2, ByteBuffer r3, int r4, int r5, int r6) {
        return ((Boolean) this.mAddFontFromBuffer.invoke(r2, new Object[]{r3, Integer.valueOf(r4), null, Integer.valueOf(r5), Integer.valueOf(r6)})).booleanValue();
    L4:
        return false;
    }

    private boolean freeze(Object r2) {
        return ((Boolean) this.mFreeze.invoke(r2, null)).booleanValue();
    L4:
        return false;
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager != null) goto L6;
        Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
    L6:
        if (this.mAddFontFromAssetManager == null) goto L8;
        return true;
    L8:
        return false;
    }

    @Nullable
    private Object newFamily() {
        return this.mFontFamilyCtor.newInstance(null);
    L5:
        return null;
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object r4) {
        Object r1 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L5
        Array.set(r1, 0, r4);     // Catch: Throwable -> L5
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r1, -1, -1});
    L5:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r11, FontResourcesParserCompat.FontFamilyFilesResourceEntry r12, Resources r13, int r14) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r15 = newFamily();
        if (r15 != null) goto L9;
        return null;
    L9:
        FontResourcesParserCompat.FontFileResourceEntry[] r16 = r12.getEntries();
        int r8 = r16.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L17;
        FontResourcesParserCompat.FontFileResourceEntry r0 = r16[r9];
        String r3 = r0.getFileName();
        int r4 = r0.getTtcIndex();
        int r5 = r0.getWeight();
        boolean r6 = r0.isItalic();
        if (addFontFromAssetManager(r11, r15, r3, r4, r5, r6 ? 1 : 0, FontVariationAxis.fromFontVariationSettings(r0.getVariationSettings())) == false) goto L13;
        r9 = r9 + 1;
        goto L10
    L13:
        abortCreation(r15);
        return null;
    L17:
        if (freeze(r15) == true) goto L20;
        return null;
    L20:
        return createFromFamiliesWithDefault(r15);
    L5:
        return super.createFromFontFamilyFilesResourceEntry(r11, r12, r13, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r11, @Nullable CancellationSignal r12, @NonNull FontsContractCompat.FontInfo[] r13, int r14) {
        if (r13.length >= 1) goto L6;
        return null;
    L6:
        if (isFontFamilyPrivateAPIAvailable() == true) goto L23;
        FontsContractCompat.FontInfo r10 = findBestInfo(r13, r14);
        ParcelFileDescriptor r15 = r11.getContentResolver().openFileDescriptor(r10.getUri(), "r", r12);     // Catch: IOException -> L22
        if (r15 != null) goto L48;
        if (r15 == null) goto L12;
        r15.close();     // Catch: IOException -> L22
    L12:
        return null;
    L48:
        Typeface r16 = new Typeface.Builder(r15.getFileDescriptor()).setWeight(r10.getWeight()).setItalic(r10.isItalic()).build();     // Catch: Throwable -> L16
        r15.close();     // Catch: IOException -> L22
        return r16;
    L16:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        return null;
    L23:
        Map<Uri, ByteBuffer> r17 = FontsContractCompat.prepareFontData(r11, r13, r12);
        Object r18 = newFamily();
        if (r18 != null) goto L26;
        return null;
    L26:
        int r0 = r13.length;
        boolean r3 = false;
        int r9 = 0;
    L27:
        if (r9 >= r0) goto L37;
        FontsContractCompat.FontInfo r4 = r13[r9];
        ByteBuffer r5 = r17.get(r4.getUri());
        if (r5 == null) goto L36;
        if (addFontFromBuffer(r18, r5, r4.getTtcIndex(), r4.getWeight(), r4.isItalic() ? 1 : 0) == false) goto L33;
        r3 = true;
        goto L36
    L33:
        abortCreation(r18);
        return null;
    L36:
        r9 = r9 + 1;
        goto L27
    L37:
        if (r3 == true) goto L41;
        abortCreation(r18);
        return null;
    L41:
        if (freeze(r18) == true) goto L43;
        return null;
    L43:
        Typeface r19 = createFromFamiliesWithDefault(r18);
        if (r19 != null) goto L47;
        return null;
    L47:
        return Typeface.create(r19, r14);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r9, Resources r10, int r11, String r12, int r13) {
        if (isFontFamilyPrivateAPIAvailable() == false) goto L5;
        Object r14 = newFamily();
        if (r14 != null) goto L10;
        return null;
    L10:
        if (addFontFromAssetManager(r9, r14, r12, 0, -1, -1, null) == true) goto L14;
        abortCreation(r14);
        return null;
    L14:
        if (freeze(r14) == true) goto L17;
        return null;
    L17:
        return createFromFamiliesWithDefault(r14);
    L5:
        return super.createFromResourcesFontFile(r9, r10, r11, r12, r13);
    }

    public Method obtainAbortCreationMethod(Class<?> r2) {
        return r2.getMethod(ABORT_CREATION_METHOD, null);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class<?> r9) {
        Class r6 = Integer.TYPE;
        return r9.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, r6, Boolean.TYPE, r6, r6, r6, FontVariationAxis[].class});
    }

    public Method obtainAddFontFromBufferMethod(Class<?> r3) {
        Class r2 = Integer.TYPE;
        return r3.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, r2, FontVariationAxis[].class, r2, r2});
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r3) {
        Class<?> r4 = Array.newInstance(r3, 1).getClass();
        Class r0 = Integer.TYPE;
        Method r5 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{r4, r0, r0});
        r5.setAccessible(true);
        return r5;
    }

    public Class<?> obtainFontFamily() {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    public Constructor<?> obtainFontFamilyCtor(Class<?> r1) {
        return r1.getConstructor(null);
    }

    public Method obtainFreezeMethod(Class<?> r2) {
        return r2.getMethod(FREEZE_METHOD, null);
    }
}
