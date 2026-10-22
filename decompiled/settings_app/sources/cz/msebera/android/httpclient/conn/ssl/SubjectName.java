package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
final class SubjectName {
    static final int DNS = 2;
    static final int IP = 7;
    private final int type;
    private final String value;

    static SubjectName IP(String r2) {
        return new SubjectName(r2, 7);
    }

    static SubjectName DNS(String r2) {
        return new SubjectName(r2, 2);
    }

    SubjectName(String r2, int r3) {
        this.value = (String) Args.notNull(r2, "Value");
        this.type = Args.positive(r3, "Type");
    }

    public int getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
