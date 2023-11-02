# Library Application

## Dependencies:
* Spring Boot DevTools
* Lombok
* Spring Data JPA
* Spring Data JDBC
* MySQL Driver

## Technologies:
* Java Spring 17
* MySQL
* Hibernate
* Postman

### Açıklama

Bu proje Spring Boot Maven ile geliştirilmiştir. 
Kütüphanenize kitap ve yazar eklemeleri yapabilir, bütün kitapları ya da listeleyebilir, istediğiniz yazarın kitaplarına erişebilir, güncelleyebilir ya da silebilirsiniz.


**Localinizde MySQL Database kurulu olmalıdır. MySQL libraryinize enocalibrary db oluşturunuz. Projeye gerekli maven dependencyleri ekleyiniz.**


POST `/api/author/create`

###### Response Example:

`{ 
    "author" :{
            "id":3,
            "fullName": "Sevda OLGUN"
    },
"statusCode" : 201,
"httpStatus" : "CREATED"
}`


POST `/api/book/createBook`

###### Response Example:

`{
"book": {
"id": 9,
"title": "Yeşil Vadi",
"yearOfPublication": 1998,
"isbn": 3235,
"authorName": "Sevda OLGUN"
},
"statusCode": 201,
"httpStatus": "CREATED"
}`


GET `/api/author/getAuthor/3`

###### Response Example:

`{
"author": {
"id": 3,
"fullName": "Sevda OLGUN"
},
"statusCode": 200,
"httpStatus": "ACCEPTED"
}`


GET `/api/author/getAllAuthor`

###### Response Example:

`{
"authorList": [
{
"id": 3,
"fullName": "Sevda OLGUN"
},
{
"id": 4,
"fullName": "Seda KANBUR"
},
{
"id": 5,
"fullName": "Deniz GÜZEL"
}
],
"statusCode": 200,
"httpStatus": "ACCEPTED"
}`


GET `/api/book/9`

###### Response Example:

`{
"book": {
"id": 9,
"title": "Yeşil Vadi",
"yearOfPublication": 1998,
"isbn": 3235,
"authorName": "Sevda OLGUN"
},
"statusCode": 200,
"httpStatus": "ACCEPTED"
}`


GET `/api/book/getAllBook`

###### Response Example:

`{
"bookList": [
{
"id": 9,
"title": "Yeşil Vadi",
"yearOfPublication": 1998,
"isbn": 3235,
"authorName": "Sevda OLGUN"
},
{
"id": 10,
"title": "Karabük'ün Yolları",
"yearOfPublication": 1998,
"isbn": 3235,
"authorName": "Seda KANBUR"
}
],
"statusCode": 200,
"httpStatus": "ACCEPTED"
}`


GET `/api/book/getBooksOfAuthor/3`

###### Response Example:

`{
"bookList": [
{
"id": 9,
"title": "Yeşil Vadi",
"yearOfPublication": 1998,
"isbn": 3235,
"authorName": "Sevda OLGUN"
},
{
"id": 11,
"title": "Ufak Bir Hayat Meselesi",
"yearOfPublication": 2023,
"isbn": 3235,
"authorName": "Sevda OLGUN"
}
],
"statusCode": 200,
"httpStatus": "ACCEPTED"
}`


PUT `/api/author/update/2`

###### Response Example:

`{
"message": "Updated!",
"httpStatus": "ACCEPTED"
}`


PUT `/api/book/update/10`

###### Response Example:

`{
"message": "Updated!",
"httpStatus": "ACCEPTED"
}`


DELETE `/api/author/delete/5`

###### Response Example:

`{
"message": "Deleted!",
"httpStatus": "ACCEPTED"
}`

DELETE `/api/book/delete/10`

###### Response Example:

`{
"message": "Deleted!",
"httpStatus": "ACCEPTED"
}`


