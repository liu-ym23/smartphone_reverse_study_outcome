package com.bytedance.badger.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.m;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00072\u00020\u0001:\u0003\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult;", "", "", "toJsonString", "()Ljava/lang/String;", "<init>", "()V", "Companion", "a", "Failure", "Success", "Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult$Failure;", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public abstract class BadgerResult {
    public static final a Companion = null;
    public static final int ERROR = -1000;
    public static final int ERROR_AWAIT_TIMEOUT = -2001;
    public static final int ERROR_JAVA_EXCEPTION = -1002;
    public static final int ERROR_SDK_NOT_SUPPORT = -1001;
    public static final int NOT_FINISHED = -3000;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = -2000;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Failure;", "Lcom/bytedance/badger/data/BadgerResult;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "errorCode", "errorMsg", "copy", "(ILjava/lang/String;)Lcom/bytedance/badger/data/BadgerResult$Failure;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "getErrorMsg", "a", "I", "getErrorCode", "<init>", "(ILjava/lang/String;)V", "badger-api_release"}, k = 1, mv = {1, 1, 15})
    public static final class Failure extends BadgerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2528b;

        public Failure(int r2, String r3) {
            o.g(r3, "errorMsg");
            super(null);
            this.f2527a = r2;
            this.f2528b = r3;
        }

        public static /* synthetic */ Failure copy$default(Failure r0, int r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.f2527a;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.f2528b;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.f2527a;
        }

        public final String component2() {
            return this.f2528b;
        }

        public final Failure copy(int r1, String r2) {
            o.g(r2, "errorMsg");
            return new Failure(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
        L15:
            return true;
        L5:
            if ((r5 instanceof Failure) == false) goto L14;
            Failure r6 = (Failure) r5;
            if (this.f2527a != r6.f2527a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L14;
            if (o.a(this.f2528b, r6.f2528b) == false) goto L14;
        L9:
            r1 = false;
        L14:
            return false;
        }

        public final int getErrorCode() {
            return this.f2527a;
        }

        public final String getErrorMsg() {
            return this.f2528b;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f2527a) * 31;
            String r1 = this.f2528b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "Failure(errorCode=" + this.f2527a + ", errorMsg=" + this.f2528b + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult;", "", "", "", "component1", "()Ljava/util/Map;", "data", "copy", "(Ljava/util/Map;)Lcom/bytedance/badger/data/BadgerResult$Success;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/Map;", "getData", "<init>", "(Ljava/util/Map;)V", "badger-api_release"}, k = 1, mv = {1, 1, 15})
    public static final class Success extends BadgerResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Object> f2529a;

        public Success(Map<String, ? extends Object> r2) {
            o.g(r2, "data");
            super(null);
            this.f2529a = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success r0, Map r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.f2529a;
        L6:
            return r0.copy(r1);
        }

        public final Map<String, Object> component1() {
            return this.f2529a;
        }

        public final Success copy(Map<String, ? extends Object> r1) {
            o.g(r1, "data");
            return new Success(r1);
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof Success) == true) goto L6;
            return false;
        L6:
            if (o.a(this.f2529a, ((Success) r2).f2529a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final Map<String, Object> getData() {
            return this.f2529a;
        }

        public int hashCode() {
            Map<String, Object> r0 = this.f2529a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f2529a + ")";
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    private BadgerResult() {
    }

    public /* synthetic */ BadgerResult(g r1) {
        this();
    }

    public final String toJsonString() {
        String r1 = "{}";
        if ((this instanceof Success) == false) goto L7;
        r1 = new JSONObject(((Success) this).getData()).toString();     // Catch: Exception -> L12
    L13:
        goto L9
    L7:
        if ((this instanceof Failure) == false) goto L11;
        r1 = new JSONObject().put("status", "failure").put("errorCode", ((Failure) this).getErrorCode()).put("errorMsg", ((Failure) this).getErrorMsg()).toString();     // Catch: Exception -> L12
        goto L13
    L11:
        throw new m();
    L9:
        return r1;
    }
}
