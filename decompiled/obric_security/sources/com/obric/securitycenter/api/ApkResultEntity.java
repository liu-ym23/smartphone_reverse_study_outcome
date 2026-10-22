package com.obric.securitycenter.api;

import kotlin.Metadata;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001c\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001c\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lcom/obric/securitycenter/api/ApkResultEntity;", "", "()V", "hasRisk", "", "getHasRisk", "()Z", "setHasRisk", "(Z)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "softName", "getSoftName", "setSoftName", "version", "getVersion", "setVersion", "versionCode", "", "getVersionCode", "()I", "setVersionCode", "(I)V", "virusDescription", "getVirusDescription", "setVirusDescription", "virusName", "getVirusName", "setVirusName", "virusUrl", "getVirusUrl", "setVirusUrl", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ApkResultEntity {
    private boolean hasRisk;
    private String packageName;
    private String path;
    private String softName;
    private String version;
    private int versionCode;
    private String virusDescription;
    private String virusName;
    private String virusUrl;

    public ApkResultEntity() {
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String r1) {
        this.packageName = r1;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String r1) {
        this.path = r1;
    }

    public final boolean getHasRisk() {
        return this.hasRisk;
    }

    public final void setHasRisk(boolean r1) {
        this.hasRisk = r1;
    }

    public final String getSoftName() {
        return this.softName;
    }

    public final void setSoftName(String r1) {
        this.softName = r1;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(int r1) {
        this.versionCode = r1;
    }

    public final String getVirusName() {
        return this.virusName;
    }

    public final void setVirusName(String r1) {
        this.virusName = r1;
    }

    public final String getVirusDescription() {
        return this.virusDescription;
    }

    public final void setVirusDescription(String r1) {
        this.virusDescription = r1;
    }

    public final String getVirusUrl() {
        return this.virusUrl;
    }

    public final void setVirusUrl(String r1) {
        this.virusUrl = r1;
    }
}
