package it.alfasoft;

import it.alfasoft.daosimple.IDto;

import java.util.HashSet;
import java.util.Set;

public class FoodProvider implements IDto<Integer> {
    private Integer idFoodProvider;
    private Integer idCategoriaFoodProvider;
    private Integer idProfilo;
    private String partitaIva;
    private String nomeFoodProvider;
    private double prezzoConsegna;
    private double ordineMinimo;
    private String orarioFoodProvider;
    private Set<Categoria> categorie = new HashSet<>();

    public FoodProvider() {
    }

    public FoodProvider(Integer idFoodProvider, Integer idCategoriaFoodProvider, Integer idProfilo, String partitaIva, String nomeFoodProvider, double prezzoConsegna, double ordineMinimo, String orarioFoodProvider) {
        this.idFoodProvider = idFoodProvider;
        this.idCategoriaFoodProvider = idCategoriaFoodProvider;
        this.idProfilo = idProfilo;
        this.partitaIva = partitaIva;
        this.nomeFoodProvider = nomeFoodProvider;
        this.prezzoConsegna = prezzoConsegna;
        this.ordineMinimo = ordineMinimo;
        this.orarioFoodProvider = orarioFoodProvider;
    }

    @Override
    public Integer getId(){
        return this.idFoodProvider;
    }
    //GETTERS
    public Integer getIdCategoriaFoodProvider() {
        return idCategoriaFoodProvider;
    }

    public Integer getIdProfilo() {
        return idProfilo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public String getNomeFoodProvider() {
        return nomeFoodProvider;
    }

    public double getPrezzoConsegna() {
        return prezzoConsegna;
    }

    public double getOrdineMinimo() {
        return ordineMinimo;
    }

    public String getOrarioFoodProvider() {
        return orarioFoodProvider;
    }

    public Set<Categoria> getCategorie() {
        return categorie;
    }

    //SETTERS

    public void setIdFoodProvider(Integer idFoodProvider) {
        this.idFoodProvider = idFoodProvider;
    }

    public void setIdCategoriaFoodProvider(Integer idCategoriaFoodProvider) {
        this.idCategoriaFoodProvider = idCategoriaFoodProvider;
    }

    public void setIdProfilo(Integer idProfilo) {
        this.idProfilo = idProfilo;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public void setNomeFoodProvider(String nomeFoodProvider) {
        this.nomeFoodProvider = nomeFoodProvider;
    }

    public void setPrezzoConsegna(double prezzoConsegna) {
        this.prezzoConsegna = prezzoConsegna;
    }

    public void setOrdineMinimo(double ordineMinimo) {
        this.ordineMinimo = ordineMinimo;
    }

    public void setOrarioFoodProvider(String orarioFoodProvider) {
        this.orarioFoodProvider = orarioFoodProvider;
    }

    public void setCategorie(Set<Categoria> categorie) {
        this.categorie = categorie;
    }

    public void addCategoria(Categoria c){
        this.getCategorie().add(c);
        c.addFoodProvider(this);
    }
    public void removeCategoria(Categoria c){
        this.getCategorie().remove(c);
        c.removeFoodProvider(this);
    }

    @Override
    public String toString() {
        return "FoodProvider{" +
                "idFoodProvider=" + idFoodProvider +
                ", idCategoriaFoodProvider=" + idCategoriaFoodProvider +
                ", idProfilo=" + idProfilo +
                ", partitaIva='" + partitaIva + '\'' +
                ", nomeFoodProvider='" + nomeFoodProvider + '\'' +
                ", prezzoConsegna=" + prezzoConsegna +
                ", ordineMinimo=" + ordineMinimo +
                ", orarioFoodProvider='" + orarioFoodProvider + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
