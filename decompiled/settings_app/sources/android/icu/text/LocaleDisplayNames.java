package android.icu.text;

import android.icu.util.ULocale;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocaleDisplayNames {

    public static final enum DialectHandling extends Enum<DialectHandling> {
        private static final /* synthetic */ DialectHandling[] $VALUES = null;
        public static final DialectHandling DIALECT_NAMES = null;
        public static final DialectHandling STANDARD_NAMES = null;

        public static DialectHandling valueOf(String r1) {
            return (DialectHandling) Enum.valueOf(DialectHandling.class, r1);
        }

        public static DialectHandling[] values() {
            return (DialectHandling[]) $VALUES.clone();
        }

        private DialectHandling(String r1, int r2) {
            super(r1, r2);
        }

        static {
            DialectHandling r0 = new DialectHandling("STANDARD_NAMES", 0);
            STANDARD_NAMES = r0;
            DialectHandling r1 = new DialectHandling("DIALECT_NAMES", 1);
            DIALECT_NAMES = r1;
            $VALUES = new DialectHandling[]{r0, r1};
        }
    }

    public static class UiListItem {
        public final ULocale minimized;
        public final ULocale modified;
        public final String nameInDisplayLocale;
        public final String nameInSelf;

        public UiListItem(ULocale r1, ULocale r2, String r3, String r4) {
            this.minimized = null;
            this.modified = null;
            this.nameInDisplayLocale = null;
            this.nameInSelf = null;
            throw new RuntimeException("Stub!");
        }

        public boolean equals(Object r1) {
            throw new RuntimeException("Stub!");
        }

        public int hashCode() {
            throw new RuntimeException("Stub!");
        }

        public String toString() {
            throw new RuntimeException("Stub!");
        }

        public static Comparator<UiListItem> getComparator(Comparator<Object> r0, boolean r1) {
            throw new RuntimeException("Stub!");
        }
    }

    public abstract DisplayContext getContext(DisplayContext.Type r1);

    public abstract DialectHandling getDialectHandling();

    public abstract ULocale getLocale();

    public abstract List<UiListItem> getUiListCompareWholeItems(Set<ULocale> r1, Comparator<UiListItem> r2);

    public abstract String keyDisplayName(String r1);

    public abstract String keyValueDisplayName(String r1, String r2);

    public abstract String languageDisplayName(String r1);

    public abstract String localeDisplayName(ULocale r1);

    public abstract String localeDisplayName(String r1);

    public abstract String localeDisplayName(Locale r1);

    public abstract String regionDisplayName(String r1);

    public abstract String scriptDisplayName(int r1);

    public abstract String scriptDisplayName(String r1);

    public abstract String variantDisplayName(String r1);

    LocaleDisplayNames() {
        throw new RuntimeException("Stub!");
    }

    public static LocaleDisplayNames getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocaleDisplayNames getInstance(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocaleDisplayNames getInstance(ULocale r0, DialectHandling r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocaleDisplayNames getInstance(ULocale r0, DisplayContext... r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocaleDisplayNames getInstance(Locale r0, DisplayContext... r1) {
        throw new RuntimeException("Stub!");
    }

    public List<UiListItem> getUiList(Set<ULocale> r1, boolean r2, Comparator<Object> r3) {
        throw new RuntimeException("Stub!");
    }
}
