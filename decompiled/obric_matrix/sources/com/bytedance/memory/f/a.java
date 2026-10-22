package com.bytedance.memory.f;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f5021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f5022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InterfaceC0157a f5023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5024l;

    /* JADX INFO: renamed from: com.bytedance.memory.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0157a {
        boolean a(File r1);
    }

    public interface b {
        boolean a(File r1, File r2);
    }

    public a() {
        this.f5019g = false;
        this.f5020h = 200;
        this.f5021i = 90;
        this.f5024l = 1;
    }

    public boolean a() {
        return this.f5019g;
    }

    public InterfaceC0157a b() {
        return this.f5023k;
    }

    public int c() {
        return this.f5021i;
    }

    public int d() {
        return this.f5020h;
    }

    public int e() {
        return this.f5024l;
    }

    public b f() {
        return this.f5022j;
    }

    public boolean g() {
        return this.f5018f;
    }

    public void h(boolean r1) {
        this.f5019g = r1;
    }

    public void i(int r1) {
        this.f5021i = r1;
    }

    public void j(int r1) {
        this.f5020h = r1;
    }

    public void k(int r1) {
        this.f5024l = r1;
    }
}
