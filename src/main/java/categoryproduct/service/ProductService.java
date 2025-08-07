package categoryproduct.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import categoryproduct.exception.ResourceNotFoundException;
import categoryproduct.model.Product;
import categoryproduct.repository.CategoryRepository;
import categoryproduct.repository.ProductRepository;


@Service
public class ProductService
{
	@Autowired
    private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo; 

   
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    public Product getById(Long id)
    {
        return productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }

    public String create(Product product) 
    {
        productRepo.save(product);
        return "Product added successfully!";
    }

//    public String update(Long id, Product updated) 
//    {
//        Product product = getById(id);
//        product.setName(updated.getName());
//        product.setPrice(updated.getPrice());
//        product.setCategory(updated.getCategory());
//        productRepo.save(product);
//        return "Product updated successfully!";
//    }
    
    public String update(Long id, Product updated) {
        Product product = getById(id);

        product.setName(updated.getName());
        product.setPrice(updated.getPrice());

        if (updated.getCategory() != null && updated.getCategory().getId() != null) {
            product.setCategory(
                categoryRepo.findById(updated.getCategory().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found"))
            );
        }

        productRepo.save(product);
        return "Product updated successfully!";
    }

    public String delete(Long id) 
    {
        getById(id);
        productRepo.deleteById(id);
        return "Product deleted successfully!";
    }
}