# NimapInfotechJavaMachineTest

**Features**

  1.Category CRUD (Create, Read, Update, Delete)
  
  2.Product CRUD with relation to Category
  
  3.One-to-Many relationship: One Category → Many Products
  
  4.Server-side pagination support for both Category and Product listing
  
  5.Product details include respective Category information

**Tech Stack**

1.Java 17

2.Spring Boot

3.Spring Data JPA

4.Hibernate

5.MySQL 

6.Lombok

7.Maven


**1) Category APIs**
   
1.http://localhost:8080/api/categories?page=3 = GET all the categories

2.http://localhost:8080/api/categoriee = POST - create a new category

3.http://localhost:8080/api/categories/{di} = GET category by Id

4.http://localhost:8080/api/categories/{di}  = PUT - update category by id

5.http://localhost:8080/api/categories/{di} = DELETE - Delete category by id

**2) Product CRUD operation.**
   
1.http://localhost:8080/api/products?page=2  = GET all the products

2.http://localhost:8080/api/products =  POST - create a new product

3.http://localhost:8080/api/products/{di} = GET product by Id

4.http://localhost:8080/api/products/{di} = PUT - update product by id

5.http://localhost:8080/api/products/{di} = DELETE - Delete product by id

 
