package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes4.dex */
public final class TelParsedResult extends ParsedResult {
    private final String number;
    private final String telURI;
    private final String title;

    public TelParsedResult(String r2, String r3, String r4) {
        super(ParsedResultType.TEL);
        this.number = r2;
        this.telURI = r3;
        this.title = r4;
    }

    public String getNumber() {
        return this.number;
    }

    public String getTelURI() {
        return this.telURI;
    }

    public String getTitle() {
        return this.title;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(20);
        maybeAppend(this.number, r0);
        maybeAppend(this.title, r0);
        return r0.toString();
    }
}
