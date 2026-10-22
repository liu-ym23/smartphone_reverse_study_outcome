package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    @RequiresApi(21)
    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = null;

        static {
            PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        private Api21Impl() {
        }

        @DoNotInline
        static Locale forLanguageTag(String r0) {
            return Locale.forLanguageTag(r0);
        }

        private static boolean isPseudoLocale(Locale r5) {
            Locale[] r0 = PSEUDO_LOCALE;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            if (r0[r3].equals(r5) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @DoNotInline
        static boolean matchesLanguageAndScript(@NonNull Locale r4, @NonNull Locale r5) {
            if (r4.equals(r5) == false) goto L6;
            return true;
        L6:
            if (r4.getLanguage().equals(r5.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (isPseudoLocale(r4) == false) goto L11;
        L24:
            return false;
        L11:
            if (isPseudoLocale(r5) == true) goto L24;
            String r0 = ICUCompat.maximizeAndGetScript(r4);
            if (r0.isEmpty() == false) goto L23;
            String r6 = r4.getCountry();
            if (r6.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r6.equals(r5.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r0.equals(ICUCompat.maximizeAndGetScript(r5));
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleList createLocaleList(Locale... r1) {
            return new LocaleList(r1);
        }

        @DoNotInline
        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        @DoNotInline
        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface r1) {
        this.mImpl = r1;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... r2) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.createLocaleList(r2));
    L7:
        return new LocaleListCompat(new LocaleListCompatWrapper(r2));
    }

    static Locale forLanguageTagCompat(String r6) {
        if (r6.contains("-") == false) goto L17;
        String[] r0 = r6.split("-", -1);
        if (r0.length <= 2) goto L9;
        return new Locale(r0[0], r0[1], r0[2]);
    L9:
        if (r0.length <= 1) goto L13;
        return new Locale(r0[0], r0[1]);
    L13:
        if (r0.length != 1) goto L31;
        return new Locale(r0[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r6 + "]");
    L17:
        if (r6.contains("_") == false) goto L33;
        String[] r1 = r6.split("_", -1);
        if (r1.length <= 2) goto L23;
        return new Locale(r1[0], r1[1], r1[2]);
    L23:
        if (r1.length <= 1) goto L27;
        return new Locale(r1[0], r1[1]);
    L27:
        if (r1.length != 1) goto L31;
        return new Locale(r1[0]);
    L33:
        return new Locale(r6);
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String r5) {
        if (r5 == null) goto L16;
        if (r5.isEmpty() == true) goto L16;
        String[] r6 = r5.split(",", -1);
        int r0 = r6.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L14;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        Locale r3 = Api21Impl.forLanguageTag(r6[r2]);
    L12:
        r1[r2] = r3;
        r2 = r2 + 1;
        goto L7
    L11:
        r3 = forLanguageTagCompat(r6[r2]);
        goto L12
    L14:
        return create(r1);
    L16:
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getAdjustedDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(21)
    public static boolean matchesLanguageAndScript(@NonNull Locale r2, @NonNull Locale r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return LocaleList.matchesLanguageAndScript(r2, r3);
    L7:
        if (Build.VERSION.SDK_INT < 21) goto L11;
        return Api21Impl.matchesLanguageAndScript(r2, r3);
    L11:
        throw new UnsupportedOperationException("This method is only supported on API level 21+");
    }

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList r2) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r2));
    }

    @RequiresApi(24)
    @Deprecated
    public static LocaleListCompat wrap(Object r0) {
        return wrap((LocaleList) r0);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r2).mImpl) == false) goto L7;
        return true;
    }

    @Nullable
    public Locale get(int r1) {
        return this.mImpl.get(r1);
    }

    @Nullable
    public Locale getFirstMatch(@NonNull String[] r1) {
        return this.mImpl.getFirstMatch(r1);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    @IntRange(from = -1)
    public int indexOf(@Nullable Locale r1) {
        return this.mImpl.indexOf(r1);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    @IntRange(from = 0)
    public int size() {
        return this.mImpl.size();
    }

    @NonNull
    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    @NonNull
    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}
