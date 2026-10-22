package org.apache.commons.math3.geometry.spherical.twod;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.spherical.oned.Sphere1D;

/* JADX INFO: loaded from: classes6.dex */
public class Sphere2D implements Serializable, Space {
    private static final long serialVersionUID = 20131218;

    /* JADX INFO: renamed from: org.apache.commons.math3.geometry.spherical.twod.Sphere2D$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final Sphere2D INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ Sphere2D access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new Sphere2D(null);
        }
    }

    @Override // org.apache.commons.math3.geometry.Space
    public int getDimension() {
        return 2;
    }

    /* synthetic */ Sphere2D(AnonymousClass1 r1) {
        this();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public /* bridge */ /* synthetic */ Space getSubSpace() throws MathUnsupportedOperationException {
        return getSubSpace();
    }

    private Sphere2D() {
    }

    public static Sphere2D getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.geometry.Space
    public Sphere1D getSubSpace() {
        return Sphere1D.getInstance();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
