package com.google.i18n.phonenumbers;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class PhoneNumberMatch {
    private final Phonenumber.PhoneNumber number;
    private final String rawString;
    private final int start;

    PhoneNumberMatch(int r1, String r2, Phonenumber.PhoneNumber r3) {
        if (r1 < 0) goto L11;
        if (r2 == null) goto L9;
        if (r3 == null) goto L9;
        this.start = r1;
        this.rawString = r2;
        this.number = r3;
        return;
    L9:
        throw null;
    L11:
        throw new IllegalArgumentException("Start index must be >= 0.");
    }

    public Phonenumber.PhoneNumber number() {
        return this.number;
    }

    public int start() {
        return this.start;
    }

    public int end() {
        return this.start + this.rawString.length();
    }

    public String rawString() {
        return this.rawString;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.start), this.rawString, this.number});
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhoneNumberMatch) == true) goto L8;
        return false;
    L8:
        PhoneNumberMatch r6 = (PhoneNumberMatch) r5;
        if (this.rawString.equals(r6.rawString) == false) goto L16;
        if (this.start != r6.start) goto L16;
        if (this.number.equals(r6.number) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public String toString() {
        return "PhoneNumberMatch [" + start() + "," + end() + ") " + this.rawString;
    }
}
