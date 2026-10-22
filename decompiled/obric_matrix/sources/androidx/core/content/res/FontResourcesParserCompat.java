package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.provider.FontRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getType(TypedArray r0, int r1) {
            return r0.getType(r1);
        }
    }

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {

        @NonNull
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] r1) {
            this.mEntries = r1;
        }

        @NonNull
        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class FontFileResourceEntry {

        @NonNull
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(@NonNull String r1, int r2, boolean r3, @Nullable String r4, int r5, int r6) {
            this.mFileName = r1;
            this.mWeight = r2;
            this.mItalic = r3;
            this.mVariationSettings = r4;
            this.mTtcIndex = r5;
            this.mResourceId = r6;
        }

        @NonNull
        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        @Nullable
        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {

        @NonNull
        private final FontRequest mRequest;
        private final int mStrategy;

        @Nullable
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(@NonNull FontRequest r2, int r3, int r4) {
            this(r2, r3, r4, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public ProviderResourceEntry(@NonNull FontRequest r1, int r2, int r3, @Nullable String r4) {
            this.mRequest = r1;
            this.mStrategy = r2;
            this.mTimeoutMs = r3;
            this.mSystemFontFamilyName = r4;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.mRequest;
        }

        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray r2, int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        TypedValue r0 = new TypedValue();
        r2.getValue(r3, r0);
        return r0.type;
    L5:
        return Api21Impl.getType(r2, r3);
    }

    @Nullable
    public static FamilyResourceEntry parse(@NonNull XmlPullParser r3, @NonNull Resources r4) {
    L2:
        int r0 = r3.next();
        if (r0 == 2) goto L7;
        if (r0 != 1) goto L2;
    L7:
        if (r0 != 2) goto L11;
        return readFamilies(r3, r4);
    L11:
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    public static List<List<byte[]>> readCerts(@NonNull Resources r5, @ArrayRes int r6) {
        if (r6 == 0) goto L4;
        TypedArray r0 = r5.obtainTypedArray(r6);
    L23:
        th = move-exception;
        r0.recycle();
        throw th;
    L7:
        if (r0.length() != 0) goto L11;
        List<List<byte[]>> r7 = Collections.emptyList();     // Catch: Throwable -> L23
        r0.recycle();
        return r7;
    L11:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L23
        if (getType(r0, 0) != 1) goto L20;
        int r8 = 0;
    L15:
        if (r8 >= r0.length()) goto L21;
        int r3 = r0.getResourceId(r8, 0);     // Catch: Throwable -> L23
        if (r3 == 0) goto L19;
        r1.add(toByteArrayList(r5.getStringArray(r3)));     // Catch: Throwable -> L23
    L19:
        r8 = r8 + 1;     // Catch: Throwable -> L23
    L21:
        r0.recycle();
        return r1;
    L20:
        r1.add(toByteArrayList(r5.getStringArray(r6)));     // Catch: Throwable -> L23
        goto L21
    L4:
        return Collections.emptyList();
    }

    @Nullable
    private static FamilyResourceEntry readFamilies(XmlPullParser r3, Resources r4) {
        r3.require(2, null, "font-family");
        if (r3.getName().equals("font-family") == true) goto L5;
        skip(r3);
        return null;
    L5:
        return readFamily(r3, r4);
    }

    @Nullable
    private static FamilyResourceEntry readFamily(XmlPullParser r9, Resources r10) {
        TypedArray r0 = r10.obtainAttributes(Xml.asAttributeSet(r9), R.styleable.FontFamily);
        String r1 = r0.getString(R.styleable.FontFamily_fontProviderAuthority);
        String r2 = r0.getString(R.styleable.FontFamily_fontProviderPackage);
        String r3 = r0.getString(R.styleable.FontFamily_fontProviderQuery);
        int r4 = r0.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int r6 = r0.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int r7 = r0.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, DEFAULT_TIMEOUT_MILLIS);
        String r8 = r0.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        r0.recycle();
        if (r1 == null) goto L11;
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
    L7:
        if (r9.next() == 3) goto L10;
        skip(r9);
        goto L7
    L10:
        return new ProviderResourceEntry(new FontRequest(r1, r2, r3, readCerts(r10, r4)), r6, r7, r8);
    L11:
        ArrayList r5 = new ArrayList();
    L13:
        if (r9.next() == 3) goto L22;
        if (r9.getEventType() != 2) goto L13;
        if (r9.getName().equals("font") == true) goto L19;
        skip(r9);
        goto L13
    L19:
        r5.add(readFont(r9, r10));
        goto L13
    L22:
        if (r5.isEmpty() == false) goto L26;
        return null;
    L26:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) r5.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r9, Resources r10) {
        TypedArray r11 = r10.obtainAttributes(Xml.asAttributeSet(r9), R.styleable.FontFamilyFont);
        int r0 = R.styleable.FontFamilyFont_fontWeight;
        if (r11.hasValue(r0) == true) goto L6;
        r0 = R.styleable.FontFamilyFont_android_fontWeight;
    L6:
        int r4 = r11.getInt(r0, NORMAL_WEIGHT);
        int r1 = R.styleable.FontFamilyFont_fontStyle;
        if (r11.hasValue(r1) == true) goto L11;
        r1 = R.styleable.FontFamilyFont_android_fontStyle;
    L11:
        if (1 != r11.getInt(r1, 0)) goto L13;
        boolean r5 = true;
    L14:
        int r2 = R.styleable.FontFamilyFont_ttcIndex;
        if (r11.hasValue(r2) == true) goto L18;
        r2 = R.styleable.FontFamilyFont_android_ttcIndex;
    L18:
        int r3 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (r11.hasValue(r3) == true) goto L22;
        r3 = R.styleable.FontFamilyFont_android_fontVariationSettings;
    L22:
        String r6 = r11.getString(r3);
        int r7 = r11.getInt(r2, 0);
        int r8 = R.styleable.FontFamilyFont_font;
        if (r11.hasValue(r8) == true) goto L26;
        r8 = R.styleable.FontFamilyFont_android_font;
    L26:
        int r12 = r11.getResourceId(r8, 0);
        String r13 = r11.getString(r8);
        r11.recycle();
    L28:
        if (r9.next() == 3) goto L31;
        skip(r9);
        goto L28
    L31:
        return new FontFileResourceEntry(r13, r4, r5, r6, r7, r12);
    L13:
        r5 = false;
        goto L14
    }

    private static void skip(XmlPullParser r3) {
        int r0 = 1;
    L3:
        if (r0 <= 0) goto L11;
        int r1 = r3.next();
        if (r1 != 2) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        if (r1 != 3) goto L3;
        r0 = r0 - 1;
        goto L3
    }

    private static List<byte[]> toByteArrayList(String[] r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r5.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Base64.decode(r5[r3], 0));
        r3 = r3 + 1;
        goto L3
    L5:
        return r0;
    }
}
