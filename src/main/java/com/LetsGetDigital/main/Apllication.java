package com.LetsGetDigital.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.LetsGetDigital.Facade.Facade;
import com.LetsGetDigital.controller.QuotationSearchController;
import com.LetsGetDigital.dao.QuotesDao;
import com.LetsGetDigital.engine.QuotationEngine;
import com.LetsGetDigital.model.Quote;
import com.LetsGetDigital.model.SearchCriteria;
import com.datastax.driver.core.Cluster;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Apllication extends Application<LetGetDigitalConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(Apllication.class);

	
	public static void main(final String[] args) throws Exception {
		new Apllication().run(args);
	}

	@Override
	public String getName() {
		return "LetsGetDIgitalApllication";
	}

	@Override
	public void initialize(final Bootstrap<LetGetDigitalConfiguration> bootstrap) {

	}

 
    
	@Override
	public void run(final LetGetDigitalConfiguration configuration,	final Environment environment) {
		LOG.warn("Running smoke test for {}", configuration.getCassandraFactory().getClusterName());

        Cluster cassandra = configuration.getCassandraFactory().build(environment);
		Injector injector = Guice.createInjector(new ServerModule(cassandra)); 
		environment.jersey().register(injector.getInstance(QuotationSearchController.class));
		LOG.warn("Running smoke test for keyspace {}", configuration.getCassandraFactory().getKeyspace());

	}

}
