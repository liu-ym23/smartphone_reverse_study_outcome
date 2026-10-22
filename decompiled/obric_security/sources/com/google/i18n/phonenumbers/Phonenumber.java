package com.google.i18n.phonenumbers;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class Phonenumber {

    public static class PhoneNumber implements Serializable {
        private static final long serialVersionUID = 1;
        private CountryCodeSource countryCodeSource_;
        private int countryCode_;
        private String extension_;
        private boolean hasCountryCode;
        private boolean hasCountryCodeSource;
        private boolean hasExtension;
        private boolean hasItalianLeadingZero;
        private boolean hasNationalNumber;
        private boolean hasNumberOfLeadingZeros;
        private boolean hasPreferredDomesticCarrierCode;
        private boolean hasRawInput;
        private boolean italianLeadingZero_;
        private long nationalNumber_;
        private int numberOfLeadingZeros_;
        private String preferredDomesticCarrierCode_;
        private String rawInput_;

        public static final enum CountryCodeSource extends Enum<CountryCodeSource> {
            private static final /* synthetic */ CountryCodeSource[] $VALUES = null;
            public static final CountryCodeSource FROM_DEFAULT_COUNTRY = null;
            public static final CountryCodeSource FROM_NUMBER_WITHOUT_PLUS_SIGN = null;
            public static final CountryCodeSource FROM_NUMBER_WITH_IDD = null;
            public static final CountryCodeSource FROM_NUMBER_WITH_PLUS_SIGN = null;
            public static final CountryCodeSource UNSPECIFIED = null;

            private static /* synthetic */ CountryCodeSource[] $values() {
                return new CountryCodeSource[]{FROM_NUMBER_WITH_PLUS_SIGN, FROM_NUMBER_WITH_IDD, FROM_NUMBER_WITHOUT_PLUS_SIGN, FROM_DEFAULT_COUNTRY, UNSPECIFIED};
            }

            private CountryCodeSource(String r1, int r2) {
                super(r1, r2);
            }

            public static CountryCodeSource valueOf(String r1) {
                return (CountryCodeSource) Enum.valueOf(CountryCodeSource.class, r1);
            }

            public static CountryCodeSource[] values() {
                return (CountryCodeSource[]) $VALUES.clone();
            }

            static {
                FROM_NUMBER_WITH_PLUS_SIGN = new CountryCodeSource("FROM_NUMBER_WITH_PLUS_SIGN", 0);
                FROM_NUMBER_WITH_IDD = new CountryCodeSource("FROM_NUMBER_WITH_IDD", 1);
                FROM_NUMBER_WITHOUT_PLUS_SIGN = new CountryCodeSource("FROM_NUMBER_WITHOUT_PLUS_SIGN", 2);
                FROM_DEFAULT_COUNTRY = new CountryCodeSource("FROM_DEFAULT_COUNTRY", 3);
                UNSPECIFIED = new CountryCodeSource("UNSPECIFIED", 4);
                $VALUES = $values();
            }
        }

        public PhoneNumber() {
            this.countryCode_ = 0;
            this.nationalNumber_ = 0;
            this.extension_ = "";
            this.italianLeadingZero_ = false;
            this.numberOfLeadingZeros_ = 1;
            this.rawInput_ = "";
            this.preferredDomesticCarrierCode_ = "";
            this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
        }

        public boolean hasCountryCode() {
            return this.hasCountryCode;
        }

        public int getCountryCode() {
            return this.countryCode_;
        }

        public PhoneNumber setCountryCode(int r2) {
            this.hasCountryCode = true;
            this.countryCode_ = r2;
            return this;
        }

        public PhoneNumber clearCountryCode() {
            this.hasCountryCode = false;
            this.countryCode_ = 0;
            return this;
        }

        public boolean hasNationalNumber() {
            return this.hasNationalNumber;
        }

        public long getNationalNumber() {
            return this.nationalNumber_;
        }

        public PhoneNumber setNationalNumber(long r2) {
            this.hasNationalNumber = true;
            this.nationalNumber_ = r2;
            return this;
        }

        public PhoneNumber clearNationalNumber() {
            this.hasNationalNumber = false;
            this.nationalNumber_ = 0;
            return this;
        }

        public boolean hasExtension() {
            return this.hasExtension;
        }

        public String getExtension() {
            return this.extension_;
        }

        public PhoneNumber setExtension(String r2) {
            r2.getClass();
            this.hasExtension = true;
            this.extension_ = r2;
            return this;
        }

        public PhoneNumber clearExtension() {
            this.hasExtension = false;
            this.extension_ = "";
            return this;
        }

        public boolean hasItalianLeadingZero() {
            return this.hasItalianLeadingZero;
        }

        public boolean isItalianLeadingZero() {
            return this.italianLeadingZero_;
        }

        public PhoneNumber setItalianLeadingZero(boolean r2) {
            this.hasItalianLeadingZero = true;
            this.italianLeadingZero_ = r2;
            return this;
        }

        public PhoneNumber clearItalianLeadingZero() {
            this.hasItalianLeadingZero = false;
            this.italianLeadingZero_ = false;
            return this;
        }

        public boolean hasNumberOfLeadingZeros() {
            return this.hasNumberOfLeadingZeros;
        }

        public int getNumberOfLeadingZeros() {
            return this.numberOfLeadingZeros_;
        }

        public PhoneNumber setNumberOfLeadingZeros(int r2) {
            this.hasNumberOfLeadingZeros = true;
            this.numberOfLeadingZeros_ = r2;
            return this;
        }

        public PhoneNumber clearNumberOfLeadingZeros() {
            this.hasNumberOfLeadingZeros = false;
            this.numberOfLeadingZeros_ = 1;
            return this;
        }

        public boolean hasRawInput() {
            return this.hasRawInput;
        }

        public String getRawInput() {
            return this.rawInput_;
        }

        public PhoneNumber setRawInput(String r2) {
            r2.getClass();
            this.hasRawInput = true;
            this.rawInput_ = r2;
            return this;
        }

        public PhoneNumber clearRawInput() {
            this.hasRawInput = false;
            this.rawInput_ = "";
            return this;
        }

        public boolean hasCountryCodeSource() {
            return this.hasCountryCodeSource;
        }

        public CountryCodeSource getCountryCodeSource() {
            return this.countryCodeSource_;
        }

        public PhoneNumber setCountryCodeSource(CountryCodeSource r2) {
            r2.getClass();
            this.hasCountryCodeSource = true;
            this.countryCodeSource_ = r2;
            return this;
        }

        public PhoneNumber clearCountryCodeSource() {
            this.hasCountryCodeSource = false;
            this.countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
            return this;
        }

        public boolean hasPreferredDomesticCarrierCode() {
            return this.hasPreferredDomesticCarrierCode;
        }

        public String getPreferredDomesticCarrierCode() {
            return this.preferredDomesticCarrierCode_;
        }

        public PhoneNumber setPreferredDomesticCarrierCode(String r2) {
            r2.getClass();
            this.hasPreferredDomesticCarrierCode = true;
            this.preferredDomesticCarrierCode_ = r2;
            return this;
        }

        public PhoneNumber clearPreferredDomesticCarrierCode() {
            this.hasPreferredDomesticCarrierCode = false;
            this.preferredDomesticCarrierCode_ = "";
            return this;
        }

        public final PhoneNumber clear() {
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearNumberOfLeadingZeros();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
            return this;
        }

        public PhoneNumber mergeFrom(PhoneNumber r3) {
            if (r3.hasCountryCode() == false) goto L6;
            setCountryCode(r3.getCountryCode());
        L6:
            if (r3.hasNationalNumber() == false) goto L9;
            setNationalNumber(r3.getNationalNumber());
        L9:
            if (r3.hasExtension() == false) goto L12;
            setExtension(r3.getExtension());
        L12:
            if (r3.hasItalianLeadingZero() == false) goto L15;
            setItalianLeadingZero(r3.isItalianLeadingZero());
        L15:
            if (r3.hasNumberOfLeadingZeros() == false) goto L18;
            setNumberOfLeadingZeros(r3.getNumberOfLeadingZeros());
        L18:
            if (r3.hasRawInput() == false) goto L21;
            setRawInput(r3.getRawInput());
        L21:
            if (r3.hasCountryCodeSource() == false) goto L24;
            setCountryCodeSource(r3.getCountryCodeSource());
        L24:
            if (r3.hasPreferredDomesticCarrierCode() == false) goto L26;
            setPreferredDomesticCarrierCode(r3.getPreferredDomesticCarrierCode());
        L26:
            return this;
        }

        public boolean exactlySameAs(PhoneNumber r7) {
            if (r7 != null) goto L6;
            return false;
        L6:
            if (this != r7) goto L9;
            return true;
        L9:
            if (this.countryCode_ == r7.countryCode_) goto L11;
            return false;
        L11:
            if (this.nationalNumber_ == r7.nationalNumber_) goto L13;
            return false;
        L13:
            if (this.extension_.equals(r7.extension_) == true) goto L15;
            return false;
        L15:
            if (this.italianLeadingZero_ == r7.italianLeadingZero_) goto L17;
            return false;
        L17:
            if (this.numberOfLeadingZeros_ == r7.numberOfLeadingZeros_) goto L19;
            return false;
        L19:
            if (this.rawInput_.equals(r7.rawInput_) == true) goto L21;
            return false;
        L21:
            if (this.countryCodeSource_ == r7.countryCodeSource_) goto L23;
            return false;
        L23:
            if (this.preferredDomesticCarrierCode_.equals(r7.preferredDomesticCarrierCode_) == true) goto L25;
            return false;
        L25:
            if (hasPreferredDomesticCarrierCode() == r7.hasPreferredDomesticCarrierCode()) goto L27;
            return false;
        L27:
            return true;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof PhoneNumber) == true) goto L5;
        L7:
            return false;
        L5:
            if (exactlySameAs((PhoneNumber) r2) == false) goto L7;
            return true;
        }

        public int hashCode() {
            int r0 = (((((2173 + getCountryCode()) * 53) + Long.valueOf(getNationalNumber()).hashCode()) * 53) + getExtension().hashCode()) * 53;
            int r2 = 1231;
            if (isItalianLeadingZero() == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((((((((r0 + r1) * 53) + getNumberOfLeadingZeros()) * 53) + getRawInput().hashCode()) * 53) + getCountryCodeSource().hashCode()) * 53) + getPreferredDomesticCarrierCode().hashCode()) * 53;
            if (hasPreferredDomesticCarrierCode() == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Country Code: ");
            r0.append(this.countryCode_);
            r0.append(" National Number: ").append(this.nationalNumber_);
            if (hasItalianLeadingZero() == false) goto L8;
            if (isItalianLeadingZero() == false) goto L8;
            r0.append(" Leading Zero(s): true");
        L8:
            if (hasNumberOfLeadingZeros() == false) goto L11;
            r0.append(" Number of leading zeros: ").append(this.numberOfLeadingZeros_);
        L11:
            if (hasExtension() == false) goto L14;
            r0.append(" Extension: ").append(this.extension_);
        L14:
            if (hasCountryCodeSource() == false) goto L17;
            r0.append(" Country Code Source: ").append(this.countryCodeSource_);
        L17:
            if (hasPreferredDomesticCarrierCode() == false) goto L20;
            r0.append(" Preferred Domestic Carrier Code: ").append(this.preferredDomesticCarrierCode_);
        L20:
            return r0.toString();
        }
    }

    private Phonenumber() {
    }
}
