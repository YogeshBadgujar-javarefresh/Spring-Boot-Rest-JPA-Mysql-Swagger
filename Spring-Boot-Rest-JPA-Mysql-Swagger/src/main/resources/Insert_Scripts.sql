-- phone_details
INSERT INTO `custsupplier`.`phone_details` (`id`, `version`, `area_code`, `number`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('1', '1', '411027', '9890202927', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');
INSERT INTO `custsupplier`.`phone_details` (`id`, `version`, `area_code`, `number`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('2', '1', '411026', '7709172777', 'Sachin', '15-06-2020', 'Sachin', '15-06-2020', '1');
INSERT INTO `custsupplier`.`phone_details` (`id`, `version`, `area_code`, `number`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('3', '1', '411001', '8888999925', 'Ram', '15-06-2020', 'Ram', '15-06-2020', '1');
INSERT INTO `custsupplier`.`phone_details` (`id`, `version`, `area_code`, `number`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('4', '1', '411009', '5625897892', 'Seeta', '15-06-2020', 'Seeta', '15-06-2020', '1');

-- Person
INSERT INTO `custsupplier`.`person` (`id`, `version`, `first_name`, `last_name`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('1', '1', 'Yogesh', 'Badgujar', '1', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');
INSERT INTO `custsupplier`.`person` (`id`, `version`, `first_name`, `last_name`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('2', '1', 'Ram', 'Kumar', '2', 'Ram', '15-06-2020', 'Ram', '15-06-2020', '1');
INSERT INTO `custsupplier`.`person` (`id`, `version`, `first_name`, `last_name`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('3', '1', 'John', 'Patil', '3', 'John', '15-06-2020', 'John', '15-06-2020', '1');

-- Company
INSERT INTO `custsupplier`.`company` (`id`, `version`, `name`, `registration_number`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('1', '1', 'MCB Core Infotech', 'ABCD-2015', '3', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');
INSERT INTO `custsupplier`.`company` (`id`, `version`, `name`, `registration_number`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('2', '1', 'Paper soft technology', 'SOFT-2347', '4', 'Ram', '15-06-2020', 'Ram', '15-06-2020', '1');
INSERT INTO `custsupplier`.`company` (`id`, `version`, `name`, `registration_number`, `phone_details_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('3', '1', 'Java Technology', 'Java-007', '2', 'Geeta', '15-06-2020', 'Geeta', '15-06-2020', '1');

-- Customer
INSERT INTO `custsupplier`.`customer` (`id`, `version`, `customer_number`, `last_order_date`, `person_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('1', '1', '1001', '5-06-2020', '1', 'Ram', '15-06-2020', 'Ram', '15-06-2020', '1');
INSERT INTO `custsupplier`.`customer` (`id`, `version`, `customer_number`, `last_order_date`, `company_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('2', '1', '1002', '5-03-2020', '2', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');
INSERT INTO `custsupplier`.`customer` (`id`, `version`, `customer_number`, `last_order_date`, `person_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('3', '1', '1005', '5-05-2020', '3', 'Seeta', '15-06-2020', 'Seeta', '15-06-2020', '1');

-- Supplier
INSERT INTO `custsupplier`.`supplier` (`id`, `version`, `tax_number`, `order_lead_days`, `person_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('1', '1', '7898', '2', '2', 'Yogesh', '15-06-2020', 'Yogesh', '15-06-2020', '1');
INSERT INTO `custsupplier`.`supplier` (`id`, `version`, `tax_number`, `order_lead_days`, `company_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('2', '1', '9989', '5', '3', 'Seeta', '15-06-2020', 'Seeta', '15-06-2020', '1');
INSERT INTO `custsupplier`.`supplier` (`id`, `version`, `tax_number`, `order_lead_days`, `person_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('3', '1', '7822', '10', '2', 'Ram', '15-06-2020', 'Ram', '15-06-2020', '1');
INSERT INTO `custsupplier`.`supplier` (`id`, `version`, `tax_number`, `order_lead_days`, `company_id`, `created_by`, `created_date`, `modified_by`, `modified_date`, `active`) VALUES ('4', '1', '5511', '7', '1', 'Gopal', '15-06-2020', 'Gopal', '15-06-2020', '1');
