package com.obric.safecheck.dataSync;

import android.content.Context;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.matrix.sdk.network.HttpRequestManager;
import com.obric.matrix.sdk.network.OceanHttpUtil;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.httpclient.OkHttpUtils;
import com.obric.safecheck.dataSync.model.AntiFraudModel;
import com.ttnet.org.chromium.net.urlconnection.MessageLoop;
import io.reactivex.Observable;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class ZipJsonParser {
    private static final String TAG = "ZipJsonParser_AntiFraud";
    private static final int THREAD_POOL_SIZE = 3;
    private final ExecutorService executorService;
    private final Map<String, Future<?>> futureMap;
    private final OkHttpClient okHttpClient;

    private interface DownloadApi {
        @GET
        @Streaming
        Observable<TypedInput> downloadFile(@Url String url);
    }

    private static class SingletonHolder {
        private static final ZipJsonParser INSTANCE = null;

        /* JADX INFO: renamed from: -$$Nest$sfgetINSTANCE, reason: not valid java name */
        static /* bridge */ /* synthetic */ ZipJsonParser m599$$Nest$sfgetINSTANCE() {
            return INSTANCE;
        }

        private SingletonHolder() {
        }

        static {
            INSTANCE = new ZipJsonParser(null);
        }
    }

    /* synthetic */ ZipJsonParser(ZipJsonParserIA r1) {
        this();
    }

    private ZipJsonParser() {
        this.okHttpClient = OkHttpUtils.getInstance();
        this.futureMap = new ConcurrentHashMap();
        this.executorService = Executors.newFixedThreadPool(3, new ZipJsonParser$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ Thread lambda$new$0(Runnable r3) {
        Thread r0 = new Thread(r3);
        r0.setName("ZipJsonParser-Thread-" + r0.getId());
        r0.setDaemon(true);
        return r0;
    }

    public static ZipJsonParser getInstance() {
        return SingletonHolder.m599$$Nest$sfgetINSTANCE();
    }

    public void parseZipJsonArray(Context context, List<AntiFraudModel.AntiFraudFile> zipUrls, final DownloadParseCallback callback) {
        List<AntiFraudModel.AntiFraudFile> r1 = zipUrls;
        if (r1 != null) goto L5;
    L30:
        callback.onAllCompleted();
        return;
    L5:
        if (zipUrls.isEmpty() == true) goto L30;
        final int r13 = zipUrls.size();
        boolean r15 = false;
        final AtomicInteger r14 = new AtomicInteger(0);
        final int r10 = 0;
    L9:
        if (r10 >= zipUrls.size()) goto L29;
        final String r9 = r1.get(r10).downloadURL;
        final String r8 = r1.get(r10).startDay;
        final String r0 = r1.get(r10).endDay;
        final AtomicBoolean r7 = new AtomicBoolean(r15);
        MessageLoop.disableVaildThreadAssert(true);     // Catch: Exception -> L21
        Observable<TypedInput> r2 = ((DownloadApi) OceanHttpUtil.INSTANCE.createDownloadService(DownloadApi.class)).downloadFile(r9);     // Catch: Exception -> L21
        OLog.d(TAG, "开始请求: " + r9);     // Catch: Exception -> L21
        callback.onStartNextTask(r10, r9);     // Catch: Exception -> L21
        final String r16 = r9;
        final int r17 = r10;
        final AtomicBoolean r3 = r7;
        r2.subscribeOn(HttpRequestManager.INSTANCE.getDEFAULT_SUBSCRIBE_SCHEDULER()).observeOn(HttpRequestManager.INSTANCE.getDEFAULT_OBSERVE_SCHEDULER()).subscribe(new ZipJsonParser$$ExternalSyntheticLambda0(callback, r9, r7, r14, r13, r8, r0, r10), new ZipJsonParser$$ExternalSyntheticLambda1(callback, r17, r16, r7, r14, r13), new ZipJsonParser$$ExternalSyntheticLambda2(r3, r14, r13, callback));     // Catch: Exception -> L17
        int r18 = r17;
        boolean r4 = false;
    L28:
        r10 = r18 + 1;
        r1 = zipUrls;
        r15 = r4;
    L17:
        e = e;
    L23:
        OLog.e(TAG, e.getMessage());
        r18 = r17;
        callback.onFailure(r18, r16, e);
        r4 = false;
        if (r3.compareAndSet(false, true) == false) goto L28;
        if (r14.incrementAndGet() != r13) goto L28;
        callback.onAllCompleted();
    L19:
        e = e;
        r3 = r7;
    L21:
        e = e;
        r3 = r7;
        r16 = r9;
        r17 = r10;
        goto L23
    }

    static /* synthetic */ void lambda$parseZipJsonArray$1(DownloadParseCallback r12, String r13, AtomicBoolean r14, AtomicInteger r15, int r16, String r17, String r18, int r19, TypedInput r20) throws Exception {
        InputStream r6 = r20.in();     // Catch: Throwable -> L59
        BufferedInputStream r7 = new BufferedInputStream(r6);     // Catch: Throwable -> L50
        ZipInputStream r8 = new ZipInputStream(r7);     // Catch: Throwable -> L42
        ZipEntry r9 = r8.getNextEntry();     // Catch: Throwable -> L34
        if (r9 != null) goto L9;
    L24:
        r12.onSuccess(r13);     // Catch: Throwable -> L34
        if (r14.compareAndSet(false, true) == true) goto L27;
    L29:
        r8.close();     // Catch: Throwable -> L42
        r7.close();     // Catch: Throwable -> L50
        if (r6 == null) goto L78;
        r6.close();     // Catch: Throwable -> L59
        return;
    L78:
        return;
    L27:
        if (r15.incrementAndGet() != r16) goto L29;
        r12.onAllCompleted();     // Catch: Throwable -> L34
        goto L29
    L9:
        if (r9.isDirectory() == true) goto L24;
        if (r9.getName().endsWith(".json") == false) goto L24;
        OLog.d(TAG, "找到 JSON 文件: " + r9.getName());     // Catch: Throwable -> L34
        new JsonStreamParser().parse(r8, r17, r18, r12);     // Catch: Throwable -> L34
        r12.onSuccess(r13);     // Catch: Throwable -> L34
        r8.close();     // Catch: Throwable -> L42
        r7.close();     // Catch: Throwable -> L50
        if (r6 == null) goto L19;
        r6.close();     // Catch: Throwable -> L59
    L19:
        if (r14.compareAndSet(false, true) == true) goto L21;
        return;
    L21:
        if (r15.incrementAndGet() != r16) goto L77;
        r12.onAllCompleted();
        return;
    L77:
        return;
    L34:
        th = move-exception;
        r8.close();     // Catch: Throwable -> L38
    L79:
        throw th;     // Catch: Throwable -> L42
    L38:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        r7.close();     // Catch: Throwable -> L46
    L80:
        throw th;     // Catch: Throwable -> L50
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        if (r6 == null) goto L81;
        r6.close();     // Catch: Throwable -> L55
    L82:
        throw th;     // Catch: Throwable -> L59
    L55:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L59
        throw th;     // Catch: Throwable -> L59
    L81:
        throw th;     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        r12.onFailure(r19, r13, th);
        if (r14.compareAndSet(false, true) == true) goto L63;
        return;
    L63:
        if (r15.incrementAndGet() != r16) goto L84;
        r12.onAllCompleted();
        return;
    }

    static /* synthetic */ void lambda$parseZipJsonArray$2(DownloadParseCallback r0, int r1, String r2, AtomicBoolean r3, AtomicInteger r4, int r5, Throwable r6) throws Exception {
        r0.onFailure(r1, r2, r6);
        if (r3.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r4.incrementAndGet() != r5) goto L9;
        r0.onAllCompleted();
        return;
    }

    static /* synthetic */ void lambda$parseZipJsonArray$3(AtomicBoolean r2, AtomicInteger r3, int r4, DownloadParseCallback r5) throws Exception {
        if (r2.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r3.incrementAndGet() != r4) goto L9;
        r5.onAllCompleted();
        return;
    }

    public void parseZipJson(Context context, String zipUrl, String startTime, String endTime, DownloadParseCallback callback) throws IOException {
        OLog.d(TAG, "开始请求: " + zipUrl);
        Response r6 = this.okHttpClient.newCall(new Request.Builder().url(zipUrl).build()).execute();
    L51:
        th = move-exception;
        if (r6 != null) goto L65;
    L57:
        throw th;
    L65:
        r6.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.addSuppressed(th);
        goto L57
    L4:
        if (r6.isSuccessful() == false) goto L50;
        InputStream r8 = r6.body().byteStream();     // Catch: Throwable -> L51
        BufferedInputStream r0 = new BufferedInputStream(r8);     // Catch: Throwable -> L42
        ZipInputStream r1 = new ZipInputStream(r0);     // Catch: Throwable -> L36
        ZipEntry r3 = r1.getNextEntry();     // Catch: Throwable -> L30
        if (r3 != null) goto L11;
    L23:
        r1.close();     // Catch: Throwable -> L36
        r0.close();     // Catch: Throwable -> L42
        if (r8 == null) goto L27;
        r8.close();     // Catch: Throwable -> L51
    L27:
        if (r6 == null) goto L72;
        r6.close();
        return;
    L72:
        return;
    L11:
        if (r3.isDirectory() == true) goto L23;
        if (r3.getName().endsWith(".json") == false) goto L23;
        OLog.d(TAG, "找到 JSON 文件: " + r3.getName());     // Catch: Throwable -> L30
        new JsonStreamParser().parse(r1, startTime, endTime, callback);     // Catch: Throwable -> L30
        r1.close();     // Catch: Throwable -> L36
        r0.close();     // Catch: Throwable -> L42
        if (r8 == null) goto L20;
        r8.close();     // Catch: Throwable -> L51
    L20:
        if (r6 == null) goto L71;
        r6.close();
        return;
    L71:
        return;
    L30:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Throwable -> L36
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L39
    L41:
        throw th;     // Catch: Throwable -> L42
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r8 != null) goto L63;
    L48:
        throw th;     // Catch: Throwable -> L51
    L63:
        r8.close();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L51
        goto L48
    L50:
        throw new IOException("HTTP 请求失败: " + r6.code() + " " + r6.message());     // Catch: Throwable -> L51
    }

    public void cancel() {
        OLog.d(TAG, "取消所有任务...");
        Map<String, Future<?>> r0 = this.futureMap;
        monitor-enter(r0);
        Iterator<Future<?>> r1 = this.futureMap.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        r1.next().cancel(true);     // Catch: Throwable -> L11
        goto L6
    L8:
        this.futureMap.clear();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void release() {
        OLog.d(TAG, "释放资源...");
        cancel();
        this.executorService.shutdown();
    }
}
