package com.prasad.samples.doctor.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

@EnableOpenApi
@Configuration
public class SwaggerConfig {
	
	@Value("${swagger.securitySchemes.OAuth2.authorizationCode.client-id}")
	private String clientId;

	@Value("${swagger.securitySchemes.OAuth2.authorizationCode.client-secret}")
	private String clientSecret;

	@Value("${swagger.securitySchemes.OAuth2.authorizationCode.authorization-url}")
	private String authURL;

	@Value("${swagger.securitySchemes.OAuth2.authorizationCode.token-url}")
	private String tokenURL;


	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("/")
				.securitySchemes(Collections.singletonList(securitySchema()));
	}

	private OAuth securitySchema() {
		List<AuthorizationScope> authorizationScopeList = new ArrayList<AuthorizationScope>();
		List<GrantType> grantTypes = new ArrayList<GrantType>();
		final TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(authURL, clientId, clientSecret);
		final TokenEndpoint tokenEndpoint = new TokenEndpoint(tokenURL, "access_token");

		AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint);
		grantTypes.add(authorizationCodeGrant);

		OAuth oAuth = new OAuth("oauth", authorizationScopeList, grantTypes);
		return oAuth;
	}

	@Bean
	public SecurityConfiguration securityInfo() {
		return new SecurityConfiguration(clientId, clientSecret, "realm", clientId, "apiKey", ApiKeyVehicle.HEADER,
				"api_key", "");
		
	}
}