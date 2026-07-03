public enum Animal {
    CAT,
    DOG,
    HORSE,
    COW,
    NOT_DEFINED;

    public static boolean containsAnimal(String name) {
        try {
            Animal.valueOf(name);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

