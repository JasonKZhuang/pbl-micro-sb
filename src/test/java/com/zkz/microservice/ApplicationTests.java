package com.zkz.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
    Mockito’s mock functionality in java unit testing
    Airtable airtableMock = mock(Airtable.class, "airtableMock");
    when(airtableMock.getMaxCap(any(), any())).thenReturn(1024);
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Test
    void contextLoads() {
        // Product product = new Product("The Ring");

        // webTestClient.post()
        //         .uri("/product")
        //         .bodyValue(product)
        //         .exchange()
        //         .expectStatus().is2xxSuccessful()
        //         .expectBody(Product.class).value(actualProduct -> {
        //     assertThat(actualProduct.getId()).isNotNull();
        //     assertThat(actualProduct.getName()).isEqualTo(product.getName());
        // });
    }

}
