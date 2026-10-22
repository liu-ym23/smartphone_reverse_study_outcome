package com.android.apksig.internal.apk;

import com.android.apksig.ApkVerificationIssue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSigResult {
    private final List<ApkVerificationIssue> mErrors;
    public final int signatureSchemeVersion;
    public boolean verified;

    public ApkSigResult(int r2) {
        this.mErrors = new ArrayList();
        this.signatureSchemeVersion = r2;
    }

    public List<? extends ApkVerificationIssue> getErrors() {
        return this.mErrors;
    }
}
