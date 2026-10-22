package android.bluetooth.client.pbap.utils;

import android.util.Log;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class BmsgTokenizer {
    private final Matcher mMatcher;
    private final int mOffset;
    private int mPos;
    private final String mStr;

    public static class Property {
        public final String name;
        public final String value;

        public Property(String r1, String r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L8;
            this.name = r1;
            this.value = r2;
            Log.v("BMSG >> ", toString());
            return;
        L8:
            throw new IllegalArgumentException();
        }

        public String toString() {
            return this.name + ":" + this.value;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof Property) == false) goto L9;
            Property r4 = (Property) r3;
            if (r4.name.equals(this.name) == false) goto L9;
            if (r4.value.equals(this.value) == false) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public BmsgTokenizer(String r2) {
        this(r2, 0);
    }

    public BmsgTokenizer(String r2, int r3) {
        this.mPos = 0;
        this.mStr = r2;
        this.mOffset = r3;
        Matcher r4 = Pattern.compile("(([^:]*):(.*))?\r\n").matcher(r2);
        this.mMatcher = r4;
        this.mPos = r4.regionStart();
    }

    public Property next(boolean r5) throws ParseException {
        boolean r0 = false;
    L3:
        Matcher r1 = this.mMatcher;
        r1.region(this.mPos, r1.regionEnd());
        if (this.mMatcher.lookingAt() == false) goto L5;
        this.mPos = this.mMatcher.end();
        if (this.mMatcher.group(1) == null) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L3;
        return new Property(this.mMatcher.group(2), this.mMatcher.group(3));
    L5:
        if (r5 == false) goto L9;
        return null;
    L9:
        throw new ParseException("Property or empty line expected", pos());
    }

    public Property next() throws ParseException {
        return next(false);
    }

    public String remaining() {
        return this.mStr.substring(this.mPos);
    }

    public int pos() {
        return this.mPos + this.mOffset;
    }
}
