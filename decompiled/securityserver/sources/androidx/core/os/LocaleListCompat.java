package androidx.core.os;

import a.a;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private LocaleListInterface mImpl;

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface r1) {
        this.mImpl = r1;
    }

    @NonNull
    public static LocaleListCompat create(@NonNull Locale... r1) {
        return wrap(new LocaleList(r1));
    }

    public static Locale forLanguageTagCompat(String r6) {
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
        throw new IllegalArgumentException(a.k("Can not parse language tag: [", r6, "]"));
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
    public static LocaleListCompat forLanguageTags(@Nullable String r4) {
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        String[] r5 = r4.split(",", -1);
        int r0 = r5.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L10;
        r1[r2] = Locale.forLanguageTag(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L10:
        return create(r1);
    L12:
        return getEmptyLocaleList();
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getAdjustedDefault() {
        return wrap(LocaleList.getAdjustedDefault());
    }

    @NonNull
    @Size(min = 1)
    public static LocaleListCompat getDefault() {
        return wrap(LocaleList.getDefault());
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
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
    public int indexOf(Locale r1) {
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

    public String toString() {
        return this.mImpl.toString();
    }

    @Nullable
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    @NonNull
    @RequiresApi(24)
    public static LocaleListCompat wrap(@NonNull LocaleList r2) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r2));
    }
}
