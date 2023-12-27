package it.alfasoft;

import it.alfasoft.daosimple.IDto;

import java.util.HashSet;
import java.util.Set;

public class Categoria implements IDto<Integer> {
    private Integer idCategoria;
    private String nomeCategoria;
    private Set<FoodProvider> foodProviders = new HashSet<>();

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nomeCategoria, Set<FoodProvider> foodProviders) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.foodProviders = foodProviders;
    }

    public Categoria(Integer idCategoria, String nomeCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public Integer getId(){
        return this.idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Set<FoodProvider> getFoodProviders() {
        return foodProviders;
    }

    public void setFoodProviders(Set<FoodProvider> foodProviders) {
        this.foodProviders = foodProviders;
    }

    public void addFoodProvider(FoodProvider fp){
        this.getFoodProviders().add(fp);
    }

    public void removeFoodProvider(FoodProvider fp){
        this.getFoodProviders().remove(fp);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nomeCategoria='" + nomeCategoria + '\'' +
                ", foodProviders=" + foodProviders +
                '}';
    }
}
