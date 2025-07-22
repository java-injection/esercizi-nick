package it.ji.esercizi.u1.esercizio7.models;

import it.ji.esercizi.u1.esercizio7.exceptions.CampoNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TennisManager {
    private String nome;
    private List<Campo> campi = new ArrayList<>();
    private Map<String, Cliente> clienti = new HashMap<>();
    //la mappa ha 2 parametri generici: chiave e valore
    //Map<K, V> -> chiave, valore

    public TennisManager(String nome) {
        this.nome = nome;
    }

    public boolean isClientExisting(String telefono) {
        return clienti.containsKey(telefono);
    }

    public void addCliente(Cliente cliente) {
        clienti.put(cliente.getTelefono(), cliente);
        //il metodo put di una mappa prende 2 argomenti, il primo è la chiave e il secondo è il valore
    }

    public Cliente getClienteByTelefono(String telefono) {
        return clienti.get(telefono);
    }

    public String getNome() {
        return nome;
    }

    public void addCampo(Campo campo) {
        campi.add(campo);
    }

    // VARARGS
    public void addCampo(Campo ... campi) {
        for (Campo campo : campi) {
            this.campi.add(campo);
        }
    }

    public List<Campo> getCampi() {
        return campi;
    }

    public Campo getCampoById(int id) throws CampoNotFoundException {
        for (Campo campo : campi) {
            if (campo.getId() == id) {
                return campo;
            }
        }
        throw new CampoNotFoundException(id);
    }
}
