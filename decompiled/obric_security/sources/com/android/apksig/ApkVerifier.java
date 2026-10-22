package com.android.apksig;

import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.apk.ApkUtilsLite;
import com.android.apksig.internal.apk.ApkSignerInfo;
import com.android.apksig.internal.apk.ApkSigningBlockUtils;
import com.android.apksig.internal.apk.ContentDigestAlgorithm;
import com.android.apksig.internal.apk.ISchemeSignerInfo;
import com.android.apksig.internal.apk.SignatureAlgorithm;
import com.android.apksig.internal.apk.v1.V1SchemeConstants;
import com.android.apksig.internal.apk.v1.V1SchemeVerifier;
import com.android.apksig.internal.apk.v2.V2SchemeVerifier;
import com.android.apksig.internal.apk.v3.V3SchemeConstants;
import com.android.apksig.internal.apk.v3.V3SchemeVerifier;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.util.DataSource;
import com.android.apksig.util.DataSources;
import com.android.apksig.util.RunnablesExecutor;
import com.android.apksig.zip.ZipFormatException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ApkVerifier {
    private static final Map<Integer, String> SUPPORTED_APK_SIG_SCHEME_NAMES = null;
    private final DataSource mApkDataSource;
    private final File mApkFile;
    private final int mMaxSdkVersion;
    private final Integer mMinSdkVersion;

    /* JADX INFO: renamed from: com.android.apksig.ApkVerifier$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class ApkVerificationIssueAdapter {
        static final Map<Integer, Issue> sVerificationIssueIdToIssue = null;

        static {
            HashMap r0 = new HashMap();
            sVerificationIssueIdToIssue = r0;
            r0.put(38, Issue.V2_SIG_NEGATIVE_LEN);
            r0.put(39, Issue.V3_SIG_NEGATIVE_LEN);
            r0.put(40, Issue.V4_SIG_NEGATIVE_LEN);
            r0.put(1, Issue.V2_SIG_MALFORMED_SIGNERS);
            r0.put(2, Issue.V2_SIG_NO_SIGNERS);
            r0.put(3, Issue.V2_SIG_MALFORMED_SIGNER);
            r0.put(4, Issue.V2_SIG_MALFORMED_SIGNATURE);
            r0.put(5, Issue.V2_SIG_NO_SIGNATURES);
            r0.put(6, Issue.V2_SIG_MALFORMED_CERTIFICATE);
            r0.put(7, Issue.V2_SIG_NO_CERTIFICATES);
            r0.put(8, Issue.V2_SIG_MALFORMED_DIGEST);
            r0.put(9, Issue.V3_SIG_MALFORMED_SIGNERS);
            r0.put(10, Issue.V3_SIG_NO_SIGNERS);
            r0.put(11, Issue.V3_SIG_MALFORMED_SIGNER);
            r0.put(12, Issue.V3_SIG_MALFORMED_SIGNATURE);
            r0.put(13, Issue.V3_SIG_NO_SIGNATURES);
            r0.put(14, Issue.V3_SIG_MALFORMED_CERTIFICATE);
            r0.put(15, Issue.V3_SIG_NO_CERTIFICATES);
            r0.put(16, Issue.V3_SIG_MALFORMED_DIGEST);
            r0.put(17, Issue.SOURCE_STAMP_NO_SIGNATURE);
            r0.put(18, Issue.SOURCE_STAMP_MALFORMED_CERTIFICATE);
            r0.put(19, Issue.SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM);
            r0.put(20, Issue.SOURCE_STAMP_MALFORMED_SIGNATURE);
            r0.put(21, Issue.SOURCE_STAMP_DID_NOT_VERIFY);
            r0.put(22, Issue.SOURCE_STAMP_VERIFY_EXCEPTION);
            r0.put(23, Issue.SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH);
            r0.put(24, Issue.SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST);
            r0.put(25, Issue.SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING);
            r0.put(26, Issue.SOURCE_STAMP_NO_SUPPORTED_SIGNATURE);
            r0.put(27, Issue.SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK);
            r0.put(28, Issue.MALFORMED_APK);
            r0.put(29, Issue.UNEXPECTED_EXCEPTION);
            r0.put(30, Issue.SOURCE_STAMP_SIG_MISSING);
            r0.put(31, Issue.SOURCE_STAMP_MALFORMED_ATTRIBUTE);
            r0.put(32, Issue.SOURCE_STAMP_UNKNOWN_ATTRIBUTE);
            r0.put(33, Issue.SOURCE_STAMP_MALFORMED_LINEAGE);
            r0.put(34, Issue.SOURCE_STAMP_POR_CERT_MISMATCH);
            r0.put(35, Issue.SOURCE_STAMP_POR_DID_NOT_VERIFY);
            r0.put(36, Issue.JAR_SIG_NO_SIGNATURES);
            r0.put(37, Issue.JAR_SIG_PARSE_EXCEPTION);
        }

        private ApkVerificationIssueAdapter() {
        }

        public static List<IssueWithParams> getIssuesFromVerificationIssues(List<? extends ApkVerificationIssue> r5) {
            ArrayList r0 = new ArrayList(r5.size());
            Iterator<? extends ApkVerificationIssue> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            ApkVerificationIssue r1 = r6.next();
            if ((r1 instanceof IssueWithParams) == true) goto L7;
            r0.add(new IssueWithParams(sVerificationIssueIdToIssue.get(Integer.valueOf(r1.getIssueId())), r1.getParams()));
            goto L4
        L7:
            r0.add((IssueWithParams) r1);
            goto L4
        L9:
            return r0;
        }
    }

    public static class Builder {
        private final DataSource mApkDataSource;
        private final File mApkFile;
        private int mMaxSdkVersion;
        private Integer mMinSdkVersion;

        public Builder(File r2) {
            this.mMinSdkVersion = 1;
            this.mMaxSdkVersion = Integer.MAX_VALUE;
            if (r2 == null) goto L7;
            this.mApkFile = r2;
            this.mApkDataSource = null;
            return;
        L7:
            throw new NullPointerException("apk == null");
        }

        public ApkVerifier build() {
            return new ApkVerifier(this.mApkFile, this.mApkDataSource, this.mMinSdkVersion, this.mMaxSdkVersion, null);
        }
    }

    public static final enum Issue extends Enum<Issue> {
        private static final /* synthetic */ Issue[] $VALUES = null;
        public static final Issue APK_SIG_BLOCK_UNKNOWN_ENTRY_ID = null;
        public static final Issue JAR_SIG_DID_NOT_VERIFY = null;
        public static final Issue JAR_SIG_DUPLICATE_MANIFEST_SECTION = null;
        public static final Issue JAR_SIG_DUPLICATE_SIG_FILE_SECTION = null;
        public static final Issue JAR_SIG_DUPLICATE_ZIP_ENTRY = null;
        public static final Issue JAR_SIG_MALFORMED_CERTIFICATE = null;
        public static final Issue JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY = null;
        public static final Issue JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY = null;
        public static final Issue JAR_SIG_MISSING = null;
        public static final Issue JAR_SIG_MISSING_APK_SIG_REFERENCED = null;
        public static final Issue JAR_SIG_MISSING_FILE = null;
        public static final Issue JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE = null;
        public static final Issue JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST = null;
        public static final Issue JAR_SIG_NO_APK_SIG_STRIP_PROTECTION = null;
        public static final Issue JAR_SIG_NO_MANIFEST = null;
        public static final Issue JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE = null;
        public static final Issue JAR_SIG_NO_SIGNATURES = null;
        public static final Issue JAR_SIG_NO_SIGNED_ZIP_ENTRIES = null;
        public static final Issue JAR_SIG_NO_SIGNERS = null;
        public static final Issue JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST = null;
        public static final Issue JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE = null;
        public static final Issue JAR_SIG_PARSE_EXCEPTION = null;
        public static final Issue JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID = null;
        public static final Issue JAR_SIG_UNNNAMED_MANIFEST_SECTION = null;
        public static final Issue JAR_SIG_UNNNAMED_SIG_FILE_SECTION = null;
        public static final Issue JAR_SIG_UNPROTECTED_ZIP_ENTRY = null;
        public static final Issue JAR_SIG_UNSUPPORTED_SIG_ALG = null;
        public static final Issue JAR_SIG_VERIFY_EXCEPTION = null;
        public static final Issue JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY = null;
        public static final Issue JAR_SIG_ZIP_ENTRY_NOT_SIGNED = null;
        public static final Issue JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH = null;
        public static final Issue MALFORMED_APK = null;
        public static final Issue MIN_SIG_SCHEME_FOR_TARGET_SDK_NOT_MET = null;
        public static final Issue NO_SIG_FOR_TARGET_SANDBOX_VERSION = null;
        public static final Issue SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK = null;
        public static final Issue SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING = null;
        public static final Issue SOURCE_STAMP_DID_NOT_VERIFY = null;
        public static final Issue SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH = null;
        public static final Issue SOURCE_STAMP_MALFORMED_ATTRIBUTE = null;
        public static final Issue SOURCE_STAMP_MALFORMED_CERTIFICATE = null;
        public static final Issue SOURCE_STAMP_MALFORMED_LINEAGE = null;
        public static final Issue SOURCE_STAMP_MALFORMED_SIGNATURE = null;
        public static final Issue SOURCE_STAMP_NO_SIGNATURE = null;
        public static final Issue SOURCE_STAMP_NO_SUPPORTED_SIGNATURE = null;
        public static final Issue SOURCE_STAMP_POR_CERT_MISMATCH = null;
        public static final Issue SOURCE_STAMP_POR_DID_NOT_VERIFY = null;
        public static final Issue SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST = null;
        public static final Issue SOURCE_STAMP_SIG_MISSING = null;
        public static final Issue SOURCE_STAMP_UNKNOWN_ATTRIBUTE = null;
        public static final Issue SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM = null;
        public static final Issue SOURCE_STAMP_VERIFY_EXCEPTION = null;
        public static final Issue UNEXPECTED_EXCEPTION = null;
        public static final Issue V2_SIG_APK_DIGEST_DID_NOT_VERIFY = null;
        public static final Issue V2_SIG_DID_NOT_VERIFY = null;
        public static final Issue V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE = null;
        public static final Issue V2_SIG_MALFORMED_CERTIFICATE = null;
        public static final Issue V2_SIG_MALFORMED_DIGEST = null;
        public static final Issue V2_SIG_MALFORMED_PUBLIC_KEY = null;
        public static final Issue V2_SIG_MALFORMED_SIGNATURE = null;
        public static final Issue V2_SIG_MALFORMED_SIGNER = null;
        public static final Issue V2_SIG_MALFORMED_SIGNERS = null;
        public static final Issue V2_SIG_MISSING = null;
        public static final Issue V2_SIG_MISSING_APK_SIG_REFERENCED = null;
        public static final Issue V2_SIG_NEGATIVE_LEN = null;
        public static final Issue V2_SIG_NO_CERTIFICATES = null;
        public static final Issue V2_SIG_NO_SIGNATURES = null;
        public static final Issue V2_SIG_NO_SIGNERS = null;
        public static final Issue V2_SIG_NO_SUPPORTED_SIGNATURES = null;
        public static final Issue V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = null;
        public static final Issue V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS = null;
        public static final Issue V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE = null;
        public static final Issue V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID = null;
        public static final Issue V2_SIG_UNKNOWN_SIG_ALGORITHM = null;
        public static final Issue V2_SIG_VERIFY_EXCEPTION = null;
        public static final Issue V31_BLOCK_FOUND_WITHOUT_V3_BLOCK = null;
        public static final Issue V31_BLOCK_MISSING = null;
        public static final Issue V31_ROTATION_MIN_SDK_ATTR_MISSING = null;
        public static final Issue V31_ROTATION_MIN_SDK_MISMATCH = null;
        public static final Issue V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER = null;
        public static final Issue V3_INCONSISTENT_LINEAGES = null;
        public static final Issue V3_INCONSISTENT_SDK_VERSIONS = null;
        public static final Issue V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD = null;
        public static final Issue V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD = null;
        public static final Issue V3_MISSING_SDK_VERSIONS = null;
        public static final Issue V3_SIG_APK_DIGEST_DID_NOT_VERIFY = null;
        public static final Issue V3_SIG_DID_NOT_VERIFY = null;
        public static final Issue V3_SIG_INVALID_SDK_VERSIONS = null;
        public static final Issue V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE = null;
        public static final Issue V3_SIG_MALFORMED_CERTIFICATE = null;
        public static final Issue V3_SIG_MALFORMED_DIGEST = null;
        public static final Issue V3_SIG_MALFORMED_LINEAGE = null;
        public static final Issue V3_SIG_MALFORMED_PUBLIC_KEY = null;
        public static final Issue V3_SIG_MALFORMED_SIGNATURE = null;
        public static final Issue V3_SIG_MALFORMED_SIGNER = null;
        public static final Issue V3_SIG_MALFORMED_SIGNERS = null;
        public static final Issue V3_SIG_MULTIPLE_PAST_SIGNERS = null;
        public static final Issue V3_SIG_MULTIPLE_SIGNERS = null;
        public static final Issue V3_SIG_NEGATIVE_LEN = null;
        public static final Issue V3_SIG_NO_CERTIFICATES = null;
        public static final Issue V3_SIG_NO_SIGNATURES = null;
        public static final Issue V3_SIG_NO_SIGNERS = null;
        public static final Issue V3_SIG_NO_SUPPORTED_SIGNATURES = null;
        public static final Issue V3_SIG_PAST_SIGNERS_MISMATCH = null;
        public static final Issue V3_SIG_POR_CERT_MISMATCH = null;
        public static final Issue V3_SIG_POR_DID_NOT_VERIFY = null;
        public static final Issue V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = null;
        public static final Issue V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS = null;
        public static final Issue V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE = null;
        public static final Issue V3_SIG_UNKNOWN_SIG_ALGORITHM = null;
        public static final Issue V3_SIG_VERIFY_EXCEPTION = null;
        public static final Issue V4_SIG_APK_ROOT_DID_NOT_VERIFY = null;
        public static final Issue V4_SIG_APK_TREE_DID_NOT_VERIFY = null;
        public static final Issue V4_SIG_DID_NOT_VERIFY = null;
        public static final Issue V4_SIG_MALFORMED_CERTIFICATE = null;
        public static final Issue V4_SIG_MALFORMED_PUBLIC_KEY = null;
        public static final Issue V4_SIG_MALFORMED_SIGNERS = null;
        public static final Issue V4_SIG_MULTIPLE_SIGNERS = null;
        public static final Issue V4_SIG_NEGATIVE_LEN = null;
        public static final Issue V4_SIG_NO_CERTIFICATE = null;
        public static final Issue V4_SIG_NO_SIGNATURES = null;
        public static final Issue V4_SIG_NO_SUPPORTED_SIGNATURES = null;
        public static final Issue V4_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = null;
        public static final Issue V4_SIG_UNKNOWN_SIG_ALGORITHM = null;
        public static final Issue V4_SIG_V2_V3_DIGESTS_MISMATCH = null;
        public static final Issue V4_SIG_V2_V3_SIGNERS_MISMATCH = null;
        public static final Issue V4_SIG_VERIFY_EXCEPTION = null;
        public static final Issue V4_SIG_VERSION_NOT_CURRENT = null;
        private final String mFormat;

        static {
            Issue r0 = new Issue("JAR_SIG_NO_SIGNATURES", 0, "No JAR signatures");
            JAR_SIG_NO_SIGNATURES = r0;
            Issue r1 = new Issue("JAR_SIG_NO_SIGNED_ZIP_ENTRIES", 1, "No JAR entries covered by JAR signatures");
            JAR_SIG_NO_SIGNED_ZIP_ENTRIES = r1;
            Issue r2 = new Issue("JAR_SIG_DUPLICATE_ZIP_ENTRY", 2, "Duplicate entry: %1$s");
            JAR_SIG_DUPLICATE_ZIP_ENTRY = r2;
            Issue r4 = new Issue("JAR_SIG_DUPLICATE_MANIFEST_SECTION", 3, "Duplicate section in META-INF/MANIFEST.MF: %1$s");
            JAR_SIG_DUPLICATE_MANIFEST_SECTION = r4;
            Issue r6 = new Issue("JAR_SIG_UNNNAMED_MANIFEST_SECTION", 4, "Malformed META-INF/MANIFEST.MF: invidual section #%1$d does not have a name");
            JAR_SIG_UNNNAMED_MANIFEST_SECTION = r6;
            Issue r8 = new Issue("JAR_SIG_UNNNAMED_SIG_FILE_SECTION", 5, "Malformed %1$s: invidual section #%2$d does not have a name");
            JAR_SIG_UNNNAMED_SIG_FILE_SECTION = r8;
            Issue r10 = new Issue("JAR_SIG_NO_MANIFEST", 6, "Missing META-INF/MANIFEST.MF");
            JAR_SIG_NO_MANIFEST = r10;
            Issue r12 = new Issue("JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST", 7, "%1$s entry referenced by META-INF/MANIFEST.MF not found in the APK");
            JAR_SIG_MISSING_ZIP_ENTRY_REFERENCED_IN_MANIFEST = r12;
            Issue r14 = new Issue("JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST", 8, "No digest for %1$s in META-INF/MANIFEST.MF");
            JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_MANIFEST = r14;
            Issue r13 = new Issue("JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE", 9, "No digest for %1$s in %2$s");
            JAR_SIG_NO_ZIP_ENTRY_DIGEST_IN_SIG_FILE = r13;
            Issue r11 = new Issue("JAR_SIG_ZIP_ENTRY_NOT_SIGNED", 10, "%1$s entry not signed");
            JAR_SIG_ZIP_ENTRY_NOT_SIGNED = r11;
            Issue r9 = new Issue("JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH", 11, "Entries %1$s and %3$s are signed with different sets of signers : <%2$s> vs <%4$s>");
            JAR_SIG_ZIP_ENTRY_SIGNERS_MISMATCH = r9;
            Issue r7 = new Issue("JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY", 12, "%2$s digest of %1$s does not match the digest specified in %3$s. Expected: <%5$s>, actual: <%4$s>");
            JAR_SIG_ZIP_ENTRY_DIGEST_DID_NOT_VERIFY = r7;
            Issue r5 = new Issue("JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY", 13, "%1$s digest of META-INF/MANIFEST.MF main section does not match the digest specified in %2$s. Expected: <%4$s>, actual: <%3$s>");
            JAR_SIG_MANIFEST_MAIN_SECTION_DIGEST_DID_NOT_VERIFY = r5;
            Issue r3 = new Issue("JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY", 14, "%2$s digest of META-INF/MANIFEST.MF section for %1$s does not match the digest specified in %3$s. Expected: <%5$s>, actual: <%4$s>");
            JAR_SIG_MANIFEST_SECTION_DIGEST_DID_NOT_VERIFY = r3;
            Issue r15 = new Issue("JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE", 15, "%1$s does not specify digest of META-INF/MANIFEST.MF. This slows down verification.");
            JAR_SIG_NO_MANIFEST_DIGEST_IN_SIG_FILE = r15;
            Issue r16 = new Issue("JAR_SIG_NO_APK_SIG_STRIP_PROTECTION", 16, "APK is signed using APK Signature Scheme v2 but these signatures may be stripped without being detected because %1$s does not contain anti-stripping protections.");
            JAR_SIG_NO_APK_SIG_STRIP_PROTECTION = r16;
            Issue r17 = new Issue("JAR_SIG_MISSING_FILE", 17, "Partial JAR signature. Found: %1$s, missing: %2$s");
            JAR_SIG_MISSING_FILE = r17;
            Issue r18 = new Issue("JAR_SIG_VERIFY_EXCEPTION", 18, "Failed to verify JAR signature %1$s against %2$s: %3$s");
            JAR_SIG_VERIFY_EXCEPTION = r18;
            Issue r19 = new Issue("JAR_SIG_UNSUPPORTED_SIG_ALG", 19, "JAR signature %1$s uses digest algorithm %5$s and signature algorithm %6$s which is not supported on API Level(s) %4$s for which this APK is being verified");
            JAR_SIG_UNSUPPORTED_SIG_ALG = r19;
            Issue r20 = new Issue("JAR_SIG_PARSE_EXCEPTION", 20, "Failed to parse JAR signature %1$s: %2$s");
            JAR_SIG_PARSE_EXCEPTION = r20;
            Issue r21 = new Issue("JAR_SIG_MALFORMED_CERTIFICATE", 21, "Malformed certificate in JAR signature %1$s: %2$s");
            JAR_SIG_MALFORMED_CERTIFICATE = r21;
            Issue r22 = new Issue("JAR_SIG_DID_NOT_VERIFY", 22, "JAR signature %1$s did not verify against %2$s");
            JAR_SIG_DID_NOT_VERIFY = r22;
            Issue r23 = new Issue("JAR_SIG_NO_SIGNERS", 23, "JAR signature %1$s contains no signers");
            JAR_SIG_NO_SIGNERS = r23;
            Issue r24 = new Issue("JAR_SIG_DUPLICATE_SIG_FILE_SECTION", 24, "Duplicate section in %1$s: %2$s");
            JAR_SIG_DUPLICATE_SIG_FILE_SECTION = r24;
            Issue r25 = new Issue("JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE", 25, "Malformed %1$s: missing Signature-Version attribute");
            JAR_SIG_MISSING_VERSION_ATTR_IN_SIG_FILE = r25;
            Issue r26 = new Issue("JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID", 26, "JAR signature %1$s references unknown APK signature scheme ID: %2$d");
            JAR_SIG_UNKNOWN_APK_SIG_SCHEME_ID = r26;
            Issue r27 = new Issue("JAR_SIG_MISSING_APK_SIG_REFERENCED", 27, "JAR signature %1$s indicates the APK is signed using %3$s but no such signature was found. Signature stripped?");
            JAR_SIG_MISSING_APK_SIG_REFERENCED = r27;
            Issue r28 = new Issue("JAR_SIG_UNPROTECTED_ZIP_ENTRY", 28, "%1$s not protected by signature. Unauthorized modifications to this JAR entry will not be detected. Delete or move the entry outside of META-INF/.");
            JAR_SIG_UNPROTECTED_ZIP_ENTRY = r28;
            Issue r29 = new Issue("JAR_SIG_MISSING", 29, "No JAR signature from this signer");
            JAR_SIG_MISSING = r29;
            Issue r30 = new Issue("NO_SIG_FOR_TARGET_SANDBOX_VERSION", 30, "Missing APK Signature Scheme v2 signature required for target sandbox version %1$d");
            NO_SIG_FOR_TARGET_SANDBOX_VERSION = r30;
            Issue r31 = new Issue("MIN_SIG_SCHEME_FOR_TARGET_SDK_NOT_MET", 31, "Target SDK version %1$d requires a minimum of signature scheme v%2$d; the APK is not signed with this or a later signature scheme");
            MIN_SIG_SCHEME_FOR_TARGET_SDK_NOT_MET = r31;
            Issue r32 = new Issue("V2_SIG_MISSING", 32, "No APK Signature Scheme v2 signature from this signer");
            V2_SIG_MISSING = r32;
            Issue r33 = new Issue("V2_SIG_MALFORMED_SIGNERS", 33, "Malformed list of signers");
            V2_SIG_MALFORMED_SIGNERS = r33;
            Issue r34 = new Issue("V2_SIG_NEGATIVE_LEN", 34, "Negative length");
            V2_SIG_NEGATIVE_LEN = r34;
            Issue r35 = new Issue("V3_SIG_NEGATIVE_LEN", 35, "Negative length");
            V3_SIG_NEGATIVE_LEN = r35;
            Issue r36 = new Issue("V4_SIG_NEGATIVE_LEN", 36, "Negative length");
            V4_SIG_NEGATIVE_LEN = r36;
            Issue r37 = new Issue("V2_SIG_MALFORMED_SIGNER", 37, "Malformed signer block");
            V2_SIG_MALFORMED_SIGNER = r37;
            Issue r38 = new Issue("V2_SIG_MALFORMED_PUBLIC_KEY", 38, "Malformed public key: %1$s");
            V2_SIG_MALFORMED_PUBLIC_KEY = r38;
            Issue r39 = new Issue("V2_SIG_MALFORMED_CERTIFICATE", 39, "Malformed certificate #%2$d: %3$s");
            V2_SIG_MALFORMED_CERTIFICATE = r39;
            Issue r40 = new Issue("V2_SIG_MALFORMED_SIGNATURE", 40, "Malformed APK Signature Scheme v2 signature record #%1$d");
            V2_SIG_MALFORMED_SIGNATURE = r40;
            Issue r41 = new Issue("V2_SIG_MALFORMED_DIGEST", 41, "Malformed APK Signature Scheme v2 digest record #%1$d");
            V2_SIG_MALFORMED_DIGEST = r41;
            Issue r42 = new Issue("V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE", 42, "Malformed additional attribute #%1$d");
            V2_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE = r42;
            Issue r43 = new Issue("V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID", 43, "APK Signature Scheme v2 signer: %1$s references unknown APK signature scheme ID: %2$d");
            V2_SIG_UNKNOWN_APK_SIG_SCHEME_ID = r43;
            Issue r44 = new Issue("V2_SIG_MISSING_APK_SIG_REFERENCED", 44, "APK Signature Scheme v2 signature %1$s indicates the APK is signed using %2$s but no such signature was found. Signature stripped?");
            V2_SIG_MISSING_APK_SIG_REFERENCED = r44;
            Issue r45 = new Issue("V2_SIG_NO_SIGNERS", 45, "No signers in APK Signature Scheme v2 signature");
            V2_SIG_NO_SIGNERS = r45;
            Issue r46 = new Issue("V2_SIG_UNKNOWN_SIG_ALGORITHM", 46, "Unknown signature algorithm: %1$#x");
            V2_SIG_UNKNOWN_SIG_ALGORITHM = r46;
            Issue r47 = new Issue("V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE", 47, "Unknown additional attribute: ID %1$#x");
            V2_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE = r47;
            Issue r48 = new Issue("V2_SIG_VERIFY_EXCEPTION", 48, "Failed to verify %1$s signature: %2$s");
            V2_SIG_VERIFY_EXCEPTION = r48;
            Issue r110 = new Issue("V2_SIG_DID_NOT_VERIFY", 49, "%1$s signature over signed-data did not verify(V2_SIG_DID_NOT_VERIFY)");
            V2_SIG_DID_NOT_VERIFY = r110;
            Issue r49 = new Issue("V2_SIG_NO_SIGNATURES", 50, "No signatures");
            V2_SIG_NO_SIGNATURES = r49;
            Issue r111 = new Issue("V2_SIG_NO_SUPPORTED_SIGNATURES", 51, "No supported signatures: %1$s");
            V2_SIG_NO_SUPPORTED_SIGNATURES = r111;
            Issue r50 = new Issue("V2_SIG_NO_CERTIFICATES", 52, "No certificates");
            V2_SIG_NO_CERTIFICATES = r50;
            Issue r112 = new Issue("V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD", 53, "Public key mismatch between certificate and signature record: <%1$s> vs <%2$s>");
            V2_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = r112;
            Issue r51 = new Issue("V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS", 54, "Signature algorithms mismatch between signatures and digests records: %1$s vs %2$s");
            V2_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS = r51;
            Issue r113 = new Issue("V2_SIG_APK_DIGEST_DID_NOT_VERIFY", 55, "APK integrity check failed. %1$s digest mismatch. Expected: <%2$s>, actual: <%3$s>");
            V2_SIG_APK_DIGEST_DID_NOT_VERIFY = r113;
            Issue r52 = new Issue("V3_SIG_MALFORMED_SIGNERS", 56, "Malformed list of signers");
            V3_SIG_MALFORMED_SIGNERS = r52;
            Issue r114 = new Issue("V3_SIG_MALFORMED_SIGNER", 57, "Malformed signer block");
            V3_SIG_MALFORMED_SIGNER = r114;
            Issue r53 = new Issue("V3_SIG_MALFORMED_PUBLIC_KEY", 58, "Malformed public key: %1$s");
            V3_SIG_MALFORMED_PUBLIC_KEY = r53;
            Issue r115 = new Issue("V3_SIG_MALFORMED_CERTIFICATE", 59, "Malformed certificate #%2$d: %3$s");
            V3_SIG_MALFORMED_CERTIFICATE = r115;
            Issue r54 = new Issue("V3_SIG_MALFORMED_SIGNATURE", 60, "Malformed APK Signature Scheme v3 signature record #%1$d");
            V3_SIG_MALFORMED_SIGNATURE = r54;
            Issue r116 = new Issue("V3_SIG_MALFORMED_DIGEST", 61, "Malformed APK Signature Scheme v3 digest record #%1$d");
            V3_SIG_MALFORMED_DIGEST = r116;
            Issue r55 = new Issue("V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE", 62, "Malformed additional attribute #%1$d");
            V3_SIG_MALFORMED_ADDITIONAL_ATTRIBUTE = r55;
            Issue r117 = new Issue("V3_SIG_NO_SIGNERS", 63, "No signers in APK Signature Scheme v3 signature");
            V3_SIG_NO_SIGNERS = r117;
            Issue r56 = new Issue("V3_SIG_MULTIPLE_SIGNERS", 64, "Multiple APK Signature Scheme v3 signatures found for a single  platform version.");
            V3_SIG_MULTIPLE_SIGNERS = r56;
            Issue r118 = new Issue("V3_SIG_MULTIPLE_PAST_SIGNERS", 65, "Multiple signatures found for pre-v3 signing with an APK  Signature Scheme v3 signer.  Only one allowed.");
            V3_SIG_MULTIPLE_PAST_SIGNERS = r118;
            Issue r57 = new Issue("V3_SIG_PAST_SIGNERS_MISMATCH", 66, "v3 signer differs from v1/v2 signer without proper signing certificate lineage.");
            V3_SIG_PAST_SIGNERS_MISMATCH = r57;
            Issue r119 = new Issue("V3_SIG_UNKNOWN_SIG_ALGORITHM", 67, "Unknown signature algorithm: %1$#x");
            V3_SIG_UNKNOWN_SIG_ALGORITHM = r119;
            Issue r120 = new Issue("V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE", 68, "Unknown additional attribute: ID %1$#x");
            V3_SIG_UNKNOWN_ADDITIONAL_ATTRIBUTE = r120;
            Issue r58 = new Issue("V3_SIG_VERIFY_EXCEPTION", 69, "Failed to verify %1$s signature: %2$s");
            V3_SIG_VERIFY_EXCEPTION = r58;
            Issue r121 = new Issue("V3_SIG_INVALID_SDK_VERSIONS", 70, "Invalid SDK Version parameter(s) encountered in APK Signature scheme v3 signature: minSdkVersion %1$s maxSdkVersion: %2$s");
            V3_SIG_INVALID_SDK_VERSIONS = r121;
            Issue r59 = new Issue("V3_SIG_DID_NOT_VERIFY", 71, "%1$s signature over signed-data did not verify(V3_SIG_DID_NOT_VERIFY)");
            V3_SIG_DID_NOT_VERIFY = r59;
            Issue r122 = new Issue("V3_SIG_NO_SIGNATURES", 72, "No signatures");
            V3_SIG_NO_SIGNATURES = r122;
            Issue r60 = new Issue("V3_SIG_NO_SUPPORTED_SIGNATURES", 73, "No supported signatures");
            V3_SIG_NO_SUPPORTED_SIGNATURES = r60;
            Issue r123 = new Issue("V3_SIG_NO_CERTIFICATES", 74, "No certificates");
            V3_SIG_NO_CERTIFICATES = r123;
            Issue r61 = new Issue("V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD", 75, "minSdkVersion mismatch between signed data and signature record: <%1$s> vs <%2$s>");
            V3_MIN_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD = r61;
            Issue r124 = new Issue("V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD", 76, "maxSdkVersion mismatch between signed data and signature record: <%1$s> vs <%2$s>");
            V3_MAX_SDK_VERSION_MISMATCH_BETWEEN_SIGNER_AND_SIGNED_DATA_RECORD = r124;
            Issue r62 = new Issue("V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD", 77, "Public key mismatch between certificate and signature record: <%1$s> vs <%2$s>");
            V3_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = r62;
            Issue r125 = new Issue("V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS", 78, "Signature algorithms mismatch between signatures and digests records: %1$s vs %2$s");
            V3_SIG_SIG_ALG_MISMATCH_BETWEEN_SIGNATURES_AND_DIGESTS_RECORDS = r125;
            Issue r63 = new Issue("V3_SIG_APK_DIGEST_DID_NOT_VERIFY", 79, "APK integrity check failed. %1$s digest mismatch. Expected: <%2$s>, actual: <%3$s>");
            V3_SIG_APK_DIGEST_DID_NOT_VERIFY = r63;
            Issue r126 = new Issue("V3_SIG_POR_DID_NOT_VERIFY", 80, "SigningCertificateLineage attribute containd a proof-of-rotation record with signature(s) that did not verify.");
            V3_SIG_POR_DID_NOT_VERIFY = r126;
            Issue r64 = new Issue("V3_SIG_MALFORMED_LINEAGE", 81, "Failed to parse the SigningCertificateLineage structure in the APK Signature Scheme v3 signature's additional attributes section.");
            V3_SIG_MALFORMED_LINEAGE = r64;
            Issue r127 = new Issue("V3_SIG_POR_CERT_MISMATCH", 82, "APK signing certificate differs from the associated certificate found in the signer's SigningCertificateLineage.");
            V3_SIG_POR_CERT_MISMATCH = r127;
            Issue r65 = new Issue("V3_INCONSISTENT_SDK_VERSIONS", 83, "APK Signature Scheme v3 signers supported min/max SDK versions are not continuous.");
            V3_INCONSISTENT_SDK_VERSIONS = r65;
            Issue r128 = new Issue("V3_MISSING_SDK_VERSIONS", 84, "APK Signature Scheme v3 signers supported min/max SDK versions do not cover the entire desired range.  Found min:  %1$s max %2$s");
            V3_MISSING_SDK_VERSIONS = r128;
            Issue r66 = new Issue("V3_INCONSISTENT_LINEAGES", 85, "SigningCertificateLineages targeting different platform versions using APK Signature Scheme v3 are not all a part of the same overall lineage.");
            V3_INCONSISTENT_LINEAGES = r66;
            Issue r129 = new Issue("V31_BLOCK_MISSING", 86, "The v3 signer indicates key rotation should be supported starting from SDK version %1$s, but a v3.1 block was not found");
            V31_BLOCK_MISSING = r129;
            Issue r67 = new Issue("V31_ROTATION_MIN_SDK_MISMATCH", 87, "The v3 signer indicates key rotation should be supported starting from SDK version %1$s, but the v3.1 block targets %2$s for rotation");
            V31_ROTATION_MIN_SDK_MISMATCH = r67;
            Issue r130 = new Issue("V31_ROTATION_MIN_SDK_ATTR_MISSING", 88, "APK supports key rotation starting from SDK version %1$s, but the v3 signer does not contain the attribute to detect if this signature is stripped");
            V31_ROTATION_MIN_SDK_ATTR_MISSING = r130;
            Issue r68 = new Issue("V31_BLOCK_FOUND_WITHOUT_V3_BLOCK", 89, "The APK contains a v3.1 signing block without a v3.0 base block");
            V31_BLOCK_FOUND_WITHOUT_V3_BLOCK = r68;
            Issue r131 = new Issue("V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER", 90, "The rotation-targets-dev-release attribute is only supported on v3.1 signers; this attribute will be ignored by the platform in a v3.0 signer");
            V31_ROTATION_TARGETS_DEV_RELEASE_ATTR_ON_V3_SIGNER = r131;
            Issue r69 = new Issue("APK_SIG_BLOCK_UNKNOWN_ENTRY_ID", 91, "APK Signing Block contains unknown entry: ID %1$#x");
            APK_SIG_BLOCK_UNKNOWN_ENTRY_ID = r69;
            Issue r132 = new Issue("V4_SIG_MALFORMED_SIGNERS", 92, "V4 signature has malformed signer block");
            V4_SIG_MALFORMED_SIGNERS = r132;
            Issue r70 = new Issue("V4_SIG_UNKNOWN_SIG_ALGORITHM", 93, "V4 signature has unknown signing algorithm: %1$#x");
            V4_SIG_UNKNOWN_SIG_ALGORITHM = r70;
            Issue r133 = new Issue("V4_SIG_NO_SIGNATURES", 94, "V4 signature has no signature found");
            V4_SIG_NO_SIGNATURES = r133;
            Issue r71 = new Issue("V4_SIG_NO_SUPPORTED_SIGNATURES", 95, "V4 signature has no supported signature");
            V4_SIG_NO_SUPPORTED_SIGNATURES = r71;
            Issue r134 = new Issue("V4_SIG_DID_NOT_VERIFY", 96, "%1$s signature over signed-data did not verify(V4_SIG_DID_NOT_VERIFY)");
            V4_SIG_DID_NOT_VERIFY = r134;
            Issue r72 = new Issue("V4_SIG_VERIFY_EXCEPTION", 97, "Failed to verify %1$s signature: %2$s");
            V4_SIG_VERIFY_EXCEPTION = r72;
            Issue r135 = new Issue("V4_SIG_MALFORMED_PUBLIC_KEY", 98, "Malformed public key: %1$s");
            V4_SIG_MALFORMED_PUBLIC_KEY = r135;
            Issue r73 = new Issue("V4_SIG_MALFORMED_CERTIFICATE", 99, "V4 signature has malformed certificate");
            V4_SIG_MALFORMED_CERTIFICATE = r73;
            Issue r74 = new Issue("V4_SIG_NO_CERTIFICATE", 100, "V4 signature has no certificate");
            V4_SIG_NO_CERTIFICATE = r74;
            Issue r75 = new Issue("V4_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD", 101, "V4 signature has mismatched certificate and signature: <%1$s> vs <%2$s>");
            V4_SIG_PUBLIC_KEY_MISMATCH_BETWEEN_CERTIFICATE_AND_SIGNATURES_RECORD = r75;
            Issue r76 = new Issue("V4_SIG_APK_ROOT_DID_NOT_VERIFY", 102, "V4 signature's hash tree root (content digest) did not verity");
            V4_SIG_APK_ROOT_DID_NOT_VERIFY = r76;
            Issue r77 = new Issue("V4_SIG_APK_TREE_DID_NOT_VERIFY", 103, "V4 signature's hash tree did not verity");
            V4_SIG_APK_TREE_DID_NOT_VERIFY = r77;
            Issue r78 = new Issue("V4_SIG_MULTIPLE_SIGNERS", 104, "V4 signature only supports one signer");
            V4_SIG_MULTIPLE_SIGNERS = r78;
            Issue r79 = new Issue("V4_SIG_V2_V3_SIGNERS_MISMATCH", 105, "V4 signature and V2/V3 signature have mismatched certificates");
            V4_SIG_V2_V3_SIGNERS_MISMATCH = r79;
            Issue r80 = new Issue("V4_SIG_V2_V3_DIGESTS_MISMATCH", 106, "V4 signature and V2/V3 signature have mismatched digests");
            V4_SIG_V2_V3_DIGESTS_MISMATCH = r80;
            Issue r81 = new Issue("V4_SIG_VERSION_NOT_CURRENT", 107, "V4 signature format version %1$d is different from the tool's current version %2$d");
            V4_SIG_VERSION_NOT_CURRENT = r81;
            Issue r82 = new Issue("SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING", 108, "Neither the source stamp certificate digest file nor the signature block are present in the APK");
            SOURCE_STAMP_CERT_DIGEST_AND_SIG_BLOCK_MISSING = r82;
            Issue r83 = new Issue("SOURCE_STAMP_SIG_MISSING", 109, "No SourceStamp signature");
            SOURCE_STAMP_SIG_MISSING = r83;
            Issue r84 = new Issue("SOURCE_STAMP_MALFORMED_CERTIFICATE", 110, "Malformed certificate: %1$s");
            SOURCE_STAMP_MALFORMED_CERTIFICATE = r84;
            Issue r85 = new Issue("SOURCE_STAMP_MALFORMED_SIGNATURE", 111, "Malformed SourceStamp signature");
            SOURCE_STAMP_MALFORMED_SIGNATURE = r85;
            Issue r86 = new Issue("SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM", 112, "Unknown signature algorithm: %1$#x");
            SOURCE_STAMP_UNKNOWN_SIG_ALGORITHM = r86;
            Issue r87 = new Issue("SOURCE_STAMP_VERIFY_EXCEPTION", 113, "Failed to verify %1$s signature: %2$s");
            SOURCE_STAMP_VERIFY_EXCEPTION = r87;
            Issue r88 = new Issue("SOURCE_STAMP_DID_NOT_VERIFY", 114, "%1$s signature over signed-data did not verify(SOURCE_STAMP_DID_NOT_VERIFY)");
            SOURCE_STAMP_DID_NOT_VERIFY = r88;
            Issue r89 = new Issue("SOURCE_STAMP_NO_SIGNATURE", 115, "No signature");
            SOURCE_STAMP_NO_SIGNATURE = r89;
            Issue r90 = new Issue("SOURCE_STAMP_NO_SUPPORTED_SIGNATURE", 116, "Signature(s) {%1$s} not supported: %2$s");
            SOURCE_STAMP_NO_SUPPORTED_SIGNATURE = r90;
            Issue r91 = new Issue("SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK", 117, "Certificate mismatch between SourceStamp block in APK signing block and SourceStamp file in APK: <%1$s> vs <%2$s>");
            SOURCE_STAMP_CERTIFICATE_MISMATCH_BETWEEN_SIGNATURE_BLOCK_AND_APK = r91;
            Issue r92 = new Issue("SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST", 118, "A source stamp signature block was found without a corresponding certificate digest in the APK");
            SOURCE_STAMP_SIGNATURE_BLOCK_WITHOUT_CERT_DIGEST = r92;
            Issue r93 = new Issue("SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH", 119, "The source stamp certificate digest in the APK, %1$s, does not match the expected digest, %2$s");
            SOURCE_STAMP_EXPECTED_DIGEST_MISMATCH = r93;
            Issue r94 = new Issue("SOURCE_STAMP_MALFORMED_ATTRIBUTE", 120, "Malformed stamp attribute #%1$d");
            SOURCE_STAMP_MALFORMED_ATTRIBUTE = r94;
            Issue r95 = new Issue("SOURCE_STAMP_UNKNOWN_ATTRIBUTE", 121, "Unknown stamp attribute: ID %1$#x");
            SOURCE_STAMP_UNKNOWN_ATTRIBUTE = r95;
            Issue r96 = new Issue("SOURCE_STAMP_MALFORMED_LINEAGE", 122, "Failed to parse the SigningCertificateLineage structure in the source stamp attributes section.");
            SOURCE_STAMP_MALFORMED_LINEAGE = r96;
            Issue r97 = new Issue("SOURCE_STAMP_POR_CERT_MISMATCH", 123, "APK signing certificate differs from the associated certificate found in the signer's SigningCertificateLineage.");
            SOURCE_STAMP_POR_CERT_MISMATCH = r97;
            Issue r98 = new Issue("SOURCE_STAMP_POR_DID_NOT_VERIFY", 124, "Source stamp SigningCertificateLineage attribute contains a proof-of-rotation record with signature(s) that did not verify.");
            SOURCE_STAMP_POR_DID_NOT_VERIFY = r98;
            Issue r99 = new Issue("MALFORMED_APK", 125, "Malformed APK; the following exception was caught when attempting to parse the APK: %1$s");
            MALFORMED_APK = r99;
            Issue r100 = new Issue("UNEXPECTED_EXCEPTION", 126, "An unexpected exception was caught when verifying the signature: %1$s");
            UNEXPECTED_EXCEPTION = r100;
            $VALUES = new Issue[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7, r5, r3, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r110, r49, r111, r50, r112, r51, r113, r52, r114, r53, r115, r54, r116, r55, r117, r56, r118, r57, r119, r120, r58, r121, r59, r122, r60, r123, r61, r124, r62, r125, r63, r126, r64, r127, r65, r128, r66, r129, r67, r130, r68, r131, r69, r132, r70, r133, r71, r134, r72, r135, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100};
        }

        private Issue(String r1, int r2, String r3) {
            super(r1, r2);
            this.mFormat = r3;
        }

        static /* synthetic */ String access$800(Issue r0) {
            return r0.mFormat;
        }

        static /* synthetic */ String access$900(Issue r0) {
            return r0.getFormat();
        }

        private String getFormat() {
            return this.mFormat;
        }

        public static Issue valueOf(String r1) {
            return (Issue) Enum.valueOf(Issue.class, r1);
        }

        public static Issue[] values() {
            return (Issue[]) $VALUES.clone();
        }
    }

    public static class IssueWithParams extends ApkVerificationIssue {
        private final Issue mIssue;
        private final Object[] mParams;

        public IssueWithParams(Issue r2, Object[] r3) {
            super(Issue.access$800(r2), r3);
            this.mIssue = r2;
            this.mParams = r3;
        }

        @Override // com.android.apksig.ApkVerificationIssue
        public Object[] getParams() {
            return (Object[]) this.mParams.clone();
        }

        @Override // com.android.apksig.ApkVerificationIssue
        public String toString() {
            return String.format(Issue.access$900(this.mIssue), this.mParams);
        }
    }

    public static class Result {
        private final List<IssueWithParams> mErrors;
        private final List<X509Certificate> mSignerCerts;
        private SourceStampInfo mSourceStampInfo;
        private final List<V1SchemeSignerInfo> mV1SchemeIgnoredSigners;
        private final List<V1SchemeSignerInfo> mV1SchemeSigners;
        private final List<V2SchemeSignerInfo> mV2SchemeSigners;
        private final List<V3SchemeSignerInfo> mV31SchemeSigners;
        private final List<V3SchemeSignerInfo> mV3SchemeSigners;
        private boolean mVerified;
        private boolean mVerifiedUsingV1Scheme;
        private boolean mVerifiedUsingV2Scheme;
        private boolean mVerifiedUsingV31Scheme;
        private boolean mVerifiedUsingV3Scheme;
        private final List<IssueWithParams> mWarnings;
        private boolean mWarningsAsErrors;

        public static class SourceStampInfo {
            private final List<X509Certificate> mCertificateLineage;
            private final List<X509Certificate> mCertificates;
            private final List<IssueWithParams> mErrors;
            private final SourceStampVerificationStatus mSourceStampVerificationStatus;
            private final List<IssueWithParams> mWarnings;

            public static final enum SourceStampVerificationStatus extends Enum<SourceStampVerificationStatus> {
                private static final /* synthetic */ SourceStampVerificationStatus[] $VALUES = null;
                public static final SourceStampVerificationStatus CERT_DIGEST_MISMATCH = null;
                public static final SourceStampVerificationStatus STAMP_MISSING = null;
                public static final SourceStampVerificationStatus STAMP_NOT_VERIFIED = null;
                public static final SourceStampVerificationStatus STAMP_VERIFICATION_FAILED = null;
                public static final SourceStampVerificationStatus STAMP_VERIFIED = null;
                public static final SourceStampVerificationStatus VERIFICATION_ERROR = null;

                static {
                    SourceStampVerificationStatus r0 = new SourceStampVerificationStatus("STAMP_VERIFIED", 0);
                    STAMP_VERIFIED = r0;
                    SourceStampVerificationStatus r1 = new SourceStampVerificationStatus("STAMP_VERIFICATION_FAILED", 1);
                    STAMP_VERIFICATION_FAILED = r1;
                    SourceStampVerificationStatus r3 = new SourceStampVerificationStatus("CERT_DIGEST_MISMATCH", 2);
                    CERT_DIGEST_MISMATCH = r3;
                    SourceStampVerificationStatus r5 = new SourceStampVerificationStatus("STAMP_MISSING", 3);
                    STAMP_MISSING = r5;
                    SourceStampVerificationStatus r7 = new SourceStampVerificationStatus("STAMP_NOT_VERIFIED", 4);
                    STAMP_NOT_VERIFIED = r7;
                    SourceStampVerificationStatus r9 = new SourceStampVerificationStatus("VERIFICATION_ERROR", 5);
                    VERIFICATION_ERROR = r9;
                    $VALUES = new SourceStampVerificationStatus[]{r0, r1, r3, r5, r7, r9};
                }

                private SourceStampVerificationStatus(String r1, int r2) {
                    super(r1, r2);
                }

                public static SourceStampVerificationStatus valueOf(String r1) {
                    return (SourceStampVerificationStatus) Enum.valueOf(SourceStampVerificationStatus.class, r1);
                }

                public static SourceStampVerificationStatus[] values() {
                    return (SourceStampVerificationStatus[]) $VALUES.clone();
                }
            }

            /* synthetic */ SourceStampInfo(ApkSignerInfo r1, AnonymousClass1 r2) {
                this(r1);
            }

            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public List<IssueWithParams> getWarnings() {
                return this.mWarnings;
            }

            private SourceStampInfo(ApkSignerInfo r2) {
                this.mCertificates = r2.certs;
                this.mCertificateLineage = r2.certificateLineage;
                List<IssueWithParams> r0 = ApkVerificationIssueAdapter.getIssuesFromVerificationIssues(r2.getErrors());
                this.mErrors = r0;
                List<IssueWithParams> r3 = ApkVerificationIssueAdapter.getIssuesFromVerificationIssues(r2.getWarnings());
                this.mWarnings = r3;
                if (r0.isEmpty() == true) goto L5;
            L7:
                this.mSourceStampVerificationStatus = SourceStampVerificationStatus.STAMP_VERIFICATION_FAILED;
                return;
            L5:
                if (r3.isEmpty() == false) goto L7;
                this.mSourceStampVerificationStatus = SourceStampVerificationStatus.STAMP_VERIFIED;
            }
        }

        public static class V1SchemeSignerInfo implements ISchemeSignerInfo {
            private final List<X509Certificate> mCertChain;
            private final List<IssueWithParams> mErrors;
            private final String mName;
            private final String mSignatureBlockFileName;
            private final String mSignatureFileName;
            private final List<IssueWithParams> mWarnings;

            /* synthetic */ V1SchemeSignerInfo(V1SchemeVerifier.Result.SignerInfo r1, AnonymousClass1 r2) {
                this(r1);
            }

            private void addError(Issue r2, Object... r3) {
                this.mErrors.add(new IssueWithParams(r2, r3));
            }

            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public X509Certificate getCertificate() {
                if (this.mCertChain.isEmpty() == false) goto L6;
                return null;
            L6:
                return this.mCertChain.get(0);
            }

            public List<X509Certificate> getCertificateChain() {
                return this.mCertChain;
            }

            @Override // com.android.apksig.internal.apk.ISchemeSignerInfo
            public List<X509Certificate> getCertificates() {
                return this.mCertChain;
            }

            public List<IssueWithParams> getErrors() {
                return this.mErrors;
            }

            public String getName() {
                return this.mName;
            }

            public String getSignatureBlockFileName() {
                return this.mSignatureBlockFileName;
            }

            public String getSignatureFileName() {
                return this.mSignatureFileName;
            }

            public List<IssueWithParams> getWarnings() {
                return this.mWarnings;
            }

            private V1SchemeSignerInfo(V1SchemeVerifier.Result.SignerInfo r2) {
                this.mName = r2.name;
                this.mCertChain = r2.certChain;
                this.mSignatureBlockFileName = r2.signatureBlockFileName;
                this.mSignatureFileName = r2.signatureFileName;
                this.mErrors = r2.getErrors();
                this.mWarnings = r2.getWarnings();
            }
        }

        public static class V2SchemeSignerInfo implements ISchemeSignerInfo {
            private final List<X509Certificate> mCerts;
            private final List<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> mContentDigests;
            private final List<IssueWithParams> mErrors;
            private final int mIndex;
            private final List<IssueWithParams> mWarnings;

            /* synthetic */ V2SchemeSignerInfo(ApkSigningBlockUtils.Result.SignerInfo r1, AnonymousClass1 r2) {
                this(r1);
            }

            private void addError(Issue r2, Object... r3) {
                this.mErrors.add(new IssueWithParams(r2, r3));
            }

            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public X509Certificate getCertificate() {
                if (this.mCerts.isEmpty() == false) goto L6;
                return null;
            L6:
                return this.mCerts.get(0);
            }

            @Override // com.android.apksig.internal.apk.ISchemeSignerInfo
            public List<X509Certificate> getCertificates() {
                return this.mCerts;
            }

            public int getIndex() {
                return this.mIndex;
            }

            public List<IssueWithParams> getWarnings() {
                return this.mWarnings;
            }

            private V2SchemeSignerInfo(ApkSigningBlockUtils.Result.SignerInfo r2) {
                this.mIndex = r2.index;
                this.mCerts = r2.certs;
                this.mErrors = r2.getErrors();
                this.mWarnings = r2.getWarnings();
                this.mContentDigests = r2.contentDigests;
            }
        }

        public static class V3SchemeSignerInfo implements ISchemeSignerInfo {
            private final List<X509Certificate> mCerts;
            private final List<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> mContentDigests;
            private final List<IssueWithParams> mErrors;
            private final int mIndex;
            private final List<IssueWithParams> mWarnings;

            /* synthetic */ V3SchemeSignerInfo(ApkSigningBlockUtils.Result.SignerInfo r1, AnonymousClass1 r2) {
                this(r1);
            }

            public boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public X509Certificate getCertificate() {
                if (this.mCerts.isEmpty() == false) goto L6;
                return null;
            L6:
                return this.mCerts.get(0);
            }

            @Override // com.android.apksig.internal.apk.ISchemeSignerInfo
            public List<X509Certificate> getCertificates() {
                return this.mCerts;
            }

            public int getIndex() {
                return this.mIndex;
            }

            public List<IssueWithParams> getWarnings() {
                return this.mWarnings;
            }

            private V3SchemeSignerInfo(ApkSigningBlockUtils.Result.SignerInfo r2) {
                this.mIndex = r2.index;
                this.mCerts = r2.certs;
                this.mErrors = r2.getErrors();
                this.mWarnings = r2.getWarnings();
                this.mContentDigests = r2.contentDigests;
            }
        }

        public Result() {
            this.mErrors = new ArrayList();
            this.mWarnings = new ArrayList();
            this.mSignerCerts = new ArrayList();
            this.mV1SchemeSigners = new ArrayList();
            this.mV1SchemeIgnoredSigners = new ArrayList();
            this.mV2SchemeSigners = new ArrayList();
            this.mV3SchemeSigners = new ArrayList();
            this.mV31SchemeSigners = new ArrayList();
        }

        static /* synthetic */ void access$000(Result r0, ApkSigningBlockUtils.Result r1) {
            r0.mergeFrom(r1);
        }

        static /* synthetic */ void access$100(Result r0, V1SchemeVerifier.Result r1) {
            r0.mergeFrom(r1);
        }

        static /* synthetic */ void access$200(Result r0) {
            r0.setVerified();
        }

        static /* synthetic */ void access$300(Result r0, X509Certificate r1) {
            r0.addSignerCertificate(r1);
        }

        private void addSignerCertificate(X509Certificate r1) {
            this.mSignerCerts.add(r1);
        }

        private void mergeFrom(ApkSigningBlockUtils.Result r5) {
            int r0 = r5.signatureSchemeVersion;
            AnonymousClass1 r1 = null;
            if (r0 == 0) goto L25;
            if (r0 != 31) goto L7;
            this.mVerifiedUsingV31Scheme = r5.verified;
            Iterator<ApkSigningBlockUtils.Result.SignerInfo> r6 = r5.signers.iterator();
        L22:
            if (r6.hasNext() == false) goto L34;
            ApkSigningBlockUtils.Result.SignerInfo r2 = r6.next();
            this.mV31SchemeSigners.add(new V3SchemeSignerInfo(r2, r1));
            goto L22
        L34:
            return;
        L7:
            if (r0 != 2) goto L9;
            this.mVerifiedUsingV2Scheme = r5.verified;
            Iterator<ApkSigningBlockUtils.Result.SignerInfo> r7 = r5.signers.iterator();
        L18:
            if (r7.hasNext() == false) goto L33;
            ApkSigningBlockUtils.Result.SignerInfo r3 = r7.next();
            this.mV2SchemeSigners.add(new V2SchemeSignerInfo(r3, r1));
            goto L18
        L33:
            return;
        L9:
            if (r0 != 3) goto L15;
            this.mVerifiedUsingV3Scheme = r5.verified;
            Iterator<ApkSigningBlockUtils.Result.SignerInfo> r8 = r5.signers.iterator();
        L12:
            if (r8.hasNext() == false) goto L32;
            ApkSigningBlockUtils.Result.SignerInfo r4 = r8.next();
            this.mV3SchemeSigners.add(new V3SchemeSignerInfo(r4, r1));
            goto L12
        L32:
            return;
        L15:
            throw new IllegalArgumentException("Unknown Signing Block Scheme Id");
        L25:
            if (r5.signers.isEmpty() == true) goto L31;
            this.mSourceStampInfo = new SourceStampInfo(r5.signers.get(0), r1);
            return;
        }

        private void setVerified() {
            this.mVerified = true;
        }

        public boolean containsErrors() {
            if (this.mErrors.isEmpty() == true) goto L6;
            return true;
        L6:
            if (this.mWarningsAsErrors == false) goto L11;
            if (this.mWarnings.isEmpty() == true) goto L11;
            return true;
        L11:
            if (this.mV2SchemeSigners.isEmpty() == true) goto L24;
            Iterator<V2SchemeSignerInfo> r0 = this.mV2SchemeSigners.iterator();
        L14:
            if (r0.hasNext() == false) goto L24;
            V2SchemeSignerInfo r2 = r0.next();
            if (r2.containsErrors() == true) goto L17;
            if (this.mWarningsAsErrors == false) goto L14;
            if (r2.getWarnings().isEmpty() == true) goto L14;
            return true;
        L17:
            return true;
        L24:
            if (this.mV3SchemeSigners.isEmpty() == true) goto L36;
            Iterator<V3SchemeSignerInfo> r1 = this.mV3SchemeSigners.iterator();
        L27:
            if (r1.hasNext() == false) goto L36;
            V3SchemeSignerInfo r3 = r1.next();
            if (r3.containsErrors() == true) goto L30;
            if (this.mWarningsAsErrors == false) goto L27;
            if (r3.getWarnings().isEmpty() == true) goto L27;
            return true;
        L30:
            return true;
        L36:
            SourceStampInfo r4 = this.mSourceStampInfo;
            if (r4 != null) goto L39;
            return false;
        L39:
            if (r4.containsErrors() == false) goto L42;
            return true;
        L42:
            if (this.mWarningsAsErrors == false) goto L47;
            if (this.mSourceStampInfo.getWarnings().isEmpty() == true) goto L47;
            return true;
        L47:
            return false;
        }

        public List<X509Certificate> getSignerCertificates() {
            return this.mSignerCerts;
        }

        public List<V1SchemeSignerInfo> getV1SchemeIgnoredSigners() {
            return this.mV1SchemeIgnoredSigners;
        }

        public List<V1SchemeSignerInfo> getV1SchemeSigners() {
            return this.mV1SchemeSigners;
        }

        public List<V2SchemeSignerInfo> getV2SchemeSigners() {
            return this.mV2SchemeSigners;
        }

        public List<V3SchemeSignerInfo> getV31SchemeSigners() {
            return this.mV31SchemeSigners;
        }

        public List<V3SchemeSignerInfo> getV3SchemeSigners() {
            return this.mV3SchemeSigners;
        }

        public boolean isVerified() {
            return this.mVerified;
        }

        public boolean isVerifiedUsingV1Scheme() {
            return this.mVerifiedUsingV1Scheme;
        }

        public boolean isVerifiedUsingV2Scheme() {
            return this.mVerifiedUsingV2Scheme;
        }

        public boolean isVerifiedUsingV31Scheme() {
            return this.mVerifiedUsingV31Scheme;
        }

        public boolean isVerifiedUsingV3Scheme() {
            return this.mVerifiedUsingV3Scheme;
        }

        private void mergeFrom(V1SchemeVerifier.Result r6) {
            this.mVerifiedUsingV1Scheme = r6.verified;
            this.mErrors.addAll(r6.getErrors());
            this.mWarnings.addAll(r6.getWarnings());
            Iterator<V1SchemeVerifier.Result.SignerInfo> r0 = r6.signers.iterator();
        L3:
            AnonymousClass1 r2 = null;
            if (r0.hasNext() == false) goto L6;
            V1SchemeVerifier.Result.SignerInfo r1 = r0.next();
            this.mV1SchemeSigners.add(new V1SchemeSignerInfo(r1, r2));
            goto L3
        L6:
            Iterator<V1SchemeVerifier.Result.SignerInfo> r7 = r6.ignoredSigners.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            V1SchemeVerifier.Result.SignerInfo r3 = r7.next();
            this.mV1SchemeIgnoredSigners.add(new V1SchemeSignerInfo(r3, r2));
            goto L8
        }
    }

    static {
        SUPPORTED_APK_SIG_SCHEME_NAMES = loadSupportedApkSigSchemeNames();
    }

    /* synthetic */ ApkVerifier(File r1, DataSource r2, Integer r3, int r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private static void collectApkContentDigests(List<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> r2, Map<ContentDigestAlgorithm, byte[]> r3) {
        Iterator<ApkSigningBlockUtils.Result.SignerInfo.ContentDigest> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        ApkSigningBlockUtils.Result.SignerInfo.ContentDigest r0 = r4.next();
        SignatureAlgorithm r1 = SignatureAlgorithm.findById(r0.getSignatureAlgorithmId());
        if (r1 == null) goto L4;
        r3.put(r1.getContentDigestAlgorithm(), r0.getValue());
        goto L4
    }

    private static Map<ContentDigestAlgorithm, byte[]> getApkContentDigestFromV1SigningScheme(List<CentralDirectoryRecord> r4, DataSource r5, ApkUtils.ZipSections r6) throws IOException, ApkFormatException {
        EnumMap r0 = new EnumMap(ContentDigestAlgorithm.class);
        Iterator<CentralDirectoryRecord> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        CentralDirectoryRecord r1 = r7.next();
        if (V1SchemeConstants.MANIFEST_ENTRY_NAME.equals(r1.getName()) == false) goto L4;
    L9:
        if (r1 != null) goto L16;
        return r0;
    L16:
        byte[] r8 = LocalFileRecord.getUncompressedData(r5, r1, r6.getZipCentralDirectoryOffset());     // Catch: ZipFormatException -> L13
        r0.put(ContentDigestAlgorithm.SHA256, ApkUtilsLite.computeSha256DigestBytes(r8));     // Catch: ZipFormatException -> L13
        return r0;
    L13:
        e = move-exception;
        throw new ApkFormatException("Failed to read APK", e);
    L8:
        r1 = null;
        goto L9
    }

    private static Map<ContentDigestAlgorithm, byte[]> getApkContentDigestsFromSigningSchemeResult(ApkSigningBlockUtils.Result r2) {
        HashMap r0 = new HashMap();
        Iterator<ApkSigningBlockUtils.Result.SignerInfo> r3 = r2.signers.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        collectApkContentDigests(r3.next().contentDigests, r0);
        goto L4
    L6:
        return r0;
    }

    private static Map<Integer, String> getSupportedSchemeNames(int r3) {
        if (r3 < 28) goto L6;
        return SUPPORTED_APK_SIG_SCHEME_NAMES;
    L6:
        if (r3 < 24) goto L9;
        HashMap r4 = new HashMap(1);
        r4.put(2, SUPPORTED_APK_SIG_SCHEME_NAMES.get(2));
        return r4;
    L9:
        return Collections.emptyMap();
    }

    private static Map<Integer, String> loadSupportedApkSigSchemeNames() {
        HashMap r0 = new HashMap(2);
        r0.put(2, "APK Signature Scheme v2");
        r0.put(3, "APK Signature Scheme v3");
        return r0;
    }

    public Result verify() throws IOException, ApkFormatException, NoSuchAlgorithmException, IllegalStateException {
        RandomAccessFile r0 = null;
        DataSource r1 = this.mApkDataSource;     // Catch: Throwable -> L19
        if (r1 == null) goto L7;
    L11:
        Result r7 = verify(r1);     // Catch: Throwable -> L19
        if (r0 == null) goto L14;
        r0.close();
    L14:
        return r7;
    L7:
        if (this.mApkFile == null) goto L18;
        RandomAccessFile r2 = new RandomAccessFile(this.mApkFile, "r");     // Catch: Throwable -> L19
        r1 = DataSources.asDataSource(r2, 0, r2.length());     // Catch: Throwable -> L15
        r0 = r2;
    L15:
        th = th;
    L21:
        if (r2 == null) goto L23;
        r2.close();
    L23:
        throw th;
    L18:
        throw new IllegalStateException("APK not provided");     // Catch: Throwable -> L19
    L19:
        th = th;
        r2 = null;
        goto L21
    }

    private ApkVerifier(File r1, DataSource r2, Integer r3, int r4) {
        this.mApkFile = r1;
        this.mApkDataSource = r2;
        this.mMinSdkVersion = r3;
        this.mMaxSdkVersion = r4;
    }

    private Result verify(DataSource r17) throws IOException, ApkFormatException, NoSuchAlgorithmException {
        int r1 = this.mMaxSdkVersion;
        ApkUtils.ZipSections r7 = ApkUtils.findZipSections(r17);     // Catch: ZipFormatException -> L61
        Integer r0 = this.mMinSdkVersion;
        if (r0 == null) goto L7;
        int r8 = r0.intValue();
        int r9 = r1;
    L8:
        Result r10 = new Result();
        HashMap r11 = new HashMap();
        Map<Integer, String> r12 = getSupportedSchemeNames(r9);
        HashSet r13 = new HashSet(2);
        if (r9 < 24) goto L47;
        RunnablesExecutor r2 = RunnablesExecutor.SINGLE_THREADED;
        if (r9 < 33) goto L20;
        ApkSigningBlockUtils.Result r3 = V3SchemeVerifier.verify(r17, r7, 31, V3SchemeConstants.APK_SIGNATURE_SCHEME_V31_BLOCK_ID);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L18
        r13.add(31);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L18
        if (r3.verified == false) goto L16;
        Result.access$000(r10, r3);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L18
        r11.put(31, getApkContentDigestsFromSigningSchemeResult(r3));     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L18
    L67:
        goto L20
    L16:
        System.err.println("(--NOTE--)V3SchemeVerifier failed");     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L18
    L18:
        r13.contains(31);
    L20:
        if (r9 >= 28) goto L71;
    L31:
        if (r8 > 28) goto L33;
    L73:
        ApkSigningBlockUtils.Result r4 = V2SchemeVerifier.verify(r17, r7, r12, r13, Math.max(r8, 24), r9);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L64
        r13.add(2);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L64
        if (r4.verified == false) goto L37;
        Result.access$000(r10, r4);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L64
        r11.put(2, getApkContentDigestsFromSigningSchemeResult(r4));     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L64
        goto L39
    L37:
        System.err.println("(--NOTE--)V2SchemeVerifier failed");     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L64
    L39:
        if (r10.containsErrors() == false) goto L41;
        return r10;
    L41:
        List<CentralDirectoryRecord> r14 = V1SchemeVerifier.parseZipCentralDirectory(r17, r7);
        if (r11.isEmpty() == false) goto L47;
        V1SchemeVerifier.Result r5 = V1SchemeVerifier.verify(r17, r7, r12, r13, r8, r9);
        if (r5.verified == false) goto L46;
        Result.access$100(r10, r5);
        r11.put(1, getApkContentDigestFromV1SigningScheme(r14, r17, r7));
        goto L47
    L46:
        System.err.println("(--NOTE--)V1SchemeVerifier failed");
        goto L47
    L33:
        if (r13.isEmpty() == false) goto L41;
    L71:
        ApkSigningBlockUtils.Result r6 = V3SchemeVerifier.verify(r17, r7, 3, V3SchemeConstants.APK_SIGNATURE_SCHEME_V3_BLOCK_ID);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L27
        r13.add(3);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L27
        if (r6.verified == false) goto L25;
        Result.access$000(r10, r6);     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L27
        r11.put(3, getApkContentDigestsFromSigningSchemeResult(r6));     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L27
    L70:
    L29:
        if (r10.containsErrors() == false) goto L31;
        return r10;
    L25:
        System.err.println("(--NOTE--)V3SchemeVerifier failed");     // Catch: ApkSigningBlockUtils.SignatureNotFoundException -> L27
    L27:
        r13.contains(31);
    L47:
        Result.access$200(r10);
        if (r10.isVerifiedUsingV31Scheme() == false) goto L50;
        List<Result.V3SchemeSignerInfo> r15 = r10.getV31SchemeSigners();
        int r16 = 1;
        Result.access$300(r10, r15.get(r15.size() - 1).getCertificate());
    L52:
        if (r10.isVerifiedUsingV3Scheme() == false) goto L55;
        List<Result.V3SchemeSignerInfo> r18 = r10.getV3SchemeSigners();
        Result.access$300(r10, r18.get(r18.size() - r16).getCertificate());
    L55:
        if (r10.isVerifiedUsingV2Scheme() == false) goto L60;
        Iterator<Result.V2SchemeSignerInfo> r19 = r10.getV2SchemeSigners().iterator();
    L58:
        if (r19.hasNext() == false) goto L60;
        Result.access$300(r10, r19.next().getCertificate());
    L60:
        return r10;
    L50:
        r16 = 1;
        goto L52
    L7:
        r9 = 33;
        r8 = 24;
    L61:
        e = move-exception;
        throw new ApkFormatException("Malformed APK: not a ZIP archive", e);
    }
}
