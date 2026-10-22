package com.bytedance.badger;

import android.content.Context;
import com.bytedance.badger.data.BadgerUpdateInfo;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\"\u0010#J/\u0010)\u001a\u00020(2\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000b0$j\u0002`&H&¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/bytedance/badger/IBadger;", "Lcom/bytedance/news/common/service/manager/IService;", "Lcom/bytedance/badger/a;", "initParams", "", "init", "(Lcom/bytedance/badger/a;)Z", "isInitialized", "()Z", "Lorg/json/JSONObject;", "config", "Lkotlin/f0;", "updateConfig", "(Lorg/json/JSONObject;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/badger/data/b;", "req", "", "waitTimeMs", "Lcom/bytedance/badger/data/a;", "getBadgerReport", "(Lcom/bytedance/badger/data/b;I)Lcom/bytedance/badger/data/a;", "Lcom/bytedance/badger/k/b;", "getNetRequestInterface", "()Lcom/bytedance/badger/k/b;", "Lcom/bytedance/badger/k/a;", "getLoginHandler", "()Lcom/bytedance/badger/k/a;", "initCore", "isLogin", "startPeriodicReport", "(Z)V", "getBadgerReportInstantly", "(Lcom/bytedance/badger/data/b;)Lcom/bytedance/badger/data/a;", "Lkotlin/Function1;", "Lcom/bytedance/badger/data/BadgerUpdateInfo;", "Lcom/bytedance/badger/data/BadgerUpdateCallback;", "fullCallback", "Lcom/bytedance/badger/data/d;", "awaitUpdateWithFullCallback", "(ILkotlin/n0/c/l;)Lcom/bytedance/badger/data/d;", "badger-api_release"}, k = 1, mv = {1, 1, 15})
public interface IBadger extends IService {
    com.bytedance.badger.data.d awaitUpdateWithFullCallback(int r1, l<? super BadgerUpdateInfo, f0> r2);

    com.bytedance.badger.data.a getBadgerReport(com.bytedance.badger.data.b r1, int r2);

    com.bytedance.badger.data.a getBadgerReportInstantly(com.bytedance.badger.data.b r1);

    Context getContext();

    com.bytedance.badger.k.a getLoginHandler();

    com.bytedance.badger.k.b getNetRequestInterface();

    boolean init(a r1);

    boolean initCore();

    boolean isInitialized();

    void startPeriodicReport(boolean r1);

    void updateConfig(JSONObject r1);
}
