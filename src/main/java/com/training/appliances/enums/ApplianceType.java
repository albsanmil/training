package com.training.appliances.enums;

public enum ApplianceType {

    FRIDGE("Fridge"),
    DISHWASHER("Dishwasher"),
    WASHING_MACHINE("Washing machine");

    private String type;

    ApplianceType(String type) {
        this.type = type;
    }

    public static ApplianceType fromType(String type) {
        for (ApplianceType applianceType : values()) {
            if (applianceType.type.equals(type)) {
                return applianceType;
            }
        }

        throw new IllegalArgumentException("'" + type + "' is not a valid appliance type");
    }
}
