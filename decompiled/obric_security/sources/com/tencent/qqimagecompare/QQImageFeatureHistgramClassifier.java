package com.tencent.qqimagecompare;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageFeatureHistgramClassifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f26a;
    private IClassifyCallback b;
    private Object c;
    private int d;
    private int e;

    public interface IClassifyCallback {
        void OnStep(int r1, Object r2);
    }

    public QQImageFeatureHistgramClassifier() {
        this.e = 80;
        this.f26a = new ArrayList();
    }

    public void addFeature(QQImageFeatureHSV r2) {
        this.f26a.add(r2);
        this.d = this.f26a.size();
    }

    public ArrayList<ArrayList<QQImageFeatureHSV>> classify() {
        ArrayList<ArrayList<QQImageFeatureHSV>> r0 = new ArrayList();
        if (this.f26a.size() <= 0) goto L19;
    L4:
        int r1 = this.f26a.size();
        if (r1 == 1) goto L6;
        if (r1 <= 1) goto L19;
        ArrayList<QQImageFeatureHSV> r2 = new ArrayList();
        QQImageFeatureHSV r3 = (QQImageFeatureHSV) this.f26a.remove(0);
        r2.add(r3);
        Iterator r4 = this.f26a.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        QQImageFeatureHSV r5 = (QQImageFeatureHSV) r4.next();
        if (r3.compare(r5) < this.e) goto L12;
        r2.add(r5);
        r4.remove();
        goto L12
    L16:
        r0.add(r2);
        if (this.b == null) goto L4;
    L18:
        int r6 = ((this.d - this.f26a.size()) * 100) / this.d;
        this.b.OnStep(r6, this.c);
        goto L4
    L6:
        ArrayList<QQImageFeatureHSV> r7 = new ArrayList();
        r7.add((QQImageFeatureHSV) this.f26a.remove(0));
        r0.add(r7);
        if (this.b == null) goto L4;
    L19:
        return r0;
    }

    public void setClassifyCallback(IClassifyCallback r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    public void setThreshold(int r1) {
        this.e = r1;
    }
}
