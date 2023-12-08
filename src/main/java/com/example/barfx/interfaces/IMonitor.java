package com.example.barfx.interfaces;

public interface IMonitor {
    void attendClientReceptionist();
    void attendedClientReceptionist();

    void attendClientBartender();
    void attendedClientBartender();

    void clientArrive();
    void clientExit();
}
