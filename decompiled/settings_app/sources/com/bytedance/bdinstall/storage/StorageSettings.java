package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.InstallOptions;

/* JADX INFO: loaded from: classes3.dex */
public class StorageSettings {
    private Account account;
    private String fileName;
    private boolean isAnonymous;
    private boolean isLocalTest;
    private boolean needSharedStorage;
    private InstallOptions options;
    private SharedPreferences sp;
    private String suffix;

    public StorageSettings() {
        this.needSharedStorage = false;
    }

    String getFileName() {
        return this.fileName;
    }

    public void setFileName(String r1) {
        this.fileName = r1;
    }

    public SharedPreferences getSp() {
        return this.sp;
    }

    public void setSp(SharedPreferences r1) {
        this.sp = r1;
    }

    boolean isLocalTest() {
        return this.isLocalTest;
    }

    public void setLocalTest(boolean r1) {
        this.isLocalTest = r1;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    void setAnonymous(boolean r1) {
        this.isAnonymous = r1;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account r1, String r2) {
        this.account = r1;
        this.suffix = r2;
    }

    String getSuffix() {
        return this.suffix;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public void setNeedSharedStorage(boolean r1) {
        this.needSharedStorage = r1;
    }

    public void setOptions(InstallOptions r1) {
        this.options = r1;
    }

    public InstallOptions getOptions() {
        return this.options;
    }
}
