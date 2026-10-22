package com.android.apksig.internal.apk;

import com.android.apksig.ApkVerificationIssue;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSignerInfo {
    public List<X509Certificate> certificateLineage;
    public List<X509Certificate> certs;
    public int index;
    private final List<ApkVerificationIssue> mErrors;
    private final List<ApkVerificationIssue> mWarnings;

    public ApkSignerInfo() {
        this.mWarnings = new ArrayList();
        this.mErrors = new ArrayList();
        this.certs = new ArrayList();
        this.certificateLineage = new ArrayList();
    }

    public List<? extends ApkVerificationIssue> getErrors() {
        return this.mErrors;
    }

    public List<? extends ApkVerificationIssue> getWarnings() {
        return this.mWarnings;
    }
}
