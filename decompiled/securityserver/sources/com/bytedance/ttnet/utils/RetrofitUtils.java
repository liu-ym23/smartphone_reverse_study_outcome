package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.parser.CacheControlParser;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.retrofit.RequestVertifyInterceptor;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson.GsonConverterFactory;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.io.ByteArrayOutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    private static final String TAG = "RetrofitUtils";
    private static volatile CopyOnWriteArrayList<Interceptor> sInterceptors;
    private static LRUCache<String, Retrofit> sOKRetrofitCache;
    private static LRUCache<String, Retrofit> sRetrofitCache;

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r2 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r2;
            $VALUES = new CompressType[]{r0, r1, r2};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r1) {
            return (CompressType) Enum.valueOf(CompressType.class, r1);
        }

        public static CompressType[] values() {
            return (CompressType[]) $VALUES.clone();
        }
    }

    static {
        sInterceptors = new CopyOnWriteArrayList();
        Retrofit.setCommonInterceptor(sInterceptors);
        sRetrofitCache = new LRUCache(10);
        sOKRetrofitCache = new LRUCache(10);
    }

    public RetrofitUtils() {
    }

    public static void addCacheValidationHeaders(List<Header> r2, String r3, String r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r3) == true) goto L8;
        r2.add(new Header("If-None-Match", r3));
    L8:
        if (StringUtils.isEmpty(r4) == true) goto L11;
        r2.add(new Header("If-Modified-Since", r4));
        return;
    }

    public static synchronized void addInterceptor(Interceptor r2) {
        monitor-enter(RetrofitUtils.class);
        if (r2 != null) goto L17;
        monitor-exit(RetrofitUtils.class);
        return;
    L17:
    L10:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r2) == true) goto L12;
        sInterceptors.add(r2);     // Catch: Throwable -> L10
    L12:
        TtnetUtil.safeAddInterceptorInRetrofitCache(sRetrofitCache, r2);     // Catch: Throwable -> L10
        TtnetUtil.safeAddInterceptorInRetrofitCache(sOKRetrofitCache, r2);     // Catch: Throwable -> L10
        monitor-exit(RetrofitUtils.class);
    }

    @Deprecated
    public static synchronized Retrofit createOkRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4, CallAdapter.Factory r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r2, r3, r4, r5, new AnonymousClass4());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createOkService(String r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        S r3 = (S) createService(getOkRetrofit(r1), r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createRetrofit(String r3, List<Interceptor> r4, Converter.Factory r5, CallAdapter.Factory r6, Client.Provider r7) {
        monitor-enter(RetrofitUtils.class);
        ArrayList r1 = null;
        if (r5 != null) goto L17;
        ArrayList r2 = null;
    L10:
        if (r6 == null) goto L12;
        r1 = new ArrayList();     // Catch: Throwable -> L7
        r1.add(r6);     // Catch: Throwable -> L7
    L12:
        Retrofit r8 = createRetrofit(r4, r2, r1, r7, r3);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r8;
    L7:
        th = move-exception;
        throw th;
    L17:
        r2 = new ArrayList();     // Catch: Throwable -> L7
        r2.add(r5);     // Catch: Throwable -> L7
        goto L10
    }

    public static synchronized <S> S createService(Retrofit r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        if (r1 != null) goto L14;
        monitor-exit(RetrofitUtils.class);
        return null;
    L14:
        S r3 = (S) r1.create(r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createSsRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r5 = createSsRetrofit(r2, r3, r4, null);     // Catch: Throwable -> L8
        monitor-exit(RetrofitUtils.class);
        return r5;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized <S> S createSsService(String r1, Class<S> r2) {
        monitor-enter(RetrofitUtils.class);
        S r3 = (S) createService(getSsRetrofit(r1), r2);
        monitor-exit(RetrofitUtils.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createTTNetRetrofit(String r2, List<Interceptor> r3, List<Converter.Factory> r4, List<CallAdapter.Factory> r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r3, r4, r5, new AnonymousClass3(), r2);     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 7381. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @java.lang.Deprecated
    public static boolean downloadFile(int r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher<java.lang.String> r37, java.lang.String r38, com.bytedance.frameworks.baselib.network.http.util.TaskInfo r39, java.util.List<com.bytedance.retrofit2.client.Header> r40, java.lang.String[] r41, int[] r42) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONST (r7v0 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (0 ??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.bytedance.ttnet.utils.RetrofitUtils.downloadFile(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher<java.lang.String>, java.lang.String, com.bytedance.frameworks.baselib.network.http.util.TaskInfo, java.util.List<com.bytedance.retrofit2.client.Header>, java.lang.String[], int[]):boolean, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.ttnet.utils.RetrofitUtils.downloadFile(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher, java.lang.String, com.bytedance.frameworks.baselib.network.http.util.TaskInfo, java.util.List, java.lang.String[], int[]):boolean");
    }

    public static long extractMaxAge(List<Header> r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        Header r5 = getFirstHeader(r4, "Cache-Control");
        if (r5 != null) goto L17;
        return -1;
    L17:
        String r6 = new CacheControlParser(r5.getValue()).getValue(CacheControlParser.Directive.MAXAGE);     // Catch: Exception -> L12
        if (r6 == null) goto L14;
        return Long.parseLong(r6);
    L14:
        return -1;
    L12:
        e = move-exception;
        Logger.w(TAG, "extract max-age exception: " + e);
        return -1;
    }

    public static String getEtag(List<Header> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = getFirstHeader(r2, "ETag");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    public static Header getFirstHeader(List<Header> r3, String r4) {
        if (r3 != null) goto L5;
    L13:
        return null;
    L5:
        if (StringUtils.isEmpty(r4) == true) goto L13;
        Iterator<Header> r5 = r3.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Header r1 = r5.next();
        if (r4.equalsIgnoreCase(r1.getName()) == false) goto L9;
        return r1;
    }

    public static String getHeaderValueIgnoreCase(List<Header> r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L23;
        Iterator<Header> r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L15;
        Header r0 = r4.next();
        if (r3.equalsIgnoreCase(r0.getName()) == false) goto L10;
        return r0.getValue();
    L15:
        return "";
    L23:
        return null;
    }

    public static String getHostAddress(Exception r5) {
        if (r5 != null) goto L18;
        return "";
    L18:
        String[] r6 = r5.getMessage().split("\\|");     // Catch: Throwable -> L12
        if (r6 != null) goto L8;
    L17:
        return "";
    L8:
        if (r6.length < 2) goto L17;
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "getHostAddress remoteIp = " + r6[0]);     // Catch: Throwable -> L12
    L14:
        return r6[0];
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    public static String getLastModified(List<Header> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = getFirstHeader(r2, "Last-Modified");
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getValue();
    }

    @Deprecated
    public static synchronized Retrofit getOkRetrofit(String r3) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r3) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r1 = sOKRetrofitCache.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r1;
    L13:
        Retrofit r2 = createOkRetrofit(r3, null, null, null);     // Catch: Throwable -> L16
        sOKRetrofitCache.put(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r2;
    }

    private static void getOutIp(BaseHttpRequestInfo r4, String[] r5, List<Header> r6, RequestContext r7, Exception r8) {
        String r0 = null;
        if (r6 == null) goto L15;
    L12:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r6.size() <= 0) goto L15;
        Iterator<Header> r9 = r6.iterator();     // Catch: Throwable -> L12
    L8:
        if (r9.hasNext() == false) goto L15;
        Header r1 = r9.next();     // Catch: Throwable -> L12
        if ("x-net-info.remoteaddr".equalsIgnoreCase(r1.getName()) == false) goto L8;
        r0 = r1.getValue();     // Catch: Throwable -> L12
    L15:
        if (StringUtils.isEmpty(r0) == false) goto L19;
        if (r7 == null) goto L19;
        r0 = r7.remoteIp;     // Catch: Throwable -> L12
    L19:
        if (StringUtils.isEmpty(r0) == false) goto L22;
        r0 = getHostAddress(r8);     // Catch: Throwable -> L12
    L22:
        if (StringUtils.isEmpty(r0) == false) goto L24;
        return;
    L24:
        if (r5 != null) goto L26;
    L28:
        if (r4 == null) goto L42;
        r4.remoteIp = r0;     // Catch: Throwable -> L12
        T r10 = r4.reqContext;     // Catch: Throwable -> L12
        if (r10 == 0) goto L43;
        r10.remoteIp = r0;     // Catch: Throwable -> L12
        return;
    L43:
        return;
    L42:
        return;
    L26:
        if (r5.length <= 0) goto L28;
        r5[0] = r0;     // Catch: Throwable -> L12
        goto L28
    }

    public static synchronized Retrofit getSsRetrofit(String r3) {
        monitor-enter(RetrofitUtils.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r3) == false) goto L9;
        monitor-exit(RetrofitUtils.class);
        return null;
    L9:
        Retrofit r1 = sRetrofitCache.get(r3);     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        monitor-exit(RetrofitUtils.class);
        return r1;
    L13:
        Retrofit r2 = createSsRetrofit(r3, null, null, null);     // Catch: Throwable -> L16
        sRetrofitCache.put(r3, r2);     // Catch: Throwable -> L16
        monitor-exit(RetrofitUtils.class);
        return r2;
    }

    public static Pair<String, String> parseContentType(String r3) {
        String r0 = null;
        if (r3 != null) goto L17;
        return null;
    L17:
        MimeType r1 = new MimeType(r3);     // Catch: Throwable -> L10
        String r4 = r1.getBaseType();     // Catch: Throwable -> L10
        r0 = r1.getParameter("charset");     // Catch: Throwable -> L8
    L14:
        return new Pair(r4, r0);
    L8:
        th = th;
    L12:
        th.printStackTrace();
    L10:
        th = th;
        r4 = null;
        goto L12
    }

    public static synchronized void removeInterceptor(Interceptor r2) {
        monitor-enter(RetrofitUtils.class);
        if (r2 != null) goto L17;
        monitor-exit(RetrofitUtils.class);
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L8:
        if (sInterceptors.contains(r2) == true) goto L11;
        monitor-exit(RetrofitUtils.class);
        return;
    L11:
        sInterceptors.remove(r2);     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sRetrofitCache, r2);     // Catch: Throwable -> L14
        TtnetUtil.safeRemoveInterceptorInRetrofitCache(sOKRetrofitCache, r2);     // Catch: Throwable -> L14
        monitor-exit(RetrofitUtils.class);
    }

    public static void setTimeout(URLConnection r1) {
        if (r1 == null) goto L5;
        r1.setConnectTimeout(15000);
        r1.setReadTimeout(15000);
        return;
    }

    public static Pair<byte[], String> tryCompressData(byte[] r6, CompressType r7) {
        byte[] r1 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = r6.length;
        if (CompressType.GZIP != r7) goto L19;
        if (r2 <= 128) goto L19;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r3 = new GZIPOutputStream(r8);
        r3.write(r6);     // Catch: Throwable -> L11
        r3.close();
        r1 = r8.toByteArray();
        String r9 = "gzip";
    L28:
        return new Pair(r1, r9);
    L11:
        th = move-exception;
        Logger.w(TAG, "compress with gzip exception: " + th);     // Catch: Throwable -> L15
        r3.close();
        return null;
    L15:
        th = move-exception;
        r3.close();
        throw th;
    L19:
        if (CompressType.DEFLATER != r7) goto L26;
        if (r2 <= 128) goto L26;
        ByteArrayOutputStream r10 = new ByteArrayOutputStream(8192);
        Deflater r0 = new Deflater();
        r0.setInput(r6);
        r0.finish();
        byte[] r11 = new byte[8192];
    L23:
        if (r0.finished() == true) goto L25;
        r10.write(r11, 0, r0.deflate(r11));
        goto L23
    L25:
        r0.end();
        r1 = r10.toByteArray();
        r9 = "deflate";
    L26:
        r9 = null;
        goto L28
    }

    public static synchronized Retrofit createSsRetrofit(String r2, List<Interceptor> r3, Converter.Factory r4, CallAdapter.Factory r5) {
        monitor-enter(RetrofitUtils.class);
        Retrofit r6 = createRetrofit(r2, r3, r4, r5, new AnonymousClass2());     // Catch: Throwable -> L7
        monitor-exit(RetrofitUtils.class);
        return r6;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Retrofit createRetrofit(List<Interceptor> r3, List<Converter.Factory> r4, List<CallAdapter.Factory> r5, Client.Provider r6, String r7) {
        monitor-enter(RetrofitUtils.class);
        if (r6 == null) goto L57;
    L8:
        Retrofit.Builder r8 = new Retrofit.Builder().setEndpoint(r7).client(r6).httpExecutor(new SsHttpExecutor());     // Catch: Throwable -> L6
        if (r4 != null) goto L12;
        r4 = new ArrayList();     // Catch: Throwable -> L6
    L12:
        if (r4.isEmpty() == false) goto L14;
        r4.add(GsonConverterFactory.create());     // Catch: Throwable -> L6
    L14:
        Iterator<Converter.Factory> r9 = r4.iterator();     // Catch: Throwable -> L6
    L16:
        if (r9.hasNext() == false) goto L18;
        r8.addConverterFactory(r9.next());     // Catch: Throwable -> L6
        goto L16
    L18:
        if (r5 != null) goto L20;
    L25:
        LinkedList r10 = new LinkedList();     // Catch: Throwable -> L6
        if (r3 != null) goto L28;
    L40:
        boolean r11 = false;
    L41:
        if (r11 == true) goto L44;
        r10.add(0, new SsInterceptor());     // Catch: Throwable -> L6
    L44:
        if (sInterceptors != null) goto L46;
    L48:
        r10.add(new RequestVertifyInterceptor());     // Catch: Throwable -> L6
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L6
    L50:
        if (r12.hasNext() == false) goto L52;
        r8.addInterceptor((Interceptor) r12.next());     // Catch: Throwable -> L6
        goto L50
    L52:
        Retrofit r13 = r8.build();     // Catch: Throwable -> L6
        monitor-exit(RetrofitUtils.class);
        return r13;
    L6:
        th = move-exception;
        throw th;
    L46:
        if (sInterceptors.size() <= 0) goto L48;
        r10.addAll(sInterceptors);     // Catch: Throwable -> L6
        goto L48
    L28:
        if (r3.size() <= 0) goto L40;
        Iterator<Interceptor> r14 = r3.iterator();     // Catch: Throwable -> L6
        r11 = false;
    L31:
        if (r14.hasNext() == false) goto L41;
        Interceptor r1 = r14.next();     // Catch: Throwable -> L6
        if ((r1 instanceof SsInterceptor) == true) goto L34;
        if ((r1 instanceof RequestVertifyInterceptor) == true) goto L31;
    L39:
        r10.add(r1);     // Catch: Throwable -> L6
        goto L31
    L34:
        if (r11 == true) goto L31;
        r10.add(r1);     // Catch: Throwable -> L6
        r11 = true;
        goto L39
    L20:
        if (r5.isEmpty() == true) goto L25;
        Iterator<CallAdapter.Factory> r15 = r5.iterator();     // Catch: Throwable -> L6
    L23:
        if (r15.hasNext() == false) goto L25;
        r8.addCallAdapterFactory(r15.next());     // Catch: Throwable -> L6
        goto L23
    L57:
        r6 = new AnonymousClass5();     // Catch: Throwable -> L6
        goto L8
    }
}
