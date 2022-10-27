package transport;

import java.time.LocalDate;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int productionYear;
    private final String assemblyCountry;
    private String transmission;
    private final String bodyType;
    private String regNumber;
    private final int seats;
    private boolean summerTyres;

    private Key key;

    public Insurance insurance;

    public static class Key {
        private final boolean remoteRunEngine;
        private final boolean withoutKeyAccess;

        public Key(boolean remoteRunEngine, boolean withoutKeyAccess) {
            this.remoteRunEngine = remoteRunEngine;
            this.withoutKeyAccess = withoutKeyAccess;
        }

        public Key() {
            this(false, false);
        }

        public boolean isRemoteRunEngine() {
            return remoteRunEngine;
        }

        public boolean isWithoutKeyAccess() {
            return withoutKeyAccess;
        }
    }

    public static class Insurance {
        private final LocalDate validity;
        private final double cost;
        private final String nubmer;

        public Insurance(LocalDate validity, double cost, String nubmer) {
            if (validity == null) {
                this.validity = LocalDate.now().plusDays(365);
            } else {
                this.validity = validity;
            }
            this.cost = cost;
            if (nubmer == null) {
                this.nubmer = "123456789";
            } else {
                this.nubmer = nubmer;
            }
        }

        public Insurance() {
            this(null, 10_000, null);
        }

        public LocalDate getValidity() {
            return validity;
        }

        public double getCost() {
            return cost;
        }

        public String getNubmer() {
            return nubmer;
        }

        public void checkValidityDate() {
            if (validity.isBefore(LocalDate.now()) || validity.isEqual(LocalDate.now())) {
                System.out.println("Нужно срочно ехать оформлять новую страховку");
            }
        }

        public void checkNumber() {
            if (nubmer.length() != 9) {
                System.out.println("Номер страховки некорректный");
            }
        }
    }

        public Car(String brand,
                   String model,
                   double engineVolume,
                   String color,
                   int productionYear,
                   String assemblyCountry,
                   String transmission,
                   String bodyType,
                   String regNumber,
                   int seats,
                   boolean summerTyres,
                   Key key,
                   Insurance insurance) {
            if (brand == null || brand.equals("")) {
                this.brand = "default";
            } else {
                this.brand = brand;
            }
            if (model == null || model.equals("")) {
                this.model = "default";
            } else {
                this.model = model;
            }
            if (assemblyCountry == null || assemblyCountry.equals("")) {
                this.assemblyCountry = "default";
            } else {
                this.assemblyCountry = assemblyCountry;
            }
            this.engineVolume = engineVolume;
            if (color == null || color.equals("")) {
                this.color = "белый";
            } else {
                this.color = color;
            }
            this.productionYear = productionYear;
            if (transmission == null || transmission.equals("")) {
                this.transmission = "МКПП";
            } else {
                this.transmission = transmission;
            }
            if (regNumber == null || regNumber.equals("")) {
                this.regNumber = "х000хх000";
            } else {
                this.regNumber = regNumber;
            }
            if (bodyType == null || bodyType.equals("")) {
                this.bodyType = "седан";
            } else {
                this.bodyType = bodyType;
            }
            if (key == null) {
                this.key = new Key();
            } else {
                this.key = key;
            }
            if (insurance == null) {
                this.insurance = new Insurance();
            } else {
                this.insurance = insurance;
            }
            this.seats = seats;
            this.summerTyres = summerTyres;
        }

        public Car(String brand,
                   String model,
                   double engineVolume,
                   String color,
                   int productionYear,
                   String assemblyCountry) {
            this(brand,
                    model,
                    engineVolume,
                    color,
                    productionYear,
                    assemblyCountry,
                    "МКПП",
                    "седан",
                    "х000хх000",
                    5,
                    true,
                    new Key(),
                    new Insurance());
        }

        public double getEngineVolume() {
            return engineVolume;
        }

        public void setEngineVolume(double engineVolume) {
            this.engineVolume = engineVolume;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getTransmission() {
            return transmission;
        }

        public void setTransmission(String transmission) {
            if (transmission == null || transmission.equals("")) {
                this.transmission = "МКПП";
            } else {
                this.transmission = transmission;
            }
        }

        public String getRegNumber() {
            return regNumber;
        }

        public void setRegNumber(String regNumber) {
            if (regNumber == null || regNumber.equals("")) {
                this.regNumber = "х000хх000";
            } else {
                this.regNumber = regNumber;
            }
        }

        public boolean isSummerTyres() {
            return summerTyres;
        }

        public void setSummerTyres(boolean summerTyres) {
            this.summerTyres = summerTyres;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public int getProductionYear() {
            return productionYear;
        }

        public String getAssemblyCountry() {
            return assemblyCountry;
        }

        public String getBodyType() {
            return bodyType;
        }

        public int getSeats() {
            return seats;
        }

        public void changeTyres() {
            summerTyres = !summerTyres;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public boolean isCorrectRegNumber() {
            if (regNumber.length() != 9) {
                return false;
            }
            char[] chars = regNumber.toCharArray();
            if (!Character.isAlphabetic(chars[0]) || !Character.isAlphabetic(chars[4]) || !Character.isAlphabetic(chars[5])) {
                return false;
            }
            if (!Character.isDigit(chars[1]) || !Character.isDigit(chars[2]) || !Character.isDigit(chars[3]) ||
                    !Character.isDigit(chars[6]) || !Character.isDigit(chars[7]) || !Character.isDigit(chars[8])) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Марка: " + brand +
                    "; Модель: " + model +
                    "; Год выпуска: " + productionYear +
                    "; Объем двигателя " + engineVolume +
                    " л.; Цвет: " + color +
                    "; Страна сборки: " + assemblyCountry +
                    "; Коробка передач: " + transmission +
                    "; Тип кузова: " + bodyType +
                    "; Регистрационный номер: " + regNumber +
                    "; Количество мест: " + seats +
                    "; Резина: " + (isSummerTyres() ? "летняя" : "зимняя") +
                    "; Доступ: " + (key.isWithoutKeyAccess() ? "безключевой" : "ключевой") +
                    "; Запуск: " + (key.isRemoteRunEngine() ? "удаленный" : "обычный") +
                    "; Номер страховки: " + (insurance.nubmer) +
                    "; Стоимость страховки: " + (insurance.cost) +
                    "; Срок действия страховки: " + (insurance.validity);
        }
    }
