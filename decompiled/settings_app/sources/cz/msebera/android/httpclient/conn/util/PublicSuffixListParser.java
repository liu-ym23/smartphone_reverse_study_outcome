package cz.msebera.android.httpclient.conn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixListParser {
    public PublicSuffixListParser() {
    }

    public PublicSuffixList parse(Reader r5) throws IOException {
        ArrayList r4 = new ArrayList();
        ArrayList r0 = new ArrayList();
        BufferedReader r1 = new BufferedReader(r5);
    L3:
        String r6 = r1.readLine();
        if (r6 == null) goto L21;
        if (r6.isEmpty() == true) goto L3;
        if (r6.startsWith("//") == true) goto L3;
        if (r6.startsWith(".") == false) goto L14;
        r6 = r6.substring(1);
    L14:
        boolean r2 = r6.startsWith("!");
        if (r2 == false) goto L17;
        r6 = r6.substring(1);
    L17:
        if (r2 == true) goto L18;
        r4.add(r6);
        goto L3
    L18:
        r0.add(r6);
        goto L3
    L21:
        return new PublicSuffixList(DomainType.UNKNOWN, r4, r0);
    }

    public List<PublicSuffixList> parseByType(Reader r8) throws IOException {
        ArrayList r7 = new ArrayList(2);
        BufferedReader r0 = new BufferedReader(r8);
    L3:
        DomainType r1 = null;
        ArrayList r2 = null;
        ArrayList r3 = null;
    L4:
        String r4 = r0.readLine();
        if (r4 == null) goto L39;
        if (r4.isEmpty() == true) goto L4;
        if (r4.startsWith("//") == true) goto L11;
        if (r1 == null) goto L4;
        if (r4.startsWith(".") == false) goto L29;
        r4 = r4.substring(1);
    L29:
        boolean r5 = r4.startsWith("!");
        if (r5 == false) goto L32;
        r4 = r4.substring(1);
    L32:
        if (r5 == true) goto L33;
        if (r2 != null) goto L38;
        r2 = new ArrayList();
    L38:
        r2.add(r4);
        goto L4
    L33:
        if (r3 != null) goto L35;
        r3 = new ArrayList();
    L35:
        r3.add(r4);
        goto L4
    L11:
        if (r1 == null) goto L13;
        if (r4.contains("===END ICANN DOMAINS===") == true) goto L22;
        if (r4.contains("===END PRIVATE DOMAINS===") == false) goto L4;
    L22:
        if (r2 == null) goto L3;
        r7.add(new PublicSuffixList(r1, r2, r3));
        goto L3
    L13:
        if (r4.contains("===BEGIN ICANN DOMAINS===") == true) goto L14;
        if (r4.contains("===BEGIN PRIVATE DOMAINS===") == false) goto L4;
        r1 = DomainType.PRIVATE;
        goto L4
    L14:
        r1 = DomainType.ICANN;
        goto L4
    L39:
        return r7;
    }
}
