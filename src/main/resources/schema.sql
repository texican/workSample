
DROP TABLE IF EXISTS beers;
CREATE TABLE beers 
(
  id integer(21) NOT NULL,
  brewery_id integer(21) NOT NULL default '0',
  name varchar(255) NOT NULL default '',
  category_id integer(11) NOT NULL default '0',
  style_id integer(11) NOT NULL default '0',
  abv float NOT NULL default '0',
  ibu float NOT NULL default '0',
  srm float NOT NULL default '0',
  upc integer(40) NOT NULL default '0',
  filepath varchar(255) NOT NULL default '',
  description clob NOT NULL,
  add_user integer(11) NOT NULL default '0',
  last_mod datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (id)
);

DROP TABLE IF EXISTS breweries;
CREATE TABLE breweries (
  id integer(21) NOT NULL auto_increment,
  name varchar(255) NOT NULL default '',
  address1 varchar(255) NOT NULL default '',
  address2 varchar(255) NOT NULL default '',
  city varchar(255) NOT NULL default '',
  state varchar(255) NOT NULL default '',
  zip_code varchar(25) NOT NULL default '',
  country varchar(255) NOT NULL default '',
  phone varchar(50) NOT NULL default '',
  website varchar(255) NOT NULL default '',
  filepath varchar(255) NOT NULL default '',
  description clob NOT NULL,
  add_user integer(11) NOT NULL default '0',
  last_mod datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (id)
) ;

DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
  id integer(11) NOT NULL auto_increment,
  category_name varchar(255) NOT NULL default '',
  last_mod datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (id)
);

DROP TABLE IF EXISTS styles;
CREATE TABLE styles (
  id integer(11) NOT NULL auto_increment,
  category_id integer(11) NOT NULL default '0',
  style_name varchar(255) NOT NULL default '',
  last_mod datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (id)
)  