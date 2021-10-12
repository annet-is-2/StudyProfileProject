public enum StudyProfile {
    MEDICINE("Медицина"),
    MATHEMATICS("Математика"),
    ECONOMICS("Экономика");

    public final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
