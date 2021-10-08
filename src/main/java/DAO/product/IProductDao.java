package DAO.product;

import DAO.IGeneralDao;
import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findProductByName(String name);
}
