CREATE KEYSPACE Mobacar WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;


use Mobacar;

CREATE TYPE cartype (
  sipp text,
  supplier text
);

CREATE TABLE QuoteSearch (
  paymentModel VARCHAR,
  reference UUID,
  total decimal,
  baseCurrency VARCHAR,
  paymentCurrency VARCHAR,
  exchangeRate decimal,
  browseTotal decimal,
  cartype frozen <cartype>,
  fromDate timestamp,
  toDate timestamp,
  pickupLocation VARCHAR,
  droppOffLocation VARCHAR,
  pickUpTime VARCHAR,
  dropOffTime VARCHAR,
  countryOfResidence VARCHAR,
  PRIMARY KEY ((fromDate, toDate,pickupLocation,droppOffLocation,pickUpTime,dropOffTime,countryOfResidence),reference));

  
  
  CREATE TABLE QuoteByReference (
  reference UUID,
  baseCurrency VARCHAR,
  paymentCurrency VARCHAR,
  fromDate timestamp,
  toDate timestamp,
  pickupLocation VARCHAR,
  droppOffLocation VARCHAR,
  pickUpTime VARCHAR,
  dropOffTime VARCHAR,
  countryOfResidence VARCHAR,
  PRIMARY KEY (reference));
  