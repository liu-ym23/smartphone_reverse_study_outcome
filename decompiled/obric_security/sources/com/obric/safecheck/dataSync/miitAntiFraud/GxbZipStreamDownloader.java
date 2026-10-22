package com.obric.safecheck.dataSync.miitAntiFraud;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.matrix.sdk.network.OceanHttpUtil;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import io.reactivex.Observable;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: GxbZipStreamDownloader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbZipStreamDownloader;", "", "()V", "TAG", "", "download", "", "downloadUrl", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbZipStreamDownloader$StreamCallback;", "parseZipStream", "inputStream", "Ljava/io/InputStream;", "DownloadApi", "NonClosingInputStream", "StreamCallback", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbZipStreamDownloader {
    public static final GxbZipStreamDownloader INSTANCE = null;
    private static final String TAG = "GxbZipStreamDownloader";

    /* JADX INFO: compiled from: GxbZipStreamDownloader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H'¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbZipStreamDownloader$DownloadApi;", "", "downloadFile", "Lio/reactivex/Observable;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "appId", "", "pemCertChain", "url", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private interface DownloadApi {
        @GET
        @Streaming
        Observable<TypedInput> downloadFile(@Header(GxbAttestationHeaders.HEADER_APP_ID) String r1, @Header(GxbAttestationHeaders.HEADER_CERT_CHAIN) String r2, @Url String r3);
    }

    /* JADX INFO: compiled from: GxbZipStreamDownloader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbZipStreamDownloader$NonClosingInputStream;", "Ljava/io/InputStream;", "delegate", "(Ljava/io/InputStream;)V", "available", "", "close", "", ProviderConstants.Sms.READ, "b", "", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class NonClosingInputStream extends InputStream {
        private final InputStream delegate;

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public NonClosingInputStream(InputStream r2) {
            Intrinsics.checkNotNullParameter(r2, "delegate");
            this.delegate = r2;
        }

        @Override // java.io.InputStream
        public int read() {
            return this.delegate.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "b");
            return this.delegate.read(r2, r3, r4);
        }

        @Override // java.io.InputStream
        public int available() {
            return this.delegate.available();
        }
    }

    /* JADX INFO: compiled from: GxbZipStreamDownloader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbZipStreamDownloader$StreamCallback;", "", "onComplete", "", "entryCount", "", "onEntry", "entry", "Ljava/util/zip/ZipEntry;", "entryStream", "Ljava/io/InputStream;", "onFailure", AlogMonitor.ALOG_RESULT_CODE, "message", "", "throwable", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public interface StreamCallback {
        void onComplete(int r1);

        void onEntry(ZipEntry r1, InputStream r2);

        void onFailure(int r1, String r2, Throwable r3);
    }

    static {
        INSTANCE = new GxbZipStreamDownloader();
    }

    private GxbZipStreamDownloader() {
    }

    public static final /* synthetic */ void access$parseZipStream(GxbZipStreamDownloader r0, InputStream r1, StreamCallback r2) {
        r0.parseZipStream(r1, r2);
    }

    @JvmStatic
    public static final void download(final String r5, final StreamCallback r6) {
        Intrinsics.checkNotNullParameter(r5, "downloadUrl");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (StringsKt.isBlank(r5) == false) goto L12;
        r6.onFailure(-1, "downloadUrl is blank", null);
        return;
    L12:
        MessageLoop.disableVaildThreadAssert(true);     // Catch: Throwable -> L9
        ((DownloadApi) OceanHttpUtil.INSTANCE.createDownloadService(DownloadApi.class)).downloadFile(GxbAttestationHeaders.INSTANCE.appId(), GxbAttestationHeaders.INSTANCE.getPemCertChain(TAG), r5).subscribeOn(HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER()).observeOn(HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER()).subscribe(new AnonymousClass1(r6, r5), new AnonymousClass2(r5, r6));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        OLog.e(TAG, "download zip failed, url is " + r5, th);
        r6.onFailure(-1, th.getMessage(), th);
    }

    private final void parseZipStream(InputStream r14, StreamCallback r15) {
        BufferedInputStream r0 = new BufferedInputStream(r14);
        ZipInputStream r1 = new ZipInputStream(r0);     // Catch: Throwable -> L27
        ZipInputStream r16 = r1;     // Catch: Throwable -> L22
        NonClosingInputStream r2 = new NonClosingInputStream(r16);     // Catch: Throwable -> L22
        ZipEntry r3 = r16.getNextEntry();     // Catch: Throwable -> L22
        int r4 = 0;
    L6:
        if (r3 == null) goto L18;
        if (r3.isDirectory() == true) goto L17;
        OLog.d(TAG, "zip entry, index is " + r4 + ", name is " + r3.getName() + ", size is " + r3.getSize() + ", compressedSize is " + r3.getCompressedSize());     // Catch: Throwable -> L22
        r15.onEntry(r3, r2);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        OLog.e(TAG, "consume zip entry failed, name is " + r3.getName(), th);     // Catch: Throwable -> L22
        r15.onFailure(-1, th.getMessage(), th);     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r0, null);
        return;
    L17:
        r16.closeEntry();     // Catch: Throwable -> L22
        r3 = r16.getNextEntry();     // Catch: Throwable -> L22
        r4 = r4 + 1;     // Catch: Throwable -> L22
        goto L6
    L18:
        r15.onComplete(r4);     // Catch: Throwable -> L22
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L27
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r0, null);
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }
}
