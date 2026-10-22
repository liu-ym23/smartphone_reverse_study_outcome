package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    static {
        sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        sTypefaceCache = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    @NonNull
    public static Typeface create(@NonNull Context r0, @Nullable Typeface r1, int r2) {
        if (r0 == null) goto L6;
        return Typeface.create(r1, r2);
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context r1, @Nullable CancellationSignal r2, @NonNull FontsContractCompat.FontInfo[] r3, int r4) {
        return sTypefaceCompatImpl.createFromFontInfo(r1, r2, r3, r4);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context r7, @NonNull FontResourcesParserCompat.FamilyResourceEntry r8, @NonNull Resources r9, int r10, int r11, @Nullable ResourcesCompat.FontCallback r12, @Nullable Handler r13, boolean r14) {
        if ((r8 instanceof FontResourcesParserCompat.ProviderResourceEntry) == false) goto L16;
        FontResourcesParserCompat.ProviderResourceEntry r0 = (FontResourcesParserCompat.ProviderResourceEntry) r8;
        boolean r4 = true;
        if (r14 == true) goto L7;
        if (r12 == null) goto L11;
    L9:
        r4 = false;
    L11:
        if (r14 == false) goto L14;
        int r1 = r0.getTimeout();
    L15:
        Typeface r2 = FontsContractCompat.getFontSync(r7, r0.getRequest(), r12, r13, r4, r1, r11);
    L21:
        if (r2 == null) goto L23;
        sTypefaceCache.put(createResourceUid(r9, r10, r11), r2);
    L23:
        return r2;
    L14:
        r1 = -1;
        goto L15
    L7:
        if (r0.getFetchStrategy() != 0) goto L9;
    L16:
        r2 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r7, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) r8, r9, r11);
        if (r12 == null) goto L21;
        if (r2 == null) goto L20;
        r12.callbackSuccessAsync(r2, r13);
        goto L21
    L20:
        r12.callbackFailAsync(-3, r13);
        goto L21
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFontFile(@NonNull Context r6, @NonNull Resources r7, int r8, String r9, int r10) {
        Typeface r11 = sTypefaceCompatImpl.createFromResourcesFontFile(r6, r7, r8, r9, r10);
        if (r11 == null) goto L5;
        String r12 = createResourceUid(r7, r8, r10);
        sTypefaceCache.put(r12, r11);
    L5:
        return r11;
    }

    private static String createResourceUid(Resources r1, int r2, int r3) {
        return r1.getResourcePackageName(r2) + "-" + r2 + "-" + r3;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface findFromCache(@NonNull Resources r1, int r2, int r3) {
        return sTypefaceCache.get(createResourceUid(r1, r2, r3));
    }

    @Nullable
    private static Typeface getBestFontFromFamily(Context r2, Typeface r3, int r4) {
        TypefaceCompatBaseImpl r0 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r5 = r0.getFontFamily(r3);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r0.createFromFontFamilyFilesResourceEntry(r2, r5, r2.getResources(), r4);
    }
}
