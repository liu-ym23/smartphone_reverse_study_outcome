package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.ExecutorUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AccountCache extends Cache {
    private static final String TAG = "AccountCache";
    private Account mAccount;
    private final AccountManager mAccountManager;
    private final ConcurrentHashMap<String, String> mCache;
    private final String mSuffix;

    static /* synthetic */ ConcurrentHashMap access$000(AccountCache r0) {
        return r0.mCache;
    }

    static /* synthetic */ AccountManager access$100(AccountCache r0) {
        return r0.mAccountManager;
    }

    AccountCache(Context r2, String r3) {
        this.mCache = new ConcurrentHashMap();
        this.mAccountManager = AccountManager.get(r2);
        this.mSuffix = r3;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String r2, String r3) {
        String r4 = wrapKey(r2);
        Account r0 = this.mAccount;
        if (r0 != null) goto L6;
        this.mCache.put(r4, r3);
        return;
    L6:
        if (r3 != null) goto L13;
        return;
    L13:
        this.mAccountManager.setUserData(r0, r4, r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    private String wrapKey(String r2) {
        return r2 + this.mSuffix;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String r3) {
        String r4 = wrapKey(r3);
        String r0 = this.mCache.get(r4);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Account r1 = this.mAccount;
        if (r1 != null) goto L13;
        return null;
    L13:
        return this.mAccountManager.getUserData(r1, r4);
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String r1) {
        String r0 = getCachedString(r1);
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return null;
    L7:
        return r0.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String r2, String[] r3) {
        if (r2 == null) goto L7;
        if (r3 == null) goto L8;
        cacheString(r2, TextUtils.join("\n", r3));
        return;
    L8:
        return;
    }

    void setAccount(final Account r2) {
        if (r2 == null) goto L8;
        this.mAccount = r2;
        if (this.mCache.size() > 0) goto L6;
        return;
    L6:
        ExecutorUtil.runOnIOExecutor(new AnonymousClass1(this, r2));
        return;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r6.iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        String r1 = wrapKey(r0.next());
        this.mCache.remove(r1);
        Account r2 = this.mAccount;     // Catch: Exception -> L16
        if (r2 == null) goto L6;
        AccountManager r3 = this.mAccountManager;     // Catch: Exception -> L16
        if (r3 == null) goto L6;
        r3.setUserData(r2, r1, null);     // Catch: Exception -> L16
        goto L6
    L14:
        super.clear(r6);
    }
}
