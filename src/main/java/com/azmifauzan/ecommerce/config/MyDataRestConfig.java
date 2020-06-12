package com.azmifauzan.ecommerce.config;

import com.azmifauzan.ecommerce.entity.Product;
import com.azmifauzan.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupport = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
        // disable it
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupport))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupport));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupport))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupport));
    }
}
