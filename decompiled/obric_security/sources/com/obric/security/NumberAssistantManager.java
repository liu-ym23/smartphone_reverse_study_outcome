package com.obric.security;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bytedanceos.app.numberassistant.NumberAssistantCallback;
import bytedanceos.app.numberassistant.NumberAssistantProxy;
import bytedanceos.util.ExecutorUtils;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.INumberCheckManager;
import com.obric.securitycenter.api.NumberMarkClassifyListener;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class NumberAssistantManager implements INumberCheckManager {
    private static final String TAG = "NumberAssistantManager";
    private boolean mIsNumberAssistantReady;
    private ExecutorService mNumberAssistantSyncExecutor;
    private NumberMarkClassifyListener pendingCallBack;
    private Bundle pendingExtra;
    private String pendingNumber;
    private boolean pendingNumberQueryWorker;
    private NumberAssistantProxy.BindCallback sBindCallback;
    private NumberAssistantProxy sNumberAssistantProxy;

    private static final class Hold {
        private static NumberAssistantManager sInstance;

        private Hold() {
        }

        static /* synthetic */ NumberAssistantManager access$600() {
            return sInstance;
        }

        static {
            sInstance = new NumberAssistantManager(null);
        }
    }

    static {
    }

    /* synthetic */ NumberAssistantManager(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ boolean access$102(NumberAssistantManager r0, boolean r1) {
        r0.mIsNumberAssistantReady = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200(NumberAssistantManager r0) {
        return r0.pendingNumberQueryWorker;
    }

    static /* synthetic */ String access$300(NumberAssistantManager r0) {
        return r0.pendingNumber;
    }

    static /* synthetic */ Bundle access$400(NumberAssistantManager r0) {
        return r0.pendingExtra;
    }

    static /* synthetic */ NumberMarkClassifyListener access$700(NumberAssistantManager r0) {
        return r0.pendingCallBack;
    }

    static /* synthetic */ NumberMarkClassifyListener access$702(NumberAssistantManager r0, NumberMarkClassifyListener r1) {
        r0.pendingCallBack = r1;
        return r1;
    }

    static /* synthetic */ NumberAssistantProxy access$800(NumberAssistantManager r0) {
        return r0.sNumberAssistantProxy;
    }

    @Override // com.obric.securitycenter.api.INumberCheckManager
    public void init(Context context) {
        this.sBindCallback = new AnonymousClass1(this);
        NumberAssistantProxy r0 = NumberAssistantProxy.getInstance();
        this.sNumberAssistantProxy = r0;
        r0.bind(context, this.sBindCallback);
    }

    @Override // com.obric.securitycenter.api.INumberCheckManager
    public void onDestroy() {
        NumberAssistantProxy r0 = this.sNumberAssistantProxy;
        if (r0 == null) goto L6;
        r0.unbind();
        return;
    }

    public static NumberAssistantManager getInstance() {
        return Hold.access$600();
    }

    private NumberAssistantManager() {
        this.pendingNumberQueryWorker = false;
        this.pendingCallBack = null;
        this.pendingNumber = "";
        this.pendingExtra = null;
        this.mNumberAssistantSyncExecutor = ExecutorUtils.newSingleThreadExecutor("number_assistant_query");
    }

    @Override // com.obric.securitycenter.api.INumberCheckManager
    public void queryNumberMarkClassify(String number, Bundle extra, NumberMarkClassifyListener callback) {
        OLog.d("_CallSmsIntercept", "queryNumberMarkClassify mIsNumberAssistantReady: " + this.mIsNumberAssistantReady);
        if (this.mIsNumberAssistantReady == true) goto L6;
        this.pendingNumber = number;
        this.pendingExtra = extra;
        this.pendingNumberQueryWorker = true;
        return;
    L6:
        this.pendingCallBack = callback;
        this.pendingNumberQueryWorker = false;
        queryNumberMarkClassify(number, extra);
    }

    public void queryNumberMarkClassify(final String number, final Bundle extra) {
        this.pendingNumberQueryWorker = false;
        if (TextUtils.isEmpty(number) == false) goto L5;
        return;
    L5:
        final NumberAssistantCallback r6 = new AnonymousClass2(this, number);
        final NumberQueryWorker r3 = new NumberQueryWorker();
        this.mNumberAssistantSyncExecutor.execute(new AnonymousClass3(this, r3, number, extra, r6));
    }
}
