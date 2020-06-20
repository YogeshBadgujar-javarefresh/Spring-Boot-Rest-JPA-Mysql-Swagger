# Spring-Boot-Rest-JPA-Mysql-Swagger

<b>Requirements -</b> Implement a simple contacts database to store personal and company contact details. The requirement is to keep a list of customers and suppliers. 
A customer or supplier can be a person or a company, but not both. Additionally, a company or person can be a supplier <br>
and a customer at the same time. For this implementation assume all fields are required, but no other validation is necessary.<br>

<b>Solution -</b> Created the Rest API for Customers and Suppliers e.g. get all customer, based on taxnumber, based of sending search criteria, create the customer, soft delete the customer, re-active the customer etc.<br>
REST API will fetch data from different layers i.e. Service and DAO layer.<br>

<b>Technologies -</b> Java, Spring Boot, Spring JPA, Spring REST, Swagger or Postman for testing, Mysql DB, Maven for build.<br>
<b>REST API</b>
<table>
  <tr>
  <th>RESTful URL</th>
  <th>HTTP Action</th>
  <th>Business Operation/Description</th>
  </tr>
  <tr><td colspan="3"><b>Customer Rest API end points</b></td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customers</td><td>GET</td><td>Get all customers</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customer/{id}</td><td>GET</td><td>Get the customer by id</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customerNumber/{customerNumber}</td><td>GET</td><td>Get the customer by customer number</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customers</td><td>POST</td><td>Search by id, customer number Provide the JSON data in SearchCustomer bean</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customer</td><td>POST</td><td>Save customer - pass CustomerBean JSON </td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customer</td><td>PUT</td><td>Update customer - pass CustomerBean JSON --TODO - Not implement </td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customer/{customerNumber}</td><td>DELETE</td><td>Soft delete customer</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/customer/{customerNumber}</td><td>PUT</td><td>Re-active customer</td></tr>

<tr><td colspan="3"><b>Supplier Rest API end points</b></td></tr>
<tr><td>http://localhost:8080/custSupplierApp/suppliers</td><td>GET</td><td>Get all suppliers</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplier/{id}</td><td>GET</td><td>Get the supplier by id</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplierTaxNumber/{taxNumber}</td><td>GET</td><td>Get the supplier by tax number</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/suppliers</td><td>POST</td><td>Search by id, tax number Provide the JSON data in SearchSupplier bean</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplier</td><td>POST</td><td>Save supplier -  pass SupplierBean JSON </td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplier/</td><td>PUT</td><td>Update supplier - pass SupplierBean JSON--TODO - Not implement</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplier/{taxNumber}</td><td>DELETE</td><td>Soft delete supplier</td></tr>
<tr><td>http://localhost:8080/custSupplierApp/supplier/{taxNumber}</td><td>PUT</td><td>Re-active supplier</td></tr>

  </table>


<b>Testing -</b><br>
Swagger UI -<br>
http://localhost:8080/custSupplierApp/swagger-ui.html<br>
Postman Also.<br>

Swagger JSON base -<br>
http://localhost:8080/custSupplierApp/v2/api-docs<br>
