package com.LetsGetDigital.main;

import com.LetsGetDigital.engine.QuotationEngine;
import com.datastax.driver.core.Cluster;
import com.google.inject.AbstractModule;

public class ServerModule  extends AbstractModule {
 
	private Cluster sessionFaction;
	
    public ServerModule(Cluster sessionFaction) {
this.sessionFaction=sessionFaction;
}
	@Override
	protected void configure() {
      bind(Cluster.class).toInstance(sessionFaction);
      bind(QuotationEngine.class).toInstance(new QuotationEngine());

	}

	

	
}
