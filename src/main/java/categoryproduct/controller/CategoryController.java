package categoryproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import categoryproduct.model.Category;
import categoryproduct.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController 
{
	@Autowired
    private  CategoryService categoryService;



    @GetMapping
    public Page<Category> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "3") int size) 
    {
        return categoryService.getAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) 
    {
        return categoryService.getById(id);
    }

    @PostMapping
    public String create(@RequestBody Category category)
    {
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Category category)
    {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) 
    {
        return categoryService.delete(id);
    }
}