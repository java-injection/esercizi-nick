package it.ji.bancomat;

import java.util.Objects;

public class Carta {
    /*
    il codice della carta, il relativo pin di 4 cifre numerico, il nome e cognome dell'utente
        e il saldo attuale.
    */
    private String codiceCarta;
    private int pin;
    private String nome;
    private String cognome;
    private float saldo;

    public Carta(String codiceCarta, int pin, String nome, String cognome, float saldo) {
        this.codiceCarta = codiceCarta;
        this.pin = pin;
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
    }

    public String getCodiceCarta() {
        return codiceCarta;
    }

    public void setCodiceCarta(String codiceCarta) {
        this.codiceCarta = codiceCarta;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Carta{" + "codiceCarta=" + codiceCarta + ", pin=" + pin + ", nome=" + nome + ", cognome=" + cognome + ", saldo=" + saldo + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.pin != other.pin) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.codiceCarta, other.codiceCarta)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cognome, other.cognome);
    }


}
