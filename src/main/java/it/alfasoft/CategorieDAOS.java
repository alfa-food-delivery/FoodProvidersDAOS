package it.alfasoft;

import it.alfasoft.daosimple.DaoException;
import it.alfasoft.daosimple.DaoImpl;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategorieDAOS extends DaoImpl<Categoria,Integer> {
    @Override
    public String getSelectByIdQuery(Integer id) {
        return "SELECT * FROM " + this.getTableName() + " x WHERE x.id_categoria_food_provider = " + id;
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM " + this.getTableName();
    }

    @Override
    public String getInsertQuery(Categoria c) {
        return "INSERT INTO " + this.getTableName() + " x (nome_categoria_food_provider) "
                + "VALUES ('" + c.getNomeCategoria() + "');";
    }

    @Override
    public String getDeleteQuery(Integer id) {
        return "DELETE FROM " + this.getTableName() + " x WHERE x.id_categoria_food_provider = " + id + ";";
    }

    @Override
    public String getUpdateQuery(Integer id, Categoria c) {
        return "UPDATE " + this.getTableName()
                + " x SET x.ruolo = '" + c.getNomeCategoria() + "'"
                + " WHERE x.id_categoria_food_provider = " + id;
    }

    @Override
    public String getReplaceQuery(Integer id, Categoria c) {
        String nomeCategoriaFoodProvider = c.getNomeCategoria();
        StringBuilder queryBuilder = new StringBuilder("UPDATE " + this.getTableName() + " x SET ");
        if(nomeCategoriaFoodProvider!=null){queryBuilder.append(" x.nome_categoria_food_provider = '" + nomeCategoriaFoodProvider + "',");}

        //cancella ultima virgola "," se esiste
        int lastIndex = queryBuilder.length() - 1; //lunghezza di ","
        if(lastIndex > 0 && queryBuilder.substring(lastIndex).equals(",")){
            queryBuilder.delete(lastIndex,lastIndex+1);
        }

        queryBuilder.append(" WHERE x.id_categoria_food_provider = " + id);
        return queryBuilder.toString();
    }

    @Override
    public String getSearchByStringQuery(String searchText) {
        StringBuilder qb = new StringBuilder("SELECT * FROM " + this.getTableName() + " x WHERE x.nome_categoria_food_provider LIKE '%" + searchText + "%' ");
        return qb.toString();
    }

    @Override
    public String getSearchByObjectQuery(Categoria searchObj) {
        String nomeCategoriaFoodProvider = searchObj.getNomeCategoria();
        //Eccezione : oggetto passato non valido perché è tutto vuoto
        if(nomeCategoriaFoodProvider==null){ return "SELECT * FROM " + this.getTableName() + " x WHERE x.id_categoria_food_provider = 0";}

        StringBuilder qb = new StringBuilder("SELECT * FROM " + this.getTableName() + " x WHERE" );
        if(nomeCategoriaFoodProvider!=null){qb.append(" x.nome_categoria_food_provider LIKE '%" + nomeCategoriaFoodProvider + "%' AND");}

        // rimuovi l'ultimo "AND" se esiste
        int lastIndex = qb.length() - 4; // lunghezza di " AND"
        if (lastIndex > 0 && qb.substring(lastIndex).equals(" AND")) {
            qb.delete(lastIndex, lastIndex + 4);
        }
        return qb.toString();
    }

    @Override
    public Categoria convertToDto(ResultSet resultSet) throws DaoException {
        Categoria c = null;
        try{
            c = new Categoria(
                    resultSet.getInt("id_categoria_food_provider"),
                    resultSet.getString("nome_categoria_food_provider")
            );
            return c;
        }catch(Exception sqle){ sqle.printStackTrace(); throw new DaoException();}
    }

    @Override
    public boolean checkOggetto(Categoria c) throws DaoException {
        return true;
    }

    @Override
    public Integer getGeneratedKey(Statement s) throws DaoException{
        try{
            ResultSet rs = s.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException();
        }
    }

}















