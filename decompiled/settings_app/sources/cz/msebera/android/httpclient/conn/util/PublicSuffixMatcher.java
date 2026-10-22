package cz.msebera.android.httpclient.conn.util;

import cz.msebera.android.httpclient.util.Args;
import java.net.IDN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixMatcher {
    private final Map<String, DomainType> exceptions;
    private final Map<String, DomainType> rules;

    public PublicSuffixMatcher(Collection<String> r2, Collection<String> r3) {
        this(DomainType.UNKNOWN, r2, r3);
    }

    public PublicSuffixMatcher(DomainType r3, Collection<String> r4, Collection<String> r5) {
        Args.notNull(r3, "Domain type");
        Args.notNull(r4, "Domain suffix rules");
        this.rules = new ConcurrentHashMap(r4.size());
        Iterator<String> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = r6.next();
        this.rules.put(r0, r3);
        goto L4
    L6:
        this.exceptions = new ConcurrentHashMap();
        if (r5 == null) goto L12;
        Iterator<String> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        String r8 = r7.next();
        this.exceptions.put(r8, r3);
        goto L10
    L15:
        return;
    }

    public PublicSuffixMatcher(Collection<PublicSuffixList> r6) {
        Args.notNull(r6, "Domain suffix lists");
        this.rules = new ConcurrentHashMap();
        this.exceptions = new ConcurrentHashMap();
        Iterator<PublicSuffixList> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        PublicSuffixList r0 = r7.next();
        DomainType r1 = r0.getType();
        Iterator<String> r2 = r0.getRules().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        String r3 = r2.next();
        this.rules.put(r3, r1);
        goto L7
    L9:
        List<String> r4 = r0.getExceptions();
        if (r4 == null) goto L4;
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L4;
        String r8 = r5.next();
        this.exceptions.put(r8, r1);
        goto L13
    }

    private static boolean hasEntry(Map<String, DomainType> r1, String r2, DomainType r3) {
        if (r1 != null) goto L5;
        return false;
    L5:
        DomainType r4 = r1.get(r2);
        if (r4 == null) goto L14;
        if (r3 != null) goto L10;
    L11:
        return true;
    L10:
        if (r4.equals(r3) == true) goto L11;
        return false;
    L14:
        return false;
    }

    private boolean hasRule(String r1, DomainType r2) {
        return hasEntry(this.rules, r1, r2);
    }

    private boolean hasException(String r1, DomainType r2) {
        return hasEntry(this.exceptions, r1, r2);
    }

    public String getDomainRoot(String r2) {
        return getDomainRoot(r2, null);
    }

    public String getDomainRoot(String r8, DomainType r9) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.startsWith(".") == false) goto L8;
        return null;
    L8:
        String r10 = r8.toLowerCase(Locale.ROOT);
        String r1 = null;
    L9:
        if (r10 == null) goto L27;
        if (hasException(IDN.toUnicode(r10), r9) == true) goto L12;
        if (hasRule(IDN.toUnicode(r10), r9) == true) goto L27;
        int r2 = r10.indexOf(46);
        if (r2 == (-1)) goto L19;
        String r4 = r10.substring(r2 + 1);
    L20:
        if (r4 != null) goto L22;
    L24:
        if (r2 == (-1)) goto L26;
        r1 = r10;
    L26:
        r10 = r4;
        goto L9
    L22:
        if (hasRule("*." + IDN.toUnicode(r4), r9) == false) goto L24;
    L19:
        r4 = null;
        goto L20
    L12:
        return r10;
    L27:
        return r1;
    }

    public boolean matches(String r2) {
        return matches(r2, null);
    }

    public boolean matches(String r4, DomainType r5) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.startsWith(".") == false) goto L9;
        r4 = r4.substring(1);
    L9:
        if (getDomainRoot(r4, r5) == null) goto L11;
        return false;
    L11:
        return true;
    }
}
