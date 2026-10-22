package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    public TypefaceCompatApi29Impl() {
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r7, FontResourcesParserCompat.FontFamilyFilesResourceEntry r8, Resources r9, int r10) {
        FontResourcesParserCompat.FontFileResourceEntry[] r6 = r8.getEntries();
        int r11 = r6.length;
        int r0 = 0;
        FontFamily.Builder r2 = null;
        int r1 = 0;
    L4:
        if (r1 >= r11) goto L11;
        FontResourcesParserCompat.FontFileResourceEntry r3 = r6[r1];
        Font r4 = new Font.Builder(r9, r3.getResourceId()).setWeight(r3.getWeight()).setSlant(r3.isItalic() ? 1 : 0).setTtcIndex(r3.getTtcIndex()).setFontVariationSettings(r3.getVariationSettings()).build();     // Catch: IOException -> L22
        if (r2 != null) goto L9;
        r2 = new FontFamily.Builder(r4);     // Catch: IOException -> L22
        goto L10
    L9:
        r2.addFont(r4);     // Catch: IOException -> L22
    L10:
        r1 = r1 + 1;
        goto L4
    L11:
        if (r2 != null) goto L14;
        return null;
    L14:
        if ((r10 & 1) == 0) goto L16;
        int r12 = TypedValues.TransitionType.TYPE_DURATION;
    L18:
        if ((r10 & 2) == 0) goto L21;
        r0 = 1;
    L21:
        return new Typeface.CustomFallbackBuilder(r2.build()).setStyle(new FontStyle(r12, r0)).build();
    L16:
        r12 = 400;
        goto L18
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r9, @Nullable CancellationSignal r10, @NonNull FontsContractCompat.FontInfo[] r11, int r12) {
        ContentResolver r8 = r9.getContentResolver();
        int r13 = r11.length;
        int r1 = 0;
        FontFamily.Builder r3 = null;
        int r2 = 0;
    L4:
        if (r2 >= r13) goto L24;
        FontsContractCompat.FontInfo r4 = r11[r2];
        ParcelFileDescriptor r5 = r8.openFileDescriptor(r4.getUri(), "r", r10);     // Catch: IOException -> L35
        if (r5 != null) goto L40;
        if (r5 == null) goto L23;
    L9:
        r5.close();     // Catch: IOException -> L35
        goto L23
    L40:
        Font r6 = new Font.Builder(r5).setWeight(r4.getWeight()).setSlant(r4.isItalic() ? 1 : 0).setTtcIndex(r4.getTtcIndex()).build();     // Catch: Throwable -> L14
        if (r3 != null) goto L16;
        r3 = new FontFamily.Builder(r6);     // Catch: Throwable -> L14
        goto L9
    L16:
        r3.addFont(r6);     // Catch: Throwable -> L14
        goto L9
    L14:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: IOException -> L35
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L35
    L23:
        r2 = r2 + 1;
        goto L4
    L24:
        if (r3 != null) goto L27;
        return null;
    L27:
        if ((r12 & 1) == 0) goto L29;
        int r14 = TypedValues.TransitionType.TYPE_DURATION;
    L31:
        if ((r12 & 2) == 0) goto L34;
        r1 = 1;
    L34:
        return new Typeface.CustomFallbackBuilder(r3.build()).setStyle(new FontStyle(r14, r1)).build();
    L29:
        r14 = 400;
        goto L31
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromInputStream(Context r1, InputStream r2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r1, Resources r2, int r3, String r4, int r5) {
        Font r0 = new Font.Builder(r2, r3).build();     // Catch: IOException -> L5
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r0).build()).setStyle(r0.getStyle()).build();
    L5:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r1, int r2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
