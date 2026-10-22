package com.obric.matrix.common_api;

import androidx.annotation.Keep;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.common.wschannel.WsConstants;
import d.b.r.i0.a0;
import d.b.r.i0.f;
import d.b.r.i0.g;
import d.b.r.i0.g0;
import d.b.r.i0.h;
import d.b.r.i0.m;
import d.b.r.i0.o;
import d.b.r.i0.q;
import d.b.r.i0.t;
import d.b.r.i0.w;
import d.b.r.k0.j;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014Jn\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bH'JN\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0001\u0010\b\u001a\u00020\tH'JN\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0001\u0010\b\u001a\u00020\tH'JX\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0014\b\u0001\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\u0011H'JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b2\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u000bH'¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/common_api/INetworkApi;", "", "doPost", "Lcom/bytedance/retrofit2/Call;", "", WsConstants.KEY_CONNECTION_URL, "maxLength", "", "addCommonParam", "", "headMap", "", "fieldMap", "queryMap", "executeGet", "executePost", "body", "Lcom/bytedance/retrofit2/mime/TypedOutput;", "postMultiPart", "partMap", "Companion", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface INetworkApi {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final a Companion = null;
    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/matrix/common_api/INetworkApi$Companion;", "", "()V", "CONTENT_TYPE", "", "DEFAULT_CONTENT_TYPE", "SERVICE", "Lcom/obric/matrix/common_api/INetworkApi;", "getSERVICE", "()Lcom/obric/matrix/common_api/INetworkApi;", "common_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f8944a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final INetworkApi f8945b = null;

        static {
            f8944a = new a();
            f8945b = (INetworkApi) c.f8951a.a(INetworkApi.class);
        }

        private a() {
        }

        public final INetworkApi a() {
            return f8945b;
        }
    }

    static {
        Companion = a.f8944a;
    }

    @t
    @g
    d.b.r.b<String> doPost(@g0 String r1, @o int r2, @d.b.r.i0.a boolean r3, @m Map<String, String> r4, @f(encode = EmbeddingCompat.DEBUG) Map<String, String> r5, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r6);

    @h
    d.b.r.b<String> executeGet(@g0 String r1, @m Map<String, String> r2, @a0 Map<String, String> r3, @d.b.r.i0.a boolean r4);

    @t
    d.b.r.b<String> executePost(@g0 String r1, @m Map<String, String> r2, @a0 Map<String, String> r3, @d.b.r.i0.a boolean r4);

    @t
    d.b.r.b<String> executePost(@g0 String r1, @m Map<String, String> r2, @a0 Map<String, String> r3, @d.b.r.i0.a boolean r4, @d.b.r.i0.b j r5);

    @q
    @t
    d.b.r.b<String> postMultiPart(@g0 String r1, @o int r2, @a0(encode = EmbeddingCompat.DEBUG) Map<String, String> r3, @w Map<String, ? extends j> r4);
}
