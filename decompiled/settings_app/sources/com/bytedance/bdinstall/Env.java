package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes3.dex */
public class Env extends AbsEnv {
    public static Env CHINA;
    public static Env CHINA_BOE;
    public static final Env DEFAULT = null;

    static {
        CHINA = new Env(InstallUrl.createUriByDomain("https://log.snssdk.com"), false, false);
        CHINA_BOE = new Env(InstallUrl.createUriByDomain("https://boe.i.snssdk.com"), false, true);
        DEFAULT = CHINA;
    }

    public Env(InstallUrl r2, boolean r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public Env(InstallUrl r1, boolean r2, boolean r3, boolean r4) {
        super(r1, r2, r3, r4);
    }
}
