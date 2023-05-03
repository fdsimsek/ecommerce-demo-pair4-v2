package com.etiya.ecommercedemopair4.business.constants;

public class Messages {
    public static class Category {
        public static final String CategoryExists = "categoryExists";
        public static final String CategoryDoesNotExistsWithGivenId = "categoryDoesNotExistsWithGivenId";
        public static final String CategoryAdded = "categoryAdded";
        public static final String CategoryUpdated = "categoryUpdated";
    }

    public static class Product {
        public static final String ProductAdded = "productAdded";
        public static final String ProductUpdated = "productUpdated";
    }

    public static class Country {
        public static final String CountryAdded = "countryAdded";
        public static final String CountryExists = "countryExists";
        public static final String CountryDoesNotExistsWithGivenId = "countryDoesNotExistsWithGivenId";
    }

    public static class Order {
        public static final String OrderTaken = "orderTaken";

        public static final String OrderUpdated = "orderUpdated";
    }

    public static class Address {
        public static final String AddressListed = "addressListed";
        public static final String AddressAdded = "addressAdded";
        public static final String AddressUpdated = "addressUpdated";
    }

    public static class OrderStatus {
        public static final String OrderStatusAdded = "orderStatusAdded";
    }

    public static class ParentCategory {
        public static final String ParentCategoryAdded = "parentCategoryAdded";
    }

    public static class ShippingMethod {
        public static final String ShippingMethodAdded = "shippingMethodAdded";
    }

    public static class Customer {
        public static final String CustomerDoesNotExistsWithGivenId = "customerDoesNotExistsWithGivenId";
    }
}
