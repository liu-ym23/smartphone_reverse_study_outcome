package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.conn.util.PublicSuffixList;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class PublicSuffixListParser {
    private final PublicSuffixFilter filter;
    private final cz.msebera.android.httpclient.conn.util.PublicSuffixListParser parser;

    PublicSuffixListParser(PublicSuffixFilter r1) {
        this.filter = r1;
        this.parser = new cz.msebera.android.httpclient.conn.util.PublicSuffixListParser();
    }

    public void parse(Reader r3) throws IOException {
        PublicSuffixList r4 = this.parser.parse(r3);
        this.filter.setPublicSuffixes(r4.getRules());
        this.filter.setExceptions(r4.getExceptions());
    }
}
