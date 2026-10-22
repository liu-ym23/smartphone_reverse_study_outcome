package com.bytedance.badger;

import android.content.Context;
import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b<\u0010=J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b#\u0010\"J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010'H\u0096\u0001¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b+\u0010\"JT\u00103\u001a\u00020\u00072\u0006\u0010-\u001a\u00020,2\u001c\u00101\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0/0.j\u0002`02\u001c\u00102\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,0/0.j\u0002`0H\u0096\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b5\u0010\"J \u0010:\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0096\u0001¢\u0006\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/badger/Badger;", "Lcom/bytedance/badger/IBadger;", "Lcom/bytedance/badger/k/a;", "", "waitTimeMs", "Lkotlin/Function1;", "Lcom/bytedance/badger/data/BadgerUpdateInfo;", "Lkotlin/f0;", "Lcom/bytedance/badger/data/BadgerUpdateCallback;", "fullCallback", "Lcom/bytedance/badger/data/d;", "awaitUpdateWithFullCallback", "(ILkotlin/n0/c/l;)Lcom/bytedance/badger/data/d;", "Lcom/bytedance/badger/data/b;", "req", "Lcom/bytedance/badger/data/a;", "getBadgerReport", "(Lcom/bytedance/badger/data/b;I)Lcom/bytedance/badger/data/a;", "getBadgerReportInstantly", "(Lcom/bytedance/badger/data/b;)Lcom/bytedance/badger/data/a;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getLoginHandler", "()Lcom/bytedance/badger/k/a;", "Lcom/bytedance/badger/k/b;", "getNetRequestInterface", "()Lcom/bytedance/badger/k/b;", "Lcom/bytedance/badger/a;", "initParams", "", "init", "(Lcom/bytedance/badger/a;)Z", "initCore", "()Z", "isInitialized", "isLogin", "startPeriodicReport", "(Z)V", "Lorg/json/JSONObject;", "config", "updateConfig", "(Lorg/json/JSONObject;)V", "checkUnfinishedTasks", "", WsConstants.KEY_CONNECTION_URL, "", "Lkotlin/u;", "Lcom/bytedance/badger/network/Headers;", "requestHeaders", "responseHeaders", "handleResponse", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "invalidateRecord", "Lcom/bytedance/badger/data/e;", "request", "", "delayMs", "sendFollowUpRequest", "(Lcom/bytedance/badger/data/e;J)V", "<init>", "()V", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public final class Badger implements IBadger, com.bytedance.badger.k.a {
    public static final Badger INSTANCE = null;
    private final /* synthetic */ IBadger $$delegate_0;
    private final /* synthetic */ com.bytedance.badger.k.a $$delegate_1;

    static {
        INSTANCE = new Badger();
    }

    private Badger() {
        this.$$delegate_0 = b.a();
        this.$$delegate_1 = b.a().getLoginHandler();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.d awaitUpdateWithFullCallback(int r2, l<? super BadgerUpdateInfo, f0> r3) {
        o.g(r3, "fullCallback");
        return this.$$delegate_0.awaitUpdateWithFullCallback(r2, r3);
    }

    @Override // com.bytedance.badger.k.a
    public boolean checkUnfinishedTasks() {
        return this.$$delegate_1.checkUnfinishedTasks();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.a getBadgerReport(com.bytedance.badger.data.b r2, int r3) {
        o.g(r2, "req");
        return this.$$delegate_0.getBadgerReport(r2, r3);
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.data.a getBadgerReportInstantly(com.bytedance.badger.data.b r2) {
        o.g(r2, "req");
        return this.$$delegate_0.getBadgerReportInstantly(r2);
    }

    @Override // com.bytedance.badger.IBadger
    public Context getContext() {
        return this.$$delegate_0.getContext();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.k.a getLoginHandler() {
        return this.$$delegate_0.getLoginHandler();
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.k.b getNetRequestInterface() {
        return this.$$delegate_0.getNetRequestInterface();
    }

    @Override // com.bytedance.badger.k.a
    public void handleResponse(String r2, List<u<String, String>> r3, List<u<String, String>> r4) {
        o.g(r2, WsConstants.KEY_CONNECTION_URL);
        o.g(r3, "requestHeaders");
        o.g(r4, "responseHeaders");
        this.$$delegate_1.handleResponse(r2, r3, r4);
    }

    @Override // com.bytedance.badger.IBadger
    public boolean init(a r2) {
        o.g(r2, "initParams");
        return this.$$delegate_0.init(r2);
    }

    @Override // com.bytedance.badger.IBadger
    public boolean initCore() {
        return this.$$delegate_0.initCore();
    }

    @Override // com.bytedance.badger.k.a
    public boolean invalidateRecord() {
        return this.$$delegate_1.invalidateRecord();
    }

    @Override // com.bytedance.badger.IBadger
    public boolean isInitialized() {
        return this.$$delegate_0.isInitialized();
    }

    @Override // com.bytedance.badger.k.a
    public void sendFollowUpRequest(com.bytedance.badger.data.e r2, long r3) {
        o.g(r2, "request");
        this.$$delegate_1.sendFollowUpRequest(r2, r3);
    }

    @Override // com.bytedance.badger.IBadger
    public void startPeriodicReport(boolean r1) {
        this.$$delegate_0.startPeriodicReport(r1);
    }

    @Override // com.bytedance.badger.IBadger
    public void updateConfig(JSONObject r1) {
        this.$$delegate_0.updateConfig(r1);
    }
}
