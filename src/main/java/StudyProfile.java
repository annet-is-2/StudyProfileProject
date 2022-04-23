public enum StudyProfile {
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    ECONOMICS("Экономика"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика");

    public final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
