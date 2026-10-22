package android.icu.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ULocale implements Serializable, Comparable<ULocale> {
    public static final ULocale CANADA = null;
    public static final ULocale CANADA_FRENCH = null;
    public static final ULocale CHINA = null;
    public static final ULocale CHINESE = null;
    public static final ULocale ENGLISH = null;
    public static final ULocale FRANCE = null;
    public static final ULocale FRENCH = null;
    public static final ULocale GERMAN = null;
    public static final ULocale GERMANY = null;
    public static final ULocale ITALIAN = null;
    public static final ULocale ITALY = null;
    public static final ULocale JAPAN = null;
    public static final ULocale JAPANESE = null;
    public static final ULocale KOREA = null;
    public static final ULocale KOREAN = null;
    public static final ULocale PRC = null;
    public static final char PRIVATE_USE_EXTENSION = 'x';
    public static final ULocale ROOT = null;
    public static final ULocale SIMPLIFIED_CHINESE = null;
    public static final ULocale TAIWAN = null;
    public static final ULocale TRADITIONAL_CHINESE = null;
    public static final ULocale UK = null;
    public static final char UNICODE_LOCALE_EXTENSION = 'u';
    public static final ULocale US = null;

    public static final enum AvailableType extends Enum<AvailableType> {
        private static final /* synthetic */ AvailableType[] $VALUES = null;
        public static final AvailableType DEFAULT = null;
        public static final AvailableType ONLY_LEGACY_ALIASES = null;
        public static final AvailableType WITH_LEGACY_ALIASES = null;

        public static AvailableType valueOf(String r1) {
            return (AvailableType) Enum.valueOf(AvailableType.class, r1);
        }

        public static AvailableType[] values() {
            return (AvailableType[]) $VALUES.clone();
        }

        private AvailableType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            AvailableType r0 = new AvailableType("DEFAULT", 0);
            DEFAULT = r0;
            AvailableType r1 = new AvailableType("ONLY_LEGACY_ALIASES", 1);
            ONLY_LEGACY_ALIASES = r1;
            AvailableType r3 = new AvailableType("WITH_LEGACY_ALIASES", 2);
            WITH_LEGACY_ALIASES = r3;
            $VALUES = new AvailableType[]{r0, r1, r3};
        }
    }

    public static final class Builder {
        public Builder() {
            throw new RuntimeException("Stub!");
        }

        public Builder setLocale(ULocale r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setLanguageTag(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setLanguage(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setScript(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setRegion(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setVariant(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder setExtension(char r1, String r2) {
            throw new RuntimeException("Stub!");
        }

        public Builder setUnicodeLocaleKeyword(String r1, String r2) {
            throw new RuntimeException("Stub!");
        }

        public Builder addUnicodeLocaleAttribute(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder removeUnicodeLocaleAttribute(String r1) {
            throw new RuntimeException("Stub!");
        }

        public Builder clear() {
            throw new RuntimeException("Stub!");
        }

        public Builder clearExtensions() {
            throw new RuntimeException("Stub!");
        }

        public ULocale build() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final enum Category extends Enum<Category> {
        private static final /* synthetic */ Category[] $VALUES = null;
        public static final Category DISPLAY = null;
        public static final Category FORMAT = null;

        public static Category valueOf(String r1) {
            return (Category) Enum.valueOf(Category.class, r1);
        }

        public static Category[] values() {
            return (Category[]) $VALUES.clone();
        }

        private Category(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Category r0 = new Category("DISPLAY", 0);
            DISPLAY = r0;
            Category r1 = new Category("FORMAT", 1);
            FORMAT = r1;
            $VALUES = new Category[]{r0, r1};
        }
    }

    static {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULocale r1) {
        return compareTo2(r1);
    }

    public ULocale(String r1) {
        throw new RuntimeException("Stub!");
    }

    public ULocale(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public ULocale(String r1, String r2, String r3) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale forLocale(Locale r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale createCanonical(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale createCanonical(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public Locale toLocale() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale getDefault() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale getDefault(Category r1) {
        throw new RuntimeException("Stub!");
    }

    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public boolean equals(Object r1) {
        throw new RuntimeException("Stub!");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale[] getAvailableLocales() {
        throw new RuntimeException("Stub!");
    }

    public static Collection<ULocale> getAvailableLocalesByType(AvailableType r1) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getISOCountries() {
        throw new RuntimeException("Stub!");
    }

    public static String[] getISOLanguages() {
        throw new RuntimeException("Stub!");
    }

    public String getLanguage() {
        throw new RuntimeException("Stub!");
    }

    public static String getLanguage(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getScript() {
        throw new RuntimeException("Stub!");
    }

    public static String getScript(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getCountry() {
        throw new RuntimeException("Stub!");
    }

    public static String getCountry(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getVariant() {
        throw new RuntimeException("Stub!");
    }

    public static String getVariant(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getFallback(String r1) {
        throw new RuntimeException("Stub!");
    }

    public ULocale getFallback() {
        throw new RuntimeException("Stub!");
    }

    public String getBaseName() {
        throw new RuntimeException("Stub!");
    }

    public static String getBaseName(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getName() {
        throw new RuntimeException("Stub!");
    }

    public static String getName(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public Iterator<String> getKeywords() {
        throw new RuntimeException("Stub!");
    }

    public static Iterator<String> getKeywords(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getKeywordValue(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getKeywordValue(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String canonicalize(String r1) {
        throw new RuntimeException("Stub!");
    }

    public ULocale setKeywordValue(String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public static String setKeywordValue(String r0, String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public String getISO3Language() {
        throw new RuntimeException("Stub!");
    }

    public static String getISO3Language(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getISO3Country() {
        throw new RuntimeException("Stub!");
    }

    public static String getISO3Country(String r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean isRightToLeft() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayLanguage() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayLanguage(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayLanguage(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayLanguage(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayLanguageWithDialect() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayLanguageWithDialect(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayLanguageWithDialect(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayLanguageWithDialect(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayScript() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayScript(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayScript(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayScript(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayCountry() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayCountry(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayCountry(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayCountry(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayVariant() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayVariant(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayVariant(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayVariant(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayKeyword(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayKeyword(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayKeyword(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayKeywordValue(String r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayKeywordValue(String r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayKeywordValue(String r0, String r1, String r2) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayKeywordValue(String r0, String r1, ULocale r2) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayName(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayName(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayNameWithDialect() {
        throw new RuntimeException("Stub!");
    }

    public String getDisplayNameWithDialect(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayNameWithDialect(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String getDisplayNameWithDialect(String r0, ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getCharacterOrientation() {
        throw new RuntimeException("Stub!");
    }

    public String getLineOrientation() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale acceptLanguage(String r0, ULocale[] r1, boolean[] r2) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale acceptLanguage(ULocale[] r0, ULocale[] r1, boolean[] r2) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale acceptLanguage(String r0, boolean[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale acceptLanguage(ULocale[] r0, boolean[] r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale addLikelySubtags(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static ULocale minimizeSubtags(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public String getExtension(char r1) {
        throw new RuntimeException("Stub!");
    }

    public Set<Character> getExtensionKeys() {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getUnicodeLocaleAttributes() {
        throw new RuntimeException("Stub!");
    }

    public String getUnicodeLocaleType(String r1) {
        throw new RuntimeException("Stub!");
    }

    public Set<String> getUnicodeLocaleKeys() {
        throw new RuntimeException("Stub!");
    }

    public String toLanguageTag() {
        throw new RuntimeException("Stub!");
    }

    public static ULocale forLanguageTag(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String toUnicodeLocaleKey(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String toUnicodeLocaleType(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String toLegacyKey(String r1) {
        throw new RuntimeException("Stub!");
    }

    public static String toLegacyType(String r0, String r1) {
        throw new RuntimeException("Stub!");
    }
}
