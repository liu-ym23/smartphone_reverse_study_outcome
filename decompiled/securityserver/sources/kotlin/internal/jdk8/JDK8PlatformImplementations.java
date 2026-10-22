package kotlin.internal.jdk8;

import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.random.Random;
import kotlin.random.jdk8.PlatformThreadLocalRandom;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class JDK8PlatformImplementations extends JDK7PlatformImplementations {
    public JDK8PlatformImplementations() {
    }

    @Override // kotlin.internal.PlatformImplementations
    public final Random b() {
        return new PlatformThreadLocalRandom();
    }
}
