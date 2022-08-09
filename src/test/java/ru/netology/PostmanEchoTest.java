package ru.netology;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.w3c.dom.CDATASection;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;


public class PostmanEchoTest {

    @Test
    void shouldPostRequest() {
        // Given - When - Then
// Предусловия
         given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldPostRequestInRussian() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("привет") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("привет"))
        ;
    }

    @Test
    void shouldGetRequest() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
// Выполняемые действия
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
// Проверки
                .then()
//                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .header("Connection", equalTo("keep-alive"))
                .contentType("application/json; charset=utf-8")
        ;
    }



}
