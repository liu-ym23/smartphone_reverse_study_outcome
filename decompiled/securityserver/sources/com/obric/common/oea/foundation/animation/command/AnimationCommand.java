package com.obric.common.oea.foundation.animation.command;

import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AnimationCommand<T> {

    @Metadata
    public static final class SpringAnimationCommand<T> extends AnimationCommand<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f111a;
        public final Object b;
        public final Object c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass f112d;
        public final AnimationSpec e;
        public final Float f;

        public SpringAnimationCommand(FloatSpringSpec r2, Float r3, Float r4, Float r5, String r6, ClassReference r7) {
            Intrinsics.f(r6, "property");
            this.f111a = r6;
            this.b = r3;
            this.c = r4;
            this.f112d = r7;
            this.e = r2;
            this.f = r5;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public final AnimationInfo a() {
            Float r2 = (Float) this.b;
            Float r3 = (Float) this.c;
            FloatSpringSpec r1 = (FloatSpringSpec) this.e;
            ClassReference r6 = (ClassReference) this.f112d;
            String r5 = this.f111a;
            return new AnimationInfo(r1, r2, r3, this.f, r5, r6);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof SpringAnimationCommand) == false) goto L18;
            SpringAnimationCommand r4 = (SpringAnimationCommand) r3;
            String r0 = r4.f111a;
            if (Intrinsics.a(this.f111a, r0) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.a(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(this.f112d, r4.f112d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.a(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.a(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            int r0 = 0;
            String r1 = this.f111a;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = r2 * 31;
            Object r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Object r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass r10 = this.f112d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            AnimationSpec r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r0 = r16.hashCode();
        L26:
            return r15 + r0;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SpringAnimationCommand(property=" + this.f111a + ", initialValue=" + this.b + ", targetValue=" + this.c + ", valueClass=" + this.f112d + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }
    }

    @Metadata
    public static final class TweenAnimationCommand<T> extends AnimationCommand<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f113a;
        public final Object b;
        public final Object c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final KClass f114d;
        public final AnimationSpec e;
        public final Float f;

        public TweenAnimationCommand(FloatSpringSpec r2, Float r3, Float r4, Float r5, String r6, ClassReference r7) {
            Intrinsics.f(r6, "property");
            this.f113a = r6;
            this.b = r3;
            this.c = r4;
            this.f114d = r7;
            this.e = r2;
            this.f = r5;
        }

        @Override // com.obric.common.oea.foundation.animation.command.AnimationCommand
        public final AnimationInfo a() {
            Float r2 = (Float) this.b;
            Float r3 = (Float) this.c;
            FloatSpringSpec r1 = (FloatSpringSpec) this.e;
            ClassReference r6 = (ClassReference) this.f114d;
            String r5 = this.f113a;
            return new AnimationInfo(r1, r2, r3, this.f, r5, r6);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof TweenAnimationCommand) == false) goto L18;
            TweenAnimationCommand r4 = (TweenAnimationCommand) r3;
            String r0 = r4.f113a;
            if (Intrinsics.a(this.f113a, r0) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.a(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.a(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.a(this.f114d, r4.f114d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.a(this.e, r4.e) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.a(this.f, r4.f) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            int r0 = 0;
            String r1 = this.f113a;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = r2 * 31;
            Object r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Object r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            KClass r10 = this.f114d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            AnimationSpec r13 = this.e;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            Float r16 = this.f;
            if (r16 == null) goto L26;
            r0 = r16.hashCode();
        L26:
            return r15 + r0;
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TweenAnimationCommand(property=" + this.f113a + ", initialValue=" + this.b + ", targetValue=" + this.c + ", valueClass=" + this.f114d + ", spec=" + this.e + ", initialVelocity=" + this.f + ")";
        }
    }

    public abstract AnimationInfo a();
}
