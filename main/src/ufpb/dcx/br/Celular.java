package ufpb.dcx.br;
import java.util.Objects;

public class  Celular {
    private String codigo;
    private String marca;
    private String modelo;
    private double preco;

    public Celular(String codigo, String modelo, String marca, double preco) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Celular celular = (Celular) o;
        return Double.compare(preco, celular.preco) == 0 && Objects.equals(codigo, celular.codigo) && Objects.equals(marca, celular.marca) && Objects.equals(modelo, celular.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, marca, modelo, preco);
    }

    @Override
    public String toString() {
        return "Celular de codigo: " + getCodigo() + "Marca: " + getMarca() + "Modelo: " + getModelo() + "Preço: " + getPreco();

    }
}
