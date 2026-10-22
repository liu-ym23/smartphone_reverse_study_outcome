package com.android.apksig.internal.apk.v1;

import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.ApkFormatException;
import com.android.apksig.apk.ApkUtils;
import com.android.apksig.internal.asn1.Asn1BerParser;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.asn1.Asn1Type;
import com.android.apksig.internal.pkcs7.ContentInfo;
import com.android.apksig.internal.pkcs7.Pkcs7Constants;
import com.android.apksig.internal.pkcs7.SignedData;
import com.android.apksig.internal.pkcs7.SignerInfo;
import com.android.apksig.internal.x509.Certificate;
import com.android.apksig.internal.zip.CentralDirectoryRecord;
import com.android.apksig.internal.zip.LocalFileRecord;
import com.android.apksig.internal.zip.ZipUtils;
import com.android.apksig.util.DataSource;
import com.android.apksig.zip.ZipFormatException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class V1SchemeVerifier {
    private static final String[] JB_MR2_AND_NEWER_DIGEST_ALGS = null;
    private static final Map<String, Integer> MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST = null;
    private static final Map<String, String> UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL = null;

    /* JADX INFO: renamed from: com.android.apksig.internal.apk.v1.V1SchemeVerifier$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class NamedDigest {
        public final byte[] digest;
        public final String jcaDigestAlgorithm;

        private NamedDigest(String r1, byte[] r2) {
            this.jcaDigestAlgorithm = r1;
            this.digest = r2;
        }
    }

    @Asn1Class(type = Asn1Type.CHOICE)
    public static class ObjectIdentifierChoice {

        @Asn1Field(type = Asn1Type.OBJECT_IDENTIFIER)
        public String value;

        public ObjectIdentifierChoice() {
        }
    }

    @Asn1Class(type = Asn1Type.CHOICE)
    public static class OctetStringChoice {

        @Asn1Field(type = Asn1Type.OCTET_STRING)
        public byte[] value;

        public OctetStringChoice() {
        }
    }

    public static class Result {
        public final List<SignerInfo> ignoredSigners;
        private final List<ApkVerifier.IssueWithParams> mErrors;
        private final List<ApkVerifier.IssueWithParams> mWarnings;
        public final List<SignerInfo> signers;
        public boolean verified;

        public static class SignerInfo {
            public final List<X509Certificate> certChain;
            private final List<ApkVerifier.IssueWithParams> mErrors;
            private final List<ApkVerifier.IssueWithParams> mWarnings;
            public final String name;
            public final String signatureBlockFileName;
            public final String signatureFileName;

            /* synthetic */ SignerInfo(String r1, String r2, String r3, AnonymousClass1 r4) {
                this(r1, r2, r3);
            }

            static /* synthetic */ boolean access$600(SignerInfo r0) {
                return r0.containsErrors();
            }

            static /* synthetic */ void access$700(SignerInfo r0, ApkVerifier.Issue r1, Object[] r2) {
                r0.addError(r1, r2);
            }

            private void addError(ApkVerifier.Issue r2, Object... r3) {
                this.mErrors.add(new ApkVerifier.IssueWithParams(r2, r3));
            }

            private void addWarning(ApkVerifier.Issue r2, Object... r3) {
                this.mWarnings.add(new ApkVerifier.IssueWithParams(r2, r3));
            }

            private boolean containsErrors() {
                return !this.mErrors.isEmpty();
            }

            public List<ApkVerifier.IssueWithParams> getErrors() {
                return this.mErrors;
            }

            public List<ApkVerifier.IssueWithParams> getWarnings() {
                return this.mWarnings;
            }

            private SignerInfo(String r2, String r3, String r4) {
                this.certChain = new ArrayList();
                this.mWarnings = new ArrayList();
                this.mErrors = new ArrayList();
                this.name = r2;
                this.signatureBlockFileName = r3;
                this.signatureFileName = r4;
            }
        }

        public Result() {
            this.signers = new ArrayList();
            this.ignoredSigners = new ArrayList();
            this.mWarnings = new ArrayList();
            this.mErrors = new ArrayList();
        }

        static /* synthetic */ boolean access$000(Result r0) {
            return r0.containsErrors();
        }

        static /* synthetic */ void access$200(Result r0, ApkVerifier.Issue r1, Object[] r2) {
            r0.addError(r1, r2);
        }

        static /* synthetic */ void access$300(Result r0, ApkVerifier.Issue r1, Object[] r2) {
            r0.addWarning(r1, r2);
        }

        private void addError(ApkVerifier.Issue r2, Object... r3) {
            this.mErrors.add(new ApkVerifier.IssueWithParams(r2, r3));
        }

        private void addWarning(ApkVerifier.Issue r2, Object... r3) {
            this.mWarnings.add(new ApkVerifier.IssueWithParams(r2, r3));
        }

        private boolean containsErrors() {
            if (this.mErrors.isEmpty() == true) goto L5;
            return true;
        L5:
            Iterator<SignerInfo> r2 = this.signers.iterator();
        L7:
            if (r2.hasNext() == false) goto L11;
            if (SignerInfo.access$600(r2.next()) == false) goto L7;
            return true;
        L11:
            return false;
        }

        public List<ApkVerifier.IssueWithParams> getErrors() {
            return this.mErrors;
        }

        public List<ApkVerifier.IssueWithParams> getWarnings() {
            return this.mWarnings;
        }
    }

    static class Signer {
        private boolean mIgnored;
        private final String mName;
        private final Result.SignerInfo mResult;
        private byte[] mSigFileBytes;
        private Set<String> mSigFileEntryNames;
        private final CentralDirectoryRecord mSignatureBlockEntry;
        private final CentralDirectoryRecord mSignatureFileEntry;

        /* synthetic */ Signer(String r1, CentralDirectoryRecord r2, CentralDirectoryRecord r3, Result.SignerInfo r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        public static List<X509Certificate> getCertificateChain(List<X509Certificate> r7, X509Certificate r8) {
            ArrayList r0 = new ArrayList(r7);
            ArrayList r9 = new ArrayList(1);
            r9.add(r8);
            r0.remove(r8);
        L4:
            if (r8.getSubjectDN().equals(r8.getIssuerDN()) == true) goto L13;
            Principal r2 = r8.getIssuerDN();
            boolean r3 = false;
            int r4 = 0;
        L7:
            if (r4 >= r0.size()) goto L12;
            X509Certificate r5 = (X509Certificate) r0.get(r4);
            if (r2.equals(r5.getSubjectDN()) == true) goto L10;
            r4 = r4 + 1;
            goto L7
        L10:
            r0.remove(r4);
            r9.add(r5);
            r3 = true;
            r8 = r5;
        L12:
            if (r3 == true) goto L4;
        L13:
            return r9;
        }

        public String getName() {
            return this.mName;
        }

        public Result.SignerInfo getResult() {
            return this.mResult;
        }

        public Set<String> getSigFileEntryNames() {
            return this.mSigFileEntryNames;
        }

        public String getSignatureBlockEntryName() {
            return this.mSignatureBlockEntry.getName();
        }

        public String getSignatureFileEntryName() {
            return this.mSignatureFileEntry.getName();
        }

        public boolean isIgnored() {
            return this.mIgnored;
        }

        void setIgnored() {
            this.mIgnored = true;
        }

        public void verifySigBlockAgainstSigFile(DataSource r7, long r8, int r10, int r11) throws IOException, ApkFormatException, NoSuchAlgorithmException {
            byte[] r1 = LocalFileRecord.getUncompressedData(r7, this.mSignatureBlockEntry, r8);     // Catch: ZipFormatException -> L52
            this.mSigFileBytes = LocalFileRecord.getUncompressedData(r7, this.mSignatureFileEntry, r8);     // Catch: ZipFormatException -> L49
            ContentInfo r12 = (ContentInfo) Asn1BerParser.parse(ByteBuffer.wrap(r1), ContentInfo.class);     // Catch: Asn1DecodingException -> L46
            if (Pkcs7Constants.OID_SIGNED_DATA.equals(r12.contentType) == false) goto L45;
            SignedData r13 = (SignedData) Asn1BerParser.parse(r12.content.getEncoded(), SignedData.class);     // Catch: Asn1DecodingException -> L46
            if (r13.signerInfos.isEmpty() == false) goto L14;
            Result.SignerInfo.access$700(this.mResult, ApkVerifier.Issue.JAR_SIG_NO_SIGNERS, new Object[]{this.mSignatureBlockEntry.getName()});
            return;
        L14:
            if (r10 >= 24) goto L16;
            List<SignerInfo> r14 = Collections.singletonList(r13.signerInfos.get(0));
        L17:
            Iterator<SignerInfo> r15 = r14.iterator();
            SignerInfo r0 = null;
            List<X509Certificate> r2 = null;
            X509Certificate r3 = null;
        L19:
            if (r15.hasNext() == false) goto L39;
            SignerInfo r4 = r15.next();
            if (r2 != null) goto L62;
            r2 = Certificate.parseCertificates(r13.certificates);     // Catch: CertificateException -> L24
        L24:
            e = move-exception;
            Result.SignerInfo.access$700(this.mResult, ApkVerifier.Issue.JAR_SIG_PARSE_EXCEPTION, new Object[]{this.mSignatureBlockEntry.getName(), e});
            return;
        L62:
            X509Certificate r5 = Certificate.findCertificate(r2, r4.sid);     // Catch: SignatureException -> L36
            if (r5 == null) goto L35;
            if (Result.SignerInfo.access$600(this.mResult) == true) goto L31;
            if (r0 != null) goto L19;
            r0 = r4;
            r3 = r5;
            goto L19
        L31:
            return;
        L35:
            throw new SignatureException("Signing certificate referenced in SignerInfo not found in SignedData");     // Catch: SignatureException -> L36
        L36:
            e = move-exception;
            Result.SignerInfo.access$700(this.mResult, ApkVerifier.Issue.JAR_SIG_VERIFY_EXCEPTION, new Object[]{this.mSignatureBlockEntry.getName(), this.mSignatureFileEntry.getName(), e});
            return;
        L39:
            if (r0 != null) goto L42;
            Result.SignerInfo.access$700(this.mResult, ApkVerifier.Issue.JAR_SIG_DID_NOT_VERIFY, new Object[]{this.mSignatureBlockEntry.getName(), this.mSignatureFileEntry.getName()});
            return;
        L42:
            List<X509Certificate> r9 = getCertificateChain(r2, r3);
            this.mResult.certChain.clear();
            this.mResult.certChain.addAll(r9);
            return;
        L16:
            r14 = r13.signerInfos;
            goto L17
        L45:
            throw new Asn1DecodingException("Unsupported ContentInfo.contentType: " + r12.contentType);     // Catch: Asn1DecodingException -> L46
        L46:
            e = move-exception;
            e.printStackTrace();
            Result.SignerInfo.access$700(this.mResult, ApkVerifier.Issue.JAR_SIG_PARSE_EXCEPTION, new Object[]{this.mSignatureBlockEntry.getName(), e});
            return;
        L49:
            e = move-exception;
            throw new ApkFormatException("Malformed ZIP entry: " + this.mSignatureFileEntry.getName(), e);
        L52:
            e = move-exception;
            throw new ApkFormatException("Malformed ZIP entry: " + this.mSignatureBlockEntry.getName(), e);
        }

        private Signer(String r1, CentralDirectoryRecord r2, CentralDirectoryRecord r3, Result.SignerInfo r4) {
            this.mName = r1;
            this.mResult = r4;
            this.mSignatureBlockEntry = r2;
            this.mSignatureFileEntry = r3;
        }
    }

    private static class Signers {
        private Signers() {
        }

        static /* synthetic */ void access$100(DataSource r0, long r1, List r3, Set r4, Map r5, Set r6, int r7, int r8, Result r9) throws ApkFormatException, IOException, NoSuchAlgorithmException {
            verify(r0, r1, r3, r4, r5, r6, r7, r8, r9);
        }

        private static void verify(DataSource r15, long r16, List<CentralDirectoryRecord> r18, Set<String> r19, Map<Integer, String> r20, Set<Integer> r21, int r22, int r23, Result r24) throws ApkFormatException, IOException, NoSuchAlgorithmException {
            HashMap r1 = new HashMap(1);
            ArrayList r3 = new ArrayList(1);
            Iterator<CentralDirectoryRecord> r4 = r18.iterator();
            AnonymousClass1 r5 = null;
            CentralDirectoryRecord r6 = null;
        L4:
            if (r4.hasNext() == false) goto L23;
            CentralDirectoryRecord r7 = r4.next();
            String r9 = r7.getName();
            if (r9.startsWith("META-INF/") == false) goto L4;
            if (r6 != null) goto L13;
            if (V1SchemeConstants.MANIFEST_ENTRY_NAME.equals(r9) == false) goto L13;
            r6 = r7;
        L13:
            if (r9.endsWith(".SF") == true) goto L14;
            if (r9.endsWith(".RSA") == true) goto L21;
            if (r9.endsWith(".DSA") == true) goto L21;
            if (r9.endsWith(".EC") == false) goto L4;
        L21:
            r3.add(r7);
            goto L4
        L14:
            r1.put(r9, r7);
            goto L4
        L23:
            if (r6 != null) goto L26;
            Result.access$200(r24, ApkVerifier.Issue.JAR_SIG_NO_MANIFEST, new Object[0]);
            return;
        L26:
            ArrayList r8 = new ArrayList(r3.size());
            Iterator r10 = r3.iterator();
        L28:
            if (r10.hasNext() == false) goto L38;
            CentralDirectoryRecord r11 = (CentralDirectoryRecord) r10.next();
            String r12 = r11.getName();
            int r13 = r12.lastIndexOf(46);
            if (r13 == (-1)) goto L36;
            String r14 = r12.substring(0, r13) + ".SF";
            CentralDirectoryRecord r17 = (CentralDirectoryRecord) r1.get(r14);
            if (r17 == null) goto L33;
            String r110 = r12.substring(9);
            r8.add(new Signer(r110, r11, r17, new Result.SignerInfo(r110, r12, r17.getName(), r5), null));
            goto L28
        L33:
            Result.access$300(r24, ApkVerifier.Issue.JAR_SIG_MISSING_FILE, new Object[]{r12, r14});
            goto L28
        L36:
            throw new RuntimeException("Signature block file name does not contain extension: " + r12);
        L38:
            if (r8.isEmpty() == false) goto L41;
            Result.access$200(r24, ApkVerifier.Issue.JAR_SIG_NO_SIGNATURES, new Object[0]);
            return;
        L41:
            Iterator r2 = r8.iterator();
        L43:
            if (r2.hasNext() == false) goto L48;
            Signer r25 = (Signer) r2.next();
            r25.verifySigBlockAgainstSigFile(r15, r16, r22, r23);
            if (Result.SignerInfo.access$600(r25.getResult()) == true) goto L43;
            r24.signers.add(r25.getResult());
            goto L43
        L48:
            if (Result.access$000(r24) == false) goto L50;
            return;
        L50:
            r24.verified = true;
        }
    }

    static {
        JB_MR2_AND_NEWER_DIGEST_ALGS = new String[]{"SHA-512", "SHA-384", "SHA-256", "SHA-1"};
        HashMap r4 = new HashMap(8);
        UPPER_CASE_JCA_DIGEST_ALG_TO_CANONICAL = r4;
        r4.put("MD5", "MD5");
        r4.put("SHA", "SHA-1");
        r4.put("SHA1", "SHA-1");
        r4.put("SHA-1", "SHA-1");
        r4.put("SHA-256", "SHA-256");
        r4.put("SHA-384", "SHA-384");
        r4.put("SHA-512", "SHA-512");
        HashMap r5 = new HashMap(5);
        MIN_SDK_VESION_FROM_WHICH_DIGEST_SUPPORTED_IN_MANIFEST = r5;
        r5.put("MD5", 0);
        r5.put("SHA-1", 0);
        r5.put("SHA-256", 0);
        r5.put("SHA-384", 9);
        r5.put("SHA-512", 9);
    }

    private V1SchemeVerifier() {
    }

    private static Set<String> checkForDuplicateEntries(List<CentralDirectoryRecord> r6, Result r7) {
        HashSet r0 = new HashSet(r6.size());
        Iterator<CentralDirectoryRecord> r8 = r6.iterator();
        HashSet r1 = null;
    L4:
        if (r8.hasNext() == false) goto L12;
        String r2 = r8.next().getName();
        if (r0.add(r2) == true) goto L4;
        if (r1 != null) goto L10;
        r1 = new HashSet();
    L10:
        if (r1.add(r2) == false) goto L4;
        Result.access$200(r7, ApkVerifier.Issue.JAR_SIG_DUPLICATE_ZIP_ENTRY, new Object[]{r2});
        goto L4
    L12:
        return r0;
    }

    private static MessageDigest getMessageDigest(String r0) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(r0);
    }

    public static List<CentralDirectoryRecord> parseZipCentralDirectory(DataSource r0, ApkUtils.ZipSections r1) throws IOException, ApkFormatException {
        return ZipUtils.parseZipCentralDirectory(r0, r1);
    }

    public static Result verify(DataSource r11, ApkUtils.ZipSections r12, Map<Integer, String> r13, Set<Integer> r14, int r15, int r16) throws IOException, ApkFormatException, NoSuchAlgorithmException {
        if (r15 > r16) goto L10;
        Result r10 = new Result();
        List<CentralDirectoryRecord> r3 = parseZipCentralDirectory(r11, r12);
        Set<String> r4 = checkForDuplicateEntries(r3, r10);
        if (Result.access$000(r10) == false) goto L7;
        return r10;
    L7:
        Signers.access$100(r11, r12.getZipCentralDirectoryOffset(), r3, r4, r13, r14, r15, r16, r10);
        return r10;
    L10:
        throw new IllegalArgumentException("minSdkVersion (" + r15 + ") > maxSdkVersion (" + r16 + ")");
    }
}
