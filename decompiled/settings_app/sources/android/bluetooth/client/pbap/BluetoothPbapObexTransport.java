package android.bluetooth.client.pbap;

import android.bluetooth.BluetoothSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.obex.ObexTransport;

/* JADX INFO: loaded from: classes.dex */
class BluetoothPbapObexTransport implements ObexTransport {
    private BluetoothSocket mSocket;

    @Override // javax.obex.ObexTransport
    public void connect() throws IOException {
    }

    @Override // javax.obex.ObexTransport
    public void create() throws IOException {
    }

    @Override // javax.obex.ObexTransport
    public void disconnect() throws IOException {
    }

    @Override // javax.obex.ObexTransport
    public int getMaxReceivePacketSize() {
        return -1;
    }

    @Override // javax.obex.ObexTransport
    public int getMaxTransmitPacketSize() {
        return -1;
    }

    @Override // javax.obex.ObexTransport
    public boolean isSrmSupported() {
        return false;
    }

    @Override // javax.obex.ObexTransport
    public void listen() throws IOException {
    }

    public BluetoothPbapObexTransport(BluetoothSocket r1) {
        this.mSocket = r1;
    }

    @Override // javax.obex.ObexTransport
    public void close() throws IOException {
        this.mSocket.close();
    }

    @Override // javax.obex.ObexTransport
    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(openInputStream());
    }

    @Override // javax.obex.ObexTransport
    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(openOutputStream());
    }

    @Override // javax.obex.ObexTransport
    public InputStream openInputStream() throws IOException {
        return this.mSocket.getInputStream();
    }

    @Override // javax.obex.ObexTransport
    public OutputStream openOutputStream() throws IOException {
        return this.mSocket.getOutputStream();
    }

    public boolean isConnected() throws IOException {
        return this.mSocket.isConnected();
    }
}
