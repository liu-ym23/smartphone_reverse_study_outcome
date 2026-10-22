package com.bytedance.android.sdk.bdticketguard;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJQ\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0011H\u0016¢\u0006\u0004\b \u0010!J=\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0010\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardProvider;", "Landroid/content/ContentProvider;", "", "onCreate", "()Z", "Lkotlin/f0;", "b", "()V", "", "id", WsConstants.KEY_CONNECTION_TYPE, "Lcom/bytedance/android/sdk/bdticketguard/n1/c$f;", "initResult", "a", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/n1/c$f;)V", "Landroid/net/Uri;", "uri", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Lcom/bytedance/android/sdk/bdticketguard/a0;", "h", "Lcom/bytedance/android/sdk/bdticketguard/a0;", "mainManager", "f", "Ljava/lang/String;", "authority", "Landroid/content/UriMatcher;", "g", "Landroid/content/UriMatcher;", "uriMatcher", "i", "Z", "hasInit", "<init>", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
public final class TicketGuardProvider extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private UriMatcher f630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a0 f631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f632i;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.p<com.bytedance.android.sdk.bdticketguard.n1.b, com.bytedance.android.sdk.bdticketguard.n1.c.f, kotlin.f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ TicketGuardProvider f633f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f634g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f635h;

        a(TicketGuardProvider r1, String r2, String r3) {
            this.f633f = r1;
            this.f634g = r2;
            this.f635h = r3;
            super(2);
        }

        public final void a(com.bytedance.android.sdk.bdticketguard.n1.b r2, com.bytedance.android.sdk.bdticketguard.n1.c.f r3) {
            kotlin.n0.d.o.g(r2, "initTask");
            kotlin.n0.d.o.g(r3, "initResult");
            this.f633f.a(this.f634g, this.f635h, r3);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ kotlin.f0 invoke(com.bytedance.android.sdk.bdticketguard.n1.b r1, com.bytedance.android.sdk.bdticketguard.n1.c.f r2) {
            a(r1, r2);
            return kotlin.f0.f18324a;
        }
    }

    public TicketGuardProvider() {
    }

    public final void a(String r6, String r7, com.bytedance.android.sdk.bdticketguard.n1.c.f r8) {
        kotlin.n0.d.o.g(r6, "id");
        kotlin.n0.d.o.g(r7, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.g(r8, "initResult");
        StringBuilder r2 = new StringBuilder();
        r2.append("content://");
        String r3 = this.f629f;
        if (r3 == null) goto L10;
        r2.append(r3);
        r2.append("/load_result");
        Uri r9 = Uri.parse(r2.toString()).buildUpon().appendQueryParameter("id", r6).appendQueryParameter(WsConstants.KEY_CONNECTION_TYPE, r7).appendQueryParameter("result", String.valueOf(r8.a())).build();
        Context r5 = getContext();
        if (r5 == null) goto L8;
        kotlin.n0.d.o.b(r5, "context!!");
        r5.getContentResolver().notifyChange(r9, null);
        return;
    L8:
        kotlin.n0.d.o.p();
        throw null;
    L10:
        kotlin.n0.d.o.v("authority");
        throw null;
    }

    @VisibleForTesting
    public final void b() {
        if (this.f631h != null) goto L9;
        f1 r0 = d1.f706b.a();
        if ((r0 instanceof a0) == true) goto L7;
        r0 = null;
    L7:
        this.f631h = (a0) r0;
    L9:
        if (this.f632i == false) goto L11;
        return;
    L11:
        this.f632i = true;
        this.f629f = j1.a(getContext());
        UriMatcher r1 = new UriMatcher(-1);
        String r2 = this.f629f;
        if (r2 == null) goto L99;
        r1.addURI(r2, "query_csr", 101);
        String r3 = this.f629f;
        if (r3 == null) goto L97;
        r1.addURI(r3, "query_client_cert", 102);
        String r4 = this.f629f;
        if (r4 == null) goto L95;
        r1.addURI(r4, "query_server_cert", 103);
        String r5 = this.f629f;
        if (r5 == null) goto L93;
        r1.addURI(r5, "ticket_data", 104);
        String r6 = this.f629f;
        if (r6 == null) goto L91;
        r1.addURI(r6, "sign", 105);
        String r7 = this.f629f;
        if (r7 == null) goto L89;
        r1.addURI(r7, "encrypt", 106);
        String r8 = this.f629f;
        if (r8 == null) goto L87;
        r1.addURI(r8, "decrypt", 107);
        String r9 = this.f629f;
        if (r9 == null) goto L85;
        r1.addURI(r9, "delta_public_key", 108);
        String r10 = this.f629f;
        if (r10 == null) goto L83;
        r1.addURI(r10, "query_ree_public_key", 109);
        String r11 = this.f629f;
        if (r11 == null) goto L81;
        r1.addURI(r11, "query_tee_create_log", 111);
        String r12 = this.f629f;
        if (r12 == null) goto L79;
        r1.addURI(r12, "query_ree_create_log", 112);
        String r13 = this.f629f;
        if (r13 == null) goto L77;
        r1.addURI(r13, "QUERY_TEE_EVER_FAIL", 113);
        String r14 = this.f629f;
        if (r14 == null) goto L75;
        r1.addURI(r14, "QUERY_TEE_PUB", 114);
        String r15 = this.f629f;
        if (r15 == null) goto L73;
        r1.addURI(r15, "query_load", 115);
        String r16 = this.f629f;
        if (r16 == null) goto L71;
        r1.addURI(r16, "update_ticket_data", 200);
        String r17 = this.f629f;
        if (r17 == null) goto L69;
        r1.addURI(r17, "update_cert", 201);
        String r18 = this.f629f;
        if (r18 == null) goto L67;
        r1.addURI(r18, "clear_server_cert", 202);
        String r19 = this.f629f;
        if (r19 == null) goto L65;
        r1.addURI(r19, "update_tee_ever_fail", 203);
        String r20 = this.f629f;
        if (r20 == null) goto L63;
        r1.addURI(r20, "ree_hmac", 204);
        String r21 = this.f629f;
        if (r21 == null) goto L61;
        r1.addURI(r21, "get_attest_sign_cache", 117);
        String r22 = this.f629f;
        if (r22 == null) goto L59;
        r1.addURI(r22, "attest_pub_key", 116);
        String r23 = this.f629f;
        if (r23 == null) goto L57;
        r1.addURI(r23, "update_sec_ts", 205);
        this.f630g = r1;
        return;
    L57:
        kotlin.n0.d.o.v("authority");
        throw null;
    L59:
        kotlin.n0.d.o.v("authority");
        throw null;
    L61:
        kotlin.n0.d.o.v("authority");
        throw null;
    L63:
        kotlin.n0.d.o.v("authority");
        throw null;
    L65:
        kotlin.n0.d.o.v("authority");
        throw null;
    L67:
        kotlin.n0.d.o.v("authority");
        throw null;
    L69:
        kotlin.n0.d.o.v("authority");
        throw null;
    L71:
        kotlin.n0.d.o.v("authority");
        throw null;
    L73:
        kotlin.n0.d.o.v("authority");
        throw null;
    L75:
        kotlin.n0.d.o.v("authority");
        throw null;
    L77:
        kotlin.n0.d.o.v("authority");
        throw null;
    L79:
        kotlin.n0.d.o.v("authority");
        throw null;
    L81:
        kotlin.n0.d.o.v("authority");
        throw null;
    L83:
        kotlin.n0.d.o.v("authority");
        throw null;
    L85:
        kotlin.n0.d.o.v("authority");
        throw null;
    L87:
        kotlin.n0.d.o.v("authority");
        throw null;
    L89:
        kotlin.n0.d.o.v("authority");
        throw null;
    L91:
        kotlin.n0.d.o.v("authority");
        throw null;
    L93:
        kotlin.n0.d.o.v("authority");
        throw null;
    L95:
        kotlin.n0.d.o.v("authority");
        throw null;
    L97:
        kotlin.n0.d.o.v("authority");
        throw null;
    L99:
        kotlin.n0.d.o.v("authority");
        throw null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        kotlin.n0.d.o.g(r1, "uri");
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r2) {
        kotlin.n0.d.o.g(r2, "uri");
        b();
        StringBuilder r3 = new StringBuilder();
        r3.append("vnd.android.cursor.item/vnd.");
        String r1 = this.f629f;
        if (r1 == null) goto L6;
        r3.append(r1);
        r3.append(".item");
        return r3.toString();
    L6:
        kotlin.n0.d.o.v("authority");
        throw null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        kotlin.n0.d.o.g(r1, "uri");
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        com.bytedance.android.sdk.bdticketguard.n1.k.e();
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r10, String[] r11, String r12, String[] r13, String r14) {
        kotlin.n0.d.o.g(r10, "uri");
        b();
        UriMatcher r15 = this.f630g;
        Object r16 = null;
        if (r15 == null) goto L216;
        int r17 = r15.match(r10);
        String r2 = "";
        if (r17 == 204) goto L202;
        boolean r7 = false;
        switch(r17) {
            case 101: goto L191;
            case 102: goto L182;
            case 103: goto L173;
            case 104: goto L160;
            case 105: goto L127;
            case 106: goto L118;
            case 107: goto L107;
            case 108: goto L98;
            case 109: goto L89;
            default: goto L8;
        };
    L8:
        switch(r17) {
            case 111: goto L80;
            case 112: goto L71;
            case 113: goto L62;
            case 114: goto L53;
            case 115: goto L22;
            case 116: goto L17;
            case 117: goto L10;
            default: goto L201;
        };
    L10:
        MatrixCursor r18 = new MatrixCursor(new String[]{"attest_sign_result", "exception_message"});
        MatrixCursor.RowBuilder r19 = r18.newRow();
        a0 r9 = this.f631h;
        if (r9 == null) goto L15;
        com.bytedance.android.sdk.bdticketguard.m1.c r20 = r9.u();
        if (r20 == null) goto L15;
        r16 = r20.b();
    L15:
        r19.add(r16);
        return r18;
    L17:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", attest pub key");
        MatrixCursor r110 = new MatrixCursor(new String[]{"attest_pub_key"});
        MatrixCursor.RowBuilder r111 = r110.newRow();
        a0 r21 = this.f631h;
        if (r21 == null) goto L20;
        r16 = r21.t();
    L20:
        r111.add(r16);
        return r110;
    L22:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", load");
        String r112 = r10.getQueryParameter("id");
        if (r112 == null) goto L52;
        kotlin.n0.d.o.b(r112, "uri.getQueryParameter(PARAM_ID) ?: return null");
        String r113 = r10.getQueryParameter(WsConstants.KEY_CONNECTION_TYPE);
        if (r113 == null) goto L52;
        kotlin.n0.d.o.b(r113, "uri.getQueryParameter(PARAM_TYPE) ?: return null");
        String r114 = r10.getQueryParameter("scene");
        if (r114 == null) goto L29;
        r2 = r114;
    L29:
        kotlin.n0.d.o.b(r2, "uri.getQueryParameter(PARAM_SCENE) ?: \"\"");
        a r115 = new a(this, r112, r113);
        int r116 = r113.hashCode();
        if (r116 == (-1512632445)) goto L48;
        if (r116 == 112786) goto L43;
        if (r116 != 114708) goto L201;
        if (r113.equals("tee") == false) goto L201;
        a0 r22 = this.f631h;
        if (r22 == null) goto L201;
        r22.O(r2, r115);
    L41:
        kotlin.f0 r23 = kotlin.f0.f18324a;
        goto L201
    L43:
        if (r113.equals("ree") == false) goto L201;
        a0 r24 = this.f631h;
        if (r24 == null) goto L201;
        r24.N(r2, r115);
        goto L41
    L48:
        if (r113.equals("encryption") == false) goto L201;
        a0 r25 = this.f631h;
        if (r25 == null) goto L201;
        r25.M(r2, r115);
    L52:
        return null;
    L53:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", query tee 04 public key");
        MatrixCursor r117 = new MatrixCursor(new String[]{"TEE_PUB"});     // Catch: Exception -> L60
        MatrixCursor.RowBuilder r118 = r117.newRow();     // Catch: Exception -> L60
        a0 r26 = this.f631h;     // Catch: Exception -> L60
        if (r26 == null) goto L57;
        String r27 = r26.E();     // Catch: Exception -> L60
    L58:
        r118.add(r27);     // Catch: Exception -> L60
        return r117;
    L57:
        r27 = null;
    L60:
        e = e;
        s0 r119 = s0.f1065a;
        String r120 = "query tee 04 public key failed";
    L200:
        r119.c("TicketGuardProvider", r120, e);
        goto L201
    L62:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", query tee ever fail");
        MatrixCursor r121 = new MatrixCursor(new String[]{"TEE_EVER_FAIL"});     // Catch: Exception -> L69
        MatrixCursor.RowBuilder r122 = r121.newRow();     // Catch: Exception -> L69
        a0 r28 = this.f631h;     // Catch: Exception -> L69
        if (r28 == null) goto L66;
        Boolean r29 = Boolean.valueOf(r28.D());     // Catch: Exception -> L69
    L67:
        r122.add(r29);     // Catch: Exception -> L69
        return r121;
    L66:
        r29 = null;
    L69:
        e = e;
        r119 = s0.f1065a;
        r120 = "query tee ever fail failed";
        goto L200
    L71:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", query ree create log");
        MatrixCursor r123 = new MatrixCursor(new String[]{"ree_create_log"});     // Catch: Exception -> L78
        MatrixCursor.RowBuilder r124 = r123.newRow();     // Catch: Exception -> L78
        a0 r30 = this.f631h;     // Catch: Exception -> L78
        if (r30 == null) goto L75;
        String r31 = r30.B();     // Catch: Exception -> L78
    L76:
        r124.add(r31);     // Catch: Exception -> L78
        return r123;
    L75:
        r31 = null;
    L78:
        e = e;
        r119 = s0.f1065a;
        r120 = "query ree create log failed";
        goto L200
    L80:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", query tee create log");
        MatrixCursor r125 = new MatrixCursor(new String[]{"tee_create_log"});     // Catch: Exception -> L87
        MatrixCursor.RowBuilder r126 = r125.newRow();     // Catch: Exception -> L87
        a0 r32 = this.f631h;     // Catch: Exception -> L87
        if (r32 == null) goto L84;
        String r33 = r32.C();     // Catch: Exception -> L87
    L85:
        r126.add(r33);     // Catch: Exception -> L87
        return r125;
    L84:
        r33 = null;
    L87:
        e = e;
        r119 = s0.f1065a;
        r120 = "query tee create log failed";
    L201:
        return null;
    L89:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", ree public key");
        MatrixCursor r127 = new MatrixCursor(new String[]{"ree_public_key"});     // Catch: Exception -> L96
        MatrixCursor.RowBuilder r128 = r127.newRow();     // Catch: Exception -> L96
        a0 r34 = this.f631h;     // Catch: Exception -> L96
        if (r34 == null) goto L93;
        String r35 = r34.v();     // Catch: Exception -> L96
    L94:
        r128.add(r35);     // Catch: Exception -> L96
        return r127;
    L93:
        r35 = null;
    L96:
        e = e;
        r119 = s0.f1065a;
        r120 = "query ree public key failed";
        goto L200
    L98:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", delta public key");
        MatrixCursor r129 = new MatrixCursor(new String[]{"delta_public_key"});     // Catch: Exception -> L105
        MatrixCursor.RowBuilder r130 = r129.newRow();     // Catch: Exception -> L105
        a0 r36 = this.f631h;     // Catch: Exception -> L105
        if (r36 == null) goto L102;
        String r37 = r36.p0();     // Catch: Exception -> L105
    L103:
        r130.add(r37);     // Catch: Exception -> L105
        return r129;
    L102:
        r37 = null;
    L105:
        e = e;
        r119 = s0.f1065a;
        r120 = "query delta public key failed";
        goto L200
    L107:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", decrypt");
        MatrixCursor r131 = new MatrixCursor(new String[]{"decrypted", "exception_message"});
        String r132 = r10.getQueryParameter("content");     // Catch: Exception -> L113
        a0 r38 = this.f631h;     // Catch: Exception -> L113
        if (r38 == null) goto L111;
        byte[] r133 = Base64.decode(r132, 0);     // Catch: Exception -> L113
        kotlin.n0.d.o.b(r133, "Base64.decode(content, Base64.DEFAULT)");     // Catch: Exception -> L113
        r16 = r38.l0(r133);     // Catch: Exception -> L113
        String r39 = null;
    L115:
        MatrixCursor.RowBuilder r134 = r131.newRow().add(r16);
    L116:
        r134.add(r39);
        return r131;
    L111:
        kotlin.n0.d.o.p();     // Catch: Exception -> L113
        throw null;
    L113:
        e = move-exception;
        s0.f1065a.c("TicketGuardProvider", "query decrypt failed", e);
        r39 = e.getMessage();
        goto L115
    L118:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", encrypt");
        r131 = new MatrixCursor(new String[]{"encrypted", "exception_message"});
        String r135 = r10.getQueryParameter("content");     // Catch: Exception -> L124
        a0 r40 = this.f631h;     // Catch: Exception -> L124
        if (r40 == null) goto L122;
        byte[] r136 = Base64.decode(r135, 0);     // Catch: Exception -> L124
        kotlin.n0.d.o.b(r136, "Base64.decode(content, Base64.DEFAULT)");     // Catch: Exception -> L124
        r16 = r40.o0(r136);     // Catch: Exception -> L124
        r39 = null;
    L126:
        r134 = r131.newRow().add(r16);
        goto L116
    L122:
        kotlin.n0.d.o.p();     // Catch: Exception -> L124
        throw null;
    L124:
        e = move-exception;
        s0.f1065a.c("TicketGuardProvider", "query encrypt failed", e);
        r39 = e.getMessage();
        goto L126
    L127:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", sign");
        MatrixCursor r137 = new MatrixCursor(new String[]{"encoded_signed"});     // Catch: Exception -> L158
        String r138 = r10.getQueryParameter("unsigned");     // Catch: Exception -> L158
        String r139 = r10.getQueryParameter("path");     // Catch: Exception -> L158
        String r140 = r10.getQueryParameter("sign_type");     // Catch: Exception -> L158
        if (r138 != null) goto L131;
    L132:
        r7 = true;
    L133:
        if (r7 == true) goto L201;
        if (r140 == null) goto L155;
        int r0 = r140.hashCode();     // Catch: Exception -> L158
        if (r0 == 157663823) goto L149;
        if (r0 != 157665745) goto L155;
        if (r140.equals("sign_type_tee") == false) goto L155;
        a0 r41 = this.f631h;     // Catch: Exception -> L158
        if (r41 == null) goto L155;
        if (r139 == null) goto L147;
        r2 = r139;
    L147:
        String r42 = r41.o(r138, r2);     // Catch: Exception -> L158
    L156:
        r137.newRow().add(r42);     // Catch: Exception -> L158
        return r137;
    L149:
        if (r140.equals("sign_type_ree") == false) goto L155;
        a0 r43 = this.f631h;     // Catch: Exception -> L158
        if (r43 == null) goto L155;
        if (r139 == null) goto L154;
        r2 = r139;
    L154:
        r42 = r43.e(r138, r2);     // Catch: Exception -> L158
    L155:
        r42 = null;
        goto L156
    L131:
        if (r138.length() != 0) goto L133;
    L158:
        e = e;
        r119 = s0.f1065a;
        r120 = "query sign failed";
        goto L200
    L160:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", ticket data");
        MatrixCursor r141 = new MatrixCursor(new String[]{"ts_sign", "ts_sign_ree", WsConstants.KEY_CONNECTION_TYPE, "cert"});     // Catch: Exception -> L171
        String r142 = r10.getQueryParameter("ticket");     // Catch: Exception -> L171
        a0 r44 = this.f631h;     // Catch: Exception -> L171
        if (r44 == null) goto L167;
        if (r142 == null) goto L165;
        w0 r45 = r44.F(r142);     // Catch: Exception -> L171
    L168:
        if (r45 == null) goto L201;
        r141.newRow().add(r45.c()).add(r45.d()).add(r45.e()).add(r45.a());     // Catch: Exception -> L171
        return r141;
    L165:
        kotlin.n0.d.o.p();     // Catch: Exception -> L171
        throw null;
    L167:
        r45 = null;
    L171:
        e = e;
        r119 = s0.f1065a;
        r120 = "query ticket data failed";
        goto L200
    L173:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", server cert");
        MatrixCursor r143 = new MatrixCursor(new String[]{"server_cert_string", "serial_number", "public_key"});     // Catch: Exception -> L180
        a0 r46 = this.f631h;     // Catch: Exception -> L180
        if (r46 == null) goto L201;
        l0 r47 = r46.g();     // Catch: Exception -> L180
        if (r47 == null) goto L201;
        r143.newRow().add(r47.a()).add(r47.c()).add(r47.b());     // Catch: Exception -> L180
        return r143;
    L180:
        e = e;
        r119 = s0.f1065a;
        r120 = "query server cert failed";
        goto L200
    L182:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", client cert");
        MatrixCursor r144 = new MatrixCursor(new String[]{"client_cert"});     // Catch: Exception -> L189
        MatrixCursor.RowBuilder r145 = r144.newRow();     // Catch: Exception -> L189
        a0 r48 = this.f631h;     // Catch: Exception -> L189
        if (r48 == null) goto L186;
        String r49 = r48.m();     // Catch: Exception -> L189
    L187:
        r145.add(r49);     // Catch: Exception -> L189
        return r144;
    L186:
        r49 = null;
    L189:
        e = e;
        r119 = s0.f1065a;
        r120 = "query client cert failed";
        goto L200
    L191:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", csr");
        MatrixCursor r146 = new MatrixCursor(new String[]{"csr"});     // Catch: Exception -> L198
        MatrixCursor.RowBuilder r147 = r146.newRow();     // Catch: Exception -> L198
        a0 r50 = this.f631h;     // Catch: Exception -> L198
        if (r50 == null) goto L195;
        String r51 = r50.w();     // Catch: Exception -> L198
    L196:
        r147.add(r51);     // Catch: Exception -> L198
        return r146;
    L195:
        r51 = null;
    L198:
        e = e;
        r119 = s0.f1065a;
        r120 = "query csr failed";
        goto L200
    L202:
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r10 + ", ree_hmac");
        r131 = new MatrixCursor(new String[]{"ree_hmac_result", "exception_message"});
        String r148 = r10.getQueryParameter("content");     // Catch: Exception -> L214
        String r149 = r10.getQueryParameter("path");     // Catch: Exception -> L214
        if (r148 == null) goto L212;
        a0 r52 = this.f631h;     // Catch: Exception -> L214
        if (r52 == null) goto L210;
        if (r149 == null) goto L209;
        r2 = r149;
    L209:
        String r53 = r52.k(r148, r2);     // Catch: Exception -> L214
    L213:
        r16 = r53;
        r39 = null;
        goto L115
    L210:
        kotlin.n0.d.o.p();     // Catch: Exception -> L214
        throw null;
    L212:
        r53 = null;
    L214:
        e = move-exception;
        s0.f1065a.c("TicketGuardProvider", "query encrypt failed", e);
        r39 = e.getMessage();
        goto L115
    L216:
        kotlin.n0.d.o.v("uriMatcher");
        throw null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r9, ContentValues r10, String r11, String[] r12) {
        kotlin.n0.d.o.g(r9, "uri");
        b();
        UriMatcher r13 = this.f630g;
        if (r13 == null) goto L62;
        boolean r14 = true;
        switch(r13.match(r9)) {
            case 200: goto L30;
            case 201: goto L27;
            case 202: goto L24;
            case 203: goto L17;
            case 204: goto L61;
            case 205: goto L7;
            default: goto L61;
        };
    L7:
        String r15 = r9.getQueryParameter("sec_ts");
        s0.f1065a.a("TicketGuardProvider", "query, uri=" + r9 + ", update sec ts: " + r15);
        if (r15 != null) goto L10;
    L13:
        if (r14 == true) goto L61;
        a0 r8 = this.f631h;
        if (r8 == null) goto L61;
        k1.a.a(r8, r15, null, 2, null);
        goto L61
    L10:
        if (r15.length() == 0) goto L13;
        r14 = false;
        goto L13
    L17:
        s0.f1065a.a("TicketGuardProvider", "update tee ever fail");
        String r16 = r9.getQueryParameter("tee_fail_reason");
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        kotlin.n0.d.o.b(r16, "uri.getQueryParameter(PARAM_TEE_FAIL_REASON) ?: \"\"");
        a0 r17 = this.f631h;
        if (r17 == null) goto L61;
        r17.U(r16);
        goto L61
    L24:
        s0.f1065a.a("TicketGuardProvider", "clear server cert");
        a0 r18 = this.f631h;
        if (r18 == null) goto L61;
        r18.x0();
        goto L61
    L27:
        s0.f1065a.a("TicketGuardProvider", "update cert");
        String r19 = r9.getQueryParameter("client_cert");
        String r20 = r9.getQueryParameter("server_cert");
        a0 r21 = this.f631h;
        if (r21 == null) goto L61;
        r21.c(r19, r20);
        goto L61
    L30:
        s0.f1065a.a("TicketGuardProvider", "update, ticket data");
        String r3 = r9.getQueryParameter(WsConstants.KEY_CONNECTION_TYPE);
        String r4 = r9.getQueryParameter("ticket");
        String r5 = r9.getQueryParameter("ts_sign");
        String r6 = r9.getQueryParameter("ts_sign_ree");
        String r7 = r9.getQueryParameter("cert");
        if (r3 != null) goto L33;
    L36:
        boolean r22 = true;
    L37:
        if (r22 == true) goto L61;
        if (r4 != null) goto L40;
    L43:
        boolean r23 = true;
    L44:
        if (r23 == true) goto L61;
        if (r5 != null) goto L47;
    L50:
        boolean r24 = true;
    L51:
        if (r24 == false) goto L58;
        if (r6 != null) goto L54;
    L57:
        if (r14 == true) goto L61;
    L54:
        if (r6.length() == 0) goto L57;
        r14 = false;
    L58:
        a0 r25 = this.f631h;
        if (r25 == null) goto L61;
        r25.X(new w0(r3, r4, r5, r6, r7));
        goto L61
    L47:
        if (r5.length() == 0) goto L50;
        r24 = false;
        goto L51
    L40:
        if (r4.length() == 0) goto L43;
        r23 = false;
        goto L44
    L33:
        if (r3.length() == 0) goto L36;
        r22 = false;
    L61:
        return 0;
    L62:
        kotlin.n0.d.o.v("uriMatcher");
        throw null;
    }
}
