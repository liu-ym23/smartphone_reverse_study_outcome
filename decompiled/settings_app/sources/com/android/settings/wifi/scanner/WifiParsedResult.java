package com.android.settings.wifi.scanner;

import com.google.zxing.client.result.ParsedResultType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiParsedResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/android/settings/wifi/scanner/WifiParsedResult;", "Lcom/android/settings/wifi/scanner/ParsedResult;", "networkEncryption", "", "ssid", "password", "isHidden", "", "identity", "anonymousIdentity", "eapMethod", "phase2Method", "justConnect", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAnonymousIdentity", "()Ljava/lang/String;", "getEapMethod", "getIdentity", "()Z", "getJustConnect", "setJustConnect", "(Z)V", "getNetworkEncryption", "getPassword", "getPhase2Method", "getSsid", "getDisplayResult", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WifiParsedResult extends ParsedResult {
    private final String anonymousIdentity;
    private final String eapMethod;
    private final String identity;
    private final boolean isHidden;
    private boolean justConnect;
    private final String networkEncryption;
    private final String password;
    private final String phase2Method;
    private final String ssid;

    public /* synthetic */ WifiParsedResult(String r12, String r13, String r14, boolean r15, String r16, String r17, String r18, String r19, boolean r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 256) == 0) goto L5;
        boolean r10 = false;
    L6:
        this(r12, r13, r14, r15, r16, r17, r18, r19, r10);
        return;
    L5:
        r10 = r20;
        goto L6
    }

    public final String getNetworkEncryption() {
        return this.networkEncryption;
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean isHidden() {
        return this.isHidden;
    }

    public final String getIdentity() {
        return this.identity;
    }

    public final String getAnonymousIdentity() {
        return this.anonymousIdentity;
    }

    public final String getEapMethod() {
        return this.eapMethod;
    }

    public final String getPhase2Method() {
        return this.phase2Method;
    }

    public final boolean getJustConnect() {
        return this.justConnect;
    }

    public final void setJustConnect(boolean r1) {
        this.justConnect = r1;
    }

    public WifiParsedResult(String r2, String r3, String r4, boolean r5, String r6, String r7, String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "networkEncryption");
        Intrinsics.checkNotNullParameter(r3, "ssid");
        super(ParsedResultType.WIFI);
        this.networkEncryption = r2;
        this.ssid = r3;
        this.password = r4;
        this.isHidden = r5;
        this.identity = r6;
        this.anonymousIdentity = r7;
        this.eapMethod = r8;
        this.phase2Method = r9;
        this.justConnect = r10;
    }

    @Override // com.android.settings.wifi.scanner.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(80);
        ParsedResult.maybeAppend(this.ssid, r0);
        ParsedResult.maybeAppend(this.networkEncryption, r0);
        ParsedResult.maybeAppend(this.password, r0);
        ParsedResult.maybeAppend(String.valueOf(this.isHidden), r0);
        String r2 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }
}
