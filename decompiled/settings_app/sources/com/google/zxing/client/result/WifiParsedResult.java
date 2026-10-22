package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes4.dex */
public final class WifiParsedResult extends ParsedResult {
    private final String anonymousIdentity;
    private final String eapMethod;
    private final boolean hidden;
    private final String identity;
    private final String networkEncryption;
    private final String password;
    private final String phase2Method;
    private final String ssid;

    public WifiParsedResult(String r2, String r3, String r4) {
        this(r2, r3, r4, false);
    }

    public WifiParsedResult(String r10, String r11, String r12, boolean r13) {
        this(r10, r11, r12, r13, null, null, null, null);
    }

    public WifiParsedResult(String r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9) {
        super(ParsedResultType.WIFI);
        this.ssid = r3;
        this.networkEncryption = r2;
        this.password = r4;
        this.hidden = r5;
        this.identity = r6;
        this.anonymousIdentity = r7;
        this.eapMethod = r8;
        this.phase2Method = r9;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public String getIdentity() {
        return this.identity;
    }

    public String getAnonymousIdentity() {
        return this.anonymousIdentity;
    }

    public String getEapMethod() {
        return this.eapMethod;
    }

    public String getPhase2Method() {
        return this.phase2Method;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(80);
        maybeAppend(this.ssid, r0);
        maybeAppend(this.networkEncryption, r0);
        maybeAppend(this.password, r0);
        maybeAppend(Boolean.toString(this.hidden), r0);
        return r0.toString();
    }
}
