package com.obric.safecheck.parser;

import com.obric.safecheck.database.entity.Item;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ParserFactory {
    private static final Map<String, Parser<? extends Item>> PARSER_MAP = null;

    public ParserFactory() {
    }

    static {
        HashMap r0 = new HashMap();
        PARSER_MAP = r0;
        PkgSignParser r1 = new PkgSignParser(true);
        PkgSignParser r3 = new PkgSignParser(false);
        PhoneParser r5 = new PhoneParser(true);
        PhoneParser r6 = new PhoneParser(false);
        UrlDomainParser r7 = new UrlDomainParser(true);
        UrlDomainParser r2 = new UrlDomainParser(false);
        r0.put("pkgSignB", r1);
        r0.put("pkgSignW", r3);
        r0.put("phoneB", r5);
        r0.put("phoneW", r6);
        r0.put("urlDomainB", r7);
        r0.put("urlDomainW", r2);
    }

    public static Parser<? extends Item> getParser(String fieldName) {
        return PARSER_MAP.get(fieldName);
    }
}
