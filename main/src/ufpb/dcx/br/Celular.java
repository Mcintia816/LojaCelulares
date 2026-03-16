//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package LojaDeCelulares;

import java.util.Objects;

public class Celular {
    private String codigo;
    private String marca;
    private String modelo;
    private double preco;
    private int QuantUnidades;

    public Celular(String codigo, String marca, String modelo, double preco, int quantUnidades) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public int getQuantUnidades() {
        return this.QuantUnidades;
    }

    public void setQuantUnidades(int quantUnidades) {
        this.QuantUnidades = quantUnidades;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean equals(Object o) {
        if (o != null && this.getClass() == o.getClass()) {
            Celular celular = (Celular)o;
            return Double.compare(this.preco, celular.preco) == 0 && Objects.equals(this.codigo, celular.codigo) && Objects.equals(this.marca, celular.marca) && Objects.equals(this.modelo, celular.modelo);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.codigo, this.marca, this.modelo, this.preco});
    }

    public String toString() {
        String var10000 = this.getCodigo();
        return "Celular de codigo: " + var10000 + "Marca: " + this.getMarca() + "Modelo: " + this.getModelo() + "Preço: " + this.getPreco();
    }
}
