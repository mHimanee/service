# service
REST  Web Service
### Product REST API
Made with:- 
  * Spring Boot 
  * Java 8
  * H2
  * Hibernate
#### Run:
  * In the Root folder(Service) run: mvnw.cmd clean spring-boot:run

###### Product Entity:
        {
            "productID": 2,
            "productName": "LG Washing Machine",
            "productType": "Washing Machine",
            "productCategory": "Home Appliances",
            "basePrice": 25000.0,
            "discount": 5500.0,
            "charges": {
                "gst": 6000.0,
                "delivery": 800.0
            },
            "finalPrice": 26300.0
        }
###### Project Tasks:
  * Implemnted CRUD for Product Entity as Specified.
  * Created Unit TESTS
  * Created Swagger/OAS Doc

###### GetAllProducts
![image](https://user-images.githubusercontent.com/114234365/195757335-c9a5621d-68a0-4cfd-9644-f69fe9abd7e0.png)

###### GetProductByID
![image](https://user-images.githubusercontent.com/114234365/195757443-108b82ca-59f1-46d3-9e4e-207a1df0779b.png)

###### Create Product
![image](https://user-images.githubusercontent.com/114234365/195757539-55bb0b05-4592-45bb-82f5-edcc0c017226.png)

###### Update Product
![image](https://user-images.githubusercontent.com/114234365/195757594-d8dd908a-791f-4733-b66d-0ed0189f3ed9.png)

###### Delete Product
![image](https://user-images.githubusercontent.com/114234365/195757668-af111cb8-0e24-42d8-acb1-8154d0edafbf.png)
