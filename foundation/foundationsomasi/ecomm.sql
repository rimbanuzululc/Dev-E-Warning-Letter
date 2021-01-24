CREATE DATABASE ecomm
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Indonesian_Indonesia.1252'
    LC_CTYPE = 'Indonesian_Indonesia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
CREATE TABLE ecomm_paymenttypes (
"paymenttypeid" serial primary key not null,
"name" varchar(255),
"code" varchar(32),
"creditflag" bool,
"activeflag" bool
);

CREATE TABLE ecomm_country (
"countryid" serial primary key not null,
"code" varchar(100),
"name" varchar(255),
"isactive" bool,
"allowotherstate" bool,
"countryorder" integer
);

CREATE TABLE ecomm_state (
"stateid" serial primary key not null,
"countryid" integer references ecomm_country(countryid),
"code" varchar(100),
"name" varchar(255),
"isactive" bool,
"stateorder" integer
);

CREATE TABLE ecomm_city (
"cityid" serial primary key not null,
"stateid" integer references ecomm_state(stateid),
"code" varchar(100),
"name" varchar(255),
"isactive" bool,
"cityorder" integer
);

CREATE TABLE ecomm_district (
"districtid" serial primary key not null,
"cityid" integer references ecomm_city(cityid),
"code" varchar(100),
"name" varchar(255),
"isactive" bool,
"districtorder" integer
);

CREATE TABLE ecomm_subdistrict (
"subdistrictid" serial primary key not null,
"districtid" integer references ecomm_district(districtid),
"code" varchar(100),
"name" varchar(255),
"isactive" bool,
"subdistrictorder" integer
);

CREATE TABLE ecomm_address (
"addressid" serial primary key not null,
"addressline1" varchar(255),
"addressline2" varchar(255),
"countryid" integer references ecomm_country(countryid),
"stateid" integer references ecomm_state(stateid),
"cityid" integer references ecomm_city(cityid),
"districtid" integer references ecomm_district(districtid),
"subdistrictid" integer references ecomm_subdistrict(subdistrictid),
"rw" varchar(255),
"rt" varchar(255),
"no" varchar(255),
"zipcode" varchar(255),
"remarks" varchar(255)
);
CREATE TABLE ecomm_vendors (
"vendorid" serial primary key not null,
"vendorname" varchar(255),
"vendorcode" varchar(100),
"selleridfif" varchar(100),
"sellertype" varchar(100),
"companyname" varchar(255),
"ownername" varchar(255),
"storename" varchar(255),
"logo" varchar(255),
"description" text,
"npwpnumber" varchar(100),
"siup" varchar(100),
"ktp" varchar(100),
"pkp" varchar(100),
"tagline" varchar(255),
"mobilephone" varchar(100),
"phonearea" varchar(10),
"phonenumber" varchar(100),
"storeadminname" varchar(255),
"storeadmindob" date,
"storeadminemail1" varchar(255),
"storeadminemail2" varchar(255),
"storeadminmobilephone" varchar(100),
"storeadminphonearea" varchar(10),
"storeadminphonenumber" varchar(100),
"bankname" varchar(255),
"bankaccountnumber" varchar(255),
"bankaccountname" varchar(255),
"settlementmethod" varchar(255),
"npwppath" varchar(255),
"siuppath" varchar(255),
"pkppath" varchar(255),
"statementletter" varchar(255),
"isactive" bool,
"vendorrating" integer,
"createddate" timestamp(6),
"createdby" varchar(255),
"lastmodifieddate" timestamp(6),
"lastmodifiedby" varchar(255),
"image" text,
"imagefilename" varchar(255)
);

CREATE TABLE ecomm_agentinvitationcode (
"agentinvitationcodeid" serial primary key not null,
"communityname" varchar(100),
"invitationcode" varchar(100),
"flagmembership" bool,
"isfullclosedloop" bool,
"vendorid" integer references ecomm_vendors(vendorid),
"createddate" timestamp(6),
"createdby" varchar(255),
"lastmodified" timestamp(6),
"lastmodifiedby" varchar(255)
);

CREATE TABLE ecomm_agent (
"agentid" serial primary key not null,
"agentnumber" varchar(100),
"fullname" varchar(255),
"nickname" varchar(100),
"gender" varchar(100),
"birthplace" varchar(100),
"birthdate" date,
"occupation" varchar(100),
"phonenumber" varchar(100),
"email" varchar(100),
"bankname" varchar(100),
"bankaccountnumber" varchar(100),
"bankaccountname" varchar(100),
"password" varchar(100),
"grandparentagent" integer,
"parentagent" integer,
"agentinvitationcodeid" integer references ecomm_agentinvitationcode(agentinvitationcodeid),
"created" timestamp(6),
"lastmodified" time(6)
);

CREATE TABLE ecomm_customers (
"customerid" serial primary key not null,
"fullname" varchar(255),
"username" varchar(255),
"password" varchar(255),
"status" varchar(255),
"firstname" varchar(255),
"lastname" varchar(255),
"phonearea" varchar(20),
"phone" varchar(20),
"mobilephone1" varchar(20),
"mobilephone2" varchar(20),
"email1" varchar(255),
"email2" varchar(255),
"agentid" integer references ecomm_agent(agentid),
"created" timestamp(6),
"lastmodified" timestamp(6)
);


CREATE TABLE ecomm_brands (
"brandid" serial primary key not null,
"name" varchar(255)
);

CREATE TABLE ecomm_products (
"productid" serial primary key not null,
"name" varchar(255),
"description" text,
"vendorid" integer references ecomm_vendors(vendorid),
"brandid" integer references ecomm_brands(brandid),
"categoryid" integer references ecomm_categories(categoryid),
"rating" integer,
"weight" integer,
"length" integer,
"width" integer,
"height" integer
);

CREATE TABLE ecomm_warehouse (
"warehouseid" serial primary key not null,
"vendorid" integer references ecomm_vendors(vendorid),
"warehouseaddressid" integer references ecomm_address(addressid),
"warehousename" varchar(255),
"returnaddressid" integer references ecomm_address(addressid)
);

CREATE TABLE ecomm_skus (
"skuid" serial primary key not null,
"productid" integer references ecomm_products(productid),
"dealerprice" integer,
"margintype" varchar(255),
"margintypevalue" numeric(20,4),
"marginvalue" numeric(20,4),
"skucode" varchar(100),
"garansi" varchar(255),
"publishprice" numeric(20,4),
"marginbeforetax" numeric(20,4),
"image" text,
"imagefilename" varchar(225)
);

CREATE TABLE ecomm_carts (
"customerid" integer references ecomm_customers(customerid),
"skuid" integer references ecomm_skus(skuid),
"quantity" integer
);


CREATE TABLE ecomm_categories (
"categoryid" serial primary key not null,
"name" varchar(255),
"code" varchar(100),
"parentcategory" integer,
"mobilevisibility" bool,
"webvisibility" bool,
"image" text,
"imagefilename" varchar(255),
"categoryorder" integer,
"oncategorytree" bool,
"isactive" bool,
"feeadmin" numeric(10),
"feeadminfif" numeric(10),
"createddate" timestamp(6),
"createdby" varchar(255),
"lastmodified" timestamp(6),
"lastmodifiedby" varchar(255)
);

CREATE TABLE ecomm_categoryattributes (
"attributeid" serial primary key not null,
"categoryid" integer references ecomm_categories(categoryid),
"name" varchar(255),
"type" varchar(255)
);

CREATE TABLE ecomm_customeraddress (
"customerid" integer references ecomm_customers(customerid),
"addressid" integer references ecomm_address(addressid),
"addresstype" varchar(255)
);

CREATE TABLE ecomm_discounts
( 
"discountid" serial primary key not null,
"discountcode" varchar(255),    
"discountname" varchar(255),   
"discounttype" varchar(255),    
"applyto" varchar(255),   
"reward" varchar(255),    
"minimumshipping" bigint,    
"percentage" integer,   
"amount" bigint,   
"minimumorder" bigint,   
"maximumorder" bigint,   
"discountfor" varchar(255),   
"startdate" timestamp without time zone,    
"enddate" timestamp without time zone,    
"discountlimit" integer,    
"discountused" integer,    
"isactive" boolean,    
"vendorid" integer references ecomm_vendors(vendorid),    
"discounttypeitem" varchar(255),    
"discountagentid" integer
);

CREATE TABLE ecomm_discountconditions (
"conditionid" serial primary key not null,
"discountid" integer references ecomm_discounts(discountid),
"conditiontype" varchar(255),
"comparatortype" varchar(255),
"conditionvalue" varchar(255)
);

CREATE TABLE ecomm_discountconditionvalues (
"conditionid" integer not null,
"targetid" serial not null,
primary key(conditionid,targetid),
foreign key (conditionid) references ecomm_discountconditions(conditionid)
);

CREATE TABLE ecomm_discountbrands
(   
"discountbrandid" serial primary key not null,    
"discountid" integer references ecomm_discounts(discountid),    
"brandid" integer references ecomm_brands(brandid)
);

CREATE TABLE ecomm_discountskus
(    
"discountskuid" serial primary key not null,    
"discountid" integer references ecomm_discounts(discountid),   
"skuid" integer references ecomm_skus(skuid)
);


CREATE TABLE ecomm_discountcategories(
	discountcategoryid serial primary key not null,
	discountid integer references ecomm_discounts(discountid),
	categoryid integer references ecomm_categories(categoryid)
);

CREATE TABLE ecomm_feecommission (
"feecommissionid" serial primary key not null,
"name" varchar(100),
"activedate" date,
"feeagent" numeric(6,2),
"feesubagent1" numeric(6,2),
"feesubagent2" numeric(6,2),
"feefifada" numeric(6,2)
);

CREATE TABLE ecomm_ordergroups (
orderGroupId serial,
    
customerId int,    
    
virtualAccount varchar(32),
    
status varchar(32),
    
statusTime timestamp,
    
byAgentFlag bool,
    
agentId int,
    
paymentTypeId int,
    
paymentTypeName varchar(255),
    
creditFlag bool,
    
total int,
    
totalDiscount int,
    
totalFee int,
    
totalShipping int,
    
grandTotal int,
    
downPayment int,
    
installment int,
    
paymentPeriode int,
    
firstPayment int,
    
primary key (orderGroupId)
);

CREATE TABLE ecomm_shippings (
"shippingid" serial primary key not null,
"name" varchar(255),
"activeflag" varchar(255)
);

create table ecomm_orders
(
	orderId serial,
    orderGroupId int,
    warehouseId int,
    shippingPackageId int,
    shippingPackageName varchar(255),
    shippingId int,
    shippingName varchar(255),
    total int,
    totalShipping int,
    totalDiscount int,
    vendorId int,
    vendorName varchar(255),
    created timestamp,
    lastModified timestamp,
    warehouseCity varchar(255),
    warehouseZipcode varchar(255),
    primary key (orderId)
);

CREATE TABLE ecomm_orderitems (
"orderid" integer references ecomm_orders(orderid),
"skuid" integer references ecomm_skus(skuid),
"quantity" integer,
"publishprice" integer,
"margintype" varchar(255),
"margintypevalue" numeric(20,4),
"marginvalue" numeric(20,4),
"discountid" integer references ecomm_discounts(discountid),
"totaldiscount" numeric(20,4)
);

CREATE TABLE ecomm_productcategories (
"productid" integer,
"categoryid" integer,
"mainflag" varchar(255),
primary key (productid,categoryid),
foreign key (productid) references ecomm_products(productid),
foreign key (categoryid) references ecomm_categories(categoryid)
);

CREATE TABLE ecomm_productpayments (
"productid" integer,
"paymenttypeid" integer,
primary key(productid,paymenttypeid),
foreign key (productid) references ecomm_products(productid),
foreign key (paymenttypeid) references ecomm_paymenttypes(paymenttypeid)
);


CREATE TABLE ecomm_productshippings (
"productid" integer,
"shippingid" integer,
primary key(productid,shippingid),
foreign key (productid) references ecomm_products(productid),
foreign key (shippingid) references ecomm_shippings(shippingid)
);

CREATE TABLE ecomm_promo (
"promoid" serial primary key not null,
"promoname" varchar(255),
"type" varchar(255),
"largeimage" varchar(255),
"mediumimage" varchar(255),
"smallimage" varchar(255),
"order" integer,
"startdate" timestamp(6),
"enddate" timestamp(6),
"description" text,
"bannerlink" varchar(255),
"isactive" bool,
"createddate" timestamp(6),
"createdby" varchar(255),
"lastmodified" timestamp(6),
"lastmodifiedby" varchar(255)
);

CREATE TABLE ecomm_skuattributes (
"skuid" integer references ecomm_skus(skuid),
"attributeid" integer references ecomm_categoryattributes(attributeid),
"value" varchar(255)
);

CREATE TABLE ecomm_user (
"userid" varchar(255) NOT NULL,
"name" varchar(255),
"password" varchar(255),
"created" timestamp(6),
"lastlogin" timestamp(6),
"roleid" integer references ecomm_role(roleid)
);

CREATE TABLE ecomm_vendoraddress (
"vendorid" integer references ecomm_vendors(vendorid),
"addressid" integer references ecomm_address(addressid),
"addresstype" varchar(255)
);


CREATE TABLE ecomm_zipcode (
"zipcodeid" serial primary key not null,
"stateid" integer references ecomm_state(stateid),
"cityid" integer references ecomm_city(cityid),
"districtid" integer references ecomm_district(districtid),
"subdistrictid" integer references ecomm_subdistrict(subdistrictid),
"zipcode" varchar(100),
"description" varchar(255),
"isactive" bool
);


CREATE TABLE ecomm_paramgroup(
	"groupcode" varchar(32) primary key not null,
	"description" varchar(255)
);

CREATE TABLE ecomm_param(
	"groupcode" varchar(32),
	"paramcode" varchar(32),
	"paramvalue" varchar(255),
	"description" varchar(255),
	"displayorder" int,
	primary key(groupcode,paramcode),
	foreign key (groupcode) references ecomm_paramgroup
);

CREATE TABLE ecomm_jneorigin(
	"jneoriginid" serial primary key not null,
	"cityid" integer references ecomm_city(cityid), 
	"cityjnecode" varchar(255),
	"branchcode" varchar(255)
);

CREATE TABLE ecomm_jnedestination(
	"jnedestinationid" serial primary key not null,
	"districtid" integer references ecomm_district(districtid),
	"districtjnecode" varchar(255)
);


CREATE TABLE ecomm_attributeoptions (
"optionsid" serial primary key not null,
"attributeid" integer references ecomm_attributes(attributeid),
"value" varchar(255)
);

CREATE TABLE ecomm_attributes (
"attributeid" serial primary key not null,
"code" varchar(100),
"name" varchar(255),
"type" varchar(255),
"isactive" bool,
"createdby" varchar(255),
"createddate" timestamp(6),
"lastmodifiedby" varchar(255),
"lastmodifieddate" timestamp(6)
);

CREATE TABLE ecomm_productattributes (
"productattributeid" serial primary key not null,
"productid" integer references ecomm_products,
"attributeid" integer references ecomm_attributes,
"value" varchar(255)
);

CREATE TABLE ecomm_setting (
"code" varchar(100),
"name" varchar(255),
"description" text,
"type" varchar(255),
"value" text,
primary key (code)
);

CREATE TABLE ecomm_shippingsetting(
	"shippingsettingid" serial primary key,
	"code" varchar(225),
	"name" varchar(225),
	"value" varchar(225),
	"shippingid" integer REFERENCES ecomm_shippings(shippingid)
);
CREATE TABLE ecomm_shippingpackage(
	"shippingpackageid" serial primary key,
	"code" varchar(225),
	"name" varchar(225),
	"isactive" boolean,
	"shippingid" integer REFERENCES ecomm_shippings(shippingid)
);

CREATE TABLE ecomm_role(
	"roleid" serial primary key,
	"name" varchar(225)
);
CREATE TABLE ecomm_menu(
	"menuid" serial primary key,
	"title" varchar(225),
	"target" varchar(225),
	"parentid" integer,
	"icon" varchar(225)
);
CREATE TABLE ecomm_rolemenu(
	"roleid" integer REFERENCES ecomm_role(roleid),
	"menuid" integer REFERENCES ecomm_menu(menuid)
);

CREATE TABLE ecomm_paymenttypesetting
(
	
	"paymentSettingId" serial,
    
	"code" varchar(32),
    
	"name" varchar(255),
    
	"value" text,
    
	"paymentId" int,
    
	"primary key" (paymentSettingId)

);
create table ecomm_productreview(
	reviewid serial primary key not null,
	customerid integer references ecomm_customers(customerid),
	productid integer references ecomm_products(productid),
	rating integer,
	review varchar(255),
	reviewtime timestamp(6)
);
