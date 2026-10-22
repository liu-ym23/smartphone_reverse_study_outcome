package com.google.i18n.phonenumbers;

import com.bytedance.librarian.LibrarianImpl;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    private static final Pattern[] INNER_MATCHES = null;
    private static final Pattern LEAD_CLASS = null;
    private static final Pattern MATCHING_BRACKETS = null;
    private static final Pattern PATTERN = null;
    private static final Pattern PUB_PAGES = null;
    private static final Pattern SLASH_SEPARATED_DATES = null;
    private static final Pattern TIME_STAMPS = null;
    private static final Pattern TIME_STAMPS_SUFFIX = null;
    private PhoneNumberMatch lastMatch;
    private final PhoneNumberUtil.Leniency leniency;
    private long maxTries;
    private final PhoneNumberUtil phoneUtil;
    private final String preferredRegion;
    private final RegexCache regexCache;
    private int searchIndex;
    private State state;
    private final CharSequence text;

    interface NumberGroupingChecker {
        boolean checkGroups(PhoneNumberUtil r1, Phonenumber.PhoneNumber r2, StringBuilder r3, String[] r4);
    }

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State DONE = null;
        public static final State NOT_READY = null;
        public static final State READY = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{NOT_READY, READY, DONE};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            NOT_READY = new State("NOT_READY", 0);
            READY = new State("READY", 1);
            DONE = new State("DONE", 2);
            $VALUES = $values();
        }
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ PhoneNumberMatch next() {
        return next();
    }

    static {
        PUB_PAGES = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
        SLASH_SEPARATED_DATES = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
        TIME_STAMPS = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
        TIME_STAMPS_SUFFIX = Pattern.compile(":[0-5]\\d");
        INNER_MATCHES = new Pattern[]{Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};
        MATCHING_BRACKETS = Pattern.compile("(?:[(\\[（［])?(?:[^(\\[（［)\\]）］]+[)\\]）］])?[^(\\[（［)\\]）］]+(?:[(\\[（［][^(\\[（［)\\]）］]+[)\\]）］])" + limit(0, 3) + "[^(\\[（［)\\]）］]*");
        String r0 = limit(0, 2);
        String r1 = limit(0, 4);
        String r2 = limit(0, 20);
        String r3 = "[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]" + r1;
        String r4 = "\\p{Nd}" + limit(1, 20);
        LEAD_CLASS = Pattern.compile("[(\\[（［+＋]");
        PATTERN = Pattern.compile("(?:[(\\[（［+＋]" + r3 + ")" + r0 + r4 + "(?:" + r3 + r4 + ")" + r2 + "(?:" + PhoneNumberUtil.EXTN_PATTERNS_FOR_MATCHING + ")?", 66);
    }

    private static String limit(int r2, int r3) {
        if (r2 < 0) goto L8;
        if (r3 <= 0) goto L8;
        if (r3 < r2) goto L8;
        return "{" + r2 + "," + r3 + "}";
    L8:
        throw new IllegalArgumentException();
    }

    PhoneNumberMatcher(PhoneNumberUtil r4, CharSequence r5, String r6, PhoneNumberUtil.Leniency r7, long r8) {
        this.state = State.NOT_READY;
        this.lastMatch = null;
        this.searchIndex = 0;
        this.regexCache = new RegexCache(32);
        if (r4 == null) goto L15;
        if (r7 != null) goto L6;
        throw null;
    L6:
        if (r8 < 0) goto L14;
        this.phoneUtil = r4;
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        this.text = r5;
        this.preferredRegion = r6;
        this.leniency = r7;
        this.maxTries = r8;
        return;
    L14:
        throw new IllegalArgumentException();
    L15:
        throw null;
    }

    private PhoneNumberMatch find(int r6) {
        Matcher r0 = PATTERN.matcher(this.text);
    L4:
        if (this.maxTries <= 0) goto L11;
        if (r0.find(r6) == false) goto L16;
        int r7 = r0.start();
        CharSequence r1 = trimAfterFirstMatch(PhoneNumberUtil.SECOND_NUMBER_START_PATTERN, this.text.subSequence(r7, r0.end()));
        PhoneNumberMatch r2 = extractMatch(r1, r7);
        if (r2 != null) goto L9;
        r6 = r7 + r1.length();
        this.maxTries--;
        goto L4
    L9:
        return r2;
    L16:
        return null;
    L11:
        return null;
    }

    private static CharSequence trimAfterFirstMatch(Pattern r1, CharSequence r2) {
        Matcher r3 = r1.matcher(r2);
        if (r3.find() == true) goto L5;
        return r2;
    L5:
        return r2.subSequence(0, r3.start());
    }

    static boolean isLatinLetter(char r3) {
        if (Character.isLetter(r3) == false) goto L5;
    L7:
        Character.UnicodeBlock r4 = Character.UnicodeBlock.of(r3);
        if (r4.equals(Character.UnicodeBlock.BASIC_LATIN) == false) goto L10;
    L19:
        return true;
    L10:
        if (r4.equals(Character.UnicodeBlock.LATIN_1_SUPPLEMENT) == true) goto L19;
        if (r4.equals(Character.UnicodeBlock.LATIN_EXTENDED_A) == true) goto L19;
        if (r4.equals(Character.UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) == true) goto L19;
        if (r4.equals(Character.UnicodeBlock.LATIN_EXTENDED_B) == true) goto L19;
        if (r4.equals(Character.UnicodeBlock.COMBINING_DIACRITICAL_MARKS) == true) goto L19;
        return false;
    L5:
        if (Character.getType(r3) == 6) goto L7;
        return false;
    }

    private static boolean isInvalidPunctuationSymbol(char r1) {
        if (r1 != '%') goto L5;
    L8:
        return true;
    L5:
        if (Character.getType(r1) == 26) goto L8;
        return false;
    }

    private PhoneNumberMatch extractMatch(CharSequence r4, int r5) {
        if (SLASH_SEPARATED_DATES.matcher(r4).find() == false) goto L6;
        return null;
    L6:
        if (TIME_STAMPS.matcher(r4).find() == false) goto L10;
        String r0 = this.text.toString().substring(r4.length() + r5);
        if (TIME_STAMPS_SUFFIX.matcher(r0).lookingAt() == false) goto L10;
        return null;
    L10:
        PhoneNumberMatch r1 = parseAndVerify(r4, r5);
        if (r1 == null) goto L14;
        return r1;
    L14:
        return extractInnerMatch(r4, r5);
    }

    private PhoneNumberMatch extractInnerMatch(CharSequence r12, int r13) {
        Pattern[] r0 = INNER_MATCHES;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L20;
        Matcher r4 = r0[r3].matcher(r12);
        boolean r6 = true;
    L6:
        if (r4.find() == false) goto L19;
        if (this.maxTries <= 0) goto L19;
        if (r6 == false) goto L15;
        PhoneNumberMatch r7 = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, r12.subSequence(0, r4.start())), r13);
        if (r7 != null) goto L13;
        this.maxTries--;
        r6 = false;
        goto L15
    L13:
        return r7;
    L15:
        PhoneNumberMatch r9 = parseAndVerify(trimAfterFirstMatch(PhoneNumberUtil.UNWANTED_END_CHAR_PATTERN, r4.group(1)), r4.start(1) + r13);
        if (r9 != null) goto L17;
        this.maxTries--;
        goto L6
    L17:
        return r9;
    L19:
        r3 = r3 + 1;
        goto L3
    L20:
        return null;
    }

    private PhoneNumberMatch parseAndVerify(CharSequence r5, int r6) {
        if (MATCHING_BRACKETS.matcher(r5).matches() == false) goto L29;
        if (PUB_PAGES.matcher(r5).find() == true) goto L29;
        if (this.leniency.compareTo(PhoneNumberUtil.Leniency.VALID) < 0) goto L25;
        if (r6 > 0) goto L12;
    L18:
        int r1 = r5.length() + r6;     // Catch: NumberParseException -> L30
        if (r1 >= this.text.length()) goto L25;
        char r2 = this.text.charAt(r1);     // Catch: NumberParseException -> L30
        if (isInvalidPunctuationSymbol(r2) == false) goto L23;
    L24:
        return null;
    L23:
        if (isLatinLetter(r2) == false) goto L25;
    L12:
        if (LEAD_CLASS.matcher(r5).lookingAt() == true) goto L18;
        char r3 = this.text.charAt(r6 - 1);     // Catch: NumberParseException -> L30
        if (isInvalidPunctuationSymbol(r3) == false) goto L16;
    L17:
        return null;
    L16:
        if (isLatinLetter(r3) == false) goto L18;
    L25:
        Phonenumber.PhoneNumber r4 = this.phoneUtil.parseAndKeepRawInput(r5, this.preferredRegion);     // Catch: NumberParseException -> L30
        if (this.leniency.verify(r4, r5, this.phoneUtil, this) == false) goto L29;
        r4.clearCountryCodeSource();     // Catch: NumberParseException -> L30
        r4.clearRawInput();     // Catch: NumberParseException -> L30
        r4.clearPreferredDomesticCarrierCode();     // Catch: NumberParseException -> L30
        return new PhoneNumberMatch(r6, r5.toString(), r4);
    L29:
        return null;
    }

    static boolean allNumberGroupsRemainGrouped(PhoneNumberUtil r5, Phonenumber.PhoneNumber r6, StringBuilder r7, String[] r8) {
        if (r6.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) goto L5;
        String r0 = Integer.toString(r6.getCountryCode());
        int r1 = r7.indexOf(r0) + r0.length();
    L6:
        int r2 = 0;
    L8:
        if (r2 >= r8.length) goto L24;
        int r3 = r7.indexOf(r8[r2], r1);
        if (r3 < 0) goto L11;
        r1 = r3 + r8[r2].length();
        if (r2 != 0) goto L22;
        if (r1 >= r7.length()) goto L22;
        if (r5.getNddPrefixForRegion(r5.getRegionCodeForCountryCode(r6.getCountryCode()), true) == null) goto L22;
        if (Character.isDigit(r7.charAt(r1)) == false) goto L22;
        return r7.substring(r1 - r8[r2].length()).startsWith(r5.getNationalSignificantNumber(r6));
    L22:
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L24:
        return r7.substring(r1).contains(r6.getExtension());
    L5:
        r1 = 0;
        goto L6
    }

    static boolean allNumberGroupsAreExactlyPresent(PhoneNumberUtil r4, Phonenumber.PhoneNumber r5, StringBuilder r6, String[] r7) {
        String[] r8 = PhoneNumberUtil.NON_DIGITS_PATTERN.split(r6.toString());
        if (r5.hasExtension() == false) goto L5;
        int r0 = r8.length - 2;
    L7:
        if (r8.length != 1) goto L9;
        return true;
    L9:
        if (r8[r0].contains(r4.getNationalSignificantNumber(r5)) == true) goto L29;
        int r9 = r7.length - 1;
    L13:
        if (r9 <= 0) goto L19;
        if (r0 < 0) goto L19;
        if (r8[r0].equals(r7[r9]) == false) goto L17;
        r9 = r9 - 1;
        r0 = r0 - 1;
        goto L13
    L17:
        return false;
    L19:
        if (r0 < 0) goto L24;
        if (r8[r0].endsWith(r7[0]) == false) goto L24;
        return true;
    L24:
        return false;
    L29:
        return true;
    L5:
        r0 = r8.length - 1;
        goto L7
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil r1, Phonenumber.PhoneNumber r2) {
        String r3 = r1.format(r2, PhoneNumberUtil.PhoneNumberFormat.RFC3966);
        int r4 = r3.indexOf(59);
        if (r4 >= 0) goto L6;
        r4 = r3.length();
    L6:
        return r3.substring(r3.indexOf(45) + 1, r4).split("-");
    }

    private static String[] getNationalNumberGroups(PhoneNumberUtil r1, Phonenumber.PhoneNumber r2, Phonemetadata.NumberFormat r3) {
        return r1.formatNsnUsingPattern(r1.getNationalSignificantNumber(r2), r3, PhoneNumberUtil.PhoneNumberFormat.RFC3966).split("-");
    }

    boolean checkNumberGroupingIsValid(Phonenumber.PhoneNumber r8, CharSequence r9, PhoneNumberUtil r10, NumberGroupingChecker r11) {
        StringBuilder r12 = PhoneNumberUtil.normalizeDigits(r9, true);
        if (r11.checkGroups(r10, r8, r12, getNationalNumberGroups(r10, r8)) == false) goto L5;
        return true;
    L5:
        Phonemetadata.PhoneMetadata r1 = DefaultMetadataDependenciesProvider.getInstance().getAlternateFormatsMetadataSource().getFormattingMetadataForCountryCallingCode(r8.getCountryCode());
        String r2 = r10.getNationalSignificantNumber(r8);
        if (r1 == null) goto L18;
        Iterator<Phonemetadata.NumberFormat> r3 = r1.getNumberFormatList().iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        Phonemetadata.NumberFormat r4 = r3.next();
        if (r4.getLeadingDigitsPatternCount() <= 0) goto L16;
        if (this.regexCache.getPatternForRegex(r4.getLeadingDigitsPattern(0)).matcher(r2).lookingAt() == false) goto L9;
    L16:
        if (r11.checkGroups(r10, r8, r12, getNationalNumberGroups(r10, r8, r4)) == false) goto L9;
        return true;
    L18:
        return false;
    }

    static boolean containsMoreThanOneSlashInNationalNumber(Phonenumber.PhoneNumber r6, String r7) {
        int r1 = r7.indexOf(47);
        if (r1 >= 0) goto L5;
        return false;
    L5:
        int r0 = r7.indexOf(47, r1 + 1);
        if (r0 >= 0) goto L9;
        return false;
    L9:
        if (r6.getCountryCodeSource() != Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L17;
    L20:
        return true;
    L17:
        if (PhoneNumberUtil.normalizeDigitsOnly(r7.substring(0, r1)).equals(Integer.toString(r6.getCountryCode())) == false) goto L20;
        return r7.substring(r0 + 1).contains(LibrarianImpl.Constants.SEPARATOR);
    L11:
        if (r6.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN) goto L14;
        r3 = false;
        goto L15
    }

    static boolean containsOnlyValidXChars(Phonenumber.PhoneNumber r7, String r8, PhoneNumberUtil r9) {
        int r1 = 0;
    L4:
        if (r1 >= (r8.length() - 1)) goto L20;
        char r2 = r8.charAt(r1);
        if (r2 == 'x') goto L8;
        if (r2 == 'X') goto L8;
    L19:
        r1 = r1 + 1;
    L8:
        int r3 = r1 + 1;
        char r6 = r8.charAt(r3);
        if (r6 == 'x') goto L16;
        if (r6 == 'X') goto L16;
        if (PhoneNumberUtil.normalizeDigitsOnly(r8.substring(r1)).equals(r7.getExtension()) == true) goto L19;
        return false;
    L16:
        if (r9.isNumberMatch(r7, r8.substring(r3)) != PhoneNumberUtil.MatchType.NSN_MATCH) goto L17;
        r1 = r3;
        goto L19
    L17:
        return false;
    L20:
        return true;
    }

    static boolean isNationalPrefixPresentIfRequired(Phonenumber.PhoneNumber r4, PhoneNumberUtil r5) {
        if (r4.getCountryCodeSource() == Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) goto L5;
        return true;
    L5:
        Phonemetadata.PhoneMetadata r0 = r5.getMetadataForRegion(r5.getRegionCodeForCountryCode(r4.getCountryCode()));
        if (r0 != null) goto L8;
        return true;
    L8:
        String r1 = r5.getNationalSignificantNumber(r4);
        Phonemetadata.NumberFormat r2 = r5.chooseFormattingPatternForNumber(r0.getNumberFormatList(), r1);
        if (r2 != null) goto L11;
    L20:
        return true;
    L11:
        if (r2.getNationalPrefixFormattingRule().length() <= 0) goto L20;
        if (r2.getNationalPrefixOptionalWhenFormatting() == false) goto L16;
        return true;
    L16:
        if (PhoneNumberUtil.formattingRuleHasFirstGroupOnly(r2.getNationalPrefixFormattingRule()) == false) goto L19;
        return true;
    L19:
        return r5.maybeStripNationalPrefixAndCarrierCode(new StringBuilder(PhoneNumberUtil.normalizeDigitsOnly(r4.getRawInput())), r0, null);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.state != State.NOT_READY) goto L9;
        PhoneNumberMatch r0 = find(this.searchIndex);
        this.lastMatch = r0;
        if (r0 != null) goto L7;
        this.state = State.DONE;
        goto L9
    L7:
        this.searchIndex = r0.end();
        this.state = State.READY;
    L9:
        if (this.state != State.READY) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public PhoneNumberMatch next() {
        if (hasNext() == false) goto L7;
        PhoneNumberMatch r0 = this.lastMatch;
        this.lastMatch = null;
        this.state = State.NOT_READY;
        return r0;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
