package com.LetsGetDigital.main;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.stuartgunter.dropwizard.cassandra.CassandraFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LetGetDigitalConfiguration extends Configuration {
	@Valid
    @NotNull
    private CassandraFactory cassandra = new CassandraFactory();

   

    @JsonProperty("cassandra")
    public CassandraFactory getCassandraFactory() {
        return cassandra;
    }

  

    @JsonProperty("cassandra")
    public void setCassandraFactory(CassandraFactory cassandra) {
        this.cassandra = cassandra;
    }   


}
