package com.example.barfx.models;

import com.example.barfx.interfaces.IMonitor;
import com.example.barfx.threads.Bartender;
import com.example.barfx.threads.Client;
import com.example.barfx.threads.Receptionist;

import java.util.Arrays;

public class Monitor implements IMonitor {

    private final Boolean[] chairsBuffer;
    private final Boolean[] clientsBuffer;

    public Monitor() {
        this.chairsBuffer = new Boolean[]{
                false, false, false, false, false, false, false, false, false, false
        };
        this.clientsBuffer = new Boolean[]{
                false, false, false
        };
    }

    @Override
    public synchronized void attendClientReceptionist() {

        while (!Arrays.asList(clientsBuffer).contains(false)){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < clientsBuffer.length; i++) {
            if (clientsBuffer[i]) {
                clientsBuffer[i] = true;
            }
        }
    }

    @Override
    public synchronized void attendedClientReceptionist() {

        for (int i = 0; i < clientsBuffer.length; i++) {
            if (clientsBuffer[i]) {
                clientsBuffer[i] = false;
            }
        }

        this.notifyAll();
    }

    @Override
    public synchronized void attendClientBartender() {}

    @Override
    public synchronized void attendedClientBartender() {}

    @Override
    public void clientArrive() {}

    @Override
    public void clientExit() {}
}
