package org.apache.commons.io;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public final class IOCase implements Serializable {
    public static final IOCase INSENSITIVE = null;
    public static final IOCase SENSITIVE = null;
    public static final IOCase SYSTEM = null;
    private static final long serialVersionUID = -6343169151696340687L;
    private final String name;
    private final transient boolean sensitive;

    static {
        SENSITIVE = new IOCase("Sensitive", true);
        INSENSITIVE = new IOCase("Insensitive", false);
        SYSTEM = new IOCase("System", !FilenameUtils.isSystemWindows());
    }

    public static IOCase forName(String r3) {
        IOCase r0 = SENSITIVE;
        if (r0.name.equals(r3) == false) goto L5;
        return r0;
    L5:
        IOCase r1 = INSENSITIVE;
        if (r1.name.equals(r3) == false) goto L8;
        return r1;
    L8:
        IOCase r2 = SYSTEM;
        if (r2.name.equals(r3) == false) goto L12;
        return r2;
    L12:
        throw new IllegalArgumentException(new StringBuffer("Invalid IOCase name: ").append(r3).toString());
    }

    private IOCase(String r1, boolean r2) {
        this.name = r1;
        this.sensitive = r2;
    }

    private Object readResolve() {
        return forName(this.name);
    }

    public String getName() {
        return this.name;
    }

    public boolean isCaseSensitive() {
        return this.sensitive;
    }

    public boolean checkEquals(String r1, String r2) {
        if (r1 == null) goto L10;
        if (r2 == null) goto L10;
        if (this.sensitive == false) goto L8;
        return r1.equals(r2);
    L8:
        return r1.equalsIgnoreCase(r2);
    L10:
        throw new NullPointerException("The strings must not be null");
    }

    public boolean checkStartsWith(String r7, String r8) {
        return r7.regionMatches(!this.sensitive, 0, r8, 0, r8.length());
    }

    public boolean checkEndsWith(String r7, String r8) {
        int r5 = r8.length();
        return r7.regionMatches(!this.sensitive, r7.length() - r5, r8, 0, r5);
    }

    public boolean checkRegionMatches(String r7, int r8, String r9) {
        return r7.regionMatches(!this.sensitive, r8, r9, 0, r9.length());
    }

    String convertCase(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (this.sensitive == false) goto L9;
        return r1;
    L9:
        return r1.toLowerCase();
    }

    public String toString() {
        return this.name;
    }
}
