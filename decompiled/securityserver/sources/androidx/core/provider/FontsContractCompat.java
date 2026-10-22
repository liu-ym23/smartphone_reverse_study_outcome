package androidx.core.provider;

import a.a;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat {
    private static final int BACKGROUND_THREAD_KEEP_ALIVE_DURATION_MS = 10000;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final String PARCEL_FONT_RESULTS = "font_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;
    private static final SelfDestructiveThread sBackgroundThread = null;
    private static final Comparator<byte[]> sByteArrayComparator = null;
    static final Object sLock = null;

    @GuardedBy("sLock")
    static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies = null;
    static final LruCache<String, Typeface> sTypefaceCache = null;

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";

        public Columns() {
        }
    }

    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontFamilyResult(int r1, @Nullable FontInfo[] r2) {
            this.mStatusCode = r1;
            this.mFonts = r2;
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public FontInfo(@NonNull Uri r1, @IntRange(from = 0) int r2, @IntRange(from = 1, to = 1000) int r3, boolean r4, int r5) {
            this.mUri = (Uri) Preconditions.checkNotNull(r1);
            this.mTtcIndex = r2;
            this.mWeight = r3;
            this.mItalic = r4;
            this.mResultCode = r5;
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        @IntRange(from = 0)
        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @NonNull
        public Uri getUri() {
            return this.mUri;
        }

        @IntRange(from = 1, to = 1000)
        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public @interface FontRequestFailReason {
        }

        public FontRequestCallback() {
        }

        public void onTypefaceRequestFailed(int r1) {
        }

        public void onTypefaceRetrieved(Typeface r1) {
        }
    }

    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        public TypefaceResult(@Nullable Typeface r1, int r2) {
            this.mTypeface = r1;
            this.mResult = r2;
        }
    }

    static {
        sTypefaceCache = new LruCache(16);
        sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
        sLock = new Object();
        sPendingReplies = new SimpleArrayMap();
        sByteArrayComparator = new AnonymousClass5();
    }

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context r1, @Nullable CancellationSignal r2, @NonNull FontInfo[] r3) {
        return TypefaceCompat.createFromFontInfo(r1, r2, r3, 0);
    }

    private static List<byte[]> convertToByteArrayList(Signature[] r3) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0.add(r3[r1].toByteArray());
        r1 = r1 + 1;
        goto L4
    L6:
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

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context r2, @Nullable CancellationSignal r3, @NonNull FontRequest r4) {
        ProviderInfo r0 = getProvider(r2.getPackageManager(), r4, r2.getResources());
        if (r0 != null) goto L7;
        return new FontFamilyResult(1, null);
    L7:
        return new FontFamilyResult(0, getFontFromProvider(r2, r4, r0.authority, r3));
    }

    private static List<List<byte[]>> getCertificates(FontRequest r1, Resources r2) {
        if (r1.getCertificates() == null) goto L7;
        return r1.getCertificates();
    L7:
        return FontResourcesParserCompat.readCerts(r2, r1.getCertificatesArrayResId());
    }

    @NonNull
    @VisibleForTesting
    public static FontInfo[] getFontFromProvider(Context r19, FontRequest r20, String r21, CancellationSignal r22) {
        ArrayList r1 = new ArrayList();
        Uri r2 = new Uri.Builder().scheme("content").authority(r21).build();
        Uri r0 = new Uri.Builder().scheme("content").authority(r21).appendPath("file").build();
        Cursor r3 = null;
        r3 = r19.getContentResolver().query(r2, new String[]{"_id", Columns.FILE_ID, Columns.TTC_INDEX, Columns.VARIATION_SETTINGS, Columns.WEIGHT, Columns.ITALIC, Columns.RESULT_CODE}, "query = ?", new String[]{r20.getQuery()}, null, r22);     // Catch: Throwable -> L13
        if (r3 != null) goto L6;
    L35:
        if (r3 == null) goto L38;
        r3.close();
    L38:
        return (FontInfo[]) r1.toArray(new FontInfo[0]);
    L6:
        if (r3.getCount() <= 0) goto L35;
        int r4 = r3.getColumnIndex(Columns.RESULT_CODE);     // Catch: Throwable -> L13
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L13
        int r6 = r3.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r7 = r3.getColumnIndex(Columns.FILE_ID);     // Catch: Throwable -> L13
        int r8 = r3.getColumnIndex(Columns.TTC_INDEX);     // Catch: Throwable -> L13
        int r9 = r3.getColumnIndex(Columns.WEIGHT);     // Catch: Throwable -> L13
        int r10 = r3.getColumnIndex(Columns.ITALIC);     // Catch: Throwable -> L13
    L8:
        if (r3.moveToNext() == false) goto L34;
        if (r4 == (-1)) goto L15;
        int r18 = r3.getInt(r4);     // Catch: Throwable -> L13
    L16:
        if (r8 == (-1)) goto L18;
        int r15 = r3.getInt(r8);     // Catch: Throwable -> L13
    L19:
        if (r7 != (-1)) goto L22;
        Uri r12 = ContentUris.withAppendedId(r2, r3.getLong(r6));     // Catch: Throwable -> L13
    L21:
        Uri r14 = r12;
        if (r9 == (-1)) goto L26;
        int r13 = r3.getInt(r9);     // Catch: Throwable -> L13
    L25:
        int r16 = r13;
        if (r10 != (-1)) goto L29;
    L31:
        boolean r17 = false;
    L32:
        r5.add(new FontInfo(r14, r15, r16, r17, r18));     // Catch: Throwable -> L13
        goto L8
    L29:
        if (r3.getInt(r10) != 1) goto L31;
        r17 = true;
        goto L32
    L26:
        r13 = 400;
        goto L25
    L22:
        r12 = ContentUris.withAppendedId(r0, r3.getLong(r7));     // Catch: Throwable -> L13
        goto L21
    L18:
        r15 = 0;
        goto L19
    L15:
        r18 = 0;
        goto L16
    L34:
        r1 = r5;
    L13:
        th = move-exception;
        if (r3 == null) goto L41;
        r3.close();
    L41:
        throw th;
    }

    @NonNull
    public static TypefaceResult getFontInternal(Context r3, FontRequest r4, int r5) {
        FontFamilyResult r6 = fetchFonts(r3, null, r4);     // Catch: PackageManager.NameNotFoundException -> L16
        int r2 = -3;
        if (r6.getStatusCode() != 0) goto L12;
        Typeface r7 = TypefaceCompat.createFromFontInfo(r3, null, r6.getFonts(), r5);
        if (r7 == null) goto L10;
        r2 = 0;
    L10:
        return new TypefaceResult(r7, r2);
    L12:
        if (r6.getStatusCode() != 1) goto L15;
        r2 = -2;
    L15:
        return new TypefaceResult(null, r2);
    L17:
        return new TypefaceResult(null, -1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFontSync(final Context r2, final FontRequest r3, @Nullable final ResourcesCompat.FontCallback r4, @Nullable final Handler r5, boolean r6, int r7, final int r8) {
        final String r0 = r3.getIdentifier() + "-" + r8;
        Typeface r1 = sTypefaceCache.get(r0);
        if (r1 == null) goto L7;
        if (r4 == null) goto L6;
        r4.onFontRetrieved(r1);
    L6:
        return r1;
    L7:
        if (r6 == true) goto L9;
    L18:
        Callable<TypefaceResult> r9 = new AnonymousClass1(r2, r3, r8, r0);
        if (r6 == true) goto L43;
        if (r4 != null) goto L24;
        SelfDestructiveThread.ReplyCallback<TypefaceResult> r10 = null;
    L25:
        Object r11 = sLock;
        monitor-enter(r11);
        SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> r12 = sPendingReplies;     // Catch: Throwable -> L31
        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> r13 = r12.get(r0);     // Catch: Throwable -> L31
        if (r13 == null) goto L35;
        if (r10 == null) goto L33;
        r13.add(r10);     // Catch: Throwable -> L31
    L33:
        monitor-exit(r11);     // Catch: Throwable -> L31
        return null;
    L35:
        if (r10 == null) goto L37;
        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> r14 = new ArrayList();     // Catch: Throwable -> L31
        r14.add(r10);     // Catch: Throwable -> L31
        r12.put(r0, r14);     // Catch: Throwable -> L31
    L37:
        monitor-exit(r11);     // Catch: Throwable -> L31
        sBackgroundThread.postAndReply(r9, new AnonymousClass3(r0));
        return null;
    L31:
        th = move-exception;
        throw th;
    L24:
        r10 = new AnonymousClass2(r4, r5);
        goto L25
    L43:
        return ((TypefaceResult) sBackgroundThread.postAndWait(r9, r7)).mTypeface;
    L46:
        return null;
    L9:
        if (r7 != (-1)) goto L18;
        TypefaceResult r15 = getFontInternal(r2, r3, r8);
        if (r4 == null) goto L17;
        int r16 = r15.mResult;
        if (r16 != 0) goto L15;
        r4.callbackSuccessAsync(r15.mTypeface, r5);
        goto L17
    L15:
        r4.callbackFailAsync(r16, r5);
    L17:
        return r15.mTypeface;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static ProviderInfo getProvider(@NonNull PackageManager r5, @NonNull FontRequest r6, @Nullable Resources r7) {
        String r0 = r6.getProviderAuthority();
        int r1 = 0;
        ProviderInfo r2 = r5.resolveContentProvider(r0, 0);
        if (r2 == null) goto L18;
        if (r2.packageName.equals(r6.getProviderPackage()) == false) goto L15;
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
    L15:
        StringBuilder r11 = a.u("Found content provider ", r0, ", but package was not ");
        r11.append(r6.getProviderPackage());
        throw new PackageManager.NameNotFoundException(r11.toString());
    L18:
        throw new PackageManager.NameNotFoundException(a.A("No package found for authority: ", r0));
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Map<Uri, ByteBuffer> prepareFontData(Context r5, FontInfo[] r6, CancellationSignal r7) {
        HashMap r0 = new HashMap();
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        FontInfo r3 = r6[r2];
        if (r3.getResultCode() != 0) goto L11;
        Uri r4 = r3.getUri();
        if (r0.containsKey(r4) == true) goto L11;
        r0.put(r4, TypefaceCompatUtil.mmap(r5, r7, r4));
    L11:
        r2 = r2 + 1;
        goto L3
    L13:
        return Collections.unmodifiableMap(r0);
    }

    public static void requestFont(@NonNull Context r0, @NonNull FontRequest r1, @NonNull FontRequestCallback r2, @NonNull Handler r3) {
        requestFontInternal(r0.getApplicationContext(), r1, r2, r3);
    }

    private static void requestFontInternal(@NonNull final Context r2, @NonNull final FontRequest r3, @NonNull final FontRequestCallback r4, @NonNull Handler r5) {
        final Handler r0 = new Handler();
        r5.post(new AnonymousClass4(r2, r3, r0, r4));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void resetCache() {
        sTypefaceCache.evictAll();
    }
}
