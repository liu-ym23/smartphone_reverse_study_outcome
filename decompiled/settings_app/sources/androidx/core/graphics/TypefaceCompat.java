package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = null;
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl = null;

    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback r1) {
            this.mFontCallback = r1;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRetrieved(Typeface r1) {
            ResourcesCompat.FontCallback r0 = this.mFontCallback;
            if (r0 == null) goto L6;
            r0.onFontRetrieved(r1);
            return;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void onTypefaceRequestFailed(int r1) {
            ResourcesCompat.FontCallback r0 = this.mFontCallback;
            if (r0 == null) goto L6;
            r0.onFontRetrievalFailed(r1);
            return;
        }
    }

    static {
        sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        sTypefaceCache = new LruCache(16);
    }

    private TypefaceCompat() {
    }

    public static Typeface findFromCache(Resources r1, int r2, String r3, int r4, int r5) {
        return sTypefaceCache.get(createResourceUid(r1, r2, r3, r4, r5));
    }

    @Deprecated
    public static Typeface findFromCache(Resources r2, int r3, int r4) {
        return findFromCache(r2, r3, null, 0, r4);
    }

    private static String createResourceUid(Resources r1, int r2, String r3, int r4, int r5) {
        return r1.getResourcePackageName(r2) + '-' + r3 + '-' + r4 + '-' + r2 + '-' + r5;
    }

    private static Typeface getSystemFontFamily(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isEmpty() == true) goto L16;
        Typeface r4 = Typeface.create(r3, 0);
        Typeface r1 = Typeface.create(Typeface.DEFAULT, 0);
        if (r4 != null) goto L10;
        return null;
    L10:
        if (r4.equals(r1) == false) goto L12;
        return null;
    L12:
        return r4;
    L16:
        return null;
    }

    public static Typeface createFromResourcesFamilyXml(Context r13, FontResourcesParserCompat.FamilyResourceEntry r14, Resources r15, int r16, String r17, int r18, int r19, ResourcesCompat.FontCallback r20, Handler r21, boolean r22) {
        if ((r14 instanceof FontResourcesParserCompat.ProviderResourceEntry) == false) goto L21;
        FontResourcesParserCompat.ProviderResourceEntry r0 = (FontResourcesParserCompat.ProviderResourceEntry) r14;
        Typeface r3 = getSystemFontFamily(r0.getSystemFontFamilyName());
        if (r3 == null) goto L10;
        if (r20 == null) goto L8;
        r20.callbackSuccessAsync(r3, r21);
    L8:
        return r3;
    L10:
        if (r22 == true) goto L12;
        if (r20 != null) goto L16;
    L15:
        boolean r9 = true;
    L17:
        if (r22 == false) goto L19;
        int r4 = r0.getTimeout();
    L20:
        Handler r11 = ResourcesCompat.FontCallback.getHandler(r21);
        ResourcesCallbackAdapter r12 = new ResourcesCallbackAdapter(r20);
        Typeface r1 = FontsContractCompat.requestFont(r13, r0.getRequest(), r19, r9, r4, r11, r12);
    L26:
        if (r1 == null) goto L28;
        sTypefaceCache.put(createResourceUid(r15, r16, r17, r18, r19), r1);
    L28:
        return r1;
    L19:
        r4 = -1;
    L16:
        r9 = false;
        goto L17
    L12:
        if (r0.getFetchStrategy() != 0) goto L16;
    L21:
        r1 = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(r13, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) r14, r15, r19);
        if (r20 == null) goto L26;
        if (r1 == null) goto L25;
        r20.callbackSuccessAsync(r1, r21);
        goto L26
    L25:
        r20.callbackFailAsync(-3, r21);
        goto L26
    }

    @Deprecated
    public static Typeface createFromResourcesFamilyXml(Context r10, FontResourcesParserCompat.FamilyResourceEntry r11, Resources r12, int r13, int r14, ResourcesCompat.FontCallback r15, Handler r16, boolean r17) {
        return createFromResourcesFamilyXml(r10, r11, r12, r13, null, 0, r14, r15, r16, r17);
    }

    public static Typeface createFromResourcesFontFile(Context r6, Resources r7, int r8, String r9, int r10, int r11) {
        Typeface r12 = sTypefaceCompatImpl.createFromResourcesFontFile(r6, r7, r8, r9, r11);
        if (r12 == null) goto L5;
        String r13 = createResourceUid(r7, r8, r9, r10, r11);
        sTypefaceCache.put(r13, r12);
    L5:
        return r12;
    }

    @Deprecated
    public static Typeface createFromResourcesFontFile(Context r6, Resources r7, int r8, String r9, int r10) {
        return createFromResourcesFontFile(r6, r7, r8, r9, 0, r10);
    }

    public static Typeface createFromFontInfo(Context r1, CancellationSignal r2, FontsContractCompat.FontInfo[] r3, int r4) {
        return sTypefaceCompatImpl.createFromFontInfo(r1, r2, r3, r4);
    }

    private static Typeface getBestFontFromFamily(Context r2, Typeface r3, int r4) {
        TypefaceCompatBaseImpl r0 = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r5 = r0.getFontFamily(r3);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r0.createFromFontFamilyFilesResourceEntry(r2, r5, r2.getResources(), r4);
    }

    public static Typeface create(Context r0, Typeface r1, int r2) {
        if (r0 == null) goto L6;
        return Typeface.create(r1, r2);
    L6:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface create(Context r3, Typeface r4, int r5, boolean r6) {
        if (r3 == null) goto L9;
        Preconditions.checkArgumentInRange(r5, 1, 1000, "weight");
        if (r4 != null) goto L7;
        r4 = Typeface.DEFAULT;
    L7:
        return sTypefaceCompatImpl.createWeightStyle(r3, r4, r5, r6);
    L9:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static void clearCache() {
        sTypefaceCache.evictAll();
    }
}
