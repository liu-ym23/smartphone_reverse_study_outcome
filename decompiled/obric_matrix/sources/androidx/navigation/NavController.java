package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.annotation.NavigationRes;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import h.a.e3.e;
import h.a.e3.m;
import h.a.e3.n;
import h.a.e3.t;
import h.a.e3.v;
import h.a.e3.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i;
import kotlin.i0.h;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.a0;
import kotlin.n0.d.b0;
import kotlin.n0.d.g;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.t0.k;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Å\u00012\u00020\u0001:\u0006Å\u0001Æ\u0001Ç\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010p\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\b\u0010r\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0015\u001a\u00020\u00072\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u0010\u0010t\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0012\u0010v\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0010\u0010v\u001a\u0002062\u0006\u0010x\u001a\u00020 H\u0007J\u0012\u0010y\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0003J\b\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u000206H\u0002J\u0010\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u000206H\u0017J\u0014\u0010\u007f\u001a\u0004\u0018\u0001022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0013\u0010\u007f\u001a\u0004\u0018\u0001022\u0007\u0010\u0080\u0001\u001a\u00020 H\u0007J\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010\u0084\u0001\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u001fH\u0016J\u000f\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010x\u001a\u00020 J\u0015\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\b\u0001\u0010\u0087\u0001\u001a\u00020\u001fH\u0016J\u0015\u0010\u0088\u0001\u001a\u0002062\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0017J \u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000f\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018H\u0002J\u001b\u0010\u008d\u0001\u001a\u00020\u00162\u0007\u0010\u008e\u0001\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J4\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0003J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J\u001d\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0017J\u0014\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001fH\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J7\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J-\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0007J+\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\u001a\u0010\u009c\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0003\b\u009e\u0001J\t\u0010\u009f\u0001\u001a\u000206H\u0017J\u0014\u0010 \u0001\u001a\u00020\u00162\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0003J\t\u0010¢\u0001\u001a\u000206H\u0017J\u001c\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\u0006\u0010x\u001a\u00020 2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0007J'\u0010¥\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160§\u0001H\u0000¢\u0006\u0003\b¨\u0001J'\u0010©\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0003J-\u0010ª\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\t\b\u0002\u0010¤\u0001\u001a\u0002062\u000f\b\u0002\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0002J\u0015\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0000¢\u0006\u0003\b\u00ad\u0001J\u0011\u0010®\u0001\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0014\u0010¯\u0001\u001a\u00020\u00162\t\u0010°\u0001\u001a\u0004\u0018\u00010\\H\u0017J5\u0010±\u0001\u001a\u0002062\u0007\u0010²\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u001b\u0010@\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\t2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0013\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001fH\u0017J\u001e\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001f2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0012\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020MH\u0017J\u0012\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020`H\u0017J\u0013\u0010¸\u0001\u001a\u00020\u00162\b\u0010¹\u0001\u001a\u00030º\u0001H\u0017J\t\u0010»\u0001\u001a\u000206H\u0002J\t\u0010¼\u0001\u001a\u000206H\u0002J\u001a\u0010½\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b¾\u0001J\u000f\u0010¿\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\bÀ\u0001J\t\u0010Á\u0001\u001a\u00020\u0016H\u0002J\u0018\u0010\u007f\u001a\u0004\u0018\u000102*\u0002022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0002Jb\u0010Â\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012H\u0002JL\u0010©\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\u0006\u0010g\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u0002062$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00160\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t8W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020C8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR$\u0010S\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b8V@WX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002020Y\u0012\b\u0012\u00060ZR\u00020\u00000\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010,R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006È\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/navigation/NavBackStackEntry;", "_graph", "Landroidx/navigation/NavGraph;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "_visibleEntries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "activity", "Landroid/app/Activity;", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "", "backQueue", "Lkotlin/collections/ArrayDeque;", "getBackQueue", "()Lkotlin/collections/ArrayDeque;", "backStackEntriesToDispatch", "", "backStackMap", "", "", "", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "backStackToRestore", "", "Landroid/os/Parcelable;", "[Landroid/os/Parcelable;", "childToParentEntries", "getContext", "()Landroid/content/Context;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentDestination", "Landroidx/navigation/NavDestination;", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "deepLinkHandled", "", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "dispatchReentrantCount", "enableOnBackPressedCallback", "entrySavedState", "graph", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "inflater", "Landroidx/navigation/NavInflater;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorStateToRestore", "Landroid/os/Bundle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "parentToChildCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "popFromBackStackHandler", "popUpTo", "previousBackStackEntry", "getPreviousBackStackEntry", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "visibleEntries", "Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "addEntryToBackStack", "node", "finalArgs", "restoredEntries", "addOnDestinationChangedListener", "listener", "clearBackStack", "destinationId", "route", "clearBackStackInternal", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "dispatchOnDestinationChanged", "enableOnBackPressed", "enabled", "findDestination", "destinationRoute", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "getBackStackEntry", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "handleDeepLink", "intent", "Landroid/content/Intent;", "instantiateBackStack", "backStackState", "linkChildToParent", "child", "parent", "navigate", "Landroid/net/Uri;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "args", "directions", "Landroidx/navigation/NavDirections;", "resId", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigateUp", "onGraphCreated", "startDestinationArgs", "popBackStack", "inclusive", "saveState", "popBackStackFromNavigator", "onComplete", "Lkotlin/Function0;", "popBackStackFromNavigator$navigation_runtime_release", "popBackStackInternal", "popEntryFromBackStack", "savedState", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "removeOnDestinationChangedListener", "restoreState", "navState", "restoreStateInternal", "id", "graphResId", "setLifecycleOwner", "owner", "setOnBackPressedDispatcher", "dispatcher", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "updateOnBackPressedCallbackEnabled", "navigateInternal", "entries", "handler", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class NavController {
    public static final Companion Companion = null;
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private static boolean deepLinkSaveState;
    private final m<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final n<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private l<? super NavBackStackEntry, f0> addToBackStackHandler;
    private final h<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, h<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final e<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final kotlin.h navInflater$delegate;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private l<? super NavBackStackEntry, f0> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final v<List<NavBackStackEntry>> visibleEntries;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "()V", "KEY_BACK_STACK", "", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean r1) {
            NavController.access$setDeepLinkSaveState$cp(r1);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "addInternal", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "createBackStackEntry", "destination", "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "entry", "pop", "popUpTo", "saveState", "", "popWithTransition", "push", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public NavControllerNavigatorState(NavController r2, Navigator<? extends NavDestination> r3) {
            o.f(r3, "navigator");
            this.this$0 = r2;
            this.navigator = r3;
        }

        public static final /* synthetic */ void access$pop$s261051546(NavControllerNavigatorState r0, NavBackStackEntry r1, boolean r2) {
            super.pop(r1, r2);
        }

        public final void addInternal(NavBackStackEntry r2) {
            o.f(r2, "backStackEntry");
            super.push(r2);
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination r12, Bundle r13) {
            o.f(r12, "destination");
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), r12, r13, this.this$0.getHostLifecycleState$navigation_runtime_release(), NavController.access$getViewModel$p(this.this$0), null, null, 96, null);
        }

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry r6) {
            o.f(r6, "entry");
            boolean r0 = o.a(NavController.access$getEntrySavedState$p(this.this$0).get(r6), Boolean.TRUE);
            super.markTransitionComplete(r6);
            NavController.access$getEntrySavedState$p(this.this$0).remove(r6);
            if (this.this$0.getBackQueue().contains(r6) == true) goto L24;
            this.this$0.unlinkChildFromParent$navigation_runtime_release(r6);
            if (r6.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
            r6.setMaxLifecycle(Lifecycle.State.DESTROYED);
        L7:
            h<NavBackStackEntry> r1 = this.this$0.getBackQueue();
            boolean r3 = true;
            if ((r1 instanceof Collection) == true) goto L10;
        L12:
            Iterator<NavBackStackEntry> r2 = r1.iterator();
        L14:
            if (r2.hasNext() == false) goto L18;
            if (o.a(r2.next().getId(), r6.getId()) == false) goto L14;
            r3 = false;
        L18:
            if (r3 == false) goto L25;
            if (r0 == true) goto L25;
            NavControllerViewModel r4 = NavController.access$getViewModel$p(this.this$0);
            if (r4 == null) goto L25;
            r4.clear(r6.getId());
        L25:
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            NavController.access$get_visibleEntries$p(this.this$0).a(this.this$0.populateVisibleEntries$navigation_runtime_release());
            return;
        L10:
            if (r1.isEmpty() == false) goto L12;
        L24:
            if (isNavigating() == false) goto L25;
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(NavBackStackEntry r3, boolean r4) {
            o.f(r3, "popUpTo");
            Navigator r0 = NavController.access$get_navigatorProvider$p(this.this$0).getNavigator(r3.getDestination().getNavigatorName());
            if (o.a(r0, this.navigator) == false) goto L8;
            l r1 = NavController.access$getPopFromBackStackHandler$p(this.this$0);
            if (r1 == null) goto L7;
            r1.invoke(r3);
            super.pop(r3, r4);
            return;
        L7:
            this.this$0.popBackStackFromNavigator$navigation_runtime_release(r3, new NavController$NavControllerNavigatorState$pop$1(this, r3, r4));
            return;
        L8:
            Object r2 = NavController.access$getNavigatorState$p(this.this$0).get(r0);
            o.c(r2);
            ((NavControllerNavigatorState) r2).pop(r3, r4);
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry r2, boolean r3) {
            o.f(r2, "popUpTo");
            super.popWithTransition(r2, r3);
            Boolean r4 = Boolean.valueOf(r3);
            NavController.access$getEntrySavedState$p(this.this$0).put(r2, r4);
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry r3) {
            o.f(r3, "backStackEntry");
            Navigator r0 = NavController.access$get_navigatorProvider$p(this.this$0).getNavigator(r3.getDestination().getNavigatorName());
            if (o.a(r0, this.navigator) == false) goto L8;
            l r1 = NavController.access$getAddToBackStackHandler$p(this.this$0);
            if (r1 == null) goto L7;
            r1.invoke(r3);
            addInternal(r3);
            return;
        L7:
            Log.i(NavController.TAG, "Ignoring add of destination " + r3.getDestination() + " outside of the call to navigate(). ");
            return;
        L8:
            Object r2 = NavController.access$getNavigatorState$p(this.this$0).get(r0);
            if (r2 == null) goto L13;
            ((NavControllerNavigatorState) r2).push(r3);
            return;
        L13:
            throw new IllegalStateException(("NavigatorBackStack for " + r3.getDestination().getNavigatorName() + " should already be created").toString());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController r1, NavDestination r2, Bundle r3);
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2 extends q implements l<NavOptionsBuilder, f0> {
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/AnimBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class AnonymousClass1 extends q implements l<AnimBuilder, f0> {
            public static final AnonymousClass1 INSTANCE = null;

            static {
                INSTANCE = new AnonymousClass1();
            }

            AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(AnimBuilder r1) {
                invoke2(r1);
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimBuilder r1) {
                o.f(r1, "$this$anim");
                r1.setEnter(0);
                r1.setExit(0);
            }
        }

        /* JADX INFO: renamed from: androidx.navigation.NavController$handleDeepLink$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/PopUpToBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C00202 extends q implements l<PopUpToBuilder, f0> {
            public static final C00202 INSTANCE = null;

            static {
                INSTANCE = new C00202();
            }

            C00202() {
                super(1);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(PopUpToBuilder r1) {
                invoke2(r1);
                return f0.f18324a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopUpToBuilder r1) {
                o.f(r1, "$this$popUpTo");
                r1.setSaveState(true);
            }
        }

        AnonymousClass2(NavDestination r1, NavController r2) {
            this.$node = r1;
            this.this$0 = r2;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavOptionsBuilder r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavOptionsBuilder r7) {
            o.f(r7, "$this$navOptions");
            r7.anim(AnonymousClass1.INSTANCE);
            NavDestination r0 = this.$node;
            boolean r2 = true;
            if ((r0 instanceof NavGraph) == false) goto L17;
            kotlin.t0.h<NavDestination> r1 = NavDestination.Companion.getHierarchy(r0);
            NavController r3 = this.this$0;
            Iterator<NavDestination> r4 = r1.iterator();
        L6:
            if (r4.hasNext() == false) goto L14;
            NavDestination r5 = r4.next();
            NavDestination r6 = r3.getCurrentDestination();
            if (r6 == null) goto L10;
            NavGraph r8 = r6.getParent();
        L12:
            if (o.a(r5, r8) == false) goto L6;
            boolean r9 = false;
        L15:
            if (r9 == false) goto L17;
        L18:
            if (r2 == true) goto L20;
            return;
        L20:
            if (NavController.access$getDeepLinkSaveState$cp() == false) goto L27;
            r7.popUpTo(NavGraph.Companion.findStartDestination(this.this$0.getGraph()).getId(), C00202.INSTANCE);
            return;
        L27:
            return;
        L10:
            r8 = null;
            goto L12
        L14:
            r9 = true;
        L17:
            r2 = false;
            goto L18
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass4 extends q implements l<NavBackStackEntry, f0> {
        final /* synthetic */ Bundle $finalArgs;
        final /* synthetic */ a0 $navigated;
        final /* synthetic */ NavDestination $node;
        final /* synthetic */ NavController this$0;

        AnonymousClass4(a0 r1, NavController r2, NavDestination r3, Bundle r4) {
            this.$navigated = r1;
            this.this$0 = r2;
            this.$node = r3;
            this.$finalArgs = r4;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavBackStackEntry r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry r10) {
            o.f(r10, "it");
            this.$navigated.f18427f = true;
            NavController.addEntryToBackStack$default(this.this$0, this.$node, this.$finalArgs, r10, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$navigateInternal$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends q implements l<NavBackStackEntry, f0> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavBackStackEntry r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06311 extends q implements l<NavBackStackEntry, f0> {
        public static final C06311 INSTANCE = null;

        static {
            INSTANCE = new C06311();
        }

        C06311() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavBackStackEntry r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry r1) {
            o.f(r1, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06322 extends q implements l<NavBackStackEntry, f0> {
        final /* synthetic */ a0 $popped;
        final /* synthetic */ a0 $receivedPop;
        final /* synthetic */ boolean $saveState;
        final /* synthetic */ h<NavBackStackEntryState> $savedState;
        final /* synthetic */ NavController this$0;

        C06322(a0 r1, a0 r2, NavController r3, boolean r4, h<NavBackStackEntryState> r5) {
            this.$receivedPop = r1;
            this.$popped = r2;
            this.this$0 = r3;
            this.$saveState = r4;
            this.$savedState = r5;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavBackStackEntry r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry r3) {
            o.f(r3, "entry");
            this.$receivedPop.f18427f = true;
            this.$popped.f18427f = true;
            NavController.access$popEntryFromBackStack(this.this$0, r3, this.$saveState, this.$savedState);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass3 extends q implements l<NavDestination, NavDestination> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NavDestination invoke2(NavDestination r3) {
            o.f(r3, "destination");
            NavGraph r2 = r3.getParent();
            boolean r0 = false;
            if (r2 != null) goto L5;
        L7:
            if (r0 == true) goto L11;
            return null;
        L11:
            return r3.getParent();
        L5:
            if (r2.getStartDestinationId() != r3.getId()) goto L7;
            r0 = true;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ NavDestination invoke(NavDestination r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06334 extends q implements l<NavDestination, Boolean> {
        final /* synthetic */ NavController this$0;

        C06334(NavController r1) {
            this.this$0 = r1;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(NavDestination r2) {
            o.f(r2, "destination");
            return Boolean.valueOf(!NavController.access$getBackStackMap$p(this.this$0).containsKey(Integer.valueOf(r2.getId())));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(NavDestination r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/navigation/NavDestination;", "destination", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass6 extends q implements l<NavDestination, NavDestination> {
        public static final AnonymousClass6 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        AnonymousClass6() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NavDestination invoke2(NavDestination r3) {
            o.f(r3, "destination");
            NavGraph r2 = r3.getParent();
            boolean r0 = false;
            if (r2 != null) goto L5;
        L7:
            if (r0 == true) goto L11;
            return null;
        L11:
            return r3.getParent();
        L5:
            if (r2.getStartDestinationId() != r3.getId()) goto L7;
            r0 = true;
            goto L7
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ NavDestination invoke(NavDestination r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$popBackStackInternal$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/navigation/NavDestination;", "invoke", "(Landroidx/navigation/NavDestination;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass7 extends q implements l<NavDestination, Boolean> {
        final /* synthetic */ NavController this$0;

        AnonymousClass7(NavController r1) {
            this.this$0 = r1;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(NavDestination r2) {
            o.f(r2, "destination");
            return Boolean.valueOf(!NavController.access$getBackStackMap$p(this.this$0).containsKey(Integer.valueOf(r2.getId())));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(NavDestination r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06341 extends q implements l<String, Boolean> {
        final /* synthetic */ String $backStackId;

        C06341(String r1) {
            this.$backStackId = r1;
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Boolean invoke2(String r1) {
            return Boolean.valueOf(o.a(r1, this.$backStackId));
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(String r1) {
            return invoke2(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavController$restoreStateInternal$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "entry", "Landroidx/navigation/NavBackStackEntry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C06354 extends q implements l<NavBackStackEntry, f0> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ List<NavBackStackEntry> $entries;
        final /* synthetic */ b0 $lastNavigatedIndex;
        final /* synthetic */ a0 $navigated;
        final /* synthetic */ NavController this$0;

        C06354(a0 r1, List<NavBackStackEntry> r2, b0 r3, NavController r4, Bundle r5) {
            this.$navigated = r1;
            this.$entries = r2;
            this.$lastNavigatedIndex = r3;
            this.this$0 = r4;
            this.$args = r5;
            super(1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(NavBackStackEntry r1) {
            invoke2(r1);
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavBackStackEntry r5) {
            o.f(r5, "entry");
            this.$navigated.f18427f = true;
            int r0 = this.$entries.indexOf(r5);
            if (r0 == (-1)) goto L5;
            int r1 = r0 + 1;
            List<NavBackStackEntry> r2 = this.$entries.subList(this.$lastNavigatedIndex.f18428f, r1);
            this.$lastNavigatedIndex.f18428f = r1;
        L6:
            NavController.access$addEntryToBackStack(this.this$0, r5.getDestination(), this.$args, r5, r2);
            return;
        L5:
            r2 = r.g();
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
        deepLinkSaveState = true;
    }

    public NavController(Context r5) {
        o.f(r5, "context");
        this.context = r5;
        Iterator r6 = k.h(r5, NavController$activity$1.INSTANCE).iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r0 = r6.next();
        if ((((Context) r0) instanceof Activity) == false) goto L4;
    L9:
        this.activity = (Activity) r0;
        this.backQueue = new h();
        n<List<NavBackStackEntry>> r7 = x.a(r.g());
        this._visibleEntries = r7;
        this.visibleEntries = h.a.e3.g.b(r7);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new a(this);
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider r1 = this._navigatorProvider;
        r1.addNavigator(new NavGraphNavigator(r1));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = i.b(new NavController$navInflater$2(this));
        m<NavBackStackEntry> r8 = t.b(1, 0, h.a.d3.e.f17222g, 2, null);
        this._currentBackStackEntryFlow = r8;
        this.currentBackStackEntryFlow = h.a.e3.g.a(r8);
        return;
    L8:
        r0 = null;
        goto L9
    }

    public static /* synthetic */ void a(NavController r0, LifecycleOwner r1, Lifecycle.Event r2) {
        m23lifecycleObserver$lambda2(r0, r1, r2);
    }

    public static final /* synthetic */ void access$addEntryToBackStack(NavController r0, NavDestination r1, Bundle r2, NavBackStackEntry r3, List r4) {
        r0.addEntryToBackStack(r1, r2, r3, r4);
    }

    public static final /* synthetic */ l access$getAddToBackStackHandler$p(NavController r0) {
        return r0.addToBackStackHandler;
    }

    public static final /* synthetic */ Map access$getBackStackMap$p(NavController r0) {
        return r0.backStackMap;
    }

    public static final /* synthetic */ boolean access$getDeepLinkSaveState$cp() {
        return deepLinkSaveState;
    }

    public static final /* synthetic */ Map access$getEntrySavedState$p(NavController r0) {
        return r0.entrySavedState;
    }

    public static final /* synthetic */ NavInflater access$getInflater$p(NavController r0) {
        return r0.inflater;
    }

    public static final /* synthetic */ Map access$getNavigatorState$p(NavController r0) {
        return r0.navigatorState;
    }

    public static final /* synthetic */ l access$getPopFromBackStackHandler$p(NavController r0) {
        return r0.popFromBackStackHandler;
    }

    public static final /* synthetic */ NavControllerViewModel access$getViewModel$p(NavController r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ NavigatorProvider access$get_navigatorProvider$p(NavController r0) {
        return r0._navigatorProvider;
    }

    public static final /* synthetic */ n access$get_visibleEntries$p(NavController r0) {
        return r0._visibleEntries;
    }

    public static final /* synthetic */ void access$popEntryFromBackStack(NavController r0, NavBackStackEntry r1, boolean r2, h r3) {
        r0.popEntryFromBackStack(r1, r2, r3);
    }

    public static final /* synthetic */ void access$setDeepLinkSaveState$cp(boolean r0) {
        deepLinkSaveState = r0;
    }

    private final void addEntryToBackStack(NavDestination r31, Bundle r32, NavBackStackEntry r33, List<NavBackStackEntry> r34) {
        Bundle r15 = r32;
        NavBackStackEntry r14 = r33;
        List<NavBackStackEntry> r13 = r34;
        NavDestination r12 = r33.getDestination();
        if ((r12 instanceof FloatingWindow) == false) goto L5;
    L10:
        h r5 = new h();
        NavBackStackEntry r18 = null;
        if ((r31 instanceof NavGraph) == false) goto L37;
        NavDestination r0 = r12;
    L13:
        o.c(r0);
        NavGraph r4 = r0.getParent();
        if (r4 == null) goto L32;
        ListIterator<NavBackStackEntry> r1 = r13.listIterator(r34.size());
    L17:
        if (r1.hasPrevious() == false) goto L21;
        NavBackStackEntry r2 = r1.previous();
        if (o.a(r2.getDestination(), r4) == false) goto L17;
    L22:
        NavBackStackEntry r3 = r2;
        if (r3 != null) goto L25;
        NavBackStackEntry r8 = r14;
        r3 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r4, r32, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L26:
        r5.addFirst(r3);
        if ((!getBackQueue().isEmpty()) == false) goto L33;
        if (getBackQueue().o().getDestination() != r4) goto L33;
        popEntryFromBackStack$default(this, getBackQueue().o(), false, null, 6, null);
    L33:
        if (r4 == 0) goto L39;
        if (r4 == r31) goto L39;
        r14 = r8;
        r0 = r4;
        r5 = r5;
        r15 = r15;
        r13 = r13;
        r12 = r12;
    L39:
        if (r5.isEmpty() == false) goto L41;
        NavDestination r6 = r12;
    L42:
        if (r6 == null) goto L59;
        if (findDestination(r6.getId()) != null) goto L59;
        r6 = r6.getParent();
        if (r6 == null) goto L42;
        ListIterator<NavBackStackEntry> r7 = r13.listIterator(r34.size());
    L49:
        if (r7.hasPrevious() == false) goto L53;
        NavBackStackEntry r9 = r7.previous();
        if (o.a(r9.getDestination(), r6) == false) goto L49;
    L54:
        NavBackStackEntry r10 = r9;
        if (r10 != null) goto L57;
        r10 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r6, r6.addInDefaultArgs(r15), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L57:
        r5.addFirst(r10);
        goto L42
    L53:
        r9 = null;
    L59:
        if (r5.isEmpty() == true) goto L63;
        r12 = ((NavBackStackEntry) r5.l()).getDestination();
    L63:
        if (getBackQueue().isEmpty() == true) goto L69;
        if ((getBackQueue().o().getDestination() instanceof NavGraph) == false) goto L69;
        if (((NavGraph) getBackQueue().o().getDestination()).findNode(r12.getId(), false) != null) goto L69;
        popEntryFromBackStack$default(this, getBackQueue().o(), false, null, 6, null);
    L69:
        NavBackStackEntry r11 = getBackQueue().m();
        if (r11 != null) goto L72;
        r11 = (NavBackStackEntry) r5.m();
    L72:
        if (r11 == null) goto L74;
        NavDestination r16 = r11.getDestination();
    L76:
        if (o.a(r16, this._graph) == true) goto L87;
        ListIterator<NavBackStackEntry> r17 = r13.listIterator(r34.size());
    L79:
        if (r17.hasPrevious() == false) goto L83;
        NavBackStackEntry r19 = r17.previous();
        NavDestination r20 = r19.getDestination();
        NavGraph r21 = this._graph;
        o.c(r21);
        if (o.a(r20, r21) == false) goto L79;
        r18 = r19;
    L83:
        NavBackStackEntry r110 = r18;
        if (r110 != null) goto L86;
        NavBackStackEntry.Companion r111 = NavBackStackEntry.Companion;
        Context r22 = this.context;
        NavGraph r23 = this._graph;
        o.c(r23);
        NavGraph r24 = this._graph;
        o.c(r24);
        r110 = NavBackStackEntry.Companion.create$default(r111, r22, r23, r24.addInDefaultArgs(r15), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L86:
        r5.addFirst(r110);
    L87:
        Iterator<E> r25 = r5.iterator();
    L89:
        if (r25.hasNext() == false) goto L95;
        NavBackStackEntry r26 = (NavBackStackEntry) r25.next();
        NavControllerNavigatorState r27 = this.navigatorState.get(this._navigatorProvider.getNavigator(r26.getDestination().getNavigatorName()));
        if (r27 == null) goto L94;
        r27.addInternal(r26);
        goto L89
    L94:
        throw new IllegalStateException(("NavigatorBackStack for " + r31.getNavigatorName() + " should already be created").toString());
    L95:
        getBackQueue().addAll(r5);
        getBackQueue().add(r8);
        Iterator r28 = r.l0(r5, r8).iterator();
    L97:
        if (r28.hasNext() == false) goto L101;
        NavBackStackEntry r29 = (NavBackStackEntry) r28.next();
        NavGraph r30 = r29.getDestination().getParent();
        if (r30 == null) goto L97;
        linkChildToParent(r29, getBackStackEntry(r30.getId()));
        goto L97
    L101:
        return;
    L74:
        r16 = null;
        goto L76
    L41:
        r6 = ((NavBackStackEntry) r5.l()).getDestination();
        goto L42
    L25:
        r8 = r14;
        goto L26
    L21:
        r2 = null;
        goto L22
    L32:
        r12 = r12;
        r8 = r14;
        goto L33
    L37:
        r5 = r5;
        r12 = r12;
        r13 = r13;
        r8 = r14;
        r15 = r15;
    L5:
        if (getBackQueue().isEmpty() == true) goto L10;
        if ((getBackQueue().o().getDestination() instanceof FloatingWindow) == false) goto L10;
        if (popBackStackInternal$default(this, getBackQueue().o().getDestination().getId(), true, false, 4, null) == true) goto L5;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void addEntryToBackStack$default(NavController r0, NavDestination r1, Bundle r2, NavBackStackEntry r3, List r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 8) == 0) goto L6;
        r4 = r.g();
    L6:
        r0.addEntryToBackStack(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    @MainThread
    private final boolean clearBackStackInternal(@IdRes int r6) {
        Iterator<T> r0 = this.navigatorState.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r0.next()).setNavigating(true);
        goto L4
    L6:
        boolean r1 = restoreStateInternal(r6, null, null, null);
        Iterator<T> r2 = this.navigatorState.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((NavControllerNavigatorState) r2.next()).setNavigating(false);
        goto L8
    L10:
        if (r1 == false) goto L15;
        if (popBackStackInternal(r6, true, false) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final boolean dispatchOnDestinationChanged() {
    L3:
        if (getBackQueue().isEmpty() == true) goto L7;
        if ((getBackQueue().o().getDestination() instanceof NavGraph) == false) goto L7;
        popEntryFromBackStack$default(this, getBackQueue().o(), false, null, 6, null);
    L7:
        NavBackStackEntry r0 = getBackQueue().p();
        if (r0 == null) goto L10;
        this.backStackEntriesToDispatch.add(r0);
    L10:
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int r1 = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = r1;
        if (r1 != 0) goto L21;
        List r2 = r.B0(this.backStackEntriesToDispatch);
        this.backStackEntriesToDispatch.clear();
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L20;
        NavBackStackEntry r4 = (NavBackStackEntry) r3.next();
        Iterator<OnDestinationChangedListener> r5 = this.onDestinationChangedListeners.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        r5.next().onDestinationChanged(this, r4.getDestination(), r4.getArguments());
        goto L17
    L19:
        this._currentBackStackEntryFlow.a(r4);
        goto L14
    L20:
        this._visibleEntries.a(populateVisibleEntries$navigation_runtime_release());
    L21:
        if (r0 != null) goto L29;
        return false;
    L29:
        return true;
    }

    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean r1) {
        Companion.enableDeepLinkSaveState(r1);
    }

    private final NavDestination findDestination(NavDestination r1, @IdRes int r2) {
        if (r1.getId() != r2) goto L6;
        return r1;
    L6:
        if ((r1 instanceof NavGraph) == false) goto L8;
        NavGraph r3 = (NavGraph) r1;
    L10:
        return r3.findNode(r2);
    L8:
        r3 = r1.getParent();
        o.c(r3);
        goto L10
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] r7) {
        NavGraph r0 = this._graph;
        int r1 = r7.length;
        int r2 = 0;
    L3:
        NavDestination r3 = null;
        if (r2 >= r1) goto L24;
        int r4 = r7[r2];
        if (r2 != 0) goto L10;
        NavGraph r5 = this._graph;
        o.c(r5);
        if (r5.getId() != r4) goto L11;
        r3 = this._graph;
    L11:
        if (r3 == null) goto L13;
        if (r2 == (r7.length - 1)) goto L23;
        if ((r3 instanceof NavGraph) == false) goto L23;
    L19:
        NavGraph r6 = (NavGraph) r3;
        o.c(r6);
        if ((r6.findNode(r6.getStartDestinationId()) instanceof NavGraph) == false) goto L22;
        r3 = r6.findNode(r6.getStartDestinationId());
        goto L19
    L22:
        r0 = r6;
    L23:
        r2 = r2 + 1;
        goto L3
    L13:
        return NavDestination.Companion.getDisplayName(this.context, r4);
    L10:
        o.c(r0);
        r3 = r0.findNode(r4);
        goto L11
    L24:
        return null;
    }

    private final int getDestinationCountOnBackStack() {
        h<NavBackStackEntry> r2 = getBackQueue();
        int r1 = 0;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<NavBackStackEntry> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        if ((!(r3.next().getDestination() instanceof NavGraph)) == false) goto L9;
        r1 = r1 + 1;
        if (r1 >= 0) goto L9;
        r.o();
        throw null;
    L17:
        return r1;
    L5:
        if (r2.isEmpty() == false) goto L7;
        goto L7
    }

    private final List<NavBackStackEntry> instantiateBackStack(h<NavBackStackEntryState> r7) {
        ArrayList r0 = new ArrayList();
        NavBackStackEntry r1 = getBackQueue().p();
        if (r1 == null) goto L6;
        NavDestination r2 = r1.getDestination();
        if (r2 == null) goto L6;
    L7:
        if (r7 == null) goto L16;
        Iterator<NavBackStackEntryState> r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L16;
        NavBackStackEntryState r3 = r8.next();
        NavDestination r4 = findDestination(r2, r3.getDestinationId());
        if (r4 == null) goto L15;
        r0.add(r3.instantiate(this.context, r4, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
        r2 = r4;
        goto L10
    L15:
        throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(this.context, r3.getDestinationId()) + " cannot be found from the current destination " + r2).toString());
    L16:
        return r0;
    L6:
        r2 = getGraph();
        goto L7
    }

    /* JADX INFO: renamed from: lifecycleObserver$lambda-2, reason: not valid java name */
    private static final void m23lifecycleObserver$lambda2(NavController r1, LifecycleOwner r2, Lifecycle.Event r3) {
        o.f(r1, "this$0");
        o.f(r2, "<anonymous parameter 0>");
        o.f(r3, NotificationCompat.CATEGORY_EVENT);
        Lifecycle.State r4 = r3.getTargetState();
        o.e(r4, "event.targetState");
        r1.hostLifecycleState = r4;
        if (r1._graph == null) goto L8;
        Iterator<NavBackStackEntry> r5 = r1.getBackQueue().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        r5.next().handleLifecycleEvent(r3);
        goto L6
    L10:
        return;
    }

    private final void linkChildToParent(NavBackStackEntry r3, NavBackStackEntry r4) {
        this.childToParentEntries.put(r3, r4);
        if (this.parentToChildCount.get(r4) != null) goto L5;
        this.parentToChildCount.put(r4, new AtomicInteger(0));
    L5:
        AtomicInteger r2 = this.parentToChildCount.get(r4);
        o.c(r2);
        r2.incrementAndGet();
    }

    @MainThread
    private final void navigate(NavDestination r21, Bundle r22, NavOptions r23, Navigator.Extras r24) {
        Iterator<T> r0 = this.navigatorState.values().iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r0.next()).setNavigating(true);
        goto L3
    L6:
        a0 r7 = new a0();
        if (r23 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        Bundle r1 = r21.addInDefaultArgs(r22);
        if (r23 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L20;
    L22:
        NavBackStackEntry r4 = getCurrentBackStackEntry();
        Navigator<? extends NavDestination> r5 = this._navigatorProvider.getNavigator(r21.getNavigatorName());
        if (r23 != null) goto L25;
    L27:
        boolean r10 = false;
    L28:
        if (r10 == false) goto L41;
        if (r4 == null) goto L35;
        NavDestination r11 = r4.getDestination();
        if (r11 == null) goto L35;
        if (r21.getId() != r11.getId()) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == false) goto L41;
        unlinkChildFromParent$navigation_runtime_release(getBackQueue().removeLast());
        NavBackStackEntry r6 = new NavBackStackEntry(r4, r1);
        getBackQueue().addLast(r6);
        NavGraph r8 = r6.getDestination().getParent();
        if (r8 == null) goto L40;
        linkChildToParent(r6, getBackStackEntry(r8.getId()));
    L40:
        r5.onLaunchSingleTop(r6);
    L43:
        updateOnBackPressedCallbackEnabled();
        Iterator<T> r13 = this.navigatorState.values().iterator();
    L45:
        if (r13.hasNext() == false) goto L47;
        ((NavControllerNavigatorState) r13.next()).setNavigating(false);
        goto L45
    L47:
        if (r9 == false) goto L49;
    L53:
        dispatchOnDestinationChanged();
        return;
    L49:
        if (r7.f18427f == true) goto L53;
        if (r2 == true) goto L53;
        updateBackStackLifecycle$navigation_runtime_release();
        return;
    L35:
        r12 = false;
    L41:
        navigateInternal(r5, r.d(NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r21, r1, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), r23, r24, new AnonymousClass4(r7, this, r21, r1));
    L42:
        r2 = false;
        goto L43
    L25:
        if (r23.shouldLaunchSingleTop() != true) goto L27;
        r10 = true;
        goto L28
    L20:
        if (this.backStackMap.containsKey(Integer.valueOf(r21.getId())) == false) goto L22;
        r7.f18427f = restoreStateInternal(r21.getId(), r1, r23, r24);
        goto L42
    L15:
        if (r23.shouldRestoreState() != true) goto L17;
        r3 = true;
        goto L18
    L9:
        if (r23.getPopUpToId() == (-1)) goto L11;
        r9 = popBackStackInternal(r23.getPopUpToId(), r23.isPopUpToInclusive(), r23.shouldPopUpToSaveState());
        goto L12
    }

    public static /* synthetic */ void navigate$default(NavController r1, String r2, NavOptions r3, Navigator.Extras r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.navigate(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    private final void navigateInternal(Navigator<? extends NavDestination> r1, List<NavBackStackEntry> r2, NavOptions r3, Navigator.Extras r4, l<? super NavBackStackEntry, f0> r5) {
        this.addToBackStackHandler = r5;
        r1.navigate(r2, r3, r4);
        this.addToBackStackHandler = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void navigateInternal$default(NavController r6, Navigator r7, List r8, NavOptions r9, Navigator.Extras r10, l r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 8) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        r6.navigateInternal(r7, r8, r9, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }

    @MainThread
    private final void onGraphCreated(Bundle r11) {
        Bundle r0 = this.navigatorStateToRestore;
        if (r0 == null) goto L12;
        ArrayList<String> r1 = r0.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES);
        if (r1 == null) goto L12;
        Iterator<String> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();
        NavigatorProvider r4 = this._navigatorProvider;
        o.e(r3, "name");
        Navigator r5 = r4.getNavigator(r3);
        Bundle r6 = r0.getBundle(r3);
        if (r6 == null) goto L8;
        r5.onRestoreState(r6);
    L12:
        Parcelable[] r7 = this.backStackToRestore;
        boolean r8 = false;
        if (r7 == null) goto L28;
        int r9 = r7.length;
        int r10 = 0;
    L15:
        if (r10 >= r9) goto L27;
        NavBackStackEntryState r12 = (NavBackStackEntryState) r7[r10];
        NavDestination r13 = findDestination(r12.getDestinationId());
        if (r13 == null) goto L26;
        NavBackStackEntry r14 = r12.instantiate(this.context, r13, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
        Navigator<? extends NavDestination> r15 = this._navigatorProvider.getNavigator(r13.getNavigatorName());
        Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> r16 = this.navigatorState;
        NavControllerNavigatorState r17 = r16.get(r15);
        if (r17 != null) goto L21;
        r17 = new NavControllerNavigatorState(this, r15);
        r16.put(r15, r17);
    L21:
        getBackQueue().add(r14);
        r17.addInternal(r14);
        NavGraph r18 = r14.getDestination().getParent();
        if (r18 == null) goto L24;
        linkChildToParent(r14, getBackStackEntry(r18.getId()));
    L24:
        r10 = r10 + 1;
        goto L15
    L26:
        throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(this.context, r12.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
    L27:
        updateOnBackPressedCallbackEnabled();
        this.backStackToRestore = null;
    L28:
        Collection<Navigator<? extends NavDestination>> r19 = this._navigatorProvider.getNavigators().values();
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L30:
        if (r21.hasNext() == false) goto L34;
        Object r22 = r21.next();
        if (((Navigator) r22).isAttached() == true) goto L30;
        r20.add(r22);
        goto L30
    L34:
        Iterator r23 = r20.iterator();
    L36:
        if (r23.hasNext() == false) goto L42;
        Navigator<? extends NavDestination> r24 = (Navigator) r23.next();
        Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> r25 = this.navigatorState;
        NavControllerNavigatorState r26 = r25.get(r24);
        if (r26 != null) goto L40;
        r26 = new NavControllerNavigatorState(this, r24);
        r25.put(r24, r26);
    L40:
        r24.onAttach(r26);
        goto L36
    L42:
        if (this._graph != null) goto L44;
    L54:
        dispatchOnDestinationChanged();
        return;
    L44:
        if (getBackQueue().isEmpty() == false) goto L54;
        if (this.deepLinkHandled == true) goto L52;
        Activity r27 = this.activity;
        if (r27 == null) goto L52;
        o.c(r27);
        if (handleDeepLink(r27.getIntent()) == false) goto L52;
        r8 = true;
    L52:
        if (r8 == true) goto L73;
        NavGraph r28 = this._graph;
        o.c(r28);
        navigate(r28, r11, null, null);
        return;
    }

    public static /* synthetic */ boolean popBackStack$default(NavController r0, String r1, boolean r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = false;
    L7:
        return r0.popBackStack(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> r1, NavBackStackEntry r2, boolean r3, l<? super NavBackStackEntry, f0> r4) {
        this.popFromBackStackHandler = r4;
        r1.popBackStack(r2, r3);
        this.popFromBackStackHandler = null;
    }

    @MainThread
    private final boolean popBackStackInternal(@IdRes int r17, boolean r18, boolean r19) {
        if (getBackQueue().isEmpty() == false) goto L5;
        return false;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r3 = r.m0(getBackQueue()).iterator();
    L7:
        if (r3.hasNext() == false) goto L16;
        NavDestination r4 = ((NavBackStackEntry) r3.next()).getDestination();
        Navigator r5 = this._navigatorProvider.getNavigator(r4.getNavigatorName());
        if (r18 == false) goto L11;
    L12:
        r1.add(r5);
    L14:
        if (r4.getId() != r17) goto L7;
        NavDestination r9 = r4;
    L17:
        if (r9 != null) goto L20;
        Log.i(TAG, "Ignoring popBackStack to destination " + NavDestination.Companion.getDisplayName(this.context, r17) + " as it was not found on the current back stack");
        return false;
    L20:
        a0 r10 = new a0();
        h<NavBackStackEntryState> r11 = new h();
        Iterator r12 = r1.iterator();
    L22:
        if (r12.hasNext() == false) goto L25;
        Navigator<? extends NavDestination> r13 = (Navigator) r12.next();
        a0 r14 = new a0();
        popBackStackInternal(r13, getBackQueue().o(), r19, new C06322(r14, r10, this, r19, r11));
        if (r14.f18427f == true) goto L22;
    L25:
        if (r19 == false) goto L42;
        if (r18 == true) goto L36;
        Iterator r0 = k.x(k.h(r9, AnonymousClass3.INSTANCE), new C06334(this)).iterator();
    L29:
        if (r0.hasNext() == false) goto L36;
        NavDestination r2 = (NavDestination) r0.next();
        Map<Integer, String> r6 = this.backStackMap;
        Integer r7 = Integer.valueOf(r2.getId());
        NavBackStackEntryState r8 = r11.m();
        if (r8 == null) goto L33;
        String r15 = r8.getId();
    L34:
        r6.put(r7, r15);
        goto L29
    L33:
        r15 = null;
    L36:
        if ((!r11.isEmpty()) == false) goto L42;
        NavBackStackEntryState r16 = r11.l();
        Iterator r20 = k.x(k.h(findDestination(r16.getDestinationId()), AnonymousClass6.INSTANCE), new AnonymousClass7(this)).iterator();
    L39:
        if (r20.hasNext() == false) goto L41;
        this.backStackMap.put(Integer.valueOf(((NavDestination) r20.next()).getId()), r16.getId());
        goto L39
    L41:
        this.backStackStates.put(r16.getId(), r11);
    L42:
        updateOnBackPressedCallbackEnabled();
        return r10.f18427f;
    L11:
        if (r4.getId() == r17) goto L14;
    L16:
        r9 = null;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popBackStackInternal$default(NavController r0, Navigator r1, NavBackStackEntry r2, boolean r3, l r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 4) == 0) goto L6;
        r4 = C06311.INSTANCE;
    L6:
        r0.popBackStackInternal(r1, r2, r3, r4);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    static /* synthetic */ boolean popBackStackInternal$default(NavController r0, int r1, boolean r2, boolean r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 4) == 0) goto L7;
        r3 = false;
    L7:
        return r0.popBackStackInternal(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    private final void popEntryFromBackStack(NavBackStackEntry r4, boolean r5, h<NavBackStackEntryState> r6) {
        NavBackStackEntry r0 = getBackQueue().o();
        if (o.a(r0, r4) == false) goto L33;
        getBackQueue().removeLast();
        NavControllerNavigatorState r7 = this.navigatorState.get(getNavigatorProvider().getNavigator(r0.getDestination().getNavigatorName()));
        boolean r1 = true;
        if (r7 == null) goto L13;
        v<Set<NavBackStackEntry>> r8 = r7.getTransitionsInProgress();
        if (r8 == null) goto L13;
        Set<NavBackStackEntry> r9 = r8.getValue();
        if (r9 == null) goto L13;
        if (r9.contains(r0) != true) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
    L19:
        Lifecycle.State r11 = r0.getLifecycle().getCurrentState();
        Lifecycle.State r2 = Lifecycle.State.CREATED;
        if (r11.isAtLeast(r2) == false) goto L26;
        if (r5 == false) goto L23;
        r0.setMaxLifecycle(r2);
        r6.addFirst(new NavBackStackEntryState(r0));
    L23:
        if (r1 == true) goto L25;
        r0.setMaxLifecycle(Lifecycle.State.DESTROYED);
        unlinkChildFromParent$navigation_runtime_release(r0);
        goto L26
    L25:
        r0.setMaxLifecycle(r2);
    L26:
        if (r5 == true) goto L34;
        if (r1 == true) goto L35;
        NavControllerViewModel r3 = this.viewModel;
        if (r3 == null) goto L36;
        r3.clear(r0.getId());
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L16:
        if (this.parentToChildCount.containsKey(r0) == true) goto L19;
        r1 = false;
    L13:
        r10 = false;
        goto L14
    L33:
        throw new IllegalStateException(("Attempted to pop " + r4.getDestination() + ", which is not the top of the back stack (" + r0.getDestination() + ')').toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void popEntryFromBackStack$default(NavController r0, NavBackStackEntry r1, boolean r2, h r3, int r4, Object r5) {
        if (r5 != null) goto L12;
        if ((r4 & 2) == 0) goto L7;
        r2 = false;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = new h();
    L9:
        r0.popEntryFromBackStack(r1, r2, r3);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    private final boolean restoreStateInternal(int r12, Bundle r13, NavOptions r14, Navigator.Extras r15) {
        if (this.backStackMap.containsKey(Integer.valueOf(r12)) == true) goto L5;
        return false;
    L5:
        String r16 = this.backStackMap.get(Integer.valueOf(r12));
        r.y(this.backStackMap.values(), new C06341(r16));
        List<NavBackStackEntry> r17 = instantiateBackStack((h) j0.c(this.backStackStates).remove(r16));
        ArrayList r0 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r17.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if ((((NavBackStackEntry) r4).getDestination() instanceof NavGraph) == true) goto L7;
        r2.add(r4);
        goto L7
    L11:
        Iterator r5 = r2.iterator();
    L13:
        if (r5.hasNext() == false) goto L26;
        NavBackStackEntry r6 = (NavBackStackEntry) r5.next();
        List r7 = (List) r.d0(r0);
        if (r7 == null) goto L21;
        NavBackStackEntry r8 = (NavBackStackEntry) r.b0(r7);
        if (r8 == null) goto L21;
        NavDestination r9 = r8.getDestination();
        if (r9 == null) goto L21;
        String r10 = r9.getNavigatorName();
    L23:
        if (o.a(r10, r6.getDestination().getNavigatorName()) == true) goto L24;
        r0.add(r.m(new NavBackStackEntry[]{r6}));
        goto L13
    L24:
        r7.add(r6);
    L21:
        r10 = null;
        goto L23
    L26:
        a0 r1 = new a0();
        Iterator r11 = r0.iterator();
    L28:
        if (r11.hasNext() == false) goto L31;
        List<NavBackStackEntry> r18 = (List) r11.next();
        navigateInternal(this._navigatorProvider.getNavigator(((NavBackStackEntry) r.P(r18)).getDestination().getNavigatorName()), r18, r14, r15, new C06354(r1, r17, new b0(), this, r13));
        goto L28
    L31:
        return r1.f18427f;
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int r1 = 0;
        if (this.deepLinkHandled == true) goto L5;
        return false;
    L5:
        Activity r0 = this.activity;
        o.c(r0);
        Intent r2 = r0.getIntent();
        Bundle r3 = r2.getExtras();
        o.c(r3);
        int[] r4 = r3.getIntArray(KEY_DEEP_LINK_IDS);
        o.c(r4);
        List<Integer> r5 = kotlin.i0.i.l0(r4);
        ArrayList r6 = r3.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int r7 = ((Number) r.z(r5)).intValue();
        if (r6 == null) goto L9;
        Bundle r8 = (Bundle) r.z(r6);
    L9:
        if (r5.isEmpty() == false) goto L11;
        return false;
    L11:
        NavDestination r9 = findDestination(getGraph(), r7);
        if ((r9 instanceof NavGraph) == false) goto L14;
        r7 = NavGraph.Companion.findStartDestination((NavGraph) r9).getId();
    L14:
        NavDestination r10 = getCurrentDestination();
        if (r10 != null) goto L17;
    L19:
        boolean r11 = false;
    L20:
        if (r11 == true) goto L22;
        return false;
    L22:
        NavDeepLinkBuilder r12 = createDeepLink();
        Bundle r13 = BundleKt.bundleOf(new u[]{kotlin.a0.a(KEY_DEEP_LINK_INTENT, r2)});
        Bundle r14 = r3.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (r14 == null) goto L25;
        r13.putAll(r14);
    L25:
        r12.setArguments(r13);
        Iterator<T> r15 = r5.iterator();
    L27:
        if (r15.hasNext() == false) goto L36;
        Object r16 = r15.next();
        int r17 = r1 + 1;
        Bundle r18 = null;
        if (r1 < 0) goto L34;
        int r19 = ((Number) r16).intValue();
        if (r6 == null) goto L33;
        r18 = (Bundle) r6.get(r1);
    L33:
        r12.addDestination(r19, r18);
        r1 = r17;
        goto L27
    L34:
        r.p();
        throw null;
    L36:
        r12.createTaskStackBuilder().startActivities();
        Activity r20 = this.activity;
        if (r20 == null) goto L39;
        r20.finish();
    L39:
        return true;
    L17:
        if (r7 != r10.getId()) goto L19;
        r11 = true;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.navigation.NavDestination, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.navigation.NavDestination] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.navigation.NavDestination, androidx.navigation.NavGraph] */
    private final boolean tryRelaunchUpToGeneratedStack() {
        ?? r0 = getCurrentDestination();
        o.c(r0);
    L3:
        int r1 = r0.getId();
        r0 = r0.getParent();
        if (r0 == 0) goto L21;
        if (r0.getStartDestinationId() == r1) goto L3;
        Bundle r2 = new Bundle();
        Activity r3 = this.activity;
        if (r3 == null) goto L16;
        o.c(r3);
        if (r3.getIntent() == null) goto L16;
        Activity r4 = this.activity;
        o.c(r4);
        if (r4.getIntent().getData() == null) goto L16;
        Activity r5 = this.activity;
        o.c(r5);
        r2.putParcelable(KEY_DEEP_LINK_INTENT, r5.getIntent());
        NavGraph r6 = this._graph;
        o.c(r6);
        Activity r7 = this.activity;
        o.c(r7);
        Intent r8 = r7.getIntent();
        o.e(r8, "activity!!.intent");
        NavDestination.DeepLinkMatch r9 = r6.matchDeepLink(new NavDeepLinkRequest(r8));
        if (r9 == null) goto L16;
        r2.putAll(r9.getDestination().addInDefaultArgs(r9.getMatchingArgs()));
    L16:
        NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), r0.getId(), null, 2, null).setArguments(r2).createTaskStackBuilder().startActivities();
        Activity r10 = this.activity;
        if (r10 == null) goto L26;
        r10.finish();
        return true;
    L26:
        return true;
    L21:
        return false;
    }

    private final void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback r0 = this.onBackPressedCallback;
        boolean r2 = true;
        if (this.enableOnBackPressedCallback == true) goto L5;
    L7:
        r2 = false;
    L8:
        r0.setEnabled(r2);
        return;
    L5:
        if (getDestinationCountOnBackStack() <= 1) goto L7;
        goto L7
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener r3) {
        o.f(r3, "listener");
        this.onDestinationChangedListeners.add(r3);
        if ((!getBackQueue().isEmpty()) == false) goto L6;
        NavBackStackEntry r0 = getBackQueue().o();
        r3.onDestinationChanged(this, r0.getDestination(), r0.getArguments());
        return;
    }

    @MainThread
    public final boolean clearBackStack(@IdRes int r1) {
        if (clearBackStackInternal(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (dispatchOnDestinationChanged() == false) goto L7;
        return true;
    }

    @MainThread
    public final boolean clearBackStack(String r2) {
        o.f(r2, "route");
        return clearBackStack(NavDestination.Companion.createRoute(r2).hashCode());
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void enableOnBackPressed(boolean r1) {
        this.enableOnBackPressedCallback = r1;
        updateOnBackPressedCallbackEnabled();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(@IdRes int r2) {
        NavGraph r0 = this._graph;
        if (r0 != null) goto L6;
        return null;
    L6:
        o.c(r0);
        if (r0.getId() == r2) goto L9;
        NavBackStackEntry r1 = getBackQueue().p();
        if (r1 == null) goto L14;
        NavDestination r3 = r1.getDestination();
        if (r3 == null) goto L14;
    L16:
        return findDestination(r3, r2);
    L14:
        r3 = this._graph;
        o.c(r3);
        goto L16
    L9:
        return this._graph;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final NavDestination findDestination(String r2) {
        o.f(r2, "destinationRoute");
        NavGraph r0 = this._graph;
        if (r0 != null) goto L6;
        return null;
    L6:
        o.c(r0);
        if (o.a(r0.getRoute(), r2) == true) goto L9;
        NavBackStackEntry r1 = getBackQueue().p();
        if (r1 == null) goto L14;
        NavGraph r3 = r1.getDestination();
        if (r3 == null) goto L14;
    L16:
        if ((r3 instanceof NavGraph) == false) goto L18;
        NavGraph r4 = r3;
    L20:
        return r4.findNode(r2);
    L18:
        r4 = r3.getParent();
        o.c(r4);
    L14:
        r3 = this._graph;
        o.c(r3);
        goto L16
    L9:
        return this._graph;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public h<NavBackStackEntry> getBackQueue() {
        return this.backQueue;
    }

    public NavBackStackEntry getBackStackEntry(@IdRes int r4) {
        h<NavBackStackEntry> r0 = getBackQueue();
        ListIterator<NavBackStackEntry> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L11;
        NavBackStackEntry r2 = r1.previous();
        if (r2.getDestination().getId() != r4) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        NavBackStackEntry r5 = r2;
        if (r5 == null) goto L16;
        return r5;
    L16:
        throw new IllegalArgumentException(("No destination with ID " + r4 + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    L8:
        r3 = false;
        goto L9
    L11:
        r2 = null;
        goto L12
    }

    public final NavBackStackEntry getBackStackEntry(String r4) {
        o.f(r4, "route");
        h<NavBackStackEntry> r0 = getBackQueue();
        ListIterator<NavBackStackEntry> r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        NavBackStackEntry r2 = r1.previous();
        if (o.a(r2.getDestination().getRoute(), r4) == false) goto L4;
    L9:
        NavBackStackEntry r3 = r2;
        if (r3 == null) goto L13;
        return r3;
    L13:
        throw new IllegalArgumentException(("No destination with route " + r4 + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    L8:
        r2 = null;
        goto L9
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Context getContext() {
        return this.context;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return getBackQueue().p();
    }

    public final e<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry r0 = getCurrentBackStackEntry();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDestination();
    }

    @MainThread
    public NavGraph getGraph() {
        NavGraph r1 = this._graph;
        if (r1 == null) goto L7;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.navigation.NavGraph");
        return r1;
    L7:
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner != null) goto L6;
        return Lifecycle.State.CREATED;
    L6:
        return this.hostLifecycleState;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator r2 = r.m0(getBackQueue()).iterator();
        if (r2.hasNext() == false) goto L5;
        r2.next();
    L5:
        Iterator r3 = k.c(r2).iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r0 = r3.next();
        if ((!(((NavBackStackEntry) r0).getDestination() instanceof NavGraph)) == false) goto L7;
    L13:
        return (NavBackStackEntry) r0;
    L11:
        r0 = null;
        goto L13
    }

    public ViewModelStoreOwner getViewModelStoreOwner(@IdRes int r2) {
        if (this.viewModel == null) goto L10;
        NavBackStackEntry r1 = getBackStackEntry(r2);
        if ((r1.getDestination() instanceof NavGraph) == false) goto L8;
        return r1;
    L8:
        throw new IllegalArgumentException(("No NavGraph with ID " + r2 + " is on the NavController's back stack").toString());
    L10:
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
    }

    public final v<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    @MainThread
    public boolean handleDeepLink(Intent r20) {
        int r7 = 0;
        if (r20 != null) goto L5;
        return false;
    L5:
        Bundle r1 = r20.getExtras();
        if (r1 == null) goto L8;
        int[] r2 = r1.getIntArray(KEY_DEEP_LINK_IDS);
    L9:
        if (r1 == null) goto L11;
        ArrayList r3 = r1.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
    L12:
        Bundle r4 = new Bundle();
        if (r1 == null) goto L15;
        Bundle r5 = r1.getBundle(KEY_DEEP_LINK_EXTRAS);
    L16:
        if (r5 == null) goto L19;
        r4.putAll(r5);
    L19:
        if (r2 != null) goto L21;
    L25:
        NavGraph r6 = this._graph;
        o.c(r6);
        NavDestination.DeepLinkMatch r8 = r6.matchDeepLink(new NavDeepLinkRequest(r20));
        if (r8 == null) goto L31;
        NavDestination r9 = r8.getDestination();
        int[] r10 = NavDestination.buildDeepLinkIds$default(r9, null, 1, null);
        Bundle r11 = r9.addInDefaultArgs(r8.getMatchingArgs());
        if (r11 == null) goto L30;
        r4.putAll(r11);
    L30:
        int[] r12 = r10;
        r3 = null;
    L32:
        if (r12 != null) goto L34;
    L94:
        return false;
    L34:
        if (r12.length != 0) goto L36;
        boolean r13 = true;
    L37:
        if (r13 == true) goto L94;
        String r14 = findInvalidDestinationDisplayNameInDeepLink(r12);
        if (r14 == null) goto L43;
        Log.i(TAG, "Could not find destination " + r14 + " in the navigation graph, ignoring the deep link from " + r20);
        return false;
    L43:
        r4.putParcelable(KEY_DEEP_LINK_INTENT, r20);
        int r15 = r12.length;
        Bundle[] r16 = new Bundle[r15];
        int r17 = 0;
    L44:
        if (r17 >= r15) goto L51;
        Bundle r18 = new Bundle();
        r18.putAll(r4);
        if (r3 == null) goto L50;
        Bundle r19 = (Bundle) r3.get(r17);
        if (r19 == null) goto L50;
        r18.putAll(r19);
    L50:
        r16[r17] = r18;
        r17 = r17 + 1;
        goto L44
    L51:
        int r21 = r20.getFlags();
        int r22 = 268435456 & r21;
        if (r22 == 0) goto L60;
        if ((r21 & 32768) != 0) goto L60;
        r20.addFlags(32768);
        TaskStackBuilder r0 = TaskStackBuilder.create(this.context).addNextIntentWithParentStack(r20);
        o.e(r0, "create(context)\n        …ntWithParentStack(intent)");
        r0.startActivities();
        Activity r23 = this.activity;
        if (r23 == null) goto L58;
        r23.finish();
        r23.overridePendingTransition(0, 0);
    L58:
        return true;
    L60:
        if (r22 != 0) goto L62;
        NavGraph r24 = this._graph;
        int r25 = r12.length;
        int r26 = 0;
    L73:
        if (r26 >= r25) goto L92;
        int r27 = r12[r26];
        Bundle r28 = r16[r26];
        if (r26 != 0) goto L77;
        NavDestination r29 = this._graph;
    L78:
        if (r29 == null) goto L91;
        if (r26 != (r12.length - 1)) goto L82;
        NavOptions.Builder r110 = new NavOptions.Builder();
        NavGraph r30 = this._graph;
        o.c(r30);
        navigate(r29, r28, NavOptions.Builder.setPopUpTo$default(r110, r30.getId(), true, false, 4, null).setEnterAnim(0).setExitAnim(0).build(), null);
    L89:
        r26 = r26 + 1;
        goto L73
    L82:
        if ((r29 instanceof NavGraph) == false) goto L89;
    L84:
        NavGraph r31 = (NavGraph) r29;
        o.c(r31);
        if ((r31.findNode(r31.getStartDestinationId()) instanceof NavGraph) == false) goto L87;
        r29 = r31.findNode(r31.getStartDestinationId());
        goto L84
    L87:
        r24 = r31;
        goto L89
    L91:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(this.context, r27) + " cannot be found in graph " + r24);
    L77:
        o.c(r24);
        r29 = r24.findNode(r27);
        goto L78
    L92:
        this.deepLinkHandled = true;
        return true;
    L62:
        if (getBackQueue().isEmpty() == true) goto L65;
        NavGraph r32 = this._graph;
        o.c(r32);
        popBackStackInternal$default(this, r32.getId(), true, false, 4, null);
    L65:
        if (r7 >= r12.length) goto L71;
        int r33 = r12[r7];
        int r34 = r7 + 1;
        Bundle r35 = r16[r7];
        NavDestination r36 = findDestination(r33);
        if (r36 == null) goto L70;
        navigate(r36, r35, NavOptionsBuilderKt.navOptions(new AnonymousClass2(r36, this)), null);
        r7 = r34;
        goto L65
    L70:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(this.context, r33) + " cannot be found from the current destination " + getCurrentDestination());
    L71:
        return true;
    L36:
        r13 = false;
    L31:
        r12 = r2;
        goto L32
    L21:
        if (r2.length != 0) goto L23;
        boolean r37 = true;
    L24:
        if (r37 == false) goto L31;
    L23:
        r37 = false;
        goto L24
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    @MainThread
    public void navigate(@IdRes int r2) {
        navigate(r2, null);
    }

    @MainThread
    public void navigate(@IdRes int r2, Bundle r3) {
        navigate(r2, r3, null);
    }

    @MainThread
    public void navigate(@IdRes int r2, Bundle r3, NavOptions r4) {
        navigate(r2, r3, r4, null);
    }

    @MainThread
    public void navigate(@IdRes int r7, Bundle r8, NavOptions r9, Navigator.Extras r10) {
        if (getBackQueue().isEmpty() == false) goto L5;
        NavDestination r0 = this._graph;
    L6:
        if (r0 == null) goto L47;
        NavAction r1 = r0.getAction(r7);
        Bundle r2 = null;
        if (r1 == null) goto L14;
        if (r9 != null) goto L11;
        r9 = r1.getNavOptions();
    L11:
        int r3 = r1.getDestinationId();
        Bundle r4 = r1.getDefaultArguments();
        if (r4 == null) goto L15;
        r2 = new Bundle();
        r2.putAll(r4);
    L15:
        if (r8 == null) goto L19;
        if (r2 != null) goto L18;
        r2 = new Bundle();
    L18:
        r2.putAll(r8);
    L19:
        if (r3 != 0) goto L25;
        if (r9 == null) goto L25;
        if (r9.getPopUpToId() == (-1)) goto L25;
        popBackStack(r9.getPopUpToId(), r9.isPopUpToInclusive());
        return;
    L25:
        boolean r11 = true;
        if (r3 == 0) goto L28;
        boolean r5 = true;
    L29:
        if (r5 == false) goto L45;
        NavDestination r6 = findDestination(r3);
        if (r6 != null) goto L42;
        NavDestination.Companion r12 = NavDestination.Companion;
        String r13 = r12.getDisplayName(this.context, r3);
        if (r1 == null) goto L37;
        r11 = false;
    L37:
        if (r11 == true) goto L41;
        throw new IllegalArgumentException(("Navigation destination " + r13 + " referenced from action " + r12.getDisplayName(this.context, r7) + " cannot be found from the current destination " + r0).toString());
    L41:
        throw new IllegalArgumentException("Navigation action/destination " + r13 + " cannot be found from the current destination " + r0);
    L42:
        navigate(r6, r2, r9, r10);
        return;
    L45:
        throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
    L28:
        r5 = false;
        goto L29
    L14:
        r3 = r7;
        goto L15
    L47:
        throw new IllegalStateException("no current navigation node");
    L5:
        r0 = getBackQueue().o().getDestination();
        goto L6
    }

    @MainThread
    public void navigate(Uri r3) {
        o.f(r3, "deepLink");
        navigate(new NavDeepLinkRequest(r3, null, null));
    }

    @MainThread
    public void navigate(Uri r3, NavOptions r4) {
        o.f(r3, "deepLink");
        navigate(new NavDeepLinkRequest(r3, null, null), r4, null);
    }

    @MainThread
    public void navigate(Uri r3, NavOptions r4, Navigator.Extras r5) {
        o.f(r3, "deepLink");
        navigate(new NavDeepLinkRequest(r3, null, null), r4, r5);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest r2) {
        o.f(r2, "request");
        navigate(r2, null);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest r2, NavOptions r3) {
        o.f(r2, "request");
        navigate(r2, r3, null);
    }

    @MainThread
    public void navigate(NavDeepLinkRequest r6, NavOptions r7, Navigator.Extras r8) {
        o.f(r6, "request");
        NavGraph r0 = this._graph;
        o.c(r0);
        NavDestination.DeepLinkMatch r1 = r0.matchDeepLink(r6);
        if (r1 == null) goto L10;
        Bundle r2 = r1.getDestination().addInDefaultArgs(r1.getMatchingArgs());
        if (r2 != null) goto L7;
        r2 = new Bundle();
    L7:
        NavDestination r3 = r1.getDestination();
        Intent r4 = new Intent();
        r4.setDataAndType(r6.getUri(), r6.getMimeType());
        r4.setAction(r6.getAction());
        r2.putParcelable(KEY_DEEP_LINK_INTENT, r4);
        navigate(r3, r2, r7, r8);
        return;
    L10:
        throw new IllegalArgumentException("Navigation destination that matches request " + r6 + " cannot be found in the navigation graph " + this._graph);
    }

    @MainThread
    public void navigate(NavDirections r3) {
        o.f(r3, "directions");
        navigate(r3.getActionId(), r3.getArguments(), null);
    }

    @MainThread
    public void navigate(NavDirections r2, NavOptions r3) {
        o.f(r2, "directions");
        navigate(r2.getActionId(), r2.getArguments(), r3);
    }

    @MainThread
    public void navigate(NavDirections r3, Navigator.Extras r4) {
        o.f(r3, "directions");
        o.f(r4, "navigatorExtras");
        navigate(r3.getActionId(), r3.getArguments(), null, r4);
    }

    public final void navigate(String r8) {
        o.f(r8, "route");
        navigate$default(this, r8, null, null, 6, null);
    }

    public final void navigate(String r8, NavOptions r9) {
        o.f(r8, "route");
        navigate$default(this, r8, r9, null, 4, null);
    }

    public final void navigate(String r3, NavOptions r4, Navigator.Extras r5) {
        o.f(r3, "route");
        NavDeepLinkRequest.Builder.Companion r0 = NavDeepLinkRequest.Builder.Companion;
        Uri r6 = Uri.parse(NavDestination.Companion.createRoute(r3));
        o.b(r6, "Uri.parse(this)");
        navigate(r0.fromUri(r6).build(), r4, r5);
    }

    public final void navigate(String r8, l<? super NavOptionsBuilder, f0> r9) {
        o.f(r8, "route");
        o.f(r9, "builder");
        navigate$default(this, r8, NavOptionsBuilderKt.navOptions(r9), null, 4, null);
    }

    @MainThread
    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() != 1) goto L18;
        Activity r0 = this.activity;
        int[] r1 = null;
        if (r0 == null) goto L9;
        Intent r2 = r0.getIntent();
        if (r2 == null) goto L9;
        Bundle r3 = r2.getExtras();
    L10:
        if (r3 == null) goto L12;
        r1 = r3.getIntArray(KEY_DEEP_LINK_IDS);
    L12:
        if (r1 == null) goto L16;
        return tryRelaunchUpToExplicitStack();
    L16:
        return tryRelaunchUpToGeneratedStack();
    L9:
        r3 = null;
        goto L10
    L18:
        return popBackStack();
    }

    @MainThread
    public boolean popBackStack() {
        if (getBackQueue().isEmpty() == false) goto L5;
        return false;
    L5:
        NavDestination r0 = getCurrentDestination();
        o.c(r0);
        return popBackStack(r0.getId(), true);
    }

    @MainThread
    public boolean popBackStack(@IdRes int r2, boolean r3) {
        return popBackStack(r2, r3, false);
    }

    @MainThread
    public boolean popBackStack(@IdRes int r1, boolean r2, boolean r3) {
        if (popBackStackInternal(r1, r2, r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (dispatchOnDestinationChanged() == false) goto L7;
        return true;
    }

    @MainThread
    public final boolean popBackStack(String r8, boolean r9) {
        o.f(r8, "route");
        return popBackStack$default(this, r8, r9, false, 4, null);
    }

    @MainThread
    public final boolean popBackStack(String r2, boolean r3, boolean r4) {
        o.f(r2, "route");
        return popBackStack(NavDestination.Companion.createRoute(r2).hashCode(), r3, r4);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry r10, kotlin.n0.c.a<f0> r11) {
        o.f(r10, "popUpTo");
        o.f(r11, "onComplete");
        int r0 = getBackQueue().indexOf(r10);
        if (r0 >= 0) goto L6;
        Log.i(TAG, "Ignoring pop of " + r10 + " as it was not found on the current back stack");
        return;
    L6:
        int r1 = r0 + 1;
        if (r1 == getBackQueue().size()) goto L9;
        popBackStackInternal(getBackQueue().get(r1).getDestination().getId(), true, false);
    L9:
        popEntryFromBackStack$default(this, r10, false, null, 6, null);
        r11.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.navigatorState.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        Set<NavBackStackEntry> r2 = ((NavControllerNavigatorState) r1.next()).getTransitionsInProgress().getValue();
        ArrayList r5 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L16;
        Object r6 = r3.next();
        NavBackStackEntry r7 = (NavBackStackEntry) r6;
        if (r0.contains(r7) == false) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L7;
        r5.add(r6);
        goto L7
    L11:
        if (r7.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED) == true) goto L13;
        r8 = true;
        goto L14
    L16:
        r.v(r0, r5);
        goto L4
    L17:
        h<NavBackStackEntry> r9 = getBackQueue();
        ArrayList r4 = new ArrayList();
        Iterator<NavBackStackEntry> r10 = r9.iterator();
    L19:
        if (r10.hasNext() == false) goto L28;
        NavBackStackEntry r11 = r10.next();
        NavBackStackEntry r12 = r11;
        if (r0.contains(r12) == false) goto L23;
    L25:
        boolean r13 = false;
    L26:
        if (r13 == false) goto L19;
        r4.add(r11);
        goto L19
    L23:
        if (r12.getMaxLifecycle().isAtLeast(Lifecycle.State.STARTED) == false) goto L25;
        r13 = true;
        goto L26
    L28:
        r.v(r0, r4);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r0.iterator();
    L30:
        if (r15.hasNext() == false) goto L34;
        Object r16 = r15.next();
        if ((!(((NavBackStackEntry) r16).getDestination() instanceof NavGraph)) == false) goto L30;
        r14.add(r16);
        goto L30
    L34:
        return r14;
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener r2) {
        o.f(r2, "listener");
        this.onDestinationChangedListeners.remove(r2);
    }

    @CallSuper
    public void restoreState(Bundle r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        r9.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = r9.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = r9.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] r0 = r9.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> r1 = r9.getStringArrayList(KEY_BACK_STACK_IDS);
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        int r2 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L8:
        if (r3 >= r2) goto L10;
        this.backStackMap.put(Integer.valueOf(r0[r3]), r1.get(r4));
        r3 = r3 + 1;
        r4 = r4 + 1;
    L10:
        ArrayList<String> r5 = r9.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
        if (r5 == null) goto L22;
        Iterator<T> r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L22;
        String r7 = (String) r6.next();
        Parcelable[] r8 = r9.getParcelableArray(KEY_BACK_STACK_STATES_PREFIX + r7);
        if (r8 == null) goto L14;
        Map<String, h<NavBackStackEntryState>> r10 = this.backStackStates;
        o.e(r7, "id");
        h<NavBackStackEntryState> r11 = new h(r8.length);
        Iterator r12 = kotlin.n0.d.b.a(r8);
    L19:
        if (r12.hasNext() == false) goto L21;
        Parcelable r13 = (Parcelable) r12.next();
        Objects.requireNonNull(r13, "null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
        r11.add((NavBackStackEntryState) r13);
        goto L19
    L21:
        r10.put(r7, r11);
    L22:
        this.deepLinkHandled = r9.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    @CallSuper
    public Bundle saveState() {
        ArrayList<String> r0 = new ArrayList();
        Bundle r1 = new Bundle();
        Iterator<Map.Entry<String, Navigator<? extends NavDestination>>> r2 = this._navigatorProvider.getNavigators().entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry<String, Navigator<? extends NavDestination>> r3 = r2.next();
        String r4 = r3.getKey();
        Bundle r5 = r3.getValue().onSaveState();
        if (r5 == null) goto L4;
        r0.add(r4);
        r1.putBundle(r4, r5);
        goto L4
    L9:
        if ((!r0.isEmpty()) == false) goto L11;
        Bundle r6 = new Bundle();
        r1.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, r0);
        r6.putBundle(KEY_NAVIGATOR_STATE, r1);
    L13:
        if ((!getBackQueue().isEmpty()) == false) goto L22;
        if (r6 != null) goto L16;
        r6 = new Bundle();
    L16:
        Parcelable[] r7 = new Parcelable[getBackQueue().size()];
        Iterator<NavBackStackEntry> r8 = getBackQueue().iterator();
        int r9 = 0;
    L18:
        if (r8.hasNext() == false) goto L20;
        r7[r9] = new NavBackStackEntryState(r8.next());
        r9 = r9 + 1;
        goto L18
    L20:
        r6.putParcelableArray(KEY_BACK_STACK, r7);
    L22:
        if ((!this.backStackMap.isEmpty()) == false) goto L31;
        if (r6 != null) goto L25;
        r6 = new Bundle();
    L25:
        int[] r10 = new int[this.backStackMap.size()];
        ArrayList<String> r11 = new ArrayList();
        Iterator<Map.Entry<Integer, String>> r12 = this.backStackMap.entrySet().iterator();
        int r13 = 0;
    L27:
        if (r12.hasNext() == false) goto L29;
        Map.Entry<Integer, String> r14 = r12.next();
        int r15 = r14.getKey().intValue();
        String r16 = r14.getValue();
        r10[r13] = r15;
        r11.add(r16);
        r13 = r13 + 1;
        goto L27
    L29:
        r6.putIntArray(KEY_BACK_STACK_DEST_IDS, r10);
        r6.putStringArrayList(KEY_BACK_STACK_IDS, r11);
    L31:
        if ((!this.backStackStates.isEmpty()) == false) goto L48;
        if (r6 != null) goto L34;
        r6 = new Bundle();
    L34:
        ArrayList<String> r17 = new ArrayList();
        Iterator<Map.Entry<String, h<NavBackStackEntryState>>> r18 = this.backStackStates.entrySet().iterator();
    L36:
        if (r18.hasNext() == false) goto L46;
        Map.Entry<String, h<NavBackStackEntryState>> r19 = r18.next();
        String r20 = r19.getKey();
        h<NavBackStackEntryState> r21 = r19.getValue();
        r17.add(r20);
        Parcelable[] r22 = new Parcelable[r21.size()];
        Iterator<NavBackStackEntryState> r23 = r21.iterator();
        int r24 = 0;
    L39:
        if (r23.hasNext() == false) goto L45;
        NavBackStackEntryState r25 = r23.next();
        int r110 = r24 + 1;
        if (r24 < 0) goto L43;
        r22[r24] = r25;
        r24 = r110;
        goto L39
    L43:
        r.p();
        throw null;
    L45:
        r6.putParcelableArray(KEY_BACK_STACK_STATES_PREFIX + r20, r22);
        goto L36
    L46:
        r6.putStringArrayList(KEY_BACK_STACK_STATES_IDS, r17);
    L48:
        if (this.deepLinkHandled == false) goto L52;
        if (r6 != null) goto L51;
        r6 = new Bundle();
    L51:
        r6.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
    L52:
        return r6;
    L11:
        r6 = null;
        goto L13
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int r2) {
        setGraph(getNavInflater().inflate(r2), null);
    }

    @CallSuper
    @MainThread
    public void setGraph(@NavigationRes int r2, Bundle r3) {
        setGraph(getNavInflater().inflate(r2), r3);
    }

    @CallSuper
    @MainThread
    public void setGraph(NavGraph r2) {
        o.f(r2, "graph");
        setGraph(r2, null);
    }

    @CallSuper
    @MainThread
    public void setGraph(NavGraph r10, Bundle r11) {
        o.f(r10, "graph");
        if (o.a(this._graph, r10) == true) goto L12;
        NavGraph r0 = this._graph;
        if (r0 == null) goto L11;
        Iterator r1 = new ArrayList(this.backStackMap.keySet()).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Integer r2 = (Integer) r1.next();
        o.e(r2, "id");
        clearBackStackInternal(r2.intValue());
        goto L8
    L10:
        popBackStackInternal$default(this, r0.getId(), true, false, 4, null);
    L11:
        this._graph = r10;
        onGraphCreated(r11);
        return;
    L12:
        int r12 = r10.getNodes().size();
        int r3 = 0;
    L13:
        if (r3 >= r12) goto L39;
        NavDestination r4 = r10.getNodes().valueAt(r3);
        NavGraph r5 = this._graph;
        o.c(r5);
        r5.getNodes().replace(r3, r4);
        h<NavBackStackEntry> r6 = getBackQueue();
        ArrayList r7 = new ArrayList();
        Iterator<NavBackStackEntry> r8 = r6.iterator();
    L16:
        if (r8.hasNext() == false) goto L25;
        NavBackStackEntry r9 = r8.next();
        NavBackStackEntry r13 = r9;
        if (r4 != null) goto L20;
    L22:
        boolean r14 = false;
    L23:
        if (r14 == false) goto L16;
        r7.add(r9);
        goto L16
    L20:
        if (r13.getDestination().getId() != r4.getId()) goto L22;
        r14 = true;
        goto L23
    L25:
        Iterator r15 = r7.iterator();
    L27:
        if (r15.hasNext() == false) goto L29;
        NavBackStackEntry r16 = (NavBackStackEntry) r15.next();
        o.e(r4, "newDestination");
        r16.setDestination(r4);
        goto L27
    L29:
        r3 = r3 + 1;
        goto L13
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State r2) {
        o.f(r2, "<set-?>");
        this.hostLifecycleState = r2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLifecycleOwner(LifecycleOwner r3) {
        o.f(r3, "owner");
        if (o.a(r3, this.lifecycleOwner) == false) goto L5;
        return;
    L5:
        LifecycleOwner r0 = this.lifecycleOwner;
        if (r0 == null) goto L10;
        Lifecycle r1 = r0.getLifecycle();
        if (r1 == null) goto L10;
        r1.removeObserver(this.lifecycleObserver);
    L10:
        this.lifecycleOwner = r3;
        r3.getLifecycle().addObserver(this.lifecycleObserver);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setNavigatorProvider(NavigatorProvider r2) {
        o.f(r2, "navigatorProvider");
        if (getBackQueue().isEmpty() == false) goto L7;
        this._navigatorProvider = r2;
        return;
    L7:
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnBackPressedDispatcher(OnBackPressedDispatcher r3) {
        o.f(r3, "dispatcher");
        if (o.a(r3, this.onBackPressedDispatcher) == false) goto L5;
        return;
    L5:
        LifecycleOwner r0 = this.lifecycleOwner;
        if (r0 == null) goto L10;
        this.onBackPressedCallback.remove();
        this.onBackPressedDispatcher = r3;
        r3.addCallback(r0, this.onBackPressedCallback);
        Lifecycle r4 = r0.getLifecycle();
        r4.removeObserver(this.lifecycleObserver);
        r4.addObserver(this.lifecycleObserver);
        return;
    L10:
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setViewModelStore(ViewModelStore r4) {
        o.f(r4, "viewModelStore");
        NavControllerViewModel r0 = this.viewModel;
        NavControllerViewModel.Companion r1 = NavControllerViewModel.Companion;
        if (o.a(r0, r1.getInstance(r4)) == false) goto L6;
        return;
    L6:
        if (getBackQueue().isEmpty() == false) goto L10;
        this.viewModel = r1.getInstance(r4);
        return;
    L10:
        throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry r3) {
        o.f(r3, "child");
        NavBackStackEntry r4 = this.childToParentEntries.remove(r3);
        Integer r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        AtomicInteger r1 = this.parentToChildCount.get(r4);
        if (r1 == null) goto L8;
        r0 = Integer.valueOf(r1.decrementAndGet());
    L8:
        if (r0 != null) goto L11;
    L16:
        return r4;
    L11:
        if (r0.intValue() != 0) goto L16;
        Navigator r2 = this._navigatorProvider.getNavigator(r4.getDestination().getNavigatorName());
        NavControllerNavigatorState r5 = this.navigatorState.get(r2);
        if (r5 == null) goto L15;
        r5.markTransitionComplete(r4);
    L15:
        this.parentToChildCount.remove(r4);
        goto L16
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        List r0 = r.B0(getBackQueue());
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        NavDestination r1 = ((NavBackStackEntry) r.b0(r0)).getDestination();
        if ((r1 instanceof FloatingWindow) == false) goto L15;
        Iterator r2 = r.m0(r0).iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        NavDestination r4 = ((NavBackStackEntry) r2.next()).getDestination();
        if ((r4 instanceof NavGraph) == true) goto L9;
        if ((r4 instanceof FloatingWindow) == true) goto L9;
    L16:
        HashMap r3 = new HashMap();
        Iterator r5 = r.m0(r0).iterator();
    L18:
        if (r5.hasNext() == false) goto L55;
        NavBackStackEntry r6 = (NavBackStackEntry) r5.next();
        Lifecycle.State r7 = r6.getMaxLifecycle();
        NavDestination r8 = r6.getDestination();
        if (r1 == null) goto L44;
        if (r8.getId() != r1.getId()) goto L44;
        Lifecycle.State r9 = Lifecycle.State.RESUMED;
        if (r7 == r9) goto L43;
        NavControllerNavigatorState r10 = this.navigatorState.get(getNavigatorProvider().getNavigator(r6.getDestination().getNavigatorName()));
        if (r10 == null) goto L32;
        v<Set<NavBackStackEntry>> r11 = r10.getTransitionsInProgress();
        if (r11 == null) goto L32;
        Set<NavBackStackEntry> r12 = r11.getValue();
        if (r12 == null) goto L32;
        Boolean r13 = Boolean.valueOf(r12.contains(r6));
    L34:
        if (o.a(r13, Boolean.TRUE) == true) goto L42;
        AtomicInteger r14 = this.parentToChildCount.get(r6);
        boolean r15 = false;
        if (r14 != null) goto L38;
    L40:
        if (r15 == true) goto L42;
        r3.put(r6, r9);
        goto L43
    L38:
        if (r14.get() != 0) goto L40;
        r15 = true;
    L42:
        r3.put(r6, Lifecycle.State.STARTED);
    L32:
        r13 = null;
    L43:
        r1 = r1.getParent();
    L44:
        if (r4 == null) goto L54;
        if (r8.getId() != r4.getId()) goto L54;
        if (r7 != Lifecycle.State.RESUMED) goto L50;
        r6.setMaxLifecycle(Lifecycle.State.STARTED);
    L53:
        r4 = r4.getParent();
        goto L18
    L50:
        Lifecycle.State r16 = Lifecycle.State.STARTED;
        if (r7 == r16) goto L53;
        r3.put(r6, r16);
    L54:
        r6.setMaxLifecycle(Lifecycle.State.CREATED);
        goto L18
    L55:
        Iterator r17 = r0.iterator();
    L57:
        if (r17.hasNext() == false) goto L62;
        NavBackStackEntry r18 = (NavBackStackEntry) r17.next();
        Lifecycle.State r19 = (Lifecycle.State) r3.get(r18);
        if (r19 != null) goto L60;
        r18.updateState();
        goto L57
    L60:
        r18.setMaxLifecycle(r19);
        goto L57
    L62:
        return;
    L15:
        r4 = null;
        goto L16
    }
}
