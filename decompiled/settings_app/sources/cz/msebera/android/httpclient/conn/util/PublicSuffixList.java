package cz.msebera.android.httpclient.conn.util;

import cz.msebera.android.httpclient.util.Args;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixList {
    private final List<String> exceptions;
    private final List<String> rules;
    private final DomainType type;

    public PublicSuffixList(DomainType r2, List<String> r3, List<String> r4) {
        this.type = (DomainType) Args.notNull(r2, "Domain type");
        this.rules = Collections.unmodifiableList((List) Args.notNull(r3, "Domain suffix rules"));
        if (r4 != null) goto L6;
        r4 = Collections.emptyList();
    L6:
        this.exceptions = Collections.unmodifiableList(r4);
    }

    public PublicSuffixList(List<String> r2, List<String> r3) {
        this(DomainType.UNKNOWN, r2, r3);
    }

    public DomainType getType() {
        return this.type;
    }

    public List<String> getRules() {
        return this.rules;
    }

    public List<String> getExceptions() {
        return this.exceptions;
    }
}
