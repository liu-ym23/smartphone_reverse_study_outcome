package com.android.settingslib.suggestions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Process;
import android.service.settings.suggestions.ISuggestionService;
import android.service.settings.suggestions.Suggestion;
import com.GlobalProxyLancet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuggestionController {
    private static final boolean DEBUG = false;
    private static final String TAG = "SuggestionController";
    private ServiceConnectionListener mConnectionListener;
    private final Context mContext;
    private ISuggestionService mRemoteService;
    private ServiceConnection mServiceConnection;
    private final Intent mServiceIntent;

    public interface ServiceConnectionListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    static /* synthetic */ ISuggestionService access$002(SuggestionController r0, ISuggestionService r1) {
        r0.mRemoteService = r1;
        return r1;
    }

    static /* synthetic */ ServiceConnectionListener access$100(SuggestionController r0) {
        return r0.mConnectionListener;
    }

    public SuggestionController(Context r1, ComponentName r2, ServiceConnectionListener r3) {
        this.mContext = r1.getApplicationContext();
        this.mConnectionListener = r3;
        this.mServiceIntent = new Intent().setComponent(r2);
        this.mServiceConnection = createServiceConnection();
    }

    public void start() {
        this.mContext.bindServiceAsUser(this.mServiceIntent, this.mServiceConnection, 1, Process.myUserHandle());
    }

    public void stop() {
        if (this.mRemoteService == null) goto L6;
        this.mRemoteService = null;
        this.mContext.unbindService(this.mServiceConnection);
        return;
    }

    public List<Suggestion> getSuggestions() {
        if (isReady() == true) goto L13;
        return null;
    L13:
        return this.mRemoteService.getSuggestions();
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error when calling getSuggestion()", e);
        return null;
    L10:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "mRemote service detached before able to query", e);
        return null;
    }

    public void dismissSuggestions(Suggestion r3) {
        if (isReady() == true) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "SuggestionController not ready, cannot dismiss " + r3.getId());
        return;
    L11:
        this.mRemoteService.dismissSuggestion(r3);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error when calling dismissSuggestion()", e);
    }

    public void launchSuggestion(Suggestion r3) {
        if (isReady() == true) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "SuggestionController not ready, cannot launch " + r3.getId());
        return;
    L11:
        this.mRemoteService.launchSuggestion(r3);     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Error when calling launchSuggestion()", e);
    }

    private boolean isReady() {
        if (this.mRemoteService == null) goto L5;
        return true;
    L5:
        return false;
    }

    private ServiceConnection createServiceConnection() {
        return new AnonymousClass1(this);
    }
}
