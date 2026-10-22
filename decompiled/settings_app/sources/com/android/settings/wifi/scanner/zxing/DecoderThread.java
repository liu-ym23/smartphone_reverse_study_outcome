package com.android.settings.wifi.scanner.zxing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecoderThread.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/scanner/zxing/DecoderThread;", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "interruptFlag", "", "(Ljava/lang/Runnable;Z)V", "getInterrupt", "setInterrupt", "", "interrupt", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DecoderThread extends Thread {
    private boolean interruptFlag;

    public DecoderThread(Runnable r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "r");
        super(r2);
        this.interruptFlag = r3;
    }

    public final void setInterrupt(boolean r1) {
        this.interruptFlag = r1;
    }

    public final boolean getInterrupt() {
        return this.interruptFlag;
    }
}
