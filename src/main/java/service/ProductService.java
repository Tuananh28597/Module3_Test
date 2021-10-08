package service;

import DAO.product.IProductDao;
import DAO.product.ProductDao;
import model.Product;

import java.util.List;

public class ProductService implements IProductService{
    private IProductDao productDao = (IProductDao) new ProductDao();


        @Override
        public List<Product> findProductByName(String name) {
            name = "%" + name + "%";
            return productDao.findProductByName(name);
        }

        @Override
        public List<Product> getAll() {
            List<Product> products = productDao.getAll();
            return products;
        }

        @Override
        public boolean save(Product product) {
            return productDao.save(product);
        }

        @Override
        public boolean update(int id, Product product) {
            return productDao.update(id,product);
        }

        @Override
        public boolean delete(int id) {
            return productDao.delete(id);
        }

        @Override
        public Product findById(int id) {
            return productDao.findById(id);
        }



}
