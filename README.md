# Spring-Boot-Rest-JPA-Mysql-Swagger

<b>Requirements -</b> Implement a simple contacts database to store personal and company contact details. The requirement is to keep a list of customers and suppliers. 
A customer or supplier can be a person or a company, but not both. Additionally, a company or person can be a supplier <br>
and a customer at the same time. For this implementation assume all fields are required, but no other validation is necessary.<br>

<b>Solution -</b> Created the Rest API for Customers and Suppliers e.g. get all customer, based on taxnumber, based of sending search criteria, create the customer, soft delete the customer, re-active the customer etc.<br>
REST API will fetch data from different layers i.e. Service and DAO layer.<br>

<b>Technologies -</b> Java, Spring Boot, Spring JPA, Spring REST, Swagger or Postman for testing, Mysql DB, Maven for build.<br>

<b>Customer Rest API end points -</b><br>
GET - http://localhost:8080/custSupplierApp/customers - Get all customers <br>
GET - http://localhost:8080/custSupplierApp/customer/{id} - Get the customer by id <br>
GET - http://localhost:8080/custSupplierApp/customerNumber/{customerNumber} - Get the customer by customer number <br>
POST - http://localhost:8080/custSupplierApp/customers - Search by id, customer number Provide the JSON data in SearchCustomer bean<br>
POST - http://localhost:8080/custSupplierApp/customer - Save customer - pass CustomerBean JSON <br>
PUT - http://localhost:8080/custSupplierApp/customer - Update customer - pass CustomerBean JSON --TODO - Not implement <br>
DELETE - http://localhost:8080/custSupplierApp/customer/{customerNumber} - Soft delete customer <br>
PUT - http://localhost:8080/custSupplierApp/customer/{customerNumber} - Re-active customer <br>

<b>Supplier Rest API end points -</b><br>
GET - http://localhost:8080/custSupplierApp/suppliers - Get all suppliers <br>
GET - http://localhost:8080/custSupplierApp/supplier/{id} - Get the supplier by id <br>
GET - http://localhost:8080/custSupplierApp/supplierTaxNumber/{taxNumber} - Get the supplier by tax number <br>
POST - http://localhost:8080/custSupplierApp/suppliers - Search by id, tax number Provide the JSON data in SearchSupplier bean <br>
POST - http://localhost:8080/custSupplierApp/supplier - Save supplier -  pass SupplierBean JSON <br>
PUT - http://localhost:8080/custSupplierApp/supplier/- Update supplier - pass SupplierBean JSON--TODO - Not implement <br>
DELETE - http://localhost:8080/custSupplierApp/supplier/{taxNumber} - Soft delete supplier <br>
PUT - http://localhost:8080/custSupplierApp/supplier/{taxNumber} - Re-active supplier <br>

<b>Testing -</b><br>
Swagger UI -<br>
http://localhost:8080/custSupplierApp/swagger-ui.html<br>
Postman Also.<br>

Swagger JSON base -<br>
http://localhost:8080/custSupplierApp/v2/api-docs<br>
