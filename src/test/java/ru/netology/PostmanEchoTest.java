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
                .body(/* --> ваша проверка здесь <-- */)
        ;
    }



}
