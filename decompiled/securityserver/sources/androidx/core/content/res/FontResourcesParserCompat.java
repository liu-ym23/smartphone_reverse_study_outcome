package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        private boolean mItalic;
        private int mResourceId;
        private int mTtcIndex;
        private String mVariationSettings;
        private int mWeight;

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
        private final int mTimeoutMs;

        public ProviderResourceEntry(@NonNull FontRequest r1, int r2, int r3) {
            this.mRequest = r1;
            this.mStrategy = r2;
            this.mTimeoutMs = r3;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        @NonNull
        public FontRequest getRequest() {
            return this.mRequest;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private FontResourcesParserCompat() {
    }

    private static int getType(TypedArray r0, int r1) {
        return r0.getType(r1);
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser r3, Resources r4) {
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

    public static List<List<byte[]>> readCerts(Resources r5, @ArrayRes int r6) {
        if (r6 == 0) goto L4;
        TypedArray r0 = r5.obtainTypedArray(r6);
    L11:
        th = move-exception;
        r0.recycle();
        throw th;
    L7:
        if (r0.length() != 0) goto L13;
        List<List<byte[]>> r7 = Collections.emptyList();     // Catch: Throwable -> L11
        r0.recycle();
        return r7;
    L13:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L11
        if (getType(r0, 0) != 1) goto L22;
        int r8 = 0;
    L17:
        if (r8 >= r0.length()) goto L23;
        int r3 = r0.getResourceId(r8, 0);     // Catch: Throwable -> L11
        if (r3 == 0) goto L21;
        r1.add(toByteArrayList(r5.getStringArray(r3)));     // Catch: Throwable -> L11
    L21:
        r8 = r8 + 1;     // Catch: Throwable -> L11
    L23:
        r0.recycle();
        return r1;
    L22:
        r1.add(toByteArrayList(r5.getStringArray(r6)));     // Catch: Throwable -> L11
        goto L23
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
    private static FamilyResourceEntry readFamily(XmlPullParser r8, Resources r9) {
        TypedArray r0 = r9.obtainAttributes(Xml.asAttributeSet(r8), R.styleable.FontFamily);
        String r1 = r0.getString(R.styleable.FontFamily_fontProviderAuthority);
        String r2 = r0.getString(R.styleable.FontFamily_fontProviderPackage);
        String r3 = r0.getString(R.styleable.FontFamily_fontProviderQuery);
        int r4 = r0.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int r5 = r0.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int r6 = r0.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        r0.recycle();
        if (r1 == null) goto L11;
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
    L7:
        if (r8.next() == 3) goto L10;
        skip(r8);
        goto L7
    L10:
        return new ProviderResourceEntry(new FontRequest(r1, r2, r3, readCerts(r9, r4)), r5, r6);
    L11:
        ArrayList r7 = new ArrayList();
    L13:
        if (r8.next() == 3) goto L22;
        if (r8.getEventType() != 2) goto L13;
        if (r8.getName().equals("font") == true) goto L19;
        skip(r8);
        goto L13
    L19:
        r7.add(readFont(r8, r9));
        goto L13
    L22:
        if (r7.isEmpty() == false) goto L26;
        return null;
    L26:
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) r7.toArray(new FontFileResourceEntry[r7.size()]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser r9, Resources r10) {
        TypedArray r11 = r10.obtainAttributes(Xml.asAttributeSet(r9), R.styleable.FontFamilyFont);
        if (r11.hasValue(R.styleable.FontFamilyFont_fontWeight) == false) goto L5;
        int r0 = R.styleable.FontFamilyFont_fontWeight;
    L6:
        int r4 = r11.getInt(r0, 400);
        if (r11.hasValue(R.styleable.FontFamilyFont_fontStyle) == false) goto L9;
        int r1 = R.styleable.FontFamilyFont_fontStyle;
    L11:
        if (1 != r11.getInt(r1, 0)) goto L13;
        boolean r5 = true;
    L15:
        if (r11.hasValue(R.styleable.FontFamilyFont_ttcIndex) == false) goto L17;
        int r2 = R.styleable.FontFamilyFont_ttcIndex;
    L19:
        if (r11.hasValue(R.styleable.FontFamilyFont_fontVariationSettings) == false) goto L21;
        int r3 = R.styleable.FontFamilyFont_fontVariationSettings;
    L22:
        String r6 = r11.getString(r3);
        int r7 = r11.getInt(r2, 0);
        if (r11.hasValue(R.styleable.FontFamilyFont_font) == false) goto L25;
        int r8 = R.styleable.FontFamilyFont_font;
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
    L25:
        r8 = R.styleable.FontFamilyFont_android_font;
        goto L26
    L21:
        r3 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        goto L22
    L17:
        r2 = R.styleable.FontFamilyFont_android_ttcIndex;
        goto L19
    L13:
        r5 = false;
        goto L15
    L9:
        r1 = R.styleable.FontFamilyFont_android_fontStyle;
        goto L11
    L5:
        r0 = R.styleable.FontFamilyFont_android_fontWeight;
        goto L6
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
