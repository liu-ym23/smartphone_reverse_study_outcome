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

    private Font findBaseFont(@NonNull FontFamily r5, int r6) {
        if ((r6 & 1) == 0) goto L5;
        int r0 = TypedValues.TransitionType.TYPE_DURATION;
    L6:
        int r2 = 1;
        if ((r6 & 2) == 0) goto L9;
        int r7 = 1;
    L10:
        FontStyle r4 = new FontStyle(r0, r7);
        Font r8 = r5.getFont(0);
        int r1 = getMatchScore(r4, r8.getStyle());
    L12:
        if (r2 >= r5.getSize()) goto L17;
        Font r3 = r5.getFont(r2);
        int r9 = getMatchScore(r4, r3.getStyle());
        if (r9 >= r1) goto L16;
        r8 = r3;
        r1 = r9;
    L16:
        r2 = r2 + 1;
        goto L12
    L17:
        return r8;
    L9:
        r7 = 0;
        goto L10
    L5:
        r0 = 400;
        goto L6
    }

    private static int getMatchScore(@NonNull FontStyle r2, @NonNull FontStyle r3) {
        int r0 = Math.abs(r2.getWeight() - r3.getWeight()) / 100;
        if (r2.getSlant() != r3.getSlant()) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = 2;
        goto L7
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context r8, FontResourcesParserCompat.FontFamilyFilesResourceEntry r9, Resources r10, int r11) {
        FontResourcesParserCompat.FontFileResourceEntry[] r12 = r9.getEntries();     // Catch: Exception -> L19
        int r0 = r12.length;     // Catch: Exception -> L19
        FontFamily.Builder r3 = null;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L15;
        FontResourcesParserCompat.FontFileResourceEntry r4 = r12[r2];     // Catch: Exception -> L19
        Font.Builder r5 = new Font.Builder(r10, r4.getResourceId()).setWeight(r4.getWeight());     // Catch: IOException -> L20 Exception -> L19
        if (r4.isItalic() == false) goto L9;
        int r6 = 1;
    L10:
        Font r7 = r5.setSlant(r6).setTtcIndex(r4.getTtcIndex()).setFontVariationSettings(r4.getVariationSettings()).build();     // Catch: IOException -> L20 Exception -> L19
        if (r3 != null) goto L13;
        r3 = new FontFamily.Builder(r7);     // Catch: IOException -> L20 Exception -> L19
        goto L14
    L13:
        r3.addFont(r7);     // Catch: IOException -> L20 Exception -> L19
        goto L14
    L9:
        r6 = 0;
    L14:
        r2 = r2 + 1;
        goto L4
    L15:
        if (r3 != null) goto L17;
        return null;
    L17:
        FontFamily r13 = r3.build();     // Catch: Exception -> L19
        return new Typeface.CustomFallbackBuilder(r13).setStyle(findBaseFont(r13, r11).getStyle()).build();
    L19:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromFontInfo(Context r10, @Nullable CancellationSignal r11, @NonNull FontsContractCompat.FontInfo[] r12, int r13) {
        ContentResolver r14 = r10.getContentResolver();
        int r1 = r12.length;     // Catch: Exception -> L33
        FontFamily.Builder r4 = null;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L29;
        FontsContractCompat.FontInfo r5 = r12[r3];     // Catch: Exception -> L33
        ParcelFileDescriptor r6 = r14.openFileDescriptor(r5.getUri(), "r", r11);     // Catch: IOException -> L34 Exception -> L33
        if (r6 != null) goto L36;
        if (r6 == null) goto L28;
    L9:
        r6.close();     // Catch: IOException -> L34 Exception -> L33
        goto L28
    L36:
        Font.Builder r7 = new Font.Builder(r6).setWeight(r5.getWeight());     // Catch: Throwable -> L21
        if (r5.isItalic() == false) goto L14;
        int r8 = 1;
    L15:
        Font r9 = r7.setSlant(r8).setTtcIndex(r5.getTtcIndex()).build();     // Catch: Throwable -> L21
        if (r4 != null) goto L18;
        r4 = new FontFamily.Builder(r9);     // Catch: Throwable -> L21
    L19:
        if (r6 == null) goto L28;
    L18:
        r4.addFont(r9);     // Catch: Throwable -> L21
        goto L19
    L14:
        r8 = 0;
    L21:
        th = move-exception;
        if (r6 != null) goto L38;
    L27:
        throw th;     // Catch: IOException -> L34 Exception -> L33
    L38:
        r6.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L34 Exception -> L33
    L28:
        r3 = r3 + 1;
        goto L4
    L29:
        if (r4 != null) goto L31;
        return null;
    L31:
        FontFamily r15 = r4.build();     // Catch: Exception -> L33
        return new Typeface.CustomFallbackBuilder(r15).setStyle(findBaseFont(r15, r13).getStyle()).build();
    L33:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface createFromInputStream(Context r1, InputStream r2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @Nullable
    public Typeface createFromResourcesFontFile(Context r1, Resources r2, int r3, String r4, int r5) {
        Font r0 = new Font.Builder(r2, r3).build();     // Catch: Exception -> L4
        return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(r0).build()).setStyle(r0.getStyle()).build();
    L4:
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    @NonNull
    Typeface createWeightStyle(@NonNull Context r1, @NonNull Typeface r2, int r3, boolean r4) {
        return Typeface.create(r2, r3, r4);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] r1, int r2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
