package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
interface Force {
    float getAcceleration(float r1, float r2);

    boolean isAtEquilibrium(float r1, float r2);
}
