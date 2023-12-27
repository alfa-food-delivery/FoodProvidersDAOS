package it.alfasoft;

import it.alfasoft.daosimple.DaoException;
import it.alfasoft.daosimple.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodProvidersDAOS extends DaoImpl<FoodProvider,Integer> {
    @Override
    public FoodProvider convertToDto(ResultSet resultSet) throws DaoException {
        FoodProvider fp = null;
        try{
            fp = new FoodProvider(
                    resultSet.getInt("id_food_provider"),
                    resultSet.getInt("id_categoria_food_provider"),
                    resultSet.getInt("id_profilo"),
                    resultSet.getString("partita_iva"),
                    resultSet.getString("nome_food_provider"),
                    resultSet.getDouble("prezzo_consegna"),
                    resultSet.getDouble("ordine_minimo"),
                    resultSet.getString("orario_food_provider")
            );
            return fp;
        }catch(Exception sqle){
            sqle.printStackTrace();
            throw new DaoException();
        }
    }

    @Override
    public boolean checkOggetto(FoodProvider fp) throws DaoException {
        if(fp.getIdProfilo()==null){ throw new DaoException("Il nuovo id_profilo non puo' essere vuoto"); }
        if(fp.getPartitaIva()==null){ throw new DaoException("La nuova partita iva non puo' essere vuota");}
        if(fp.getNomeFoodProvider()==null){ throw new DaoException("Il nuovo nome del food provider non puo' essere vuoto");}

        return true;
    }

    @Override
    public Integer getGeneratedKey(Statement statement) throws DaoException {
        try{
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e) { e.printStackTrace(); throw new DaoException(); }
    }

    @Override
    public String getSelectByIdQuery(Integer id) {
        return "SELECT * FROM " + this.getTableName() + " x WHERE x.id_food_provider = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM " + this.getTableName();
    }

    @Override
    public String getInsertQuery(FoodProvider fp) {
        return "INSERT INTO " + this.getTableName() + " (id_categoria_food_provider,id_profilo,partita_iva,nome_food_provider,prezzo_consegna,ordine_minimo,orario_food_provider) "
                + "VALUES ('" + fp.getIdCategoriaFoodProvider() + "','" + fp.getIdProfilo() + "','" + fp.getPartitaIva() + "','" + fp.getNomeFoodProvider() + "','" + fp.getPrezzoConsegna() + "','" + fp.getOrdineMinimo() + "','" + fp.getOrarioFoodProvider() + "');";
    }

    @Override
    public String getDeleteQuery(Integer id) {
        return "DELETE FROM " + this.getTableName() + " x WHERE x.id_food_provider = " + id + ";";
    }

    @Override
    public String getUpdateQuery(Integer id, FoodProvider fp) {
        return "UPDATE " + this.getTableName()
                + " x SET x.id_categoria_food_provider = '" + fp.getIdCategoriaFoodProvider() + "' , "
                + " x.id_profilo = '" + fp.getIdProfilo() + "'"
                + " x.partita_iva = '" + fp.getPartitaIva() + "'"  //FINIREEEEE
                + " WHERE x.id_utente = " + id;
    }


    //DA TERMINARE E RIVEDERE


}
