package categoryproduct.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import categoryproduct.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
