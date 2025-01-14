package com.grv.eCommerceApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.grv.eCommerceApp.entity.Product;
import com.grv.eCommerceApp.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod[] unsupportedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};
		
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions))
			.withCollectionExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions))
		.withCollectionExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions));
	}

}
