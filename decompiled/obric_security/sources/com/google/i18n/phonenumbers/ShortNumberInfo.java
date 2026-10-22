package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.internal.MatcherApi;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes2.dex */
public class ShortNumberInfo {
    private static final ShortNumberInfo INSTANCE = null;
    private static final Set<String> REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = null;
    private static final Logger logger = null;
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final MatcherApi matcherApi;
    private final RegionMetadataSource shortNumberMetadataSource;

    /* JADX INFO: renamed from: com.google.i18n.phonenumbers.ShortNumberInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost = null;

        static {
            int[] r0 = new int[ShortNumberCost.values().length];
            $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost = r0;
            r0[ShortNumberCost.PREMIUM_RATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[ShortNumberCost.UNKNOWN_COST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[ShortNumberCost.STANDARD_RATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[ShortNumberCost.TOLL_FREE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum ShortNumberCost extends Enum<ShortNumberCost> {
        private static final /* synthetic */ ShortNumberCost[] $VALUES = null;
        public static final ShortNumberCost PREMIUM_RATE = null;
        public static final ShortNumberCost STANDARD_RATE = null;
        public static final ShortNumberCost TOLL_FREE = null;
        public static final ShortNumberCost UNKNOWN_COST = null;

        private static /* synthetic */ ShortNumberCost[] $values() {
            return new ShortNumberCost[]{TOLL_FREE, STANDARD_RATE, PREMIUM_RATE, UNKNOWN_COST};
        }

        private ShortNumberCost(String r1, int r2) {
            super(r1, r2);
        }

        public static ShortNumberCost valueOf(String r1) {
            return (ShortNumberCost) Enum.valueOf(ShortNumberCost.class, r1);
        }

        public static ShortNumberCost[] values() {
            return (ShortNumberCost[]) $VALUES.clone();
        }

        static {
            TOLL_FREE = new ShortNumberCost("TOLL_FREE", 0);
            STANDARD_RATE = new ShortNumberCost("STANDARD_RATE", 1);
            PREMIUM_RATE = new ShortNumberCost("PREMIUM_RATE", 2);
            UNKNOWN_COST = new ShortNumberCost("UNKNOWN_COST", 3);
            $VALUES = $values();
        }
    }

    static {
        logger = Logger.getLogger(ShortNumberInfo.class.getName());
        INSTANCE = new ShortNumberInfo(RegexBasedMatcher.create(), DefaultMetadataDependenciesProvider.getInstance().getShortNumberMetadataSource());
        HashSet r0 = new HashSet();
        REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT = r0;
        r0.add("BR");
        r0.add("CL");
        r0.add("NI");
    }

    public static ShortNumberInfo getInstance() {
        return INSTANCE;
    }

    ShortNumberInfo(MatcherApi r1, RegionMetadataSource r2) {
        this.matcherApi = r1;
        this.shortNumberMetadataSource = r2;
        this.countryCallingCodeToRegionCodeMap = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap();
    }

    private List<String> getRegionCodesForCountryCode(int r1) {
        List<String> r0 = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(r1));
        if (r0 != null) goto L6;
        r0 = new ArrayList(0);
    L6:
        return Collections.unmodifiableList(r0);
    }

    private boolean regionDialingFromMatchesNumber(Phonenumber.PhoneNumber r1, String r2) {
        return getRegionCodesForCountryCode(r1.getCountryCode()).contains(r2);
    }

    private Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return this.shortNumberMetadataSource.getMetadataForRegion(r2);
    L7:
        return null;
    }

    public boolean isPossibleShortNumberForRegion(Phonenumber.PhoneNumber r3, String r4) {
        if (regionDialingFromMatchesNumber(r3, r4) == true) goto L5;
        return false;
    L5:
        Phonemetadata.PhoneMetadata r2 = getShortNumberMetadataForRegion(r4);
        if (r2 != null) goto L8;
        return false;
    L8:
        int r5 = getNationalSignificantNumber(r3).length();
        return r2.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(r5));
    }

    public boolean isPossibleShortNumber(Phonenumber.PhoneNumber r4) {
        List<String> r0 = getRegionCodesForCountryCode(r4.getCountryCode());
        int r5 = getNationalSignificantNumber(r4).length();
        Iterator<String> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        Phonemetadata.PhoneMetadata r2 = getShortNumberMetadataForRegion(r1.next());
        if (r2 == null) goto L4;
        if (r2.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(r5)) == false) goto L4;
        return true;
    L12:
        return false;
    }

    public boolean isValidShortNumberForRegion(Phonenumber.PhoneNumber r3, String r4) {
        if (regionDialingFromMatchesNumber(r3, r4) == true) goto L5;
        return false;
    L5:
        Phonemetadata.PhoneMetadata r5 = getShortNumberMetadataForRegion(r4);
        if (r5 != null) goto L8;
        return false;
    L8:
        String r6 = getNationalSignificantNumber(r3);
        if (matchesPossibleNumberAndNationalNumber(r6, r5.getGeneralDesc()) == true) goto L12;
        return false;
    L12:
        return matchesPossibleNumberAndNationalNumber(r6, r5.getShortCode());
    }

    public boolean isValidShortNumber(Phonenumber.PhoneNumber r4) {
        List<String> r0 = getRegionCodesForCountryCode(r4.getCountryCode());
        String r1 = getRegionCodeForShortNumberFromRegionList(r4, r0);
        if (r0.size() <= 1) goto L7;
        if (r1 == null) goto L7;
        return true;
    L7:
        return isValidShortNumberForRegion(r4, r1);
    }

    public ShortNumberCost getExpectedCostForRegion(Phonenumber.PhoneNumber r4, String r5) {
        if (regionDialingFromMatchesNumber(r4, r5) == false) goto L5;
        Phonemetadata.PhoneMetadata r0 = getShortNumberMetadataForRegion(r5);
        if (r0 == null) goto L9;
        String r6 = getNationalSignificantNumber(r4);
        if (r0.getGeneralDesc().getPossibleLengthList().contains(Integer.valueOf(r6.length())) == true) goto L15;
        return ShortNumberCost.UNKNOWN_COST;
    L15:
        if (matchesPossibleNumberAndNationalNumber(r6, r0.getPremiumRate()) == false) goto L19;
        return ShortNumberCost.PREMIUM_RATE;
    L19:
        if (matchesPossibleNumberAndNationalNumber(r6, r0.getStandardRate()) == false) goto L23;
        return ShortNumberCost.STANDARD_RATE;
    L23:
        if (matchesPossibleNumberAndNationalNumber(r6, r0.getTollFree()) == false) goto L27;
        return ShortNumberCost.TOLL_FREE;
    L27:
        if (isEmergencyNumber(r6, r5) == false) goto L31;
        return ShortNumberCost.TOLL_FREE;
    L31:
        return ShortNumberCost.UNKNOWN_COST;
    L9:
        return ShortNumberCost.UNKNOWN_COST;
    L5:
        return ShortNumberCost.UNKNOWN_COST;
    }

    public ShortNumberCost getExpectedCost(Phonenumber.PhoneNumber r9) {
        List<String> r0 = getRegionCodesForCountryCode(r9.getCountryCode());
        if (r0.size() != 0) goto L7;
        return ShortNumberCost.UNKNOWN_COST;
    L7:
        if (r0.size() == 1) goto L9;
        ShortNumberCost r1 = ShortNumberCost.TOLL_FREE;
        Iterator<String> r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L28;
        ShortNumberCost r3 = getExpectedCostForRegion(r9, r2.next());
        int r4 = AnonymousClass1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[r3.ordinal()];
        if (r4 == 1) goto L27;
        if (r4 != 2) goto L18;
        r1 = ShortNumberCost.UNKNOWN_COST;
        goto L12
    L18:
        if (r4 != 3) goto L20;
        if (r1 == ShortNumberCost.UNKNOWN_COST) goto L12;
        r1 = ShortNumberCost.STANDARD_RATE;
        goto L12
    L20:
        if (r4 == 4) goto L12;
        logger.log(Level.SEVERE, "Unrecognised cost for region: " + r3);
        goto L12
    L27:
        return ShortNumberCost.PREMIUM_RATE;
    L28:
        return r1;
    L9:
        return getExpectedCostForRegion(r9, r0.get(0));
    }

    private String getRegionCodeForShortNumberFromRegionList(Phonenumber.PhoneNumber r4, List<String> r5) {
        if (r5.size() != 0) goto L6;
        return null;
    L6:
        if (r5.size() == 1) goto L8;
        String r6 = getNationalSignificantNumber(r4);
        Iterator<String> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L17;
        String r0 = r7.next();
        Phonemetadata.PhoneMetadata r2 = getShortNumberMetadataForRegion(r0);
        if (r2 == null) goto L11;
        if (matchesPossibleNumberAndNationalNumber(r6, r2.getShortCode()) == false) goto L11;
        return r0;
    L17:
        return null;
    L8:
        return r5.get(0);
    }

    String getExampleShortNumber(String r2) {
        Phonemetadata.PhoneMetadata r1 = getShortNumberMetadataForRegion(r2);
        if (r1 != null) goto L5;
        return "";
    L5:
        Phonemetadata.PhoneNumberDesc r3 = r1.getShortCode();
        if (r3.hasExampleNumber() == true) goto L8;
        return "";
    L8:
        return r3.getExampleNumber();
    }

    String getExampleShortNumberForCost(String r2, ShortNumberCost r3) {
        Phonemetadata.PhoneMetadata r1 = getShortNumberMetadataForRegion(r2);
        if (r1 != null) goto L5;
        return "";
    L5:
        int r4 = AnonymousClass1.$SwitchMap$com$google$i18n$phonenumbers$ShortNumberInfo$ShortNumberCost[r3.ordinal()];
        if (r4 != 1) goto L8;
        Phonemetadata.PhoneNumberDesc r5 = r1.getPremiumRate();
    L15:
        if (r5 != null) goto L17;
    L20:
        return "";
    L17:
        if (r5.hasExampleNumber() == false) goto L20;
        return r5.getExampleNumber();
    L8:
        if (r4 != 3) goto L10;
        r5 = r1.getStandardRate();
        goto L15
    L10:
        if (r4 == 4) goto L12;
        r5 = null;
        goto L15
    L12:
        r5 = r1.getTollFree();
        goto L15
    }

    public boolean connectsToEmergencyNumber(String r2, String r3) {
        return matchesEmergencyNumberHelper(r2, r3, true);
    }

    public boolean isEmergencyNumber(CharSequence r2, String r3) {
        return matchesEmergencyNumberHelper(r2, r3, false);
    }

    private boolean matchesEmergencyNumberHelper(CharSequence r4, String r5, boolean r6) {
        CharSequence r7 = PhoneNumberUtil.extractPossibleNumber(r4);
        boolean r1 = false;
        if (PhoneNumberUtil.PLUS_CHARS_PATTERN.matcher(r7).lookingAt() == false) goto L5;
        return false;
    L5:
        Phonemetadata.PhoneMetadata r0 = getShortNumberMetadataForRegion(r5);
        if (r0 != null) goto L8;
    L17:
        return false;
    L8:
        if (r0.hasEmergency() == false) goto L17;
        String r8 = PhoneNumberUtil.normalizeDigitsOnly(r7);
        if (r6 == false) goto L16;
        if (REGIONS_WHERE_EMERGENCY_NUMBERS_MUST_BE_EXACT.contains(r5) == true) goto L16;
        r1 = true;
    L16:
        return this.matcherApi.matchNationalNumber(r8, r0.getEmergency(), r1);
    }

    public boolean isCarrierSpecific(Phonenumber.PhoneNumber r2) {
        String r0 = getRegionCodeForShortNumberFromRegionList(r2, getRegionCodesForCountryCode(r2.getCountryCode()));
        String r3 = getNationalSignificantNumber(r2);
        Phonemetadata.PhoneMetadata r1 = getShortNumberMetadataForRegion(r0);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (matchesPossibleNumberAndNationalNumber(r3, r1.getCarrierSpecific()) == false) goto L7;
        return true;
    }

    public boolean isCarrierSpecificForRegion(Phonenumber.PhoneNumber r3, String r4) {
        if (regionDialingFromMatchesNumber(r3, r4) == true) goto L5;
        return false;
    L5:
        String r5 = getNationalSignificantNumber(r3);
        Phonemetadata.PhoneMetadata r6 = getShortNumberMetadataForRegion(r4);
        if (r6 != null) goto L8;
        return false;
    L8:
        if (matchesPossibleNumberAndNationalNumber(r5, r6.getCarrierSpecific()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isSmsServiceForRegion(Phonenumber.PhoneNumber r3, String r4) {
        if (regionDialingFromMatchesNumber(r3, r4) == true) goto L5;
        return false;
    L5:
        Phonemetadata.PhoneMetadata r5 = getShortNumberMetadataForRegion(r4);
        if (r5 != null) goto L8;
        return false;
    L8:
        if (matchesPossibleNumberAndNationalNumber(getNationalSignificantNumber(r3), r5.getSmsServices()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private static String getNationalSignificantNumber(Phonenumber.PhoneNumber r3) {
        StringBuilder r0 = new StringBuilder();
        if (r3.isItalianLeadingZero() == false) goto L5;
        char[] r1 = new char[r3.getNumberOfLeadingZeros()];
        Arrays.fill(r1, DeepCleanSAFEngine.DetailPath.KEY);
        r0.append(new String(r1));
    L5:
        r0.append(r3.getNationalNumber());
        return r0.toString();
    }

    private boolean matchesPossibleNumberAndNationalNumber(String r4, Phonemetadata.PhoneNumberDesc r5) {
        if (r5.getPossibleLengthCount() <= 0) goto L8;
        if (r5.getPossibleLengthList().contains(Integer.valueOf(r4.length())) == true) goto L8;
        return false;
    L8:
        return this.matcherApi.matchNationalNumber(r4, r5, false);
    }
}
