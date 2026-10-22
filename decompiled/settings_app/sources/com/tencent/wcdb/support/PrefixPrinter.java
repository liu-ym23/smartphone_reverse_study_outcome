package com.tencent.wcdb.support;

import android.util.Printer;

/* JADX INFO: loaded from: classes5.dex */
public class PrefixPrinter implements Printer {
    private final String mPrefix;
    private final Printer mPrinter;

    public static Printer create(Printer r1, String r2) {
        if (r2 != null) goto L4;
    L8:
        return r1;
    L4:
        if (r2.equals("") == true) goto L8;
        return new PrefixPrinter(r1, r2);
    }

    private PrefixPrinter(Printer r1, String r2) {
        this.mPrinter = r1;
        this.mPrefix = r2;
    }

    @Override // android.util.Printer
    public void println(String r3) {
        this.mPrinter.println(this.mPrefix + r3);
    }
}
