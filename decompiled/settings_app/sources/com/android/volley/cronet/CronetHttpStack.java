package com.android.volley.cronet;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.settings.utils.HanziToPinyin;
import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import com.android.volley.RequestTask;
import com.android.volley.toolbox.AsyncHttpStack;
import com.android.volley.toolbox.ByteArrayPool;
import com.android.volley.toolbox.UrlRewriter;
import com.loopj.android.http.RequestParams;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.chromium.net.CronetEngine;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: loaded from: classes.dex */
public class CronetHttpStack extends AsyncHttpStack {
    private final CronetEngine mCronetEngine;
    private final CurlCommandLogger mCurlCommandLogger;
    private final boolean mCurlLoggingEnabled;
    private final boolean mLogAuthTokensInCurlCommands;
    private final ByteArrayPool mPool;
    private final RequestListener mRequestListener;
    private final UrlRewriter mUrlRewriter;

    /* JADX INFO: renamed from: com.android.volley.cronet.CronetHttpStack$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$android$volley$Request$Priority = null;

        static {
            int[] r0 = new int[Request.Priority.values().length];
            $SwitchMap$com$android$volley$Request$Priority = r0;
            r0[Request.Priority.LOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$android$volley$Request$Priority[Request.Priority.HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$volley$Request$Priority[Request.Priority.IMMEDIATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$volley$Request$Priority[Request.Priority.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class Builder {
        private static final int DEFAULT_POOL_SIZE = 4096;
        private final Context context;
        private CronetEngine mCronetEngine;
        private CurlCommandLogger mCurlCommandLogger;
        private boolean mCurlLoggingEnabled;
        private boolean mLogAuthTokensInCurlCommands;
        private ByteArrayPool mPool;
        private RequestListener mRequestListener;
        private UrlRewriter mUrlRewriter;

        public Builder(Context r1) {
            this.context = r1;
        }

        public Builder setCronetEngine(CronetEngine r1) {
            this.mCronetEngine = r1;
            return this;
        }

        public Builder setPool(ByteArrayPool r1) {
            this.mPool = r1;
            return this;
        }

        public Builder setUrlRewriter(UrlRewriter r1) {
            this.mUrlRewriter = r1;
            return this;
        }

        public Builder setRequestListener(RequestListener r1) {
            this.mRequestListener = r1;
            return this;
        }

        public Builder setCurlLoggingEnabled(boolean r1) {
            this.mCurlLoggingEnabled = r1;
            return this;
        }

        public Builder setCurlCommandLogger(CurlCommandLogger r1) {
            this.mCurlCommandLogger = r1;
            return this;
        }

        public Builder setLogAuthTokensInCurlCommands(boolean r1) {
            this.mLogAuthTokensInCurlCommands = r1;
            return this;
        }

        public CronetHttpStack build() {
            if (this.mCronetEngine != null) goto L6;
            this.mCronetEngine = new CronetEngine.Builder(this.context).build();
        L6:
            if (this.mUrlRewriter != null) goto L9;
            this.mUrlRewriter = new AnonymousClass1(this);
        L9:
            if (this.mRequestListener != null) goto L12;
            this.mRequestListener = new AnonymousClass2(this);
        L12:
            if (this.mPool != null) goto L15;
            this.mPool = new ByteArrayPool(4096);
        L15:
            if (this.mCurlCommandLogger != null) goto L18;
            this.mCurlCommandLogger = new AnonymousClass3(this);
        L18:
            return new CronetHttpStack(this.mCronetEngine, this.mPool, this.mUrlRewriter, this.mRequestListener, this.mCurlLoggingEnabled, this.mCurlCommandLogger, this.mLogAuthTokensInCurlCommands, null);
        }
    }

    public interface CurlCommandLogger {
        void logCurlCommand(String r1);
    }

    private static class CurlLoggedRequestParameters {
        private byte[] mBody;
        private final TreeMap<String, String> mHeaders;
        private String mHttpMethod;

        private CurlLoggedRequestParameters() {
            this.mHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }

        /* synthetic */ CurlLoggedRequestParameters(AnonymousClass1 r1) {
            this();
        }

        TreeMap<String, String> getHeaders() {
            return this.mHeaders;
        }

        void putAllHeaders(Map<String, String> r1) {
            this.mHeaders.putAll(r1);
        }

        String getHttpMethod() {
            return this.mHttpMethod;
        }

        void setHttpMethod(String r1) {
            this.mHttpMethod = r1;
        }

        byte[] getBody() {
            return this.mBody;
        }

        void setBody(String r2, byte[] r3) {
            this.mBody = r3;
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.mHeaders.containsKey("Content-Type") == true) goto L9;
            this.mHeaders.put("Content-Type", r2);
            return;
        }

        void applyToRequest(UrlRequest.Builder r4, ExecutorService r5) {
            Iterator<Map.Entry<String, String>> r0 = this.mHeaders.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<String, String> r1 = r0.next();
            r4.addHeader(r1.getKey(), r1.getValue());
            goto L4
        L6:
            r4.setHttpMethod(this.mHttpMethod);
            byte[] r3 = this.mBody;
            if (r3 == null) goto L11;
            r4.setUploadDataProvider(UploadDataProviders.create(r3), r5);
            return;
        }
    }

    public static abstract class RequestListener {
        private CronetHttpStack mStack;

        public void onRequestPrepared(Request<?> r1, UrlRequest.Builder r2) {
        }

        public RequestListener() {
        }

        void initialize(CronetHttpStack r1) {
            this.mStack = r1;
        }

        protected Executor getNonBlockingExecutor() {
            return CronetHttpStack.access$1100(this.mStack);
        }

        protected Executor getBlockingExecutor() {
            return CronetHttpStack.access$1200(this.mStack);
        }
    }

    private class SetUpRequestTask<T> extends RequestTask<T> {
        Map<String, String> additionalHeaders;
        UrlRequest.Builder builder;
        AsyncHttpStack.OnRequestComplete callback;
        Request<T> request;
        final /* synthetic */ CronetHttpStack this$0;
        String url;

        SetUpRequestTask(CronetHttpStack r1, Request<T> r2, String r3, UrlRequest.Builder r4, Map<String, String> r5, AsyncHttpStack.OnRequestComplete r6) {
            this.this$0 = r1;
            super(r2);
            this.url = r3;
            this.builder = r4;
            this.additionalHeaders = r5;
            this.callback = r6;
            this.request = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetHttpStack.access$200(this.this$0).onRequestPrepared(this.request, this.builder);     // Catch: AuthFailureError -> L7
            CurlLoggedRequestParameters r0 = new CurlLoggedRequestParameters(null);     // Catch: AuthFailureError -> L7
            CronetHttpStack.access$400(this.this$0, r0, this.request);     // Catch: AuthFailureError -> L7
            CronetHttpStack.access$500(this.this$0, r0, this.request, this.additionalHeaders);     // Catch: AuthFailureError -> L7
            r0.applyToRequest(this.builder, CronetHttpStack.access$600(this.this$0));     // Catch: AuthFailureError -> L7
            UrlRequest r1 = this.builder.build();     // Catch: AuthFailureError -> L7
            if (CronetHttpStack.access$700(this.this$0) == false) goto L5;
            CronetHttpStack.access$900(this.this$0).logCurlCommand(CronetHttpStack.access$800(this.this$0, this.url, r0));     // Catch: AuthFailureError -> L7
        L5:
            r1.start();     // Catch: AuthFailureError -> L7
            return;
        L7:
            e = move-exception;
            this.callback.onAuthError(e);
        }
    }

    /* synthetic */ CronetHttpStack(CronetEngine r1, ByteArrayPool r2, UrlRewriter r3, RequestListener r4, boolean r5, CurlCommandLogger r6, boolean r7, AnonymousClass1 r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

    static /* synthetic */ ByteArrayPool access$000(CronetHttpStack r0) {
        return r0.mPool;
    }

    static /* synthetic */ int access$100(CronetHttpStack r0, UrlResponseInfo r1) {
        return r0.getContentLength(r1);
    }

    static /* synthetic */ ExecutorService access$1100(CronetHttpStack r0) {
        return r0.getNonBlockingExecutor();
    }

    static /* synthetic */ ExecutorService access$1200(CronetHttpStack r0) {
        return r0.getBlockingExecutor();
    }

    static /* synthetic */ RequestListener access$200(CronetHttpStack r0) {
        return r0.mRequestListener;
    }

    static /* synthetic */ void access$400(CronetHttpStack r0, CurlLoggedRequestParameters r1, Request r2) throws AuthFailureError {
        r0.setHttpMethod(r1, r2);
    }

    static /* synthetic */ void access$500(CronetHttpStack r0, CurlLoggedRequestParameters r1, Request r2, Map r3) throws AuthFailureError {
        r0.setRequestHeaders(r1, r2, r3);
    }

    static /* synthetic */ ExecutorService access$600(CronetHttpStack r0) {
        return r0.getNonBlockingExecutor();
    }

    static /* synthetic */ boolean access$700(CronetHttpStack r0) {
        return r0.mCurlLoggingEnabled;
    }

    static /* synthetic */ String access$800(CronetHttpStack r0, String r1, CurlLoggedRequestParameters r2) {
        return r0.generateCurlCommand(r1, r2);
    }

    static /* synthetic */ CurlCommandLogger access$900(CronetHttpStack r0) {
        return r0.mCurlCommandLogger;
    }

    private CronetHttpStack(CronetEngine r1, ByteArrayPool r2, UrlRewriter r3, RequestListener r4, boolean r5, CurlCommandLogger r6, boolean r7) {
        this.mCronetEngine = r1;
        this.mPool = r2;
        this.mUrlRewriter = r3;
        this.mRequestListener = r4;
        this.mCurlLoggingEnabled = r5;
        this.mCurlCommandLogger = r6;
        this.mLogAuthTokensInCurlCommands = r7;
        r4.initialize(this);
    }

    @Override // com.android.volley.toolbox.AsyncHttpStack
    public void executeRequest(Request<?> r11, Map<String, String> r12, final AsyncHttpStack.OnRequestComplete r13) {
        if (getBlockingExecutor() == null) goto L13;
        if (getNonBlockingExecutor() == null) goto L13;
        UrlRequest.Callback r0 = new AnonymousClass1(this, r13);
        String r1 = r11.getUrl();
        String r6 = this.mUrlRewriter.rewriteUrl(r1);
        if (r6 != null) goto L10;
        r13.onError(new IOException("URL blocked by rewriter: " + r1));
        return;
    L10:
        getBlockingExecutor().execute(new SetUpRequestTask(this, r11, r6, this.mCronetEngine.newUrlRequestBuilder(r6, r0, getNonBlockingExecutor()).allowDirectExecutor().disableCache().setPriority(getPriority(r11)), r12, r13));
        return;
    L13:
        throw new IllegalStateException("Must set blocking and non-blocking executors");
    }

    public static List<Header> getHeaders(List<Map.Entry<String, String>> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L4
    L6:
        return r0;
    }

    private void setHttpMethod(CurlLoggedRequestParameters r4, Request<?> r5) throws AuthFailureError {
        switch(r5.getMethod()) {
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r4.setHttpMethod("PATCH");
        addBodyIfExists(r4, r5.getBodyContentType(), r5.getBody());
        return;
    L7:
        r4.setHttpMethod("TRACE");
        return;
    L8:
        r4.setHttpMethod("OPTIONS");
        return;
    L9:
        r4.setHttpMethod("HEAD");
        return;
    L10:
        r4.setHttpMethod("DELETE");
        return;
    L11:
        r4.setHttpMethod("PUT");
        addBodyIfExists(r4, r5.getBodyContentType(), r5.getBody());
        return;
    L12:
        r4.setHttpMethod("POST");
        addBodyIfExists(r4, r5.getBodyContentType(), r5.getBody());
        return;
    L13:
        r4.setHttpMethod("GET");
        return;
    L14:
        byte[] r0 = r5.getPostBody();
        if (r0 == null) goto L17;
        r4.setHttpMethod("POST");
        addBodyIfExists(r4, r5.getPostBodyContentType(), r0);
        return;
    L17:
        r4.setHttpMethod("GET");
        return;
    L5:
        throw new IllegalStateException("Unknown method type.");
    }

    private void setRequestHeaders(CurlLoggedRequestParameters r1, Request<?> r2, Map<String, String> r3) throws AuthFailureError {
        r1.putAllHeaders(r3);
        r1.putAllHeaders(r2.getHeaders());
    }

    private void addBodyIfExists(CurlLoggedRequestParameters r1, String r2, byte[] r3) {
        r1.setBody(r2, r3);
    }

    private int getPriority(Request<?> r2) {
        int r1 = AnonymousClass2.$SwitchMap$com$android$volley$Request$Priority[r2.getPriority().ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L6;
        return 4;
    L6:
        if (r1 == 3) goto L11;
        return 3;
    L11:
        return 4;
    L10:
        return 2;
    }

    private int getContentLength(UrlResponseInfo r1) {
        List r0 = (List) r1.getAllHeaders().get("Content-Length");
        if (r0 != null) goto L7;
        return 1024;
    L7:
        return Integer.parseInt((String) r0.get(0));
    }

    private String generateCurlCommand(String r6, CurlLoggedRequestParameters r7) {
        StringBuilder r0 = new StringBuilder("curl ");
        r0.append("-X ").append(r7.getHttpMethod()).append(HanziToPinyin.Token.SEPARATOR);
        Iterator<Map.Entry<String, String>> r1 = r7.getHeaders().entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r1.next();
        r0.append("--header \"").append(r2.getKey()).append(": ");
        if (this.mLogAuthTokensInCurlCommands == false) goto L8;
    L12:
        r0.append(r2.getValue());
    L13:
        r0.append("\" ");
        goto L4
    L8:
        if ("Authorization".equals(r2.getKey()) == false) goto L10;
    L11:
        r0.append("[REDACTED]");
        goto L13
    L10:
        if ("Cookie".equals(r2.getKey()) == false) goto L12;
    L14:
        r0.append("\"").append(r6).append("\"");
        if (r7.getBody() == null) goto L28;
        if (r7.getBody().length < 1024) goto L20;
        r0.append(" [REQUEST BODY TOO LARGE TO INCLUDE]");
        goto L28
    L20:
        if (isBinaryContentForLogging(r7) == false) goto L29;
        r0.insert(0, "echo '" + Base64.encodeToString(r7.getBody(), 2) + "' | base64 -d > /tmp/$$.bin; ").append(" --data-binary @/tmp/$$.bin");
        goto L28
    L29:
        r0.append(" --data-ascii \"").append(new String(r7.getBody(), "UTF-8")).append("\"");     // Catch: UnsupportedEncodingException -> L24
    L24:
        e = move-exception;
        throw new RuntimeException("Could not encode to UTF-8", e);
    L28:
        return r0.toString();
    }

    private boolean isBinaryContentForLogging(CurlLoggedRequestParameters r7) {
        String r6 = r7.getHeaders().get("Content-Encoding");
        if (r6 == null) goto L10;
        String[] r8 = TextUtils.split(r6, ",");
        int r2 = r8.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L10;
        if ("gzip".equals(r8[r3].trim()) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        return true;
    L10:
        String r9 = r7.getHeaders().get("Content-Type");
        if (r9 != null) goto L13;
        return true;
    L13:
        if (r9.startsWith("text/") == false) goto L15;
        return false;
    L15:
        if (r9.startsWith("application/xml") == false) goto L17;
        return false;
    L17:
        if (r9.startsWith(RequestParams.APPLICATION_JSON) == false) goto L19;
        return false;
    L19:
        return true;
    }
}
