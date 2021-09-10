CREATE DATABASE IF NOT EXISTS restaurant;

USE restaurant;

DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS menu_items;

CREATE TABLE restaurants
(
    restaurant_id bigint NOT NULL,
    restaurant_name varchar(32) NOT NULL,
    PRIMARY KEY (restaurant_id)
);

CREATE TABLE menu_items
(
    restaurant_restaurant_id bigint NOT NULL,
    menu_item_id bigint NOT NULL,
    menu_item_name varchar(32) NOT NULL,
    price bigint NOT NULL
);