package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final String PARCEL_FONT_RESULTS = "font_results";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int RESULT_CODE_PROVIDER_NOT_FOUND = -1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int RESULT_CODE_WRONG_CERTIFICATES = -2;

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
        @Deprecated
        public FontFamilyResult(int r1, @Nullable FontInfo[] r2) {
            this.mStatusCode = r1;
            this.mFonts = r2;
        }

        static FontFamilyResult create(int r1, @Nullable FontInfo[] r2) {
            return new FontFamilyResult(r1, r2);
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
        @Deprecated
        public FontInfo(@NonNull Uri r1, @IntRange(from = 0) int r2, @IntRange(from = 1, to = 1000) int r3, boolean r4, int r5) {
            this.mUri = (Uri) Preconditions.checkNotNull(r1);
            this.mTtcIndex = r2;
            this.mWeight = r3;
            this.mItalic = r4;
            this.mResultCode = r5;
        }

        static FontInfo create(@NonNull Uri r7, @IntRange(from = 0) int r8, @IntRange(from = 1, to = 1000) int r9, boolean r10, int r11) {
            return new FontInfo(r7, r8, r9, r10, r11);
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
        @Deprecated
        public static final int RESULT_OK = 0;
        static final int RESULT_SUCCESS = 0;

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

    private FontsContractCompat() {
    }

    @Nullable
    public static Typeface buildTypeface(@NonNull Context r1, @Nullable CancellationSignal r2, @NonNull FontInfo[] r3) {
        return TypefaceCompat.createFromFontInfo(r1, r2, r3, 0);
    }

    @NonNull
    public static FontFamilyResult fetchFonts(@NonNull Context r0, @Nullable CancellationSignal r1, @NonNull FontRequest r2) {
        return FontProvider.getFontFamilyResult(r0, r2, r1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface getFontSync(Context r7, FontRequest r8, @Nullable ResourcesCompat.FontCallback r9, @Nullable Handler r10, boolean r11, int r12, int r13) {
        TypefaceCompat.ResourcesCallbackAdapter r6 = new TypefaceCompat.ResourcesCallbackAdapter(r9);
        return requestFont(r7, r8, r13, r11, r12, ResourcesCompat.FontCallback.getHandler(r10), r6);
    }

    @VisibleForTesting
    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ProviderInfo getProvider(@NonNull PackageManager r0, @NonNull FontRequest r1, @Nullable Resources r2) {
        return FontProvider.getProvider(r0, r1, r2);
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> prepareFontData(Context r0, FontInfo[] r1, CancellationSignal r2) {
        return TypefaceCompatUtil.readFontInfoIntoByteBuffer(r0, r1, r2);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface requestFont(@NonNull Context r1, @NonNull FontRequest r2, int r3, boolean r4, @IntRange(from = 0) int r5, @NonNull Handler r6, @NonNull FontRequestCallback r7) {
        CallbackWithHandler r0 = new CallbackWithHandler(r7, r6);
        if (r4 == false) goto L7;
        return FontRequestWorker.requestFontSync(r1, r2, r0, r3, r5);
    L7:
        return FontRequestWorker.requestFontAsync(r1, r2, r3, null, r0);
    }

    public static void requestFont(@NonNull Context r1, @NonNull FontRequest r2, @NonNull FontRequestCallback r3, @NonNull Handler r4) {
        CallbackWithHandler r0 = new CallbackWithHandler(r3);
        Executor r5 = RequestExecutor.createHandlerExecutor(r4);
        FontRequestWorker.requestFontAsync(r1.getApplicationContext(), r2, 0, r5, r0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void resetCache() {
        FontRequestWorker.resetTypefaceCache();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public static void resetTypefaceCache() {
        FontRequestWorker.resetTypefaceCache();
    }
}
