package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.FontResourcesParserCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class FontProvider {
    private static final Comparator<byte[]> sByteArrayComparator = null;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static Cursor query(ContentResolver r7, Uri r8, String[] r9, String r10, String[] r11, String r12, Object r13) {
            return r7.query(r8, r9, r10, r11, r12, (CancellationSignal) r13);
        }
    }

    static {
        sByteArrayComparator = a.f332f;
    }

    private FontProvider() {
    }

    static /* synthetic */ int a(byte[] r4, byte[] r5) {
        if (r4.length == r5.length) goto L7;
        int r6 = r4.length;
        int r7 = r5.length;
    L6:
        return r6 - r7;
    L7:
        int r1 = 0;
    L9:
        if (r1 >= r4.length) goto L14;
        if (r4[r1] != r5[r1]) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        r6 = r4[r1];
        r7 = r5[r1];
        goto L6
    L14:
        return 0;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r4) {
        ArrayList r0 = new ArrayList();
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2].toByteArray());
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private static boolean equalsByteArrayList(List<byte[]> r4, List<byte[]> r5) {
        if (r4.size() == r5.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r4.size()) goto L12;
        if (Arrays.equals(r4.get(r0), r5.get(r0)) == false) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest r1, Resources r2) {
        if (r1.getCertificates() == null) goto L7;
        return r1.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r2, r1.getCertificatesArrayResId());
    }

    @NonNull
    static FontsContractCompat.FontFamilyResult getFontFamilyResult(@NonNull Context r2, @NonNull FontRequest r3, @Nullable CancellationSignal r4) {
        ProviderInfo r0 = getProvider(r2.getPackageManager(), r3, r2.getResources());
        if (r0 != null) goto L7;
        return FontsContractCompat.FontFamilyResult.create(1, null);
    L7:
        return FontsContractCompat.FontFamilyResult.create(0, query(r2, r3, r0.authority, r4));
    }

    @Nullable
    @VisibleForTesting
    static ProviderInfo getProvider(@NonNull PackageManager r5, @NonNull FontRequest r6, @Nullable Resources r7) {
        String r0 = r6.getProviderAuthority();
        int r1 = 0;
        ProviderInfo r2 = r5.resolveContentProvider(r0, 0);
        if (r2 == null) goto L18;
        if (r2.packageName.equals(r6.getProviderPackage()) == false) goto L16;
        List<byte[]> r8 = convertToByteArrayList(r5.getPackageInfo(r2.packageName, 64).signatures);
        Collections.sort(r8, sByteArrayComparator);
        List<List<byte[]>> r9 = getCertificates(r6, r7);
    L8:
        if (r1 >= r9.size()) goto L13;
        ArrayList r10 = new ArrayList(r9.get(r1));
        Collections.sort(r10, sByteArrayComparator);
        if (equalsByteArrayList(r8, r10) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return r2;
    L13:
        return null;
    L16:
        throw new PackageManager.NameNotFoundException("Found content provider " + r0 + ", but package was not " + r6.getProviderPackage());
    L18:
        throw new PackageManager.NameNotFoundException("No package found for authority: " + r0);
    }

    @NonNull
    @VisibleForTesting
    static FontsContractCompat.FontInfo[] query(Context r16, FontRequest r17, String r18, CancellationSignal r19) {
        ArrayList r1 = new ArrayList();
        Uri r2 = new Uri.Builder().scheme("content").authority(r18).build();
        Uri r0 = new Uri.Builder().scheme("content").authority(r18).appendPath("file").build();
        Cursor r3 = null;
        String[] r6 = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE};     // Catch: Throwable -> L39
        ContentResolver r4 = r16.getContentResolver();     // Catch: Throwable -> L39
        int r12 = 0;
        if (Build.VERSION.SDK_INT <= 16) goto L6;
        r3 = Api16Impl.query(r4, r2, r6, "query = ?", new String[]{r17.getQuery()}, null, r19);     // Catch: Throwable -> L39
    L7:
        if (r3 != null) goto L9;
    L35:
        if (r3 == null) goto L38;
        r3.close();
    L38:
        return (FontsContractCompat.FontInfo[]) r1.toArray(new FontsContractCompat.FontInfo[0]);
    L9:
        if (r3.getCount() <= 0) goto L35;
        int r5 = r3.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);     // Catch: Throwable -> L39
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L39
        int r8 = r3.getColumnIndex("_id");     // Catch: Throwable -> L39
        int r9 = r3.getColumnIndex(FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L39
        int r10 = r3.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);     // Catch: Throwable -> L39
        int r11 = r3.getColumnIndex(FontsContractCompat.Columns.WEIGHT);     // Catch: Throwable -> L39
        int r13 = r3.getColumnIndex(FontsContractCompat.Columns.ITALIC);     // Catch: Throwable -> L39
    L11:
        if (r3.moveToNext() == false) goto L34;
        if (r5 == (-1)) goto L16;
        int r14 = r3.getInt(r5);     // Catch: Throwable -> L39
    L17:
        if (r10 == (-1)) goto L19;
        int r15 = r3.getInt(r10);     // Catch: Throwable -> L39
    L20:
        int r110 = r14;
        if (r9 != (-1)) goto L23;
        Uri r111 = ContentUris.withAppendedId(r2, r3.getLong(r8));     // Catch: Throwable -> L39
    L24:
        if (r11 == (-1)) goto L26;
        int r112 = r3.getInt(r11);     // Catch: Throwable -> L39
    L27:
        if (r13 != (-1)) goto L29;
    L31:
        boolean r113 = false;
    L32:
        r7.add(FontsContractCompat.FontInfo.create(r111, r15, r112, r113, r110));     // Catch: Throwable -> L39
        r12 = 0;
        goto L11
    L29:
        if (r3.getInt(r13) != 1) goto L31;
        r113 = true;
        goto L32
    L26:
        r112 = 400;
        goto L27
    L23:
        r111 = ContentUris.withAppendedId(r0, r3.getLong(r9));     // Catch: Throwable -> L39
        goto L24
    L19:
        r15 = r12;
        goto L20
    L16:
        r14 = r12;
        goto L17
    L34:
        r1 = r7;
        goto L35
    L6:
        r3 = r4.query(r2, r6, "query = ?", new String[]{r17.getQuery()}, null);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        if (r3 == null) goto L42;
        r3.close();
    L42:
        throw th;
    }
}
