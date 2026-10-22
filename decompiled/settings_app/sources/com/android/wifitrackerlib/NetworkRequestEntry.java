package com.android.wifitrackerlib;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRequestEntry extends StandardWifiEntry {
    public static final String KEY_PREFIX = "NetworkRequestEntry:";

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public boolean canForget() {
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public boolean canSetAutoJoinEnabled() {
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public boolean canSetMeteredChoice() {
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public boolean canSetPrivacy() {
        return false;
    }

    @Override // com.android.wifitrackerlib.WifiEntry
    public boolean isSubscription() {
        return false;
    }

    NetworkRequestEntry(WifiTrackerInjector r1, Handler r2, StandardWifiEntry.StandardWifiEntryKey r3, WifiManager r4, boolean r5) throws IllegalArgumentException {
        super(r1, r2, r3, r4, r5);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isMetered() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSaved() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isSuggestion() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized WifiConfiguration getWifiConfiguration() {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canConnect() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void connect(WifiEntry.ConnectCallback r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void forget(WifiEntry.ForgetCallback r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canShare() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean canEasyConnect() {
        monitor-enter(this);
        monitor-exit(this);
        return false;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized int getMeteredChoice() {
        monitor-enter(this);
        monitor-exit(this);
        return 0;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void setMeteredChoice(int r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized int getPrivacy() {
        monitor-enter(this);
        monitor-exit(this);
        return 1;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void setPrivacy(int r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized boolean isAutoJoinEnabled() {
        monitor-enter(this);
        monitor-exit(this);
        return true;
    }

    @Override // com.android.wifitrackerlib.StandardWifiEntry, com.android.wifitrackerlib.WifiEntry
    public synchronized void setAutoJoinEnabled(boolean r1) {
        monitor-enter(this);
        monitor-exit(this);
    }
}
