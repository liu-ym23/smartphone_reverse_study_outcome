package com.tencent.wcdb.database;

/* JADX INFO: loaded from: classes5.dex */
public class SQLiteCipherSpec {
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    public int hmacAlgorithm;
    public boolean hmacEnabled;
    public int kdfAlgorithm;
    public int kdfIteration;
    public int pageSize;

    public SQLiteCipherSpec() {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.defaultPageSize;
    }

    public SQLiteCipherSpec(SQLiteCipherSpec r2) {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = SQLiteGlobal.defaultPageSize;
        this.kdfIteration = r2.kdfIteration;
        this.hmacEnabled = r2.hmacEnabled;
        this.pageSize = r2.pageSize;
    }

    public SQLiteCipherSpec setKDFIteration(int r1) {
        this.kdfIteration = r1;
        return this;
    }

    public SQLiteCipherSpec withHMACEnabled(boolean r1) {
        this.hmacEnabled = r1;
        return this;
    }

    public SQLiteCipherSpec setHmacAlgorithm(int r1) {
        this.hmacAlgorithm = r1;
        return this;
    }

    public SQLiteCipherSpec setKdfAlgorithm(int r1) {
        this.kdfAlgorithm = r1;
        return this;
    }

    public SQLiteCipherSpec setPageSize(int r1) {
        this.pageSize = r1;
        return this;
    }

    public SQLiteCipherSpec setSQLCipherVersion(int r5) {
        if (r5 != 1) goto L5;
        this.hmacEnabled = false;
        this.kdfIteration = 4000;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
    L16:
        return this;
    L5:
        if (r5 != 2) goto L7;
        this.hmacEnabled = true;
        this.kdfIteration = 4000;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
        goto L16
    L7:
        if (r5 != 3) goto L9;
        this.hmacEnabled = true;
        this.kdfIteration = 64000;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
        goto L16
    L9:
        if (r5 != 4) goto L12;
        this.hmacEnabled = true;
        this.kdfIteration = 256000;
        this.hmacAlgorithm = 2;
        this.kdfAlgorithm = 2;
        goto L16
    L12:
        throw new IllegalArgumentException("Unsupported SQLCipher version: " + r5);
    }
}
