package com.bytedance.android.sdk.bdticketguard;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0010J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR0\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/o0;", "Lcom/bytedance/android/sdk/bdticketguard/m0;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "Lcom/bytedance/android/sdk/bdticketguard/o0$a;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "itemArray", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class o0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("tickets")
    private final ArrayList<a> f923a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u000f\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0013"}, d2 = {"com/bytedance/android/sdk/bdticketguard/o0$a", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "tsSign", "c", "tsSignRee", "a", "ticket", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("ticket")
        private final String f924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("ts_sign")
        private final String f925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @com.google.gson.y.c("ts_sign_ree")
        private final String f926c;

        public final String a() {
            return this.f924a;
        }

        public final String b() {
            return this.f925b;
        }

        public final String c() {
            return this.f926c;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (kotlin.n0.d.o.a(this.f924a, r4.f924a) == true) goto L8;
            return false;
        L8:
            if (kotlin.n0.d.o.a(this.f925b, r4.f925b) == true) goto L10;
            return false;
        L10:
            if (kotlin.n0.d.o.a(this.f926c, r4.f926c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.f924a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.f925b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f926c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "ServerDataItem(ticket=" + this.f924a + ", tsSign=" + this.f925b + ", tsSignRee=" + this.f926c + ")";
        }
    }

    public final ArrayList<a> a() {
        return this.f923a;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof o0) == true) goto L6;
        return false;
    L6:
        if (kotlin.n0.d.o.a(this.f923a, ((o0) r2).f923a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        ArrayList<a> r0 = this.f923a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "ServerDataV2(itemArray=" + this.f923a + ")";
    }
}
