package categoryproduct.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import categoryproduct.exception.ResourceNotFoundException;
import categoryproduct.model.Category;
import categoryproduct.repository.CategoryRepository;


@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository categoryRepo;
	
	  public Page<Category> getAll(Pageable pageable) {
	        return categoryRepo.findAll(pageable);
	    }

	    public Category getById(Long id) {
	        return categoryRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
	    }

	    public String create(Category category) {
	        categoryRepo.save(category);
	        return "Category added successfully!";
	    }

	    public String update(Long id, Category updated) {
	        Category category = getById(id);
	        category.setName(updated.getName());
	        categoryRepo.save(category);
	        return "Category updated successfully!";
	    }

	    public String delete(Long id) {
	        getById(id);
	        categoryRepo.deleteById(id);
	        return "Category deleted successfully!";
	    }
	
	
}
